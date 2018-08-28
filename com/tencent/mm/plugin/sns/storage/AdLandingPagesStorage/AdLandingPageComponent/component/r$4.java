package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

class r$4 implements a {
    final /* synthetic */ r nFh;

    r$4(r rVar) {
        this.nFh = rVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        if (this.nFh.jBN.getVisibility() == 0) {
            this.nFh.jBN.setImageBitmap(MMBitmapFactory.decodeFile(str));
        }
    }
}
