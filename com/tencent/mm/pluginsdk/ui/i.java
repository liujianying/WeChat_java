package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class i extends BitmapDrawable implements com.tencent.mm.pluginsdk.ui.d.a {
    protected static final Paint dvs;
    protected static final ag dvt = new ag(Looper.getMainLooper());
    private Runnable dvv;
    private Paint fBa = new Paint();
    protected final a lZs;
    protected boolean lkD = false;
    protected boolean qFD = false;
    private int qFE = 0;
    private int qFF = 0;
    protected boolean qFG;
    protected boolean qFH;
    protected float qFI = 1.0f;
    private PaintFlagsDrawFilter qFJ = new PaintFlagsDrawFilter(0, 3);
    private Path qFK;
    private Rect rect = new Rect();
    protected String tag;

    public interface a {
        void a(i iVar);

        Bitmap b(String str, int i, int i2, int i3);

        Bitmap cJ(String str);

        Bitmap cK(String str);

        Bitmap uM();
    }

    static {
        Paint paint = new Paint();
        dvs = paint;
        paint.setAntiAlias(true);
        dvs.setFilterBitmap(true);
    }

    public i(a aVar, String str) {
        super(aVar.uM());
        this.fBa.setStyle(Style.STROKE);
        this.fBa.setFlags(1);
        this.fBa.setAntiAlias(true);
        this.qFK = new Path();
        this.dvv = new Runnable() {
            public final void run() {
                i.this.invalidateSelf();
            }
        };
        this.lZs = aVar;
        this.tag = str;
        this.lZs.a(this);
    }

    public i(a aVar, String str, byte b) {
        super(aVar.uM());
        this.fBa.setStyle(Style.STROKE);
        this.fBa.setFlags(1);
        this.fBa.setAntiAlias(true);
        this.qFK = new Path();
        this.dvv = /* anonymous class already generated */;
        this.lkD = false;
        this.lZs = aVar;
        this.tag = str;
        this.lZs.a(this);
    }

    public final void Tw(String str) {
        if (str != null && str.length() > 0 && !str.equals(this.tag)) {
            this.tag = str;
            dvt.post(this.dvv);
        }
    }

    public final void kD(boolean z) {
        this.qFD = z;
    }

    public void draw(Canvas canvas) {
        Bitmap b;
        if (this.qFD) {
            b = this.lZs.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.qFG) {
            b = this.lZs.cK(this.tag);
        } else {
            b = this.lZs.cJ(this.tag);
        }
        if (b == null || b.isRecycled()) {
            b = this.lZs.uM();
            if (this.qFG) {
                this.qFH = true;
            } else {
                this.qFH = false;
            }
        } else {
            this.qFH = false;
        }
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.qFI > 1.0f || this.lkD) {
            int height = (b.getHeight() / 15) / 2;
            int width = (b.getWidth() / 15) / 2;
            rect = new Rect(width, height, b.getWidth() - width, b.getHeight() - height);
        }
        canvas.drawBitmap(b, rect, bounds, dvs);
    }

    public void jX(String str) {
        if (str != null && str.equals(this.tag)) {
            x.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
            dvt.post(this.dvv);
        }
    }

    public final void cdg() {
        this.qFG = true;
    }

    public final void cdh() {
        if (this.qFG) {
            this.qFG = false;
            if (this.qFH) {
                this.qFH = false;
                invalidateSelf();
            }
        }
    }

    public void onScrollStateChanged(boolean z) {
        if (z) {
            this.qFG = true;
        } else {
            cdh();
        }
    }
}
