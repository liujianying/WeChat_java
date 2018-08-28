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
class URISpanHandlerSet$SettingPluginLomoUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SettingPluginLomoUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
            return new m(str, 12, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{12};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 12) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "weibo");
        d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://setting/plugin/lomo")) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "weibo");
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
