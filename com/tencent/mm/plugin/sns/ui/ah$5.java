package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class ah$5 implements c {
    final /* synthetic */ ah nQf;

    ah$5(ah ahVar) {
        this.nQf = ahVar;
    }

    public final void a(l lVar) {
        if (!af.eyg) {
            lVar.e(0, this.nQf.bGc.getString(j.app_field_mmsight));
        }
        lVar.e(1, this.nQf.bGc.getString(j.app_field_select_new_pic));
    }
}
