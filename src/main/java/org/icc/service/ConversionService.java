package org.icc.service;

import org.icc.model.ConversionHistory;

import java.util.List;

public interface ConversionService {

    public double convert(String convertedFrom, String convertedTo, double amount);

    public List<ConversionHistory> getHistory();
}
