package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Map.Entry;
import java.util.Set;

public class RadarDataLayer extends DataLayerView {
    public static final Point nCB = new Point(0, 0);
    private Path ks = new Path();
    private a nCC;
    private a nCD;
    private b nCE = new b();
    private ValueAnimator nCF;
    private boolean nCG = true;
    private int nCH = 80;
    private Point nCI = nCB;
    private int nCw = 4;
    private float nCz = 1.0f;

    public RadarDataLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bzJ();
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bzJ();
    }

    public RadarDataLayer(Context context, float f, a aVar) {
        super(context);
        this.nCz = f;
        this.nCE = aVar.nBJ;
        this.nCw = aVar.size();
        this.nCC = aVar;
        TimeInterpolator timeInterpolator = aVar.nBK;
        long j = aVar.duration;
        if (j > 0) {
            this.nCF = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.nCD = new a();
            this.nCF.setDuration(j);
            this.nCF.setInterpolator(timeInterpolator);
            this.nCF.addUpdateListener(new 1(this));
        }
    }

    private void bzJ() {
        setMinimumHeight(160);
        setMinimumWidth(160);
    }

    protected final int bzG() {
        return this.nCH * 2;
    }

    protected final int bzH() {
        return this.nCH * 2;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.nCH = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.nCI.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.nCC == null) {
            throw new RuntimeException("Error: NullPointerException at data.");
        } else if (this.nCC != null) {
            Set entrySet;
            if (this.nCD == null) {
                entrySet = this.nCC.entrySet();
            } else {
                entrySet = this.nCD.entrySet();
            }
            int i = 0;
            for (Entry entry : entrySet) {
                float floatValue = (float) (((double) this.nCI.x) - (((double) ((((Float) entry.getValue()).floatValue() / this.nCz) * ((float) this.nCH))) * Math.sin(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.nCw)))));
                float floatValue2 = (float) (((double) this.nCI.y) - (((double) ((((Float) entry.getValue()).floatValue() / this.nCz) * ((float) this.nCH))) * Math.cos(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.nCw)))));
                if (i == 0) {
                    this.ks.moveTo(floatValue, floatValue2);
                } else {
                    this.ks.lineTo(floatValue, floatValue2);
                }
                if (this.nCG) {
                    canvas.drawCircle(floatValue, floatValue2, (float) this.nCE.nBR, getPaintLayerDotPoint());
                }
                i++;
            }
            this.ks.close();
            canvas.drawPath(this.ks, getPaintLayerFilling());
            canvas.drawPath(this.ks, getPaintLayerBorder());
            this.ks.reset();
        }
    }

    private Paint getPaintLayerFilling() {
        Paint paint = new Paint();
        b bVar = this.nCE;
        paint.setColor(bVar.nBO == -1 ? bVar.nBM : bVar.nBO);
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        paint.setAlpha(this.nCE.nBP);
        return paint;
    }

    private Paint getPaintLayerBorder() {
        Paint paint = new Paint();
        paint.setColor(this.nCE.nBM);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.nCE.nBN);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint getPaintLayerPoint() {
        Paint paint = new Paint();
        paint.setColor(this.nCE.nBM);
        paint.setStrokeWidth(this.nCE.nBN);
        return paint;
    }

    private Paint getPaintLayerDotPoint() {
        Paint paint = new Paint();
        paint.setColor(this.nCE.nBQ);
        return paint;
    }

    public void setGlobalMax(float f) {
        this.nCz = f;
        invalidate();
    }

    public void setData(a aVar) {
        this.nCC = aVar;
        invalidate();
    }

    public void setLayerStyle(b bVar) {
        this.nCE = bVar;
        invalidate();
    }

    public void setMaxValue(float f) {
        this.nCz = f;
        invalidate();
    }
}
