package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSBaseWebViewUI$1 implements OnTouchListener {
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$1(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.qdI.YC();
        return false;
    }
}
