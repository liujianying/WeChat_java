package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.mm.ab.g;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.ab.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.ab.g.a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    public static volatile a qwc = null;
    private int bOS;
    public List<a> cWy = new LinkedList();
    public SensorController hlW;
    private boolean hlZ = true;
    public az hma;
    private long hmb = -1;
    private boolean hmc;
    private boolean hmg = false;
    private g iWF = ((h) com.tencent.mm.kernel.g.l(h.class)).vm();
    String path;

    private a() {
        au.HU();
        Boolean bool = (Boolean) c.DT().get(26, Boolean.valueOf(false));
        this.hmc = bool.booleanValue();
        this.hlZ = !bool.booleanValue();
        if (this.iWF != null) {
            this.iWF.a(this);
            this.iWF.a(this);
            this.iWF.aK(this.hlZ);
        } else {
            x.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (this.hlW == null) {
            this.hlW = new SensorController(ad.getContext());
        }
        if (this.hma == null) {
            this.hma = new az(ad.getContext());
        }
    }

    public static a cbb() {
        if (qwc == null) {
            synchronized (a.class) {
                if (qwc == null) {
                    qwc = new a();
                }
            }
        }
        return qwc;
    }

    public final boolean startPlay(String str, int i) {
        if (this.iWF == null) {
            x.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.iWF.stop();
        if (!(this.hlW == null || this.hlW.sIY)) {
            this.hlW.a(this);
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
        for (a aVar : this.cWy) {
            if (aVar != null) {
                aVar.Sw(str);
            }
        }
        return true;
    }

    public final void stopPlay() {
        x.i("MicroMsg.RecordVoiceHelper", "stop play");
        af.Wq("keep_app_silent");
        if (this.iWF != null) {
            this.iWF.stop();
            for (a aVar : this.cWy) {
                if (aVar != null) {
                    aVar.cba();
                }
            }
        }
        if (this.hlW != null) {
            this.hlW.ciL();
        }
        if (this.hma != null) {
            this.hma.ciM();
        }
    }

    public final boolean aLq() {
        if (this.iWF != null) {
            return this.iWF.isPlaying();
        }
        x.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void onError() {
        x.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
    }

    public final void wd() {
        x.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
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
                    this.hlZ = false;
                } else if (this.iWF == null || this.iWF.isPlaying()) {
                    if (this.iWF != null) {
                        this.iWF.aK(z);
                    }
                    this.hlZ = z;
                    if (!z) {
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
