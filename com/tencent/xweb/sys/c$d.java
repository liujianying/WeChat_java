package com.tencent.xweb.sys;

import android.webkit.JsResult;
import com.tencent.xweb.f;

public class c$d extends f {
    public JsResult vCO;

    public c$d(JsResult jsResult) {
        this.vCO = jsResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        if (this.vCO != null) {
            this.vCO.confirm();
        }
    }

    public final void cancel() {
        if (this.vCO != null) {
            this.vCO.cancel();
        }
    }
}
