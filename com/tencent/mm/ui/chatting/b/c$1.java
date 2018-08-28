package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ac.m$a$a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements m$a$a {
    final /* synthetic */ c tOm;

    c$1(c cVar) {
        this.tOm = cVar;
    }

    public final void kX(String str) {
        if (str == null) {
            x.i("MicroMsg.ChattingUI.BizComponent", "brand is null");
            return;
        }
        x.i("MicroMsg.ChattingUI.BizComponent", "BrandLogic.BrandIconService.BrandIconUpdateListener onUpdate");
        this.tOm.bAG.avj();
    }
}
