package com.demo.springbootrabbitmqexample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomMessage {

    private String text;
    private final int priority;

    public CustomMessage(@JsonProperty("text") final String text,
                         @JsonProperty("priority") final int priority) {
        this.text = text;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                '}';
    }
}
