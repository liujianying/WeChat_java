package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public boolean bTv = false;
    public b kpV = null;
    public final Object kpW = new Object();
    public int kpX = 0;
    public boolean kpY = false;

    public final void fT(boolean z) {
        x.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(this.kpY), Boolean.valueOf(z)});
        au.HV().aY(z);
        com.tencent.mm.plugin.ipcall.a.c.a aXq = i.aXq();
        if ((z ? aXq.kqx.tf(401) : aXq.kqx.tf(402)) < 0) {
            x.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[]{Integer.valueOf(z ? aXq.kqx.tf(401) : aXq.kqx.tf(402))});
        }
        if (z != this.kpY) {
            this.kpY = z;
            if (this.kpV != null && this.kpV.oGX) {
                this.kpV.iJ(z);
            }
        }
    }

    public static boolean yJ() {
        return au.HV().daT.isSpeakerphoneOn();
    }
}
