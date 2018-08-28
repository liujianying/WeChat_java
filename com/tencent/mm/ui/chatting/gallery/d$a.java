package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class d$a {
    private static HashMap<String, d$a> tVa = new HashMap();
    private int dHI;
    private int height;
    private long sHf = 0;
    private int tUX = 0;
    private String tUY = "";
    private int tUZ = 0;
    private int width;

    private d$a() {
    }

    public static void dp(String str, int i) {
        try {
            if (!bi.oW(str) && i != 0) {
                d$a d_a = (d$a) tVa.get(str);
                if (d_a != null) {
                    d_a.dHI = i;
                }
                Set<String> hashSet = new HashSet();
                for (String str2 : tVa.keySet()) {
                    d$a d_a2 = (d$a) tVa.get(str2);
                    if (d_a2 != null) {
                        x.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[]{Long.valueOf(bi.bH(d_a2.sHf)), Integer.valueOf(d_a2.dHI), Integer.valueOf(d_a2.width), Integer.valueOf(d_a2.height), Integer.valueOf(d_a2.tUX), Integer.valueOf(d_a2.tUZ), d_a2.tUY, str2});
                        if (bi.bH(d_a2.sHf) >= 60000) {
                            if (d_a2.dHI > 0 && !bi.oW(d_a2.tUY)) {
                                h.mEJ.h(11713, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(d_a2.dHI), Integer.valueOf(d_a2.width), Integer.valueOf(d_a2.height), Integer.valueOf(d_a2.tUX), Integer.valueOf(d_a2.tUZ), d_a2.tUY});
                            }
                            hashSet.add(str2);
                        }
                    }
                }
                for (String str22 : hashSet) {
                    tVa.remove(str22);
                }
            }
        } catch (Throwable th) {
            x.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[]{bi.i(th)});
        }
    }

    public static void m(String str, int i, int i2, int i3) {
        try {
            if (!bi.oW(str) && i != 0 && i2 != 0) {
                d$a d_a = (d$a) tVa.get(str);
                if (d_a == null) {
                    d_a = new d$a();
                    d_a.sHf = bi.VF();
                    tVa.put(str, d_a);
                }
                d_a.height = i2;
                d_a.width = i;
                d_a.tUY += i3 + "|";
                if (i3 > 0) {
                    if (d_a.tUX == 0) {
                        d_a.tUX = i3;
                    }
                } else if (d_a.tUX != 0) {
                    d_a.tUZ++;
                    d_a.tUX = 0;
                }
                x.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(d_a.tUX), Integer.valueOf(d_a.tUZ), d_a.tUY, str});
            }
        } catch (Throwable th) {
            x.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[]{bi.i(th)});
        }
    }
}
