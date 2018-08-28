package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;

final class a$a extends FrameLayout {
    private static final int SIZE = (b.qbo / 2);
    static final int qbg;
    static final float qbh;
    View FU = findViewById(R.h.content);
    Vibrator hXL;
    ImageView iDX = ((ImageView) findViewById(R.h.bg));

    static {
        int i = b.qbp / 2;
        qbg = i;
        qbh = ((float) i) / ((float) SIZE);
    }

    public a$a(Context context) {
        super(context);
        this.hXL = (Vibrator) context.getSystemService("vibrator");
        LayoutInflater.from(context).inflate(R.i.webview_bag_canceller, this);
    }

    final void R(float f, float f2) {
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 1.0f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(50);
        this.iDX.startAnimation(scaleAnimation);
    }
}
