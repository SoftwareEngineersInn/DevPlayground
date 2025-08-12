package org.software.engineers.inn.design.patterns.creational.ok;

/**
 * This an example of a builder pattern inside an object
 */
public class Email {
    private final String to;
    private final String subject;
    private final String body;
    private final boolean isHtml;

    public Email(Builder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.body = builder.body;
        this.isHtml = builder.isHtml;
    }

    public static class Builder {
        private String to;
        private String subject;
        private String body;
        private boolean isHtml;

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder isHtml(boolean isHtml) {
            this.isHtml = isHtml;
            return this;
        }

        public Email build() {
            // here you can set your validations
            if (to == null || subject == null || body == null) {
                throw new IllegalStateException("Mandatory fields are missing");
            }
            return new Email(this);
        }
    }

    //Here you can declare optional getters
}
