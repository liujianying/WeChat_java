package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends View {
    private Paint cN = new Paint();
    int mHeight;
    int mWidth;
    private Bitmap qbK;
    private Bitmap qbL;
    private Canvas qbM;
    private Paint qbN = new Paint();
    private Rect qbO;
    private RectF qbP;
    private int qbQ;
    int qbR;
    int qbS;
    int qbT;
    int qbU = -1;
    boolean qbV;
    private AnimatorListenerAdapter qbW;

    public i(Context context, Bitmap bitmap) {
        super(context);
        this.qbN.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.qbK = bitmap;
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.qbO = new Rect(0, 0, this.mWidth, this.mHeight);
        this.qbL = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        this.qbM = new Canvas(this.qbL);
        this.qbP = new RectF();
        this.qbP.left = 0.0f;
        this.qbP.top = 0.0f;
        this.qbP.right = (float) this.mWidth;
        this.qbP.bottom = (float) this.mHeight;
        x.i("MicroMsg.TransformToBagAniMask", String.format("init: mWidth:%d mHeight:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)}));
    }

    public final void setContentStartPosX(int i) {
        this.qbU = i;
    }

    public final void setListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.qbW = animatorListenerAdapter;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.qbV) {
            canvas.save();
            canvas.translate((float) this.qbQ, 0.0f);
        }
        canvas.drawBitmap(this.qbK, this.qbO, this.qbO, this.cN);
        this.qbM.drawColor(0, Mode.CLEAR);
        this.qbM.drawRoundRect(this.qbP, (float) this.qbR, (float) this.qbR, this.cN);
        canvas.drawBitmap(this.qbL, this.qbO, this.qbO, this.qbN);
        if (this.qbV) {
            canvas.restore();
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }
}
