package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;

class b$7 implements Runnable {
    final /* synthetic */ b nHy;

    b$7(b bVar) {
        this.nHy = bVar;
    }

    public final void run() {
        int i = 0;
        if (b.a(this.nHy) != null) {
            if ((b.d(this.nHy).nIh || !TextUtils.isEmpty(b.d(this.nHy).nIg)) && !b.l(this.nHy)) {
                b.m(this.nHy);
                b.a(this.nHy).nHL.setVisibility(0);
                b.a(this.nHy).nHI.setScaleType(ScaleType.CENTER_CROP);
                b.a(this.nHy).nHL.getViewTreeObserver().addOnPreDrawListener(new 1(this));
                a o = b.o(this.nHy);
                ViewGroup viewGroup = b.a(this.nHy).nHL;
                while (true) {
                    int i2 = i;
                    if (i2 < o.nHg.nIi.size()) {
                        i a = am.a(viewGroup.getContext(), (s) o.nHg.nIi.get(i2), viewGroup, o.bgColor);
                        if (a != null) {
                            if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                                ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                            }
                            a.getView().setTag(a);
                            viewGroup.addView(a.getView());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
