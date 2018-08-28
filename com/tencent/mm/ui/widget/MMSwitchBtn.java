package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mm.bw.a$i;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.d;
import com.tencent.mm.bw.a.k;
import com.tencent.mm.ui.ap;

public class MMSwitchBtn extends View {
    private int edgePadding;
    private int jVn;
    private Paint lwr = new Paint(1);
    private int maxHeight;
    private int maxWidth;
    private float omu;
    private float omv;
    private long uGF;
    private int uGG;
    private int uGH;
    private int uGI;
    private boolean uGJ = false;
    private boolean uGK = false;
    private float uGL;
    private float uGM;
    private int uGN;
    private int uGO;
    private int uGP;
    public boolean uGQ = false;
    private RectF uGR = new RectF();
    private RectF uGS = new RectF();
    private int uGT;
    private int uGU;
    private int uGV;
    private String uGW;
    private String uGX;
    private b uGY = new b(this, (byte) 0);
    private a uGZ;

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        b(context.obtainStyledAttributes(attributeSet, k.MMSwitchBtn));
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        b(context.obtainStyledAttributes(attributeSet, k.MMSwitchBtn));
    }

    private void init() {
        this.edgePadding = getResources().getDimensionPixelSize(d.SmallestPadding);
        this.uGL = (float) getResources().getDimensionPixelSize(d.SwitchBtnRadiusOut);
        this.uGM = (float) getResources().getDimensionPixelSize(d.SwitchBtnRadiusIn);
        this.uGN = getResources().getColor(c.white);
        this.uGO = getResources().getColor(c.switch_btn_off_color);
        this.uGP = getResources().getColor(c.switch_btn_on_color);
        this.uGU = this.uGP;
        this.uGT = this.uGO;
        this.uGV = this.uGN;
        this.jVn = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void b(TypedArray typedArray) {
        this.uGU = typedArray.getColor(k.MMSwitchBtn_on_color, this.uGP);
        this.uGT = typedArray.getColor(k.MMSwitchBtn_off_color, this.uGO);
        this.uGV = typedArray.getColor(k.MMSwitchBtn_slide_color, this.uGN);
        this.uGW = typedArray.getString(k.MMSwitchBtn_on_text);
        this.uGX = typedArray.getString(k.MMSwitchBtn_off_text);
        typedArray.recycle();
    }

    public void setCheck(boolean z) {
        if (this.uGQ != z) {
            clearAnimation();
            this.uGQ = z;
            cAu();
            this.uGJ = false;
            invalidate();
        }
        setContentDescription(z ? getContext().getString(a$i.switch_check_desc) : getContext().getString(a$i.switch_uncheck_desc));
    }

    public void setSwitchListener(a aVar) {
        this.uGZ = aVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.maxWidth = i3 - i;
        this.maxHeight = i4 - i2;
        this.uGH = (this.maxWidth - ((int) (this.uGM * 2.0f))) - (this.edgePadding * 2);
        this.uGG = this.uGH / 2;
        this.uGI = getResources().getDimensionPixelSize(d.SwitchBtnHeight);
        if (this.uGI < this.maxHeight) {
            this.uGR.top = (float) ((this.maxHeight - this.uGI) / 2);
            this.uGR.bottom = this.uGR.top + ((float) this.uGI);
        } else {
            this.uGR.top = 0.0f;
            this.uGR.bottom = (float) this.maxHeight;
        }
        this.uGR.left = 0.0f;
        this.uGR.right = (float) this.maxWidth;
        cAu();
        this.lwr.setStyle(Style.FILL);
        this.lwr.setColor(this.uGO);
    }

    private void cAu() {
        if (this.uGI < this.maxHeight) {
            this.uGS.top = (float) (((this.maxHeight - this.uGI) / 2) + this.edgePadding);
            this.uGS.bottom = (this.uGS.top + ((float) this.uGI)) - ((float) (this.edgePadding * 2));
        } else {
            this.uGS.top = (float) this.edgePadding;
            this.uGS.bottom = (float) (this.maxHeight - this.edgePadding);
        }
        if (this.uGQ) {
            this.uGS.left = (float) (this.uGH + this.edgePadding);
            this.uGS.right = (float) (this.maxWidth - this.edgePadding);
            return;
        }
        this.uGS.left = (float) this.edgePadding;
        this.uGS.right = (float) (((int) (this.uGM * 2.0f)) + this.edgePadding);
    }

    private void cAv() {
        if (this.uGS.left < ((float) this.edgePadding)) {
            this.uGS.left = (float) this.edgePadding;
        }
        if (this.uGS.left > ((float) (this.uGH + this.edgePadding))) {
            this.uGS.left = (float) (this.uGH + this.edgePadding);
        }
        this.uGS.right = this.uGS.left + ((float) ((int) (this.uGM * 2.0f)));
    }

    private void mB(boolean z) {
        this.uGJ = true;
        this.uGY.reset();
        if (z) {
            this.uGY.uHb = (((long) this.uGH) - ((long) this.uGS.left)) + ((long) this.edgePadding);
            this.uGY.direction = 1;
        } else {
            this.uGY.uHb = (long) this.uGS.left;
            this.uGY.direction = 0;
        }
        this.uGY.uHa = this.uGS.left;
        this.uGY.setDuration((80 * this.uGY.uHb) / ((long) this.uGH));
        startAnimation(this.uGY);
    }

    private void em(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void czX() {
        if (this.uGS.left > ((float) this.uGG)) {
            mB(true);
        } else {
            mB(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.uGJ && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.omu = motionEvent.getX();
                    this.omv = motionEvent.getY();
                    this.uGF = SystemClock.elapsedRealtime();
                    this.uGK = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.uGF < 300) {
                        mB(!this.uGQ);
                    } else {
                        czX();
                    }
                    em(false);
                    this.uGK = false;
                    break;
                case 2:
                    float x;
                    if (this.uGK) {
                        em(true);
                        x = motionEvent.getX() - this.omu;
                        RectF rectF = this.uGS;
                        rectF.left = x + rectF.left;
                        cAv();
                    } else {
                        float x2 = motionEvent.getX() - this.omu;
                        x = motionEvent.getY() - this.omv;
                        if (Math.abs(x2) >= ((float) this.jVn) / 10.0f) {
                            if (x == 0.0f) {
                                x = 1.0f;
                            }
                            if (Math.abs(x2 / x) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.uGK = true;
                            em(true);
                        }
                    }
                    this.omu = motionEvent.getX();
                    this.omv = motionEvent.getY();
                    break;
                case 3:
                    if (this.uGK) {
                        czX();
                    }
                    em(false);
                    this.uGK = false;
                    break;
            }
            if (this.uGK) {
                invalidate();
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        this.lwr.setColor(this.uGT);
        this.lwr.setAlpha(255);
        canvas.drawRoundRect(this.uGR, this.uGL, this.uGL, this.lwr);
        this.lwr.setColor(this.uGU);
        this.lwr.setAlpha(Math.min(255, (int) (((this.uGS.left - ((float) this.edgePadding)) / ((float) this.uGH)) * 255.0f)));
        canvas.drawRoundRect(this.uGR, this.uGL, this.uGL, this.lwr);
        this.lwr.setColor(this.uGV);
        canvas.drawRoundRect(this.uGS, this.uGM, this.uGM, this.lwr);
        if (this.uGW != null && this.uGX != null) {
            Paint paint = new Paint();
            paint.setTextSize(getResources().getDimension(d.SmallTextSize));
            paint.setTextAlign(Align.CENTER);
            paint.setColor(getResources().getColor(c.white_text_color));
            paint.setAntiAlias(true);
            int min = Math.min(255, (int) (((this.uGS.left - ((float) this.edgePadding)) / ((float) this.uGH)) * 255.0f));
            Rect rect = new Rect();
            paint.getTextBounds(this.uGW, 0, this.uGW.length(), rect);
            paint.setAlpha(min);
            float height = ((((float) rect.height()) / 2.0f) + ((this.uGR.top + this.uGR.bottom) / 2.0f)) - ((float) ap.fromDPToPix(getContext(), 1));
            canvas.drawText(this.uGW, (((this.uGR.left + this.uGR.right) / 2.0f) - this.uGM) + ((float) ap.fromDPToPix(getContext(), 1)), height, paint);
            float fromDPToPix = (((this.uGR.left + this.uGR.right) / 2.0f) + this.uGM) - ((float) ap.fromDPToPix(getContext(), 1));
            paint.setAlpha(255 - min);
            canvas.drawText(this.uGX, fromDPToPix, height, paint);
        }
    }
}
