package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.mogic.WxViewPager;

public class CustomViewPager extends WxViewPager {
    private boolean Bk = true;
    private boolean tsp = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanSlide(boolean z) {
        this.Bk = z;
    }

    public void setCanSlideBySide(boolean z) {
        this.tsp = z;
    }

    protected final boolean S(float f, float f2) {
        if (this.tsp) {
            return super.S(f, f2);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Bk) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.Bk) {
            return z;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CustomViewPager", e, "get a Exception", new Object[z]);
            return z;
        }
    }
}
