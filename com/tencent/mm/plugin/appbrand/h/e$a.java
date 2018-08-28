package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.sdk.platformtools.x;

class e$a {
    public String appId;
    public String dzR;
    public int gkb;
    public a gkc;
    public long lastUpdateTime;

    private e$a() {
    }

    /* synthetic */ e$a(byte b) {
        this();
    }

    public final boolean alm() {
        if (this.gkb < 0) {
            return false;
        }
        if (this.gkb == 0) {
            if (aln() > 10000) {
                return true;
            }
            return false;
        } else if (aln() > ((long) this.gkb) * 1000) {
            return true;
        } else {
            return false;
        }
    }

    private long aln() {
        x.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.lastUpdateTime)});
        return System.currentTimeMillis() - this.lastUpdateTime;
    }
}
