package com.tencent.mm.plugin.webwx.ui;

import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebWXLogoutUI$9 extends c<rb> {
    final /* synthetic */ WebWXLogoutUI qmC;

    WebWXLogoutUI$9(WebWXLogoutUI webWXLogoutUI) {
        this.qmC = webWXLogoutUI;
        this.sFo = rb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rb rbVar = (rb) bVar;
        x.d("MicroMsg.WebWXLogoutUI", "status Notify function");
        if (rbVar.cbQ.bNI == 8) {
            this.qmC.finish();
        }
        return false;
    }
}
