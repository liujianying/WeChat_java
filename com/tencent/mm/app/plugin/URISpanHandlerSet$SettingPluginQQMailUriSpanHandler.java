package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$SettingPluginQQMailUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SettingPluginQQMailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/plugin/qqmail")) {
            return new m(str, 10, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{10};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 10) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "qqmail");
        d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://setting/plugin/qqmail")) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "qqmail");
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
