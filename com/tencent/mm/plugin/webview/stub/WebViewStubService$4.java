package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.model.d$a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubService$4 implements d$a {
    final /* synthetic */ WebViewStubService pUR;

    WebViewStubService$4(WebViewStubService webViewStubService) {
        this.pUR = webViewStubService;
    }

    public final void a(boolean z, int i, int i2, String str, String str2) {
        Bundle bundle;
        x.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        if (z) {
            try {
                bundle = new Bundle();
                bundle.putString("webview_jssdk_file_item_local_id", str);
                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.h(this.pUR)) {
                    webViewStubCallbackWrapper.pXx.c(2011, bundle);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[]{e.getMessage()});
            }
        }
        switch (i) {
            case 1:
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : WebViewStubService.h(this.pUR)) {
                            webViewStubCallbackWrapper2.pXx.c(2003, bundle);
                        }
                        return;
                    } catch (Exception e2) {
                        x.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[]{e2.getMessage()});
                        return;
                    }
                }
                try {
                    bundle = new Bundle();
                    bundle.putString("webview_jssdk_file_item_server_id", str2);
                    bundle.putInt("webview_jssdk_file_item_progreess", i2);
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : WebViewStubService.h(this.pUR)) {
                        webViewStubCallbackWrapper22.pXx.c(2004, bundle);
                    }
                    return;
                } catch (Exception e22) {
                    x.e("MicroMsg.WebViewStubService", "notify download image failed :%s", new Object[]{e22.getMessage()});
                    return;
                }
            case 2:
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : WebViewStubService.h(this.pUR)) {
                            webViewStubCallbackWrapper222.pXx.c(2005, bundle);
                        }
                        return;
                    } catch (Exception e222) {
                        x.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", new Object[]{e222.getMessage()});
                        return;
                    }
                }
                try {
                    bundle = new Bundle();
                    bundle.putString("webview_jssdk_file_item_server_id", str2);
                    bundle.putInt("webview_jssdk_file_item_progreess", i2);
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : WebViewStubService.h(this.pUR)) {
                        webViewStubCallbackWrapper2222.pXx.c(2006, bundle);
                    }
                    return;
                } catch (Exception e2222) {
                    x.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", new Object[]{e2222.getMessage()});
                    return;
                }
            case 4:
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : WebViewStubService.h(this.pUR)) {
                            webViewStubCallbackWrapper22222.pXx.c(2010, bundle);
                        }
                        return;
                    } catch (Exception e22222) {
                        x.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", new Object[]{e22222.getMessage()});
                        return;
                    }
                }
                return;
            default:
                x.e("MicroMsg.WebViewStubService", "unsupport media type : %d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }
}
