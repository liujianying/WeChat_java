package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.a.a.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public int bNZ;
    public a kiO;
    private ServiceConnection kiP;
    boolean kiQ = false;
    public boolean kiR = false;
    public b kiS;
    public String kiT;
    public Context mContext;

    static /* synthetic */ int a(b bVar, Intent intent, String str) {
        x.d("MicroMsg.IabHelper", "Querying owned items, item type: " + str);
        x.d("MicroMsg.IabHelper", "Package name: " + bVar.mContext.getPackageName());
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        do {
            x.d("MicroMsg.IabHelper", "Calling getPurchases with continuation token: " + str2);
            Bundle b = bVar.kiO.b(3, bVar.mContext.getPackageName(), str, str2);
            int D = D(b);
            x.d("MicroMsg.IabHelper", "Owned items response: " + String.valueOf(D));
            if (D != 0) {
                x.d("MicroMsg.IabHelper", "getPurchases() failed: " + D);
                return D;
            } else if (b.containsKey("INAPP_PURCHASE_ITEM_LIST") && b.containsKey("INAPP_PURCHASE_DATA_LIST") && b.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                arrayList.addAll(b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST"));
                arrayList2.addAll(b.getStringArrayList("INAPP_PURCHASE_DATA_LIST"));
                arrayList3.addAll(b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST"));
                str2 = b.getString("INAPP_CONTINUATION_TOKEN");
                x.d("MicroMsg.IabHelper", "Continuation token: " + str2);
            } else {
                ED("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
        } while (!TextUtils.isEmpty(str2));
        intent.putStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST", arrayList);
        intent.putStringArrayListExtra("INAPP_PURCHASE_DATA_LIST", arrayList2);
        intent.putStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        return 0;
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final void a(final a aVar) {
        if (this.kiQ) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        x.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
        this.kiP = new ServiceConnection() {
            public final void onServiceDisconnected(ComponentName componentName) {
                x.d("MicroMsg.IabHelper", "Billing service disconnected.");
                b.this.kiO = null;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                x.d("MicroMsg.IabHelper", "Billing service connected.");
                b.this.kiO = a.a.c(iBinder);
                String packageName = b.this.mContext.getPackageName();
                try {
                    x.d("MicroMsg.IabHelper", "Checking for in-app billing 3 support.");
                    int b = b.this.kiO.b(3, packageName, "inapp");
                    if (b != 0) {
                        if (aVar != null) {
                            aVar.a(new c(b, "Error checking for billing v3 support."));
                        }
                        b.this.kiR = false;
                        return;
                    }
                    x.d("MicroMsg.IabHelper", "In-app billing version 3 supported for " + packageName);
                    int b2 = b.this.kiO.b(3, packageName, "subs");
                    if (b2 == 0) {
                        x.d("MicroMsg.IabHelper", "Subscriptions AVAILABLE.");
                        b.this.kiR = true;
                    } else {
                        x.d("MicroMsg.IabHelper", "Subscriptions NOT AVAILABLE. Response: " + b2);
                    }
                    b.this.kiQ = true;
                    if (aVar != null) {
                        aVar.a(new c(0, "Setup successful."));
                    }
                } catch (Throwable e) {
                    if (aVar != null) {
                        aVar.a(new c(-1001, "RemoteException while setting up in-app billing."));
                    }
                    x.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (this.mContext == null || this.mContext.getPackageManager() == null || this.mContext.getPackageManager().queryIntentServices(intent, 0) == null || this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            aVar.a(new c(-2001, "Google play not installed!"));
        } else {
            this.mContext.bindService(intent, this.kiP, 1);
        }
    }

    public final void dispose() {
        x.d("MicroMsg.IabHelper", "Disposing.");
        this.kiQ = false;
        if (this.kiP != null) {
            x.d("MicroMsg.IabHelper", "Unbinding from service.");
            try {
                if (this.mContext != null) {
                    this.mContext.unbindService(this.kiP);
                }
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.IabHelper", e.toString());
            }
            this.kiP = null;
            this.kiO = null;
        }
    }

    public final void EC(String str) {
        if (!this.kiQ) {
            x.e("MicroMsg.IabHelper", "Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    public final boolean a(ArrayList<String> arrayList, c cVar) {
        EC("query details");
        Intent intent = new Intent();
        c cVar2;
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.IabHelper", "query list is empty!");
            cVar2 = new c(5, "no query list or is empty");
            intent.putExtra("RESPONSE_CODE", 5);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            return true;
        }
        try {
            x.d("MicroMsg.IabHelper", "query detail list with the size is " + arrayList.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            bundle = this.kiO.a(3, this.mContext.getPackageName(), "inapp", bundle);
            int D = D(bundle);
            x.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(D));
            if (D != 0) {
                x.d("MicroMsg.IabHelper", "cannot query details");
                cVar2 = new c(D, "cannot query details");
                intent.putExtra("RESPONSE_CODE", D);
                cVar.a(cVar2, intent);
                return true;
            }
            c cVar3 = new c(D, "query list ok!");
            x.d("MicroMsg.IabHelper", "result code : " + D);
            intent.putExtra("RESPONSE_CODE", D);
            intent.putExtra("RESPONSE_QUERY_DETAIL_INFO", bundle.getStringArrayList("DETAILS_LIST"));
            cVar.a(cVar3, intent);
            Iterator it = bundle.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                x.d("MicroMsg.IabHelper", (String) it.next());
            }
            return true;
        } catch (Throwable e) {
            ED("RemoteException while launching query details ");
            x.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
            cVar2 = new c(-1001, "Remote exception while starting purchase flow");
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            return false;
        }
    }

    public static String rg(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                return String.valueOf(i) + ":Unknown IAB Helper Error";
            }
            return split2[i2];
        } else if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        } else {
            return split[i];
        }
    }

    public static int D(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            x.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            ED("Unexpected type for bundle response code.");
            ED(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    public static void ED(String str) {
        x.e("MicroMsg.IabHelper", "In-app billing error: " + str);
    }
}
