package com.tencent.mm.plugin.voip.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VoipSmallIconButton$1 implements OnTouchListener {
    final /* synthetic */ VoipSmallIconButton oQO;

    VoipSmallIconButton$1(VoipSmallIconButton voipSmallIconButton) {
        this.oQO = voipSmallIconButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                VoipSmallIconButton.b(this.oQO).setImageDrawable(VoipSmallIconButton.a(this.oQO));
                VoipSmallIconButton.c(this.oQO).setTextColor(-855638017);
                break;
            case 1:
                VoipSmallIconButton.b(this.oQO).setImageDrawable(VoipSmallIconButton.d(this.oQO));
                VoipSmallIconButton.c(this.oQO).setTextColor(-1);
                break;
        }
        return false;
    }
}
