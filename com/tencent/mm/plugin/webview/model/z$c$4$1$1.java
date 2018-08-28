package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.model.z.b;
import com.tencent.mm.plugin.webview.model.z.c;
import com.tencent.mm.plugin.webview.model.z.c.4.1;
import com.tencent.mm.plugin.webview.model.z.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class z$c$4$1$1 implements Runnable {
    final /* synthetic */ int oCo;
    final /* synthetic */ 1 pRG;

    z$c$4$1$1(1 1, int i) {
        this.pRG = 1;
        this.oCo = i;
    }

    public final void run() {
        if (this.oCo == 1) {
            this.pRG.pRF.pRy.goBack();
            return;
        }
        Bundle bundle = this.pRG.pRF.pRC;
        Bundle bundle2 = this.pRG.pRE;
        d dVar = this.pRG.pRF.pRy;
        com.tencent.mm.plugin.webview.stub.d dVar2 = this.pRG.pRF.pRa;
        b bVar = this.pRG.pRF.pRx;
        int i = this.pRG.pRF.pRD;
        x.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
        if (bundle.getBoolean("is_call_server_when_confirm")) {
            c.a(dVar2, bundle.getString("oauth_url"), 1, (ArrayList) bundle2.getSerializable("key_scope"), bVar, true, i);
            return;
        }
        dVar.Qk(bundle.getString("redirect_url"));
        x.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", new Object[]{r0});
    }
}
