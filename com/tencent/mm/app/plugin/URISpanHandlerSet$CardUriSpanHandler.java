package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$CardUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$CardUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        return null;
    }

    final int[] vB() {
        return new int[0];
    }

    final boolean a(m mVar, g gVar) {
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.startsWith("wxcard://cardjumptype=1")) {
            return false;
        }
        String str2 = null;
        if (sVar != null) {
            str2 = sVar.cbm().toString();
        }
        Intent intent = new Intent();
        intent.putExtra("user_name", str2);
        intent.putExtra("view_type", 1);
        d.b(URISpanHandlerSet.a(this.bAt), "card", ".ui.CardViewUI", intent);
        return true;
    }
}
