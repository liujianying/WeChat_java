package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiOpenDocument$a$2 implements ValueCallback<String> {
    final /* synthetic */ a fQn;

    JsApiOpenDocument$a$2(a aVar) {
        this.fQn = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, receiveValue = %s", new Object[]{(String) obj});
        if ("fileReaderClosed".equals((String) obj) && !a.a(this.fQn)) {
            a.b(this.fQn);
        }
    }
}
