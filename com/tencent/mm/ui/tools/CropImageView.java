package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.e.b.c;
import java.util.Timer;

public class CropImageView extends ImageView {
    int bRV = 0;
    private Timer gei = new Timer(true);
    private float hlo;
    Bitmap jDx;
    private float jUm;
    private long kHe;
    private OnTouchListener lmH = new 3(this);
    float nMZ = 0.0f;
    float nNa = 0.0f;
    private boolean nWF = false;
    private float translateX = 0.0f;
    private float translateY = 0.0f;
    private boolean tzG = false;
    private Drawable tzH;
    private boolean uwA = false;
    private Timer uwB;
    private ag uwC = new 1(this);
    private b uwD = null;
    private ag uwE = new ag() {
        public final void handleMessage(Message message) {
            if (message.what != 4653) {
                CropImageView.o(CropImageView.this);
            } else if (!(CropImageView.this.gei == null || CropImageView.this.uwD == null)) {
                CropImageView.this.uwD.cancel();
                CropImageView.this.uwD = null;
            }
            super.handleMessage(message);
        }
    };
    private a uwF;
    private boolean uwG = true;
    private boolean uwl = true;
    private boolean uwm = false;
    private float uwn;
    private float uwo;
    private PointF uwp = new PointF();
    boolean uwq = false;
    private boolean uwr = false;
    private boolean uws = false;
    private boolean uwt = false;
    private boolean uwu = false;
    private boolean uwv = false;
    private boolean uww = false;
    private boolean uwx = false;
    private float uwy = 1.0f;
    private c uwz = null;

    static /* synthetic */ void o(CropImageView cropImageView) {
        if (cropImageView.uwu) {
            cropImageView.translateX -= -20.0f;
            if (cropImageView.translateX > 0.0f) {
                cropImageView.uwu = false;
            }
            cropImageView.getImageMatrix().postTranslate(-20.0f, 0.0f);
        }
        if (cropImageView.uwv) {
            cropImageView.translateX -= 20.0f;
            if (cropImageView.translateX < 0.0f) {
                cropImageView.uwv = false;
            }
            cropImageView.getImageMatrix().postTranslate(20.0f, 0.0f);
        }
        if (cropImageView.uww) {
            cropImageView.translateY -= 20.0f;
            if (cropImageView.translateY < 0.0f) {
                cropImageView.uww = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, 20.0f);
        }
        if (cropImageView.uwx) {
            cropImageView.translateY -= -20.0f;
            if (cropImageView.translateY > 0.0f) {
                cropImageView.uwx = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, -20.0f);
        }
        cropImageView.setImageBitmap(cropImageView.jDx);
        cropImageView.invalidate();
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        czG();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.tzG = false;
        this.jDx = bitmap;
        f.a(this.uwp, bitmap);
        super.setImageBitmap(bitmap);
    }

    public void setLimitZoomIn(boolean z) {
        this.uwl = z;
    }

    public void setEnableOprate(boolean z) {
        this.uwG = z;
    }

    public Bitmap getBmp() {
        return this.jDx;
    }

    public void setOnShortClick(a aVar) {
        this.uwF = aVar;
    }

    public final void czG() {
        setOnTouchListener(this.lmH);
    }

    public final void zoomIn() {
        this.uwy *= 1.0666f;
        if (1.0f <= this.uwy) {
            this.uwt = false;
        }
        if (1.6f < this.uwy) {
            this.uws = true;
        } else {
            this.uws = false;
        }
        if (!this.uwl || 4.0f >= this.uwy) {
            float[] fArr = new float[2];
            r1 = new float[2];
            float f = this.uwp.x;
            r1[0] = f;
            fArr[0] = f;
            f = this.uwp.y;
            r1[1] = f;
            fArr[1] = f;
            getImageMatrix().mapPoints(fArr);
            getImageMatrix().postScale(1.0666f, 1.0666f);
            getImageMatrix().mapPoints(r1);
            getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
            setImageBitmap(this.jDx);
            invalidate();
            return;
        }
        this.uwy = 4.0f;
    }

    public final void zoomOut() {
        this.uwy *= 0.9375f;
        if (1.6f > this.uwy) {
            this.uws = false;
        }
        if (1.0f > this.uwy) {
            this.uwt = true;
        } else {
            this.uwt = false;
        }
        if (0.4f > this.uwy) {
            this.uwy = 0.4f;
            return;
        }
        float[] fArr = new float[2];
        r1 = new float[2];
        float f = this.uwp.x;
        r1[0] = f;
        fArr[0] = f;
        f = this.uwp.y;
        r1[1] = f;
        fArr[1] = f;
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postScale(0.9375f, 0.9375f);
        getImageMatrix().mapPoints(r1);
        getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
        setImageBitmap(this.jDx);
        invalidate();
    }

    public int getRotateCount() {
        return this.bRV;
    }

    public void setGifPath(String str) {
        try {
            this.tzG = true;
            this.tzH = c.gj(str, str);
            setImageDrawable(this.tzH);
        } catch (Exception e) {
            this.tzG = false;
        }
    }

    public int getGifWidth() {
        if (!this.tzG || this.tzH == null) {
            return getWidth();
        }
        return this.tzH.getIntrinsicWidth();
    }

    public int getGifHeight() {
        if (!this.tzG || this.tzH == null) {
            return getHeight();
        }
        return this.tzH.getIntrinsicHeight();
    }
}
