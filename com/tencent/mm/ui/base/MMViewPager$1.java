package com.tencent.mm.ui.base;

import android.support.v4.view.ViewPager.e;

class MMViewPager$1 implements e {
    final /* synthetic */ MMViewPager tyS;

    MMViewPager$1(MMViewPager mMViewPager) {
        this.tyS = mMViewPager;
    }

    public final void O(int i) {
        MMViewPager.a(this.tyS, MMViewPager.e(this.tyS));
        MMViewPager.b(this.tyS, i);
        if (MMViewPager.f(this.tyS) != null) {
            MMViewPager.f(this.tyS).O(i);
        }
        g g = MMViewPager.g(this.tyS);
        if (g == null || !(g instanceof WxImageView)) {
            MMViewPager.a(this.tyS, false);
            MMViewPager.i(this.tyS);
            return;
        }
        MMViewPager.a(this.tyS, true);
        MMViewPager.h(this.tyS);
    }

    public final void a(int i, float f, int i2) {
        if (MMViewPager.f(this.tyS) != null) {
            MMViewPager.f(this.tyS).a(i, f, i2);
        }
        MMViewPager.a(this.tyS, f);
        if (i2 == 0 && MMViewPager.j(this.tyS) != -1) {
            MMViewPager.c(this.tyS, MMViewPager.j(this.tyS));
        }
    }

    public final void N(int i) {
        if (MMViewPager.f(this.tyS) != null) {
            MMViewPager.f(this.tyS).N(i);
        }
        if (i == 0) {
            MMViewPager.a(this.tyS, 0.0f);
        }
    }
}
