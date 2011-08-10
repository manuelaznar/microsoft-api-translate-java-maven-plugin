package com.neodoo.maven.plugin;


import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import com.neodoo.util.OrderedProperties;
import java.io.IOException;

public class EventProcessor {
    static int callsToGoogle=0;
    static int maxCalls=100;
    static int pauseMs=5000;
    Boolean debug;
    String sourceLanguage;
    String destLanguage;
    String key;
    OrderedProperties properties;

    // <REV 1.3; RSavage> modified constructor to accept property
    //                    key name string and 'OrderedProperties'
    //                    parameters instead of 'writer'
    public EventProcessor(String apiKey, Boolean debug, String sourceLanguage,
            String destLanguage, String key, OrderedProperties properties) {
        //Set referrer
        Translate.setHttpReferrer("http://localhost");
        Translate.setKey(apiKey);        
        this.debug = debug;
        this.sourceLanguage = sourceLanguage;
        this.destLanguage = destLanguage;
        this.key = key;
        this.properties = properties;
    }

    public void foundMarkup(String markup) throws IOException {
        // if (debug) {
        // System.out.println("markup0:[" + markup + "]");
        // }

        // <REV 1.3; RSavage> we no longer need to escape the line feed,
        //                    as the 'OrderedProperties' class should take
        //                    case of all character escaping
        //markup = markup.replaceAll("\n", "\\\\n");
        //writer.write(markup);

        // !! POSSIBLE BUG !! - now that the code has been converted over
        //                      to using the 'OrderedProperties' to write
        //                      to translated property files, we no longer
        //                      have control over managing multi-line
        //                      property values, the current implementation
        //                      just writes the entire property value to a
        //                      single line.
        //if (markup.equalsIgnoreCase("<br>")) {
        //    writer.write("\\\r\n");

        // set named property value;
        // append to any existing value in the property
        String currentValue = properties.getProperty(key,"");
        properties.setProperty(key, currentValue + markup);
    }

    public void foundContent(String content) throws IOException {
        if (debug) {
            System.out.println("\n[" + content + "]BEFORE");
        }
        String translatedText = content;
        try {
            if (content.trim().length() > 0) {
                // extract whitespace from start
                String prefix = stripFront(content);
                // extract whitespace from end
                String suffix = stripEnd(content);
                content = content.trim();
                if (++callsToGoogle % maxCalls==0){
                   System.out.print("\r pauzing "+pauseMs/1000+" seconds every "+maxCalls+" calls to google");
                   Thread.sleep(pauseMs);
                   System.out.print("\r resuming...");
                }
                translatedText = Translate.execute(content, Language.fromString(sourceLanguage), Language.fromString(destLanguage));
                translatedText = (new StringBuilder()).append(prefix).append(translatedText).append(suffix).toString();
            }
        } catch (Exception e) {
            System.out.println("ERROR src:[" + content + "] srcLang:"
                    + sourceLanguage + " dstLang:" + destLanguage + " err:"
                    + e.getMessage());
        }
        if(debug.booleanValue()) {
        	System.out.println((new StringBuilder()).append("[").append(translatedText).append("]").toString());
        }

        // <REV 1.3; RSavage> no longer are writing directly to the file
        //                    instead using the 'OrderedProperties' class
        //                    to write out the property file.
        //writer.write(translatedText);
        String currentValue = properties.getProperty(key,"");
        properties.setProperty(key, currentValue + translatedText);
    }

    // Return the whitespace from the front of a string
    private String stripFront(String s) {
        int len = s.length();
        int st = 0;
        char[] val = s.toCharArray();
        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }
        return (st > 0) ? s.substring(0, st) : "";
    }

    // Return the whitespace from the end of a string
    private String stripEnd(String s) {
        int len = s.length();
        int c = 0;
        char[] val = s.toCharArray();
        while (len > 0 && val[len - 1] <= ' ') {
            len--;
            c++;
        }
        return (c > 0) ? s.substring(s.length() - c) : "";
    }

}
