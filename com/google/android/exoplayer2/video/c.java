package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.video.e.a;
import com.google.android.exoplayer2.video.e.a.1;
import com.google.android.exoplayer2.video.e.a.2;
import com.google.android.exoplayer2.video.e.a.3;
import com.google.android.exoplayer2.video.e.a.4;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c extends b {
    private static final int[] aDd = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int aDA;
    private int aDB;
    private int aDC;
    private float aDD;
    b aDE;
    private long aDF;
    private int aDG;
    private final d aDe;
    private final a aDf;
    private final long aDg;
    private final int aDh = 50;
    private final boolean aDi;
    private final long[] aDj;
    private Format[] aDk;
    private a aDl;
    private boolean aDm;
    private Surface aDn;
    private int aDo;
    private boolean aDp;
    private long aDq;
    private long aDr;
    private int aDs;
    private int aDt;
    private int aDu;
    private float aDv;
    private int aDw;
    private int aDx;
    private int aDy;
    private float aDz;
    private int aeA;
    private Surface aeJ;
    private boolean agM;
    private final Context context;

    public c(Context context, com.google.android.exoplayer2.e.c cVar, long j, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar) {
        boolean z = false;
        super(2, cVar, bVar, false);
        this.aDg = j;
        this.context = context.getApplicationContext();
        this.aDe = new d(context);
        this.aDf = new a(handler, eVar);
        if (t.SDK_INT <= 22 && "foster".equals(t.DEVICE) && "NVIDIA".equals(t.MANUFACTURER)) {
            z = true;
        }
        this.aDi = z;
        this.aDj = new long[10];
        this.aDF = -9223372036854775807L;
        this.aDq = -9223372036854775807L;
        this.aDw = -1;
        this.aDx = -1;
        this.aDz = -1.0f;
        this.aDv = -1.0f;
        this.aDo = 1;
        mu();
    }

    protected final int a(com.google.android.exoplayer2.e.c cVar, Format format) {
        int i = 0;
        String str = format.adW;
        if (!g.au(str)) {
            return 0;
        }
        boolean z;
        DrmInitData drmInitData = format.adZ;
        if (drmInitData != null) {
            z = false;
            for (int i2 = 0; i2 < drmInitData.aiu; i2++) {
                z |= drmInitData.ait[i2].aiv;
            }
        } else {
            z = false;
        }
        com.google.android.exoplayer2.e.a d = cVar.d(str, z);
        if (d == null) {
            return 1;
        }
        boolean z2;
        String str2 = format.adT;
        if (str2 == null || d.mimeType == null) {
            z2 = true;
        } else {
            String aw = g.aw(str2);
            if (aw == null) {
                z2 = true;
            } else if (d.mimeType.equals(aw)) {
                Pair ak = com.google.android.exoplayer2.e.d.ak(str2);
                if (ak == null) {
                    z2 = true;
                } else {
                    for (CodecProfileLevel codecProfileLevel : d.kj()) {
                        if (codecProfileLevel.profile == ((Integer) ak.first).intValue() && codecProfileLevel.level >= ((Integer) ak.second).intValue()) {
                            z2 = true;
                            break;
                        }
                    }
                    d.aj("codec.profileLevel, " + str2 + ", " + aw);
                    z2 = false;
                }
            } else {
                d.aj("codec.mime " + str2 + ", " + aw);
                z2 = false;
            }
        }
        if (z2 && format.width > 0 && format.height > 0) {
            if (t.SDK_INT >= 21) {
                z2 = d.a(format.width, format.height, (double) format.aea);
            } else {
                if (format.width * format.height <= com.google.android.exoplayer2.e.d.kq()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    new StringBuilder("FalseCheck [legacyFrameSize, ").append(format.width).append("x").append(format.height).append("] [").append(t.aCH).append("]");
                }
            }
        }
        int i3 = d.apq ? 16 : 8;
        if (d.agM) {
            i = 32;
        }
        return (i | i3) | (z2 ? 4 : 3);
    }

    protected final void ae(boolean z) {
        boolean z2;
        super.ae(z);
        this.aeA = this.acj.aeA;
        if (this.aeA != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.agM = z2;
        a aVar = this.aDf;
        com.google.android.exoplayer2.b.d dVar = this.aqc;
        if (aVar.aDZ != null) {
            aVar.handler.post(new 1(aVar, dVar));
        }
        d dVar2 = this.aDe;
        dVar2.aDQ = false;
        if (dVar2.aDK) {
            dVar2.aDJ.handler.sendEmptyMessage(1);
        }
    }

    protected final void a(Format[] formatArr, long j) {
        this.aDk = formatArr;
        if (this.aDF == -9223372036854775807L) {
            this.aDF = j;
        } else {
            if (this.aDG == this.aDj.length) {
                new StringBuilder("Too many stream changes, so dropping offset: ").append(this.aDj[this.aDG - 1]);
            } else {
                this.aDG++;
            }
            this.aDj[this.aDG - 1] = j;
        }
        super.a(formatArr, j);
    }

    protected final void b(long j, boolean z) {
        super.b(j, z);
        ms();
        this.aDt = 0;
        if (this.aDG != 0) {
            this.aDF = this.aDj[this.aDG - 1];
            this.aDG = 0;
        }
        if (z) {
            mr();
        } else {
            this.aDq = -9223372036854775807L;
        }
    }

    public final boolean hv() {
        if (super.hv() && (this.aDp || ((this.aDn != null && this.aeJ == this.aDn) || this.apD == null || this.agM))) {
            this.aDq = -9223372036854775807L;
            return true;
        } else if (this.aDq == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.aDq) {
                return true;
            }
            this.aDq = -9223372036854775807L;
            return false;
        }
    }

    protected final void onStarted() {
        super.onStarted();
        this.aDs = 0;
        this.aDr = SystemClock.elapsedRealtime();
    }

    protected final void onStopped() {
        this.aDq = -9223372036854775807L;
        mx();
        super.onStopped();
    }

    protected final void ix() {
        this.aDw = -1;
        this.aDx = -1;
        this.aDz = -1.0f;
        this.aDv = -1.0f;
        this.aDF = -9223372036854775807L;
        this.aDG = 0;
        mu();
        ms();
        d dVar = this.aDe;
        if (dVar.aDK) {
            dVar.aDJ.handler.sendEmptyMessage(2);
        }
        this.aDE = null;
        this.agM = false;
        try {
            super.ix();
        } finally {
            this.aqc.jC();
            this.aDf.e(this.aqc);
        }
    }

    public final void d(int i, Object obj) {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                if (this.aDn != null) {
                    surface = this.aDn;
                } else {
                    com.google.android.exoplayer2.e.a aVar = this.apE;
                    if (aVar != null && ar(aVar.apr)) {
                        this.aDn = DummySurface.g(this.context, aVar.apr);
                        surface = this.aDn;
                    }
                }
            }
            if (this.aeJ != surface) {
                this.aeJ = surface;
                int i2 = this.state;
                if (i2 == 1 || i2 == 2) {
                    MediaCodec mediaCodec = this.apD;
                    if (t.SDK_INT < 23 || mediaCodec == null || surface == null || this.aDm) {
                        kl();
                        kk();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.aDn) {
                    mu();
                    ms();
                    return;
                }
                mw();
                ms();
                if (i2 == 2) {
                    mr();
                }
            } else if (surface != null && surface != this.aDn) {
                mw();
                if (this.aDp) {
                    this.aDf.c(this.aeJ);
                }
            }
        } else if (i == 4) {
            this.aDo = ((Integer) obj).intValue();
            MediaCodec mediaCodec2 = this.apD;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(this.aDo);
            }
        } else {
            super.d(i, obj);
        }
    }

    protected final boolean a(com.google.android.exoplayer2.e.a aVar) {
        return this.aeJ != null || ar(aVar.apr);
    }

    protected final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a aVar2;
        Format[] formatArr = this.aDk;
        int i = format.width;
        int i2 = format.height;
        int l = l(format);
        if (formatArr.length == 1) {
            aVar2 = new a(i, i2, l);
        } else {
            int i3 = 0;
            int length = formatArr.length;
            int i4 = 0;
            while (i4 < length) {
                Format format2 = formatArr[i4];
                int b = b(aVar.apq, format, format2);
                if (b != 0) {
                    b = (format2.width == -1 || format2.height == -1) ? 1 : 0;
                    b |= i3;
                    i = Math.max(i, format2.width);
                    i2 = Math.max(i2, format2.height);
                    i3 = Math.max(l, l(format2));
                }
                l = i3;
                i4++;
                i3 = b;
            }
            if (i3 != 0) {
                new StringBuilder("Resolutions unknown. Codec max resolution: ").append(i).append("x").append(i2);
                Point a = a(aVar, format);
                if (a != null) {
                    i = Math.max(i, a.x);
                    i2 = Math.max(i2, a.y);
                    l = Math.max(l, b(format.adW, i, i2));
                    new StringBuilder("Codec max resolution adjusted to: ").append(i).append("x").append(i2);
                }
            }
            aVar2 = new a(i, i2, l);
        }
        this.aDl = aVar2;
        aVar2 = this.aDl;
        boolean z = this.aDi;
        l = this.aeA;
        MediaFormat iQ = format.iQ();
        iQ.setInteger("max-width", aVar2.width);
        iQ.setInteger("max-height", aVar2.height);
        if (aVar2.aDH != -1) {
            iQ.setInteger("max-input-size", aVar2.aDH);
        }
        if (z) {
            iQ.setInteger("auto-frc", 0);
        }
        if (l != 0) {
            iQ.setFeatureEnabled("tunneled-playback", true);
            iQ.setInteger("audio-session-id", l);
        }
        if (this.aeJ == null) {
            com.google.android.exoplayer2.i.a.ap(ar(aVar.apr));
            if (this.aDn == null) {
                this.aDn = DummySurface.g(this.context, aVar.apr);
            }
            this.aeJ = this.aDn;
        }
        mediaCodec.configure(iQ, this.aeJ, mediaCrypto, 0);
        if (t.SDK_INT >= 23 && this.agM) {
            this.aDE = new b(this, mediaCodec, (byte) 0);
        }
    }

    protected final void kl() {
        try {
            super.kl();
        } finally {
            if (this.aDn != null) {
                if (this.aeJ == this.aDn) {
                    this.aeJ = null;
                }
                this.aDn.release();
                this.aDn = null;
            }
        }
    }

    protected final void c(String str, long j, long j2) {
        a aVar = this.aDf;
        if (aVar.aDZ != null) {
            aVar.handler.post(new 2(aVar, str, j, j2));
        }
        boolean z = (("deb".equals(t.DEVICE) || "flo".equals(t.DEVICE)) && "OMX.qcom.video.decoder.avc".equals(str)) || ("tcl_eu".equals(t.DEVICE) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
        this.aDm = z;
    }

    protected final void e(Format format) {
        super.e(format);
        a aVar = this.aDf;
        if (aVar.aDZ != null) {
            aVar.handler.post(new 3(aVar, format));
        }
        this.aDv = format.aec == -1.0f ? 1.0f : format.aec;
        this.aDu = m(format);
    }

    protected final void kn() {
        if (t.SDK_INT < 23 && this.agM) {
            mt();
        }
    }

    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.aDw = integer;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer = mediaFormat.getInteger("height");
        }
        this.aDx = integer;
        this.aDz = this.aDv;
        if (t.SDK_INT < 21) {
            this.aDy = this.aDu;
        } else if (this.aDu == 90 || this.aDu == 270) {
            integer = this.aDw;
            this.aDw = this.aDx;
            this.aDx = integer;
            this.aDz = 1.0f / this.aDz;
        }
        mediaCodec.setVideoScalingMode(this.aDo);
    }

    protected final boolean a(boolean z, Format format, Format format2) {
        return b(z, format, format2) && format2.width <= this.aDl.width && format2.height <= this.aDl.height && l(format2) <= this.aDl.aDH;
    }

    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (this.aDG != 0 && j3 >= this.aDj[0]) {
            this.aDF = this.aDj[0];
            this.aDG--;
            System.arraycopy(this.aDj, 1, this.aDj, 0, this.aDG);
        }
        if (z) {
            a(mediaCodec, i);
            return true;
        }
        long j4 = j3 - j;
        if (this.aeJ == this.aDn) {
            if (!X(j4)) {
                return false;
            }
            a(mediaCodec, i);
            return true;
        } else if (!this.aDp) {
            if (t.SDK_INT >= 21) {
                a(mediaCodec, i, System.nanoTime());
            } else {
                b(mediaCodec, i);
            }
            return true;
        } else if (this.state != 2) {
            return false;
        } else {
            long j5;
            j4 -= (SystemClock.elapsedRealtime() * 1000) - j2;
            long nanoTime = System.nanoTime();
            long j6 = nanoTime + (j4 * 1000);
            d dVar = this.aDe;
            long j7 = j3 * 1000;
            if (dVar.aDQ) {
                if (j3 != dVar.aDN) {
                    dVar.aDT++;
                    dVar.aDO = dVar.aDP;
                }
                if (dVar.aDT >= 6) {
                    j5 = dVar.aDO + ((j7 - dVar.aDS) / dVar.aDT);
                    if (dVar.e(j5, j6)) {
                        dVar.aDQ = false;
                        j4 = j6;
                        j5 = j7;
                    } else {
                        j4 = (dVar.aDR + j5) - dVar.aDS;
                    }
                    if (!dVar.aDQ) {
                        dVar.aDS = j7;
                        dVar.aDR = j6;
                        dVar.aDT = 0;
                        dVar.aDQ = true;
                    }
                    dVar.aDN = j3;
                    dVar.aDP = j5;
                    if (!(dVar.aDJ == null || dVar.aDJ.aDU == 0)) {
                        j6 = dVar.aDJ.aDU;
                        j5 = dVar.aDL;
                        j7 = (((j4 - j6) / j5) * j5) + j6;
                        if (j4 > j7) {
                            j5 = j7 - j5;
                            j6 = j7;
                        } else {
                            j6 = j7 + j5;
                            j5 = j7;
                        }
                        j4 = (j6 - j4 >= j4 - j5 ? j6 : j5) - dVar.aDM;
                    }
                    j6 = (j4 - nanoTime) / 1000;
                    if (X(j6)) {
                        if (t.SDK_INT >= 21) {
                            if (j6 < 50000) {
                                a(mediaCodec, i, j4);
                                return true;
                            }
                        } else if (j6 < 30000) {
                            if (j6 > 11000) {
                                try {
                                    Thread.sleep((j6 - 10000) / 1000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            b(mediaCodec, i);
                            return true;
                        }
                        return false;
                    }
                    r.beginSection("dropVideoBuffer");
                    mediaCodec.releaseOutputBuffer(i, false);
                    r.endSection();
                    com.google.android.exoplayer2.b.d dVar2 = this.aqc;
                    dVar2.aid++;
                    this.aDs++;
                    this.aDt++;
                    this.aqc.aie = Math.max(this.aDt, this.aqc.aie);
                    if (this.aDs == this.aDh) {
                        mx();
                    }
                    return true;
                } else if (dVar.e(j7, j6)) {
                    dVar.aDQ = false;
                }
            }
            j4 = j6;
            j5 = j7;
            if (dVar.aDQ) {
                dVar.aDS = j7;
                dVar.aDR = j6;
                dVar.aDT = 0;
                dVar.aDQ = true;
            }
            dVar.aDN = j3;
            dVar.aDP = j5;
            j6 = dVar.aDJ.aDU;
            j5 = dVar.aDL;
            j7 = (((j4 - j6) / j5) * j5) + j6;
            if (j4 > j7) {
                j6 = j7 + j5;
                j5 = j7;
            } else {
                j5 = j7 - j5;
                j6 = j7;
            }
            if (j6 - j4 >= j4 - j5) {
            }
            j4 = (j6 - j4 >= j4 - j5 ? j6 : j5) - dVar.aDM;
            j6 = (j4 - nanoTime) / 1000;
            if (X(j6)) {
                if (t.SDK_INT >= 21) {
                    if (j6 < 50000) {
                        a(mediaCodec, i, j4);
                        return true;
                    }
                } else if (j6 < 30000) {
                    if (j6 > 11000) {
                        try {
                            Thread.sleep((j6 - 10000) / 1000);
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    b(mediaCodec, i);
                    return true;
                }
                return false;
            }
            r.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            r.endSection();
            com.google.android.exoplayer2.b.d dVar22 = this.aqc;
            dVar22.aid++;
            this.aDs++;
            this.aDt++;
            this.aqc.aie = Math.max(this.aDt, this.aqc.aie);
            if (this.aDs == this.aDh) {
                mx();
            }
            return true;
        }
    }

    private void a(MediaCodec mediaCodec, int i) {
        r.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        r.endSection();
        com.google.android.exoplayer2.b.d dVar = this.aqc;
        dVar.aic++;
    }

    private void b(MediaCodec mediaCodec, int i) {
        mv();
        r.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        r.endSection();
        com.google.android.exoplayer2.b.d dVar = this.aqc;
        dVar.aib++;
        this.aDt = 0;
        mt();
    }

    @TargetApi(21)
    private void a(MediaCodec mediaCodec, int i, long j) {
        mv();
        r.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        r.endSection();
        com.google.android.exoplayer2.b.d dVar = this.aqc;
        dVar.aib++;
        this.aDt = 0;
        mt();
    }

    private boolean ar(boolean z) {
        return t.SDK_INT >= 23 && !this.agM && (!z || DummySurface.X(this.context));
    }

    private void mr() {
        this.aDq = this.aDg > 0 ? SystemClock.elapsedRealtime() + this.aDg : -9223372036854775807L;
    }

    private void ms() {
        this.aDp = false;
        if (t.SDK_INT >= 23 && this.agM) {
            MediaCodec mediaCodec = this.apD;
            if (mediaCodec != null) {
                this.aDE = new b(this, mediaCodec, (byte) 0);
            }
        }
    }

    final void mt() {
        if (!this.aDp) {
            this.aDp = true;
            this.aDf.c(this.aeJ);
        }
    }

    private void mu() {
        this.aDA = -1;
        this.aDB = -1;
        this.aDD = -1.0f;
        this.aDC = -1;
    }

    private void mv() {
        if (this.aDw != -1 || this.aDx != -1) {
            if (this.aDA != this.aDw || this.aDB != this.aDx || this.aDC != this.aDy || this.aDD != this.aDz) {
                this.aDf.c(this.aDw, this.aDx, this.aDy, this.aDz);
                this.aDA = this.aDw;
                this.aDB = this.aDx;
                this.aDC = this.aDy;
                this.aDD = this.aDz;
            }
        }
    }

    private void mw() {
        if (this.aDA != -1 || this.aDB != -1) {
            this.aDf.c(this.aDA, this.aDB, this.aDC, this.aDD);
        }
    }

    private void mx() {
        if (this.aDs > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.aDr;
            a aVar = this.aDf;
            int i = this.aDs;
            if (aVar.aDZ != null) {
                aVar.handler.post(new 4(aVar, i, j));
            }
            this.aDs = 0;
            this.aDr = elapsedRealtime;
        }
    }

    private static boolean X(long j) {
        return j < -30000;
    }

    private static Point a(com.google.android.exoplayer2.e.a aVar, Format format) {
        Object obj = format.height > format.width ? 1 : null;
        int i = obj != null ? format.height : format.width;
        int i2 = obj != null ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : aDd) {
            int i32;
            int i4 = (int) (((float) i32) * f);
            if (i32 <= i || i4 <= i2) {
                return null;
            }
            if (t.SDK_INT >= 21) {
                int i5;
                Point point;
                if (obj != null) {
                    i5 = i4;
                } else {
                    i5 = i32;
                }
                if (obj == null) {
                    i32 = i4;
                }
                if (aVar.aps == null) {
                    aVar.aj("align.caps");
                    point = null;
                } else {
                    VideoCapabilities videoCapabilities = aVar.aps.getVideoCapabilities();
                    if (videoCapabilities == null) {
                        aVar.aj("align.vCaps");
                        point = null;
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(t.aw(i5, widthAlignment) * widthAlignment, t.aw(i32, heightAlignment) * heightAlignment);
                    }
                }
                if (aVar.a(point.x, point.y, (double) format.aea)) {
                    return point;
                }
            } else {
                i32 = t.aw(i32, 16) * 16;
                i4 = t.aw(i4, 16) * 16;
                if (i32 * i4 <= com.google.android.exoplayer2.e.d.kq()) {
                    return new Point(obj != null ? i4 : i32, obj != null ? i32 : i4);
                }
            }
        }
        return null;
    }

    private static int l(Format format) {
        if (format.adX == -1) {
            return b(format.adW, format.width, format.height);
        }
        int i = 0;
        for (int i2 = 0; i2 < format.adY.size(); i2++) {
            i += ((byte[]) format.adY.get(i2)).length;
        }
        return format.adX + i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(java.lang.String r5, int r6, int r7) {
        /*
        r4 = 16;
        r1 = 4;
        r0 = 2;
        r2 = -1;
        if (r6 == r2) goto L_0x0009;
    L_0x0007:
        if (r7 != r2) goto L_0x000b;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
    L_0x000b:
        r3 = r5.hashCode();
        switch(r3) {
            case -1664118616: goto L_0x0018;
            case -1662541442: goto L_0x0044;
            case 1187890754: goto L_0x0023;
            case 1331836730: goto L_0x002e;
            case 1599127256: goto L_0x0039;
            case 1599127257: goto L_0x004f;
            default: goto L_0x0012;
        };
    L_0x0012:
        r3 = r2;
    L_0x0013:
        switch(r3) {
            case 0: goto L_0x005a;
            case 1: goto L_0x005a;
            case 2: goto L_0x0064;
            case 3: goto L_0x0080;
            case 4: goto L_0x0084;
            case 5: goto L_0x0084;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
        goto L_0x000a;
    L_0x0018:
        r3 = "video/3gpp";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0021:
        r3 = 0;
        goto L_0x0013;
    L_0x0023:
        r3 = "video/mp4v-es";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x002c:
        r3 = 1;
        goto L_0x0013;
    L_0x002e:
        r3 = "video/avc";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0037:
        r3 = r0;
        goto L_0x0013;
    L_0x0039:
        r3 = "video/x-vnd.on2.vp8";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0042:
        r3 = 3;
        goto L_0x0013;
    L_0x0044:
        r3 = "video/hevc";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x004d:
        r3 = r1;
        goto L_0x0013;
    L_0x004f:
        r3 = "video/x-vnd.on2.vp9";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0058:
        r3 = 5;
        goto L_0x0013;
    L_0x005a:
        r1 = r6 * r7;
        r2 = r1;
    L_0x005d:
        r1 = r2 * 3;
        r0 = r0 * 2;
        r0 = r1 / r0;
        goto L_0x000a;
    L_0x0064:
        r1 = "BRAVIA 4K 2015";
        r3 = com.google.android.exoplayer2.i.t.MODEL;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0071;
    L_0x006f:
        r0 = r2;
        goto L_0x000a;
    L_0x0071:
        r1 = com.google.android.exoplayer2.i.t.aw(r6, r4);
        r2 = com.google.android.exoplayer2.i.t.aw(r7, r4);
        r1 = r1 * r2;
        r1 = r1 * 16;
        r1 = r1 * 16;
        r2 = r1;
        goto L_0x005d;
    L_0x0080:
        r1 = r6 * r7;
        r2 = r1;
        goto L_0x005d;
    L_0x0084:
        r2 = r6 * r7;
        r0 = r1;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.c.b(java.lang.String, int, int):int");
    }

    private static boolean b(boolean z, Format format, Format format2) {
        return format.adW.equals(format2.adW) && m(format) == m(format2) && (z || (format.width == format2.width && format.height == format2.height));
    }

    private static int m(Format format) {
        return format.aeb == -1 ? 0 : format.aeb;
    }
}
