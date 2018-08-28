package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class i$2 implements a<String> {
    final /* synthetic */ i fXB;

    i$2(i iVar) {
        this.fXB = iVar;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        String str = (String) obj;
        i iVar = this.fXB;
        if (iVar.gMI != null) {
            iVar.gMI.hide();
        }
        if (!z) {
            iVar.h("cancel", null);
        } else if (bi.oW(str)) {
            iVar.h("fail", null);
        } else {
            Map hashMap = new HashMap(1);
            hashMap.put("value", str);
            iVar.h("ok", hashMap);
        }
    }
}
