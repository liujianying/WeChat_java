package com.tencent.mm.plugin.qqmail.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

class EmbedWebView$1 extends SimpleOnGestureListener {
    final /* synthetic */ EmbedWebView mgi;

    EmbedWebView$1(EmbedWebView embedWebView) {
        this.mgi = embedWebView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        EmbedWebView embedWebView = this.mgi;
        x.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + embedWebView.getScale());
        int i = 10;
        while (embedWebView.getScale() != 1.0f) {
            i--;
            if (i <= 0) {
                break;
            } else if (embedWebView.getScale() > 1.0f) {
                embedWebView.zoomOut();
            } else {
                embedWebView.zoomIn();
            }
        }
        x.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + this.mgi.getScale());
        return true;
    }
}
