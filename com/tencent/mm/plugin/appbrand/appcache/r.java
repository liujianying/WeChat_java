package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.bi;

public final class r {
    private final String appId;
    private final String fgp;
    private volatile String fgq;

    public r(String str, String str2) {
        this.appId = str;
        if (bi.oW(str2) || "__APP__".equals(str2)) {
            this.fgp = str2;
        } else {
            this.fgp = a.qC(str2);
        }
    }

    public r(String str) {
        this.appId = str;
        this.fgp = null;
    }

    public final String toString() {
        if (bi.oW(this.fgq)) {
            this.fgq = this.appId + (bi.oW(this.fgp) ? "" : "$" + this.fgp);
        }
        return this.fgq;
    }
}
