package com.tencent.xweb.sys;

import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.tencent.xweb.o;

class e$a extends WebView {
    public o gcI;
    final /* synthetic */ e vDj;

    public e$a(e eVar, Context context) {
        this.vDj = eVar;
        super(context);
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.vDj.vCX != null) {
            this.vDj.vCX.onWebViewScrollChanged(i, i2, i3, i4);
        }
        if (this.gcI != null) {
            this.gcI.onScrollChanged(i, i2, i3, i4, this);
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4 || !this.vDj.hasEnteredFullscreen()) {
            return false;
        }
        this.vDj.leaveFullscreen();
        return true;
    }
}
