package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bi;

@a
class URISpanHandlerSet$ExposeUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$ExposeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().toLowerCase().equals("weixin://expose/")) {
            return new m(str, 31, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{31};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 31) {
            return false;
        }
        int i;
        Intent intent = new Intent();
        String str = (String) gVar.a(mVar);
        intent.putExtra("k_username", str);
        if (bi.oW(str) || !str.endsWith("@chatroom")) {
            i = 39;
        } else {
            i = 36;
        }
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        d.b(URISpanHandlerSet.a(this.bAt), "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
