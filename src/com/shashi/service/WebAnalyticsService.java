package com.shashi.service;

import java.util.List;

import com.shashi.beans.InteractionBean;

public interface WebAnalyticsService {

    String addInteraction(String userId, String prodId, int weight);
    
    String checkInteraction(String userId, String prodId);
    
    List<InteractionBean> getUserInteractions(String userId, int cutoff);
    
    List<String> getUserCategories(String userId, int cutoff);
    
    List<String> getUserStudentCategories(String userId, int cutoff);

}
