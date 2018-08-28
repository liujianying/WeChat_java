package com.tencent.mm.plugin.topstory.ui.home;

import android.os.Build;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

class b$2 extends v {
    final /* synthetic */ b ozD;

    b$2(b bVar) {
        this.ozD = bVar;
    }

    public final void bHJ() {
        if (bi.oW(r.PX("discoverSearchEntry").optString("wording"))) {
            x.e("MicroMsg.TopStory.TopStoryUIComponentImpl", "empty title");
            return;
        }
        ad.h("", 0, 0, 36);
        String zK = p.zK(36);
        Map hashMap = new HashMap();
        try {
            hashMap.put("topStoryScene", String.valueOf(this.ozD.ccA.scene));
            hashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("from", URLEncoder.encode(this.ozD.ozw.getString(g.top_story_assistor), "utf8"));
            com.tencent.mm.kernel.g.Eg();
            hashMap.put("uin", a.Dg());
            hashMap.put("timeZone", URLEncoder.encode(bi.ciX(), "utf8"));
            hashMap.put("ostype", d.qVJ);
        } catch (Exception e) {
        }
        ((f) com.tencent.mm.kernel.g.l(f.class)).a(this.ozD.ozw, "", zK, hashMap);
        com.tencent.mm.plugin.report.f.mDy.h(15449, new Object[]{Integer.valueOf(0)});
    }
}
