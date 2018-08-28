package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.g;
import com.tencent.mm.ab.g.a;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.ab.h;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class n implements a, b, SensorController.a {
    static SensorController hlW;
    private int bOS;
    private List<a> cWy = new LinkedList();
    private boolean hlZ = true;
    az hma;
    long hmb = -1;
    private boolean hmc;
    private boolean hmg = false;
    private g iWF = ((h) com.tencent.mm.kernel.g.l(h.class)).vm();
    boolean iWG;
    private int iWH;
    public String path;

    public n() {
        Boolean bool = (Boolean) com.tencent.mm.kernel.g.Ei().DT().get(26, Boolean.valueOf(false));
        this.hmc = bool.booleanValue();
        this.hlZ = !bool.booleanValue();
        if (this.iWF != null) {
            this.iWF.a(this);
            this.iWF.a(this);
            this.iWF.aK(this.hlZ);
        } else {
            x.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (hlW == null) {
            hlW = new SensorController(ad.getContext());
        }
        if (this.hma == null) {
            this.hma = new az(ad.getContext());
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.cWy) {
            if (aVar == aVar2) {
                return;
            }
        }
        this.cWy.add(aVar);
    }

    public final void destroy() {
        pause();
        aux();
        hlW = null;
        this.cWy.clear();
    }

    public final void pause() {
        if (this.iWF == null) {
            x.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            return;
        }
        if (this.iWF.isPlaying()) {
            aLs();
        }
        for (a onPause : this.cWy) {
            onPause.onPause();
        }
    }

    public final boolean startPlay(String str, int i) {
        if (this.iWF == null) {
            x.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.iWF.stop();
        for (a aW : this.cWy) {
            aW.aW(str, 0);
        }
        if (!(hlW == null || hlW.sIY)) {
            hlW.a(this);
            if (this.hma.Q(new 1(this))) {
                this.hmb = 0;
            } else {
                this.hmb = -1;
            }
        }
        this.path = str;
        this.bOS = i;
        if (bi.oW(str) || !this.iWF.a(str, this.hlZ, true, i)) {
            return false;
        }
        af.Wp("keep_app_silent");
        return true;
    }

    public final boolean O(String str, int i, int i2) {
        if (this.iWF == null) {
            x.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.iWF.stop();
        for (a aW : this.cWy) {
            aW.aW(str, i2);
        }
        if (!(hlW == null || hlW.sIY)) {
            hlW.a(this);
            if (this.hma.Q(new 2(this))) {
                this.hmb = 0;
            } else {
                this.hmb = -1;
            }
        }
        this.path = str;
        this.bOS = i;
        if (bi.oW(str) || !this.iWF.a(str, this.hlZ, i, i2)) {
            return false;
        }
        af.Wp("keep_app_silent");
        f.yz().e(this.hlZ, false, false);
        return true;
    }

    public final boolean aLq() {
        if (this.iWF != null) {
            return this.iWF.isPlaying();
        }
        x.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
        return false;
    }

    public final boolean wc() {
        if (this.iWF != null) {
            return this.iWF.wc();
        }
        x.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
        return false;
    }

    public final double wb() {
        if (this.iWF != null) {
            return this.iWF.wb();
        }
        x.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
        return 0.0d;
    }

    public final boolean aLr() {
        x.i("MicroMsg.FavVoiceLogic", "resume play");
        af.Wp("keep_app_silent");
        if (this.iWF != null) {
            return this.iWF.vY();
        }
        x.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
        return false;
    }

    public final boolean aLs() {
        x.i("MicroMsg.FavVoiceLogic", "pause play");
        af.Wq("keep_app_silent");
        if (this.iWF != null) {
            return this.iWF.pause();
        }
        x.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
        return false;
    }

    public final void stopPlay() {
        x.d("MicroMsg.FavVoiceLogic", "stop play");
        af.Wq("keep_app_silent");
        if (this.iWF != null) {
            this.iWF.stop();
        }
        aux();
    }

    public final void onError() {
        x.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        stopPlay();
        for (a onFinish : this.cWy) {
            onFinish.onFinish();
        }
    }

    public final void wd() {
        x.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        stopPlay();
        for (a onFinish : this.cWy) {
            onFinish.onFinish();
        }
    }

    private void aux() {
        if (hlW != null) {
            hlW.ciL();
        }
        if (this.hma != null) {
            this.hma.ciM();
        }
    }

    public final void dK(boolean z) {
        boolean z2 = true;
        if (!bi.oW(this.path)) {
            if (this.hmg) {
                if (z) {
                    z2 = false;
                }
                this.hmg = z2;
            } else if (z || this.hmb == -1 || bi.bI(this.hmb) <= 400) {
                this.hmg = false;
                if (this.iWF != null && this.iWF.vZ()) {
                    return;
                }
                if (this.hmc) {
                    if (this.iWF != null) {
                        this.iWF.aK(false);
                    }
                    f.yz().e(false, false, false);
                    this.hlZ = false;
                } else if (this.iWF == null || this.iWF.isPlaying() || this.iWG) {
                    if (this.iWF != null) {
                        this.iWF.aK(z);
                    }
                    this.hlZ = z;
                    if (this.iWG && !z) {
                        O(this.path, this.bOS, this.iWH);
                    } else if (!z) {
                        startPlay(this.path, this.bOS);
                    }
                } else {
                    this.iWF.aK(true);
                    this.hlZ = true;
                }
            } else {
                this.hmg = true;
            }
        }
    }
}
