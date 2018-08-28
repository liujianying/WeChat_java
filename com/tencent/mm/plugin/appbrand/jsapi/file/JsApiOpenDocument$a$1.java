package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;

class JsApiOpenDocument$a$1 implements Runnable {
    final /* synthetic */ a fQn;

    JsApiOpenDocument$a$1(a aVar) {
        this.fQn = aVar;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), j.app_brand_jsapi_open_document_no_available_3rd_apps, 0).show();
    }
}
