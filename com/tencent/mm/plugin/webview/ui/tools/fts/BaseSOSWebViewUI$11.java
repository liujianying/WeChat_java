package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class BaseSOSWebViewUI$11 implements OnTouchListener {
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$11(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.qdp.bXk().getEditText().clearFocus();
        this.qdp.YC();
        return false;
    }
}
