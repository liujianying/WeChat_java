package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class JsApiAddNativeDownloadTask$4 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ AddNativeDownloadTaskTask fFA;
    final /* synthetic */ JsApiAddNativeDownloadTask fFz;

    JsApiAddNativeDownloadTask$4(JsApiAddNativeDownloadTask jsApiAddNativeDownloadTask, AddNativeDownloadTaskTask addNativeDownloadTaskTask, l lVar, int i) {
        this.fFz = jsApiAddNativeDownloadTask;
        this.fFA = addNativeDownloadTaskTask;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void run() {
        this.fFA.ahB();
        Map hashMap = new HashMap();
        switch (this.fFA.bWA) {
            case 0:
                this.fCl.E(this.doP, this.fFz.f("fail:cancel", null));
                return;
            case 1:
                this.fCl.E(this.doP, this.fFz.f("fail:download fail", null));
                return;
            case 2:
                hashMap.put("download_id", Long.valueOf(this.fFA.bGm));
                this.fCl.E(this.doP, this.fFz.f("ok", hashMap));
                return;
            default:
                return;
        }
    }
}
