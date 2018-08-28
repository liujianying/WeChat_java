package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.u.c.g;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class a {
    private static volatile g fwP;
    private static volatile g fwQ;

    public static g kd(int i) {
        if (i == 1) {
            return afn();
        }
        return afm();
    }

    private static g afm() {
        if (fwP == null) {
            synchronized (a.class) {
                if (fwP == null) {
                    g gVar = new g();
                    gVar.a(new b(TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY));
                    gVar.a(new c(TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER));
                    gVar.a(new d(TbsListener$ErrorCode.ERROR_CANLOADX5_RETURN_NULL));
                    gVar.a(new f());
                    gVar.a(new g());
                    fwP = gVar;
                }
            }
        }
        return fwP;
    }

    private static g afn() {
        if (fwQ == null) {
            synchronized (a.class) {
                if (fwQ == null) {
                    g gVar = new g();
                    gVar.a(new b(262));
                    gVar.a(new c(263));
                    gVar.a(new d(268));
                    gVar.a(new f());
                    gVar.a(new g());
                    gVar.a(new e((byte) 0));
                    fwQ = gVar;
                }
            }
        }
        return fwQ;
    }
}
