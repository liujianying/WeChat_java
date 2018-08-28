package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.aq.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class q {
    public static boolean gQ(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String GF = GF();
        if (GF != null && GF.length() > 0) {
            return GF.equals(str);
        }
        x.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
        return false;
    }

    public static int GE() {
        g.Ek();
        Integer num = (Integer) g.Ei().DT().get(9, null);
        return num == null ? 0 : num.intValue();
    }

    public static String getUserBindEmail() {
        g.Ek();
        return bi.oV((String) g.Ei().DT().get(5, null));
    }

    public static String GF() {
        g.Ek();
        return (String) g.Ei().DT().get(2, null);
    }

    public static String GG() {
        g.Ek();
        return (String) g.Ei().DT().get(42, null);
    }

    public static String GH() {
        g.Ek();
        return (String) g.Ei().DT().get(4, null);
    }

    public static String GI() {
        String GG = GG();
        return !bi.oW(GG) ? GG : GF();
    }

    public static int GJ() {
        g.Ek();
        Integer num = (Integer) g.Ei().DT().get(7, null);
        return num == null ? 0 : num.intValue();
    }

    public static long GK() {
        g.Ek();
        Long l = (Long) g.Ei().DT().get(147457, null);
        return l == null ? 0 : l.longValue();
    }

    public static int GL() {
        g.Ek();
        Integer num = (Integer) g.Ei().DT().get(40, null);
        return num == null ? 0 : num.intValue();
    }

    public static int GM() {
        g.Ek();
        Integer num = (Integer) g.Ei().DT().get(339975, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean gT(int i) {
        return (i & 8192) != 0;
    }

    public static boolean GN() {
        return (GL() & 16384) != 0;
    }

    public static boolean GO() {
        return (GL() & 32768) != 0;
    }

    public static void GP() {
        int GL = GL() | 32768;
        g.Ek();
        g.Ei().DT().set(40, Integer.valueOf(GL));
    }

    public static int GQ() {
        g.Ek();
        Integer num = (Integer) g.Ei().DT().get(34, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean GR() {
        boolean z;
        if ((GJ() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(GJ()));
        return z;
    }

    public static boolean GS() {
        g.Ek();
        g.Ei().DT().lm(true);
        if (GM() == 1) {
            return true;
        }
        return false;
    }

    public static boolean GT() {
        g.Ek();
        g.Ei().DT().lm(true);
        if (GM() == 2) {
            return true;
        }
        return false;
    }

    public static boolean GU() {
        g.Ek();
        g.Ei().DT().lm(true);
        if (GM() == 4) {
            return true;
        }
        return false;
    }

    public static boolean GV() {
        return (GQ() & 32) == 0;
    }

    public static boolean GW() {
        return (GJ() & 4096) != 0;
    }

    public static boolean GX() {
        bl Hg = ((i) g.l(i.class)).FZ().Hg("@t.qq.com");
        return Hg != null && Hg.isEnable();
    }

    public static boolean GY() {
        return (GQ() & 2) == 0;
    }

    public static boolean GZ() {
        return (GQ() & 16) == 0;
    }

    public static boolean Ha() {
        return (GQ() & FileUtils.S_IWUSR) == 0;
    }

    public static boolean Hb() {
        g.Ek();
        return bi.d((Boolean) g.Ei().DT().get(8200, null));
    }

    public static boolean Hc() {
        return (GQ() & SQLiteGlobal.journalSizeLimit) == 0;
    }

    public static boolean Hd() {
        return (GQ() & 262144) == 0;
    }

    public static boolean He() {
        return (GQ() & 8192) == 0;
    }

    public static boolean Hf() {
        return (GQ() & 65536) == 0;
    }

    public static boolean Hg() {
        g.Ek();
        String str = (String) g.Ei().DT().get(65825, null);
        if (bi.oW(str)) {
            return false;
        }
        if (str.equals("0")) {
            return false;
        }
        try {
            if (bi.c(Long.valueOf(bi.getLong(str, 0))) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean Hh() {
        return (GQ() & 1) == 0;
    }

    public static boolean Hi() {
        return (GJ() & 131072) == 0;
    }

    public static int Hj() {
        g.Ek();
        return bi.a((Integer) g.Ei().DT().get(8201, null), 22);
    }

    public static int Hk() {
        g.Ek();
        return bi.a((Integer) g.Ei().DT().get(8208, null), 8);
    }

    public static ab Hl() {
        a Yg = ((i) g.l(i.class)).FR().Yg(GF());
        if (Yg != null && ((int) Yg.dhP) > 0) {
            return Yg;
        }
        ab abVar = new ab();
        g.Ek();
        String str = (String) g.Ei().DT().get(2, null);
        g.Ek();
        String str2 = (String) g.Ei().DT().get(4, null);
        abVar.setUsername(str);
        abVar.dx(str2);
        ((i) g.l(i.class)).FR().T(abVar);
        return ((i) g.l(i.class)).FR().Yg(str);
    }

    public static b q(int i, String str) {
        b kVar;
        switch (i) {
            case 2:
                kVar = new k(str, 1);
                break;
            case 18:
                kVar = new k(str, 2);
                break;
            default:
                kVar = null;
                break;
        }
        ((i) g.l(i.class)).FQ().b(kVar);
        return kVar;
    }

    public static boolean Hm() {
        g.Ek();
        return new o(bi.f((Integer) g.Ei().DT().get(9, null))).longValue() != 0;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            return false;
        } else if (str2 != null && str2.length() > 0 && (ab.XO(str2) || ab.XQ(str2))) {
            return false;
        } else {
            boolean z2;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                double d;
                if (e.cm(str) < 65536) {
                    z2 = true;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                    d = (double) options.outWidth;
                    double d2 = (double) options.outHeight;
                    if (d < 100.0d && d2 < 100.0d) {
                        x.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d2);
                        z2 = true;
                    }
                }
                if (z2) {
                    d = (double) options.outWidth;
                    double d3 = (double) options.outHeight;
                    if (d / d3 >= 2.5d || d3 / d >= 2.5d) {
                        if (e.cm(str) < 26214400) {
                            x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.cm(str)));
                            return true;
                        }
                        x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.cm(str)));
                        return false;
                    } else if (z) {
                        return false;
                    } else {
                        return true;
                    }
                }
                x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                return true;
            }
            z2 = false;
            if (z2) {
                d = (double) options.outWidth;
                double d32 = (double) options.outHeight;
                if (d / d32 >= 2.5d || d32 / d >= 2.5d) {
                    if (e.cm(str) < 26214400) {
                        x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.cm(str)));
                        return true;
                    }
                    x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.cm(str)));
                    return false;
                } else if (z) {
                    return false;
                } else {
                    return true;
                }
            }
            x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
            return true;
        }
    }

    public static void p(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        g.Ek();
        if (g.Ei() != null) {
            g.Ek();
            if (g.Ei().DT() != null) {
                g.Ek();
                g.Ei().DT().set(327682, stringBuilder.toString());
            }
        }
    }

    public static void q(Map<String, String> map) {
        map.clear();
        g.Ek();
        if (g.Ei() != null) {
            g.Ek();
            if (g.Ei().DT() != null) {
                g.Ek();
                String str = (String) g.Ei().DT().get(327682, null);
                if (str != null) {
                    String[] split = str.split("\n");
                    if (split.length % 2 != 0) {
                        x.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                        return;
                    }
                    for (int i = 0; i < split.length; i += 2) {
                        map.put(split[i], split[i + 1]);
                    }
                    return;
                }
                return;
            }
        }
        x.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
    }

    public static Boolean Hn() {
        if (g.Eg().Dx()) {
            g.Ek();
            String str = (String) g.Ei().DT().get(6, null);
            g.Ek();
            if (!Boolean.valueOf(bi.d((Boolean) g.Ei().DT().get(340241, null))).booleanValue() || bi.oW(str)) {
                return Boolean.valueOf(false);
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = ap.Fp(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }
        x.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        return Boolean.valueOf(false);
    }

    public static Map<String, String> Ho() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("login_weixin_username", GF());
        g.Ek();
        hashMap.put("login_user_name", (String) g.Ei().DT().get(aa.a.USERINFO_LAST_LOGIN_USERNAME_STRING, null));
        g.Ek();
        hashMap.put("last_avatar_path", (String) g.Ei().DT().get(aa.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, null));
        g.Ek();
        hashMap.put("last_login_bind_mobile", (String) g.Ei().DT().get(6, null));
        g.Ek();
        hashMap.put("last_login_bind_email", (String) g.Ei().DT().get(5, null));
        g.Ek();
        hashMap.put("last_login_bind_qq", String.valueOf(g.Ei().DT().get(9, null)));
        g.Ek();
        hashMap.put("last_login_use_voice", String.valueOf(g.Ei().DT().get(40, null)));
        return hashMap;
    }
}
