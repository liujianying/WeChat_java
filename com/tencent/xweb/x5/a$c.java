package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.f;

public class a$c implements JsResult {
    public f jJF;

    public a$c(f fVar) {
        this.jJF = fVar;
    }

    public final void confirm() {
        this.jJF.confirm();
    }

    public final void cancel() {
        this.jJF.cancel();
    }
}
