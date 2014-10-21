package com.quanken.model

class Chat {
    String personName
    String content
    Date time

    @Override
    public String toString() {
        return "Chat{" +
                "personName='" + personName + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}