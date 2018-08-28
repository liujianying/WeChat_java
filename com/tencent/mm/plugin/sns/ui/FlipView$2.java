package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class FlipView$2 implements c {
    final /* synthetic */ List iYC;
    final /* synthetic */ FlipView nNe;
    final /* synthetic */ List nNf;

    FlipView$2(FlipView flipView, List list, List list2) {
        this.nNe = flipView;
        this.iYC = list;
        this.nNf = list2;
    }

    public final void a(l lVar) {
        lVar.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iYC.size()) {
                lVar.e(((Integer) this.nNf.get(i2)).intValue(), (CharSequence) this.iYC.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
