package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.119.1;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.d.a;
import com.tencent.mm.sdk.platformtools.x;

class g$119$1$1 implements a {
    final /* synthetic */ 1 qkd;

    g$119$1$1(1 1) {
        this.qkd = 1;
    }

    public final void r(boolean z, boolean z2) {
        x.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            this.qkd.qkc.qiK.a(this.qkd.qkc.qiH, "launchApplication:ok", null);
        } else {
            this.qkd.qkc.qiK.a(this.qkd.qkc.qiH, "launchApplication:fail", null);
        }
    }
}
