package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends View {
    public int cA;
    private Paint cN = new Paint();
    private RectF gMn;
    private Matrix mMatrix;
    private int mRotateAngle;
    public int oTO;
    public int oTP;
    public int oTQ;
    private int oTR;
    private int oTS;
    private int oTT;
    private int oTU;
    private boolean oTV;

    public f(Context context) {
        super(context);
        this.cN.setStyle(Style.STROKE);
        this.cN.setColor(-65536);
        this.cN.setStrokeWidth((float) a.fromDPToPix(getContext(), 3));
        this.mMatrix = new Matrix();
    }

    public final void setFaceLocation(int[] iArr) {
        if (iArr != null) {
            this.oTR = iArr[0];
            this.oTS = iArr[1];
            this.oTT = iArr[2];
            this.oTU = iArr[3];
            if (this.oTP != 0 && this.oTQ != 0 && this.cA != 0 && this.oTO != 0) {
                int i;
                int i2;
                float f;
                float f2;
                int i3 = this.oTT - this.oTR;
                int i4 = this.oTU - this.oTS;
                x.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[]{Integer.valueOf(this.oTR), Integer.valueOf(this.oTS), Integer.valueOf(this.oTT), Integer.valueOf(this.oTT)});
                x.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[]{Integer.valueOf(this.oTP), Integer.valueOf(this.oTQ), Boolean.valueOf(this.oTV), Integer.valueOf(this.mRotateAngle)});
                int i5 = (this.oTT + this.oTR) / 2;
                int i6 = (this.oTU + this.oTS) / 2;
                if (this.mRotateAngle == 90 || this.mRotateAngle == aw.CTRL_BYTE) {
                    i = i5;
                    i2 = i6;
                } else {
                    i = i6;
                    i2 = i5;
                }
                x.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                if (this.mRotateAngle == 90 || this.mRotateAngle == aw.CTRL_BYTE) {
                    f = (float) (this.cA / this.oTP);
                    f2 = (float) (this.oTO / this.oTQ);
                } else {
                    f = (float) (this.oTO / this.oTP);
                    f2 = (float) (this.cA / this.oTQ);
                }
                f2 = Math.max(f, f2);
                f = (float) ((int) (((float) i3) * f2));
                float f3 = (float) ((int) (((float) i4) * f2));
                i2 = (int) (((float) i2) * f2);
                i = (int) (((float) i) * f2);
                this.oTR = dR((int) (((float) i2) - (f / 2.0f)), this.oTO);
                this.oTS = dR((int) (((float) i) - (f3 / 2.0f)), this.cA);
                this.oTT = dR((int) (((float) i2) + (f / 2.0f)), this.oTO);
                this.oTU = dR((int) (((float) i) + (f3 / 2.0f)), this.cA);
                this.gMn = new RectF((float) this.oTR, (float) this.oTS, (float) this.oTT, (float) this.oTU);
                x.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[]{Float.valueOf(this.gMn.left), Float.valueOf(this.gMn.top), Float.valueOf(this.gMn.right), Float.valueOf(this.gMn.bottom)});
            }
        }
    }

    private static int dR(int i, int i2) {
        int i3;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        return i3 > i2 ? i2 : i3;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.gMn != null) {
            canvas.save();
            canvas.rotate(0.0f);
            canvas.drawRect(this.gMn, this.cN);
            canvas.restore();
        }
    }

    public final void setMirror(boolean z) {
        this.oTV = z;
    }

    public final void setRotateAngle(int i) {
        this.mRotateAngle = i;
    }
}
