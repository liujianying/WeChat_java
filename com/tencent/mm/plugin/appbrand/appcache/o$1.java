package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class o$1 implements Runnable {
    o$1() {
    }

    public final void run() {
        try {
            String str;
            String str2 = AppBrandGlobalSystemConfig.adZ().fpJ;
            if (bi.oW(str2)) {
                str = "res.servicewechat.com";
            } else {
                str2 = Uri.parse(str2).getHost();
                str = bi.oW(str2) ? "res.servicewechat.com" : str2;
            }
            Object arrayList = new ArrayList();
            g.Eh().dpP.dJs.getHostByName(str, arrayList);
            CdnLogic.triggerPreConnect(str, (String[]) arrayList.toArray(new String[0]), true);
            x.i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, host %s", new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PkgNetworkOpt", e, "triggerPreConnect", new Object[0]);
        }
    }
}
