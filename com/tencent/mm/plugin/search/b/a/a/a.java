package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;

public final class a implements b {
    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        j jVar = (j) aVar;
        ((n) g.n(n.class)).updateTopHitsRank(jVar.jrx.jrV, jVar.fyJ, 0);
        if (!((e) g.l(e.class)).uo(jVar.jyt.field_url)) {
            Intent intent;
            if (jVar.jyt.field_actionType == 2) {
                intent = new Intent();
                intent.putExtra("rawUrl", jVar.jyt.field_url);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (!com.tencent.mm.plugin.search.a.a.L(context, jVar.jyt.field_featureId)) {
                intent = new Intent();
                intent.putExtra("rawUrl", jVar.jyt.field_updateUrl);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        }
        return true;
    }
}
