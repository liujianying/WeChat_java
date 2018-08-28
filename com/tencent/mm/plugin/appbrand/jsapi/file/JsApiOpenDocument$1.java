package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenResult;
import com.tencent.mm.plugin.appbrand.l;

class JsApiOpenDocument$1 implements b<OpenResult> {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiOpenDocument fQl;

    JsApiOpenDocument$1(JsApiOpenDocument jsApiOpenDocument, l lVar, int i) {
        this.fQl = jsApiOpenDocument;
        this.fCl = lVar;
        this.doP = i;
    }

    public final /* synthetic */ void c(ProcessResult processResult) {
        OpenResult openResult = (OpenResult) processResult;
        if (this.fCl.Sx) {
            String str;
            if (openResult != null && openResult.ret != 2147483645) {
                switch (openResult.ret) {
                    case 0:
                        str = "ok";
                        break;
                    case 2147483646:
                        str = "fail no third apps supported";
                        break;
                    case Integer.MAX_VALUE:
                        str = "fail user cancel";
                        break;
                    default:
                        str = "fail file type not supported " + openResult.ret;
                        break;
                }
            }
            str = "fail env error";
            this.fCl.E(this.doP, this.fQl.f(str, null));
        }
    }
}
