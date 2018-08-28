package com.tencent.mm.plugin.scanner.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.scanner.a.o.a;
import com.tencent.mm.plugin.scanner.a.o.b;
import com.tencent.mm.plugin.scanner.a.o.c;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class p {
    private o mGG = new o();

    public final void KH(String str) {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    o.mGG = this.mGG;
                    break;
                case 2:
                    str2 = newPullParser.getName();
                    if (!str2.equals("name")) {
                        if (!str2.equals("address")) {
                            if (!str2.equals("deliveryAddress")) {
                                if (!str2.equals("homeAddress")) {
                                    if (!str2.equals("workAddress")) {
                                        if (!str2.equals("photo")) {
                                            if (!str2.equals("logo")) {
                                                if (!str2.equals("sound")) {
                                                    break;
                                                }
                                                this.mGG.mGs = c(newPullParser);
                                                break;
                                            }
                                            this.mGG.mGr = c(newPullParser);
                                            break;
                                        }
                                        this.mGG.mGq = c(newPullParser);
                                        break;
                                    }
                                    this.mGG.mGx = b(newPullParser);
                                    break;
                                }
                                this.mGG.mGw = b(newPullParser);
                                break;
                            }
                            this.mGG.mGv = b(newPullParser);
                            break;
                        }
                        this.mGG.mGu = b(newPullParser);
                        break;
                    }
                    this.mGG.mGp = new b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    o oVar;
                                    if (!str2.equals("mobilePhoneNumber")) {
                                        if (!str2.equals("homePhoneNumber")) {
                                            if (!str2.equals("workPhoneNumber")) {
                                                if (!str2.equals("telAVPhoneNumber")) {
                                                    if (!str2.equals("phoneNumber")) {
                                                        if (!str2.equals("email")) {
                                                            if (!str2.equals(SlookSmartClipMetaTag.TAG_TYPE_TITLE)) {
                                                                if (!str2.equals("role")) {
                                                                    if (!str2.equals("agent")) {
                                                                        if (!str2.equals("note")) {
                                                                            if (!str2.equals(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
                                                                                if (!str2.equals("organization")) {
                                                                                    break;
                                                                                }
                                                                                this.mGG.fkz = text;
                                                                                break;
                                                                            }
                                                                            this.mGG.url = text;
                                                                            break;
                                                                        }
                                                                        this.mGG.mGF = text;
                                                                        break;
                                                                    }
                                                                    this.mGG.mGE = text;
                                                                    break;
                                                                }
                                                                this.mGG.mGD = text;
                                                                break;
                                                            }
                                                            this.mGG.title = text;
                                                            break;
                                                        }
                                                        this.mGG.csD = text;
                                                        break;
                                                    }
                                                    oVar = this.mGG;
                                                    if (oVar.mGC == null) {
                                                        oVar.mGC = new ArrayList();
                                                    }
                                                    if (!(text == null || oVar.mGC.contains(text))) {
                                                        oVar.mGC.add(text);
                                                        break;
                                                    }
                                                }
                                                oVar = this.mGG;
                                                if (oVar.mGB == null) {
                                                    oVar.mGB = new ArrayList();
                                                }
                                                if (!(text == null || oVar.mGB.contains(text))) {
                                                    oVar.mGB.add(text);
                                                    break;
                                                }
                                            }
                                            oVar = this.mGG;
                                            if (oVar.mGA == null) {
                                                oVar.mGA = new ArrayList();
                                            }
                                            if (!(text == null || oVar.mGA.contains(text))) {
                                                oVar.mGA.add(text);
                                                break;
                                            }
                                        }
                                        oVar = this.mGG;
                                        if (oVar.mGz == null) {
                                            oVar.mGz = new ArrayList();
                                        }
                                        if (!(text == null || oVar.mGz.contains(text))) {
                                            oVar.mGz.add(text);
                                            break;
                                        }
                                    }
                                    oVar = this.mGG;
                                    if (oVar.mGy == null) {
                                        oVar.mGy = new ArrayList();
                                    }
                                    if (!(text == null || oVar.mGy.contains(text))) {
                                        oVar.mGy.add(text);
                                        break;
                                    }
                                }
                                this.mGG.mGt = text;
                                break;
                            }
                            this.mGG.fkq = text;
                            break;
                        }
                        this.mGG.bgn = text;
                        break;
                    }
                default:
                    break;
            }
        }
        o.mGG = this.mGG;
    }

    private static a b(XmlPullParser xmlPullParser) {
        return new a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, "locality"), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, "country"));
    }

    private static c c(XmlPullParser xmlPullParser) {
        return new c(xmlPullParser.getAttributeValue(null, "type"), xmlPullParser.getAttributeValue(null, "buffer"));
    }
}
