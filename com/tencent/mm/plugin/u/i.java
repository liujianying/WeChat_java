package com.tencent.mm.plugin.u;

import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    private a ldA;
    Looper ldt;
    ag ldu;
    HandlerThread ldv;
    HandlerThread ldw;
    HandlerThread ldx;
    public j ldy;
    public c ldz;

    public i(Looper looper) {
        this(looper, (byte) 0);
    }

    private i(Looper looper, byte b) {
        this.ldA = new 1(this);
        this.ldv = e.cZ("VideoPlayer:inner", -16);
        this.ldv.start();
        this.ldw = e.cZ("VideoPlayer:video", -16);
        this.ldw.start();
        this.ldx = e.cZ("VideoPlayer:audio", -16);
        this.ldx.start();
        this.ldt = looper;
        this.ldu = new ag(this.ldt, this.ldA);
        this.ldy = new j(this.ldu, this.ldv.getLooper(), this.ldw.getLooper(), this.ldx != null ? this.ldx.getLooper() : null);
    }

    public final void setPath(String str) {
        x.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[]{avA(), str});
        j jVar = this.ldy;
        x.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[]{jVar.ldg.avA(), str});
        jVar.ldH.setPath(str);
        if (jVar.ldJ != null) {
            jVar.ldJ.setPath(str);
        }
    }

    public final void setIOnlineCache(b bVar) {
        if (bVar != null && this.ldy != null) {
            this.ldy.ldH.ldj = bVar;
        }
    }

    public final void gr(boolean z) {
        this.ldy.ldH.ldQ = z;
    }

    public final void setNeedResetExtractor(boolean z) {
        if (this.ldy != null) {
            j jVar = this.ldy;
            if (jVar.ldg != null) {
                jVar.ldg.ldb = z;
            }
        }
    }

    public final void setIsOnlineVideoType(boolean z) {
        if (this.ldy != null) {
            j jVar = this.ldy;
            if (jVar.ldg != null) {
                x.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[]{jVar.ldg.avA(), Boolean.valueOf(z)});
                jVar.ldg.ldc = z;
            }
        }
    }

    public final void setSurface(Surface surface) {
        if (surface != null) {
            x.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[]{this.ldy.ldg.avA(), Integer.valueOf(surface.hashCode())});
            r0.ldH.aeJ = surface;
        }
    }

    public final boolean bdz() {
        j jVar = this.ldy;
        x.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[]{jVar.ldg.avA()});
        jVar.ldC.obtainMessage(1).sendToTarget();
        if (jVar.ldJ != null) {
            jVar.ldD.obtainMessage(1).sendToTarget();
        }
        return true;
    }

    public final void start() {
        x.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[]{avA(), Integer.valueOf(this.ldy.state), bi.cjd()});
        if (d.sC(this.ldy.state) || d.sA(this.ldy.state)) {
            x.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[]{avA()});
            return;
        }
        this.ldy.start();
    }

    public final void pause() {
        x.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[]{avA(), Integer.valueOf(this.ldy.state), bi.cjd()});
        if (d.sC(this.ldy.state) || d.sA(this.ldy.state)) {
            x.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[]{avA()});
            return;
        }
        this.ldy.pause();
    }

    public final void sG(int i) {
        this.ldy.sG(i);
    }

    public final void setMute(boolean z) {
        try {
            if (this.ldy != null) {
                j jVar = this.ldy;
                if (jVar.ldJ != null) {
                    x.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[]{jVar.ldg.avA(), Boolean.valueOf(z)});
                    jVar.ldJ.setMute(z);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void release() {
        try {
            this.ldy.release();
        } catch (Exception e) {
        }
    }

    public final int bdA() {
        j jVar = this.ldy;
        if (jVar.ldg == null) {
            return 0;
        }
        int i = (int) (jVar.ldg.lcW / 1000);
        int i2 = (int) jVar.ldg.lcV;
        if (i2 != -1) {
            i = i2;
        }
        if (((long) i) < jVar.ldg.lcX / 1000) {
            i = (int) (jVar.ldg.lcX / 1000);
        }
        x.d("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[]{jVar.ldg.avA(), Integer.valueOf(i), Long.valueOf(jVar.ldg.lcW), Long.valueOf(jVar.ldg.lcX)});
        return i;
    }

    public final boolean isPlaying() {
        return d.sz(this.ldy.state);
    }

    public final String avA() {
        return this.ldy != null ? this.ldy.ldg.avA() : "has no player!";
    }
}
