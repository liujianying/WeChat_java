package com.tencent.mm.plugin.backup.bakoldlogic.a;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static List<String> gRN = null;

    public static List<String> arb() {
        if (gRN != null) {
            return gRN;
        }
        gRN = new LinkedList();
        for (Object add : s.dAV) {
            gRN.add(add);
        }
        gRN.add("weixin");
        gRN.add("weibo");
        gRN.add("qqmail");
        gRN.add("fmessage");
        gRN.add("tmessage");
        gRN.add("qmessage");
        gRN.add("qqsync");
        gRN.add("floatbottle");
        gRN.add("lbsapp");
        gRN.add("shakeapp");
        gRN.add("medianote");
        gRN.add("qqfriend");
        gRN.add("readerapp");
        gRN.add("newsapp");
        gRN.add("blogapp");
        gRN.add("facebookapp");
        gRN.add("masssendapp");
        gRN.add("meishiapp");
        gRN.add("feedsapp");
        gRN.add("voipapp");
        gRN.add("officialaccounts");
        gRN.add("helper_entry");
        gRN.add("pc_share");
        gRN.add("cardpackage");
        gRN.add("voicevoipapp");
        gRN.add("voiceinputapp");
        gRN.add("linkedinplugin");
        gRN.add("appbrandcustomerservicemsg");
        return gRN;
    }

    public static String wv(String str) {
        if (str == null) {
            return "";
        }
        String u = g.u(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (u.length() > 0) {
            str2 = u.charAt(0) + "/";
        }
        if (u.length() >= 2) {
            str3 = u.charAt(1) + "/";
        }
        return str2 + str3;
    }

    public static String asK() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gq()).append("backup/").toString();
    }

    public static void wH(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "backupItem/");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "backupMeida/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long r14, com.tencent.mm.pointers.PLong r16, com.tencent.mm.pointers.PLong r17, java.lang.String r18) {
        /*
        r2 = com.tencent.mm.compatible.util.h.getExternalStorageDirectory();
        r3 = new android.os.StatFs;
        r2 = r2.getPath();
        r3.<init>(r2);
        r2 = r3.getBlockSize();
        r4 = (long) r2;
        r2 = r3.getAvailableBlocks();
        r2 = (long) r2;
        r2 = r2 * r4;
        r0 = r16;
        r0.value = r2;
        r2 = com.tencent.mm.compatible.util.h.getDataDirectory();
        r3 = new android.os.StatFs;
        r4 = r2.getPath();
        r3.<init>(r4);
        r4 = r3.getBlockCount();
        r4 = (long) r4;
        r6 = r3.getAvailableBlocks();
        r6 = (long) r6;
        r8 = r3.getBlockSize();
        r8 = (long) r8;
        r3 = r3.getAvailableBlocks();
        r10 = (long) r3;
        r8 = r8 * r10;
        r0 = r17;
        r0.value = r8;
        r3 = "MicroMsg.BakUtil";
        r8 = "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d";
        r9 = 3;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r0 = r16;
        r12 = r0.value;
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 1;
        r0 = r17;
        r12 = r0.value;
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 2;
        r11 = java.lang.Long.valueOf(r14);
        r9[r10] = r11;
        com.tencent.mm.sdk.platformtools.x.i(r3, r8, r9);
        r8 = 0;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 > 0) goto L_0x0073;
    L_0x0071:
        r2 = 0;
    L_0x0072:
        return r2;
    L_0x0073:
        r4 = r4 - r6;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 >= 0) goto L_0x007c;
    L_0x007a:
        r2 = 0;
        goto L_0x0072;
    L_0x007c:
        r0 = r16;
        r4 = r0.value;
        r0 = r17;
        r6 = r0.value;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0094;
    L_0x0088:
        r2 = r2.getPath();
        r0 = r18;
        r2 = r0.startsWith(r2);
        if (r2 == 0) goto L_0x009a;
    L_0x0094:
        r2 = 0;
        r0 = r16;
        r0.value = r2;
    L_0x009a:
        r0 = r17;
        r2 = r0.value;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x00a4;
    L_0x00a2:
        r2 = 0;
        goto L_0x0072;
    L_0x00a4:
        r2 = 1;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(long, com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong, java.lang.String):boolean");
    }

    public static boolean wx(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (bl.z(str, "msg") != null) {
            return true;
        }
        return false;
    }

    public static String wI(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return asK() + "backupMeida/" + wv(str) + str;
    }

    public static int c(ey eyVar, int i) {
        if (eyVar.rfA == i) {
            if (eyVar.rfy == null) {
                return 0;
            }
            return eyVar.rfy.siK.lR.length;
        } else if (eyVar.rfx == null || eyVar.rfw == null) {
            return 0;
        } else {
            Iterator it = eyVar.rfx.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bia) it.next()).siO == i) {
                    return e.cm(wI(((bhz) eyVar.rfw.get(i2)).siM));
                }
                i2++;
            }
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.tencent.mm.protocal.c.ey r5, int r6, java.lang.String r7) {
        /*
        r2 = 0;
        r0 = r5.rfA;
        if (r0 != r6) goto L_0x0014;
    L_0x0005:
        r0 = r5.rfy;
        if (r0 == 0) goto L_0x0014;
    L_0x0009:
        r0 = r5.rfy;
        r0 = r0.siK;
        r0 = r0.lR;
        r0 = com.tencent.mm.a.g.u(r0);
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = 0;
        r1 = r5.rfx;
        if (r1 == 0) goto L_0x0060;
    L_0x0019:
        r1 = r5.rfw;
        if (r1 == 0) goto L_0x0060;
    L_0x001d:
        r1 = r5.rfx;
        r3 = r1.iterator();
        r1 = r0;
    L_0x0024:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0060;
    L_0x002a:
        r0 = r3.next();
        r0 = (com.tencent.mm.protocal.c.bia) r0;
        r0 = r0.siO;
        if (r0 != r6) goto L_0x005c;
    L_0x0034:
        r0 = r5.rfw;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.protocal.c.bhz) r0;
        r0 = r0.siM;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r4 != 0) goto L_0x0050;
    L_0x0044:
        r4 = r0.endsWith(r7);
        if (r4 != 0) goto L_0x0050;
    L_0x004a:
        r0 = r1 + 1;
        r0 = r0 + 1;
        r1 = r0;
        goto L_0x0024;
    L_0x0050:
        r1 = wI(r0);
        r1 = com.tencent.mm.a.e.cn(r1);
        if (r1 != 0) goto L_0x0013;
    L_0x005a:
        r0 = r2;
        goto L_0x0013;
    L_0x005c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0024;
    L_0x0060:
        r0 = r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(com.tencent.mm.protocal.c.ey, int, java.lang.String):java.lang.String");
    }

    public static String a(ey eyVar, int i) {
        return a(eyVar, i, null);
    }

    public static byte[] b(ey eyVar, int i) {
        if (eyVar.rfA == i && eyVar.rfy != null) {
            return eyVar.rfy.siK.lR;
        }
        if (!(eyVar.rfx == null || eyVar.rfw == null)) {
            Iterator it = eyVar.rfx.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bia) it.next()).siO == i) {
                    String wI = wI(((bhz) eyVar.rfw.get(i2)).siM);
                    i2 = e.cm(wI);
                    if (i2 != 0 && i2 <= 1048576) {
                        return e.f(wI, 0, -1);
                    }
                    x.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
                    return null;
                }
                i2++;
            }
        }
        return null;
    }

    public static boolean b(ey eyVar, int i, String str) {
        if (eyVar.rfA != i || eyVar.rfy == null) {
            String a = a(eyVar, i, null);
            if (bi.oW(a)) {
                return false;
            }
            j.q(wI(a), str, false);
            return true;
        }
        byte[] bArr = eyVar.rfy.siK.lR;
        if (bArr.length <= 0) {
            return false;
        }
        e.b(str, bArr, bArr.length);
        return true;
    }

    public static int aR(String str, int i) {
        if (bi.oW(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
            return i;
        }
    }

    public static boolean d(ey eyVar, int i) {
        if (eyVar.rfA == i && eyVar.rfy != null) {
            return true;
        }
        Iterator it = eyVar.rfx.iterator();
        while (it.hasNext()) {
            if (((bia) it.next()).siO == i) {
                return true;
            }
        }
        return false;
    }
}
