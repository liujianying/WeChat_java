package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class c$1 implements a {
    final /* synthetic */ c pVT;

    c$1(c cVar) {
        this.pVT = cVar;
    }

    public final boolean vD() {
        if (this.pVT.pVS.isFinishing()) {
            x.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
        } else {
            c cVar = this.pVT;
            OAuthUI oAuthUI = this.pVT.pVS;
            this.pVT.pVS.getString(R.l.app_tip);
            cVar.jnR = h.a(oAuthUI, this.pVT.pVS.getString(R.l.app_waiting), true, new 1(this));
        }
        return false;
    }
}
