package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i<d> {
    public static final String[] diD = new String[]{i.a(d.dhO, "WebViewHistory")};

    static /* synthetic */ void a(e eVar) {
        int count = eVar.getCount() - 500;
        if (count > 0) {
            x.i("MicroMsg.WebViewHistoryStorage", "deleteItem: " + eVar.fV("WebViewHistory", "delete from WebViewHistory order by timeStamp limit " + count));
        }
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.dhO, "WebViewHistory", null);
    }
}
