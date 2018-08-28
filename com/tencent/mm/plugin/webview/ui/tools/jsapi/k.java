package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ak.o;
import com.tencent.mm.sdk.platformtools.bi;

public final class k {
    public static void RQ(String str) {
        if (!bi.oW(str) && str.startsWith("http")) {
            o.Pe().a(str, null);
        }
    }
}
