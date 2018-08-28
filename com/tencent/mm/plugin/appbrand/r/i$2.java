package com.tencent.mm.plugin.appbrand.r;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.r.i.a;

class i$2 implements ValueCallback<String> {
    final /* synthetic */ a gBK;

    i$2(a aVar) {
        this.gBK = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (str == null || !str.contains("11111")) {
            if (this.gBK != null) {
                this.gBK.fM(str);
            }
        } else if (this.gBK != null) {
            this.gBK.qe(str);
        }
    }
}
