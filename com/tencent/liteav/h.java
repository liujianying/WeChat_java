package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.i;

public class h extends a implements d, b, com.tencent.liteav.basic.c.a, i, com.tencent.liteav.videodecoder.d {
    private Context a = null;
    private g b = null;
    private com.tencent.liteav.videodecoder.b c = null;
    private com.tencent.liteav.renderer.h d = null;
    private com.tencent.liteav.basic.b.a e = null;
    private com.tencent.liteav.audio.b f = null;
    private com.tencent.liteav.basic.c.a g = null;
    private boolean h = false;
    private int i = 0;
    private long j = 0;
    private byte[] k = null;
    private n l = null;
    private int m;
    private boolean n = false;
    private String o;
    private final float p = com.tencent.liteav.basic.a.a.o;
    private final float q = com.tencent.liteav.basic.a.a.p;
    private final float r = com.tencent.liteav.basic.a.a.q;
    private final float s = 0.3f;
    private boolean t = false;
    private a u = null;

    public h(Context context, int i) {
        this.a = context;
        this.m = i;
        com.tencent.liteav.basic.e.b.a().a(this.a);
    }

    public void a(com.tencent.liteav.renderer.h hVar) {
        this.d = hVar;
        if (this.d != null && this.g != null) {
            this.d.a(this);
        }
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.g = aVar;
    }

    public void a(g gVar) {
        this.b = gVar;
        q();
    }

    public void setID(String str) {
        super.setID(str);
        if (this.d != null) {
            this.d.setID(getID());
        }
    }

    public void a(a aVar) {
        this.u = aVar;
    }

    public void a(boolean z) {
        this.h = z;
        this.n = true;
        if (this.d != null) {
            this.d.a(this);
            this.d.g();
            this.d.setID(getID());
        }
        this.c = new com.tencent.liteav.videodecoder.b();
        this.c.a(this.j);
        this.c.a(this);
        this.c.a(this);
        this.f = new com.tencent.liteav.audio.b();
        this.f.a(this);
        c(this.h);
        this.f.a(this.i);
        this.f.a(this.a);
        this.e = new com.tencent.liteav.basic.b.a();
        this.e.a((b) this);
        this.e.a();
        p();
        q();
    }

    public void a() {
        this.h = false;
        this.i = 0;
        if (this.c != null) {
            this.c.a(null);
            this.c.a(null);
            this.c.c();
        }
        if (this.f != null) {
            this.f.a(null);
            this.f.a();
        }
        if (this.e != null) {
            this.e.a(null);
            this.e.b();
        }
        if (this.d != null) {
            this.d.h();
            this.d.a(null);
        }
    }

    public void a(Surface surface) {
        if (this.c != null) {
            this.c.a(surface, null, null, !this.h);
            this.c.c();
            if (surface != null) {
                this.c.a(true);
                this.c.b();
            }
        }
    }

    public void a(com.tencent.liteav.basic.f.a aVar) {
        if (this.f != null) {
            this.f.a(aVar);
        } else {
            TXCLog.w("TXCRenderAndDec", "decAudio fail which audio play hasn't been created!");
        }
    }

