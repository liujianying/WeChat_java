package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;

public class BottleImageView extends ImageView {
    int Om;
    int On;
    int Oo;
    int Op;
    Context context;
    private int hlh;
    private int hli;
    Animation hlj = new 1(this);

    public BottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        aup();
    }

    public BottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aup();
    }

    private void aup() {
        Drawable background = getBackground();
        if (background != null) {
            this.hlh = background.getIntrinsicWidth();
            this.hli = background.getIntrinsicHeight();
        }
    }
}
