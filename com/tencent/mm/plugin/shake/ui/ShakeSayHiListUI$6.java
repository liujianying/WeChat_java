package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.az.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class ShakeSayHiListUI$6 implements f {
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$6(ShakeSayHiListUI shakeSayHiListUI) {
        this.nbq = shakeSayHiListUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.SayHiListUI", "onItemDel object null");
            return;
        }
        d.SH().YP(obj.toString());
        ShakeSayHiListUI.b(this.nbq).a(null, null);
    }
}
