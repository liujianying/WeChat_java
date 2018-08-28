package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class ab<T extends aa> extends n {
    a<T> aHd;

    public ab(q qVar, a<T> aVar) {
        super(qVar);
        this.aHd = aVar;
    }

    private T a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    Object attributeValue;
                    Object trim;
                    if (toLowerCase.equals("screenname")) {
                        CharSequence attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        CharSequence trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2)) {
                            TextUtils.isEmpty(trim2);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim3 == null)) {
                            this.aHd.m(attributeValue, trim3);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.aHd.g(attributeValue, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                c("Error parsing bool configuration value", trim, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.aHd.k(attributeValue, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                c("Error parsing int configuration value", trim, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            g("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            g("Error parsing tracker configuration file", e4);
        }
        return this.aHd.nS();
    }

    public final T dg(int i) {
        try {
            return a(this.aFn.aFU.getResources().getXml(i));
        } catch (NotFoundException e) {
            f("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
