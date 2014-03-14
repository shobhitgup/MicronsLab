package com.tree.downloaded;

import java.awt.Color;

import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class TestCaseWelcomeArea extends JEditorPane {

    public TestCaseWelcomeArea() {
        setBackground(Color.decode("#FFFFFF"));
        setContentType("text/html");
        String htmlString = "<html>\n"
                + "<body>\n"
                + "<H1>Welcome Text</H1>"
                + "</body>\n";
        setText(htmlString);
    }
}
