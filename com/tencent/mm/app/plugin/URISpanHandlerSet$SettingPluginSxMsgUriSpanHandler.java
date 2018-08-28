package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SettingPluginSxMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
            return new m(str, 11, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{11};
    }

    final boolean a(m mVar, g gVar) {
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
