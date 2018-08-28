package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.bp.a;

public class RoundedCornerRelativeLayout extends RelativeLayout {
    private Paint fBa;
    private Bitmap nGa;
    private a omP;

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        eh(context);
    }

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eh(context);
    }

    private void eh(Context context) {
        int fromDPToPix = a.fromDPToPix(context, 8);
        this.omP = new a(this, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        this.fBa = new Paint(1);
        this.fBa.setColor(-1);
        setWillNotDraw(false);
    }

    public void setRadius(int i) {
        this.omP.omQ = a.fromDPToPix(getContext(), i);
        this.omP.omR = a.fromDPToPix(getContext(), i);
        this.omP.omS = a.fromDPToPix(getContext(), i);
        this.omP.omT = a.fromDPToPix(getContext(), i);
        if (this.nGa != null) {
            this.nGa = null;
            postInvalidate();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.nGa == null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ALPHA_8);
                Canvas canvas2 = new Canvas(createBitmap);
                Paint paint = new Paint(1);
                paint.setColor(-1);
                canvas2.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
                paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
                RectF rectF = new RectF(0.0f, 0.0f, (float) this.omP.omQ, (float) this.omP.omQ);
                RectF rectF2 = new RectF((float) (width - this.omP.omR), 0.0f, (float) width, (float) this.omP.omR);
                RectF rectF3 = new RectF(0.0f, (float) (height - this.omP.omS), (float) this.omP.omS, (float) height);
                RectF rectF4 = new RectF((float) (width - this.omP.omT), (float) (height - this.omP.omT), (float) width, (float) height);
                Path path = new Path();
                path.moveTo(rectF.left, rectF.bottom);
                path.arcTo(rectF, 180.0f, 90.0f);
                path.lineTo(rectF2.left, rectF2.top);
                path.arcTo(rectF2, 270.0f, 90.0f);
                path.lineTo(rectF4.right, rectF4.top);
                path.arcTo(rectF4, 0.0f, 90.0f);
                path.lineTo(rectF3.right, rectF3.bottom);
                path.arcTo(rectF3, 90.0f, 90.0f);
                path.lineTo(rectF.left, rectF.bottom);
                canvas2.drawPath(path, paint);
                this.nGa = createBitmap;
            }
            canvas.drawBitmap(this.nGa, 0.0f, 0.0f, this.fBa);
        }
    }
}
