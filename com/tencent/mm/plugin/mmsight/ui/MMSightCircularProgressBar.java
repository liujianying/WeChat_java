package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.sdk.platformtools.x;

public class MMSightCircularProgressBar extends View {
    boolean bTv = false;
    int duration = 0;
    private Paint fBa;
    float loc = 0.0f;
    int lod = 0;
    int loe = 0;
    private RectF lof;
    b log;
    a loh;
    private int loi = Color.parseColor("#1AAD19");
    private float strokeWidth = 0.0f;
    private float wW = 0.0f;

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(b.mmsight_recorder_button_outer_size_max);
        this.strokeWidth = (float) getResources().getDimensionPixelSize(b.mmsight_recorder_progress_circular_thickness);
        this.wW = this.strokeWidth / 2.0f;
        this.lof = new RectF(this.wW, this.wW, dimensionPixelSize - this.wW, dimensionPixelSize - this.wW);
        this.fBa = new Paint();
        this.fBa.setStyle(Style.STROKE);
        this.fBa.setStrokeWidth(this.strokeWidth);
        this.fBa.setColor(this.loi);
        this.fBa.setAlpha(153);
        this.fBa.setAntiAlias(true);
    }

    public void setMaxProgress(int i) {
        x.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[]{Integer.valueOf(i)});
        this.loe = i;
    }

    public void setDuration(int i) {
        x.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[]{Integer.valueOf(i)});
        this.duration = i;
    }

    public void setInitProgress(int i) {
        x.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.bTv)});
        if (!this.bTv) {
            this.lod = i;
        }
    }

    public void setProgressCallback(a aVar) {
        this.loh = aVar;
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.wW, this.wW);
        canvas.rotate(180.0f, this.lof.right / 2.0f, this.lof.bottom / 2.0f);
        canvas.drawArc(this.lof, 90.0f, 360.0f * (this.loc / ((float) this.loe)), false, this.fBa);
        canvas.restore();
    }
}
