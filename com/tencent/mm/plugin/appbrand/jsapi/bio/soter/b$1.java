package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class b$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ b fKY;

    b$1(b bVar, l lVar, int i) {
        this.fKY = bVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        Bundle bundle = null;
        if (i != 1000) {
            return;
        }
        b bVar;
        l lVar;
        int i3;
        if (i2 == -1) {
            x.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
            bVar = this.fKY;
            lVar = this.fCl;
            i3 = this.doP;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            b.a(bVar, lVar, i3, bundle, "ok");
        } else if (i2 == 1) {
            x.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
            bVar = this.fKY;
            lVar = this.fCl;
            i3 = this.doP;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            b.a(bVar, lVar, i3, bundle, "fail");
        } else {
            x.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
            bVar = this.fKY;
            lVar = this.fCl;
            i3 = this.doP;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            b.a(bVar, lVar, i3, bundle, "cancel");
        }
    }
}
