package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$4 extends c<pw> {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$4(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
        this.sFo = pw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pw pwVar = (pw) bVar;
        x.i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", new Object[]{Integer.valueOf(this.nPH.hashCode()), pwVar.caC.bNH, OnlineVideoView.a(this.nPH), Integer.valueOf(pwVar.caC.bOh), Boolean.valueOf(OnlineVideoView.q(this.nPH))});
        if (pwVar.caC.bOh == 2) {
            OnlineVideoView.a(this.nPH, false);
            this.nPH.bCo();
            this.nPH.onDestroy();
        } else if (pwVar.caC.bOh == 1) {
            OnlineVideoView.o(this.nPH).post(new 1(this, pwVar));
        }
        return false;
    }
}
