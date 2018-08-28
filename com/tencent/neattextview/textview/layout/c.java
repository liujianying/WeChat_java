package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.layout.b.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c implements a {
    private static final TextPaint vaM = new TextPaint(1);
    private static Comparator<Integer> vaN = new Comparator<Integer>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
        }
    };
    public int Tw;
    private float qsZ;
    public int tK;
    private b vaO;
    private char[] vaP;
    private int vaQ;
    private float vaR;
    private boolean vaS;
    private float vaT;
    private float vaU = -1.0f;
    private RectF vaV = new RectF();
    private LinkedList<Integer> vaW = null;
    private float[] vag;

    public c(b bVar, char[] cArr, int i, int i2, float f, float[] fArr, float f2, float f3, float f4, TextPaint textPaint, boolean z, int i3) {
        this.vaO = bVar;
        this.vaP = cArr;
        this.Tw = i;
        this.tK = i2;
        this.vaQ = i3;
        this.vag = fArr;
        this.vaR = f4;
        this.vaS = z;
        this.vaT = f3;
        this.qsZ = f2;
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f5 = fontMetrics.leading - fontMetrics.top;
        float f6 = fontMetrics.bottom - fontMetrics.leading;
        float f7 = ((((this.vaT - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        this.vaV.set(0.0f, f7 - f5, 0.0f + f2, f7 + f6);
    }

    public final void a(Canvas canvas, TextPaint textPaint, float f) {
        Iterator it;
        float cEf = 0.0f + cEf();
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = ((((this.vaT - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        int i = this.Tw;
        int i2 = this.tK;
        int[] iArr = this.vaO.vaA.vbb;
        int[] iArr2 = this.vaO.vaA.vbc;
        LineBackgroundSpan[] lineBackgroundSpanArr = (LineBackgroundSpan[]) this.vaO.vaA.vba;
        List<LineBackgroundSpan> linkedList = new LinkedList();
        int i3 = 0;
        while (i3 < this.vaO.vaA.vaZ) {
            if (iArr[i3] < i2 && iArr2[i3] > i) {
                linkedList.add(lineBackgroundSpanArr[i3]);
            }
            i3++;
        }
        for (LineBackgroundSpan drawBackground : linkedList) {
            drawBackground.drawBackground(canvas, textPaint, (int) this.vaV.left, (int) this.vaV.right, (int) this.vaV.top, (int) f2, (int) this.vaV.bottom, this.vaO.getText(), this.Tw, this.tK, this.vaQ);
        }
        float f3;
        float f4;
        int i4;
        ImageSpan imageSpan;
        if (this.vaR != 0.0f || this.vaS) {
            i2 = this.Tw;
            int i5 = this.Tw;
            f3 = f2;
            f4 = cEf;
            while (i5 < this.tK) {
                if (i5 + 1 >= this.tK || this.vag[i5 + 1] != 0.0f) {
                    i4 = i5 + 1;
                    imageSpan = (ImageSpan) this.vaO.vau.fB(i2, i4);
                    if (imageSpan != null) {
                        vaM.set(textPaint);
                        imageSpan.draw(canvas, "", i2, i4, f4, 0, (int) f3, (int) (this.vaT + f), vaM);
                    } else {
                        if (a(textPaint, i2, i4)) {
                            f3 = ((((this.vaT - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                        }
                        canvas.drawText(this.vaP, i2, i4 - i2, f4, f3, vaM);
                    }
                    f4 += this.vag[i2] + this.vaR;
                    i2 = i4;
                }
                i5++;
            }
            return;
        }
        fA(this.Tw, this.tK);
        i2 = this.Tw;
        it = this.vaW.iterator();
        f3 = f2;
        f4 = cEf;
        while (it.hasNext()) {
            i4 = ((Integer) it.next()).intValue();
            if (i4 > 0 && i2 != i4) {
                imageSpan = (ImageSpan) this.vaO.vau.fD(i2, i4);
                if (imageSpan != null) {
                    vaM.set(textPaint);
                    imageSpan.draw(canvas, "", i2, i4, f4, 0, (int) f3, (int) (this.vaT + f), vaM);
                } else {
                    if (a(textPaint, i2, i4)) {
                        f3 = ((((this.vaT - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                    }
                    canvas.drawText(this.vaP, i2, i4 - i2, f4, f3, vaM);
                }
                while (i2 < i4) {
                    f4 += this.vag[i2];
                    i2++;
                }
                i2 = i4;
            }
        }
        if (i2 < this.Tw + getLength()) {
            float f5;
            if (a(textPaint, i2, this.Tw + getLength())) {
                f5 = ((((this.vaT - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
            } else {
                f5 = f3;
            }
            canvas.drawText(this.vaP, i2, (this.Tw + getLength()) - i2, f4, f5, vaM);
        }
    }

    public final float getHeight() {
        return this.vaT;
    }

    public final float getWidth() {
        return this.qsZ;
    }

    public final float[] cEb() {
        return this.vag;
    }

    private int getLength() {
        return this.tK - this.Tw;
    }

    public final RectF fz(int i, int i2) {
        RectF rectF = new RectF();
        if (i < i2) {
            float cEf = cEf();
            for (int i3 = this.Tw; i3 < i; i3++) {
                cEf += this.vag[i3] + this.vaR;
            }
            float f = cEf;
            while (i < i2) {
                f += this.vag[i] + this.vaR;
                i++;
            }
            rectF.set(cEf, this.vaV.top, f, this.vaV.bottom);
        }
        return rectF;
    }

    public final RectF cEc() {
        return this.vaV;
    }

    public final int getStart() {
        return this.Tw;
    }

    public final int getEnd() {
        return this.tK;
    }

    public final float cEd() {
        return this.vaR;
    }

    public final boolean cEe() {
        return this.vaS;
    }

    public final float cEf() {
        if (this.vaU != -1.0f) {
            return this.vaU;
        }
        if (this.vaO.vau.fB(this.Tw, this.Tw + 1) == null && this.vaO.cEj().containsKey(Character.valueOf(this.vaP[this.Tw]))) {
            float f = -((Float) this.vaO.cEj().get(Character.valueOf(this.vaP[this.Tw]))).floatValue();
            this.vaU = f;
            return f;
        }
        this.vaU = 0.0f;
        return this.vaU;
    }

    private boolean a(TextPaint textPaint, int i, int i2) {
        boolean z = true;
        boolean z2 = false;
        vaM.set(textPaint);
        AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) this.vaO.vav.fB(i, i2);
        if (absoluteSizeSpan != null) {
            absoluteSizeSpan.updateDrawState(vaM);
            z2 = true;
        }
        RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) this.vaO.vaw.fB(i, i2);
        if (relativeSizeSpan != null) {
            relativeSizeSpan.updateDrawState(vaM);
        } else {
            z = z2;
        }
        ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) this.vaO.vay.fB(i, i2);
        if (foregroundColorSpan != null) {
            foregroundColorSpan.updateDrawState(vaM);
        }
        ClickableSpan clickableSpan = (ClickableSpan) this.vaO.vaz.fB(i, i2);
        if (clickableSpan != null) {
            clickableSpan.updateDrawState(vaM);
        }
        return z;
    }

    private void fA(int i, int i2) {
        if (this.vaW == null) {
            this.vaW = new LinkedList();
            for (int i3 : a.cEk()) {
                if (i3 != a.vaG) {
                    d dVar;
                    b bVar = this.vaO;
                    switch (com.tencent.neattextview.textview.layout.b.AnonymousClass1.vaE[i3 - 1]) {
                        case 1:
                            dVar = bVar.vaz;
                            break;
                        case 2:
                            dVar = bVar.vax;
                            break;
                        case 3:
                            dVar = bVar.vau;
                            break;
                        case 4:
                            dVar = bVar.vav;
                            break;
                        case 5:
                            dVar = bVar.vaw;
                            break;
                        case 6:
                            dVar = bVar.vay;
                            break;
                        default:
                            dVar = null;
                            break;
                    }
                    int i4 = 0;
                    for (boolean z : dVar.fC(i, i2)) {
                        if (z) {
                            int i5;
                            this.vaW.add(Integer.valueOf(dVar.vbb[i4] < i ? i : dVar.vbb[i4]));
                            LinkedList linkedList = this.vaW;
                            if (dVar.vbc[i4] > i2) {
                                i5 = i2;
                            } else {
                                i5 = dVar.vbc[i4];
                            }
                            linkedList.add(Integer.valueOf(i5));
                        }
                        i4++;
                    }
                }
            }
            Collections.sort(this.vaW, vaN);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.getStart() != this.Tw || aVar.getEnd() != this.tK || !aVar.cEc().equals(this.vaV) || aVar.cEe() != this.vaS || aVar.cEd() != this.vaR || aVar.cEf() != this.vaU) {
            return false;
        }
        for (int i = this.Tw; i < this.tK; i++) {
            if (this.vag[i] != aVar.cEb()[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.Tw + this.tK) + ((int) this.vaT)) + ((int) this.qsZ)) + ((int) this.vaU)) + this.vaV.hashCode();
    }

    public final String toString() {
        return "MeasuredLine{mStart=" + this.Tw + ", mEnd=" + this.tK + ", mLetter=" + this.vaR + ", isSmartLetter=" + this.vaS + ", mHeight=" + this.vaT + ", mWidth=" + this.qsZ + ", mLeftOffset=" + this.vaU + ", mLineRect=" + this.vaV + '}';
    }
}
