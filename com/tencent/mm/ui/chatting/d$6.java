package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class d$6 implements a {
    final /* synthetic */ d tHt;
    final /* synthetic */ boolean tHv;

    d$6(d dVar, boolean z) {
        this.tHt = dVar;
        this.tHv = z;
    }

    public final boolean vD() {
        if (this.tHv) {
            x.i("MicroMsg.AutoPlay", "speaker true");
            this.tHt.csR();
            if (this.tHt.context != null) {
                this.tHt.tHi = s.a(this.tHt.bAG.tTq.getActivity(), this.tHt.context.getString(R.l.fmt_route_speaker), 2000);
            }
            this.tHt.hlZ = true;
            this.tHt.csP();
        } else {
            x.i("MicroMsg.AutoPlay", "speaker off");
            this.tHt.hlZ = false;
            d dVar = this.tHt;
            if (dVar.iWF.isPlaying()) {
                x.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                dVar.bhU();
            }
        }
        return false;
    }
}
