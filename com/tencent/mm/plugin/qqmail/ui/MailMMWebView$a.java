package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

class MailMMWebView$a extends FrameLayout {
    final /* synthetic */ MailMMWebView mhG;

    public MailMMWebView$a(MailMMWebView mailMMWebView, Context context) {
        this.mhG = mailMMWebView;
        super(context);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!MailMMWebView.a(this.mhG) && !MailMMWebView.b(this.mhG)) {
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case 1:
            case 3:
                MailMMWebView.c(this.mhG);
                MailMMWebView.d(this.mhG);
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this == MailMMWebView.e(this.mhG) && this.mhG.getTitleHeight() > 0) {
            this.mhG.bpd();
        } else if (this == MailMMWebView.f(this.mhG) && this.mhG.getBottomHeight() > 0) {
            this.mhG.bpe();
        }
    }
}
