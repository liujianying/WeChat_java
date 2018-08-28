package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.bu.a;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.z.d;
import com.tencent.mm.sdk.platformtools.x;

class z$c$3 implements b {
    final /* synthetic */ d pRy;
    final /* synthetic */ String pRz;

    public z$c$3(d dVar, String str) {
        this.pRy = dVar;
        this.pRz = str;
    }

    public final void hj(int i) {
        x.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
        a.ab(new 1(this, i));
    }
}
