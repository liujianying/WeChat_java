package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectDecorView extends View {
    public boolean iTB;
    public boolean iTC;
    public boolean iTD;
    public RectF iTE;
    private Paint iTF;

    public FaceDetectDecorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectDecorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iTB = false;
        this.iTC = false;
        this.iTD = false;
        this.iTE = null;
        this.iTF = null;
        this.iTF = new Paint();
        this.iTF.setColor(getResources().getColor(b.black));
        this.iTF.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        setLayerType(1, null);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[]{Boolean.valueOf(this.iTC), Boolean.valueOf(this.iTB), this.iTE});
        if (this.iTC != this.iTB || this.iTD) {
            if (this.iTC) {
                canvas.drawColor(getResources().getColor(b.face_cover));
                canvas.drawRect(this.iTE, this.iTF);
            } else {
                canvas.drawColor(getResources().getColor(b.transparent));
            }
        }
        this.iTB = this.iTC;
    }
}
