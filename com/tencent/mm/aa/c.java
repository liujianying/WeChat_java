package com.tencent.mm.aa;

import android.graphics.Bitmap;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.g.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class c {
    public static String ac(String str, String str2) {
        return str + "?access_token=" + str2;
    }

    public static Bitmap jF(String str) {
        return a(str + "@google", false, -1);
    }

    private static String jG(String str) {
        return "http://graph.facebook.com/" + str + "/picture";
    }

    public static void jH(String str) {
        if (!bi.oW(str)) {
            String str2 = str + "@fb";
            j kc = q.KH().kc(str2);
            if (kc == null || !str2.equals(kc.getUsername()) || 3 != kc.csA) {
                if (kc == null) {
                    kc = new j();
                }
                kc.username = str2;
                kc.csA = 3;
                kc.dHR = jG(str);
                kc.dHQ = jG(str);
                kc.by(true);
                kc.bWA = 31;
                q.KH().a(kc);
            }
        }
    }

    public static Bitmap jI(String str) {
        return a(str + "@fb", false, -1);
    }

    public static long jJ(String str) {
        long j = -1;
        if (!ab.XS(str)) {
            return j;
        }
        try {
            return bi.getLong(str.split("@")[0], -1);
        } catch (Exception e) {
            return j;
        }
    }

    private static String aX(long j) {
        return new o(j) + "@qqim";
    }

    public static long jK(String str) {
        long j = -1;
        if (!ab.XQ(str)) {
            return j;
        }
        try {
            return bi.getLong(str.split("@")[0], -1);
        } catch (Exception e) {
            return j;
        }
    }

    public static boolean d(long j, int i) {
        if (i != 3) {
            return false;
        }
        return jL(aX(j));
    }

    public static boolean jL(String str) {
        if (str == null) {
            x.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        } else if (str.endsWith("@qqim")) {
            j jVar = new j();
            jVar.username = str;
            jVar.csA = 3;
            jVar.bWA = 3;
            return q.KH().a(jVar);
        } else {
            x.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        }
    }

    public static Bitmap aY(long j) {
        return a(aX(j), false, -1);
    }

    public static boolean J(String str, int i) {
        if (bi.oW(str)) {
            return false;
        }
        j kc = q.KH().kc(str);
        if (kc != null && str.equals(kc.getUsername()) && i == kc.csA) {
            return true;
        }
        if (kc == null) {
            kc = new j();
        }
        kc.username = str;
        kc.csA = i;
        kc.bWA = 3;
        return q.KH().a(kc);
    }

    public static Bitmap jM(String str) {
        return a(str, false, -1);
    }

    public static Bitmap c(String str, int i, int i2, int i3) {
        if (bi.oW(str) || !g.Eg().Dx()) {
            return null;
        }
        Bitmap bitmap;
        f Kp = q.Kp();
        x.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (bi.oW(str)) {
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.sdk.platformtools.c.a(Kp.c(str, true, false), i, i2, null, 0, 0, 1);
        }
        if (bitmap == null) {
            final g gVar = new g();
            gVar.a(str, new b() {
                public final int bd(int i, int i2) {
                    gVar.Ku();
                    x.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    return 0;
                }
            });
            return a(str, false, i3);
        } else if (i3 > 5) {
            return com.tencent.mm.sdk.platformtools.c.a(bitmap, false, (float) i3);
        } else {
            return bitmap;
        }
    }

    public static Bitmap a(String str, boolean z, int i) {
        if (bi.oW(str) || !g.Eg().Dx()) {
            return null;
        }
        if (!g.Ei().DW()) {
            return q.Kp().bJ(ad.getContext());
        }
        if (ab.gY(str)) {
            str = ab.XV(str);
        }
        return q.KJ().b(str, z, i);
    }

    public static String A(String str, boolean z) {
        if (bi.oW(str) || !g.Eg().Dx() || !g.Ei().DW()) {
            return null;
        }
        if (ab.gY(str)) {
            return q.Kp().c(ab.XV(str), false, z);
        }
        return q.Kp().c(str, false, z);
    }

    public static void jN(String str) {
        j kc = q.KH().kc(str);
        if (kc != null && str.equals(kc.getUsername())) {
            kc.dHT = 0;
            kc.bWA = 64;
            q.KH().a(kc);
        }
    }

    public static j a(String str, aue aue) {
        j jVar = new j();
        jVar.bWA = -1;
        jVar.username = str;
        jVar.dHQ = aue.rra;
        jVar.dHR = aue.rqZ;
        x.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", jVar.getUsername(), jVar.Kx(), jVar.Ky());
        jVar.by(aue.rXe != 0);
        if (aue.rWZ == 3 || aue.rWZ == 4) {
            jVar.csA = aue.rWZ;
        } else if (aue.rWZ == 2) {
            jVar.csA = 3;
            if (!q.GF().equals(str)) {
                q.Kp();
                f.B(str, false);
                q.Kp();
                f.B(str, true);
                q.KJ().jO(str);
            }
        }
        return jVar;
    }
}
