package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.LauncherUI;

@a
class URISpanHandlerSet$FlowStatUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$FlowStatUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://flowstat")) {
            return new m(str, 16, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{16};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 16) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_settings");
        }
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://flowstat")) {
            return false;
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_settings");
        }
        return true;
    }
}
