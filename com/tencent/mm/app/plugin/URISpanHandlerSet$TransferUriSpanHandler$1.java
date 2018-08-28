package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.ad;

class URISpanHandlerSet$TransferUriSpanHandler$1 implements OnClickListener {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ TransferUriSpanHandler bAF;

    URISpanHandlerSet$TransferUriSpanHandler$1(TransferUriSpanHandler transferUriSpanHandler, Bundle bundle) {
        this.bAF = transferUriSpanHandler;
        this.bAE = bundle;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String string = this.bAE.getString("transaction_id");
        String string2 = this.bAE.getString("receiver_name");
        Intent intent = new Intent();
        intent.putExtra("transaction_id", string);
        intent.putExtra("receiver_name", string2);
        d.b(ad.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
    }
}
