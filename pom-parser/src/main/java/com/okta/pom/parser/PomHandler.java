package com.okta.pom.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

/**
 * <dependencies>
 * <dependency>
 * <groupId>javax.servlet</groupId>
 * <artifactId>javax.servlet-api</artifactId>
 * <version>3.1.0</version>
 * <scope>provided</scope>
 * </dependency>
 * </dependencies>
 */
class PomHandler extends DefaultHandler {

    enum State {
        dependency,
        groupId,
        artifactId,
        scope,
        version
    }


    private State state;
    private StringBuilder text;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        State newState = State.valueOf(localName);

        state = newState;

        text = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
