package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements a, d {
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    Surface e;
    d f;
    private int g;
    private ByteBuffer h;
    private ByteBuffer i;
    private long j;
    private boolean k = false;
    private ArrayList<com.tencent.liteav.basic.f.b> l = new ArrayList();
    private a m;
    private WeakReference<a> n;

    public void onNotifyEvent(int i, Bundle bundle) {
        com.tencent.liteav.basic.util.a.a(this.n, this.j, i, bundle);
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public boolean a() {
        return this.b;
    }

    public void a(a aVar) {
        this.n = new WeakReference(aVar);
    }

    public int a(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        return a(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z);
    }

    public int a(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        this.e = surface;
        this.h = byteBuffer;
        this.i = byteBuffer2;
        this.a = z;
        return 0;
    }

    public void a(boolean z) {
        this.b = z;
    }

    private void b(com.tencent.liteav.basic.f.b bVar) {
        boolean z = bVar.b == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", bVar.a);
        bundle.putLong("pts", bVar.g);
        bundle.putLong("dts", bVar.h);
        bundle.putInt("codecId", bVar.i);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        a aVar = this.m;
        if (aVar != null) {
            aVar.sendMessage(message);
        }
        this.g++;
    }

    public void a(com.tencent.liteav.basic.f.b bVar) {
        try {
            Object obj = bVar.b == 0 ? 1 : null;
            if (this.d || obj != null) {
                if (!(this.d || obj == null)) {
                    TXCLog.w("TXCVideoDecoder", "play:decode: push first i frame");
                    this.d = true;
                }
                if (!(this.k || bVar.i != 1 || this.b)) {
                    TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
                    com.tencent.liteav.basic.util.a.a(this.n, TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
                    this.k = true;
                }
                if (this.m != null) {
                    if (!this.l.isEmpty()) {
                        Iterator it = this.l.iterator();
                        while (it.hasNext()) {
                            b((com.tencent.liteav.basic.f.b) it.next());
                        }
                    }
                    this.l.clear();
                    b(bVar);
                    return;
                }
                if (!(obj == null || this.l.isEmpty())) {
                    this.l.clear();
                }
                this.l.add(bVar);
                if (!this.k) {
                    b();
                    return;
                }
                return;
            }
            TXCLog.i("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b() {
        /*
        r10 = this;
        r9 = 2008; // 0x7d8 float:2.814E-42 double:9.92E-321;
        r0 = -1;
        r8 = 0;
        r1 = r10.b;
        if (r1 == 0) goto L_0x0016;
    L_0x0008:
        r1 = r10.e;
        if (r1 != 0) goto L_0x0016;
    L_0x000c:
        r1 = "TXCVideoDecoder";
        r2 = "play:decode: start decoder error when not setup surface";
        com.tencent.liteav.basic.log.TXCLog.i(r1, r2);
    L_0x0015:
        return r0;
    L_0x0016:
        monitor-enter(r10);
        r1 = r10.m;	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x0029;
    L_0x001b:
        r1 = "TXCVideoDecoder";
        r2 = "play:decode: start decoder error when decoder is started";
        com.tencent.liteav.basic.log.TXCLog.e(r1, r2);	 Catch:{ all -> 0x0026 }
        monitor-exit(r10);	 Catch:{ all -> 0x0026 }
        goto L_0x0015;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = 0;
        r10.g = r0;	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r10.k = r0;	 Catch:{ all -> 0x0026 }
        r1 = new android.os.HandlerThread;	 Catch:{ all -> 0x0026 }
        r0 = "VDecoder";
        r1.<init>(r0);	 Catch:{ all -> 0x0026 }
        r1.start();	 Catch:{ all -> 0x0026 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0026 }
        r2 = "VDecoder";
        r0.<init>(r2);	 Catch:{ all -> 0x0026 }
        r2 = r1.getId();	 Catch:{ all -> 0x0026 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0026 }
        r0 = r0.toString();	 Catch:{ all -> 0x0026 }
        r1.setName(r0);	 Catch:{ all -> 0x0026 }
        r0 = new com.tencent.liteav.videodecoder.b$a;	 Catch:{ all -> 0x0026 }
        r1 = r1.getLooper();	 Catch:{ all -> 0x0026 }
        r0.<init>(r1);	 Catch:{ all -> 0x0026 }
        r1 = r10.c;	 Catch:{ all -> 0x0026 }
        r2 = r10.b;	 Catch:{ all -> 0x0026 }
        r3 = r10.e;	 Catch:{ all -> 0x0026 }
        r4 = r10.h;	 Catch:{ all -> 0x0026 }
        r5 = r10.i;	 Catch:{ all -> 0x0026 }
        r6 = r10;
        r7 = r10;
        r0.a(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0026 }
        r1 = "TXCVideoDecoder";
        r2 = "play:decode: start decode thread";
        com.tencent.liteav.basic.log.TXCLog.w(r1, r2);	 Catch:{ all -> 0x0026 }
        r1 = android.os.Message.obtain();	 Catch:{ all -> 0x0026 }
        r2 = 100;
        r1.what = r2;	 Catch:{ all -> 0x0026 }
        r2 = r10.a;	 Catch:{ all -> 0x0026 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x0026 }
        r1.obj = r2;	 Catch:{ all -> 0x0026 }
        r0.sendMessage(r1);	 Catch:{ all -> 0x0026 }
        r10.m = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r10);	 Catch:{ all -> 0x0026 }
        r1 = new android.os.Bundle;
        r1.<init>();
        r0 = "EVT_ID";
        r1.putInt(r0, r9);
        r0 = "EVT_TIME";
        r2 = com.tencent.liteav.basic.util.TXCTimeUtil.getTimeTick();
        r1.putLong(r0, r2);
        r2 = "EVT_MSG";
        r0 = r10.b;
        if (r0 == 0) goto L_0x00bf;
    L_0x00a4:
        r0 = "启动硬解";
    L_0x00a7:
        r1.putCharSequence(r2, r0);
        r2 = "EVT_PARAM1";
        r0 = r10.b;
        if (r0 == 0) goto L_0x00c3;
    L_0x00b1:
        r0 = 1;
    L_0x00b2:
        r1.putInt(r2, r0);
        r0 = r10.n;
        r2 = r10.j;
        com.tencent.liteav.basic.util.a.a(r0, r2, r9, r1);
        r0 = r8;
        goto L_0x0015;
    L_0x00bf:
        r0 = "启动软解";
        goto L_0x00a7;
    L_0x00c3:
        r0 = 2;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.b.b():int");
    }

    public void c() {
        synchronized (this) {
            if (this.m != null) {
                this.m.sendEmptyMessage(102);
            }
            this.m = null;
        }
        this.l.clear();
        this.d = false;
        this.g = 0;
    }

    public void b(boolean z) {
        int i = 1;
        synchronized (this) {
            this.b = z;
            this.l.clear();
            this.d = false;
            this.g = 0;
            Message obtain = Message.obtain();
            obtain.what = 103;
            obtain.arg1 = this.b ? 1 : 0;
            if (!this.a) {
                i = 0;
            }
            obtain.arg2 = i;
            if (this.m != null) {
                this.m.sendMessage(obtain);
            }
        }
    }

    public void a(byte[] bArr, long j, int i) {
        a aVar = this.m;
        if (aVar != null && !aVar.d && aVar.a != null) {
            ((TXCVideoFfmpegDecoder) aVar.a).loadNativeData(bArr, j, i);
        }
    }

    public int d() {
        return this.g + this.l.size();
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        if (this.f != null) {
            this.f.a(surfaceTexture, i, i2, j, j2);
        }
        if (this.g > 0) {
            this.g--;
        }
    }

    public void a(long j, int i, int i2, long j2, long j3) {
        if (this.f != null) {
            this.f.a(j, i, i2, j2, j3);
        }
        if (this.g > 0) {
            this.g--;
        }
    }

    public void a(int i, int i2) {
        if (this.f != null) {
            this.f.a(i, i2);
        }
    }

    public boolean e() {
        a aVar = this.m;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }
}
