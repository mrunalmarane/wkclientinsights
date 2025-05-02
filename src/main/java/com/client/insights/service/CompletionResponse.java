package com.client.insights.service;

public class CompletionResponse {


    private String id;
    private String object;
    private int created;
    private String model;
    private Choice[] choices;

    public static class Choice {
        private String text;
        private int index;
        private String logprobs;
        private String finish_reason;

        // Getters and Setters
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Choice[] getChoices() {
        return choices;
    }

    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }
}

    // Getters and Setters
