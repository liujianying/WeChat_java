package com.tencent.mm.plugin.game.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bp.a;

public class TextProgressBar extends ProgressBar {
    private Paint cN;
    private String gEw;
    private int gbP;
    private Context mContext;
    private int pF;

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
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
        this.cN.setColor(Color.rgb(69, 192, 26));
        this.cN.setTextSize((float) this.gbP);
        Rect rect = new Rect();
        this.cN.getTextBounds(this.gEw, 0, this.gEw.length(), rect);
        float width = (float) ((getWidth() / 2) - rect.centerX());
        float height = (float) ((getHeight() / 2) - rect.centerY());
        canvas.drawText(this.gEw, width, height, this.cN);
        float width2 = (((float) this.pF) / 100.0f) * ((float) getWidth());
        if (width2 > width) {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setTextSize((float) this.gbP);
            RectF rectF = new RectF(0.0f, 0.0f, width2, (float) getHeight());
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawText(this.gEw, width, height, paint);
            canvas.restore();
        }
    }

    public void setTextSize(int i) {
        this.gbP = a.fromDPToPix(this.mContext, i);
    }

    private void setText(int i) {
        this.pF = i;
        this.gEw = String.valueOf(i) + "%";
    }
}
