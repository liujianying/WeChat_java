package com.tencent.mm.plugin.game.ui;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class w implements OnTouchListener {
    private int pN;

    public w() {
        this(Color.argb(TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS, 136, 136, 136));
    }

    private w(int i) {
        this.pN = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Drawable drawable;
        if (action == 0) {
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(this.pN, Mode.MULTIPLY);
                    imageView.setImageDrawable(drawable);
                }
            } else if (view.getBackground() != null) {
                view.getBackground().setColorFilter(this.pN, Mode.MULTIPLY);
            }
        } else if (action == 1 || action == 3) {
            if (view instanceof ImageView) {
                drawable = ((ImageView) view).getDrawable();
                if (drawable != null) {
                    drawable.clearColorFilter();
                }
            } else {
                drawable = view.getBackground();
                if (drawable != null) {
                    drawable.clearColorFilter();
                }
            }
        }
        return false;
    }
}
