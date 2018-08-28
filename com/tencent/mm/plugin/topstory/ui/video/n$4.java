package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class n$4 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$4(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        if (n.b(this.oBM).bHS().oCg) {
            n.b(this.oBM).bHU().b(n.e(this.oBM));
            if (n.b(this.oBM).bHS().bIB()) {
                n.b(this.oBM).bHS().bAf();
                n.f(this.oBM).bTv();
                n.f(this.oBM).bTy();
            } else {
                n.b(this.oBM).bHS().bGR();
                n.f(this.oBM).bTw();
                n.f(this.oBM).bTx();
            }
            this.oBM.bIm();
            return;
        }
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "no video play now");
    }
}
