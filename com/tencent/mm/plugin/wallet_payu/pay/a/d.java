package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static Orders a(Orders orders, String str, String str2, int i, String str3) {
        if (orders == null || orders.ppf == null || orders.ppf.size() <= 0) {
            x.d("MicroMsg.OrdersWrapper", "hy: params error");
        } else {
            for (Commodity commodity : orders.ppf) {
                commodity.lNR = i;
                commodity.lNO = str.equals("1") ? "2" : "1";
                commodity.lNP = str2;
                commodity.lNT = str3;
            }
        }
        return orders;
    }
}
