package com.tencent.mm.e.b;

import android.os.Build;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class g$b {
    private static boolean bEI;
    private static boolean bEJ;

    static {
        bEI = false;
        bEJ = false;
        int zj = m.zj();
        x.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[]{Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(zj)});
        if (!bi.oW(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !bi.oW(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
            x.i("MicroMsg.RecorderUtil", "don't contains armeabi");
            k.b("wechatvoicesilk_v5", g.class.getClassLoader());
            bEI = true;
            bEJ = false;
        } else if ((zj & 1024) != 0) {
            try {
                k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
                bEI = true;
                bEJ = true;
            } catch (UnsatisfiedLinkError e) {
                x.e("MicroMsg.RecorderUtil", "load library failed!");
                bEI = false;
                bEJ = false;
            }
        } else if ((zj & 512) != 0) {
            k.b("wechatvoicesilk", g.class.getClassLoader());
            bEI = true;
            bEJ = true;
        } else {
            k.b("wechatvoicesilk_v5", g.class.getClassLoader());
            bEI = true;
            bEJ = false;
        }
        x.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[]{Boolean.valueOf(bEI), Boolean.valueOf(bEJ)});
    }

    public static boolean ws() {
        return bEJ;
    }
}
