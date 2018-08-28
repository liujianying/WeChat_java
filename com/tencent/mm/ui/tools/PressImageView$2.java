package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PressImageView$2 implements OnTouchListener {
    final /* synthetic */ PressImageView uBj;

    PressImageView$2(PressImageView pressImageView) {
        this.uBj = pressImageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                PressImageView.b(this.uBj).removeCallbacks(PressImageView.a(this.uBj));
                break;
            case 1:
            case 3:
                PressImageView.b(this.uBj).post(PressImageView.a(this.uBj));
                break;
        }
        if (this.uBj.isClickable() || this.uBj.isLongClickable()) {
            return false;
        }
        return true;
    }
}
