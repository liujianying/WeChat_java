package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI$AVOptions;
import com.tencent.mm.plugin.appbrand.jsapi.p.h;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class d implements a {
    public static float a = 0.5f;
    public static float b = 0.8f;
    public static float c = 1.25f;
    public static float d = 2.0f;
    private int e = 2;
    private TXSWMuxerJNI f;
    private String g = null;
    private MediaFormat h = null;
    private MediaFormat i = null;
    private int j = 0;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private ConcurrentLinkedQueue<a> n = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<a> o = new ConcurrentLinkedQueue();
    private long p = -1;
    private long q = -1;
    private long r = -1;

    public synchronized void a(MediaFormat mediaFormat) {
        TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:" + mediaFormat);
        this.h = mediaFormat;
        this.n.clear();
    }

    public synchronized void b(MediaFormat mediaFormat) {
        TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:" + mediaFormat);
        this.i = mediaFormat;
        this.o.clear();
    }

    public synchronized boolean c() {
        boolean z;
        if (this.h != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private ByteBuffer d() {
        ByteBuffer byteBuffer = this.i.getByteBuffer("csd-0");
        byteBuffer.position(0);
        return byteBuffer;
    }

    private ByteBuffer e() {
        return this.h.getByteBuffer("csd-0");
    }

    private ByteBuffer f() {
        return this.h.getByteBuffer("csd-1");
    }

    public synchronized int a() {
        int i = 0;
        synchronized (this) {
            if (this.g == null || this.g.isEmpty()) {
                TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
                i = -1;
            } else if (!c()) {
                TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
                i = -2;
            } else if (this.f != null) {
                TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
            } else {
                int integer;
                TXCLog.d("TXCMP4SWMuxer", "start");
                this.f = new TXSWMuxerJNI();
                TXSWMuxerJNI$AVOptions tXSWMuxerJNI$AVOptions = new TXSWMuxerJNI$AVOptions();
                if (this.h != null) {
                    integer = this.h.getInteger("width");
                    tXSWMuxerJNI$AVOptions.videoHeight = this.h.getInteger("height");
                    tXSWMuxerJNI$AVOptions.videoWidth = integer;
                    tXSWMuxerJNI$AVOptions.videoGOP = this.h.containsKey("i-frame-interval") ? this.h.getInteger("i-frame-interval") : 3;
                }
                if (this.i != null) {
                    integer = this.i.getInteger("channel-count");
                    int integer2 = this.i.getInteger("sample-rate");
                    tXSWMuxerJNI$AVOptions.audioChannels = integer;
                    tXSWMuxerJNI$AVOptions.audioSampleRate = integer2;
                }
                ByteBuffer e = e();
                ByteBuffer f = f();
                ByteBuffer d = d();
                if (e == null || f == null || d == null) {
                    TXCLog.e("TXCMP4SWMuxer", "video or audio format contains error csd!");
                    i = -3;
                } else {
                    this.f.a(e, e.capacity(), f, f.capacity());
                    this.f.a(d, d.capacity());
                    this.f.a(tXSWMuxerJNI$AVOptions);
                    this.f.a(this.g);
                    this.f.a();
                    this.p = -1;
                    this.l = true;
                    this.m = false;
                    this.q = -1;
                    this.r = -1;
                }
            }
        }
        return i;
    }

    public synchronized int b() {
        int i = 0;
        synchronized (this) {
            if (this.f != null) {
                TXCLog.d("TXCMP4SWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
                try {
                    if (this.l && this.m) {
                        this.f.b();
                    }
                    this.f.c();
                    this.f = null;
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                } catch (Exception e) {
                    TXCLog.e("TXCMP4SWMuxer", "muxer stop/release exception: " + e);
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                    i = -1;
                } catch (Throwable th) {
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                }
            }
        }
        return i;
    }

    public synchronized void a(String str) {
        this.g = str;
        if (!TextUtils.isEmpty(this.g)) {
            File file = new File(this.g);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public synchronized void b(byte[] bArr, int i, int i2, long j, int i3) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        a(allocateDirect, bufferInfo);
    }

    public synchronized void a(byte[] bArr, int i, int i2, long j, int i3) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        b(allocateDirect, bufferInfo);
    }

    public synchronized void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.f == null) {
            a(true, byteBuffer, bufferInfo);
            TXCLog.w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
        } else if (this.p < 0) {
            a(true, byteBuffer, bufferInfo);
            this.p = g();
            TXCLog.d("TXCMP4SWMuxer", "first frame offset = " + this.p);
            h();
        } else {
            c(byteBuffer, bufferInfo);
        }
    }

    public synchronized void b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.f == null || this.p < 0) {
            TXCLog.w("TXCMP4SWMuxer", "cache sample before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            a(false, byteBuffer, bufferInfo);
        } else {
            d(byteBuffer, bufferInfo);
        }
    }

    private void c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        long j = 0;
        int i = 1;
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (j2 < 0) {
            TXCLog.e("TXCMP4SWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.q > 0) {
                j = this.q;
            }
        } else {
            j = j2;
        }
        if (j < this.q) {
            TXCLog.w("TXCMP4SWMuxer", "video is not in chronological order. current frame's pts(" + j + ") smaller than pre frame's pts(" + this.q + ")");
        } else {
            this.q = j;
        }
        if (this.e != 2) {
            if (this.e == 3) {
                j = (long) (((float) j) * b);
            } else if (this.e == 4) {
                j = (long) (((float) j) * a);
            } else if (this.e == 1) {
                j = (long) (((float) j) * c);
            } else if (this.e == 0) {
                j = (long) (((float) j) * d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            TXSWMuxerJNI tXSWMuxerJNI = this.f;
            int i2 = bufferInfo.offset;
            int i3 = bufferInfo.size;
            if (bufferInfo.flags != 1) {
                i = 0;
            }
            tXSWMuxerJNI.a(byteBuffer, 1, i2, i3, i, bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
        } catch (IllegalStateException e) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: " + e);
        } catch (IllegalArgumentException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: " + e2);
        }
    }

    private void d(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        long j = bufferInfo.presentationTimeUs - this.p;
        if (this.p < 0 || j < 0) {
            TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            return;
        }
        if (j < this.r) {
            TXCLog.e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + j + ") must larger than pre audio's pts(" + this.r + ")");
            j = this.r + 1;
        } else {
            this.r = j;
        }
        if (this.e != 2) {
            if (this.e == 3) {
                j = (long) (((float) j) * b);
            } else if (this.e == 4) {
                j = (long) (((float) j) * a);
            } else if (this.e == 1) {
                j = (long) (((float) j) * c);
            } else if (this.e == 0) {
                j = (long) (((float) j) * d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f.a(byteBuffer, 0, bufferInfo.offset, bufferInfo.size, bufferInfo.flags, bufferInfo.presentationTimeUs);
        } catch (IllegalStateException e) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: " + e);
        } catch (IllegalArgumentException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: " + e2);
        }
    }

    private void a(boolean z, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (byteBuffer != null && bufferInfo != null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            byteBuffer.rewind();
            if (bufferInfo.size > 0) {
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.size);
            }
            allocateDirect.rewind();
            allocateDirect.put(byteBuffer);
            BufferInfo bufferInfo2 = new BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
            a aVar = new a(allocateDirect, bufferInfo2);
            if (z) {
                if (this.n.size() < 200) {
                    this.n.add(aVar);
                } else {
                    TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
                }
            } else if (this.o.size() < h.CTRL_INDEX) {
                this.o.add(aVar);
            } else {
                TXCLog.e("TXCMP4SWMuxer", "drop audio frame. audio cache size is larger than 300");
            }
        }
    }

    private long g() {
        long j;
        if (this.n.size() > 0) {
            j = ((a) this.n.peek()).b().presentationTimeUs;
        } else {
            j = 0;
        }
        if (this.o.size() <= 0) {
            return j;
        }
        a aVar = (a) this.o.peek();
        if (aVar == null || aVar.b() == null) {
            return j;
        }
        long j2 = ((a) this.o.peek()).b().presentationTimeUs;
        if (j > j2) {
            return j2;
        }
        return j;
    }

    private void h() {
        a aVar;
        while (this.n.size() > 0) {
            aVar = (a) this.n.poll();
            c(aVar.a(), aVar.b());
        }
        while (this.o.size() > 0) {
            aVar = (a) this.o.poll();
            d(aVar.a(), aVar.b());
        }
    }
}
