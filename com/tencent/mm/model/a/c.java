package com.tencent.mm.model.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c {
    b dDN = null;
    b dDO = null;

    final void iQ(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            return;
        }
        x.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", new Object[]{str});
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < elementsByTagName.getLength()) {
                        b bVar = new b();
                        NodeList childNodes = elementsByTagName.item(i2).getChildNodes();
                        int length = childNodes.getLength();
                        for (i = 0; i < length; i++) {
                            Node item = childNodes.item(i);
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                                NamedNodeMap attributes = item.getAttributes();
                                e eVar = new e();
                                if (attributes != null) {
                                    Node namedItem = attributes.getNamedItem("id");
                                    if (namedItem != null) {
                                        x.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", new Object[]{namedItem.getNodeValue()});
                                        eVar.id = r9;
                                    }
                                    Node namedItem2 = attributes.getNamedItem("reportid");
                                    if (namedItem2 != null) {
                                        x.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", new Object[]{namedItem2.getNodeValue()});
                                        eVar.dDP = r7;
                                    }
                                }
                                x.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", new Object[]{item.getTextContent()});
                                eVar.value = r6;
                                bVar.dDM.put(eVar.id, eVar);
                            } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("verifymd5")) {
                                if (item != null) {
                                    if (item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                                        x.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", new Object[]{item.getTextContent()});
                                        bVar.dDJ = r6;
                                    }
                                }
                                if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                                    x.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", new Object[]{item.getTextContent()});
                                    bVar.dDK = r6;
                                } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                                    x.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", new Object[]{item.getTextContent()});
                                    bVar.dDL = r6;
                                }
                            } else {
                                x.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", new Object[]{item.getTextContent()});
                                bVar.dDI = r6;
                            }
                        }
                        if (bi.oW(bVar.dDJ) || !"0".equals(bVar.dDJ)) {
                            this.dDN = bVar;
                        } else {
                            this.dDO = bVar;
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public final boolean IU() {
        if (this.dDN == null) {
            return false;
        }
        return true;
    }

    public final e iP(String str) {
        e eVar = null;
        if (this.dDN != null) {
            eVar = this.dDN.iP(str);
        }
        if (eVar != null || this.dDO == null) {
            return eVar;
        }
        return this.dDO.iP(str);
    }
}
