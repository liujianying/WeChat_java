package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class BizTimeLineUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$11(BizTimeLineUI bizTimeLineUI) {
        this.hst = bizTimeLineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (p.zO(0)) {
            Intent adR = p.adR();
            adR.putExtra("title", this.hst.getString(h.fts_search_biz_article));
            adR.putExtra("searchbar_tips", this.hst.getString(h.fts_search_biz_article));
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
            d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR);
        } else {
            x.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
        }
        return true;
    }
}
