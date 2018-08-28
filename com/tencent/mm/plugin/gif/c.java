package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.bp.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class c extends a {
    private final Paint cN;
    private int dYK;
    private ag ioW;
    boolean khD;
    private volatile long khE;
    private AssetFileDescriptor khF;
    private final int[] khG;
    private float khH;
    private float khI;
    private boolean khJ;
    private int[] khK;
    private int khL;
    private int khM;
    private long khN;
    private long khO;
    private long khP;
    private long khQ;
    private long khR;
    private long khS;
    private int khT;
    private boolean khU;
    int khV;
    private int khW;
    h khX;
    private final Runnable khY;
    final Runnable khZ;
    private final Runnable kia;
    private final Runnable kib;
    private final Runnable kic;
    private final Runnable kid;
    private float mDensity;
    boolean mIsRunning;
    private final Rect rD;

    /* renamed from: f */
    final void a(Runnable runnable, long j) {
        this.khS = SystemClock.uptimeMillis() + j;
        if (this.ioW != null) {
            this.ioW.postAtTime(runnable, this.khS);
        }
    }

    public c(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
    }

    public c(String str) {
        int i = 0;
        this.mIsRunning = true;
        this.khD = false;
        this.khF = null;
        this.khG = new int[6];
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
        this.khU = false;
        this.khV = 0;
        this.khW = 0;
        this.ioW = new ag();
        this.khY = new Runnable() {
            public final void run() {
            }
        };
        this.khZ = new 2(this);
        this.kia = new Runnable() {
            public final void run() {
                MMGIFJNI.restoreRemainder(c.this.khE);
                c.this.a(c.this.khZ, c.this.khP);
            }
        };
        this.kib = new 4(this);
        this.kic = new 5(this);
        this.kid = new Runnable() {
            public final void run() {
                if (c.this.khD) {
                    x.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (c.this.khM + 1 > c.this.khL - 1) {
                    c.this.khM = -1;
                }
                c.this.khM = c.this.khM + 1;
                if (MMGIFJNI.drawFramePixels(c.this.khE, c.this.khK, c.this.khG)) {
                    c.this.khW = c.this.khW + 1;
                }
                c.this.khN = System.currentTimeMillis() - currentTimeMillis;
                if (c.this.khO != 0) {
                    c.this.khP = (c.this.khO - c.this.khN) - c.this.khR;
                    if (c.this.khP < 0) {
                        x.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[]{Long.valueOf(c.this.khN), Long.valueOf(c.this.khR), Long.valueOf(c.this.khP), Long.valueOf(c.this.khO), Integer.valueOf(c.this.khG[5])});
                        h.mEJ.a(401, 0, 1, false);
                        h.mEJ.a(401, 1, Math.abs(c.this.khP), false);
                        if (c.this.khP < -100) {
                            boolean z = HardCoderJNI.hcGifEnable || HardCoderJNI.hcGifFrameEnable;
                            HardCoderJNI.stopPerformace(z, c.this.dYK);
                            c.this.dYK = HardCoderJNI.startPerformance(HardCoderJNI.hcGifFrameEnable, HardCoderJNI.hcGifFrameDelay, HardCoderJNI.hcGifFrameCPU, HardCoderJNI.hcGifFrameIO, HardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, HardCoderJNI.hcGifFrameTimeout, 602, HardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                c.this.a(c.this.khZ, c.this.khP > 0 ? c.this.khP : 0);
                if (c.this.khG[2] == 1) {
                    c.this.khO = 5000;
                } else {
                    c.this.khO = (long) c.this.khG[4];
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("file path is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.dYK = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.khE = MMGIFJNI.openByFilePath(str, this.khG);
        init();
    }

    private c(AssetFileDescriptor assetFileDescriptor) {
        int i = 0;
        this.mIsRunning = true;
        this.khD = false;
        this.khF = null;
        this.khG = new int[6];
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
        this.khU = false;
        this.khV = 0;
        this.khW = 0;
        this.ioW = new ag();
        this.khY = /* anonymous class already generated */;
        this.khZ = new 2(this);
        this.kia = /* anonymous class already generated */;
        this.kib = new 4(this);
        this.kic = new 5(this);
        this.kid = /* anonymous class already generated */;
        if (assetFileDescriptor == null) {
            throw new NullPointerException("assert file Descriptor is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.dYK = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.khF = assetFileDescriptor;
        this.khE = MMGIFJNI.openByFileDescroptor(this.khF.getFileDescriptor(), assetFileDescriptor.getStartOffset(), this.khG);
        init();
    }

    public c(InputStream inputStream) {
        int i = 0;
        this.mIsRunning = true;
        this.khD = false;
        this.khF = null;
        this.khG = new int[6];
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
        this.khU = false;
        this.khV = 0;
        this.khW = 0;
        this.ioW = new ag();
        this.khY = /* anonymous class already generated */;
        this.khZ = new 2(this);
        this.kia = /* anonymous class already generated */;
        this.kib = new 4(this);
        this.kic = new 5(this);
        this.kid = /* anonymous class already generated */;
        if (inputStream == null) {
            throw new NullPointerException("input stream is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.dYK = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.khE = MMGIFJNI.openByInputStrem(inputStream, this.khG);
        init();
    }

    public c(byte[] bArr) {
        int i = 0;
        this.mIsRunning = true;
        this.khD = false;
        this.khF = null;
        this.khG = new int[6];
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
        this.khU = false;
        this.khV = 0;
        this.khW = 0;
        this.ioW = new ag();
        this.khY = /* anonymous class already generated */;
        this.khZ = new 2(this);
        this.kia = /* anonymous class already generated */;
        this.kib = new 4(this);
        this.kic = new 5(this);
        this.kid = /* anonymous class already generated */;
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.dYK = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.khE = MMGIFJNI.openByByteArray(bArr, this.khG);
        init();
    }

    private void init() {
        x.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[]{Long.valueOf(this.khE)});
        this.khL = this.khG[2];
        this.khT = a.ad(ad.getContext(), com.tencent.mm.plugin.n.a.c.emoji_view_image_size);
        if (this.khG[0] > 1024 || this.khG[1] > 1024) {
            x.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[]{Integer.valueOf(this.khG[0]), Integer.valueOf(this.khG[1])});
            this.khK = new int[(this.khT * this.khT)];
            this.khU = true;
            h.mEJ.a(401, 2, 1, false);
            return;
        }
        this.khK = new int[(this.khG[0] * this.khG[1])];
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
        return (int) (((float) this.khG[0]) * getEmojiDensityScale());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.khG[1]) * getEmojiDensityScale());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.khJ = true;
    }

    public final void draw(Canvas canvas) {
        if (this.khJ) {
            this.rD.set(getBounds());
            this.khH = ((float) this.rD.width()) / ((float) this.khG[0]);
            this.khI = ((float) this.rD.height()) / ((float) this.khG[1]);
            this.khJ = false;
        }
        if (this.cN.getShader() == null) {
            if (this.khQ == 0) {
                this.khQ = System.currentTimeMillis();
            }
            canvas.scale(this.khH, this.khI);
            int[] iArr = this.khK;
            if (iArr == null) {
                x.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.khG[0] * this.khG[1]) {
                canvas.drawBitmap(iArr, 0, this.khG[0], 0.0f, 0.0f, this.khG[0], this.khG[1], true, this.cN);
            } else {
                canvas.drawRGB(230, 230, 230);
                x.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(this.khG[0]), Integer.valueOf(this.khG[1])});
            }
            this.khR = System.currentTimeMillis() - this.khQ;
            if (this.khU || this.khG[2] <= 0) {
                x.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[]{Integer.valueOf(this.khG[2]), Integer.valueOf(this.khG[4]), Boolean.valueOf(this.khU)});
                return;
            }
            if (this.khG[4] < 0) {
                x.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
            }
            if (this.khV == 0 || this.khW <= this.khV - 1) {
                com.tencent.mm.aj.a.c(this.kid, 0);
                return;
            } else {
                a(this.khY, 0);
                return;
            }
        }
        x.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.rD, this.cN);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        this.cN.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void start() {
        this.mIsRunning = true;
        com.tencent.mm.aj.a.c(this.kia, 0);
    }

    public final void stop() {
        boolean z = true;
        x.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.mIsRunning = false;
        if (this.dYK != 0) {
            x.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformace startPerformance:%x ", new Object[]{Integer.valueOf(this.dYK)});
            if (!(HardCoderJNI.hcGifEnable || HardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            HardCoderJNI.stopPerformace(z, this.dYK);
            this.dYK = 0;
        }
        com.tencent.mm.aj.a.c(this.kic, 300);
    }

    public final void reset() {
        this.khD = false;
        this.mIsRunning = true;
        com.tencent.mm.aj.a.c(this.kib, 300);
    }

    public final void recycle() {
        x.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.khD = true;
        this.mIsRunning = false;
        long j = this.khE;
        this.khE = 0;
        MMGIFJNI.recycle(j);
        this.khK = null;
        if (this.khF != null) {
            try {
                this.khF.close();
            } catch (Exception e) {
            }
        }
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
