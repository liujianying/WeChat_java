package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

@a
class URISpanHandlerSet$AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$AlphaInstallUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
            return new m(str, 32, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{32};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 32) {
            return false;
        }
        String replace = mVar.url.replace("weixin://alphainstall?", "");
        String str = e.bnE + Uri.parse(replace).getQueryParameter("md5") + ".apk";
        if (com.tencent.mm.a.e.cn(str)) {
            bi.j(str, ad.getContext());
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", replace.toString());
            d.b(URISpanHandlerSet.a(this.bAt), "webview", ".ui.tools.WebViewUI", intent);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
