package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class MaskLinearLayout$2 implements OnTouchListener {
    final /* synthetic */ MaskLinearLayout nOM;

    MaskLinearLayout$2(MaskLinearLayout maskLinearLayout) {
        this.nOM = maskLinearLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        x.e("test", "touch: " + motionEvent.getAction());
        if (MaskLinearLayout.b(this.nOM)) {
            switch (motionEvent.getAction()) {
                case 0:
                    view.setPressed(true);
                    MaskLinearLayout.a(this.nOM);
                    view.invalidate();
                    MaskLinearLayout.d(this.nOM).removeCallbacks(MaskLinearLayout.c(this.nOM));
                    break;
                case 1:
                case 3:
                    MaskLinearLayout.d(this.nOM).post(MaskLinearLayout.c(this.nOM));
                    break;
            }
            if (MaskLinearLayout.e(this.nOM) != null) {
                for (MaskImageView maskImageView : MaskLinearLayout.e(this.nOM)) {
                    maskImageView.d(maskImageView, motionEvent);
                }
            }
        }
        return false;
    }
}
