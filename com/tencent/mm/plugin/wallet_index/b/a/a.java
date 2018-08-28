package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {

    public interface a {
        void a(com.tencent.mm.plugin.wallet_index.c.a aVar, b bVar);
    }

    public static b a(Intent intent, d dVar) {
        com.tencent.mm.plugin.wallet_index.c.a aN;
        if (intent == null) {
            ED("Null data in IAB activity result.");
            aN = com.tencent.mm.plugin.wallet_index.c.a.aN(5, "");
            if (dVar == null) {
                return null;
            }
            dVar.a(aN, null);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            x.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            x.d("MicroMsg.IabResolver", "Purchase data: " + stringExtra);
            x.d("MicroMsg.IabResolver", "Data signature: " + stringExtra2);
            x.d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                ED("BUG: either purchaseData or dataSignature is null.");
                aN = com.tencent.mm.plugin.wallet_index.c.a.aN(5, "");
                if (dVar == null) {
                    return null;
                }
                dVar.a(aN, null);
                return null;
            }
            try {
                c cVar = new c("inapp", stringExtra, stringExtra2);
                stringExtra = cVar.iiv;
                x.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (dVar != null) {
                    dVar.a(com.tencent.mm.plugin.wallet_index.c.a.aN(0, ""), cVar);
                }
                return new b(stringExtra, cVar);
            } catch (Throwable e) {
                ED("Failed to parse purchase data.");
                x.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                aN = com.tencent.mm.plugin.wallet_index.c.a.aN(5, "");
                if (dVar == null) {
                    return null;
                }
                dVar.a(aN, null);
                return null;
            }
        }
        ED("Purchase failed. Response: " + intExtra);
        aN = com.tencent.mm.plugin.wallet_index.c.a.aN(intExtra, "");
        if (dVar == null) {
            return null;
        }
        dVar.a(aN, null);
        return null;
    }

    public static int a(Intent intent, a aVar) {
        b bVar = new b();
        int ae = ae(intent);
        x.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(ae));
        if (ae != 0) {
            aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aN(ae, ""), null);
            return ae;
        } else if (intent.hasExtra("INAPP_PURCHASE_ITEM_LIST") && intent.hasExtra("INAPP_PURCHASE_DATA_LIST") && intent.hasExtra("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
            ArrayList stringArrayListExtra3 = intent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
            int i = 0;
            while (i < stringArrayListExtra2.size()) {
                try {
                    String str = (String) stringArrayListExtra2.get(i);
                    String str2 = (String) stringArrayListExtra3.get(i);
                    String str3 = "MicroMsg.IabResolver";
                    x.d(str3, "Sku is owned: " + ((String) stringArrayListExtra.get(i)));
                    c cVar = new c("inapp", str, str2);
                    if (TextUtils.isEmpty(cVar.eIe)) {
                        x.w("MicroMsg.IabResolver", "In-app billing warning: " + "BUG: empty/null token!");
                        x.d("MicroMsg.IabResolver", "Purchase data: " + str);
                    }
                    bVar.pCD.put(cVar.iiv, cVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                    aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aN(5, ""), bVar);
                }
            }
            aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aN(0, ""), bVar);
            return 0;
        } else {
            ED("Bundle returned from getPurchases() doesn't contain required fields.");
            aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aN(5, ""), null);
            return 5;
        }
    }

    private static void ED(String str) {
        x.e("MicroMsg.IabResolver", "In-app billing error: " + str);
    }

    public static int ae(Intent intent) {
        if (intent == null) {
            ED("Intent with no response code, assuming OK (known issue)");
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            ED("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            ED("Unexpected type for intent response code.");
            ED(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }
}
