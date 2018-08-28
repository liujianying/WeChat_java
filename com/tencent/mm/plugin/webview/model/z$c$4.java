package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.z.b;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.l.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class z$c$4 implements a {
    final /* synthetic */ String pRB;
    final /* synthetic */ Bundle pRC;
    final /* synthetic */ int pRD;
    final /* synthetic */ d pRa;
    final /* synthetic */ b pRx;
    final /* synthetic */ z.d pRy;
    final /* synthetic */ Context val$context;

    public z$c$4(Context context, String str, z.d dVar, Bundle bundle, d dVar2, b bVar, int i) {
        this.val$context = context;
        this.pRB = str;
        this.pRy = dVar;
        this.pRC = bundle;
        this.pRa = dVar2;
        this.pRx = bVar;
        this.pRD = i;
    }

    public final void f(int i, Bundle bundle) {
        x.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                c.a(this.val$context, com.tencent.mm.model.gdpr.a.dEd, this.pRB, new 1(this, bundle));
                return;
            case 2:
            case 3:
                Bundle bundle2 = this.pRC;
                z.d dVar = this.pRy;
                d dVar2 = this.pRa;
                b bVar = this.pRx;
                int i2 = this.pRD;
                x.i("MicroMsg.OauthAuthorizeLogic", "doRejectLogic");
                z.c.a(dVar2, bundle2.getString("oauth_url"), 2, bundle == null ? new ArrayList() : (ArrayList) bundle.getSerializable("key_scope"), bVar, false, i2);
                dVar.goBack();
                return;
            default:
                this.pRy.goBack();
                return;
        }
    }
}
