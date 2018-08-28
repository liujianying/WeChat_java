package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

final class c {
    al dHa = new al(new 1(this), false);
    d gcO;
    p jnR;
    boolean pVP = false;
    boolean pVQ = false;
    final a pVR;
    OAuthUI pVS;

    private c(OAuthUI oAuthUI, a aVar, d dVar) {
        this.pVS = oAuthUI;
        this.pVR = aVar;
        this.gcO = dVar;
    }

    public static c a(OAuthUI oAuthUI, String str, Req req, a aVar, d dVar) {
        c cVar = new c(oAuthUI, aVar, dVar);
        String str2 = req.scope;
        String str3 = req.state;
        if (cVar.pVP) {
            x.e("MicroMsg.OAuthSession", "already getting");
        } else {
            cVar.pVQ = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                cVar.gcO.s(233, bundle);
                cVar.pVP = true;
            } catch (Exception e) {
                x.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            cVar.dHa.J(3000, 3000);
        }
        return cVar;
    }
}
