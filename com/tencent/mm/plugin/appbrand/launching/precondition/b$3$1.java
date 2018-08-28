package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.b.3;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class b$3$1 implements a {
    final /* synthetic */ 3 ghu;

    b$3$1(3 3) {
        this.ghu = 3;
    }

    public final void d(final AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (!this.ghu.ghq.isFinishing()) {
            if (appBrandInitConfig == null) {
                this.ghu.ghq.finish();
                return;
            }
            this.ghu.ght.a(appBrandInitConfig);
            b.a(this.ghu.ghq, appBrandInitConfig);
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    b$3$1.this.ghu.ghq.e(appBrandInitConfig, b$3$1.this.ghu.ght.ghm);
                }
            };
            if (c.Jm()) {
                c.a(this.ghu.ghq.getBaseContext(), com.tencent.mm.model.gdpr.a.dEb, appBrandInitConfig.appId, new 2(this, anonymousClass1));
            } else if (this.ghu.ghq.b(appBrandInitConfig)) {
                b.a(this.ghu.ghq, anonymousClass1);
            } else {
                anonymousClass1.run();
            }
        }
    }
}
