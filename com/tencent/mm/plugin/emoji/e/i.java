package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ar.d;
import com.tencent.mm.ar.f;
import com.tencent.mm.br.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.co;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class i {
    private static String ifA = "newemoji";
    private static String ifB = "panel";
    public static String ifC = "suggest";
    public static String ifD = "egg";
    private static String ifE = "search";
    private static String ifF = "config.conf";
    private static String ifG = "emojipanel.zip";
    private static String ifH = "newemoji.zip";
    private static String ifI = "emoji_template.zip";
    private static String ifJ = "emojisuggest.zip";
    private static String ifK = "egg.zip";
    private static String ifL = "newemoji-config.xml";
    private static String ifM = "emojipanel-config.xml";
    public static String ifN = "emojisuggest-config.xml";
    public static String ifO = "egg.xml";
    private static int ifP = 0;
    private static int ifQ = 0;
    private static int ifR = 0;
    private static int ifS = 0;
    private static i ifT;
    private static String ify = "";
    private static String ifz = "temp";
    public f ifU;

    public static i aEd() {
        if (ifT == null) {
            synchronized (i.class) {
                ifT = new i();
            }
        }
        return ifT;
    }

    public static String getDataEmojiPath() {
        if (bi.oW(ify)) {
            ify = e.duO.replace("/data/user/0", "/data/data");
            ify += "/emoji";
        }
        return ify;
    }

    public static boolean a(bc bcVar, a aVar, String str) {
        File file = new File(bcVar.bIB.filePath);
        if (!file.exists() || file.length() <= 0) {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", new Object[]{String.valueOf(aVar), file.getAbsolutePath()});
        File file2 = new File(getDataEmojiPath(), str);
        if (file2.exists()) {
            com.tencent.mm.a.e.k(file2);
        }
        switch (1.ifV[aVar.ordinal()]) {
            case 1:
                str2 = ifH;
                break;
            case 2:
                str2 = ifG;
                break;
            case 3:
                str2 = ifI;
                break;
            case 4:
                str2 = ifJ;
                break;
            case 5:
                str2 = ifK;
                break;
            default:
                x.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", new Object[]{String.valueOf(aVar)});
                str2 = "";
                break;
        }
        File file3 = new File(file2, str2);
        file2.mkdirs();
        com.tencent.mm.a.e.y(file.getAbsolutePath(), file3.getAbsolutePath());
        int fR = bi.fR(file3.getAbsolutePath(), file2.getAbsolutePath());
        com.tencent.mm.a.e.deleteFile(file3.getPath());
        x.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (fR >= 0) {
            return true;
        }
        return false;
    }

    private static int F(File file) {
        Reader inputStreamReader;
        Throwable e;
        Reader reader;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (file.exists()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    reader = null;
                    inputStreamReader = null;
                    try {
                        x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                        com.tencent.mm.a.e.f(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.mm.a.e.f(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    reader = null;
                    inputStreamReader = null;
                    com.tencent.mm.a.e.f(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
                try {
                    reader = new BufferedReader(inputStreamReader);
                    try {
                        String str = "";
                        while (true) {
                            String readLine = reader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        }
                        i = new JSONObject(str).getInt("version");
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                        com.tencent.mm.a.e.f(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                    } catch (Exception e3) {
                        e = e3;
                        x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                        com.tencent.mm.a.e.f(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    }
                } catch (Exception e4) {
                    e = e4;
                    reader = null;
                    x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                    com.tencent.mm.a.e.f(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return i;
                } catch (Throwable th4) {
                    th = th4;
                    reader = null;
                    com.tencent.mm.a.e.f(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                reader = null;
                inputStreamReader = null;
                fileInputStream = null;
                x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                com.tencent.mm.a.e.f(fileInputStream);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return i;
            } catch (Throwable th5) {
                th = th5;
                reader = null;
                inputStreamReader = null;
                fileInputStream = null;
                com.tencent.mm.a.e.f(fileInputStream);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
                throw th;
            }
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", new Object[]{file.getAbsolutePath()});
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    public static boolean a(bc bcVar, a aVar) {
        int F;
        int intValue;
        if (a(bcVar, aVar, ifz)) {
            File file = new File(getDataEmojiPath(), ifz);
            x.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            F = F(new File(file, ifF));
        } else {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", new Object[]{String.valueOf(aVar)});
            F = -1;
        }
        switch (1.ifV[aVar.ordinal()]) {
            case 1:
                au.HU();
                intValue = ((Integer) c.DT().get(a.sPi, Integer.valueOf(0))).intValue();
                ifP = intValue;
                break;
            case 2:
                au.HU();
                intValue = ((Integer) c.DT().get(a.sPj, Integer.valueOf(0))).intValue();
                ifQ = intValue;
                break;
            case 3:
                intValue = com.tencent.mm.ag.a.dRu;
                break;
            case 4:
                au.HU();
                intValue = ((Integer) c.DT().get(a.sPk, Integer.valueOf(0))).intValue();
                ifR = intValue;
                break;
            case 5:
                au.HU();
                intValue = ((Integer) c.DT().get(a.sPl, Integer.valueOf(0))).intValue();
                ifS = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", new Object[]{Integer.valueOf(F), Integer.valueOf(intValue)});
        if (F == -1 || intValue >= F) {
            return false;
        }
        return true;
    }

    private static void G(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("emoji");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    if (childNodes != null && childNodes.getLength() > 0) {
                        q qVar = new q();
                        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                            Node item = childNodes.item(i2);
                            String nodeName = item.getNodeName();
                            if (nodeName.equalsIgnoreCase("key")) {
                                qVar.field_key = item.getTextContent();
                            } else if (nodeName.equalsIgnoreCase("cn-value")) {
                                if (bi.oW(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                    qVar.field_cnValue = qVar.field_key;
                                } else {
                                    qVar.field_cnValue = item.getTextContent();
                                }
                            } else if (nodeName.equalsIgnoreCase("qq-value")) {
                                if (bi.oW(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                    qVar.field_qqValue = qVar.field_key;
                                } else {
                                    qVar.field_qqValue = item.getTextContent();
                                }
                            } else if (nodeName.equalsIgnoreCase("en-value")) {
                                if (bi.oW(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                    qVar.field_enValue = qVar.field_key;
                                } else {
                                    qVar.field_enValue = item.getTextContent();
                                }
                            } else if (nodeName.equalsIgnoreCase("tw-value")) {
                                if (bi.oW(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                    qVar.field_twValue = qVar.field_key;
                                } else {
                                    qVar.field_twValue = item.getTextContent();
                                }
                            } else if (nodeName.equalsIgnoreCase("th-value")) {
                                if (bi.oW(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                    qVar.field_thValue = qVar.field_key;
                                } else {
                                    qVar.field_thValue = item.getTextContent();
                                }
                            } else if (nodeName.equalsIgnoreCase("fileName")) {
                                qVar.field_fileName = item.getTextContent();
                            } else if (nodeName.equalsIgnoreCase("eggIndex")) {
                                int intValue;
                                try {
                                    intValue = Integer.valueOf(item.getTextContent()).intValue();
                                } catch (Throwable e) {
                                    x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                                    intValue = -1;
                                }
                                qVar.field_eggIndex = intValue;
                            }
                        }
                        qVar.field_position = -1;
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", qVar.toString());
                        if (bi.oW(qVar.field_key)) {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is empty");
                        } else {
                            arrayList.add(qVar);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig smiley list is null.");
                } else if (((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().p(arrayList)) {
                    co coVar = new co();
                    coVar.bJZ.bID = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(coVar);
                    ifP = F(new File(getDataEmojiPath() + File.separator + ifA, ifF));
                    au.HU();
                    c.DT().a(a.sPi, Integer.valueOf(ifP));
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig parseXML exception:%s", new Object[]{e2.toString()});
        }
    }

    private static void H(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || bi.oW(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            for (char valueOf : toChars) {
                                replaceAll = replaceAll + String.valueOf(valueOf);
                            }
                        }
                        s sVar = new s(i, replaceAll);
                        if (bi.oW(sVar.field_key)) {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is null.");
                        } else {
                            arrayList.add(sVar);
                        }
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", sVar.toString());
                    }
                }
                if (arrayList.isEmpty()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig smiley panel list is null.");
                } else if (((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().q(arrayList)) {
                    co coVar = new co();
                    coVar.bJZ.bID = 2;
                    com.tencent.mm.sdk.b.a.sFg.m(coVar);
                    ifQ = F(new File(getDataEmojiPath() + File.separator + ifB, ifF));
                    au.HU();
                    c.DT().a(a.sPj, Integer.valueOf(ifQ));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void I(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("group");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    if (childNodes != null && childNodes.getLength() > 0) {
                        int length2 = childNodes.getLength();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Node item = childNodes.item(i2);
                            if (item.getNodeName().equals("word")) {
                                String textContent = item.getTextContent();
                                if (!bi.oW(textContent)) {
                                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", new Object[]{textContent});
                                    arrayList2.add(textContent.trim());
                                }
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aEA().igH.ad(arrayList);
                ifR = F(new File(getDataEmojiPath() + File.separator + ifC, ifF));
                au.HU();
                c.DT().a(a.sPk, Integer.valueOf(ifR));
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void J(File file) {
        try {
            String ct = com.tencent.mm.a.e.ct(file.getAbsolutePath());
            Map z = bl.z(ct, "EasterEgg");
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:" + ct);
            if (z == null) {
                x.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                return;
            }
            f fVar = new f();
            fVar.ecK = (double) bi.WU((String) z.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (z.get(str + ".$name") != null) {
                    d dVar = new d();
                    dVar.name = bi.oV((String) z.get(str + ".$name"));
                    dVar.ecD = bi.oV((String) z.get(str + ".$langs"));
                    dVar.ecA = bi.WU((String) z.get(str + ".$reportType"));
                    dVar.ecB = bi.WL((String) z.get(str + ".$BeginDate"));
                    dVar.ecC = bi.WL((String) z.get(str + ".$EndDate"));
                    dVar.ecE = bi.oV((String) z.get(str + ".FileName"));
                    dVar.ecF = bi.WU((String) z.get(str + ".AnimType"));
                    dVar.ecG = bi.WU((String) z.get(str + ".AnimType.$viewcount"));
                    dVar.ecH = bi.WU((String) z.get(str + ".AnimType.$minSize"));
                    dVar.maxSize = bi.WU((String) z.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        ct = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = ct + ".$lang";
                        if (z.get(ct) == null) {
                            break;
                        }
                        com.tencent.mm.ar.e eVar = new com.tencent.mm.ar.e();
                        eVar.ecI = bi.oV((String) z.get(ct));
                        eVar.lang = bi.oV((String) z.get(str2));
                        dVar.ecy.add(eVar);
                        i2++;
                    }
                    fVar.ecJ.add(dVar);
                    i++;
                } else {
                    byte[] toByteArray = fVar.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.Gp()).append("eggingfo.ini").toString(), toByteArray, toByteArray.length);
                    ifS = F(new File(getDataEmojiPath() + File.separator + ifD, ifF));
                    au.HU();
                    c.DT().a(a.sPl, Integer.valueOf(ifS));
                    return;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
    }

    public static void a(bc bcVar, boolean z) {
        if (!z && !a(bcVar, a.ifW)) {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
        } else if (a(bcVar, a.ifW, ifA) || z) {
            File file = new File(new File(getDataEmojiPath(), ifA), ifL);
            if (file.exists()) {
                G(file);
            } else {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
            }
        } else {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
        }
    }

    public static void b(bc bcVar, boolean z) {
        String str;
        if (!(z || a(bcVar, a.ifX))) {
            au.HU();
            str = (String) c.DT().get(a.sPm, ifM);
            String aEl = n.aEl();
            int i = (bi.oW(aEl) || str.equalsIgnoreCase(aEl)) ? 0 : 1;
            if (i == 0) {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                return;
            }
        }
        if (z || a(bcVar, a.ifX, ifB)) {
            File file = new File(getDataEmojiPath(), ifB);
            str = n.aEl();
            if (bi.oW(str)) {
                str = ifM;
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
            } else {
                if (!new File(file, str).exists()) {
                    str = ifM;
                }
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", new Object[]{str});
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                H(file2);
                au.HU();
                c.DT().a(a.sPm, str);
                return;
            }
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
            return;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
    }

    public static boolean b(bc bcVar) {
        long currentTimeMillis = System.currentTimeMillis();
        b.cjC();
        b.cjF();
        long j = b.cjC().sLx;
        b.cjC();
        int Xu = b.Xu(bcVar.bIB.filePath);
        b.cjC();
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", new Object[]{Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(Xu), Long.valueOf(b.Xt(bcVar.bIB.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (Xu == 1 && r6 > j) {
            return true;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
        return false;
    }

    public final f aDT() {
        try {
            if (this.ifU == null) {
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                byte[] f = com.tencent.mm.a.e.f(stringBuilder.append(c.Gp()).append("eggingfo.ini").toString(), 0, -1);
                if (f == null) {
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.ifU = (f) new f().aG(f);
                }
            }
        } catch (Throwable e) {
            x.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", new Object[]{e.getLocalizedMessage()});
            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
        return this.ifU;
    }
}
