package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletUI$4 implements b {
    final /* synthetic */ GWalletUI kiJ;
    final /* synthetic */ boolean kiM;

    GWalletUI$4(GWalletUI gWalletUI, boolean z) {
        this.kiJ = gWalletUI;
        this.kiM = z;
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public final void b(c cVar, Intent intent) {
        x.d("MicroMsg.GWalletUI", "Query inventory finished. data : " + intent);
        if (intent == null) {
            intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
            intent.putExtra("RESPONSE_CODE", cVar.aVR());
        } else {
            intent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        }
        if (!this.kiM) {
            intent.putExtra("is_direct", false);
        }
        this.kiJ.sendBroadcast(intent);
    }
}
