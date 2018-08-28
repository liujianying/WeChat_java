package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.bu.a;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.z.c.4;
import com.tencent.mm.sdk.platformtools.x;

class z$c$4$1 implements b {
    final /* synthetic */ Bundle pRE;
    final /* synthetic */ 4 pRF;

    z$c$4$1(4 4, Bundle bundle) {
        this.pRF = 4;
        this.pRE = bundle;
    }

    public final void hj(int i) {
        x.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[]{Integer.valueOf(i)});
        a.ab(new 1(this, i));
    }
}
