package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.k;

class a$k$2 implements Runnable {
    final /* synthetic */ View eHJ;
    final /* synthetic */ k nGI;
    final /* synthetic */ Bitmap ndf;

    a$k$2(k kVar, View view, Bitmap bitmap) {
        this.nGI = kVar;
        this.eHJ = view;
        this.ndf = bitmap;
    }

    public final void run() {
        this.eHJ.setBackgroundDrawable(new BitmapDrawable(this.ndf));
    }
}
