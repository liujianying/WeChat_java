package com.tencent.mm.ak;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class f {
    public static e a(e eVar) {
        if (eVar == null) {
            return null;
        }
        if (!eVar.ON()) {
            return eVar;
        }
        e hQ = o.Pf().hQ(eVar.dTU);
        if (hQ != null) {
            return hQ;
        }
        return eVar;
    }

    public static boolean b(e eVar) {
        if (eVar == null) {
            return false;
        }
        int i = eVar.offset;
        int i2 = eVar.dHI;
        long j = eVar.bYu;
        if (eVar.ON()) {
            e hQ = o.Pf().hQ(eVar.dTU);
            i = hQ.offset;
            i2 = hQ.dHI;
            j = hQ.bYu;
        }
        if (i2 == 0) {
            return true;
        }
        if ((i != i2 || i2 == 0) && j == 0) {
            return false;
        }
        return true;
    }

    public static String c(e eVar) {
        if (eVar == null) {
            return "";
        }
        if (!eVar.ON()) {
            return eVar.dTL;
        }
        e hQ = o.Pf().hQ(eVar.dTU);
        if (hQ == null) {
            return "";
        }
        return hQ.dTL;
    }

    public static String c(String str, String str2, String str3, String str4) {
        if (bi.oW(str)) {
            return null;
        }
        return String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[]{str, bi.oV(str2), bi.oV(str3), bi.oV(str4)});
    }

    public static final a lL(String str) {
        if (bi.oW(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map z = bl.z(str, "msg");
        if (z == null) {
            x.e("MicroMsg.ImgInfoLogic", "parseImg failed");
            return null;
        }
        a aVar = new a();
        aVar.appId = (String) z.get(".msg.appinfo.appid");
        aVar.mediaTagName = (String) z.get(".msg.appinfo.mediatagname");
        aVar.messageExt = (String) z.get(".msg.appinfo.messageext");
        aVar.messageAction = (String) z.get(".msg.appinfo.messageaction");
        return aVar;
    }
}
