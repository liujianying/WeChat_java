package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import org.xwalk.core.Log;

class h$2 implements ExceptionHandler {
    final /* synthetic */ h vDI;

    h$2(h hVar) {
        this.vDI = hVar;
    }

    public final void handleException(JsContext jsContext, JsError jsError) {
        if (jsError == null) {
            Log.i("MicroMsg.X5V8JsRuntime", "jsError is null.");
            return;
        }
        Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[]{jsError.getMessage()}));
        if (this.vDI.gex != null) {
            this.vDI.gex.aR(r0, "");
        }
    }
}
