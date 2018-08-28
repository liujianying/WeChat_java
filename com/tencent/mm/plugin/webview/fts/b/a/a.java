package com.tencent.mm.plugin.webview.fts.b.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class a {
    public static final a pPM = new a();
    public Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> pPL = new HashMap();

    public static a bTN() {
        return pPM;
    }

    public static com.tencent.mm.plugin.webview.fts.b.a.a.a Qg(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("//test-widget-ui")) {
            x.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
            return null;
        }
        String[] split = str.split("\\s+");
        if (split.length != 2) {
            x.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
            return null;
        }
        com.tencent.mm.plugin.webview.fts.b.a.a.a aVar;
        try {
            aVar = new com.tencent.mm.plugin.webview.fts.b.a.a.a(split[1]);
        } catch (Throwable e) {
            x.printErrStackTrace("SearchWidgetTestUiMgr", e, "", new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        pPM.pPL.put(aVar.bPS, aVar);
        x.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", aVar.pPR, aVar.bPS, aVar.pPP, aVar.pPQ);
        return aVar;
    }

    public final com.tencent.mm.plugin.webview.fts.b.a.a.a Qh(String str) {
        return (com.tencent.mm.plugin.webview.fts.b.a.a.a) this.pPL.get(str);
    }

    public static Uri a(Uri uri, String str, String str2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str3 : queryParameterNames) {
            clearQuery.appendQueryParameter(str3, str3.equals(str) ? str2 : uri.getQueryParameter(str3));
        }
        return clearQuery.build();
    }

    public final boolean Qi(String str) {
        return this.pPL.containsKey(str) && !((com.tencent.mm.plugin.webview.fts.b.a.a.a) this.pPL.get(str)).pPV;
    }
}
