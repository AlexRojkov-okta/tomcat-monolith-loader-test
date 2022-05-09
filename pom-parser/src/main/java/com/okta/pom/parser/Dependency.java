package com.okta.pom.parser;

public class Dependency {
    private final String artifactId;
    private final String groupId;
    private final Scope scope;
    private final Version version;

    public Dependency(String artifactId, String groupId, Scope scope, Version version) {
        this.artifactId = artifactId;
        this.groupId = groupId;
        this.scope = scope;
        this.version = version;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public Scope getScope() {
        return scope;
    }

    public Version getVersion() {
        return version;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String artifactId;
        private String groupId;
        private Scope scope;
        private Version version;

        private Builder() {

        }

        public Builder setArtifactId(String artifactId) {
            this.artifactId = artifactId;
            return this;
        }

        public Builder setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder setScope(Scope scope) {
            this.scope = scope;
            return this;
        }

        public Builder setVersion(Version version) {
            this.version = version;
            return this;
        }

        public Dependency createArtifact() {
            return new Dependency(artifactId, groupId, scope, version);
        }
    }
}
