package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.7;
import com.tencent.mm.sdk.platformtools.x;

class b$7$1 implements OnPreDrawListener {
    final /* synthetic */ 7 nHG;

    b$7$1(7 7) {
        this.nHG = 7;
    }

    public final boolean onPreDraw() {
        if (b.a(this.nHG.nHy).nHL.getHeight() > 0) {
            b.a(this.nHG.nHy).nHL.getViewTreeObserver().removeOnPreDrawListener(this);
            b.b(this.nHG.nHy, b.a(this.nHG.nHy).nHL.getHeight());
            if (b.n(this.nHG.nHy) < b.f(this.nHG.nHy)) {
                b.b(this.nHG.nHy, b.f(this.nHG.nHy));
            }
            LayoutParams layoutParams = (LayoutParams) b.a(this.nHG.nHy).nHI.getLayoutParams();
            layoutParams.height = b.n(this.nHG.nHy);
            b.a(this.nHG.nHy).nHI.setLayoutParams(layoutParams);
            x.i("ContentFragment", "set bgIV height " + b.a(this.nHG.nHy).nHL.getHeight() + ", count " + b.a(this.nHG.nHy).nHL.getChildCount());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.a(this.nHG.nHy).nHL.getChildCount()) {
                    break;
                }
                Object tag = b.a(this.nHG.nHy).nHL.getChildAt(i2).getTag();
                if (tag instanceof i) {
                    ((i) tag).bzz();
                }
                i = i2 + 1;
            }
            b.a(this.nHG.nHy).nHL.removeAllViews();
            b.a(this.nHG.nHy).nHL.setVisibility(8);
        }
        return true;
    }
}
