package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.az.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class NearbySayHiListUI$9 implements f {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$9(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.SayHiListUI", "onItemDel object null");
            return;
        }
        d.SG().YP(obj.toString());
        NearbySayHiListUI.b(this.lCB).a(null, null);
    }
}
