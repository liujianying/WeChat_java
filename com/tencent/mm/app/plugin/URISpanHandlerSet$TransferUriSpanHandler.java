package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.base.h;

@a
class URISpanHandlerSet$TransferUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$TransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
            return new m(str, 39, null);
        }
        if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
            return new m(str, 40, null);
        }
        if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
            return new m(str, 41, null);
        }
        return str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt") ? new m(str, 42, null) : null;
    }

    final int[] vB() {
        return new int[]{39, 40, 41, 42};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar != null) {
            if (mVar.type == 42) {
                d.A(URISpanHandlerSet.a(this.bAt), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                return true;
            } else if (mVar.type == 41) {
                d.A(URISpanHandlerSet.a(this.bAt), "wallet", ".balance.ui.WalletBalanceManagerUI");
                return true;
            } else if (mVar.type == 39) {
                if (mVar.data != null && (mVar.data instanceof Bundle)) {
                    h.a(URISpanHandlerSet.a(this.bAt), URISpanHandlerSet.a(this.bAt).getString(R.l.span_remittance_confirm_resend_msg), URISpanHandlerSet.a(this.bAt).getString(R.l.app_remind), URISpanHandlerSet.a(this.bAt).getString(R.l.span_remittance_resend), URISpanHandlerSet.a(this.bAt).getString(R.l.app_cancel), new 1(this, (Bundle) mVar.data), new 2(this));
                }
                return true;
            } else if (mVar.type == 40) {
                if (mVar.data != null && (mVar.data instanceof Bundle)) {
                    Bundle bundle = (Bundle) mVar.data;
                    ne neVar = new ne();
                    neVar.bYf.bOe = bundle.getString("transaction_id");
                    neVar.bYf.bXz = bundle.getString("transfer_id");
                    neVar.bYf.bYg = bundle.getInt("total_fee");
                    neVar.bYf.bYh = bundle.getString("sender_name");
                    com.tencent.mm.sdk.b.a.sFg.m(neVar);
                }
                return true;
            }
        }
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
