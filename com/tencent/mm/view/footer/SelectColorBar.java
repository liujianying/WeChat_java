package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bd.a.c;
import com.tencent.smtt.sdk.WebView;

public class SelectColorBar extends View {
    public static final int[] uUQ = new int[]{-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    private Paint dnG;
    private Paint uSU = new Paint(1);
    private final float uUA = getResources().getDimension(c.feature_padding);
    private Rect[] uUM;
    private boolean uUT = true;
    private a uVr;
    private int uVs = -1;

    public SelectColorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.uSU.setColor(-16711936);
        this.uUM = new Rect[uUQ.length];
        this.dnG = new Paint(1);
        this.dnG.setStyle(Style.FILL);
        this.dnG.setStrokeCap(Cap.ROUND);
    }

    public void setSelectColorListener(a aVar) {
        this.uVr = aVar;
    }

    public void setSelectColor(int i) {
        for (int i2 = 0; i2 < uUQ.length; i2++) {
            if (uUQ[i2] == i) {
                this.uVs = i2;
                break;
            }
        }
        this.uUT = false;
        postInvalidate();
    }

    protected void onMeasure(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec((int) getResources().getDimension(c.color_select_layout_height), 1073741824));
        if (this.uUM == null) {
            this.uUM = new Rect[uUQ.length];
        }
        float dimension = getResources().getDimension(c.doodle_radio);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingLeftAndRight())) - ((2.0f * dimension) * ((float) uUQ.length))) / ((float) (uUQ.length - 1));
        int i3 = (int) (dimension * 2.0f);
        int paddingLeftAndRight = (int) ((((float) (getPaddingLeftAndRight() / 2)) + dimension) + 5.0f);
        int detailHeight = getDetailHeight() / 2;
        for (size = 0; size < uUQ.length; size++) {
            this.uUM[size] = new Rect(paddingLeftAndRight - i3, detailHeight - i3, paddingLeftAndRight + i3, detailHeight + i3);
            paddingLeftAndRight = (int) (((float) paddingLeftAndRight) + ((2.0f * dimension) + measuredWidth));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r5.getX();
        r1 = (int) r1;
        r2 = r5.getY();
        r2 = (int) r2;
        r3 = r5.getAction();
        switch(r3) {
            case 0: goto L_0x0016;
            case 1: goto L_0x002a;
            case 2: goto L_0x0012;
            case 3: goto L_0x002a;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = 1;
        return r0;
    L_0x0014:
        r0 = r0 + 1;
    L_0x0016:
        r3 = r4.uUM;
        r3 = r3.length;
        if (r0 >= r3) goto L_0x0012;
    L_0x001b:
        r3 = r4.uUM;
        r3 = r3[r0];
        r3 = r3.contains(r1, r2);
        if (r3 == 0) goto L_0x0014;
    L_0x0025:
        r4.uVs = r0;
        goto L_0x0012;
    L_0x0028:
        r0 = r0 + 1;
    L_0x002a:
        r3 = r4.uUM;
        if (r3 == 0) goto L_0x004e;
    L_0x002e:
        r3 = r4.uUM;
        r3 = r3.length;
        if (r0 >= r3) goto L_0x004e;
    L_0x0033:
        r3 = r4.uUM;
        r3 = r3[r0];
        r3 = r3.contains(r1, r2);
        if (r3 == 0) goto L_0x0028;
    L_0x003d:
        r3 = r4.uVs;
        if (r0 != r3) goto L_0x0028;
    L_0x0041:
        r3 = r4.uVr;
        if (r3 == 0) goto L_0x0028;
    L_0x0045:
        r1 = r4.uVr;
        r2 = uUQ;
        r0 = r2[r0];
        r1.GO(r0);
    L_0x004e:
        r4.requestLayout();
        r4.postInvalidate();
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.footer.SelectColorBar.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        float dimension = getResources().getDimension(c.doodle_radio);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingLeftAndRight())) - ((2.0f * dimension) * ((float) uUQ.length))) / ((float) (uUQ.length - 1));
        float paddingLeftAndRight = (((float) (getPaddingLeftAndRight() / 2)) + dimension) + 5.0f;
        float detailHeight = (1.0f * ((float) getDetailHeight())) / 2.0f;
        int i = 0;
        while (i < uUQ.length) {
            float f = 0.0f;
            if (this.uVs == i) {
                this.uUT = false;
                f = 6.0f;
            } else if (this.uUT && i == 2) {
                f = 6.0f;
            }
            this.dnG.setColor(-1);
            canvas.drawCircle(paddingLeftAndRight, detailHeight, (dimension + 5.0f) + f, this.dnG);
            this.dnG.setColor(uUQ[i]);
            canvas.drawCircle(paddingLeftAndRight, detailHeight, f + dimension, this.dnG);
            paddingLeftAndRight += (2.0f * dimension) + measuredWidth;
            i++;
        }
    }

    protected int getDetailHeight() {
        return (int) getResources().getDimension(c.color_select_layout_height);
    }

    public int getPaddingLeftAndRight() {
        return (int) (2.0f * this.uUA);
    }

    public int getCurColor() {
        if (this.uVs == -1) {
            return uUQ[2];
        }
        return uUQ[this.uVs];
    }
}
