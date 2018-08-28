package com.tencent.mm.plugin.fts.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSBaseUI$1 implements OnTouchListener {
    final /* synthetic */ FTSBaseUI jwn;

    FTSBaseUI$1(FTSBaseUI fTSBaseUI) {
        this.jwn = fTSBaseUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FTSBaseUI.a(this.jwn).getFtsEditText().jzo.clearFocus();
        this.jwn.YC();
        return false;
    }
}
