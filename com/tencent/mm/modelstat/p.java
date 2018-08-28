package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p {
    public static void a(String str, d dVar) {
        if (dVar != null) {
            b(str, dVar);
        }
    }

    public static void b(String str, d dVar) {
        if (!bi.oW(str) && dVar != null) {
            bqx nn = nn(str);
            dVar.r("Source", (nn == null ? -1 : nn.source) + ",");
            dVar.r("SnsStatExt", a(nn));
        }
    }

    public static bqx nn(String str) {
        if (bi.oW(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        bqw bqw = new bqw();
        try {
            bqw.aG(decode);
        } catch (Exception e) {
            x.e("MicroMsg.SnsStatExtUtil", "", new Object[]{e});
        }
        return bqw.soW;
    }

    public static String a(String str, PString pString) {
        if (bi.oW(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        bqw bqw = new bqw();
        try {
            bqw.aG(decode);
            String str2 = bqw.soW.spa;
            String str3 = bqw.soW.soZ;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(bqw.soW.source), URLEncoder.encode(a(bqw.soW), "UTF-8")});
            pString.value = bqw.soY == null ? "" : bqw.soY.jLY;
            return str2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String a(bqx bqx) {
        if (bqx != null) {
            String str = bqx.spa;
            String str2 = "";
            if (!bi.oW(str)) {
                String[] split = str.split("\\|");
                if (split != null && split.length > 0) {
                    str2 = split[0];
                }
            }
            try {
                return String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(bqx.spb), URLEncoder.encode(str2, "UTF-8"), bqx.soZ});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.SnsStatExtUtil", "", new Object[]{e});
            }
        }
        return "";
    }

    public static String C(bd bdVar) {
        if (bdVar == null) {
            return "";
        }
        String str = null;
        if (bdVar.aQm()) {
            a gp = a.gp(bdVar.field_content);
            if (gp == null || bi.oW(gp.bZN)) {
                return "";
            }
            str = gp.bZN;
        }
        if (!bdVar.cmk()) {
            return str;
        }
        r nW = t.nW(bdVar.field_imgPath);
        if (nW == null || bi.oW(nW.bZN)) {
            return "";
        }
        return nW.bZN;
    }
}
