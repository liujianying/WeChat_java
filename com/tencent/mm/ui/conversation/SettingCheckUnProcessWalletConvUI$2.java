package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SettingCheckUnProcessWalletConvUI$2 implements OnTouchListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI urE;

    SettingCheckUnProcessWalletConvUI$2(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.urE = settingCheckUnProcessWalletConvUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.urE.YC();
                SettingCheckUnProcessWalletConvUI.a(this.urE)[0] = (int) motionEvent.getRawX();
                SettingCheckUnProcessWalletConvUI.a(this.urE)[1] = (int) motionEvent.getRawY();
                break;
        }
        return false;
    }
}
