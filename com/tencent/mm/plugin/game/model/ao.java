package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.s.d;
import com.tencent.mm.plugin.game.model.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class ao {
    private static String N(LinkedList<h> linkedList) {
        if (bi.cX(linkedList)) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                newSerializer.startTag(null, "userinfo");
                newSerializer.attribute(null, "jump_id", hVar.jNs);
                newSerializer.startTag(null, "username");
                try {
                    newSerializer.text(bi.aG(hVar.userName, ""));
                } catch (Exception e) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "username");
                newSerializer.startTag(null, "nickname");
                try {
                    newSerializer.text(bi.aG(hVar.bgn, ""));
                } catch (Exception e2) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "nickname");
                newSerializer.startTag(null, "usericon");
                try {
                    newSerializer.text(bi.aG(hVar.jNp, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, "profile");
                try {
                    newSerializer.text(bi.aG(hVar.jNq, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "profile");
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(bi.aG(hVar.jNr, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            }
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            return stringWriter.getBuffer().toString();
        } catch (Exception e6) {
            x.e("MicroMsg.GameXmlProcess", e6.getMessage());
            return "";
        }
    }

    private static String a(LinkedList<h> linkedList, HashMap<String, d> hashMap) {
        if (bi.cX(linkedList) || hashMap.isEmpty()) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                d dVar = (d) hashMap.get(hVar.jNs);
                if (dVar != null) {
                    newSerializer.startTag(null, "jump");
                    newSerializer.attribute(null, "id", hVar.jNs);
                    newSerializer.startTag(null, "jump_type");
                    try {
                        newSerializer.text(String.valueOf(dVar.jNj));
                    } catch (Exception e) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_type");
                    newSerializer.startTag(null, "jump_url");
                    try {
                        newSerializer.text(bi.aG(dVar.iCI, ""));
                    } catch (Exception e2) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_url");
                    newSerializer.endTag(null, "jump");
                }
            }
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            return stringWriter.getBuffer().toString();
        } catch (Exception e3) {
            x.e("MicroMsg.GameXmlProcess", e3.getMessage());
            return "";
        }
    }

    public static String a(String str, LinkedList<h> linkedList, HashMap<String, d> hashMap) {
        if (bi.oW(str) || bi.cX(linkedList)) {
            return str;
        }
        String N = N(linkedList);
        if (bi.oW(N)) {
            return str;
        }
        String a = a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, N);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || bi.oW(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameXmlProcess", e.getMessage());
            x.e("MicroMsg.GameXmlProcess", "xml is invalid : " + str);
        }
        return stringBuilder.toString();
    }
}
