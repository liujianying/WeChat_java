package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.i;
import android.support.v4.b.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WelabRoundCornerImageView extends ImageView {
    private float qns;

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCornerRadiusPercent(float f) {
        this.qns = f;
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
        } else if (this.qns <= 0.0f) {
            super.setImageBitmap(bitmap);
        } else {
            i a = k.a(getResources(), bitmap);
            float min = Math.min(((float) bitmap.getWidth()) * this.qns, ((float) bitmap.getHeight()) * this.qns);
            if (a.go != min) {
                a.rG = false;
                if (i.r(min)) {
                    a.cN.setShader(a.rB);
                } else {
                    a.cN.setShader(null);
                }
                a.go = min;
                a.invalidateSelf();
            }
            super.setImageDrawable(a);
        }
    }

    public Bitmap getDisplayingBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof i)) {
            return null;
        }
        return ((i) drawable).mBitmap;
    }
}
