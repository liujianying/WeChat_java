package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import javax.microedition.khronos.egl.EGL10;

public class a extends c {
    private static final String a = a.class.getSimpleName();
    private boolean A;
    private ByteBuffer[] B;
    private byte[] C;
    private volatile long D;
    private long E;
    private long F;
    private int G;
    private int H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private long q;
    private MediaCodec r;
    private b s;
    private Runnable t;
    private Runnable u;
    private ArrayDeque<Long> v;
    private Object w;
    private Surface x;
    private boolean y;
    private boolean z;

    public a() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = new 6(this);
        this.u = new 7(this);
        this.v = new ArrayDeque(10);
        this.x = null;
        this.y = true;
        this.z = true;
        this.A = false;
        this.B = null;
        this.C = null;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = -1;
        this.s = new b("HWVideoEncoder");
    }

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        super.start(tXSVideoEncoderParam);
        boolean[] zArr = new boolean[1];
        if (VERSION.SDK_INT < 18) {
            zArr[0] = false;
        } else {
            synchronized (this) {
                this.s.a(new 1(this, zArr, tXSVideoEncoderParam));
            }
        }
        if (!zArr[0]) {
            callDelegate(10000004);
        }
        if (zArr[0]) {
            return 0;
        }
        return 10000004;
    }

    public void stop() {
        this.z = true;
        synchronized (this) {
            this.s.a(new 2(this));
        }
    }

    public void setFPS(int i) {
        this.s.b(new 3(this, i));
    }

    public void setBitrate(int i) {
        this.b = i;
        this.s.b(new 4(this, i));
    }

    public long getRealFPS() {
        return this.d;
    }

    public long getRealBitrate() {
        return this.c;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        if (this.z) {
            return 10000004;
        }
        GLES20.glFinish();
        this.D = j;
        this.M = i;
        this.J++;
        if (this.I) {
            f();
        }
        this.s.b(this.u);
        return 0;
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        if (this.z) {
            return 10000004;
        }
        GLES20.glFinish();
        this.D = j;
        this.M = i;
        this.J++;
        if (this.I) {
            f();
        }
        this.s.a(this.u);
        return 0;
    }

    public void signalEOSAndFlush() {
        if (!this.z) {
            this.s.a(new 5(this));
        }
    }

    @TargetApi(16)
    private MediaFormat a(int i, int i2, int i3, int i4, int i5) {
        if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
            return null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3 * 1024);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", i5);
        return createVideoFormat;
    }

    @TargetApi(16)
    private MediaFormat a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        MediaFormat a = a(i, i2, i3, i4, i5);
        if (a == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 21) {
            MediaCodecInfo a2 = a("video/avc");
            if (a2 == null) {
                return a;
            }
            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType("video/avc");
            EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            if (encoderCapabilities.isBitrateModeSupported(i6)) {
                a.setInteger("bitrate-mode", i6);
            } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                a.setInteger("bitrate-mode", 2);
            }
            a.setInteger("complexity", ((Integer) encoderCapabilities.getComplexityRange().clamp(Integer.valueOf(5))).intValue());
            if (VERSION.SDK_INT >= 23) {
                int i8 = 0;
                for (CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                    if (codecProfileLevel.profile <= i7 && codecProfileLevel.profile > i8) {
                        i8 = codecProfileLevel.profile;
                        a.setInteger("profile", codecProfileLevel.profile);
                        a.setInteger("level", codecProfileLevel.level);
                    }
                }
            }
        }
        return a;
    }

    @TargetApi(16)
    private static MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private void a(long j) {
        this.v.add(Long.valueOf(j));
    }

    private long a() {
        Long l = (Long) this.v.poll();
        return l == null ? 0 : l.longValue();
    }

    private boolean a(Surface surface, int i, int i2) {
        if (surface == null) {
            return false;
        }
        if (this.A) {
            EGLContext eGLContext = (EGLContext) this.mGLContextExternal;
            if (eGLContext == null) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            this.w = c.a(null, eGLContext, surface, i, i2);
        } else {
            javax.microedition.khronos.egl.EGLContext eGLContext2 = (javax.microedition.khronos.egl.EGLContext) this.mGLContextExternal;
            if (eGLContext2 == null) {
                eGLContext2 = EGL10.EGL_NO_CONTEXT;
            }
            this.w = com.tencent.liteav.basic.d.b.a(null, eGLContext2, surface, i, i2);
        }
        if (this.w == null) {
            return false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.mEncodeFilter = new d();
        this.mEncodeFilter.a(h.e, h.a(g.NORMAL, false, false));
        if (this.mEncodeFilter.a()) {
            GLES20.glViewport(0, 0, i, i2);
            return true;
        }
        this.mEncodeFilter = null;
        return false;
    }

    private void b() {
        if (this.mEncodeFilter != null) {
            this.mEncodeFilter.d();
            this.mEncodeFilter = null;
        }
        if (this.w instanceof com.tencent.liteav.basic.d.b) {
            ((com.tencent.liteav.basic.d.b) this.w).b();
            this.w = null;
        }
        if (this.w instanceof c) {
            ((c) this.w).b();
            this.w = null;
        }
    }

    @TargetApi(18)
    private boolean a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        boolean z = true;
        this.z = false;
        this.y = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.q = 0;
        this.B = null;
        this.C = null;
        this.D = 0;
        this.G = -1;
        this.mOutputWidth = tXSVideoEncoderParam.width;
        this.mOutputHeight = tXSVideoEncoderParam.height;
        this.H = tXSVideoEncoderParam.gop;
        this.I = tXSVideoEncoderParam.fullIFrame;
        this.o = tXSVideoEncoderParam.syncOutput;
        this.A = tXSVideoEncoderParam.enableEGL14;
        this.v.clear();
        if (tXSVideoEncoderParam == null || tXSVideoEncoderParam.width == 0 || tXSVideoEncoderParam.height == 0 || tXSVideoEncoderParam.fps == 0 || tXSVideoEncoderParam.gop == 0) {
            this.y = true;
            return false;
        }
        int i;
        this.h = tXSVideoEncoderParam.annexb;
        this.i = tXSVideoEncoderParam.appendSpsPps;
        if (this.b == 0) {
            this.b = (int) (Math.sqrt((((double) (tXSVideoEncoderParam.width * tXSVideoEncoderParam.width)) * 1.0d) + ((double) (tXSVideoEncoderParam.height * tXSVideoEncoderParam.height))) * 1.2d);
        }
        this.j = (long) this.b;
        this.g = tXSVideoEncoderParam.fps;
        switch (tXSVideoEncoderParam.encoderMode) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 0;
                break;
            default:
                i = 2;
                break;
        }
        if (com.tencent.liteav.basic.e.b.a().c() == 1) {
            tXSVideoEncoderParam.encoderProfile = 1;
        }
        try {
            MediaFormat a = a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop, i, 1);
            if (a == null) {
                this.y = true;
                return false;
            }
            this.r = MediaCodec.createEncoderByType("video/avc");
            try {
                this.r.configure(a, null, null, 1);
            } catch (Exception e) {
                if ((e instanceof IllegalArgumentException) || (VERSION.SDK_INT >= 21 && (e instanceof CodecException))) {
                    this.r.configure(a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop), null, null, 1);
                } else {
                    throw e;
                }
            } catch (Exception e2) {
                if (z >= true && this.r != null) {
                    this.r.stop();
                }
                this.r = null;
                if (this.x != null) {
                    this.x.release();
                }
                this.x = null;
                if (this.r != null) {
                }
                this.y = true;
                return false;
            }
            z = true;
            this.x = this.r.createInputSurface();
            this.r.start();
            this.B = this.r.getOutputBuffers();
            if (this.r != null || this.B == null || this.x == null) {
                this.y = true;
                return false;
            } else if (a(this.x, tXSVideoEncoderParam.width, tXSVideoEncoderParam.height)) {
                this.mInit = true;
                return true;
            } else {
                this.y = true;
                return false;
            }
        } catch (Exception e3) {
            z = true;
            this.r.stop();
            this.r = null;
            if (this.x != null) {
                this.x.release();
            }
            this.x = null;
            if (this.r != null) {
            }
            this.y = true;
            return false;
        }
    }

    private int c() {
        if (this.r == null) {
            return -1;
        }
        BufferInfo bufferInfo = new BufferInfo();
        try {
            int dequeueOutputBuffer = this.r.dequeueOutputBuffer(bufferInfo, 10000);
            if (dequeueOutputBuffer == -1) {
                return 0;
            }
            if (dequeueOutputBuffer == -3) {
                this.B = this.r.getOutputBuffers();
                return 1;
            } else if (dequeueOutputBuffer == -2) {
                callDelegate(this.r.getOutputFormat());
                return 1;
            } else if (dequeueOutputBuffer < 0) {
                return -1;
            } else {
                int i;
                ByteBuffer byteBuffer = this.B[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    i = -1;
                } else {
                    byte[] bArr;
                    Object bArr2;
                    Object obj = new byte[bufferInfo.size];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    byteBuffer.get(obj, 0, bufferInfo.size);
                    i = obj.length;
                    if (bufferInfo.size > 5 && obj[0] == (byte) 0 && obj[1] == (byte) 0 && obj[2] == (byte) 0 && obj[3] == (byte) 0 && obj[4] == (byte) 0 && obj[5] == (byte) 0) {
                        int i2 = 3;
                        while (i2 < i - 4) {
                            if (obj[i2] == (byte) 0 && obj[i2 + 1] == (byte) 0 && obj[i2 + 2] == (byte) 0 && obj[i2 + 3] == (byte) 1) {
                                i -= i2;
                                break;
                            }
                            i2++;
                        }
                        i2 = 0;
                        Object obj2 = new byte[i];
                        System.arraycopy(obj, i2, obj2, 0, i);
                        bArr2 = obj2;
                    } else {
                        bArr2 = obj;
                    }
                    if (bufferInfo.size != 0) {
                        int i3 = 1;
                        if ((bufferInfo.flags & 2) == 2) {
                            if (this.h) {
                                this.C = (byte[]) bArr2.clone();
                            } else {
                                this.C = a((byte[]) bArr2.clone());
                            }
                            i = 1;
                        } else {
                            byte[] bArr3;
                            if ((bufferInfo.flags & 1) == 1) {
                                i3 = 0;
                                this.G = -1;
                                if (this.h) {
                                    bArr3 = new byte[(this.C.length + bArr2.length)];
                                    System.arraycopy(this.C, 0, bArr3, 0, this.C.length);
                                    System.arraycopy(bArr2, 0, bArr3, this.C.length, bArr2.length);
                                } else {
                                    bArr2 = a(bArr2);
                                    bArr3 = new byte[(this.C.length + bArr2.length)];
                                    System.arraycopy(this.C, 0, bArr3, 0, this.C.length);
                                    System.arraycopy(bArr2, 0, bArr3, this.C.length, bArr2.length);
                                }
                            } else if (this.h) {
                                bArr3 = bArr2;
                            } else {
                                bArr3 = a(bArr2);
                            }
                            if (!this.I) {
                                i = this.G + 1;
                                this.G = i;
                                if (i == this.g * this.H) {
                                    f();
                                }
                            }
                            long a = a();
                            long j = bufferInfo.presentationTimeUs / 1000;
                            if (this.F == 0) {
                                this.F = a;
                            }
                            if (this.E == 0) {
                                this.E = j;
                            }
                            long j2 = j + (this.F - this.E);
                            if (a <= this.n) {
                                a = this.n + 1;
                            }
                            if (a > j2) {
                                a = j2;
                            }
                            this.n = a;
                            a = TXCTimeUtil.getTimeTick();
                            if (i3 == 0) {
                                if (a > this.e + 1000) {
                                    this.c = (long) (((((double) this.p) * 8000.0d) / ((double) (a - this.e))) / 1024.0d);
                                    this.p = 0;
                                    this.e = a;
                                }
                                this.k++;
                                this.l = 0;
                            } else {
                                this.l++;
                            }
                            this.p += (long) bArr3.length;
                            if (a > this.f + 2000) {
                                this.d = (long) ((((double) this.q) * 1000.0d) / ((double) (a - this.f)));
                                this.q = 0;
                                this.f = a;
                            }
                            this.q++;
                            byteBuffer.position(bufferInfo.offset);
                            if (this.i) {
                                callDelegate(bArr3, i3, this.k, this.l, this.m, i3 == 0 ? 0 : this.l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                            } else {
                                callDelegate(obj, i3, this.k, this.l, this.m, i3 == 0 ? 0 : this.l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                            }
                            this.m++;
                            this.L++;
                            if ((bufferInfo.flags & 4) != 0) {
                                if (this.mListener != null) {
                                    this.mListener.a(null, 0);
                                }
                                i = -2;
                            } else {
                                i = 1;
                            }
                        }
                    } else if ((bufferInfo.flags & 4) != 0) {
                        if (this.mListener != null) {
                            this.mListener.a(null, 0);
                        }
                        i = -2;
                    } else {
                        i = -1;
                    }
                }
                try {
                    if (this.r == null) {
                        return i;
                    }
                    this.r.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return i;
                } catch (IllegalStateException e) {
                    return i;
                }
            }
        } catch (IllegalStateException e2) {
            return -1;
        }
    }

    private byte[] a(byte[] bArr) {
        int i;
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 20)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            if (bArr[i2] == (byte) 0 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1) {
                i4 = a(i2, i3, bArr2, bArr, i4);
                i = i2 + 3;
                i2 = i;
                i3 = i;
            } else if (bArr[i2] == (byte) 0 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 0 && bArr[i2 + 3] == (byte) 1) {
                i4 = a(i2, i3, bArr2, bArr, i4);
                i = i2 + 4;
                i2 = i;
                i3 = i;
            }
            if (i2 == length - 4 && (bArr[i2 + 1] != (byte) 0 || bArr[i2 + 2] != (byte) 0 || bArr[i2 + 3] != (byte) 1)) {
                i2 = length;
                break;
            }
            i2++;
        }
        i = a(i2, i3, bArr2, bArr, i4);
        Object obj = new byte[i];
        System.arraycopy(bArr2, 0, obj, 0, i);
        return obj;
    }

    private int a(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        if (i2 <= 0 || i <= i2) {
            return i3;
        }
        int i4 = i - i2;
        try {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[4]);
            wrap.asIntBuffer().put(i4);
            wrap.order(ByteOrder.BIG_ENDIAN);
            System.arraycopy(wrap.array(), 0, bArr, i3, 4);
            System.arraycopy(bArr2, i2, bArr, i3 + 4, i4);
            return i3 + (i4 + 4);
        } catch (Exception e) {
            TXCLog.e(a, "setNalData exception");
            return i3;
        }
    }

    @TargetApi(18)
    private void d() {
        if (!this.y && this.w != null) {
            int c;
            a(this.D);
            this.mEncodeFilter.a(this.M);
            if (this.w instanceof c) {
                ((c) this.w).a(this.D * 1000000);
                ((c) this.w).c();
            }
            if (this.w instanceof com.tencent.liteav.basic.d.b) {
                ((com.tencent.liteav.basic.d.b) this.w).a();
            }
            do {
                c = c();
            } while (c > 0);
            if (c == -1 || c == -2) {
                if (c == -1) {
                    callDelegate(10000005);
                }
                this.y = true;
                e();
                return;
            }
            this.K++;
        }
    }

    private void e() {
        if (this.mInit) {
            this.y = true;
            this.z = true;
            b();
            try {
                this.r.stop();
                try {
                    this.r.release();
                } catch (Exception e) {
                }
            } catch (IllegalStateException e2) {
                try {
                    this.r.release();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    this.r.release();
                } catch (Exception e4) {
                }
                throw th;
            }
            this.r = null;
            this.M = -1;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.p = 0;
            this.q = 0;
            this.mGLContextExternal = null;
            this.B = null;
            this.C = null;
            this.D = 0;
            this.mOutputWidth = 0;
            this.mOutputHeight = 0;
            this.mInit = false;
            this.mListener = null;
            this.v.clear();
        }
    }

    private void a(int i) {
        if (this.j != ((long) this.b)) {
            this.j = (long) this.b;
            if (VERSION.SDK_INT >= 19 && this.r != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", this.b * 1024);
                this.r.setParameters(bundle);
            }
        }
    }

    private void f() {
        if (VERSION.SDK_INT >= 19 && this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.r.setParameters(bundle);
        }
    }

    private void b(int i) {
    }
}
