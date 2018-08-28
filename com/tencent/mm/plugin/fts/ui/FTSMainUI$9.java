package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class FTSMainUI$9 implements c {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$9(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void a(bhr bhr, String str, int i) {
        String str2 = this.jxp.bWm;
        if (bhr.jRb == 1) {
            FTSMainUI.a(this.jxp, this.jxp.bWm);
            this.jxp.bWm = bhr.siy;
            Map hashMap = new HashMap();
            hashMap.put("prefixSug", FTSMainUI.e(this.jxp));
            hashMap.put("sugId", str);
            hashMap.put("sceneActionType", "6");
            FTSMainUI.a(this.jxp, hashMap);
        } else if (bhr.jRb == 4 && !bi.oW(bhr.jOU)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", bhr.jOU);
            intent.putExtra("convertActivityFromTranslucent", false);
            d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
        ((e) g.l(e.class)).g(str2, str, i, bhr.siy);
        b bVar = FTSMainUI.f(this.jxp).jwK;
        if (FTSMainUI.g(this.jxp) == null || FTSMainUI.g(this.jxp).getVisibility() != 0) {
            bVar.jzl = FTSMainUI.f(this.jxp).getBlockCount() + 1;
        } else {
            bVar.jzl = FTSMainUI.f(this.jxp).getBlockCount() + 2;
        }
        int count = FTSMainUI.f(this.jxp).getCount();
        int h = FTSMainUI.h(this.jxp);
        int i2 = count + 1;
        long currentTimeMillis = System.currentTimeMillis() - bVar.jyY;
        if (currentTimeMillis < 0 || bVar.jyY == 0) {
            currentTimeMillis = 0;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(h), Integer.valueOf(23), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(currentTimeMillis), Integer.valueOf(bVar.jzb), Integer.valueOf(bVar.jzc), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jze), Integer.valueOf(bVar.jzf), Integer.valueOf(bVar.jzg), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzj), Integer.valueOf(bVar.jzk), com.tencent.mm.plugin.fts.a.e.jqM, str2, Integer.valueOf(bVar.jzi), Integer.valueOf(bVar.jzl)});
        x.i("MicroMsg.FTS.FTSReportLogic", "lxl, click blockpos:" + bVar.jzl);
        h.mEJ.k(10991, format);
    }
}
