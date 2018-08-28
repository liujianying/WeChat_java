package com.tencent.mm.plugin.order.model;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

public final class a {
    public static e a(Context context, MallTransactionObject mallTransactionObject) {
        e eVar = new e(context);
        if (bi.oW(mallTransactionObject.lOf)) {
            eVar.lQl = context.getString(i.wallet_order_info_support_customer_service);
        } else {
            eVar.lQl = context.getString(i.wallet_order_info_support);
        }
        eVar.mOnClickListener = new 1(mallTransactionObject, context);
        return eVar;
    }

    public static void a(int i, Context context, MallTransactionObject mallTransactionObject) {
        switch (i) {
            case 0:
                g.Ek();
                ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(mallTransactionObject.lNW);
                if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                    com.tencent.mm.wallet_core.ui.e.ab(context, mallTransactionObject.lNW);
                    return;
                } else {
                    com.tencent.mm.wallet_core.ui.e.bD(context, mallTransactionObject.lNW);
                    return;
                }
            case 1:
                com.tencent.mm.wallet_core.ui.e.bE(context, mallTransactionObject.lNy);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.l(context, mallTransactionObject.lOf, false);
                return;
            default:
                return;
        }
    }
}
