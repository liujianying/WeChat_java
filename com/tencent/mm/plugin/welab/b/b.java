package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.welab.a.a.b {
    public final void e(Activity activity, String str) {
        if (p.zO(0)) {
            Intent adR = p.adR();
            adR.putExtra("ftsbizscene", 20);
            Map b = p.b(20, true, 0);
            adR.putExtra("ftsneedkeyboard", true);
            adR.putExtra("rawUrl", p.v(b));
            d.b((Context) activity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", adR);
            return;
        }
        x.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
    }

    public final String bYQ() {
        return r.PX("discoverSearchEntry").optString("labIcon");
    }

    public final String bYR() {
        String optString = r.PX("discoverSearchEntry").optString("wording");
        if (bi.oW(optString)) {
            return ad.getContext().getString(R.l.find_friends_look);
        }
        return optString;
    }
}
