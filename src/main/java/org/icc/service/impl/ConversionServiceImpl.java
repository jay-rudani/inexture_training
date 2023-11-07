package org.icc.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icc.exception.InvalidAmountFormatException;
import org.icc.exception.InvalidCurrencyCodeException;
import org.icc.exception.SameCurrencyCodeException;
import org.icc.exception.UnknownCurrencyCodeException;
import org.icc.factory.FactoryProvider;
import org.icc.model.ConversionError;
import org.icc.model.ConversionHistory;
import org.icc.model.ConversionResult;
import org.icc.service.ConversionService;
import org.icc.utility.ConvertFromToName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.NestedServletException;

import javax.persistence.Query;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
@PropertySource(value = {"classpath:currency-conversion-api.properties"})
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${currency.api.url}")
    private String apiUrl;

    private static final String REGEX_FOR_CURRENCY_CODE = "^[A-Z]{3}$";

    private static final String REGEX_FOR_AMOUNT = "^[1-9]+[0-9]*(\\.?[0-9]+)?$";

    private static final String REGEX_FOR_AMOUNT_DECIMAL_START_FROM_0 = "^[0]+?\\.?[0-9]+$";

    private static final String REGEX_FOR_INTEGER = "^[1-9]+[0-9]*$";

    @Override
    public ConversionHistory convert(String convertFrom, String convertTo, double amount) throws JsonProcessingException {

        if (convertTo.equals(convertFrom)) {
            throw new SameCurrencyCodeException(convertFrom, convertTo);
        }

        if (!Pattern.matches(REGEX_FOR_CURRENCY_CODE, convertFrom) || !Pattern.matches(REGEX_FOR_CURRENCY_CODE, convertTo)) {
            throw new InvalidCurrencyCodeException(convertFrom, convertTo);
        }

        if ((!Pattern.matches(REGEX_FOR_AMOUNT, String.valueOf(amount)) && !Pattern.matches(REGEX_FOR_AMOUNT_DECIMAL_START_FROM_0, String.valueOf(amount))) || amount == 0) {
            throw new InvalidAmountFormatException();
        }

        String conversionUrl = apiUrl + "/pair/" + convertFrom + "/" + convertTo + "/" + amount;
        String supportedCodesUrl = apiUrl + "/codes";
        Session session = FactoryProvider.getSessionFactory().openSession();
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = restTemplate.getForObject(conversionUrl, String.class);
            ConversionResult conversionResult = mapper.readValue(json, ConversionResult.class);
            ResponseEntity<String> response = restTemplate.getForEntity(supportedCodesUrl, String.class);
            String convertFromName = ConvertFromToName.getName(response, convertFrom);
            String convertToName = ConvertFromToName.getName(response, convertTo);

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
            return conversionHistory;
        } catch (HttpClientErrorException e) {
            ConversionError conversionError = mapper.readValue(e.getResponseBodyAsString(), ConversionError.class);
            throw new UnknownCurrencyCodeException(conversionError.getResult(), conversionError.getError_type());
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ConversionHistory> getConversionHistory(String keyword, Integer start, Integer entries) {

        if (Pattern.matches(REGEX_FOR_INTEGER, String.valueOf(start)) || Pattern.matches(REGEX_FOR_INTEGER, String.valueOf(entries))) {
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
        return null;
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
