package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.g.a.su;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$VoipCallAgainUrilSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$VoipCallAgainUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://voip/callagain/")) {
            return new m(str, 38, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{38};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type == 38) {
            Uri parse = Uri.parse(mVar.url);
            String queryParameter = parse.getQueryParameter("username");
            String queryParameter2 = parse.getQueryParameter("isvideocall");
            su suVar = new su();
            suVar.cdE.bOh = 5;
            suVar.cdE.talker = queryParameter;
            suVar.cdE.context = URISpanHandlerSet.a(this.bAt);
            if (!(queryParameter == null || queryParameter.equals(""))) {
                if (queryParameter2 == null || !queryParameter2.equals("true")) {
                    suVar.cdE.cdz = 4;
                } else {
                    suVar.cdE.cdz = 2;
                }
                com.tencent.mm.sdk.b.a.sFg.m(suVar);
                return true;
            }
        }
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
