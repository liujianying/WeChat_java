package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pw;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.4;
import com.tencent.mm.sdk.platformtools.bi;

class OnlineVideoView$4$1 implements Runnable {
    final /* synthetic */ pw nPJ;
    final /* synthetic */ 4 nPK;

    OnlineVideoView$4$1(4 4, pw pwVar) {
        this.nPK = 4;
        this.nPJ = pwVar;
    }

    public final void run() {
        if (!bi.fS(this.nPJ.caC.bNH, OnlineVideoView.a(this.nPK.nPH))) {
            OnlineVideoView.a(this.nPK.nPH, false);
            this.nPK.nPH.bCo();
            this.nPK.nPH.onDestroy();
        } else if (OnlineVideoView.q(this.nPK.nPH)) {
            this.nPK.nPH.requestLayout();
        } else {
            OnlineVideoView.a(this.nPK.nPH, true);
            this.nPK.nPH.onResume();
        }
    }
}
