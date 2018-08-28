package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class t$1 implements c {
    final /* synthetic */ List nNJ;
    final /* synthetic */ List nNK;
    final /* synthetic */ t nNL;

    t$1(t tVar, List list, List list2) {
        this.nNL = tVar;
        this.nNJ = list;
        this.nNK = list2;
    }

    public final void a(l lVar) {
        lVar.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nNJ.size()) {
                lVar.e(((Integer) this.nNK.get(i2)).intValue(), (CharSequence) this.nNJ.get(i2));
                i = i2 + 1;
            } else {
                lVar.e(-1, this.nNL.context.getString(j.sns_del_sns));
                return;
            }
        }
    }
}
