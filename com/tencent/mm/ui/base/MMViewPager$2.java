package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class MMViewPager$2 implements OnTouchListener {
    final /* synthetic */ MMViewPager tyS;

    MMViewPager$2(MMViewPager mMViewPager) {
        this.tyS = mMViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouch;
        x.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", new Object[]{Integer.valueOf(this.tyS.getCurrentItem())});
        if (MMViewPager.k(this.tyS) != null) {
            onTouch = MMViewPager.k(this.tyS).onTouch(view, motionEvent);
        } else {
            onTouch = false;
        }
        MMViewPager.a(this.tyS, false);
        g g = MMViewPager.g(this.tyS);
        if (g == null) {
            MMViewPager.a(this.tyS, false);
            MMViewPager.a(this.tyS, motionEvent);
            MMViewPager.b(this.tyS, null);
            MMViewPager.l(this.tyS).onTouchEvent(motionEvent);
            return (MMViewPager.m(this.tyS) || MMViewPager.n(this.tyS)) ? true : onTouch;
        } else {
            MMViewPager.a(this.tyS, g);
            if (MMViewPager.a(this.tyS) != null && (MMViewPager.a(this.tyS) instanceof MultiTouchImageView)) {
                MMViewPager.a(this.tyS, false);
            } else if (MMViewPager.a(this.tyS) != null && (MMViewPager.a(this.tyS) instanceof WxImageView)) {
                MMViewPager.a(this.tyS, true);
            }
            boolean a = MMViewPager.a(this.tyS, MMViewPager.a(this.tyS), motionEvent);
            if (MMViewPager.o(this.tyS) != null) {
                MMViewPager.o(this.tyS).recycle();
            }
            MMViewPager.b(this.tyS, MotionEvent.obtainNoHistory(motionEvent));
            MMViewPager.l(this.tyS).onTouchEvent(motionEvent);
            this.tyS.computeScroll();
            if (a || onTouch) {
                return true;
            }
            return false;
        }
    }
}
