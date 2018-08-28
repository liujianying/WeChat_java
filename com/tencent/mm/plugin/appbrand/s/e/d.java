package com.tencent.mm.plugin.appbrand.s.e;

import com.tencent.mm.sdk.platformtools.x;

public final class d extends g implements b {
    private String gDb = "*";

    public final void vY(String str) {
        if (str == null) {
            x.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
        } else {
            this.gDb = str;
        }
    }

    public final String aoO() {
        return this.gDb;
    }
}
