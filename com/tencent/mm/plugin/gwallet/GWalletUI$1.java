package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletUI$1 implements a {
    final /* synthetic */ GWalletUI kiJ;

    GWalletUI$1(GWalletUI gWalletUI) {
        this.kiJ = gWalletUI;
    }

    public final void a(c cVar) {
        x.d("MicroMsg.GWalletUI", "Setup finished.");
        if (cVar.isSuccess()) {
            if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(this.kiJ.getIntent().getAction())) {
                GWalletUI.a(this.kiJ);
                return;
            } else {
                this.kiJ.fC(this.kiJ.getIntent().getBooleanExtra("is_direct", true));
                return;
            }
        }
        x.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: " + cVar);
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", cVar.aVR());
        GWalletUI.a(this.kiJ, -1, intent);
    }
}
