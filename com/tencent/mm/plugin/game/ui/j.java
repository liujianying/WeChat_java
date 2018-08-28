package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends BitmapDrawable implements a {
    private static Bitmap byb;
    private static ag dvt = new ag(Looper.getMainLooper());
    private Runnable dvv;
    private Bitmap hqe;
    private String mUrl;

    private j(String str) {
        Bitmap createBitmap;
        if (byb == null || byb.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            byb = createBitmap;
        } else {
            createBitmap = byb;
        }
        this(str, createBitmap);
    }

    private j(String str, Bitmap bitmap) {
        super(bitmap);
        this.dvv = new 1(this);
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        y.a((a) this);
        setUrl(str);
    }

    public final void m(String str, Bitmap bitmap) {
        if (this.mUrl != null && (this.mUrl.hashCode()).equals(str) && bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.hqe = bitmap;
            dvt.post(this.dvv);
        }
    }

    public final void draw(Canvas canvas) {
        if (this.hqe == null || this.hqe.isRecycled()) {
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.hqe, new Rect(0, 0, this.hqe.getWidth(), this.hqe.getHeight()), bounds, getPaint());
    }

    public final void setUrl(String str) {
        if (str != null && !str.equals(this.mUrl)) {
            x.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[]{str});
            this.mUrl = str;
            Bitmap a = y.a(new ap(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.hqe = a;
            }
            dvt.post(this.dvv);
        }
    }
}
