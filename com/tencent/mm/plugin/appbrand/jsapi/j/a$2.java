package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class a$2 implements a<String> {
    final /* synthetic */ a fXa;

    a$2(a aVar) {
        this.fXa = aVar;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        String str = (String) obj;
        a aVar = this.fXa;
        if (aVar.gMI != null) {
            if (!z) {
                aVar.h("cancel", null);
            }
            if (bi.oW(str)) {
                aVar.h("fail", null);
            } else {
                Map hashMap = new HashMap(1);
                hashMap.put("value", str);
                aVar.h("ok", hashMap);
            }
            aVar.gMI.hide();
        }
    }
}
