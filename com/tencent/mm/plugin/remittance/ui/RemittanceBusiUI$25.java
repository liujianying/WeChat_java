package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class RemittanceBusiUI$25 implements OnTouchListener {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$25(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (RemittanceBusiUI.p(this.mBt)) {
            this.mBt.Wq();
        }
        return false;
    }
}
