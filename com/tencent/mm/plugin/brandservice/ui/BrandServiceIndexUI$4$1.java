package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.4;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

class BrandServiceIndexUI$4$1 implements Runnable {
    final /* synthetic */ 4 hpd;

    BrandServiceIndexUI$4$1(4 4) {
        this.hpd = 4;
    }

    public final void run() {
        Intent adR = p.adR();
        adR.putExtra("KRightBtn", true);
        adR.putExtra("ftsneedkeyboard", true);
        adR.putExtra("key_load_js_without_delay", true);
        adR.putExtra("ftsType", 1);
        adR.putExtra("ftsbizscene", 6);
        Map b = p.b(6, true, 0);
        String zK = p.zK(bi.WU((String) b.get("scene")));
        b.put("sessionId", zK);
        b.put("subSessionId", zK);
        adR.putExtra("sessionId", zK);
        adR.putExtra("rawUrl", p.v(b));
        d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR);
    }
}
