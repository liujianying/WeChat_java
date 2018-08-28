package com.tencent.mm.plugin.webview.modeltools;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class h extends i<g> {
    public static final String[] diD = new String[]{i.a(g.dhO, "WebViewHostsFilter")};
    private final e diF;

    public h(e eVar) {
        this(eVar, g.dhO, "WebViewHostsFilter");
    }

    private h(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
        this.diF = eVar;
    }

    public final Set<String> bVd() {
        long VE = bi.VE();
        x.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = " + VE);
        boolean fV = fV("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < " + VE);
        x.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", new Object[]{Boolean.valueOf(fV)});
        Cursor a = this.diF.a(getTableName(), new String[]{"host"}, null, null, null, null, null, 2);
        Set hashSet = new HashSet();
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            return hashSet;
        }
        do {
            String string = a.getString(0);
            if (!bi.oW(string)) {
                hashSet.add(string);
                x.d("MicroMsg.WebViewStorage", "webview hijack gethost = " + string);
            }
        } while (a.moveToNext());
        if (a != null) {
            a.close();
        }
        return hashSet;
    }
}
