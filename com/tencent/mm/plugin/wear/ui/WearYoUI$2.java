package com.tencent.mm.plugin.wear.ui;

import com.tencent.mm.g.a.ts;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WearYoUI$2 extends c<ts> {
    final /* synthetic */ WearYoUI pKt;

    WearYoUI$2(WearYoUI wearYoUI) {
        this.pKt = wearYoUI;
        this.sFo = ts.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ts tsVar = (ts) bVar;
        if (tsVar instanceof ts) {
            switch (tsVar.cfs.bIH) {
                case 1:
                    if (!WearYoUI.a(this.pKt).equals(tsVar.cfs.username)) {
                        tsVar.cft.cfu = 2;
                        break;
                    }
                    tsVar.cft.cfu = 1;
                    break;
                case 2:
                    if (WearYoUI.a(this.pKt).equals(tsVar.cfs.username)) {
                        WearYoUI.b(this.pKt);
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
