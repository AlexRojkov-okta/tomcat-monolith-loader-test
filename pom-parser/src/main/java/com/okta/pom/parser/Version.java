package com.okta.pom.parser;

public class Version {

    public static Builder newBuilder() {
        return new Builder();
    }

    static class Builder {
        public Builder() {
        }

        public void setVersion(String version) {

        }

        Version build() {
            return new Version();
        }
    }
}
