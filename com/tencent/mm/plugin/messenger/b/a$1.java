package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a$1 implements n {
    final /* synthetic */ a lcN;

    a$1(a aVar) {
        this.lcN = aVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[]{map.toString()});
        a.d(aVar);
    }
}
