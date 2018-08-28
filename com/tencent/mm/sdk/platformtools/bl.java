package com.tencent.mm.sdk.platformtools;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bl {
    private static ThreadLocal<XmlPullParser> sJK = new ThreadLocal();

    private static class a {
        private XmlPullParser sJL;
        private String sJM;
        private StringBuilder sJN = new StringBuilder();
        private Map<String, String> sJO;
        private Map<Integer, Integer> sJP;

        public a(String str, String str2) {
            this.sJM = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) bl.sJK.get();
            this.sJL = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal cjk = bl.sJK;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.sJL = newPullParser;
                cjk.set(newPullParser);
            }
            this.sJL.setInput(new StringReader(str));
            this.sJP = new HashMap();
            this.sJO = new HashMap();
        }

        public final Map<String, String> cjl() {
            int eventType = this.sJL.getEventType();
            while (eventType != 1) {
                int next = this.sJL.next();
                String str;
                if (next == 2) {
                    this.sJN.append('.').append(this.sJL.getName());
                    String stringBuilder = this.sJN.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) this.sJP.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        this.sJN.append(num);
                        this.sJP.put(Integer.valueOf(hashCode), num);
                        str = stringBuilder + num;
                    } else {
                        this.sJP.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                        str = stringBuilder;
                    }
                    this.sJO.put(str, "");
                    for (int i = 0; i < this.sJL.getAttributeCount(); i++) {
                        this.sJO.put(str + ".$" + this.sJL.getAttributeName(i), this.sJL.getAttributeValue(i));
                    }
                    eventType = next;
                } else if (next == 4) {
                    str = this.sJL.getText();
                    if (str != null) {
                        this.sJO.put(this.sJN.toString(), str);
                    }
                    eventType = next;
                } else {
                    if (next == 3) {
                        this.sJN = this.sJN.delete(this.sJN.lastIndexOf("."), this.sJN.length());
                        if (this.sJN.length() == 0) {
                            break;
                        }
                    }
                    eventType = next;
                }
            }
            return this.sJO;
        }
    }

    public static Map<String, String> z(String str, String str2) {
        Map<String, String> map = null;
        int indexOf = str == null ? -1 : str.indexOf("<" + str2);
        if (indexOf < 0) {
            x.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
            return map;
        }
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        try {
            return new a(str, str2).cjl();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            return map;
        }
    }

    public static String b(Node node) {
        Writer stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            x.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", e.getMessage());
        }
        return stringWriter.toString();
    }
}
