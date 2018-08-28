package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.b.3.1;
import com.tencent.mm.plugin.appbrand.s.j;

class b$3$1$2 implements b {
    final /* synthetic */ 1 ghv;
    final /* synthetic */ Runnable ghw;

    b$3$1$2(1 1, Runnable runnable) {
        this.ghv = 1;
        this.ghw = runnable;
    }

    public final void hj(int i) {
        if (i == 0) {
            this.ghw.run();
            return;
        }
        a.a(this.ghv.ghu.ghq.getBaseContext(), this.ghv.ghu.ghq.getBaseContext().getString(j.appbrand_gdpr_deny_alert_message), this.ghv.ghu.ghq.getBaseContext().getString(j.appbrand_gdpr_deny_alert_title), this.ghv.ghu.ghq.getBaseContext().getString(j.app_ok), null, null, null, null);
        this.ghv.ghu.ghq.finish();
    }
}
