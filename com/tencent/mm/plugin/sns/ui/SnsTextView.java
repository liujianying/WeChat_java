package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class SnsTextView extends TextView {
    private String kGl = "";
    private char obT = 0;

    public SnsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        if (q.deW.ddU == 1 || q.deW.ddU == -1) {
            try {
                super.onMeasure(i, i2);
                this.obT = 0;
                return;
            } catch (IndexOutOfBoundsException e) {
                if (this.obT < 3) {
                    try {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(getText());
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            this.obT = 'd';
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                            this.obT = (char) (this.obT + 1);
                        }
                        setText(spannableStringBuilder);
                        onMeasure(i, i2);
                        return;
                    } catch (IndexOutOfBoundsException e2) {
                        x.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bi.oW(this.kGl));
                        setText(this.kGl);
                        onMeasure(i, i2);
                        this.obT = (char) (this.obT + 1);
                        return;
                    }
                } else if (this.obT == 3) {
                    x.i("MicroMsg.SnsTextView", "fix error set origintext " + bi.oW(this.kGl));
                    setText(this.kGl);
                    onMeasure(i, i2);
                    this.obT = (char) (this.obT + 1);
                    return;
                } else {
                    throw e;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    public void setOriginText(String str) {
        this.kGl = str;
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
