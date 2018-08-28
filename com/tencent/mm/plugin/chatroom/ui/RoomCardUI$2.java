package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.g.a.ll;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;

class RoomCardUI$2 extends c<ll> {
    final /* synthetic */ RoomCardUI hNw;

    RoomCardUI$2(RoomCardUI roomCardUI) {
        this.hNw = roomCardUI;
        this.sFo = ll.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ll llVar = (ll) bVar;
        String str = llVar.bVN.bVO;
        String str2 = llVar.bVN.bVP;
        int i = llVar.bVN.ret;
        if (i != 0 && str2 != null) {
            h.b(this.hNw, str2, str, true);
            if (RoomCardUI.g(this.hNw) != null) {
                au.HU();
                com.tencent.mm.model.c.FQ().c(RoomCardUI.g(this.hNw));
            }
        } else if (i == 0) {
            if (RoomCardUI.h(this.hNw)) {
                RoomCardUI.a(this.hNw, RoomCardUI.b(this.hNw).getText().toString());
            } else {
                RoomCardUI.i(this.hNw);
            }
        }
        if (!(RoomCardUI.h(this.hNw) || RoomCardUI.j(this.hNw) == null || !RoomCardUI.j(this.hNw).isShowing())) {
            RoomCardUI.j(this.hNw).dismiss();
        }
        return false;
    }
}
