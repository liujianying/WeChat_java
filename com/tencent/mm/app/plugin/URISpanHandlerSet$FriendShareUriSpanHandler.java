package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$FriendShareUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$FriendShareUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://findfriend/share")) {
            return new m(str, 18, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{18};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 18) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        d.A(URISpanHandlerSet.a(this.bAt), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://findfriend/share")) {
            return false;
        }
        Intent intent = new Intent();
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        d.b(URISpanHandlerSet.a(this.bAt), "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", intent);
        return true;
    }
}
