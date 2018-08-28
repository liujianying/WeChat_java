package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class CollectBillUI$1 implements e {
    final /* synthetic */ CollectBillUI hXA;

    CollectBillUI$1(CollectBillUI collectBillUI) {
        this.hXA = collectBillUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof j) {
            j jVar = (j) lVar;
            if (i == 0 && i2 == 0) {
                List<cq> list = jVar.hUj.rpH;
                if (list == null || list.isEmpty()) {
                    CollectBillUI.a(this.hXA).setVisibility(8);
                    return;
                }
                for (cq cqVar : list) {
                    if (cqVar.type == 1 && !bi.oW(cqVar.bSc)) {
                        x.i("MicroMsg.CollectBillUI", "show notice");
                        CollectBillUI.a(this.hXA).setText(cqVar.bSc);
                        CollectBillUI.a(this.hXA).setOnClickListener(new 1(this, cqVar));
                        CollectBillUI.a(this.hXA).setVisibility(0);
                        return;
                    }
                }
                CollectBillUI.a(this.hXA).setVisibility(8);
                return;
            }
            x.e("MicroMsg.CollectBillUI", "net error: %s", new Object[]{jVar});
            CollectBillUI.a(this.hXA).setVisibility(8);
        }
    }
}
