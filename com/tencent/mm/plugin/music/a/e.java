package com.tencent.mm.plugin.music.a;

import android.os.Looper;
import com.tencent.mm.an.d;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.music.b.a.c;
import com.tencent.mm.plugin.music.b.a.c.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;

public abstract class e implements c {
    protected c lwR = null;
    ar lwV;
    protected boolean lwW;
    protected a lwX;

    public abstract String bhr();

    public abstract String getAppId();

    public final void bhn() {
    }

    public final boolean bho() {
        return false;
    }

    public boolean bhp() {
        return false;
    }

    public final d bhq() {
        return null;
    }

    public final void bhs() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
        t tVar = new t();
        tVar.bHb.action = 7;
        tVar.bHb.state = "canplay";
        tVar.bHb.duration = (long) getDuration();
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
    }

    public final void bht() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[]{Boolean.valueOf(PY())});
        t tVar = new t();
        tVar.bHb.action = 0;
        tVar.bHb.state = "play";
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        if (this.lwR != null) {
            this.lwR.onStart(bhr());
        }
    }

    public final void bhu() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
        t tVar = new t();
        tVar.bHb.action = 1;
        tVar.bHb.state = "play";
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        if (this.lwR != null) {
            this.lwR.onStart(bhr());
        }
    }

    public final void bhv() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
        t tVar = new t();
        tVar.bHb.action = 2;
        tVar.bHb.state = "pause";
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        if (this.lwR != null) {
            this.lwR.HT(bhr());
        }
    }

    public final void bhw() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        t tVar = new t();
        tVar.bHb.action = 3;
        tVar.bHb.state = "stop";
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        if (this.lwR != null) {
            this.lwR.AW(bhr());
        }
    }

    public final void bhx() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
        t tVar = new t();
        tVar.bHb.action = 6;
        tVar.bHb.state = "seeked";
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
    }

    public final void bhy() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        t tVar = new t();
        tVar.bHb.action = 5;
        tVar.bHb.state = "ended";
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        if (this.lwR != null) {
            this.lwR.HU(bhr());
        }
    }

    public final void tp(int i) {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[]{Integer.valueOf(i)});
        t tVar = new t();
        tVar.bHb.action = 4;
        tVar.bHb.state = "error";
        tVar.bHb.errCode = com.tencent.mm.plugin.music.b.a.d.tL(i);
        tVar.bHb.Yy = com.tencent.mm.plugin.music.b.a.d.tM(i);
        tVar.bHb.bGW = bhr();
        tVar.bHb.appId = getAppId();
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        if (this.lwR != null) {
            this.lwR.onError(bhr());
        }
    }

    public final void bhz() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
        tp(-1);
    }

    public final void a(a aVar) {
        this.lwX = aVar;
    }

    public final void a(c cVar) {
        this.lwR = cVar;
    }
}
