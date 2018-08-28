package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements b {
    public final void e(Activity activity, String str) {
        if (p.zO(0)) {
            String optString = r.PX("discoverRecommendEntry").optString("wording");
            if (bi.oW(optString)) {
                x.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
                return;
            } else {
                ((i) g.l(i.class)).a(ad.getContext(), new 1(this, optString, activity));
                return;
            }
        }
        x.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
    }

    public final String bYQ() {
        return r.PX("discoverRecommendEntry").optString("labIcon");
    }

    public final String bYR() {
        String optString = r.PX("discoverRecommendEntry").optString("wording");
        if (bi.oW(optString)) {
            return ad.getContext().getString(R.l.find_friends_look);
        }
        return optString;
    }
}
