package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static ArrayList<ta> zF(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<ta> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                Node item = elementsByTagName.item(i);
                ta taVar = new ta();
                String toLowerCase = item.getTextContent().toLowerCase();
                NamedNodeMap attributes = item.getAttributes();
                Node namedItem = attributes.getNamedItem("thumburl");
                if (namedItem != null) {
                    taVar.lPl = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("cdnurl");
                if (namedItem != null) {
                    taVar.jPK = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("productid");
                if (namedItem != null) {
                    taVar.rem = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("designerid");
                if (namedItem != null) {
                    taVar.rwl = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("aeskey");
                if (namedItem != null) {
                    taVar.rwn = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("encrypturl");
                if (namedItem != null) {
                    taVar.rwm = namedItem.getNodeValue();
                }
                item = attributes.getNamedItem("activityid");
                if (item != null) {
                    taVar.rwq = item.getNodeValue();
                }
                taVar.rwk = toLowerCase;
                arrayList.add(taVar);
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static ArrayList<String> zG(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("ProductID");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                arrayList.add(elementsByTagName.item(i).getTextContent());
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }
}
