package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.b.c.2;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class b implements a, d.a, HeadsetPlugReceiver.a {
    public MMActivity bGc;
    public com.tencent.mm.compatible.util.b epT = new com.tencent.mm.compatible.util.b(ad.getContext());
    public a kqb = new a();
    public c kqc = new c();
    public d kqd = new d();
    public HeadsetPlugReceiver kqe = new HeadsetPlugReceiver();
    public j kqf;
    private boolean kqg = false;
    public a kqh;
    public boolean kqi = false;
    public boolean kqj = false;
    public long kqk = 0;

    public final void a(j jVar) {
        this.kqf = jVar;
        if (jVar != null) {
            i.aXu().aWS();
        }
    }

    public final void aiN() {
        c cVar = this.kqc;
        if (cVar.bTv) {
            x.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            return;
        }
        x.i("MicroMsg.IPCallRecorder", "start record");
        cVar.bTv = true;
        cVar.kqn = i.aXs().kqb.kpX;
        if (cVar.kqn <= 10) {
            if (cVar.kqn <= 0) {
                x.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.aXr().aXP();
            }
            cVar.kqn = 92;
        }
        synchronized (cVar.kqm) {
            e.post(new 2(cVar), "IPCallRecorder_startRecord");
        }
    }

    public final void fT(boolean z) {
        this.kqb.fT(z);
    }

    public final void fU(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[]{Boolean.valueOf(z)});
        if (this.bGc != null) {
            MMActivity mMActivity = this.bGc;
            if (z) {
                z2 = false;
            }
            mMActivity.setScreenEnable(z2);
        }
        if (!i.aXt().aXk()) {
            return;
        }
        if (z) {
            this.kqg = a.yJ();
            this.kqb.fT(false);
            return;
        }
        this.kqb.fT(this.kqg);
    }

    public final void ew(int i) {
        x.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.kqi = true;
                if (this.kqh != null && !this.kqj) {
                    this.kqh.fX(true);
                    return;
                }
                return;
            case 2:
            case 4:
                this.kqi = false;
                if (this.kqh != null && !this.kqj) {
                    this.kqh.fX(false);
                    return;
                }
                return;
            case 3:
                au.HV().yB();
                if (au.HV().yE() && this.kqh != null) {
                    this.kqh.fW(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void fV(boolean z) {
        x.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", new Object[]{Boolean.valueOf(z)});
        if (this.kqh != null && z != this.kqj) {
            this.kqj = z;
            if (!this.kqi) {
                this.kqh.fW(z);
            }
        }
    }

    public final int aXI() {
        a aVar = this.kqb;
        return (aVar.kpV == null || !aVar.bTv) ? -1 : aVar.kpV.bJx();
    }
}
