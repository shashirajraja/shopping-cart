package com.shashi.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InteractionBean implements Serializable{

    public InteractionBean() {
    }

    private String username;
    private String prodId;
    private int interactionCount;

    public InteractionBean(String username, String prodId, int interactionCount) {
        this.username = username;
        this.prodId = prodId;
        this.interactionCount = interactionCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public int getInteractionCount() {
        return interactionCount;
    }

    public void setInteractionCount(int interactionCount) {
        this.interactionCount = interactionCount;
    }
}
