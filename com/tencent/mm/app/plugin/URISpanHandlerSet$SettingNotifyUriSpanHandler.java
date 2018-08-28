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
import com.tencent.mm.ui.LauncherUI;

@a
class URISpanHandlerSet$SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SettingNotifyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/notify")) {
            return new m(str, 9, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{9};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 9) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_settings");
        }
        d.A(URISpanHandlerSet.a(this.bAt), "setting", ".ui.setting.SettingsNotificationUI");
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://setting/notify")) {
            return false;
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_settings");
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        d.b(URISpanHandlerSet.a(this.bAt), "setting", ".ui.setting.SettingsNotificationUI", intent);
        return true;
    }
}
