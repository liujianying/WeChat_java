package com.tencent.mm.plugin.sns.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.l;

public class SnsTextProgressBar extends ProgressBar {
    private Paint cN;
    private String gEw;
    private int gbP;
    private Context mContext;
    private String onh;
    private int pF;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l.SnsTextProgressBar, 0, 0);
        try {
            setTextSize(obtainStyledAttributes.getInteger(l.SnsTextProgressBar_testSize, 18));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(int i) {
        setText(i);
        super.setProgress(i);
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cN = new Paint();
        this.cN.setAntiAlias(true);
        int color = (this.onh == null || this.onh.length() <= 0) ? this.mContext.getResources().getColor(c.white_text_color_pressed) : Color.parseColor(this.onh);
        this.cN.setColor(color);
        this.cN.setTextSize((float) this.gbP);
        Rect rect = new Rect();
        this.cN.getTextBounds(this.gEw, 0, this.gEw.length(), rect);
        canvas.drawText(this.gEw, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.cN);
    }

    public void setTextSize(int i) {
        this.gbP = a.fromDPToPix(this.mContext, i);
    }

    private void setText(int i) {
        this.pF = i;
        this.gEw = String.valueOf(i) + "%";
    }

    public void setPaintColor(String str) {
        this.onh = str;
    }
}
