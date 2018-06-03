package com.lucatode.funfactservice.domain.entity;

public class LogMessage {
    private final String source;
    private final String text;
    private final String level;
    private final String date;



    public LogMessage(String source, String text, String level, String date) {
        this.source = source;
        this.text = text;
        this.level = level;
        this.date = date;
    }

    public static final class LogMessageBuilder {
        private String source;
        private String text;
        private String level;
        private String date;

        public LogMessageBuilder() {
        }

        public static LogMessageBuilder aLogMessage() {
            return new LogMessageBuilder();
        }

        public LogMessageBuilder withSource(String source) {
            this.source = source;
            return this;
        }

        public LogMessageBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public LogMessageBuilder withLevel(String level) {
            this.level = level;
            return this;
        }

        public LogMessageBuilder withDate(String date) {
            this.date = date;
            return this;
        }

        public LogMessage build() {
            return new LogMessage(source, text, level, date);
        }
    }
}
