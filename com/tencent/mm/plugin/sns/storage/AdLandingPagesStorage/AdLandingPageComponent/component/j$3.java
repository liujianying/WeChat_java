package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j nDE;
    final /* synthetic */ ImageView nDF;

    j$3(j jVar, ImageView imageView) {
        this.nDE = jVar;
        this.nDF = imageView;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        try {
            this.nDF.setImageBitmap(BitmapFactory.decodeFile(str));
            this.nDF.setVisibility(0);
        } catch (Throwable e) {
            x.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bi.i(e));
        }
    }
}
