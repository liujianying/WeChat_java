package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.AlphaAnimation;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements d$a {
    final /* synthetic */ AlphaAnimation nHD;
    final /* synthetic */ b nHy;

    b$5(b bVar, AlphaAnimation alphaAnimation) {
        this.nHy = bVar;
        this.nHD = alphaAnimation;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.d("ContentFragment", "onDownloadError show nextBtn");
        b.a(this.nHy).nHJ.setVisibility(0);
        b.a(this.nHy).nHJ.startAnimation(this.nHD);
    }

    public final void MX(String str) {
        x.d("ContentFragment", "onDownloaded show nextBtn");
        b.a(this.nHy, str, b.a(this.nHy).nHJ);
        b.a(this.nHy).nHJ.setVisibility(0);
        b.a(this.nHy).nHJ.startAnimation(this.nHD);
    }
}
