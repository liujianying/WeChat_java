package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;

@a
class URISpanHandlerSet$SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SettingBlacklistUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/blacklist")) {
            return new m(str, 14, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{14};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 14) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        x xVar = y.if(URISpanHandlerSet.a(this.bAt).getString(R.l.group_blacklist));
        Intent intent = new Intent();
        intent.setClass(URISpanHandlerSet.a(this.bAt), SelectContactUI.class);
        intent.putExtra("Contact_GroupFilter_Type", xVar.getType());
        intent.putExtra("Contact_GroupFilter_DisplayName", xVar.BK());
        intent.addFlags(67108864);
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_settings");
        }
        URISpanHandlerSet.a(this.bAt).startActivity(intent);
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://setting/blacklist")) {
            return false;
        }
        x xVar = y.if(URISpanHandlerSet.a(this.bAt).getString(R.l.group_blacklist));
        Intent intent = new Intent();
        intent.setClass(URISpanHandlerSet.a(this.bAt), AddressUI.class);
        intent.putExtra("Contact_GroupFilter_Type", xVar.getType());
        intent.putExtra("Contact_GroupFilter_DisplayName", xVar.BK());
        intent.addFlags(67108864);
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_settings");
        }
        URISpanHandlerSet.a(this.bAt).startActivity(intent);
        return true;
    }
}
