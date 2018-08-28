package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@a
class URISpanHandlerSet$PayTransferUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$PayTransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        if (!str.startsWith("wxpay://")) {
            return false;
        }
        String obj;
        com.tencent.mm.plugin.wallet.a aVar;
        if (sVar != null) {
            obj = sVar.cbm().toString();
            Object cbn = sVar.cbn();
            aVar = cbn instanceof com.tencent.mm.plugin.wallet.a ? (com.tencent.mm.plugin.wallet.a) cbn : null;
        } else {
            aVar = null;
            obj = null;
        }
        if (bi.oW(obj)) {
            x.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
            return false;
        }
        String substring = str.substring(8);
        String str2 = "";
        if (substring.indexOf("&") > 0) {
            substring = substring.split("&")[0];
        }
        int indexOf = substring.indexOf("=");
        if (indexOf >= 0) {
            substring = substring.substring(indexOf + 1);
        } else {
            substring = str2;
        }
        if (bi.getInt(substring, 0) == 1) {
            if (q.GT() || q.GU()) {
                h.a(URISpanHandlerSet.a(this.bAt), 5, obj, 11, aVar);
            } else {
                h.a(URISpanHandlerSet.a(this.bAt), 2, obj, 11, aVar);
            }
            return true;
        }
        Toast.makeText(URISpanHandlerSet.a(this.bAt), URISpanHandlerSet.a(this.bAt).getString(R.l.service_app_service_not_support), 0).show();
        return false;
    }
}
