package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager.e;

class b$2 implements e {
    final /* synthetic */ b iRW;

    b$2(b bVar) {
        this.iRW = bVar;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        if (this.iRW.vp.getParent() != null) {
            this.iRW.vp.getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    public final void N(int i) {
    }
}
