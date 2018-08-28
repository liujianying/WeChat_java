package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.smtt.sdk.WebView;

class c$13 implements OnTouchListener {
    final /* synthetic */ c vCb;

    c$13(c cVar) {
        this.vCb = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!c.c(this.vCb)) {
            return false;
        }
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 1:
                c.a(this.vCb, 0);
                break;
            case 5:
                if (motionEvent.getPointerCount() == 2) {
                    c.a(this.vCb, 1);
                    break;
                }
                break;
            case 6:
                c.a(this.vCb, 0);
                break;
        }
        if (motionEvent.getAction() == 1 && c.d(this.vCb) == 3) {
            this.vCb.e((c.a(this.vCb) * ((double) c.e(this.vCb))) / 100.0d, true);
            c.b(this.vCb).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[]{Double.valueOf(r2)}), new 1(this));
            c.f(this.vCb);
        }
        if (c.g(this.vCb) == 1) {
            return c.h(this.vCb).onTouchEvent(motionEvent);
        }
        return c.i(this.vCb).onTouchEvent(motionEvent);
    }
}
