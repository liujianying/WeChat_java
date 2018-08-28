package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements AnimationListener {
    final /* synthetic */ b nHy;

    b$4(b bVar) {
        this.nHy = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        if (b.j(this.nHy)) {
            animation.cancel();
            this.nHy.bAv();
            return;
        }
        x.d("ContentFragment", "onAnimationStart show nextBtn");
        b.a(this.nHy).nHK = true;
    }

    public final void onAnimationEnd(Animation animation) {
        new ag().postDelayed(new 1(this), 200);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
