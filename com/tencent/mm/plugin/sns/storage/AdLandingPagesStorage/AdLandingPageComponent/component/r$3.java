package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;

class r$3 implements ac {
    final /* synthetic */ r nFh;
    final /* synthetic */ Context val$context;

    r$3(r rVar, Context context) {
        this.nFh = rVar;
        this.val$context = context;
    }

    public final void il(boolean z) {
        Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        intent.putExtra("show", z ? 1 : 0);
        d.O(this.val$context).a(intent);
    }
}
