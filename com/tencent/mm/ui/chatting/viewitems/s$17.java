package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c$a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;
import java.util.Map;

class s$17 implements c$a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ Map qiX;
    final /* synthetic */ s ucn;
    final /* synthetic */ az ucz;

    s$17(s sVar, Map map, bd bdVar, az azVar) {
        this.ucn = sVar;
        this.qiX = map;
        this.dAs = bdVar;
        this.ucz = azVar;
    }

    public final void b(WxaAttributes wxaAttributes) {
        if (wxaAttributes != null) {
            s.b(this.ucn, wxaAttributes.field_appId);
            ah.A(new 1(this, (wxaAttributes.field_appOpt & 1) > 0));
        }
    }
}