    public void a(com.tencent.liteav.basic.f.b bVar) {
        try {
            if (this.e != null) {
                this.e.a(bVar);
            }
        } catch (Exception e) {
        }
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void b(int i) {
        if (this.d != null) {
            this.d.b(i);
        }
    }

    public void b(boolean z) {
        if (this.f != null) {
            this.f.d(z);
        }
    }

    public void c(int i) {
        this.i = i;
        if (this.f != null) {
            this.f.a(i);
        }
    }

    public static void a(Context context, int i) {
        com.tencent.liteav.audio.b.a(context, i);
    }

    public long b() {
        if (this.f != null) {
            return this.f.b();
        }
        return 0;
    }

    public long c() {
        if (this.e != null) {
            return this.e.d();
        }
        return 0;
    }

    public long d() {
        if (this.e != null) {
            return this.e.e();
        }
        return 0;
    }

    public int e() {
        if (this.c != null) {
            return this.c.d();
        }
        return 0;
    }

    public long f() {
        if (this.e == null || this.f == null) {
            return 0;
        }
        return this.f.c() - this.e.f();
    }

    public int g() {
        if (this.f != null) {
            return this.f.d();
        }
        return 0;
    }

    public long h() {
        if (this.f == null || this.e == null) {
            return 0;
        }
        return this.f.e() - this.e.g();
    }

    public float i() {
        if (this.f != null) {
            return this.f.f();
        }
        return 0.0f;
    }

    public int j() {
        if (this.e != null) {
            return this.e.h();
        }
        return 0;
    }

    public String k() {
        int g;
        if (this.f != null) {
            g = this.f.g();
        } else {
            g = TXEAudioDef.TXE_AEC_NONE;
        }
        return g + " | " + this.o;
    }

    public void l() {
        long j = 0;
        if (this.f != null) {
            TXAudioJitterBufferReportInfo h = this.f.h();
            if (h != null) {
                long j2 = h.mLoadCnt == 0 ? 0 : (long) (h.mLoadTime / h.mLoadCnt);
                long j3 = h.mTimeTotalCacheTimeCnt == 0 ? 0 : h.mTimeTotalCacheTime / h.mTimeTotalCacheTimeCnt;
                long j4 = (long) (h.mTimeTotalJittCnt == 0 ? 0 : h.mTimeTotalJitt / h.mTimeTotalJittCnt);
                setStatusValue(2001, Long.valueOf(j2));
                setStatusValue(2002, Long.valueOf((long) h.mLoadCnt));
                setStatusValue(2003, Long.valueOf((long) h.mLoadMaxTime));
                setStatusValue(2004, Long.valueOf((long) h.mSpeedCnt));
                setStatusValue(2005, Long.valueOf((long) h.mNoDataCnt));
                setStatusValue(2007, Long.valueOf((long) h.mAvgCacheTime));
                setStatusValue(2008, Long.valueOf((long) h.mIsRealTime));
                setStatusValue(2010, Long.valueOf(j3));
                setStatusValue(2011, Long.valueOf(j4));
                setStatusValue(2014, Long.valueOf((long) h.mTimeDropCnt));
            }
        }
        if (this.e != null) {
            setStatusValue(2006, Long.valueOf(d()));
            setStatusValue(6007, Long.valueOf(this.e.k()));
            setStatusValue(6008, Long.valueOf(this.e.j()));
            setStatusValue(6009, Long.valueOf(this.e.i()));
        }
        if (this.c != null) {
            if (this.c.a()) {
                j = 1;
            }
            setStatusValue(5002, Long.valueOf(j));
        }
    }

    public boolean a(byte[] bArr) {
        synchronized (this) {
            this.k = bArr;
        }
        return true;
    }

    public void a(n nVar) {
        synchronized (this) {
            this.l = nVar;
        }
    }

    private void c(SurfaceTexture surfaceTexture) {
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.h);
            if (surfaceTexture != null) {
                bVar.a(surfaceTexture, null, null, !this.h);
                bVar.b();
            }
        }
    }

    private void p() {
        c(this.d != null ? this.d.a() : null);
    }

    private void q() {
        c(this.h);
        if (this.f != null) {
            this.f.a(this.b.a);
            this.f.a(this.b.f);
            this.f.c(this.b.c);
            this.f.b(this.b.b);
            setStatusValue(2012, Long.valueOf((long) (this.b.c * 1000.0f)));
            setStatusValue(2013, Long.valueOf((long) (this.b.b * 1000.0f)));
            setStatusValue(2015, Long.valueOf(0));
        }
        if (this.e != null) {
            this.e.a(this.b.c);
        }
        if (this.c != null && this.c.a() && this.b.c < 0.3f && this.b.b < 0.3f) {
            this.b.h = false;
            this.c.c();
            p();
        }
    }

    private void c(boolean z) {
        if (z) {
            float f;
            float f2 = this.b.c;
            float f3 = this.b.b;
            if (f2 > this.q) {
                f2 = this.q;
            }
            if (f3 > this.r) {
                f3 = this.r;
            }
            if (f2 >= f3) {
                f = this.q;
                f3 = this.r;
            } else {
                f = f2;
            }
            this.b.f = true;
            this.b.a = f;
            this.b.c = f;
            this.b.b = f3;
            if (this.f != null) {
                this.f.a(true, this.a);
                this.f.c(true);
            }
        } else {
            TXCLog.e("TXCRenderAndDec", "setupRealTimePlayParams current cache time : min-cache[" + this.b.c + "], max-cache[" + this.b.b + "], org-cache[" + this.b.a + "]");
            if (this.f != null) {
                if (this.b == null || !this.b.g) {
                    this.f.a(false, this.a);
                } else {
                    this.f.a(true, this.a);
                }
                this.f.c(false);
            }
            if (this.b.a > this.b.b || this.b.a < this.b.c) {
                this.b.a = this.b.b;
            }
        }
        if (this.e != null) {
            this.e.b(z);
        }
    }

    private void a(int i, String str) {
        com.tencent.liteav.basic.c.a aVar = this.g;
        if (aVar != null) {
            Bundle bundle = new Bundle();
            new StringBuilder("TXCRenderAndDec notifyEvent: mUserID  ").append(this.j);
            bundle.putLong("EVT_USERID", this.j);
            bundle.putInt("EVT_ID", i);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (str != null) {
                bundle.putCharSequence("EVT_MSG", str);
            }
            aVar.onNotifyEvent(i, bundle);
        }
    }

    private void r() {
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null) {
            TXCLog.w("TXCRenderAndDec", "switch to soft decoder when hw error");
            bVar.c();
            this.b.h = false;
            c(this.h);
            p();
        }
    }

    public void m() {
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null && bVar.e()) {
            bVar.b(true);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (i == 2106) {
            r();
        } else if (i == 2003 && this.n) {
            a(2004, "视频播放开始");
            this.n = false;
        }
        com.tencent.liteav.basic.c.a aVar = this.g;
        if (aVar != null) {
            aVar.onNotifyEvent(i, bundle);
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        c(surfaceTexture);
    }

    public void b(SurfaceTexture surfaceTexture) {
        try {
            TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
            if (this.c != null) {
                this.c.c();
            }
            if (this.u != null) {
                this.u.a(surfaceTexture);
            }
        } catch (Exception e) {
        }
    }

    public long n() {
        try {
            if (this.f != null) {
                return this.f.c();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void b(com.tencent.liteav.basic.f.b bVar) {
        try {
            if (this.c != null) {
                this.c.a(bVar);
            } else if (this.e != null) {
                this.e.a(bVar.g);
            }
        } catch (Exception e) {
        }
    }

    public void c(com.tencent.liteav.basic.f.b bVar) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("EVT_GET_MSG", bVar.a);
        onNotifyEvent(2012, bundle);
    }

    public int o() {
        try {
            if (this.c != null) {
                return this.c.d();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        if (this.d != null) {
            this.d.a(surfaceTexture, i, i2);
            if (this.e != null) {
                this.e.a(j);
            }
        }
    }

    public void a(long j, int i, int i2, long j2, long j3) {
        Object obj = null;
        if (!(this.l == null || this.k == null)) {
            synchronized (this) {
                byte[] bArr = this.k;
                this.k = null;
                if (!(this.l == null || bArr == null || this.c == null)) {
                    if (bArr.length <= ((i * i2) * 3) / 2) {
                        this.c.a(bArr, j, bArr.length);
                        this.l.onVideoRawDataAvailable(bArr, i, i2, (int) j2);
                        obj = 1;
                    } else {
                        TXCLog.e("TXCRenderAndDec", "raw data buffer length is too large");
                    }
                }
            }
        }
        if (obj == null) {
            if (j > 0 && this.d != null) {
                this.d.a(j, i, i2);
            }
            if (this.e != null) {
                this.e.a(j2);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.d != null) {
            this.d.b(i, i2);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("EVT_MSG", "分辨率改变");
        bundle.putInt("EVT_PARAM1", i);
        bundle.putInt("EVT_PARAM2", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        onNotifyEvent(2009, bundle);
    }

    public void onPlayAudioInfoChanged(com.tencent.liteav.basic.f.a aVar, com.tencent.liteav.basic.f.a aVar2) {
        if (this.u != null) {
            this.u.a(aVar2);
        }
        if (aVar != null && aVar2 != null) {
            this.o = aVar.a + "," + aVar.b + " | " + aVar2.a + "," + aVar2.b;
        }
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        if (this.u != null) {
            this.u.a(bArr, j);
        }
    }

    public void onPlayError(int i, String str) {
    }

    public void onPlayJitterStateNotify(int i) {
        if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_LOADING) {
            if (this.e != null) {
                this.e.a(true);
            }
            a(2007, "视频缓冲中...");
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_PLAYING) {
            if (this.e != null) {
                this.e.a(false);
            }
            a(2004, "视频播放开始");
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_PLAY) {
            if (this.e != null) {
                this.e.a(false);
            }
            if (this.n) {
                a(2004, "视频播放开始");
                this.n = false;
            }
        }
    }
}
