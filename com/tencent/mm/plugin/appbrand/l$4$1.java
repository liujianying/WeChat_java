package com.tencent.mm.plugin.appbrand;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.l.4;
import com.tencent.mm.sdk.platformtools.x;

class l$4$1 implements ValueCallback<String> {
    final /* synthetic */ 4 fea;

    l$4$1(4 4) {
        this.fea = 4;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.AppBrandService", "inject SDK, current wx.version = %s", new Object[]{(String) obj});
    }
}
