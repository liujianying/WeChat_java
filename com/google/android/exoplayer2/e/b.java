package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends a {
    private static final byte[] apt = t.aF("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final com.google.android.exoplayer2.drm.b<d> acz;
    private Format aep;
    private ByteBuffer[] agE;
    private final BufferInfo apA;
    private com.google.android.exoplayer2.drm.a<d> apB;
    private com.google.android.exoplayer2.drm.a<d> apC;
    public MediaCodec apD;
    public a apE;
    private int apF;
    private boolean apG;
    private boolean apH;
    private boolean apI;
    private boolean apJ;
    private boolean apK;
    private boolean apL;
    private boolean apM;
    private boolean apN;
    private ByteBuffer[] apO;
    private long apP;
    private int apQ;
    private int apR;
    private boolean apS;
    private boolean apT;
    private int apU;
    private int apV;
    private boolean apW;
    private boolean apX;
    private boolean apY;
    private boolean apZ;
    private final c apu;
    private final boolean apv;
    private final e apw;
    private final e apx;
    private final k apy;
    private final List<Long> apz;
    private boolean aqa;
    private boolean aqb;
    public com.google.android.exoplayer2.b.d aqc;

    public abstract int a(c cVar, Format format);

    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public b(int i, c cVar, com.google.android.exoplayer2.drm.b<d> bVar, boolean z) {
        super(i);
        com.google.android.exoplayer2.i.a.ap(t.SDK_INT >= 16);
        this.apu = (c) com.google.android.exoplayer2.i.a.Z(cVar);
        this.acz = bVar;
        this.apv = z;
        this.apw = new e(0);
        this.apx = new e(0);
        this.apy = new k();
        this.apz = new ArrayList();
        this.apA = new BufferInfo();
        this.apU = 0;
        this.apV = 0;
    }

    public final int iw() {
        return 8;
    }

    public final int b(Format format) {
        try {
            int a = a(this.apu, format);
            if ((a & 7) <= 2) {
                return a;
            }
            com.google.android.exoplayer2.drm.b bVar = this.acz;
            boolean jP = format.adZ == null ? true : bVar == null ? false : bVar.jP();
            if (jP) {
                return a;
            }
            return (a & -8) | 2;
        } catch (com.google.android.exoplayer2.e.d.b e) {
            throw com.google.android.exoplayer2.e.a(e, this.index);
        }
    }

    public a a(c cVar, Format format, boolean z) {
        return cVar.d(format.adW, z);
    }

    public final void kk() {
        boolean z = false;
        if (this.apD == null && this.aep != null) {
            boolean z2;
            boolean z3;
            MediaCrypto mediaCrypto;
            this.apB = this.apC;
            String str = this.aep.adW;
            if (this.apB != null) {
                d dVar = (d) this.apB.jO();
                if (dVar == null) {
                    com.google.android.exoplayer2.drm.a.a jN = this.apB.jN();
                    if (jN != null) {
                        throw com.google.android.exoplayer2.e.a(jN, this.index);
                    }
                    return;
                }
                MediaCrypto mediaCrypto2 = dVar.aiw;
                z2 = !dVar.aix && dVar.aiw.requiresSecureDecoderComponent(str);
                z3 = z2;
                mediaCrypto = mediaCrypto2;
            } else {
                z3 = false;
                mediaCrypto = null;
            }
            if (this.apE == null) {
                try {
                    this.apE = a(this.apu, this.aep, z3);
                    if (this.apE == null && z3) {
                        this.apE = a(this.apu, this.aep, false);
                        if (this.apE != null) {
                            new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.apE.name).append(".");
                        }
                    }
                } catch (com.google.android.exoplayer2.e.d.b e) {
                    a(new a(this.aep, e, z3, -49998));
                }
                if (this.apE == null) {
                    a(new a(this.aep, null, z3, -49999));
                }
            }
            if (a(this.apE)) {
                String str2 = this.apE.name;
                int i = (t.SDK_INT <= 24 && "OMX.Exynos.avc.dec.secure".equals(str2) && (t.MODEL.startsWith("SM-T585") || t.MODEL.startsWith("SM-A520"))) ? 2 : (t.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(t.DEVICE) || "flounder_lte".equals(t.DEVICE) || "grouper".equals(t.DEVICE) || "tilapia".equals(t.DEVICE)))) ? 0 : 1;
                this.apF = i;
                Format format = this.aep;
                if (t.SDK_INT < 21 && format.adY.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.apG = z2;
                if (t.SDK_INT < 18 || ((t.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (t.SDK_INT == 19 && t.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2))))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.apH = z2;
                if (t.SDK_INT > 17 || !("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.apI = z2;
                if ((t.SDK_INT > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && !(t.SDK_INT <= 19 && "hb2000".equals(t.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.apJ = z2;
                if (t.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.apK = z2;
                format = this.aep;
                if (t.SDK_INT <= 18 && format.aeg == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z = true;
                }
                this.apL = z;
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    r.beginSection("createCodec:" + str2);
                    this.apD = MediaCodec.createByCodecName(str2);
                    r.endSection();
                    r.beginSection("configureCodec");
                    a(this.apE, this.apD, this.aep, mediaCrypto);
                    r.endSection();
                    r.beginSection("startCodec");
                    this.apD.start();
                    r.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    c(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.apO = this.apD.getInputBuffers();
                    this.agE = this.apD.getOutputBuffers();
                } catch (Throwable e2) {
                    a(new a(this.aep, e2, z3, str2));
                }
                this.apP = this.state == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.apQ = -1;
                this.apR = -1;
                this.aqb = true;
                com.google.android.exoplayer2.b.d dVar2 = this.aqc;
                dVar2.ahY++;
            }
        }
    }

    private void a(a aVar) {
        throw com.google.android.exoplayer2.e.a(aVar, this.index);
    }

    public boolean a(a aVar) {
        return true;
    }

    public void ae(boolean z) {
        this.aqc = new com.google.android.exoplayer2.b.d();
    }

    public void b(long j, boolean z) {
        this.apY = false;
        this.apZ = false;
        if (this.apD != null) {
            this.apP = -9223372036854775807L;
            this.apQ = -1;
            this.apR = -1;
            this.aqb = true;
            this.aqa = false;
            this.apS = false;
            this.apz.clear();
            this.apM = false;
            this.apN = false;
            if (this.apH || (this.apJ && this.apX)) {
                kl();
                kk();
            } else if (this.apV != 0) {
                kl();
                kk();
            } else {
                this.apD.flush();
                this.apW = false;
            }
            if (this.apT && this.aep != null) {
                this.apU = 1;
            }
        }
    }

    public void ix() {
        this.aep = null;
        try {
            kl();
        } finally {
            this.apB = null;
            this.apC = null;
        }
    }

    public void kl() {
        this.apP = -9223372036854775807L;
        this.apQ = -1;
        this.apR = -1;
        this.aqa = false;
        this.apS = false;
        this.apz.clear();
        this.apO = null;
        this.agE = null;
        this.apE = null;
        this.apT = false;
        this.apW = false;
        this.apG = false;
        this.apH = false;
        this.apF = 0;
        this.apI = false;
        this.apJ = false;
        this.apL = false;
        this.apM = false;
        this.apN = false;
        this.apX = false;
        this.apU = 0;
        this.apV = 0;
        this.apw.aig = null;
        if (this.apD != null) {
            com.google.android.exoplayer2.b.d dVar = this.aqc;
            dVar.ahZ++;
            try {
                this.apD.stop();
                try {
                    this.apD.release();
                } finally {
                    this.apD = null;
                    if (!(this.apB == null || this.apC == this.apB)) {
                        this.apB = null;
                    }
                }
            } catch (Throwable th) {
                this.apD.release();
            } finally {
                this.apD = null;
                if (!(this.apB == null || this.apC == this.apB)) {
                    this.apB = null;
                }
            }
        }
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public final void c(long j, long j2) {
        if (this.apZ) {
            jv();
            return;
        }
        int a;
        if (this.aep == null) {
            this.apx.clear();
            a = a(this.apy, this.apx, true);
            if (a == -5) {
                e(this.apy.aep);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.ap(this.apx.jy());
                this.apY = true;
                ko();
                return;
            } else {
                return;
            }
        }
        kk();
        if (this.apD != null) {
            r.beginSection("drainAndFeed");
            do {
            } while (d(j, j2));
            do {
            } while (km());
            r.endSection();
        } else {
            this.ack.H(j - this.acl);
            this.apx.clear();
            a = a(this.apy, this.apx, false);
            if (a == -5) {
                e(this.apy.aep);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.ap(this.apx.jy());
                this.apY = true;
                ko();
            }
        }
        this.aqc.jC();
    }

    private boolean km() {
        if (this.apD == null || this.apV == 2 || this.apY) {
            return false;
        }
        if (this.apQ < 0) {
            this.apQ = this.apD.dequeueInputBuffer(0);
            if (this.apQ < 0) {
                return false;
            }
            this.apw.aig = this.apO[this.apQ];
            this.apw.clear();
        }
        if (this.apV == 1) {
            if (!this.apI) {
                this.apX = true;
                this.apD.queueInputBuffer(this.apQ, 0, 0, 0, 4);
                this.apQ = -1;
            }
            this.apV = 2;
            return false;
        } else if (this.apM) {
            this.apM = false;
            this.apw.aig.put(apt);
            this.apD.queueInputBuffer(this.apQ, 0, apt.length, 0, 0);
            this.apQ = -1;
            this.apW = true;
            return true;
        } else {
            int i;
            int i2;
            int position;
            if (this.aqa) {
                i = 0;
                i2 = -4;
            } else {
                if (this.apU == 1) {
                    for (i = 0; i < this.aep.adY.size(); i++) {
                        this.apw.aig.put((byte[]) this.aep.adY.get(i));
                    }
                    this.apU = 2;
                }
                position = this.apw.aig.position();
                i2 = a(this.apy, this.apw, false);
                i = position;
            }
            if (i2 == -3) {
                return false;
            }
            if (i2 == -5) {
                if (this.apU == 2) {
                    this.apw.clear();
                    this.apU = 1;
                }
                e(this.apy.aep);
                return true;
            } else if (this.apw.jy()) {
                if (this.apU == 2) {
                    this.apw.clear();
                    this.apU = 1;
                }
                this.apY = true;
                if (this.apW) {
                    try {
                        if (this.apI) {
                            return false;
                        }
                        this.apX = true;
                        this.apD.queueInputBuffer(this.apQ, 0, 0, 0, 4);
                        this.apQ = -1;
                        return false;
                    } catch (Exception e) {
                        throw com.google.android.exoplayer2.e.a(e, this.index);
                    }
                }
                ko();
                return false;
            } else if (!this.aqb || this.apw.jz()) {
                boolean z;
                this.aqb = false;
                boolean jD = this.apw.jD();
                if (this.apB == null || (!jD && this.apv)) {
                    z = false;
                } else {
                    position = this.apB.getState();
                    if (position == 1) {
                        throw com.google.android.exoplayer2.e.a(this.apB.jN(), this.index);
                    }
                    z = position != 4;
                }
                this.aqa = z;
                if (this.aqa) {
                    return false;
                }
                if (this.apG && !jD) {
                    h.e(this.apw.aig);
                    if (this.apw.aig.position() == 0) {
                        return true;
                    }
                    this.apG = false;
                }
                try {
                    long j = this.apw.aih;
                    if (this.apw.jx()) {
                        this.apz.add(Long.valueOf(j));
                    }
                    this.apw.jE();
                    kn();
                    if (jD) {
                        CryptoInfo cryptoInfo = this.apw.aif.ahV;
                        if (i != 0) {
                            if (cryptoInfo.numBytesOfClearData == null) {
                                cryptoInfo.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = cryptoInfo.numBytesOfClearData;
                            iArr[0] = i + iArr[0];
                        }
                        this.apD.queueSecureInputBuffer(this.apQ, 0, cryptoInfo, j, 0);
                    } else {
                        this.apD.queueInputBuffer(this.apQ, 0, this.apw.aig.limit(), j, 0);
                    }
                    this.apQ = -1;
                    this.apW = true;
                    this.apU = 0;
                    com.google.android.exoplayer2.b.d dVar = this.aqc;
                    dVar.aia++;
                    return true;
                } catch (Exception e2) {
                    throw com.google.android.exoplayer2.e.a(e2, this.index);
                }
            } else {
                this.apw.clear();
                if (this.apU == 2) {
                    this.apU = 1;
                }
                return true;
            }
        }
    }

    public void c(String str, long j, long j2) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(com.google.android.exoplayer2.Format r7) {
        /*
        r6 = this;
        r1 = 0;
        r2 = 0;
        r3 = 1;
        r4 = r6.aep;
        r6.aep = r7;
        r0 = r6.aep;
        r5 = r0.adZ;
        if (r4 != 0) goto L_0x0030;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r0 = com.google.android.exoplayer2.i.t.i(r5, r0);
        if (r0 != 0) goto L_0x0033;
    L_0x0014:
        r0 = r3;
    L_0x0015:
        if (r0 == 0) goto L_0x004a;
    L_0x0017:
        r0 = r6.aep;
        r0 = r0.adZ;
        if (r0 == 0) goto L_0x0081;
    L_0x001d:
        r0 = r6.acz;
        if (r0 != 0) goto L_0x0035;
    L_0x0021:
        r0 = new java.lang.IllegalStateException;
        r1 = "Media requires a DrmSessionManager";
        r0.<init>(r1);
        r1 = r6.index;
        r0 = com.google.android.exoplayer2.e.a(r0, r1);
        throw r0;
    L_0x0030:
        r0 = r4.adZ;
        goto L_0x000e;
    L_0x0033:
        r0 = r2;
        goto L_0x0015;
    L_0x0035:
        r0 = r6.acz;
        android.os.Looper.myLooper();
        r1 = r6.aep;
        r1 = r1.adZ;
        r0 = r0.jQ();
        r6.apC = r0;
        r0 = r6.apC;
        r1 = r6.apB;
        if (r0 != r1) goto L_0x004a;
    L_0x004a:
        r0 = r6.apC;
        r1 = r6.apB;
        if (r0 != r1) goto L_0x0086;
    L_0x0050:
        r0 = r6.apD;
        if (r0 == 0) goto L_0x0086;
    L_0x0054:
        r0 = r6.apE;
        r0 = r0.apq;
        r1 = r6.aep;
        r0 = r6.a(r0, r4, r1);
        if (r0 == 0) goto L_0x0086;
    L_0x0060:
        r6.apT = r3;
        r6.apU = r3;
        r0 = r6.apF;
        r1 = 2;
        if (r0 == r1) goto L_0x007d;
    L_0x0069:
        r0 = r6.apF;
        if (r0 != r3) goto L_0x0084;
    L_0x006d:
        r0 = r6.aep;
        r0 = r0.width;
        r1 = r4.width;
        if (r0 != r1) goto L_0x0084;
    L_0x0075:
        r0 = r6.aep;
        r0 = r0.height;
        r1 = r4.height;
        if (r0 != r1) goto L_0x0084;
    L_0x007d:
        r0 = r3;
    L_0x007e:
        r6.apM = r0;
    L_0x0080:
        return;
    L_0x0081:
        r6.apC = r1;
        goto L_0x004a;
    L_0x0084:
        r0 = r2;
        goto L_0x007e;
    L_0x0086:
        r0 = r6.apW;
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r6.apV = r3;
        goto L_0x0080;
    L_0x008d:
        r6.kl();
        r6.kk();
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.e(com.google.android.exoplayer2.Format):void");
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    public void kn() {
    }

    public boolean a(boolean z, Format format, Format format2) {
        return false;
    }

    public boolean iT() {
        return this.apZ;
    }

    public boolean hv() {
        if (!(this.aep == null || this.aqa)) {
            if ((this.acm ? this.acn : this.ack.hv()) || this.apR >= 0 || (this.apP != -9223372036854775807L && SystemClock.elapsedRealtime() < this.apP)) {
                return true;
            }
        }
        return false;
    }

    private boolean d(long j, long j2) {
        boolean z;
        if (this.apR < 0) {
            if (this.apK && this.apX) {
                try {
                    this.apR = this.apD.dequeueOutputBuffer(this.apA, 0);
                } catch (IllegalStateException e) {
                    ko();
                    if (this.apZ) {
                        kl();
                    }
                    return false;
                }
            }
            this.apR = this.apD.dequeueOutputBuffer(this.apA, 0);
            if (this.apR >= 0) {
                if (this.apN) {
                    this.apN = false;
                    this.apD.releaseOutputBuffer(this.apR, false);
                    this.apR = -1;
                    return true;
                } else if ((this.apA.flags & 4) != 0) {
                    ko();
                    this.apR = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.agE[this.apR];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.apA.offset);
                        byteBuffer.limit(this.apA.offset + this.apA.size);
                    }
                    long j3 = this.apA.presentationTimeUs;
                    int size = this.apz.size();
                    for (int i = 0; i < size; i++) {
                        if (((Long) this.apz.get(i)).longValue() == j3) {
                            this.apz.remove(i);
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    this.apS = z;
                }
            } else if (this.apR == -2) {
                MediaFormat outputFormat = this.apD.getOutputFormat();
                if (this.apF != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.apN = true;
                } else {
                    if (this.apL) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.apD, outputFormat);
                }
                return true;
            } else if (this.apR == -3) {
                this.agE = this.apD.getOutputBuffers();
                return true;
            } else {
                if (this.apI && (this.apY || this.apV == 2)) {
                    ko();
                }
                return false;
            }
        }
        if (this.apK && this.apX) {
            try {
                z = a(j, j2, this.apD, this.agE[this.apR], this.apR, this.apA.flags, this.apA.presentationTimeUs, this.apS);
            } catch (IllegalStateException e2) {
                ko();
                if (this.apZ) {
                    kl();
                }
                return false;
            }
        }
        z = a(j, j2, this.apD, this.agE[this.apR], this.apR, this.apA.flags, this.apA.presentationTimeUs, this.apS);
        if (!z) {
            return false;
        }
        long j4 = this.apA.presentationTimeUs;
        this.apR = -1;
        return true;
    }

    public void jv() {
    }

    private void ko() {
        if (this.apV == 2) {
            kl();
            kk();
            return;
        }
        this.apZ = true;
        jv();
    }
}
