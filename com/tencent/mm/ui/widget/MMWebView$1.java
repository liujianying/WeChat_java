package com.tencent.mm.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.smtt.sdk.WebView;

class MMWebView$1 implements OnTouchListener {
    final /* synthetic */ MMWebView uHt;

    MMWebView$1(MMWebView mMWebView) {
        this.uHt = mMWebView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.uHt.getIsX5Kernel()) {
            switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                case 0:
                case 2:
                    MMWebView.c(this.uHt).requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                case 3:
                    MMWebView.c(this.uHt).requestDisallowInterceptTouchEvent(false);
                    break;
                default:
                    MMWebView.c(this.uHt).requestDisallowInterceptTouchEvent(true);
                    break;
            }
        }
        if (MMWebView.d(this.uHt) != null) {
            return MMWebView.d(this.uHt).onTouch(view, motionEvent);
        }
        return false;
    }
}
