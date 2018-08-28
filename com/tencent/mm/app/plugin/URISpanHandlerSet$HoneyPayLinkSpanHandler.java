package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.x;

@a
class URISpanHandlerSet$HoneyPayLinkSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$HoneyPayLinkSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().startsWith("native://wcpay/honeypay")) {
            return new m(str, 46, null);
        }
        return str.trim().startsWith("weixin://wcpay/bankCardList") ? new m(str, 47, null) : null;
    }

    final int[] vB() {
        return new int[]{46, 47};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type == 46) {
            x.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
            if (mVar.data != null && (mVar.data instanceof Bundle)) {
                Uri parse = Uri.parse(mVar.url);
                String queryParameter = parse.getQueryParameter("cardNo");
                boolean equals = parse.getQueryParameter("isPayer").equals("1");
                Intent intent = new Intent();
                intent.putExtra("key_card_no", queryParameter);
                intent.putExtra("key_is_payer", equals);
                d.b(URISpanHandlerSet.a(this.bAt), "honey_pay", ".ui.HoneyPayProxyUI", intent);
            }
        } else if (mVar.type == 47) {
            x.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
            Intent intent2 = new Intent();
            intent2.putExtra("intent_finish_self", true);
            d.b(URISpanHandlerSet.a(this.bAt), "wallet", ".bind.ui.WalletBankcardManageUI", intent2);
            h.mEJ.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        }
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
