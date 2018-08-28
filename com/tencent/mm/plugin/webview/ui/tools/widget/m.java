package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    static void Bj(int i) {
        switch (i) {
            case 1:
                if (g.l(a.class) != null) {
                    ((a) g.l(a.class)).bVg();
                    return;
                } else {
                    x.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
                    return;
                }
            case 2:
                if (g.l(a.class) != null) {
                    ((a) g.l(a.class)).bVh();
                    return;
                } else {
                    x.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
                    return;
                }
            default:
                return;
        }
    }

    public static void Bk(int i) {
        if (ad.cic()) {
            x.i("MicroMsg.WebViewBagService", "in mm process op:%d", new Object[]{Integer.valueOf(i)});
            Bj(i);
            return;
        }
        XIPCInvoker.a("com.tencent.mm", new IPCInteger(i), a.class, new 1());
    }
}
