package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$PayUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$PayUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        return null;
    }

    final int[] vB() {
        return new int[]{28};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 28) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        gw gwVar = new gw();
        gwVar.bQd.actionCode = 11;
        gwVar.bQd.result = mVar.url;
        gwVar.bQd.context = URISpanHandlerSet.a(this.bAt);
        gwVar.bQd.bQf = new Bundle();
        gwVar.bQd.bQf.putInt("pay_channel", 6);
        com.tencent.mm.sdk.b.a.sFg.a(gwVar, Looper.myLooper());
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
