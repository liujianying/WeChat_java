package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnLongClickListener;

class MMViewPager$3 implements OnLongClickListener {
    final /* synthetic */ MMViewPager tyS;

    MMViewPager$3(MMViewPager mMViewPager) {
        this.tyS = mMViewPager;
    }

    public final boolean onLongClick(View view) {
        if (MMViewPager.p(this.tyS) != null) {
            MMViewPager.p(this.tyS).aMl();
        }
        return true;
    }
}
