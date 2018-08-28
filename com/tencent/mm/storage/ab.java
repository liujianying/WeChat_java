package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsDownloadConfig;

public final class ab extends a implements Cloneable {
    public CharSequence sNQ;
    public String taj = null;

    public ab(String str) {
        super(str);
    }

    public static boolean XO(String str) {
        return str != null ? str.endsWith("@t.qq.com") : false;
    }

    public static boolean XP(String str) {
        return str != null ? str.endsWith("@qr") : false;
    }

    public static boolean XQ(String str) {
        return str != null ? str.endsWith("@qqim") : false;
    }

    public static boolean XR(String str) {
        return str != null ? str.endsWith("@openim") : false;
    }

    public static boolean XS(String str) {
        return str != null ? str.endsWith("@fb") : false;
    }

    public static boolean gY(String str) {
        if (str != null) {
            return str.contains("@bottle:") || str.endsWith("@bottle");
        } else {
            return false;
        }
    }

    public static boolean Dk(int i) {
        return (i & 8) > 0;
    }

    public static boolean gr(String str) {
        return str != null ? str.endsWith("@app") : false;
    }

    public static boolean XT(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            return false;
        } else if (XR(str)) {
            return true;
        } else {
            String G = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AU().G("HideWechatID", "idprefix");
            if (G == null) {
                return false;
            }
            String[] split = G.split(";");
            int i = 0;
            while (i < split.length) {
                if (split[i] != null && str.startsWith(split[i])) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    public static boolean XU(String str) {
        if (bi.oW(str)) {
            return true;
        }
        for (String str2 : "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";")) {
            if (!bi.oW(str2) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ckV() {
        return false;
    }

    public static String XV(String str) {
        if (gY(str)) {
            String[] split = str.split(":");
            if (split == null || split.length <= 0) {
                return str;
            }
            return split[0];
        } else if (str == null || !str.contains("@")) {
            return str + "@bottle";
        } else {
            return "";
        }
    }

    public final boolean ckW() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public static int ckX() {
        return 16;
    }

    public static int ckY() {
        return 8;
    }

    public final boolean ckZ() {
        return ((long) (((int) bi.VE()) - this.csR)) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    }

    public static String o(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("username"));
    }

    public final void dS(String str) {
        super.dS(str);
        clb();
    }

    public final String getCountryCode() {
        String str = this.csQ;
        if (bi.oW(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return "";
        }
        return bi.oV(split[0]);
    }

    public final String cla() {
        String str = this.csQ;
        if (bi.oW(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            return "";
        }
        return bi.oV(split[1]);
    }

    public final String getCityCode() {
        String str = this.csQ;
        if (bi.oW(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            return "";
        }
        return bi.oV(split[2]);
    }

    @Deprecated
    public final void dN(String str) {
        super.dN(str);
    }

    @Deprecated
    public final void dO(String str) {
        super.dO(str);
    }

    public final String getProvince() {
        return super.getProvince();
    }

    public final String getCity() {
        return super.getCity();
    }

    public final void clb() {
        String str = this.csQ;
        if (!bi.oW(str)) {
            String[] split = str.split("_");
            if (split.length <= 0) {
                return;
            }
            if (split.length > 2) {
                if (RegionCodeDecoder.Zh(split[0])) {
                    RegionCodeDecoder.cmS();
                    super.dN(RegionCodeDecoder.ga(split[0], split[1]));
                } else {
                    RegionCodeDecoder.cmS();
                    super.dN(RegionCodeDecoder.Zi(split[0]));
                }
                RegionCodeDecoder.cmS();
                super.dO(RegionCodeDecoder.ar(split[0], split[1], split[2]));
            } else if (split.length == 2) {
                RegionCodeDecoder.cmS();
                super.dN(RegionCodeDecoder.Zi(split[0]));
                RegionCodeDecoder.cmS();
                super.dO(RegionCodeDecoder.ga(split[0], split[1]));
            } else {
                RegionCodeDecoder.cmS();
                super.dN(RegionCodeDecoder.Zi(split[0]));
                super.dO("");
            }
        }
    }

    public final ab clc() {
        try {
            return (ab) super.clone();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Contact", e, "", new Object[0]);
            x.e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            return null;
        }
    }
}
