package com.tencent.mm.memory.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class a extends Drawable implements i {
    public static final Paint dvs;
    private static final ag dvt = new ag(Looper.getMainLooper());
    boolean DEBUG = false;
    public n dvu;
    private Runnable dvv = new Runnable() {
        public final void run() {
            x.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", new Object[]{a.this.tag});
            a.this.invalidateSelf();
        }
    };
    protected String tag;

    static {
        Paint paint = new Paint();
        dvs = paint;
        paint.setAntiAlias(true);
        dvs.setFilterBitmap(false);
        dvs.setColor(-1118482);
    }

    public a(String str, n nVar) {
        this.tag = str;
        this.dvu = nVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        n nVar = this.dvu;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, null, bounds, dvs);
    }

    public final void Fs() {
        if (this.dvu != null) {
            this.dvu.Fs();
        }
    }

    public final void Ft() {
        if (this.dvu != null) {
            this.dvu.Ft();
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        if (this.dvu == null) {
            return 0;
        }
        n nVar = this.dvu;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        if (this.dvu == null) {
            return 0;
        }
        n nVar = this.dvu;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getHeight();
    }

    public final n FB() {
        if (this.dvu != null) {
            return this.dvu;
        }
        return null;
    }

    public String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode();
        if (this.dvu != null) {
            return str + this.dvu;
        }
        return str;
    }
}
