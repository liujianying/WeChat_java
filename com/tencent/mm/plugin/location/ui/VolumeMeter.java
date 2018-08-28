package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;

public class VolumeMeter extends ImageView implements Runnable {
    public boolean dRn = false;
    private Paint fBa;
    private float kHA = 0.0f;
    private float kHB = 40.0f;
    private float kHC = 30.0f;
    public boolean kHk = false;
    private View kHl;
    private int kHm = -1;
    private int kHn = -1;
    public ag kHo = null;
    private float kHp;
    private float kHq;
    private float kHr;
    private float kHs;
    private int kHt = -6751336;
    private int kHu = 70;
    private float kHv = 0.5f;
    private float kHw = 0.001f;
    private int kHx = 20;
    private float kHy;
    private float kHz;
    private Context mContext;

    public final void aZR() {
        if (this.kHo == null) {
            new ag().postDelayed(new 2(this), 100);
        } else {
            this.kHo.post(this);
        }
    }

    public void run() {
        if (this.dRn) {
            float f;
            float f2 = this.kHr;
            if (this.kHq > this.kHp) {
                f = (this.kHq - this.kHp) / this.kHC;
                if (f > this.kHv) {
                    f = this.kHv;
                } else if (f < this.kHw) {
                    f = this.kHw;
                }
                f += f2;
            } else if (this.kHq <= this.kHp) {
                f = (this.kHp - this.kHq) / this.kHB;
                if (f > this.kHv) {
                    f = this.kHv;
                } else if (f < this.kHw) {
                    f = this.kHw;
                }
                f = f2 - f;
            } else {
                f = f2;
            }
            this.kHr = f;
            this.kHs = this.kHr;
            this.kHA = ((float) ((260.0d * Math.sqrt((double) this.kHr)) - ((double) (130.0f * this.kHr)))) / 1.5f;
            postInvalidate();
            this.kHo.postDelayed(this, (long) this.kHx);
        }
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.fBa = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (this.kHl != null) {
            int[] iArr = new int[2];
            this.kHl.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.kHl.getWidth();
                int height = this.kHl.getHeight();
                if (!(width == 0 || height == 0)) {
                    int b = b.b(this.mContext, 50.0f);
                    this.kHm = iArr[0] + (width / 2);
                    this.kHn = (iArr[1] + (height / 2)) - (b / 2);
                    this.kHz = (float) (width / 2);
                    this.kHy = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.kHm >= 0 && this.kHn >= 0) {
            this.fBa.setColor(this.kHt);
            this.fBa.setAlpha(this.kHu);
            float b2 = (float) b.b(this.mContext, this.kHA);
            if (b2 > this.kHy) {
                b2 = this.kHy;
            }
            if (b2 < this.kHz) {
                b2 = this.kHz;
            }
            canvas.drawCircle((float) this.kHm, (float) this.kHn, b2, this.fBa);
        }
    }

    public final void reset() {
        this.kHA = 0.0f;
        this.kHp = 0.0f;
        this.kHq = 0.0f;
        this.kHr = 0.0f;
        this.kHs = 0.0f;
        postInvalidate();
    }

    public void setVolume(float f) {
        this.kHp = this.kHq;
        this.kHq = f;
    }

    public void setArchView(View view) {
        this.kHl = view;
    }
}
