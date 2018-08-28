package com.tencent.mm.ui.conversation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.conversation.BizConversationUI.a.1;
import java.util.Map;

class BizConversationUI$a$1$1 implements Runnable {
    final /* synthetic */ 1 unA;

    BizConversationUI$a$1$1(1 1) {
        this.unA = 1;
    }

    public final void run() {
        Intent adR = p.adR();
        adR.putExtra("title", this.unA.unz.getString(R.l.fts_search_biz_article));
        adR.putExtra("searchbar_tips", this.unA.unz.getString(R.l.fts_search_biz_article));
        adR.putExtra("KRightBtn", true);
        adR.putExtra("ftsneedkeyboard", true);
        adR.putExtra("publishIdPrefix", "bs");
        adR.putExtra("ftsType", 2);
        adR.putExtra("ftsbizscene", 11);
        Map b = p.b(11, true, 2);
        String zK = p.zK(bi.WU((String) b.get("scene")));
        b.put("sessionId", zK);
        adR.putExtra("sessionId", zK);
        adR.putExtra("rawUrl", p.v(b));
        adR.putExtra("key_load_js_without_delay", true);
        adR.addFlags(67108864);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(this.unA.unz.thisActivity(), new Pair[0]).toBundle();
        }
        d.a(this.unA.unz.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR, bundle);
    }
}
