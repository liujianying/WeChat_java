package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.f;

public class g$f extends f {
    public JsResult vDE;

    public g$f(JsResult jsResult) {
        this.vDE = jsResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        this.vDE.confirm();
    }

    public final void cancel() {
        this.vDE.cancel();
    }
}
