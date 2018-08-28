package com.tencent.mm.plugin.voip.model;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver$a;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.sdk.platformtools.x;

class o$12 implements HeadsetPlugReceiver$a {
    final /* synthetic */ o oMC;

    o$12(o oVar) {
        this.oMC = oVar;
    }

    public final void fV(boolean z) {
        x.d("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b", new Object[]{Boolean.valueOf(z)});
        if (!(true == z && 3 == o.f(this.oMC)) && (z || 3 == o.f(this.oMC))) {
            if (b.yV(o.a(this.oMC).mState)) {
                if (z) {
                    o.b(this.oMC, false);
                    o.a(this.oMC, 3);
                } else if (i.bJI().bKY()) {
                    Toast.makeText(o.g(this.oMC), o.g(this.oMC).getString(R.l.voip_voice_come_from_speaker), 0).show();
                    o.b(this.oMC, true);
                    o.a(this.oMC, 1);
                } else {
                    o.b(this.oMC, false);
                    o.a(this.oMC, 3);
                }
            } else if (z) {
                if (1 == o.f(this.oMC)) {
                    o.b(this.oMC, false);
                    o.c(this.oMC, true);
                } else {
                    o.c(this.oMC, false);
                }
                o.a(this.oMC, 3);
            } else if (i.bJI().bKY()) {
                if (o.h(this.oMC) || 2 == o.i(this.oMC)) {
                    Toast.makeText(o.g(this.oMC), o.g(this.oMC).getString(R.l.voip_voice_come_from_speaker), 0).show();
                    o.b(this.oMC, true);
                    o.a(this.oMC, 1);
                } else {
                    Toast.makeText(o.g(this.oMC), o.g(this.oMC).getString(R.l.voip_voice_come_from_earpiece), 0).show();
                    o.a(this.oMC, 2);
                }
                o.c(this.oMC, false);
            } else {
                o.b(this.oMC, false);
                o.a(this.oMC, 2);
            }
            o.b(this.oMC, o.f(this.oMC));
            return;
        }
        x.d("MicroMsg.Voip.VoipMgr", "same status, no changed");
    }
}
