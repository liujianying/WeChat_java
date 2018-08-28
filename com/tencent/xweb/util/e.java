package com.tencent.xweb.util;

import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.g;
import com.tencent.xweb.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    public static String bJK = "";
    private static String vAE = "";
    private static boolean vDo = false;
    static q vDp = null;

    /* renamed from: com.tencent.xweb.util.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] vDq = new int[d.values().length];

        static {
            try {
                vDq[d.vAP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vDq[d.vAQ.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vDq[d.vAR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void adF(String str) {
        if (str != null) {
            vAE = str;
        }
    }

    public static void c(d dVar) {
        if (vDp != null) {
            String str;
            if ((dVar == d.vAP ? 1 : null) != null) {
                str = "REPORT_APK_VER_TIME";
            } else {
                str = "REPORT_APK_VER_TIME_" + dVar;
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            Object string = XWalkEnvironment.getSharedPreferences().getString(str, "");
            if (string == null) {
                string = "";
            }
            if (!format.equals(string)) {
                int i;
                if (dVar == d.vAP) {
                    int availableVersion = XWalkEnvironment.getAvailableVersion();
                    if (availableVersion > 0) {
                        i = 99;
                        vDp.am((long) ((availableVersion % 50) + 100));
                    } else {
                        return;
                    }
                } else if (dVar == d.vAR) {
                    i = 97;
                } else if (dVar == d.vAQ) {
                    i = 98;
                } else {
                    return;
                }
                vDp.am((long) i);
                XWalkEnvironment.getSharedPreferences().edit().putString(str, format).apply();
            }
        }
    }

    public static void a(q qVar) {
        vDp = qVar;
    }

    public static void bh(int i, String str) {
        if (vDp != null) {
            vDp.k(i, str);
        }
    }

    public static void gY(long j) {
        if (vDp != null) {
            vDp.am(j);
        }
    }

    public static void cIH() {
        int i = 73;
        if (vDp != null) {
            vDp.am(0);
            if (!vDo) {
                if (vAE.equals("tools")) {
                    i = 70;
                } else if (!(vAE.equals("appbrand") || vAE.equals("support"))) {
                    i = -1;
                }
                int ordinal = WebView.getCurWebType().ordinal() - 1;
                if (i >= 70 && ordinal >= 0) {
                    vDo = true;
                    vDp.am((long) (i + ordinal));
                }
            }
        }
    }

    public static void cII() {
        if (vDp != null) {
            vDp.am(1);
        }
    }

    public static void gZ(long j) {
        if (vDp != null && j > 0 && j < 300000) {
            vDp.w(2, 3, (int) j);
        }
    }

    public static void cIJ() {
        if (vDp != null) {
            vDp.am(46);
        }
    }

    public static void cIK() {
        if (vDp != null) {
            vDp.am(47);
        }
    }

    public static void ha(long j) {
        if (vDp != null && j > 0 && j < 300000) {
            vDp.w(48, 49, (int) j);
        }
    }

    public static void cIL() {
        if (vDp != null) {
            vDp.am(42);
        }
    }

    public static void cIM() {
        if (vDp != null) {
            vDp.am(43);
        }
    }

    public static void hb(long j) {
        if (vDp != null && j > 0 && j < 300000) {
            vDp.w(44, 45, (int) j);
        }
    }

    public static void dH(String str, int i) {
        if (vDp != null) {
            cIH();
            bJK = UUID.randomUUID().toString().replace("-", "");
            vDp.am(4);
            vDp.a(XWalkEnvironment.getAvailableVersion(), adG(str), bJK, g.cIl() == null ? 100 : g.cIl().ordinal(), 0, 0, 0, i);
        }
    }

    public static void b(String str, int i, long j, int i2) {
        if (vDp != null) {
            cII();
            vDp.am(5);
            vDp.k(15003, "");
            vDp.a(XWalkEnvironment.getAvailableVersion(), adG(str), bJK, g.cIl() == null ? 100 : g.cIl().ordinal(), 1, i, (int) j, i2);
        }
    }

    public static void j(String str, long j, int i) {
        gZ(j);
        if (vDp != null && j > 0 && j < 300000) {
            vDp.w(6, 7, (int) j);
            vDp.a(XWalkEnvironment.getAvailableVersion(), adG(str), bJK, g.cIl() == null ? 100 : g.cIl().ordinal(), 1, 0, (int) j, i);
        }
    }

    public static int adG(String str) {
        if (str.startsWith("https://servicewechat.com/")) {
            return 0;
        }
        if (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) {
            return 1;
        }
        return 2;
    }

    public static void cIN() {
        if (vDp != null) {
            vDp.am(52);
        }
    }

    public static void cIO() {
        if (vDp != null) {
            vDp.am(53);
        }
    }

    public static void cIP() {
        if (vDp != null) {
            vDp.am(54);
        }
    }

    public static void cIQ() {
        if (vDp != null) {
            vDp.am(55);
        }
    }

    public static void cIR() {
        if (vDp != null) {
            vDp.am(56);
        }
    }

    public static void cIS() {
        if (vDp != null) {
            vDp.am(57);
        }
    }

    public static void cIT() {
        if (vDp != null) {
            vDp.am(58);
        }
    }

    public static void cIU() {
        if (vDp != null) {
            vDp.am(59);
        }
    }

    public static void at(int i, boolean z) {
        if (vDp != null) {
            int i2 = 0;
            switch (i) {
                case 0:
                    if (!z) {
                        i2 = 159;
                        break;
                    } else {
                        i2 = 163;
                        break;
                    }
                case 1:
                    if (!z) {
                        i2 = 160;
                        break;
                    } else {
                        i2 = 164;
                        break;
                    }
                case 2:
                    if (!z) {
                        i2 = 161;
                        break;
                    } else {
                        i2 = 165;
                        break;
                    }
                case 3:
                    if (!z) {
                        i2 = 162;
                        break;
                    } else {
                        i2 = 166;
                        break;
                    }
            }
            if (i2 > 0) {
                vDp.am((long) i2);
            }
        }
    }

    public static void au(int i, boolean z) {
        if (vDp != null) {
            int i2 = 0;
            switch (i) {
                case 0:
                    if (!z) {
                        i2 = 151;
                        break;
                    } else {
                        i2 = 155;
                        break;
                    }
                case 1:
                    if (!z) {
                        i2 = 152;
                        break;
                    } else {
                        i2 = 156;
                        break;
                    }
                case 2:
                    if (!z) {
                        i2 = 153;
                        break;
                    } else {
                        i2 = 157;
                        break;
                    }
                case 3:
                    if (!z) {
                        i2 = 154;
                        break;
                    } else {
                        i2 = 158;
                        break;
                    }
            }
            if (i2 > 0) {
                vDp.am((long) i2);
            }
        }
    }

    public static void cIV() {
        if (vDp != null) {
            vDp.am(9);
        }
    }

    public static void hc(long j) {
        if (vDp != null && vDp != null && j > 0 && j < 600000) {
            vDp.w(11, 12, (int) j);
        }
    }

    public static void cIW() {
        if (vDp != null) {
            vDp.am(10);
        }
    }

    public static void cIX() {
        if (vDp != null) {
            vDp.am(60);
        }
    }

    public static void cIY() {
        if (vDp != null) {
            vDp.am(61);
        }
    }

    public static void cIZ() {
        if (vDp != null) {
            vDp.am(20);
        }
    }

    public static void hd(long j) {
        if (vDp != null && vDp != null && j > 0 && j < 600000) {
            vDp.w(22, 23, (int) j);
        }
    }

    public static void cJa() {
        if (vDp != null) {
            vDp.am(21);
        }
    }

    public static void cJb() {
        if (vDp != null) {
            vDp.am(25);
        }
    }

    public static void he(long j) {
        if (vDp != null && vDp != null && j > 0 && j < 600000) {
            vDp.w(27, 28, (int) j);
        }
    }

    public static void cJc() {
        if (vDp != null) {
            vDp.am(26);
        }
    }

    public static void cJd() {
        if (vDp != null) {
            vDp.am(14);
        }
    }

    public static void cJe() {
        if (vDp != null) {
            vDp.am(15);
        }
    }

    public static void hf(long j) {
        if (vDp != null && vDp != null && j > 0 && j < 120000) {
            vDp.w(16, 17, (int) j);
        }
    }

    public static void cJf() {
        if (vDp != null) {
            vDp.am(83);
        }
    }

    public static void d(d dVar) {
        if (vDp != null) {
            int i;
            switch (AnonymousClass1.vDq[dVar.ordinal()]) {
                case 1:
                    i = 82;
                    break;
                case 2:
                    i = 81;
                    break;
                case 3:
                    i = 80;
                    break;
                default:
                    return;
            }
            vDp.am((long) i);
        }
    }

    public static void cJg() {
        if (vDp != null) {
            vDp.am(87);
        }
    }

    public static void e(d dVar) {
        if (vDp != null) {
            int i;
            switch (AnonymousClass1.vDq[dVar.ordinal()]) {
                case 1:
                    i = 86;
                    break;
                case 2:
                    i = 85;
                    break;
                case 3:
                    i = 84;
                    break;
                default:
                    return;
            }
            vDp.am((long) i);
        }
    }

    public static void cJh() {
        if (vDp != null) {
            vDp.am(88);
        }
    }
}
