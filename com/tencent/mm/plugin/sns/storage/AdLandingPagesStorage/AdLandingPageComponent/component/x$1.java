package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;

class x$1 implements ac {
    final /* synthetic */ x nFL;
    final /* synthetic */ Context val$context;

    x$1(x xVar, Context context) {
        this.nFL = xVar;
        this.val$context = context;
    }

    public final void il(boolean z) {
        Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        intent.putExtra("show", z ? 1 : 0);
        d.O(this.val$context).a(intent);
    }
}
