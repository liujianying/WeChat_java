package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;

final class d$a extends FrameLayout {
    ImageView gER = ((ImageView) findViewById(R.h.icon));
    Vibrator hXL;
    private ImageView iDX = ((ImageView) findViewById(R.h.bg));
    a qbF;

    public d$a(Context context) {
        super(context);
        this.hXL = (Vibrator) context.getSystemService("vibrator");
        LayoutInflater.from(context).inflate(R.i.webview_bag_indicator, this);
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.qbF != null && configuration != null) {
            this.qbF.onChange(configuration.orientation == 2);
        }
    }

    final void R(float f, float f2) {
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(50);
        this.iDX.startAnimation(scaleAnimation);
    }
}
