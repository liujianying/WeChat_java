package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar extends ProgressBar {
    private static SoftReference<Bitmap> udF = null;
    private static SoftReference<Bitmap> udG = null;
    private static SoftReference<Bitmap> udH = null;
    private static int udN;
    private static int udO;
    private boolean dRn = false;
    private float rotation = 0.0f;
    private int udB = 0;
    private int udC = 0;
    private boolean udD = false;
    private boolean udE = false;
    private Bitmap udI = null;
    private Bitmap udJ = null;
    private Bitmap udK = null;
    private boolean udL = false;
    private a udM = null;

    public interface a {
    }

    static {
        udN = 0;
        udO = 0;
        udN = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 1);
        udO = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 6);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        if (this.udL) {
            canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) this.udI.getWidth(), (float) this.udI.getHeight()), 255, 31);
            if (!this.dRn) {
                canvas.drawBitmap(this.udK, new Rect(0, 0, this.udK.getWidth(), this.udK.getHeight()), new Rect(udN, udO, this.udK.getWidth() + udN, this.udK.getHeight() + udO), null);
                return;
            } else if (this.udD) {
                if (this.udB <= this.udJ.getWidth()) {
                    Matrix matrix = new Matrix();
                    this.rotation += 6.0f;
                    matrix.setRotate(this.rotation, (float) (this.udI.getWidth() / 2), (float) (this.udI.getHeight() / 2));
                    int i = ((int) this.rotation) % 360;
                    if (i < 270) {
                        i += 360;
                    }
                    if (i >= 270 && i < 450) {
                        Paint paint = new Paint();
                        paint.setColor(-16776961);
                        canvas.drawBitmap(this.udI, matrix, paint);
                        paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                        canvas.drawRect(0.0f, 0.0f, (float) this.udI.getWidth(), (float) (this.udI.getHeight() / 2), paint);
                    }
                    canvas.drawBitmap(this.udJ, new Rect(0, 0, this.udB, this.udJ.getHeight()), new Rect(udN, udO, this.udB + udN, this.udJ.getHeight() + udO), null);
                    this.udB += 2;
                    invalidate();
                    return;
                }
                Rect rect = new Rect(0, 0, this.udJ.getWidth(), this.udJ.getHeight());
                Rect rect2 = new Rect(udN, udO, this.udJ.getWidth() + udN, this.udJ.getHeight() + udO);
                canvas.drawBitmap(this.udJ, rect, rect2, null);
                if (this.udC < 255) {
                    Paint paint2 = new Paint();
                    paint2.setAlpha(this.udC);
                    canvas.drawBitmap(this.udK, rect, rect2, paint2);
                    this.udC += 20;
                    invalidate();
                    return;
                }
                canvas.drawBitmap(this.udK, rect, rect2, null);
                this.dRn = false;
                this.rotation = 0.0f;
                this.udB = 0;
                this.udC = 0;
                this.udE = false;
                this.udD = false;
                return;
            } else if (((int) (this.rotation - 270.0f)) % 360 == 0 && this.udE) {
                this.udD = true;
                invalidate();
                return;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(this.rotation, (float) (this.udI.getWidth() / 2), (float) (this.udI.getHeight() / 2));
                canvas.drawBitmap(this.udI, matrix2, null);
                this.rotation += 6.0f;
                invalidate();
                return;
            }
        }
        super.onDraw(canvas);
    }

    public void setDrawListener(a aVar) {
        this.udM = aVar;
    }

    public a getDrawListener() {
        return this.udM;
    }
}
