package com.tencent.mm.plugin.shake.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ShakeItemListUI$7 implements OnTouchListener {
    final /* synthetic */ ShakeItemListUI mZA;

    ShakeItemListUI$7(ShakeItemListUI shakeItemListUI) {
        this.mZA = shakeItemListUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (ShakeItemListUI.b(this.mZA) != null) {
            ShakeItemListUI$a b = ShakeItemListUI.b(this.mZA);
            if (b.eKg != null) {
                b.eKg.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
