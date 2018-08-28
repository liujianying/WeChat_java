package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ah;

class r$7 implements OnClickListener {
    final /* synthetic */ r nFh;

    r$7(r rVar) {
        this.nFh = rVar;
    }

    public final void onClick(View view) {
        r.a(this.nFh);
        this.nFh.nEP = false;
        this.nFh.nEM = true;
        this.nFh.nEW = 3;
        this.nFh.bzC();
        this.nFh.ik(true);
        ah.i(new 1(this), 10000);
    }
}
