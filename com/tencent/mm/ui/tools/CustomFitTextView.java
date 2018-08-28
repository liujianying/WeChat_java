package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView extends TextView {
    private boolean fbh = true;
    public int maxLines;
    private Paint uwK;
    private String uwL;
    private Rect uwM = new Rect();
    private LinkedList<String> uwN = new LinkedList();
    public int uwO;
    private Drawable uwP;
    public boolean uwQ;
    private int uwR = 0;

    public CustomFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(String str, int i, boolean z, int i2, int i3) {
        this.maxLines = i;
        this.uwL = str;
        if (this.uwL == null) {
            x.w("MicroMsg.CustomFitTextView", "ori text is null");
            this.uwL = "";
        }
        if (this.maxLines <= 0) {
            x.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
            this.maxLines = 2;
        }
        this.uwR = getResources().getDimensionPixelSize(e.BasicPaddingSize);
        this.uwQ = z;
        this.uwO = i2;
        if (this.uwQ) {
            this.uwP = getResources().getDrawable(this.uwO);
        }
        this.uwK = new Paint();
        this.uwK.set(getPaint());
        this.uwK.setAntiAlias(true);
        this.uwK.setColor(i3);
        ds(this.uwL, getWidth());
        setHeight(Math.max(czH(), a.fromDPToPix(getContext(), 32)));
    }

    private int czH() {
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        return ((int) ((((fontMetrics.leading + (fontMetrics.bottom - fontMetrics.top)) * ((float) this.uwN.size())) + ((float) getPaddingTop())) + ((float) getPaddingBottom()))) + (Math.max(0, this.uwN.size() - 1) * this.uwR);
    }

    private boolean ds(String str, int i) {
        if (!this.fbh || i <= 0 || str == null || "".equals(str)) {
            return false;
        }
        int ceil;
        this.uwN.clear();
        int i2 = 0;
        int length = str.length();
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.uwQ ? this.uwP.getIntrinsicWidth() : 0;
        float measureText = ((float) intrinsicWidth) + getPaint().measureText(str, 0, length);
        int i3 = this.maxLines;
        if (Float.compare(measureText, (float) (this.maxLines * paddingLeft)) < 0) {
            ceil = (int) Math.ceil((double) (measureText / ((float) paddingLeft)));
        } else {
            ceil = i3;
        }
        for (int i4 = 0; i4 < ceil; i4++) {
            if (i4 == ceil - 1) {
                abc(str.substring(i2, d(str, i2, length, intrinsicWidth, paddingLeft)).trim());
            } else {
                i3 = d(str, i2, length, 0, paddingLeft);
                abc(str.substring(i2, i3).trim());
                if (i3 >= length) {
                    x.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
                    break;
                }
                i2 = i3;
            }
        }
        return true;
    }

    private void abc(String str) {
        if (this.uwN != null && str != null && !"".equals(str)) {
            this.uwN.add(str);
        }
    }

    private int d(String str, int i, int i2, int i3, int i4) {
        if (i2 <= i) {
            return i + 1;
        }
        if (getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            return i2;
        }
        int length = str.length();
        while (getPaint().measureText(str, i, i2) + ((float) i3) > ((float) i4)) {
            i2 = (i2 + i) >> 1;
        }
        while (i2 <= length && getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            i2++;
        }
        int min = Math.min(length, i2) - 1;
        length = min;
        while (length >= 0 && bi.o(str.charAt(length))) {
            length--;
        }
        if (length < 0 || length == min) {
            return i2 - 1;
        }
        return length + 1;
    }

    protected void onDraw(Canvas canvas) {
        if (this.fbh && this.uwL != null && !"".equals(this.uwL) && this.uwN.size() != 0) {
            FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f = fontMetrics.descent - fontMetrics.ascent;
            float paddingLeft = (float) getPaddingLeft();
            float paddingTop = (float) getPaddingTop();
            Iterator it = this.uwN.iterator();
            float f2 = paddingTop;
            while (it.hasNext()) {
                float f3 = (fontMetrics.leading + f) + f2;
                canvas.drawText((String) it.next(), paddingLeft, f3, this.uwK);
                f2 = f3;
            }
            if (this.uwQ) {
                getPaint().getTextBounds((String) this.uwN.getLast(), 0, ((String) this.uwN.getLast()).length(), this.uwM);
                int paddingLeft2 = getPaddingLeft() + this.uwM.right;
                int i = (int) ((f2 - f) - fontMetrics.leading);
                this.uwP.setBounds(paddingLeft2, i, this.uwP.getIntrinsicWidth() + paddingLeft2, this.uwP.getIntrinsicHeight() + i);
                this.uwP.draw(canvas);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = (i == i3 && i2 == i4) ? false : true;
        this.fbh = z;
        if (this.fbh) {
            ds(this.uwL, i);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        if (ds(this.uwL, size)) {
            fromDPToPix = Math.max(czH(), fromDPToPix);
        }
        setMeasuredDimension(size, fromDPToPix);
    }
}
