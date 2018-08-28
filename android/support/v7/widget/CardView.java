package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.support.v7.b.a.c;
import android.support.v7.b.a.d;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout implements o {
    private static final int[] Nq = new int[]{16842801};
    private static final q Nr;
    private boolean Ns;
    private int Nt;
    private int Nu;
    private final Rect Nv = new Rect();
    private final Rect Nw = new Rect();
    private boolean fk;

    static {
        if (VERSION.SDK_INT >= 21) {
            Nr = new n();
        } else if (VERSION.SDK_INT >= 17) {
            Nr = new r();
        } else {
            Nr = new p();
        }
        Nr.eN();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.fk;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.fk != z) {
            this.fk = z;
            Nr.f(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (Nr instanceof n) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) Nr.b(this)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) Nr.c(this)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i, c.CardView);
        if (obtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            color = obtainStyledAttributes.getColor(d.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(Nq);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(a.cardview_light_background) : getResources().getColor(a.cardview_dark_background);
        }
        float dimension = obtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.fk = obtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.Ns = obtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        this.Nv.left = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.Nv.top = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, dimensionPixelSize);
        this.Nv.right = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, dimensionPixelSize);
        this.Nv.bottom = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.Nt = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        this.Nu = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        Nr.a(this, context, color, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.Nt = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.Nu = i;
        super.setMinimumHeight(i);
    }

    public final void E(int i, int i2) {
        if (i > this.Nt) {
            super.setMinimumWidth(i);
        }
        if (i2 > this.Nu) {
            super.setMinimumHeight(i2);
        }
    }

    public void setCardBackgroundColor(int i) {
        Nr.a(this, i);
    }

    public int getContentPaddingLeft() {
        return this.Nv.left;
    }

    public int getContentPaddingRight() {
        return this.Nv.right;
    }

    public int getContentPaddingTop() {
        return this.Nv.top;
    }

    public int getContentPaddingBottom() {
        return this.Nv.bottom;
    }

    public void setRadius(float f) {
        Nr.a(this, f);
    }

    public float getRadius() {
        return Nr.d(this);
    }

    public final void d(int i, int i2, int i3, int i4) {
        this.Nw.set(i, i2, i3, i4);
        super.setPadding(this.Nv.left + i, this.Nv.top + i2, this.Nv.right + i3, this.Nv.bottom + i4);
    }

    public void setCardElevation(float f) {
        Nr.c(this, f);
    }

    public float getCardElevation() {
        return Nr.e(this);
    }

    public void setMaxCardElevation(float f) {
        Nr.b(this, f);
    }

    public float getMaxCardElevation() {
        return Nr.a(this);
    }

    public boolean getPreventCornerOverlap() {
        return this.Ns;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.Ns) {
            this.Ns = z;
            Nr.g(this);
        }
    }
}
