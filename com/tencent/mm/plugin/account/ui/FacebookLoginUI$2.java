package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

class FacebookLoginUI$2 implements a {
    final /* synthetic */ FacebookLoginUI eQv;

    FacebookLoginUI$2(FacebookLoginUI facebookLoginUI) {
        this.eQv = facebookLoginUI;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            c Lr = eVar.Lr();
            byte[] bArr = new byte[0];
            g.Eg();
            Lr.x(bArr, com.tencent.mm.kernel.a.Df());
        }
    }
}
