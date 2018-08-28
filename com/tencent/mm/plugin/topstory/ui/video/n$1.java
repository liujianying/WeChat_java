package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.topstory.ui.video.n.c;
import com.tencent.mm.plugin.websearch.api.a.a;

class n$1 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$1(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        if (n.a(this.oBM) == c.oBU) {
            n.b(this.oBM).bHR().ozV = true;
        }
        if (n.b(this.oBM).bHR().isConnected()) {
            if (n.b(this.oBM).bHS().oCg) {
                n.b(this.oBM).bHS().bGR();
            } else {
                this.oBM.iB(true);
            }
            a.kB(19);
            return;
        }
        a.kB(20);
    }
}
