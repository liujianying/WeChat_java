package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MaskImageButton$2 implements OnTouchListener {
    final /* synthetic */ MaskImageButton uAM;

    MaskImageButton$2(MaskImageButton maskImageButton) {
        this.uAM = maskImageButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                MaskImageButton.b(this.uAM).removeCallbacks(MaskImageButton.a(this.uAM));
                break;
            case 1:
            case 3:
                MaskImageButton.b(this.uAM).post(MaskImageButton.a(this.uAM));
                break;
        }
        if (this.uAM.isClickable() || this.uAM.isLongClickable()) {
            return false;
        }
        return true;
    }
}
