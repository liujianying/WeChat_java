package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.x;

class n$a$c$a implements a {
    final /* synthetic */ c nEg;

    private n$a$c$a(c cVar) {
        this.nEg = cVar;
    }

    public final void start() {
    }

    public final void wo(int i) {
        d a = n.a(this.nEg.nEe.nDS);
        d.c cVar = a.sJQ;
        if (cVar != null) {
            cVar.sendMessage(Message.obtain(a.sJQ, 1, i, 0));
        }
    }

    public final void bxj() {
        x.i("LogStateTransitionState", "paused");
        n.a(this.nEg.nEe.nDS).Dd(7);
    }

    public final void bxk() {
    }

    public final void bxl() {
        n.a(this.nEg.nEe.nDS).Dd(9);
    }

    public final void bxm() {
        n.a(this.nEg.nEe.nDS).Dd(8);
    }

    public final void bxn() {
    }
}
