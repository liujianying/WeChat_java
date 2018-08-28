package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.a.e;
import com.tencent.mm.bp.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private final Paint cN;
    private ag ioW;
    private boolean khD;
    private int[] khG;
    private float khH;
    private float khI;
    private boolean khJ;
    private int khL;
    private int khM;
    private long khN;
    private long khO;
    private long khP;
    private long khQ;
    private long khR;
    private long khS;
    private final Runnable khZ;
    private final Runnable kia;
    private final Runnable kid;
    private volatile long kiq;
    private int[] kir;
    private Bitmap kis;
    private boolean kit;
    private float mDensity;
    private int mHeight;
    private boolean mIsRunning;
    private int mWidth;
    private final Rect rD;

    static /* synthetic */ void a(f fVar, Runnable runnable, long j) {
        fVar.khS = SystemClock.uptimeMillis() + j;
        if (fVar.ioW != null) {
            fVar.ioW.postAtTime(runnable, fVar.khS);
        }
    }

    public f(String str) {
        this(e.e(str, 0, e.cm(str)));
    }

    public f(byte[] bArr) {
        this.mIsRunning = false;
        this.khD = false;
        this.khG = new int[4];
        this.kir = new int[4];
        this.khH = 1.0f;
        this.khI = 1.0f;
        this.rD = new Rect();
        this.cN = new Paint(6);
        this.khL = 0;
        this.khM = -1;
        this.khN = 0;
        this.khO = 0;
        this.khP = 0;
        this.khQ = 0;
        this.khS = 0;
        this.kit = false;
        this.ioW = new ag();
        this.khZ = new 1(this);
        this.kia = new 2(this);
        this.kid = new 3(this);
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        this.kiq = MMWXGFJNI.nativeInitWxAMDecoder();
        if (this.kiq == 0 || this.kiq == -901) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", Long.valueOf(this.kiq));
            if (this.kiq == -901) {
                h.mEJ.a(711, 5, 1, false);
            }
            h.mEJ.a(711, 4, 1, false);
            throw new MMGIFException(HardCoderJNI.SCENE_RECEIVE_MSG);
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.kiq, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                h.mEJ.a(711, 8, 1, false);
            } else {
                h.mEJ.a(711, 3, 1, false);
            }
            throw new MMGIFException(nativeDecodeBufferHeader);
        }
        nativeDecodeBufferHeader = MMWXGFJNI.nativeGetOption(this.kiq, bArr, bArr.length, this.khG);
        if (nativeDecodeBufferHeader != 0) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -903) {
                h.mEJ.a(711, 7, 1, false);
            } else {
                h.mEJ.a(711, 3, 1, false);
            }
            throw new MMGIFException(nativeDecodeBufferHeader);
        }
        this.khL = this.khG[0];
        this.mWidth = this.khG[1];
        this.mHeight = this.khG[2];
        if (this.mWidth == 0 || this.mHeight == 0) {
            nativeDecodeBufferHeader = a.ad(ad.getContext(), c.emoji_view_image_size);
            this.mHeight = nativeDecodeBufferHeader;
            this.mWidth = nativeDecodeBufferHeader;
        }
        this.kis = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
    }

    private float getEmojiDensityScale() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ad.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    public final int getIntrinsicWidth() {
        return (int) (((float) this.mWidth) * getEmojiDensityScale());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.mHeight) * getEmojiDensityScale());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.khJ = true;
    }

    public final void draw(Canvas canvas) {
        if (this.khJ) {
            this.rD.set(getBounds());
            this.khH = ((float) this.rD.width()) / ((float) this.mWidth);
            this.khI = ((float) this.rD.height()) / ((float) this.mHeight);
            this.khJ = false;
        }
        if (this.cN.getShader() == null) {
            if (this.khQ == 0) {
                this.khQ = System.currentTimeMillis();
            }
            canvas.scale(this.khH, this.khI);
            if (this.kis == null || this.kis.isRecycled() || this.khD) {
                x.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
            } else {
                canvas.drawBitmap(this.kis, 0.0f, 0.0f, null);
            }
            this.khR = System.currentTimeMillis() - this.khQ;
            com.tencent.mm.aj.a.c(this.kid, 0);
            return;
        }
        canvas.drawRect(this.rD, this.cN);
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

    public final void start() {
        this.mIsRunning = true;
        com.tencent.mm.aj.a.c(this.kia, 0);
    }

    public final void stop() {
        this.mIsRunning = false;
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", th, "", new Object[0]);
            super.finalize();
        }
    }

    public final void reset() {
        this.mIsRunning = true;
    }

    public final synchronized void recycle() {
        x.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", Long.valueOf(this.kiq));
        this.khD = true;
        this.mIsRunning = false;
        long j = this.kiq;
        this.kiq = 0;
        this.ioW.removeCallbacks(this.khZ);
        int nativeUninit = MMWXGFJNI.nativeUninit(j);
        if (nativeUninit == -906) {
            h.mEJ.a(401, 10, 1, false);
        }
        x.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", Integer.valueOf(nativeUninit), Long.valueOf(j), Boolean.valueOf(this.kit));
        if (!(j == 0 || nativeUninit != 0 || this.kis == null)) {
            this.kis.isRecycled();
        }
        this.kis = null;
    }
}
