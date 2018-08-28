package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsUploadUI$11 implements OnTouchListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$11(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SnsUploadUI.b(this.ogU);
    }
}
