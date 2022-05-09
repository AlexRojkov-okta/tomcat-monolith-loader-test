package com.okta.pom.parser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parser {

    private final SAXParserFactory parsers;

    private final Charset charset = Charset.forName("UTF-8");

    public Parser() {
        parsers = SAXParserFactory.newInstance();
    }

    private void parse(Path pom) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = parsers.newSAXParser();

        try (Reader in = Files.newBufferedReader(pom, charset)) {
            parser.parse(new InputSource(in), new PomHandler());
        }


    }

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(args[0]);

        Parser parser = new Parser();

        parser.parse(path);
    }

}
