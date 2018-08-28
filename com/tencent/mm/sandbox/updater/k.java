package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.plugin.cdndownloader.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b.d;
import com.tencent.xweb.i;
import com.tencent.xweb.r;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class k implements a {
    /* synthetic */ k(byte b) {
        this();
    }

    public final boolean ao(Intent intent) {
        if (intent == null) {
            return false;
        }
        x.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", new Object[]{Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 4))});
        HashMap hashMap = new HashMap();
        if (intent.getIntExtra("intent_extra_download_type", 4) == 5) {
            hashMap.put("UpdaterCheckType", "1");
        } else {
            hashMap.put("UpdaterCheckType", "0");
        }
        i.a(ad.getContext(), hashMap);
        return true;
    }

    public final void la(boolean z) {
    }

    public final boolean isBusy() {
        boolean isBusy = i.isBusy();
        x.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = " + isBusy);
        return isBusy;
    }

    public final void onDestroy() {
    }

    private k() {
        1 1 = new 1(this);
        2 2 = new 2(this);
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.uHo);
        r.a(ad.getContext(), 1, 2, null);
        d.a(a.aAr());
    }
}
