package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;

public class FaceNumberItemView extends View {
    static final long iUd = 29;
    Timer iUc;
    private boolean iUe;
    private Paint iUf;
    private RectF iUg;
    private Bitmap iUh;
    private int iUi;
    int iUj;
    Runnable iUk;

    public FaceNumberItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUc = null;
        this.iUe = false;
        this.iUf = null;
        this.iUg = null;
        this.iUh = null;
        this.iUi = 17;
        this.iUj = 0;
        this.iUk = new 1(this);
        setLayerType(1, null);
        this.iUf = new Paint();
        this.iUf.setColor(context.getResources().getColor(b.face_number_shader_color));
        this.iUf.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.iUg = new RectF();
    }

    public void setImageResource(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (i == d.face_point) {
            int dimensionPixelSize = (getResources().getDimensionPixelSize(c.face_number_width) - a.fromDPToPix(getContext(), 8)) / 2;
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth() + (dimensionPixelSize * 2), decodeResource.getHeight() + 0, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 255, 255, 255);
            canvas.drawBitmap(decodeResource, (float) dimensionPixelSize, 0.0f, null);
            this.iUh = createBitmap;
            return;
        }
        this.iUh = Bitmap.createScaledBitmap(decodeResource, a.fromDPToPix(getContext(), 48), decodeResource.getHeight(), false);
    }

    public void setGravity(int i) {
        x.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
        this.iUi = i;
    }

    public final void aKM() {
        if (this.iUc != null) {
            this.iUc.cancel();
            this.iUc = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        float width;
        float height;
        super.onDraw(canvas);
        if (this.iUi == 17) {
            width = (float) ((getWidth() - this.iUh.getWidth()) >> 1);
            height = (float) ((getHeight() - this.iUh.getHeight()) >> 1);
        } else if (this.iUi == 3) {
            height = (float) ((getHeight() - this.iUh.getHeight()) >> 1);
            width = 0.0f;
        } else if (this.iUi == 5) {
            width = (float) (getWidth() - this.iUh.getWidth());
            height = (float) ((getHeight() - this.iUh.getHeight()) >> 1);
        } else {
            x.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
            width = (float) ((getWidth() - this.iUh.getWidth()) >> 1);
            height = (float) ((getHeight() - this.iUh.getHeight()) >> 1);
        }
        if (!this.iUe) {
            canvas.drawBitmap(this.iUh, width, height, null);
        }
        this.iUg.set(width, 0.0f, ((((float) this.iUh.getWidth()) * ((float) this.iUj)) / 30.0f) + width, (float) getHeight());
        canvas.drawRect(this.iUg, this.iUf);
    }
}
