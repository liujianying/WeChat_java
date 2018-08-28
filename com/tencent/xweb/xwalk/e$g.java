package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.xweb.h;

public class e$g implements h {
    ValueCallback<Boolean> vEP;

    public e$g(ValueCallback<Boolean> valueCallback) {
        this.vEP = valueCallback;
    }

    public final void proceed() {
        this.vEP.onReceiveValue(Boolean.valueOf(true));
    }

    public final void cancel() {
        this.vEP.onReceiveValue(Boolean.valueOf(false));
    }
}
