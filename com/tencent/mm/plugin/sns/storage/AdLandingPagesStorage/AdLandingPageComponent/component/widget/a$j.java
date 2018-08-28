package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.widget.TextView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

class a$j implements Runnable {
    final /* synthetic */ a nGD;

    private a$j(a aVar) {
        this.nGD = aVar;
    }

    /* synthetic */ a$j(a aVar, byte b) {
        this(aVar);
    }

    public final void run() {
        if (a.e(this.nGD) >= 0 && a.j(this.nGD) != null && a.j(this.nGD).get() != null) {
            ((TextView) a.j(this.nGD).get()).setText(SightVideoJNI.getVideoInfo(a.e(this.nGD)));
        }
    }
}
