package org.icc.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.icc.model.ConversionHistory;
import org.icc.service.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public double convert(String convertFrom, String convertTo, double amount) {
        double convertedValue = 0;
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

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

        Session session = factory.openSession();
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
        factory.close();

        return convertedValue;
    }
}
