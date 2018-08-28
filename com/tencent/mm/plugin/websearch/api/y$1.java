package com.tencent.mm.plugin.websearch.api;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class y$1 implements ValueCallback<String> {
    y$1() {
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "initIFrame back %s", new Object[]{(String) obj});
    }
}
