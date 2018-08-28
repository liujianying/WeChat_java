package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class l$5 implements OnDismissListener {
    final /* synthetic */ l nDI;

    l$5(l lVar) {
        this.nDI = lVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ad.ef(this.nDI.context);
    }
}
