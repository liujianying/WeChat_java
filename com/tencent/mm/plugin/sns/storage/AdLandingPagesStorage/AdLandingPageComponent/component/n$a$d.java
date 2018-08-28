package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;

class n$a$d extends b {
    final /* synthetic */ a nEe;

    n$a$d(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b b = n.b(this.nEe.nDS);
        Object obj = (b.nzV == 0 || b.nzV == 2) ? 1 : null;
        if (obj != null) {
            this.nEe.b(this.nEe.nDW);
        } else {
            this.nEe.b(this.nEe.nEc);
        }
    }
}
