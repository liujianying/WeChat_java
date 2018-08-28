package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;

class h$4 implements OnClickListener {
    final /* synthetic */ c nMg;
    final /* synthetic */ int nUZ;
    final /* synthetic */ av okj;
    final /* synthetic */ h okk;

    h$4(h hVar, av avVar, int i, c cVar) {
        this.okk = hVar;
        this.okj = avVar;
        this.nUZ = i;
        this.nMg = cVar;
    }

    public final void onClick(View view) {
        this.okj.ntw.olb.onClick(view);
        if (this.nUZ > 0) {
            this.okj.obV.nLJ.eA(this.nMg.oiF);
        }
    }
}
