package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.MMWizardActivity;

@a
class URISpanHandlerSet$BindMobileUrilSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$BindMobileUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("weixin://setting/bindphone")) {
            return new m(str, 5, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{5};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 5) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        MMWizardActivity.D(URISpanHandlerSet.a(this.bAt), new Intent(URISpanHandlerSet.a(this.bAt), BindMContactIntroUI.class));
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (!str.equals("weixin://setting/bindphone")) {
            return false;
        }
        Intent intent = new Intent(URISpanHandlerSet.a(this.bAt), BindMContactIntroUI.class);
        if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
            intent.addFlags(268435456);
        }
        MMWizardActivity.D(URISpanHandlerSet.a(this.bAt), intent);
        return true;
    }
}
