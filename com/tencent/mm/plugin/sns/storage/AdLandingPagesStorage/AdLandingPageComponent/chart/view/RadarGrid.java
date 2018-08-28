package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid extends ChartGridView {
    public static final Point nCB = new Point(0, 0);
    private Rect cO = new Rect();
    private Path ks = new Path();
    private c nCA;
    private int nCH = 80;
    private Point nCI = nCB;
    private Spannable[] nCK;
    private List<PointF> nCL;
    private int nCw = 4;
    private int nCx = 4;
    private float nCz = 1.0f;

    public RadarGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bzJ();
    }

    public RadarGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bzJ();
    }

    public RadarGrid(Context context, int i, int i2, float f, Spannable[] spannableArr, c cVar) {
        super(context);
        this.nCz = f;
        this.nCw = i;
        this.nCx = i2;
        this.nCz = f;
        this.nCK = spannableArr;
        this.nCA = cVar;
    }

    private void bzJ() {
        setMinimumHeight(JsApiSetBackgroundAudioState.CTRL_INDEX);
        setMinimumWidth(JsApiSetBackgroundAudioState.CTRL_INDEX);
    }

    protected final int bzG() {
        return this.nCH * 2;
    }

    protected final int bzH() {
        return this.nCH * 2;
    }

    private List<PointF> at(float f) {
        List<PointF> arrayList = new ArrayList();
        for (int i = 0; i < this.nCw; i++) {
            PointF pointF = new PointF();
            pointF.set((float) (((double) this.nCI.x) - (((double) (((float) this.nCH) * f)) * Math.sin((((double) (i * 2)) * 3.141592653589793d) / ((double) this.nCw)))), (float) (((double) this.nCI.y) - (((double) (((float) this.nCH) * f)) * Math.cos((((double) (i * 2)) * 3.141592653589793d) / ((double) this.nCw)))));
            arrayList.add(pointF);
        }
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        int i;
        PointF pointF;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.nCH = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.nCI.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.nCA.nCm != null) {
            width = (int) (((float) width) / 2.0f);
            height = (int) (((float) height) / 2.0f);
            i = (int) (((float) (this.nCH * 2)) + (this.nCA.nCj * 2.0f));
            int width2 = (this.nCA.nCm.getWidth() * i) / this.nCA.nCm.getHeight();
            if (this.nCA.nCm != null) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(this.nCA.nCm, width2, i, false), (float) (width - (width2 >>> 1)), (float) (height - (i >>> 1)), null);
            }
        }
        if (this.nCA.nBT) {
            switch (this.nCA.nBS) {
                case 0:
                    this.nCL = at(1.0f);
                    height = 0;
                    while (true) {
                        width = height;
                        if (width >= this.nCw) {
                            this.ks.close();
                            if (this.nCA.backgroundColor != 0 && this.nCA.nCm == null) {
                                canvas.drawPath(this.ks, getPaintGridFill());
                                break;
                            }
                        }
                        pointF = (PointF) this.nCL.get(width);
                        if (width == 0) {
                            this.ks.moveTo(pointF.x, pointF.y);
                        } else {
                            this.ks.lineTo(pointF.x, pointF.y);
                        }
                        height = width + 1;
                    }
                case 1:
                    canvas.drawCircle((float) this.nCI.x, (float) this.nCI.y, (float) this.nCH, getPaintGridFill());
                    break;
            }
        }
        if (this.nCA.nBU) {
            this.nCL = at(1.0f);
            height = 0;
            while (true) {
                int i2 = height;
                if (i2 < this.nCw) {
                    pointF = (PointF) this.nCL.get(i2);
                    canvas.drawLine((float) this.nCI.x, (float) this.nCI.y, pointF.x, pointF.y, getPaintGridLongitude());
                    height = i2 + 1;
                }
            }
        }
        if (this.nCA.nBT) {
            switch (this.nCA.nBS) {
                case 0:
                    canvas.drawPath(this.ks, getPaintGridBorder());
                    this.ks.reset();
                    height = 1;
                    while (true) {
                        width = height;
                        if (width >= this.nCx) {
                            break;
                        }
                        this.nCL = at((((float) width) * 1.0f) / ((float) this.nCx));
                        height = 0;
                        while (true) {
                            i = height;
                            if (i < this.nCw) {
                                pointF = (PointF) this.nCL.get(i);
                                if (i == 0) {
                                    this.ks.moveTo(pointF.x, pointF.y);
                                } else {
                                    this.ks.lineTo(pointF.x, pointF.y);
                                }
                                canvas.drawCircle(pointF.x, pointF.y, (float) getGridDotRadius(), getPaintGridDot());
                                height = i + 1;
                            } else {
                                this.ks.close();
                                canvas.drawPath(this.ks, getPaintGridLatitude());
                                this.ks.reset();
                                height = width + 1;
                            }
                        }
                    }
                case 1:
                    canvas.drawCircle((float) this.nCI.x, (float) this.nCI.y, (float) this.nCH, getPaintGridBorder());
                    for (height = 1; height < this.nCx; height++) {
                        canvas.drawCircle((float) this.nCI.x, (float) this.nCI.y, ((float) this.nCH) * ((((float) height) * 1.0f) / ((float) this.nCx)), getPaintGridLatitude());
                    }
                    break;
            }
        }
        if (this.nCK != null && this.nCA.nBW) {
            if (this.nCK.length != this.nCw) {
                throw new RuntimeException("Labels array length not matches longitude lines number.");
            }
            height = 0;
            while (true) {
                int i3 = height;
                if (i3 < this.nCw) {
                    CharSequence charSequence = this.nCK[i3];
                    if (!charSequence.equals(null)) {
                        float f;
                        float f2;
                        if (i3 == 0 || i3 == (this.nCw >>> 1)) {
                            f = 0.5f;
                        } else if (i3 <= 0 || i3 >= (this.nCw >>> 1)) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        if (i3 == 0) {
                            f2 = this.nCA.nCe;
                        } else if (i3 == (this.nCw >>> 1)) {
                            f2 = -this.nCA.nCe;
                        } else {
                            f2 = 0.0f;
                        }
                        StaticLayout staticLayout = new StaticLayout(charSequence, getTextPaintGLabelFont(), 1000, Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
                        float lineWidth = (float) (((double) (((float) this.nCI.x) - (staticLayout.getLineWidth(0) * f))) - (((double) (((float) this.nCH) + this.nCA.nCe)) * Math.sin(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.nCw)))));
                        float height2 = (float) ((((double) (this.nCI.y - (staticLayout.getHeight() / 2))) - (((double) (((float) this.nCH) + this.nCA.nCe)) * Math.cos(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.nCw))))) - ((double) f2));
                        canvas.save();
                        canvas.translate(lineWidth, height2);
                        staticLayout.draw(canvas);
                        canvas.restore();
                    }
                    height = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private Paint getPaintGridFill() {
        Paint paint = new Paint();
        paint.setColor(this.nCA.backgroundColor);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint getPaintGridBorder() {
        Paint paint = new Paint();
        c cVar = this.nCA;
        paint.setColor(cVar.nBX == -1 ? cVar.nBY : cVar.nBX);
        paint.setStyle(Style.STROKE);
        cVar = this.nCA;
        paint.setStrokeWidth(cVar.nCb == -1.0f ? cVar.nCa : cVar.nCb);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint getPaintGridLatitude() {
        Paint paint = new Paint();
        paint.setColor(this.nCA.nBY);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.nCA.nCa);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint getPaintGridDot() {
        Paint paint = new Paint();
        paint.setColor(this.nCA.nCk);
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        return paint;
    }

    private int getGridDotRadius() {
        return this.nCA.nCl;
    }

    private Paint getPaintGridLongitude() {
        Paint paint = new Paint();
        paint.setColor(this.nCA.nBZ);
        paint.setStrokeWidth(this.nCA.nCa);
        return paint;
    }

    private Paint getPaintGLabelFont() {
        Paint paint = new Paint();
        paint.setColor(this.nCA.nCc);
        paint.setTextSize(this.nCA.nCd);
        return paint;
    }

    private TextPaint getTextPaintGLabelFont() {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(this.nCA.nCc);
        textPaint.setTextSize(this.nCA.nCd);
        return textPaint;
    }

    private Paint getPaintGScaleFont() {
        Paint paint = new Paint();
        c cVar = this.nCA;
        paint.setColor(cVar.nCf == -1 ? cVar.nCc : cVar.nCf);
        paint.setTextSize(this.nCA.nCg);
        return paint;
    }

    public void setGridChartType(int i) {
        this.nCA.nBS = i;
        invalidate();
    }

    public void setLonNum(int i) {
        this.nCw = i;
        invalidate();
    }

    public void setLatNum(int i) {
        this.nCx = i;
        invalidate();
    }

    public void setMaxValue(float f) {
        this.nCz = f;
        invalidate();
    }

    public void setLabelsArray(Spannable[] spannableArr) {
        this.nCK = spannableArr;
        invalidate();
    }

    public void setGridStyle(c cVar) {
        this.nCA = cVar;
        invalidate();
    }

    public c getGridStyle() {
        return this.nCA;
    }

    public void setBackgroundColor(int i) {
        this.nCA.backgroundColor = i;
        invalidate();
    }

    public void setGridBorderColor(int i) {
        this.nCA.nBX = i;
        invalidate();
    }

    public void setGridLatitudeColor(int i) {
        this.nCA.nBY = i;
        invalidate();
    }

    public void setGridLongitudeColor(int i) {
        this.nCA.nBZ = i;
        invalidate();
    }

    public void setGridStrokeWidth(float f) {
        this.nCA.nCa = f;
        invalidate();
    }

    public void setGridBorderStrokeWidth(float f) {
        this.nCA.nCb = f;
        invalidate();
    }

    public void setGridLabelColor(int i) {
        this.nCA.nCc = i;
        invalidate();
    }

    public void setGridLabelSize(float f) {
        this.nCA.nCd = f;
        invalidate();
    }

    public void setGridLabelPadding(float f) {
        this.nCA.nCe = f;
        invalidate();
    }

    public void setGridScaleColor(int i) {
        this.nCA.nCf = i;
        invalidate();
    }

    public void setGridScaleSize(float f) {
        this.nCA.nCg = f;
        invalidate();
    }

    public void setGridScaleLabelPadding(float f) {
        this.nCA.nCh = f;
        invalidate();
    }
}
