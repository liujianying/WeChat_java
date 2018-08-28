package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.3;
import com.tencent.mm.sdk.platformtools.x;

class b$3$1 implements Runnable {
    final /* synthetic */ Bitmap nHA;
    final /* synthetic */ 3 nHB;

    b$3$1(3 3, Bitmap bitmap) {
        this.nHB = 3;
        this.nHA = bitmap;
    }

    public final void run() {
        if (this.nHA == null) {
            x.i("ContentFragment", "decode img fail, set bg color %s", this.nHB.fYF);
            b.h(this.nHB.nHy);
            return;
        }
        x.i("ContentFragment", "set bg with bitmap");
        b.i(this.nHB.nHy).put(this.nHB.fYF, this.nHA);
        b.a(this.nHB.nHy, this.nHA);
    }
}
