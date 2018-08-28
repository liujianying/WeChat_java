package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

class WXBizEntryActivity$1 implements a {
    final /* synthetic */ WXBizEntryActivity hdL;

    WXBizEntryActivity$1(WXBizEntryActivity wXBizEntryActivity) {
        this.hdL = wXBizEntryActivity;
    }

    public final void dG(boolean z) {
        if (z) {
            d.c(this.hdL, "game", ".ui.CreateOrJoinChatroomUI", this.hdL.getIntent());
        } else {
            x.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
        }
        this.hdL.finish();
    }
}
