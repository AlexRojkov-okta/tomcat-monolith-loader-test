package com.okta.pom.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DependenciesHandler extends DefaultHandler {

    enum State {
        dependencies,
        dependency,
        groupId,
        artifactId,
        scope,
        version
    }

    private Dependency.Builder builder;

    private StringBuilder text;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        State state = State.valueOf(localName);

        switch (state) {
            case groupId: {
                builder.setGroupId(text.toString());

                break;
            }
            case artifactId: {
                builder.setArtifactId(text.toString());

                break;
            }
            case scope: {
                builder.setScope(Scope.valueOf(text.toString()));

                break;
            }
            case version: {
                Version.newBuilder().setVersion(text.toString());

                break;
            }
        }
    }
}
