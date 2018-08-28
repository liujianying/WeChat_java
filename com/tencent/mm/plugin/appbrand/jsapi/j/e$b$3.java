package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.j.e.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d$a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class e$b$3 implements d$a<int[]> {
    final /* synthetic */ b fXl;

    e$b$3(b bVar) {
        this.fXl = bVar;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        int[] iArr = (int[]) obj;
        b.b(this.fXl).hide();
        if (!z) {
            this.fXl.h("cancel", null);
        } else if (iArr == null || iArr.length <= 0) {
            this.fXl.h("fail error result", null);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (int put : iArr) {
                jSONArray.put(put);
            }
            Map hashMap = new HashMap(1);
            hashMap.put("current", jSONArray);
            this.fXl.h("ok", hashMap);
        }
    }
}
