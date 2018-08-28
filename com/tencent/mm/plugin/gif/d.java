package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private final Paint cN = new Paint(6);
    private ag ioW = new ag(Looper.getMainLooper());
    public int irJ = 0;
    private float khH = 1.0f;
    private float khI = 1.0f;
    private boolean khJ;
    private long khS = 0;
    private final Runnable khY = new 2(this);
    private final Runnable khZ = new 1(this);
    private volatile boolean kif = false;
    private int kig;
    private int kih;
    private int[] kii;
    private Bitmap kij = null;
    private boolean kik = false;
    public boolean kil = true;
    private String kim;
    public int kin = 0;
    private h kio;
    private Context mContext;
    private int mHeight;
    public boolean mIsPlaying = true;
    private Resources mResources;
    private int mWidth;
    private final Rect rD = new Rect();

    public d(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        this.mContext = context;
        this.mResources = this.mContext.getResources();
        this.kik = false;
        this.mIsPlaying = z;
        this.kil = z2;
        this.kim = str;
        this.kih = i;
        this.kii = iArr;
        if (z) {
            this.kij = rf(this.kii[0]);
        } else {
            this.kij = rf(EB(str));
        }
        this.mWidth = this.kij.getWidth();
        this.mHeight = this.kij.getHeight();
        if (this.kii.length == 3) {
            this.kig = 300;
        } else {
            this.kig = 100;
        }
        this.kin = 0;
    }

    public final void draw(Canvas canvas) {
        if (this.khJ) {
            this.rD.set(getBounds());
            this.khH = ((float) this.rD.width()) / ((float) this.mWidth);
            this.khI = ((float) this.rD.height()) / ((float) this.mHeight);
            this.khJ = false;
        }
        if (this.cN.getShader() == null) {
            canvas.scale(this.khH, this.khI);
            if (this.kik) {
                this.kij = rf(this.kih);
                if (this.kij != null && !this.kij.isRecycled()) {
                    canvas.drawBitmap(this.kij, 0.0f, 0.0f, this.cN);
                    return;
                }
                return;
            } else if (this.mIsPlaying) {
                this.kij = rf(this.kii[this.irJ]);
                if (!(this.kij == null || this.kij.isRecycled())) {
                    canvas.drawBitmap(this.kij, 0.0f, 0.0f, this.cN);
                }
                this.irJ++;
                if (this.kin < 3) {
                    if (this.irJ >= this.kii.length) {
                        this.irJ = 0;
                        if (this.kil) {
                            this.kin++;
                        } else {
                            this.kin = 0;
                        }
                    }
                    f(this.khZ, (long) this.kig);
                    return;
                }
                this.mIsPlaying = false;
                f(this.khZ, (long) this.kig);
                f(this.khY, 0);
                return;
            } else {
                this.kij = rf(EB(this.kim));
                if (this.kij != null && !this.kij.isRecycled()) {
                    canvas.drawBitmap(this.kij, 0.0f, 0.0f, this.cN);
                    return;
                }
                return;
            }
        }
        x.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.rD, this.cN);
    }

    private void f(Runnable runnable, long j) {
        this.khS = SystemClock.uptimeMillis() + j;
        if (this.ioW != null) {
            this.ioW.postDelayed(runnable, j);
        }
    }

    public final int getIntrinsicHeight() {
        return this.mHeight;
    }

    public final int getIntrinsicWidth() {
        return this.mWidth;
    }

    public final void setAlpha(int i) {
        this.cN.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -2;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.khJ = true;
    }

    public final void start() {
        this.kif = true;
        this.ioW.post(this.khZ);
    }

    public final void stop() {
        this.kif = false;
    }

    public final boolean isRunning() {
        return this.kif;
    }

    private Bitmap rf(int i) {
        return BitmapFactory.decodeResource(this.mResources, i);
    }

    private int EB(String str) {
        return this.mResources.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
    }

    protected final void finalize() {
        this.kio = null;
        super.finalize();
    }

    public final void recycle() {
    }

    public final void reset() {
    }
}
