package com.tencent.mm.plugin.p;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;

public final class a {
    public String knp;
    public String knq;
    public int knr;
    public int kns;
    public int knt;
    public int knu;
    public int knv;
    public int knw;

    public static String cp(String str) {
        byte[] e = FileOp.e(str, 0, 6);
        if (e == null || e.length != 6) {
            return "";
        }
        String str2 = "";
        try {
            return new String(e, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            x.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:" + e2);
            return str2;
        }
    }

    public static String EK(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return str.replace(",", ";");
    }
}
