package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.xweb.e;

public class c$c extends e {
    public JsPromptResult vCN;

    public c$c(JsPromptResult jsPromptResult) {
        this.vCN = jsPromptResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        if (this.vCN != null) {
            this.vCN.confirm();
        }
    }

    public final void cancel() {
        if (this.vCN != null) {
            this.vCN.cancel();
        }
    }
}
