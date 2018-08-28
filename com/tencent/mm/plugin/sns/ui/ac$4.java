package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.an.b;
import com.tencent.mm.plugin.sns.ui.ac.3;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ac$4 implements OnClickListener {
    final /* synthetic */ ac nOP;

    ac$4(ac acVar) {
        this.nOP = acVar;
    }

    public final void onClick(View view) {
        if (b.PY()) {
            this.nOP.bCk();
            return;
        }
        ac acVar = this.nOP;
        if (acVar.nOa == null) {
            x.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
        } else {
            new ag(acVar.bGc.getMainLooper()).post(new 3(acVar));
        }
    }
}
