package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.w.a.m;

public class MMVerticalTextView extends View {
    private TextPaint dG = new TextPaint();
    private int direction;
    private String gEw;
    Rect tys = new Rect();

    public MMVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dG.setAntiAlias(true);
        this.dG.setTextSize(15.0f);
        this.dG.setColor(-16777216);
        this.dG.setTextAlign(Align.CENTER);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.verticaltextview);
        int resourceId = obtainStyledAttributes.getResourceId(m.verticaltextview_text, 0);
        if (resourceId != 0) {
            this.gEw = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getDimensionPixelOffset(m.verticaltextview_textSize, 15);
        if (resourceId > 0) {
            this.dG.setTextSize((float) resourceId);
        }
        this.dG.setColor(obtainStyledAttributes.getColor(m.verticaltextview_textColor, -16777216));
        this.direction = obtainStyledAttributes.getInt(m.verticaltextview_direction, 0);
        this.dG.setFakeBoldText(obtainStyledAttributes.getBoolean(m.verticaltextview_textBold, false));
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
    }

    public void setText(String str) {
        this.gEw = str;
        requestLayout();
        invalidate();
    }

    public void setTextSize(int i) {
        this.dG.setTextSize((float) i);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.dG.setColor(i);
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int height;
        this.dG.getTextBounds(this.gEw, 0, this.gEw.length(), this.tys);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            height = this.tys.height();
            size = mode == Integer.MIN_VALUE ? Math.min(height, size) : height;
        }
        int mode2 = MeasureSpec.getMode(i2);
        height = MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            mode = this.tys.width();
            height = mode2 == Integer.MIN_VALUE ? Math.min(mode, height) : mode;
        }
        setMeasuredDimension(size, height);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        int width;
        if (this.direction == 0) {
            width = (getWidth() >> 1) - (this.tys.height() >> 1);
            path.moveTo((float) width, 0.0f);
            path.lineTo((float) width, (float) height);
        } else {
            width = (getWidth() >> 1) + (this.tys.height() >> 1);
            path.moveTo((float) width, (float) height);
            path.lineTo((float) width, 0.0f);
        }
        canvas.drawTextOnPath(this.gEw, path, 0.0f, 0.0f, this.dG);
    }
}
