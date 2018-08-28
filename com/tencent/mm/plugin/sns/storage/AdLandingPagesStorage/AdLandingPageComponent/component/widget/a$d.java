package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;

class a$d implements Runnable {
    final /* synthetic */ a nGD;

    private a$d(a aVar) {
        this.nGD = aVar;
    }

    /* synthetic */ a$d(a aVar, byte b) {
        this(aVar);
    }

    public final void run() {
        if (a.k(this.nGD).get() != null) {
            ((View) a.k(this.nGD).get()).startAnimation(a.l(this.nGD));
        }
    }
}
