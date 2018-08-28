package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.support.v4.view.ViewPager.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a;

class o$1 implements e {
    final /* synthetic */ a nEp;
    final /* synthetic */ o nEq;

    o$1(o oVar, a aVar) {
        this.nEq = oVar;
        this.nEp = aVar;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        this.nEq.nEl.setPage(i);
        o.a(this.nEq, i);
        if (this.nEq.nDw) {
            this.nEp.wN(i);
            this.nEp.wO(i);
        }
    }

    public final void N(int i) {
    }
}
