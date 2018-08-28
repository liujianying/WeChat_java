package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsUserUI$15 implements Runnable {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$15(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
    }

    public final void run() {
        if (SnsUserUI.j(this.ohd)) {
            x.w("MicroMsg.SnsUserUI", "too fast that it finish");
            return;
        }
        SnsUserUI.b(this.ohd).a(SnsUserUI.k(this.ohd).getType(), SnsUserUI.c(this.ohd), this.ohd);
        if (SnsUserUI.k(this.ohd).getType() == 1 && SnsUserUI.k(this.ohd).bEd()) {
            af.bye().z(af.byv().nro, -1);
        }
        if (!SnsUserUI.k(this.ohd).bEd()) {
            a b = SnsUserUI.b(this.ohd);
            int type = SnsUserUI.k(this.ohd).getType();
            String c = SnsUserUI.c(this.ohd);
            SnsUserUI.d(this.ohd);
            b.a(type, c, SnsUserUI.f(this.ohd), SnsUserUI.e(this.ohd));
        }
    }
}
