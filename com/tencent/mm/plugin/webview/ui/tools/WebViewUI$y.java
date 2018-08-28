package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ak.i;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;

class WebViewUI$y implements IUtils {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$y(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$y(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final void javaUtilLog(int i, String str, String str2) {
        switch (i) {
            case 2:
                x.v(str, str2);
                return;
            case 3:
                x.d(str, str2);
                return;
            case 4:
                x.i(str, str2);
                return;
            case 5:
                x.w(str, str2);
                return;
            case 6:
                x.e(str, str2);
                return;
            default:
                return;
        }
    }

    public final void httpproxyReport(String... strArr) {
        i bUA = this.pZJ.pQY.bUA();
        if (!(strArr == null || strArr.length == 0)) {
            if (bUA.pSw == null) {
                bUA.pSw = new ArrayList();
            } else {
                bUA.pSw.clear();
            }
            for (Object add : strArr) {
                x.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[]{strArr[r0]});
                bUA.pSw.add(add);
            }
        }
        i bUA2 = this.pZJ.pQY.bUA();
        d dVar = this.pZJ.gcO;
        if (bUA2.pSw != null && bUA2.pSw.size() != 0 && dVar != null) {
            d.a(dVar, 12033, bUA2.pSw);
            bUA2.pSw.clear();
        }
    }

    public final void idKeyReport(String str, String str2, String str3) {
        x.i("MicroMsg.WebViewUI", "idkey report, id = %s, key = %s, value = %s", new Object[]{str, str2, str3});
        if (!bi.oW(str) && !bi.oW(str2) && !bi.oW(str3)) {
            h.mEJ.a((long) bi.getInt(str, 0), (long) bi.getInt(str2, 0), (long) bi.getInt(str3, 0), false);
        }
    }

    public final void kvReport(String... strArr) {
        ak.h bUB = this.pZJ.pQY.bUB();
        if (!(strArr == null || strArr.length == 0)) {
            if (bUB.pSw == null) {
                bUB.pSw = new ArrayList();
            } else {
                bUB.pSw.clear();
            }
            for (Object add : strArr) {
                x.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[]{strArr[r0]});
                bUB.pSw.add(add);
            }
        }
        ak.h bUB2 = this.pZJ.pQY.bUB();
        d dVar = this.pZJ.gcO;
        if (bUB2.pSw != null && bUB2.pSw.size() != 0 && dVar != null) {
            d.a(dVar, 12666, bUB2.pSw);
            bUB2.pSw.clear();
        }
    }
}
