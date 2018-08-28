package com.tencent.mm.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.a;

public abstract class b<T extends d> {
    public static final b bBs = new b() {
        public final a vE() {
            return a.bBg;
        }

        public final void vF() {
        }

        public final void onDraw(Canvas canvas) {
        }
    };
    public com.tencent.mm.bi.b bBn;
    private Matrix bBo;
    Rect bBp;
    private boolean bBq;
    private Bitmap bBr;
    private Canvas bBt = new Canvas();
    private Runnable bBu;
    PointF bBv = new PointF();
    private PointF bBw = new PointF();
    public boolean isCreated;
    private Context mContext;
    float[] values = new float[9];

    public abstract void onDraw(Canvas canvas);

    public abstract a vE();

    public abstract void vF();

    public final void b(Canvas canvas) {
        if (this.bBr != null && !this.bBr.isRecycled()) {
            canvas.drawBitmap(this.bBr, 0.0f, 0.0f, null);
        }
    }

    public final T vG() {
        return this.bBn.a(vE());
    }

    public void a(com.tencent.mm.bi.b bVar, Matrix matrix, Rect rect) {
        x.i("MicroMsg.BaseArtist" + vE(), "[onCreate]");
        this.isCreated = true;
        this.mContext = bVar.getContext();
        this.bBn = bVar;
        this.bBo = matrix;
        this.bBp = rect;
    }

    public void vH() {
        x.i("MicroMsg.BaseArtist" + vE(), "[onAlive] isAlive:%s", new Object[]{Boolean.valueOf(this.bBq)});
        if (!this.bBq) {
            this.bBq = true;
            d vG = vG();
            if (vG != null) {
                vG.yo();
                vG.aV(false);
            } else {
                x.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[]{vE()});
            }
            this.bBr = vL();
        }
    }

    public void vI() {
        x.i("MicroMsg.BaseArtist" + vE(), "[onSelected] ");
    }

    public final void onFinish() {
        x.i("MicroMsg.BaseArtist", "[onFinish] type:%s", new Object[]{vE()});
        this.bBq = false;
        this.isCreated = false;
        d vG = vG();
        if (vG != null) {
            vG.aV(true);
        } else {
            x.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", new Object[]{vE()});
        }
        vJ();
    }

    public void onDestroy() {
        this.isCreated = false;
        this.bBq = false;
        x.i("MicroMsg.BaseArtist" + vE(), "[onDestroy]");
        vJ();
    }

    public final void vJ() {
        if (this.bBr != null && !this.bBr.isRecycled()) {
            this.bBr.recycle();
        }
    }

    public boolean vK() {
        try {
            if (vG().aW(true) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void aH(boolean z) {
        this.bBt.setBitmap(vL());
        vG().a(this.bBt, z);
    }

    protected final Bitmap vL() {
        if (this.bBr == null || this.bBr.isRecycled()) {
            int width;
            int height;
            Rect imageBitmapRect = this.bBn.cfQ().getBaseBoardView().getImageBitmapRect();
            if (imageBitmapRect.isEmpty() || !this.bBn.cfQ().getBaseBoardView().cCg()) {
                width = this.bBn.cfQ().getBaseBoardView().getBoardRect().width();
                height = this.bBn.cfQ().getBaseBoardView().getBoardRect().height();
            } else {
                width = imageBitmapRect.width();
                height = imageBitmapRect.height();
            }
            this.bBr = Bitmap.createBitmap(width, height, Config.ARGB_4444);
        }
        return this.bBr;
    }

    protected final void h(Bitmap bitmap) {
        if (!(vL() == null || vL().isRecycled())) {
            vL().recycle();
        }
        this.bBr = bitmap;
    }

    public final void setOneFingerMoveEnable(boolean z) {
        this.bBn.cfQ().getBaseBoardView().setOneFingerMoveEnable(z);
    }

    public final boolean isAlive() {
        return this.isCreated && this.bBq;
    }

    protected final boolean vM() {
        return this.bBn.cfR().vE() == vE();
    }

    public final void vN() {
        if (vG().pop() != null) {
            vG().vN();
        }
        this.bBn.cfQ().removeCallbacks(this.bBu);
        a cfQ = this.bBn.cfQ();
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                b.this.vF();
                b.this.vO();
                b.this.bBu = null;
            }
        };
        this.bBu = anonymousClass2;
        cfQ.postDelayed(anonymousClass2, 66);
    }

    public boolean q(MotionEvent motionEvent) {
        if (u(motionEvent)) {
            t(motionEvent);
        }
        return false;
    }

    protected final Rect getBoardRect() {
        return this.bBn.cfQ().getBaseBoardView().getBoardRect();
    }

    public final Matrix getMainMatrix() {
        return this.bBn.cfQ().getBaseBoardView().getMainMatrix();
    }

    public final void vO() {
        this.bBn.cfQ().getBaseBoardView().postInvalidate();
    }

    public final void vP() {
        this.bBn.cfQ().getBaseFooterView().postInvalidate();
    }

    public final float getScale() {
        float a = a(this.bBo, 3);
        float a2 = a(this.bBo, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) a(this.bBo, 1), (double) a(this.bBo, 0)) * 57.29577951308232d);
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    protected final float[] w(float f, float f2) {
        Matrix matrix = new Matrix(this.bBo);
        this.bBo.invert(matrix);
        float[] fArr = new float[]{f, f2};
        matrix.mapPoints(fArr);
        return fArr;
    }

    protected final float[] x(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        this.bBo.mapPoints(fArr);
        return fArr;
    }

    protected static int r(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    protected static int[] s(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    protected final void t(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            this.bBw.x = motionEvent.getX(1);
            this.bBw.y = motionEvent.getY(1);
        } else if (motionEvent.getPointerCount() == 1) {
            this.bBv.x = motionEvent.getX(0);
            this.bBv.y = motionEvent.getY(0);
        }
        if (motionEvent.getActionMasked() != 6) {
            return;
        }
        if (motionEvent.getPointerCount() <= 1 || 1 - motionEvent.getActionIndex() < 0 || 1 - motionEvent.getActionIndex() >= motionEvent.getPointerCount()) {
            this.bBv.x = motionEvent.getX(0);
            this.bBv.y = motionEvent.getY(0);
            return;
        }
        this.bBv.x = motionEvent.getX(1 - motionEvent.getActionIndex());
        this.bBv.y = motionEvent.getY(1 - motionEvent.getActionIndex());
    }

    protected final boolean u(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (Math.abs(this.bBv.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.bBv.y - motionEvent.getY(0)) > 3.0f || Math.abs(this.bBw.x - motionEvent.getX(1)) > 3.0f || Math.abs(this.bBw.y - motionEvent.getY(1)) > 3.0f) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() != 1) {
            return false;
        } else {
            if (Math.abs(this.bBv.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.bBv.y - motionEvent.getY(0)) > 3.0f) {
                return true;
            }
            return false;
        }
    }
}
