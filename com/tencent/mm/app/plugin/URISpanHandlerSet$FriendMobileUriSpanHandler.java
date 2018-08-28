package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$FriendMobileUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$FriendMobileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://findfriend/mobile")) {
            return new m(str, 20, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{20};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 20) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        URISpanHandlerSet.a(this.bAt).startActivity(new Intent(URISpanHandlerSet.a(this.bAt), MobileFriendUI.class));
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://findfriend/mobile")) {
            return false;
        }
        Intent intent = new Intent(URISpanHandlerSet.a(this.bAt), MobileFriendUI.class);
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        URISpanHandlerSet.a(this.bAt).startActivity(intent);
        return true;
    }
}
