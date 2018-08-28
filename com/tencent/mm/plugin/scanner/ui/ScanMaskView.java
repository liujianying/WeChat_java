package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView extends View {
    private Paint cN;
    private Bitmap mJC = null;
    private Bitmap mJD = null;
    private Bitmap mJE = null;
    private Bitmap mJF = null;
    int mJG = 0;
    int mJH = 0;
    private boolean mJI = false;
    private Rect mJJ = new Rect();
    private Rect mJK = new Rect();
    private Rect mJL = new Rect();
    private Rect mJM = new Rect();
    private Rect mJN = new Rect();
    private Rect mJO = new Rect();
    private Rect mJP = new Rect();
    private Rect mJQ = new Rect();
    private Rect mJR = new Rect();
    private Path mJS = new Path();
    Rect mJT;
    private PorterDuffXfermode mJU;
    private int mJV = R.e.scan_mask_bg_color;
    private long mJW = 0;
    boolean mJX = false;
    Rect mJY;
    private final long mJZ = 200;
    float mKa = 0.0f;
    float mKb = 0.0f;
    float mKc = 0.0f;
    float mKd = 0.0f;
    private Paint mKe;
    ValueAnimator mKf = null;

    public ScanMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanMaskView(Context context, Rect rect) {
        super(context);
        this.mJT = rect;
        getDrawingRect(this.mJJ);
        this.cN = new Paint();
        this.mJC = a.decodeResource(getResources(), R.g.scanqr1);
        this.mJD = a.decodeResource(getResources(), R.g.scanqr2);
        this.mJE = a.decodeResource(getResources(), R.g.scanqr3);
        this.mJF = a.decodeResource(getResources(), R.g.scanqr4);
        this.mJG = this.mJC.getWidth();
        this.mJH = this.mJC.getHeight();
        this.mKe = new Paint();
        this.mJU = new PorterDuffXfermode(Mode.CLEAR);
    }

    public final void bsL() {
        this.mJI = true;
        if (this.mJC != null) {
            this.mJC.recycle();
            this.mJC = null;
        }
        if (this.mJD != null) {
            this.mJD.recycle();
            this.mJD = null;
        }
        if (this.mJE != null) {
            this.mJE.recycle();
            this.mJE = null;
        }
        if (this.mJF != null) {
            this.mJF.recycle();
            this.mJF = null;
        }
    }

    public Rect getMaskRect() {
        return this.mJT;
    }

    public long getMaskAnimDuration() {
        return 200;
    }

    public void setMaskColorRsid(int i) {
        this.mJV = i;
    }

    protected void onDraw(Canvas canvas) {
        if (this.mJT != null && !this.mJI) {
            System.currentTimeMillis();
            System.currentTimeMillis();
            int save = canvas.save();
            this.cN.reset();
            if (d.fS(18)) {
                this.mJO.left = 0;
                this.mJO.top = this.mJT.top;
                this.mJO.right = this.mJT.left;
                this.mJO.bottom = this.mJT.bottom;
                this.mJP.left = this.mJT.left;
                this.mJP.top = 0;
                this.mJP.right = this.mJT.right;
                this.mJP.bottom = this.mJT.top;
                this.mJQ.left = this.mJT.right;
                this.mJQ.top = this.mJT.top;
                this.mJQ.right = getWidth();
                this.mJQ.bottom = this.mJT.bottom;
                this.mJR.left = this.mJT.left;
                this.mJR.top = this.mJT.bottom;
                this.mJR.right = this.mJT.right;
                this.mJR.bottom = getHeight();
                this.mJK.left = 0;
                this.mJK.top = 0;
                this.mJK.right = this.mJT.left;
                this.mJK.bottom = this.mJT.top;
                this.mJL.left = this.mJT.right;
                this.mJL.top = 0;
                this.mJL.right = getWidth();
                this.mJL.bottom = this.mJT.top;
                this.mJM.left = 0;
                this.mJM.top = this.mJT.bottom;
                this.mJM.right = this.mJT.left;
                this.mJM.bottom = getHeight();
                this.mJN.left = this.mJT.right;
                this.mJN.top = this.mJT.bottom;
                this.mJN.right = getWidth();
                this.mJN.bottom = getHeight();
                canvas.save();
                canvas.clipRect(this.mJO, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJP, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJQ, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJR, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJK, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJL, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJM, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.mJN, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.mJV));
                canvas.restore();
            } else {
                canvas.clipRect(this.mJT, Op.DIFFERENCE);
                canvas.drawColor(getResources().getColor(this.mJV));
            }
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.restoreToCount(save);
            this.cN.reset();
            this.cN.setStyle(Style.STROKE);
            this.cN.setStrokeWidth(1.0f);
            this.cN.setColor(-3355444);
            this.cN.setAntiAlias(true);
            canvas.drawRect(this.mJT, this.cN);
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.drawBitmap(this.mJC, (float) this.mJT.left, (float) this.mJT.top, this.mKe);
            canvas.drawBitmap(this.mJD, (float) (this.mJT.right - this.mJG), (float) this.mJT.top, this.mKe);
            canvas.drawBitmap(this.mJE, (float) this.mJT.left, (float) (this.mJT.bottom - this.mJH), this.mKe);
            canvas.drawBitmap(this.mJF, (float) (this.mJT.right - this.mJG), (float) (this.mJT.bottom - this.mJH), this.mKe);
            System.currentTimeMillis();
            super.onDraw(canvas);
            System.currentTimeMillis();
        }
    }
}
