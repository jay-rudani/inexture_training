package org.icc.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.icc.factory.FactoryProvider;
import org.icc.model.ConversionHistory;
import org.icc.service.ConversionService;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public double convert(String convertFrom, String convertTo, double amount) {
        double convertedValue = 0;

        String[] convertFromData = convertFrom.split("_");
        String convertFromFullName = convertFromData[0];
        String convertFromCountryCode = convertFromData[1];
        double convertFromRate = 1 / Double.parseDouble(convertFromData[2]);

        String[] convertToData = convertTo.split("_");
        String convertToFullName = convertToData[0];
        String convertToCountryCode = convertToData[1];
        double convertToRate = 1 / Double.parseDouble(convertToData[2]);

        double rate = convertFromRate / convertToRate;

        convertedValue = rate * amount;

        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ConversionHistory conversionHistory = new ConversionHistory();
        conversionHistory.setSourceCurrency(convertFromFullName + " (" + convertFromCountryCode + ")");
        conversionHistory.setTargetCurrency(convertToFullName + " (" + convertToCountryCode + ")");
        conversionHistory.setAmount(amount);
        conversionHistory.setConvertedAmount(convertedValue);
        conversionHistory.setExchangeRate(rate);
        conversionHistory.setConvertedAt(new Date());

        session.persist(conversionHistory);

        tx.commit();
        session.close();

        return convertedValue;
    }

    @Override
    public List<ConversionHistory> getHistory() {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query query = session.createQuery("From ConversionHistory");
        List<ConversionHistory> histories = query.getResultList();
        session.close();
        return histories;
    }
}
