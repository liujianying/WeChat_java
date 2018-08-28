package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.bhk;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.Map;

public final class e {
    private static boolean t(String str, Map<String, String> map) {
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        return false;
    }

    static void f(String str, String str2, Map<String, String> map) {
        if (!t(String.format("%s.%s", new Object[]{str, str2}), map)) {
            int g = g(str, str2, map) | 0;
            int i = 0;
            while (true) {
                i++;
                if (t(String.format(Locale.US, "%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                    break;
                }
                g |= g(str, str2, map);
            }
            i = i$b.Tk(str2);
            if (i$b.BP(i)) {
                j.n(0, 32);
                if (g == 0) {
                    j.n(0, 33);
                }
            } else if (i$b.BQ(i)) {
                j.n(0, 35);
                if (g == 0) {
                    j.n(0, 36);
                }
            } else if (i$b.BR(i)) {
                j.n(0, 38);
                if (g == 0) {
                    j.n(0, 39);
                }
            }
        }
    }

    private static boolean g(String str, String str2, Map<String, String> map) {
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int Tk = i$b.Tk(str2);
        if (t(format, map)) {
            return true;
        }
        boolean d = d(Tk, format, map) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format(Locale.US, "%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (t(format2, map)) {
                return d;
            }
            d |= d(Tk, format2, map);
        }
    }

    private static boolean d(int i, String str, Map<String, String> map) {
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        int i2;
        int i3;
        bhi bhi;
        if (i$b.BR(i)) {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
            i2 = bi.getInt((String) map.get(str + ".resType"), -1);
            i3 = bi.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            bhi = new bhi();
            bhi.sdX = i3;
            bhi.sih = new bhl();
            bhi.sih.sir = bi.getInt((String) map.get(str + ".resVer"), 0);
            bhi.sik = (String) map.get(str + ".sampleID");
            bhi.sij = bi.getInt((String) map.get(str + ".reportID"), 0);
            bhi.rIr = i$b.DoDelete.bWA;
            c.ccr().a(i2, bhi, true);
            j.n((long) bhi.sij, 40);
            return true;
        } else if (i$b.BP(i)) {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
            String str2 = (String) map.get(str + ".CDNUrl");
            int i4 = bi.getInt((String) map.get(str + ".subType"), -1);
            int i5 = bi.getInt((String) map.get(str + ".resType"), -1);
            String str3 = (String) map.get(str + ".md5");
            int i6 = bi.getInt((String) map.get(str + ".priority"), 0);
            if (bi.oW(str2) || bi.oW(str3) || -1 == i4 || -1 == i5 || i6 < 0) {
                return false;
            }
            int ccu;
            bhi bhi2 = new bhi();
            bhi2.sih = new bhl();
            if (bi.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
                ccu = i$a.ccu();
            } else {
                ccu = 0;
            }
            if (bi.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
                ccu = i$a.BN(ccu);
            }
            bhi2.sdX = i4;
            bhi2.sim = bi.getInt((String) map.get(str + ".networkType"), 2);
            bhi2.rlY = bi.getInt((String) map.get(str + ".expireTime"), 1);
            bhi2.sih.jPK = str2;
            bhi2.sih.sir = bi.getInt((String) map.get(str + ".resVer"), 0);
            bhi2.sih.rwt = str3;
            bhi2.sih.siu = (String) map.get(str + ".originalmd5");
            bhi2.sih.sis = ccu;
            bhi2.sih.sit = null;
            bhi2.sih.rwb = null;
            bhi2.rPB = i6;
            bhi2.rIr = i$b.DoCache.bWA;
            bhi2.sij = bi.getInt((String) map.get(str + ".reportID"), 0);
            bhi2.sik = (String) map.get(str + ".sampleID");
            bhi2.sil = bi.getInt((String) map.get(str + ".retryTime"), 3);
            bhi2.sin = bi.getInt((String) map.get(str + ".retryInterval"), 0);
            bhi2.qCh = 0;
            c.ccr().b(i5, bhi2, true);
            j.n((long) bhi2.sij, 34);
            return true;
        } else if (!i$b.BQ(i)) {
            return false;
        } else {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
            i2 = bi.getInt((String) map.get(str + ".resType"), -1);
            i3 = bi.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            bhi = new bhi();
            bhi.sii = new bhk();
            bhi.sdX = i3;
            bhi.sii.siq = (String) map.get(str + ".resKey");
            bhi.sii.sip = bi.getInt((String) map.get(str + ".resKeyVersion"), 0);
            bhi.sik = (String) map.get(str + ".sampleID");
            bhi.sij = bi.getInt((String) map.get(str + ".reportID"), 0);
            bhi.rIr = i$b.DoDecrypt.bWA;
            bhi.sih = new bhl();
            bhi.sih.siu = (String) map.get(str + ".originalmd5");
            c.ccr().a(i2, bhi, true, false);
            j.n((long) bhi.sij, 37);
            return true;
        }
    }
}
