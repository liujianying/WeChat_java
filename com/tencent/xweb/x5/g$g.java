package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.e;

public class g$g extends e {
    public JsPromptResult vDF;

    public g$g(JsPromptResult jsPromptResult) {
        this.vDF = jsPromptResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        this.vDF.confirm();
    }

    public final void cancel() {
        this.vDF.cancel();
    }
}
