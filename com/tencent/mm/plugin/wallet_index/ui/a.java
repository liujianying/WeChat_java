package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.plugin.wallet_index.b.a.b;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.q;
import java.util.ArrayList;

public final class a implements b {
    public static long pDd = 0;
    BroadcastReceiver hiJ = new 1(this);
    String iiv;
    private String pCK;
    String pCL;
    private d pDa = null;
    private d pDb = null;
    private c pDc;
    private d pDe;
    private com.tencent.mm.plugin.wallet_index.b.a.a pDf;
    private b pDg;
    String pDh;

    public a(Activity activity, c cVar, d dVar) {
        this.pDe = dVar;
        pDd = 0;
        this.pDc = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        activity.registerReceiver(this.hiJ, intentFilter);
        this.pDf = new com.tencent.mm.plugin.wallet_index.b.a.a();
    }

    public final int bRd() {
        return 3;
    }

    public final void a(MMActivity mMActivity, d dVar) {
        this.pDa = dVar;
        this.iiv = this.pDc.pCP.lRl;
        this.pCL = this.pDc.pCP.lPj;
        this.pCK = this.pDc.pCP.rFe;
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("product_id", this.iiv);
        this.pDh = this.pDc.pCP.rQh;
        String str = "developer_pay_load";
        String str2 = this.pDh;
        String str3 = this.pCL;
        String str4 = this.pCK;
        if (bi.oW(str2)) {
            str2 = "";
        }
        if (bi.oW(str3)) {
            str3 = "";
        }
        if (bi.oW(str4)) {
            str4 = "";
        }
        intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
        if (mMActivity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            x.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
            com.tencent.mm.plugin.wallet_index.c.a aN = com.tencent.mm.plugin.wallet_index.c.a.aN(3, "");
            if (this.pDa != null) {
                this.pDa.a(aN, null);
                return;
            }
            return;
        }
        pDd = bi.VF();
        x.i("MicroMsg.GoogleWallet", "GWallet Found!");
        mMActivity.startActivityForResult(intent, 10001);
    }

    public final void j(MMActivity mMActivity) {
        try {
            mMActivity.unregisterReceiver(this.hiJ);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.GoogleWallet", e.toString());
        }
        if (!bi.ci(mMActivity)) {
            x.d("MicroMsg.GoogleWallet", "close front UI.");
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            mMActivity.sendBroadcast(intent);
        }
        x.d("MicroMsg.GoogleWallet", "Destroying helper.");
    }

    private static void b(MMActivity mMActivity, int i) {
        com.tencent.mm.plugin.wallet_index.c.a aN = com.tencent.mm.plugin.wallet_index.c.a.aN(i, "");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", aN.kjf);
        intent.putExtra("key_err_msg", aN.kjg);
        intent.putExtra("key_launch_ts", pDd);
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (i == 10001) {
            x.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", Integer.valueOf(i2));
            if (intent != null) {
                int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                if (intExtra == 3 || intExtra == 105) {
                    q.c(this.pDh, this.iiv, this.pCL, intExtra, "");
                    b(mMActivity, intExtra);
                } else if (intExtra == 100000001) {
                    b(mMActivity, intExtra);
                }
            } else {
                b(mMActivity, 1);
            }
            return true;
        }
        d dVar = this.pDb;
        String str = this.pDh;
        String str2 = this.iiv;
        String str3 = this.pCL;
        int ae = com.tencent.mm.plugin.wallet_index.b.a.a.ae(intent);
        x.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(ae));
        com.tencent.mm.plugin.wallet_index.c.a aN = com.tencent.mm.plugin.wallet_index.c.a.aN(ae, "");
        q.c(str, str2, str3, ae, aN.kjg);
        if (dVar != null) {
            dVar.a(aN, null);
        }
        return true;
    }

    public final void b(MMActivity mMActivity, boolean z) {
        x.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
        x.d("MicroMsg.GoogleWallet", "is direct? " + z);
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("is_direct", z);
        mMActivity.startActivityForResult(intent, 10001);
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        this.pDb = dVar;
        x.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
        b bVar = this.pDg;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            c cVar = (c) bVar.pCD.get(str);
            if (cVar != null) {
                arrayList2.add(cVar.eIe);
            }
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putStringArrayListExtra("tokens", arrayList2);
            intent.putExtra("IS_FAILED_CONSUME", z);
            mMActivity.sendBroadcast(intent);
            return;
        }
        com.tencent.mm.plugin.wallet_index.c.a aN = com.tencent.mm.plugin.wallet_index.c.a.aN(0, "");
        if (this.pDb != null) {
            this.pDb.a(aN, null);
        }
    }
}
