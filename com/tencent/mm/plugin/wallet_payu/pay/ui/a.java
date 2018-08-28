package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.g;
import java.util.ArrayList;

public final class a extends g {
    public a(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        super(context, arrayList, i, orders);
    }

    public final int getCount() {
        return (this.oZG == null || this.oZG.size() == 0) ? 1 : this.oZG.size();
    }

    /* renamed from: ze */
    public final Bankcard getItem(int i) {
        if (this.oZG != null && this.oZG.size() != 0) {
            return (Bankcard) this.oZG.get(i);
        }
        if (i != getCount() - 1) {
            return (Bankcard) this.oZG.get(i);
        }
        return null;
    }
}
