package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.mm.protocal.c.amg;

public class a {
    private static volatile a kji = null;
    private amg kjj = null;

    private a() {
    }

    public static a aVS() {
        if (kji != null) {
            return kji;
        }
        a aVar;
        synchronized (a.class) {
            if (kji == null) {
                kji = new a();
            }
            aVar = kji;
        }
        return aVar;
    }

    public final amg aVT() {
        if (this.kjj == null) {
            this.kjj = new amg();
        }
        return this.kjj;
    }
}
