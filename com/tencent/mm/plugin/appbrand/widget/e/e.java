package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class e extends FrameLayout {
    public static final int gMA = Color.parseColor("#000000");
    public static final int gMp = Color.parseColor("#000000");
    public static final int gMq = Color.parseColor("#000000");
    private float bhr = 0.0f;
    private float bhs = 0.0f;
    private int gMB;
    private int gMC;
    private int gMD;
    private int gME;
    private TextView gMz;
    public int x = 0;
    public int y = 0;

    public e(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-2, -2));
        this.gMz = new TextView(context);
        this.gMz.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.gMz);
    }

    public final void m(int i, int i2, int i3, int i4) {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) i);
        gradientDrawable.setStroke(i2, i3);
        gradientDrawable.setColor(i4);
        this.gMz.setBackgroundDrawable(gradientDrawable);
    }

    public final void setText(String str) {
        this.gMz.setText(str);
    }

    public final void setTextSize(int i) {
        this.gMz.setTextSize((float) i);
    }

    public final void setTextColor(int i) {
        this.gMz.setTextColor(i);
    }

    public final void setTextPadding(int i) {
        this.gMz.setPadding(i, i, i, i);
    }

    public final void setGravity(String str) {
        if (str.equals("left")) {
            this.gMz.setGravity(3);
        } else if (str.equals("right")) {
            this.gMz.setGravity(5);
        } else {
            str.equals("center");
            this.gMz.setGravity(17);
        }
    }

    public final void setX(int i) {
        this.x = i;
    }

    public final void setY(int i) {
        this.y = i;
    }

    public final float getAnchorX() {
        return this.bhr;
    }

    public final float getAnchorY() {
        return this.bhs;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.gMB = getMeasuredWidth();
        this.gMC = getMeasuredHeight();
        if ((-this.gMB) < this.x && this.x < 0) {
            this.gMD = this.gMB;
            this.bhr = ((float) Math.abs(this.x)) / (((float) this.gMB) * 1.0f);
        } else if (this.x >= 0) {
            this.gMD = this.gMB + Math.abs(this.x);
            this.bhr = 0.0f;
        } else {
            this.gMD = Math.abs(this.x);
            this.bhr = 1.0f;
        }
        if ((-this.gMC) < this.y && this.y < 0) {
            this.gME = this.gMC;
            this.bhs = ((float) Math.abs(this.y)) / (((float) this.gMC) * 1.0f);
        } else if (this.y >= 0) {
            this.gME = this.gMC + Math.abs(this.y);
            this.bhs = 0.0f;
        } else {
            this.gME = Math.abs(this.y);
            this.bhs = 1.0f;
        }
        setMeasuredDimension(this.gMD, this.gME);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.x >= 0 && this.y >= 0) {
            layoutParams.gravity = 85;
        } else if (this.x >= 0 && this.y <= 0) {
            layoutParams.gravity = 53;
        } else if (this.x <= 0 && this.y >= 0) {
            layoutParams.gravity = 83;
        } else if (this.x <= 0 && this.y <= 0) {
            layoutParams.gravity = 51;
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
