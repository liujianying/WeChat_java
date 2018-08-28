package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.x;

class WxaScrollView$1 extends ScrollView {
    final /* synthetic */ WxaScrollView fPW;

    WxaScrollView$1(WxaScrollView wxaScrollView, Context context) {
        this.fPW = wxaScrollView;
        super(context);
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (WxaScrollView.a(this.fPW) != null) {
            WxaScrollView.a(this.fPW).h(this.fPW, i, i2);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        x.i("MicroMsg.WxaScrollView", "onTouchEvent:%d", new Object[]{Integer.valueOf(motionEvent.getAction())});
        switch (motionEvent.getAction()) {
            case 2:
                if (!WxaScrollView.b(this.fPW)) {
                    x.e("MicroMsg.WxaScrollView", "can not move");
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
