package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class t$5 implements c {
    final /* synthetic */ List eRE;
    final /* synthetic */ t nNL;
    final /* synthetic */ List nNO;

    t$5(t tVar, List list, List list2) {
        this.nNL = tVar;
        this.eRE = list;
        this.nNO = list2;
    }

    public final void a(l lVar) {
        lVar.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eRE.size()) {
                lVar.e(((Integer) this.nNO.get(i2)).intValue(), (CharSequence) this.eRE.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
