package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMWizardActivity;

@a
class URISpanHandlerSet$SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$SetSafeDeviceUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        if (!str.equals("weixin://setting/account/safedevice")) {
            return false;
        }
        au.HU();
        String str2 = (String) c.DT().get(6, "");
        au.HU();
        String str3 = (String) c.DT().get(4097, "");
        Intent intent;
        if (!bi.oW(str2)) {
            intent = new Intent();
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            d.A(URISpanHandlerSet.a(this.bAt), "account", ".security.ui.MySafeDeviceListUI");
        } else if (bi.oW(str3)) {
            intent = new Intent();
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            d.a(URISpanHandlerSet.a(this.bAt), "account", ".security.ui.BindSafeDeviceUI", intent);
        } else {
            intent = new Intent(URISpanHandlerSet.a(this.bAt), BindMContactIntroUI.class);
            intent.putExtra("is_bind_for_safe_device", true);
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            MMWizardActivity.D(URISpanHandlerSet.a(this.bAt), intent);
        }
        return true;
    }
}
