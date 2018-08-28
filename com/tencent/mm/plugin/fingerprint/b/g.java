package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.hw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;

public final class g extends c<hw> {
    public g() {
        this.sFo = hw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hw hwVar = (hw) bVar;
        if (hwVar != null) {
            hwVar.bRp.bRr = TenpayUtil.signWith3Des("passwd=" + hwVar.bRo.bRq);
            x.v("MicroMsg.GetWcPaySignEventListener", "alvinluo wcpaysign: %s", new Object[]{hwVar.bRp.bRr});
        }
        return false;
    }
}
