package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public enum b {
    ;
    
    private Map<String, WeakReference<a>> psC;

    private b(String str) {
        this.psC = new HashMap();
    }

    public final a a(Orders orders) {
        String str;
        if (orders == null || orders.ppf == null) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= orders.ppf.size()) {
                    break;
                }
                stringBuilder.append(((Commodity) orders.ppf.get(i2)).bOe);
                i = i2 + 1;
            }
            stringBuilder.append("@");
            stringBuilder.append(orders.poN);
            str = stringBuilder.toString();
        }
        if (bi.oW(str)) {
            x.w("MicroMsg.FavorLogicHelperPool", "get key null");
            return null;
        }
        if (this.psC.containsKey(str)) {
            x.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:" + str);
            WeakReference weakReference = (WeakReference) this.psC.get(str);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    return aVar;
                }
                x.i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                x.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.ppg == null) {
            return null;
        }
        a aVar2 = new a(orders.ppg);
        this.psC.put(str, new WeakReference(aVar2));
        return aVar2;
    }
}
