package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c$a;
import com.tencent.mm.sdk.platformtools.ah;

class s$7 implements c$a {
    final /* synthetic */ s ucn;
    final /* synthetic */ String ucv;
    final /* synthetic */ az ucz;

    s$7(s sVar, az azVar, String str) {
        this.ucn = sVar;
        this.ucz = azVar;
        this.ucv = str;
    }

    public final void b(WxaAttributes wxaAttributes) {
        if (wxaAttributes != null) {
            ah.A(new 1(this, wxaAttributes.field_brandIconURL, wxaAttributes.field_nickname));
        }
    }
}
