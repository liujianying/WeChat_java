package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.ac.m$a.a;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends BitmapDrawable implements a {
    private static Bitmap byb;
    private static ag dvt = new ag(Looper.getMainLooper());
    private static int hqf = m.CTRL_INDEX;
    private Runnable dvv;
    private String gtX;
    private Bitmap hqe;
    private Runnable hqg;
    private String mUrl;

    /* synthetic */ b(String str, String str2, Bitmap bitmap, byte b) {
        this(str, str2, bitmap);
    }

    private b(String str, String str2) {
        if (byb == null || byb.isRecycled()) {
            byb = Bitmap.createBitmap(m.CTRL_INDEX, m.CTRL_INDEX, Config.ARGB_8888);
        }
        this(str, str2, byb);
    }

    private b(String str, String str2, Bitmap bitmap) {
        super(bitmap);
        this.dvv = new 1(this);
        this.hqg = new Runnable() {
            public final void run() {
                Bitmap d = com.tencent.mm.ac.m.d(b.this.gtX, b.this.mUrl, 0);
                if (d != null && !d.isRecycled()) {
                    b.dvt.post(b.this.dvv);
                }
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        z.Ni().a(this);
        bX(str, str2);
    }

    public final void kX(String str) {
        if (this.gtX != null && this.gtX.equals(str)) {
            dvt.postDelayed(this.dvv, (long) hqf);
        }
    }

    public final void draw(Canvas canvas) {
        this.hqe = com.tencent.mm.ac.m.kV(this.gtX);
        if (this.hqe == null || this.hqe.isRecycled()) {
            g.Em().h(this.hqg, (long) hqf);
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.hqe, new Rect(0, 0, this.hqe.getWidth(), this.hqe.getHeight()), bounds, getPaint());
    }

    public final void bX(String str, String str2) {
        if (bi.oW(str)) {
            x.w("MicroMsg.BrandAvatarDrawable", "The username is null or nil.");
        }
        this.gtX = str;
        if (str2 == this.mUrl) {
            return;
        }
        if (str2 == null || !(str2 == null || str2.equals(this.mUrl))) {
            x.i("MicroMsg.BrandAvatarDrawable", "set a new url for the drawable, url:[%s]", new Object[]{str2});
            this.mUrl = str2;
            dvt.post(this.dvv);
        }
    }
}
