package com.tencent.mm.ui.widget.textview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

class a$b extends View {
    private Paint cN;
    private int hPK = 25;
    private int mHeight = (this.qrL * 2);
    int mWidth = (this.qrL * 2);
    private int qrL = (this.uPp.uPj / 2);
    final /* synthetic */ a uPp;
    public PopupWindow uPs;
    boolean uPt;
    private int uPu;
    private int uPv;
    private int uPw;
    private int uPx;
    int[] uPy = new int[2];

    a$b(a aVar, boolean z) {
        this.uPp = aVar;
        super(aVar.mContext);
        this.uPt = z;
        this.cN = new Paint(1);
        this.cN.setColor(aVar.mContext.getResources().getColor(aVar.uPi));
        this.uPs = new PopupWindow(this);
        this.uPs.setClippingEnabled(false);
        this.uPs.setWidth(this.mWidth + (this.hPK * 2));
        this.uPs.setHeight(this.mHeight + (this.hPK / 2));
        invalidate();
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawCircle((float) (this.qrL + this.hPK), (float) this.qrL, (float) this.qrL, this.cN);
        if (this.uPt) {
            canvas.drawRect((float) (this.qrL + this.hPK), 0.0f, (float) ((this.qrL * 2) + this.hPK), (float) this.qrL, this.cN);
            return;
        }
        canvas.drawRect((float) this.hPK, 0.0f, (float) (this.qrL + this.hPK), (float) this.qrL, this.cN);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.uPw = this.uPp.uPb.Tw;
                this.uPx = this.uPp.uPb.tK;
                this.uPu = (int) motionEvent.getX();
                this.uPv = (int) motionEvent.getY();
                break;
            case 1:
            case 3:
                this.uPp.cBp();
                break;
            case 2:
                this.uPp.uPe.ctb();
                int rawX = (((int) motionEvent.getRawX()) + this.uPu) - this.mWidth;
                int rawY = (this.uPv + ((int) motionEvent.getRawY())) - this.mHeight;
                this.uPp.ih.getLocationInWindow(this.uPy);
                int i = this.uPt ? this.uPp.uPb.Tw : this.uPp.uPb.tK;
                int i2 = rawY - this.uPy[1];
                TextView textView = this.uPp.ih;
                Layout layout = textView.getLayout();
                if (layout != null) {
                    int lineRight;
                    int lineBottom;
                    int i3;
                    int lineForVertical = layout.getLineForVertical(i2);
                    if (b.a(layout, i)) {
                        lineRight = (int) layout.getLineRight(lineForVertical);
                        if (rawX > lineRight - ((lineRight - ((int) layout.getPrimaryHorizontal(i - 1))) / 2)) {
                            rawY = i - 1;
                            rawY = layout.getLineForOffset(rawY);
                            lineRight = layout.getLineTop(rawY);
                            lineBottom = layout.getLineBottom(rawY);
                            i3 = (lineBottom - lineRight) / 2;
                            if ((lineForVertical != rawY + 1 || i2 - lineBottom >= i3) && (lineForVertical != rawY - 1 || lineRight - i2 >= i3)) {
                                rawY = lineForVertical;
                            }
                            lineForVertical = layout.getOffsetForHorizontal(rawY, (float) rawX);
                            if (lineForVertical < textView.getText().length() - 1 && b.a(layout, lineForVertical + 1)) {
                                rawY = (int) layout.getLineRight(rawY);
                                if (rawX > rawY - ((rawY - ((int) layout.getPrimaryHorizontal(lineForVertical))) / 2)) {
                                    rawY = lineForVertical + 1;
                                }
                            }
                            rawY = lineForVertical;
                        }
                    }
                    rawY = i;
                    rawY = layout.getLineForOffset(rawY);
                    lineRight = layout.getLineTop(rawY);
                    lineBottom = layout.getLineBottom(rawY);
                    i3 = (lineBottom - lineRight) / 2;
                    rawY = lineForVertical;
                    lineForVertical = layout.getOffsetForHorizontal(rawY, (float) rawX);
                    rawY = (int) layout.getLineRight(rawY);
                    if (rawX > rawY - ((rawY - ((int) layout.getPrimaryHorizontal(lineForVertical))) / 2)) {
                        rawY = lineForVertical + 1;
                    }
                    rawY = lineForVertical;
                    break;
                }
                rawY = -1;
                if (rawY != i) {
                    this.uPp.cBo();
                    a$b a;
                    if (!this.uPt) {
                        if (rawY < this.uPw) {
                            a = a.a(this.uPp, true);
                            a.cBq();
                            cBq();
                            this.uPx = this.uPw;
                            this.uPp.fp(rawY, this.uPw);
                            a.cBr();
                        } else {
                            this.uPp.fp(this.uPw, rawY);
                        }
                        cBr();
                        break;
                    }
                    if (rawY > this.uPx) {
                        a = a.a(this.uPp, false);
                        cBq();
                        a.cBq();
                        this.uPw = this.uPx;
                        this.uPp.fp(this.uPx, rawY);
                        a.cBr();
                    } else {
                        this.uPp.fp(rawY, -1);
                    }
                    cBr();
                    break;
                }
                break;
        }
        return true;
    }

    private void cBq() {
        this.uPt = !this.uPt;
        invalidate();
    }

    private void cBr() {
        this.uPp.ih.getLocationInWindow(this.uPy);
        Layout layout = this.uPp.ih.getLayout();
        if (layout != null) {
            int i = (int) layout.getPaint().getFontMetrics().descent;
            if (this.uPt) {
                this.uPs.update((((int) layout.getPrimaryHorizontal(this.uPp.uPb.Tw)) - this.mWidth) + getExtraX(), (layout.getLineBaseline(layout.getLineForOffset(this.uPp.uPb.Tw)) + i) + getExtraY(), -1, -1);
                return;
            }
            int[] fq = fq((int) layout.getPrimaryHorizontal(this.uPp.uPb.tK), layout.getLineBaseline(layout.getLineForOffset(this.uPp.uPb.tK)) + i);
            this.uPs.update(fq[0] + getExtraX(), fq[1] + getExtraY(), -1, -1);
        }
    }

    public final int getExtraX() {
        return (this.uPy[0] - this.hPK) + this.uPp.ih.getPaddingLeft();
    }

    public final int getExtraY() {
        return this.uPy[1] + this.uPp.ih.getPaddingTop();
    }

    final int[] fq(int i, int i2) {
        int[] iArr = new int[2];
        if (i == 0 && this.uPp.uPb.tK > 1) {
            this.uPp.ih.getLocationInWindow(this.uPy);
            Layout layout = this.uPp.ih.getLayout();
            if (layout != null) {
                i = (int) layout.getLineWidth(layout.getLineForOffset(this.uPp.uPb.tK - 1));
                i2 = layout.getLineBaseline(layout.getLineForOffset(this.uPp.uPb.tK - 1)) + ((int) layout.getPaint().getFontMetrics().descent);
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }
}
