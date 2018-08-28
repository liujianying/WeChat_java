package com.tencent.mm.plugin.fts.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSBaseVoiceSearchUI$1 implements OnTouchListener {
    final /* synthetic */ FTSBaseVoiceSearchUI jwp;

    FTSBaseVoiceSearchUI$1(FTSBaseVoiceSearchUI fTSBaseVoiceSearchUI) {
        this.jwp = fTSBaseVoiceSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FTSBaseVoiceSearchUI.a(this.jwp).clearFocus();
        this.jwp.YC();
        return false;
    }
}
