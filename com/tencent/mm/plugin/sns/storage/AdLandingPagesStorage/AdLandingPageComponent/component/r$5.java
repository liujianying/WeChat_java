package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class r$5 implements OnClickListener {
    final /* synthetic */ r nFh;

    r$5(r rVar) {
        this.nFh = rVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[]{Boolean.valueOf(this.nFh.nEF.isPlaying())});
        if (this.nFh.nEF.isPlaying()) {
            this.nFh.bAf();
            this.nFh.nEW = 4;
        } else {
            if (this.nFh.nEO) {
                this.nFh.bzy();
            } else {
                this.nFh.bzD();
                this.nFh.bzC();
            }
            r.a(this.nFh);
            this.nFh.nEW = 3;
        }
        if (this.nFh.nzR) {
            r rVar = this.nFh;
            rVar.nFa++;
        }
    }
}
