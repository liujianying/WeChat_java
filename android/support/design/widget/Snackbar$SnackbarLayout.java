package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Snackbar$SnackbarLayout extends LinearLayout {
    TextView gH;
    Button gI;
    private int gJ;
    private b gK;
    private a gL;
    private int gg;

    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.SnackbarLayout);
        this.gg = obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_android_maxWidth, -1);
        this.gJ = obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_maxActionInlineWidth, -1);
        if (obtainStyledAttributes.hasValue(i.SnackbarLayout_elevation)) {
            z.g(this, (float) obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        LayoutInflater.from(context).inflate(f.design_layout_snackbar_include, this);
        z.N(this);
        z.i(this, 1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gH = (TextView) findViewById(e.snackbar_text);
        this.gI = (Button) findViewById(e.snackbar_action);
    }

    TextView getMessageView() {
        return this.gH;
    }

    Button getActionView() {
        return this.gI;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gg > 0 && getMeasuredWidth() > this.gg) {
            i = MeasureSpec.makeMeasureSpec(this.gg, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        int i3 = this.gH.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.gJ <= 0 || this.gI.getMeasuredWidth() <= this.gJ) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (f(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (f(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gK != null) {
            this.gK.aD();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gL != null) {
            this.gL.aC();
        }
    }

    void setOnLayoutChangeListener(b bVar) {
        this.gK = bVar;
    }

    void setOnAttachStateChangeListener(a aVar) {
        this.gL = aVar;
    }

    private boolean f(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.gH.getPaddingTop() == i2 && this.gH.getPaddingBottom() == i3) {
            return z;
        }
        View view = this.gH;
        if (z.ad(view)) {
            z.c(view, z.O(view), i2, z.P(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
        return true;
    }
}
