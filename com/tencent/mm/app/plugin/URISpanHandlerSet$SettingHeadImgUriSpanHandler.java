package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.LauncherUI;

@a
class URISpanHandlerSet$SettingHeadImgUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SettingHeadImgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/setheadimage")) {
            return new m(str, 6, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{6};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 6) {
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
        if (!str.equals("weixin://setting/setheadimage")) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", q.GF());
        intent.putExtra("Contact_Nick", q.GH());
        intent.putExtra("User_Avatar", true);
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
