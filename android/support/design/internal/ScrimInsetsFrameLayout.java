package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
    private Drawable bH;
    private Rect bI;
    private Rect bJ;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJ = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ScrimInsetsFrameLayout, i, h.Widget_Design_ScrimInsetsFrameLayout);
        this.bH = obtainStyledAttributes.getDrawable(i.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        z.b(this, new 1(this));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.bI != null && this.bH != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.bJ.set(0, 0, width, this.bI.top);
            this.bH.setBounds(this.bJ);
            this.bH.draw(canvas);
            this.bJ.set(0, height - this.bI.bottom, width, height);
            this.bH.setBounds(this.bJ);
            this.bH.draw(canvas);
            this.bJ.set(0, this.bI.top, this.bI.left, height - this.bI.bottom);
            this.bH.setBounds(this.bJ);
            this.bH.draw(canvas);
            this.bJ.set(width - this.bI.right, this.bI.top, width, height - this.bI.bottom);
            this.bH.setBounds(this.bJ);
            this.bH.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bH != null) {
            this.bH.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bH != null) {
            this.bH.setCallback(null);
        }
    }

    public void c(Rect rect) {
    }
}
