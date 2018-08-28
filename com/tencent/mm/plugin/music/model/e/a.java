package com.tencent.mm.plugin.music.model.e;

import android.os.Looper;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.b.a.c;
import com.tencent.mm.plugin.music.b.a.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements c {
    public boolean bTH;
    private ar lwV;
    protected boolean lwW;
    protected com.tencent.mm.plugin.music.b.a.c.a lwX;
    public String lzq = "";

    protected final void bir() {
        this.lwV = new ar();
        this.lwV.fN(ad.getContext());
        this.lwV.a(new com.tencent.mm.sdk.platformtools.ar.a() {
            public final void fn(int i) {
                switch (i) {
                    case 0:
                        if (a.this.lwW) {
                            a.this.lwW = false;
                            a.this.resume();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        if (a.this.PY()) {
                            a.this.lwW = true;
                            a.this.pause();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final void bis() {
        if (this.lwV != null) {
            this.lwV.end();
            this.lwV.ciy();
        }
    }

    public final void m(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPreparintEvent %b", new Object[]{Boolean.valueOf(PY())});
        this.lzq = "waiting";
        jt jtVar = new jt();
        jtVar.bTE.action = 11;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "waiting";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
    }

    public final void n(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[]{Boolean.valueOf(PY())});
        this.lzq = "canplay";
        jt jtVar = new jt();
        jtVar.bTE.action = 9;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "canplay";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
    }

    public final void o(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[]{Boolean.valueOf(PY())});
        this.lzq = "play";
        jt jtVar = new jt();
        jtVar.bTE.action = 0;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "play";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
        f.bhZ();
        f.dGw = System.currentTimeMillis();
        f.e(h.bic().bhR());
    }

    public final void p(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
        this.lzq = "play";
        jt jtVar = new jt();
        jtVar.bTE.action = 1;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "play";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
        f.dGw = System.currentTimeMillis();
    }

    public final void q(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
        this.lzq = "pause";
        jt jtVar = new jt();
        jtVar.bTE.action = 3;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "pause";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
        f.yL();
    }

    public final void r(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.lzq = "stop";
        jt jtVar = new jt();
        jtVar.bTE.action = 2;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "stop";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.g.a.jt.a aVar = jtVar.bTE;
        boolean z = this.bTH;
        this.bTH = false;
        aVar.bTH = z;
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
        f.bhZ();
    }

    public final void s(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
        this.lzq = "seeked";
        jt jtVar = new jt();
        jtVar.bTE.action = 8;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "seeked";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
    }

    public final void t(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
        this.lzq = "seeking";
        jt jtVar = new jt();
        jtVar.bTE.action = 12;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "seeking";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
    }

    public final void u(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.lzq = "ended";
        jt jtVar = new jt();
        jtVar.bTE.action = 7;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "ended";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
        f.bhZ();
        if (h.bic().mode == 2) {
            h.bic().bhU();
        }
    }

    public final void a(avq avq, int i) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[]{Integer.valueOf(i)});
        this.lzq = "error";
        jt jtVar = new jt();
        jtVar.bTE.action = 4;
        jtVar.bTE.bTy = avq;
        jtVar.bTE.state = "error";
        jtVar.bTE.duration = (long) getDuration();
        jtVar.bTE.bTG = bhp();
        jtVar.bTE.errCode = d.tL(i);
        jtVar.bTE.Yy = d.tM(i);
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
        f.bhZ();
    }

    public final void v(avq avq) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        a(avq, -1);
    }

    public final void a(com.tencent.mm.plugin.music.b.a.c.a aVar) {
        this.lwX = aVar;
    }
}
