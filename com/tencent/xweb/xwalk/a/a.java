package com.tencent.xweb.xwalk.a;

import com.tencent.xweb.util.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xwalk.core.XWalkInitializer;

public final class a {

    public static class a {
        public String vFk;
        public String vFl;
        public c[] vFm;
        public com.tencent.xweb.c.a.a[] vFn;
    }

    public static class b {
        public boolean bUseCdn;
        public String vFk;
        public int vFo;
        public String vFp;
        public boolean vFq;
    }

    static String f(File file, int i) {
        try {
            byte[] bArr = new byte[i];
            int read = new FileInputStream(file).read(bArr, 0, bArr.length);
            if (read != bArr.length) {
                return null;
            }
            String str = new String(bArr, 0, read);
            int indexOf = str.indexOf("<Versions>");
            if (indexOf < 0) {
                return null;
            }
            bArr = MessageDigest.getInstance("MD5").digest(str.substring(indexOf).getBytes());
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(bArr.length);
            for (byte b : bArr) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    private static int a(Element element, String str) {
        if (element == null) {
            return 0;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(attribute);
    }

    private static boolean b(Element element, String str) {
        if (element == null) {
            return false;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            return false;
        }
        return Boolean.parseBoolean(attribute);
    }

    private static b[] a(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            return null;
        }
        b[] bVarArr = new b[elementsByTagName.getLength()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= elementsByTagName.getLength()) {
                return bVarArr;
            }
            b bVar = new b();
            Element element2 = (Element) elementsByTagName.item(i2);
            bVar.vFp = element2.getAttribute("url");
            bVar.vFo = a(element2, "targetVersion");
            bVar.vFk = element2.getAttribute("md5");
            bVar.vFq = b(element2, "useCellular");
            bVar.bUseCdn = b(element2, "useCdn");
            bVarArr[i2] = bVar;
            i = i2 + 1;
        }
    }

    private static void a(a aVar, Element element) {
        if (element != null) {
            try {
                NodeList elementsByTagName = element.getElementsByTagName("command");
                if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                    aVar.vFn = new com.tencent.xweb.c.a.a[elementsByTagName.getLength()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < elementsByTagName.getLength()) {
                            com.tencent.xweb.c.a.a aVar2 = new com.tencent.xweb.c.a.a();
                            Element element2 = (Element) elementsByTagName.item(i2);
                            aVar2.vCo.vCu = a(element2, "apkMin");
                            aVar2.vCo.vCv = a(element2, "apkMax");
                            aVar2.vCo.vCs = a(element2, "sdkMin");
                            aVar2.vCo.vCt = a(element2, "sdkMax");
                            aVar2.vCo.vCw = a(element2, "apiMin");
                            aVar2.vCo.vCx = a(element2, "apiMax");
                            aVar2.vCo.vCy = element2.getAttribute("forbidDeviceRegex");
                            aVar2.vCo.vCz = a(element2, "grayMin");
                            aVar2.vCo.vCA = a(element2, "grayMax");
                            aVar2.vCp = element2.getAttribute("optype");
                            aVar2.vCq = element2.getAttribute("opvalue");
                            aVar2.vCr = element2.getAttribute("module");
                            aVar.vFn[i2] = aVar2;
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static a i(File file, String str) {
        a aVar = null;
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream fileInputStream = new FileInputStream(file);
            a aVar2 = new a();
            try {
                Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                if (documentElement == null) {
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    return null;
                }
                aVar2.vFk = documentElement.getAttribute("checkvalue");
                if (aVar2.vFk == null || !aVar2.vFk.equalsIgnoreCase(str)) {
                    e.gY(34);
                    XWalkInitializer.addXWalkInitializeLog("parse config failed , md5 not match");
                    return null;
                }
                aVar2.vFl = documentElement.getAttribute("configVer");
                a(aVar2, documentElement);
                NodeList elementsByTagName = documentElement.getElementsByTagName("VersionInfo");
                if (!(elementsByTagName == null || elementsByTagName.getLength() == 0)) {
                    aVar2.vFm = new c[elementsByTagName.getLength()];
                    for (int i = 0; i < elementsByTagName.getLength(); i++) {
                        c cVar = new c();
                        Element element = (Element) elementsByTagName.item(i);
                        cVar.vFp = element.getAttribute("fullurl");
                        cVar.vFk = element.getAttribute("md5");
                        cVar.vCo.vCy = element.getAttribute("forbidDeviceRegex");
                        cVar.vCo.vCs = a(element, "sdkMin");
                        cVar.vCo.vCt = a(element, "sdkMax");
                        cVar.vCo.vCw = a(element, "apiMin");
                        cVar.vCo.vCx = a(element, "apiMax");
                        cVar.vFs = a(element, "period");
                        cVar.vFr = a(element, "version");
                        cVar.vFq = b(element, "useCellular");
                        cVar.vCo.vCz = a(element, "grayMin");
                        cVar.vCo.vCA = a(element, "grayMax");
                        cVar.bUseCdn = b(element, "useCdn");
                        d dVar = cVar.vFu;
                        if (dVar != null) {
                            NodeList elementsByTagName2 = element.getElementsByTagName("Description");
                            if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                                dVar.vFv = ((Element) elementsByTagName2.item(0)).getAttribute("versionStr");
                            }
                        }
                        cVar.vFt = a(element);
                        aVar2.vFm[i] = cVar;
                    }
                }
                return aVar2;
            } catch (ParserConfigurationException e) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            } catch (SAXException e2) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            } catch (IOException e3) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            }
        } catch (ParserConfigurationException e4) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        } catch (SAXException e5) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        } catch (IOException e6) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        }
    }
}
