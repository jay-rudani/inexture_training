package org.icc.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icc.factory.FactoryProvider;
import org.icc.model.ConversionHistory;
import org.icc.model.ConversionResult;
import org.icc.service.ConversionService;
import org.icc.utility.ConvertFromToName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final String apiKey = "1d18149ae8a2140ef318dbc2";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ConversionHistory convert(String convertFrom, String convertTo, double amount) throws JsonProcessingException {

        String conversionUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + convertFrom + "/" + convertTo + "/" + amount;
        String supportedCodesUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/codes";
        String json = restTemplate.getForObject(conversionUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        ConversionResult conversionResult = mapper.readValue(json, ConversionResult.class);

        ResponseEntity<String> response = restTemplate.getForEntity(supportedCodesUrl, String.class);
        String convertFromName = ConvertFromToName.getName(response, convertFrom);
        String convertToName = ConvertFromToName.getName(response, convertTo);

        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ConversionHistory conversionHistory = new ConversionHistory();
        conversionHistory.setSourceCurrency(convertFromName + " (" + convertFrom + ")");
        conversionHistory.setTargetCurrency(convertToName + " (" + convertTo + ")");
        conversionHistory.setAmount(amount);
        conversionHistory.setConvertedAmount(conversionResult.getConversion_result());
        conversionHistory.setExchangeRate(conversionResult.getConversion_rate());
        conversionHistory.setConvertedAt(new Date());

        session.persist(conversionHistory);

        tx.commit();
        session.close();

        return conversionHistory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ConversionHistory> getConversionHistory(String keyword, Integer start, Integer entries) {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query query;
        List<ConversionHistory> conversionHistories;
        String hqlQuery;

        if (keyword != null && !keyword.isEmpty()) {
            hqlQuery = "From ConversionHistory Where " +
                    "sourceCurrency Like '%" + keyword + "%' or " +
                    "targetCurrency Like '%" + keyword + "%' or " +
                    "amount Like '%" + keyword + "%' or " +
                    "exchangeRate Like '%" + keyword + "%' or " +
                    "convertedAmount Like '%" + keyword + "%' or " +
                    "convertedAt Like '%" + keyword + "%' Order By id DESC";
        } else {
            hqlQuery = "From ConversionHistory Order By id DESC";
        }

        query = session.createQuery(hqlQuery);
        query.setFirstResult(start);
        query.setMaxResults(entries);
        conversionHistories = query.getResultList();
        session.close();
        return conversionHistories;
    }

    @Override
    public long getCount(String keyword) {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query query;
        int size;
        String hqlQuery;

        if (keyword != null && !keyword.isEmpty()) {
            hqlQuery = "From ConversionHistory Where " +
                    "sourceCurrency Like '%" + keyword + "%' or " +
                    "targetCurrency Like '%" + keyword + "%' or " +
                    "amount Like '%" + keyword + "%' or " +
                    "exchangeRate Like '%" + keyword + "%' or " +
                    "convertedAmount Like '%" + keyword + "%' or " +
                    "convertedAt Like '%" + keyword + "%'";
        } else {
            hqlQuery = "From ConversionHistory";
        }

        query = session.createQuery(hqlQuery);
        size = query.getResultList().size();
        session.close();
        return size;
    }
}
