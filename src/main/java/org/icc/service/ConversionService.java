package org.icc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.icc.model.ConversionHistory;

import java.util.List;

public interface ConversionService {

    ConversionHistory convert(String convertedFrom, String convertedTo, double amount) throws JsonProcessingException;

    List<ConversionHistory> getHistory();
}
