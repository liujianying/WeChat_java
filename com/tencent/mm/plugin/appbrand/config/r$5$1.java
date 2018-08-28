package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.r.5;
import com.tencent.mm.plugin.appbrand.config.r.a;
import com.tencent.mm.sdk.platformtools.bi;

class r$5$1 implements a<WxaAttributes> {
    final /* synthetic */ 5 frK;

    r$5$1(5 5) {
        this.frK = 5;
    }

    public final /* synthetic */ boolean bh(Object obj) {
        return bi.oW(((WxaAttributes) obj).field_versionInfo);
    }

    public final /* synthetic */ Object sh(String str) {
        return e.aba().e(str, new String[0]);
    }

    public final String getUsername() {
        return this.frK.dhF;
    }

    public final l sg(String str) {
        return new l(str, null);
    }
}
