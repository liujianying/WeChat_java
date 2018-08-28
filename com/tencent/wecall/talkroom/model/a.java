package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public class a {
    private static a vwV = null;
    private f vwW = null;

    public static a cHt() {
        if (vwV == null) {
            synchronized (a.class) {
                if (vwV == null) {
                    vwV = new a();
                }
            }
        }
        return vwV;
    }

    public static f cHu() {
        a cHt = cHt();
        if (cHt.vwW == null) {
            synchronized (a.class) {
                if (cHt.vwW == null) {
                    cHt.vwW = new f();
                }
            }
        }
        return cHt.vwW;
    }

    public static void cHv() {
        c.d("MicroMsg.Voip", new Object[]{"registerEvents"});
        cHu();
    }
}
