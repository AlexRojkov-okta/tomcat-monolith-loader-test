package com.okta.pom.parser;

public interface Artifact {
    String groupId();

    String artifactId();

    Version version();
}
