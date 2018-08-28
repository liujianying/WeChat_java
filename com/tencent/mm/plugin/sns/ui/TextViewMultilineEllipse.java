package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import java.util.List;

public class TextViewMultilineEllipse extends View {
    private Context context;
    private TextPaint dG;
    private String gEw;
    private int kgE;
    private boolean nQA;
    private boolean nQB;
    private int nQv;
    private String nQw;
    private String nQx;
    private boolean nQy;
    private int nQz;
    private a ohh;
    private a ohi;
    private int textSize = -1;

    public TextViewMultilineEllipse(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.nQB = false;
        this.nQy = true;
        this.nQA = false;
        this.kgE = -1;
        this.nQw = "...";
        this.nQx = "";
        this.nQz = -16776961;
        this.ohh = new a();
        this.ohi = new a();
        this.dG = new TextPaint();
        this.dG.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = b.b(this.context, 12.0f);
            this.dG.setTextSize((float) this.textSize);
        } else {
            this.dG.setTextSize(13.0f);
        }
        this.dG.setColor(-16777216);
        this.dG.setTextAlign(Align.LEFT);
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

    public void setEllipsis(String str) {
        this.nQw = str;
    }

    public void setEllipsisMore(String str) {
        this.nQx = str;
    }

    public void setMaxLines(int i) {
        this.kgE = i;
    }

    public void setDrawEllipsizeMoreString(boolean z) {
        this.nQy = z;
    }

    public void setColorEllpsizeMore(int i) {
        this.nQz = i;
    }

    public void setRightAlignEllipsizeMoreString(boolean z) {
        this.nQA = z;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            xn(size);
        } else if (mode == Integer.MIN_VALUE) {
            size = Math.min(xn(size), size);
        } else {
            xn(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.nQv = (int) this.dG.ascent();
        if (mode2 == 1073741824) {
            i3 = mode;
        } else {
            i3 = (((this.nQB ? this.ohh.nQH.size() : this.ohi.nQH.size()) * ((int) (((float) (-this.nQv)) + this.dG.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onDraw(Canvas canvas) {
        a aVar;
        List list;
        super.onDraw(canvas);
        if (this.nQB) {
            aVar = this.ohh;
            list = this.ohh.nQH;
        } else {
            aVar = this.ohi;
            Object list2 = this.ohi.nQH;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.nQv));
        int i = 0;
        while (i < list2.size()) {
            int[] iArr = (int[]) list2.get(i);
            canvas.drawText(this.gEw, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.dG);
            if (i == list2.size() - 1 && aVar.nQG) {
                canvas.drawText(this.nQw, aVar.nQI + paddingLeft, paddingTop, this.dG);
                if (this.nQy) {
                    int color = this.dG.getColor();
                    this.dG.setColor(this.nQz);
                    if (this.nQA) {
                        canvas.drawText(this.nQx, ((float) canvas.getWidth()) - ((aVar.nQK + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.dG);
                    } else {
                        canvas.drawText(this.nQx, (aVar.nQI + aVar.nQJ) + paddingLeft, paddingTop, this.dG);
                    }
                    this.dG.setColor(color);
                }
            }
            paddingTop += ((float) (-this.nQv)) + this.dG.descent();
            if (paddingTop <= ((float) canvas.getHeight())) {
                i++;
            } else {
                return;
            }
        }
    }

    public boolean getIsExpanded() {
        return this.nQB;
    }

    private int xn(int i) {
        int a;
        if (this.nQB) {
            a = this.ohh.a(this.gEw, null, null, -1, (i - getPaddingLeft()) - getPaddingRight(), this.dG);
        } else {
            a = this.ohi.a(this.gEw, this.nQw, this.nQx, this.kgE, (i - getPaddingLeft()) - getPaddingRight(), this.dG);
        }
        return (a + getPaddingLeft()) + getPaddingRight();
    }
}
