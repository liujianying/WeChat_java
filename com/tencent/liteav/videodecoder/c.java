package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class c implements a {
    private BufferInfo a = new BufferInfo();
    private MediaCodec b = null;
    private String c = "video/avc";
    private int d = 540;
    private int e = 960;
    private long f = 0;
    private long g = 0;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private Surface k = null;
    private int l = 0;
    private ArrayList<b> m = new ArrayList();
    private d n;
    private WeakReference<a> o;

    public void setListener(d dVar) {
        this.n = dVar;
    }

    public void setNotifyListener(WeakReference<a> weakReference) {
        this.o = weakReference;
    }

    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.k = surface;
        return 0;
    }

    public void decode(b bVar) {
        boolean z = true;
        if (bVar.i != 1) {
            z = false;
        }
        a(z);
        this.m.add(bVar);
        while (!this.m.isEmpty()) {
            int size = this.m.size();
            b();
            if (size == this.m.size()) {
                return;
            }
        }
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        return a(byteBuffer, byteBuffer2, z2);
    }

    public void stop() {
        a();
    }

    public boolean isHevc() {
        return this.j;
    }

    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        Exception e;
        int i = 1;
        int i2 = -1;
        try {
            if (this.b != null || this.k == null) {
                TXCLog.e("MediaCodecDecoder", "decode: init decoder error, can not init for decoder=" + this.b + ",surface=" + this.k);
                return -1;
            }
            this.j = z;
            if (this.j) {
                this.c = "video/hevc";
            } else {
                this.c = "video/avc";
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.c, this.d, this.e);
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (byteBuffer2 != null) {
                createVideoFormat.setByteBuffer("csd-1", byteBuffer2);
            }
            this.b = MediaCodec.createDecoderByType(this.c);
            try {
                this.b.configure(createVideoFormat, this.k, null, 0);
                this.b.setVideoScalingMode(1);
                this.b.start();
                i = 4;
                TXCLog.w("MediaCodecDecoder", "decode: start decoder success, is hevc: " + this.j);
                try {
                    this.l = 0;
                    return 0;
                } catch (Exception e2) {
                    e = e2;
                    i2 = 0;
                }
            } catch (Exception e3) {
                e = e3;
                if (this.b != null) {
                    try {
                        this.b.release();
                        TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
                    } catch (Exception e4) {
                        TXCLog.e("MediaCodecDecoder", "decode: , decoder release exception: " + e.toString());
                        TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + e.toString());
                        f();
                        return i2;
                    } finally {
                        this.b = null;
                    }
                }
                TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + e.toString());
                f();
                return i2;
            }
        } catch (Exception e5) {
            e = e5;
            i = 0;
        }
    }

    private void a() {
        if (this.b != null) {
            try {
                this.b.stop();
                TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
                try {
                    this.b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                } catch (Exception e) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e.toString());
                } finally {
                }
            } catch (Exception e2) {
                TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + e2.toString());
                try {
                } catch (Exception e22) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e22.toString());
                } finally {
                    this.b = null;
                }
                this.m.clear();
                this.f = 0;
                this.h = true;
                return;
            } finally {
                try {
                    this.b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                } catch (Exception e3) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e3.toString());
                } finally {
                    this.b = null;
                }
            }
            this.m.clear();
            this.f = 0;
            this.h = true;
            return;
        }
        return;
        this.b = null;
    }

    @TargetApi(16)
    private void b() {
        if (this.b == null) {
            TXCLog.e("MediaCodecDecoder", "null decoder");
            return;
        }
        b bVar = (b) this.m.get(0);
        if (bVar == null || bVar.a.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
            this.m.remove(0);
            return;
        }
        ByteBuffer[] inputBuffers = this.b.getInputBuffers();
        if (inputBuffers == null || inputBuffers.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
            return;
        }
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        try {
            dequeueInputBuffer = this.b.dequeueInputBuffer(10000);
        } catch (Exception e) {
            TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! " + e);
            dequeueInputBuffer = -10000;
        }
        if (dequeueInputBuffer >= 0) {
            inputBuffers[dequeueInputBuffer].put(bVar.a);
            this.b.queueInputBuffer(dequeueInputBuffer, 0, bVar.a.length, bVar.g, 0);
            this.m.remove(0);
            if (this.f == 0) {
                TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: " + dequeueInputBuffer);
            }
        } else {
            TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
        try {
            dequeueOutputBuffer = this.b.dequeueOutputBuffer(this.a, 10000);
        } catch (Exception e2) {
            g();
            TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!" + e2);
            dequeueOutputBuffer = -10000;
        }
        if (dequeueOutputBuffer >= 0) {
            a(dequeueOutputBuffer, this.a.presentationTimeUs, this.a.presentationTimeUs);
            this.l = 0;
        } else if (dequeueOutputBuffer == -1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e3) {
            }
            TXCLog.d("MediaCodecDecoder", "decode: no output from decoder available when timeout");
            g();
        } else if (dequeueOutputBuffer == -3) {
            TXCLog.d("MediaCodecDecoder", "decode: output buffers changed");
        } else if (dequeueOutputBuffer == -2) {
            c();
        } else {
            TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
        }
    }

    private void a(int i, long j, long j2) {
        this.b.releaseOutputBuffer(i, true);
        if ((this.a.flags & 4) != 0) {
            TXCLog.d("MediaCodecDecoder", "output EOS");
        }
        try {
            if (this.n != null) {
                this.n.a(null, this.d, this.e, j, j2);
            }
        } catch (Exception e) {
        }
        d();
    }

    private void c() {
        MediaFormat outputFormat = this.b.getOutputFormat();
        TXCLog.d("MediaCodecDecoder", "decode output format changed: " + outputFormat);
        int abs = Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1;
        int abs2 = Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1;
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        abs = Math.min(abs, integer);
        integer2 = Math.min(abs2, integer2);
        if (abs != this.d || integer2 != this.e) {
            this.d = abs;
            this.e = integer2;
            try {
                if (this.n != null) {
                    this.n.a(this.d, this.e);
                }
            } catch (Exception e) {
            }
            TXCLog.d("MediaCodecDecoder", "decode: video size change to w:" + abs + ",h:" + integer2);
        } else if (this.h) {
            this.h = false;
            if (this.n != null) {
                this.n.a(this.d, this.e);
            }
        }
    }

    private void d() {
        if (this.f == 0) {
            TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f > 0 && currentTimeMillis > this.f + 1000 && currentTimeMillis > this.g + 2000 && this.g != 0) {
            TXCLog.e("MediaCodecDecoder", "frame interval[" + (currentTimeMillis - this.f) + "] > 1000");
            this.g = currentTimeMillis;
        }
        if (this.g == 0) {
            this.g = currentTimeMillis;
        }
        this.f = currentTimeMillis;
    }

    private boolean e() {
        int i;
        if (VERSION.SDK_INT >= 21) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                for (String contains : mediaCodecInfo.getSupportedTypes()) {
                    if (contains.contains("video/hevc")) {
                        TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + mediaCodecInfo.getName() + ",encoder:" + mediaCodecInfo.isEncoder());
                        return true;
                    }
                }
            }
            return false;
        }
        if (VERSION.SDK_INT >= 16) {
            int codecCount = MediaCodecList.getCodecCount();
            for (i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                for (String contains2 : codecInfoAt.getSupportedTypes()) {
                    if (contains2.contains("video/hevc")) {
                        TXCLog.e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + codecInfoAt.getName() + ",encoder:" + codecInfoAt.isEncoder());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void f() {
        if (!this.i) {
            TXCLog.w("MediaCodecDecoder", "decode hw decode error, hevc: " + this.j);
            if (this.j) {
                com.tencent.liteav.basic.util.a.a(this.o, -2304, "h265解码失败");
            } else {
                com.tencent.liteav.basic.util.a.a(this.o, 2106, "硬解启动失败，采用软解");
            }
            this.i = true;
        }
    }

    private void g() {
        if (this.l >= 40) {
            f();
            this.l = 0;
            return;
        }
        this.l++;
    }

    private void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (!this.i) {
                if (!this.j || e()) {
                    a();
                    a(null, null, this.j);
                    return;
                }
                a();
                f();
            }
        }
    }
}
