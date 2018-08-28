package com.tencent.mm.plugin.gwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.2;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class GWalletUI$3 extends BroadcastReceiver {
    final /* synthetic */ GWalletUI kiJ;

    GWalletUI$3(GWalletUI gWalletUI) {
        this.kiJ = gWalletUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(intent.getAction())) {
            List stringArrayListExtra = intent.getStringArrayListExtra("tokens");
            final boolean booleanExtra = intent.getBooleanExtra("IS_FAILED_CONSUME", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                GWalletUI.a(this.kiJ, 0, null);
            } else {
                e.post(new 2(GWalletUI.b(this.kiJ), stringArrayListExtra, new b() {
                    public final void b(c cVar, Intent intent) {
                        x.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
                        Intent intent2 = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
                        if (booleanExtra) {
                            intent2.putExtra("RESPONSE_CODE", 100000001);
                        } else {
                            intent2.putExtra("RESPONSE_CODE", 0);
                        }
                        GWalletUI.a(GWalletUI$3.this.kiJ, -1, intent2);
                    }
                }, new ag()), "IabHelper_consumeAsync");
            }
        }
    }
}
