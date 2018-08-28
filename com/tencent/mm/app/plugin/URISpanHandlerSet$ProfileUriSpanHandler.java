package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.e;

@a
class URISpanHandlerSet$ProfileUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$ProfileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://contacts/profile/")) {
            return new m(str, 3, str.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
        }
        return null;
    }

    final int[] vB() {
        return new int[]{3};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 3) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        String str = (String) mVar.F(String.class);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("Contact_User", str);
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
            e.a(intent, str);
        }
        if (bi.oV(str).length() > 0) {
            d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        }
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.startsWith("weixin://contacts/profile/")) {
            return false;
        }
        String replace = str.trim().replace("weixin://contacts/profile/", "").replace("/", "");
        if (bi.oW(replace)) {
            x.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
            return true;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("Contact_User", replace);
        au.HU();
        ab Yg = c.FR().Yg(replace);
        if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
            e.a(intent, replace);
        }
        d.b(URISpanHandlerSet.a(this.bAt), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
