package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashSet;
import java.util.List;

class RemittanceBusiUI$6 implements c {
    final /* synthetic */ RemittanceBusiUI mBt;
    final /* synthetic */ List mBu;
    final /* synthetic */ HashSet mBv;

    RemittanceBusiUI$6(RemittanceBusiUI remittanceBusiUI, List list, HashSet hashSet) {
        this.mBt = remittanceBusiUI;
        this.mBu = list;
        this.mBv = hashSet;
    }

    public final void a(l lVar) {
        int i = 0;
        RemittanceBusiUI.a(this.mBt, RemittanceBusiUI.m(this.mBt));
        if (!RemittanceBusiUI.z(this.mBt).brk() || RemittanceBusiUI.n(this.mBt) <= 0.0d) {
            for (xc xcVar : this.mBu) {
                lVar.a(i, xcVar.rCC, xcVar.rCE, null, true);
                this.mBv.add(Integer.valueOf(i));
                i++;
            }
            return;
        }
        for (xc xcVar2 : this.mBu) {
            if (xcVar2.rCK == 1) {
                lVar.a(i, xcVar2.rCC, xcVar2.rCE, null, true);
                this.mBv.add(Integer.valueOf(i));
            } else {
                lVar.a(i, xcVar2.rCC, xcVar2.rCE);
            }
            i++;
        }
    }
}
