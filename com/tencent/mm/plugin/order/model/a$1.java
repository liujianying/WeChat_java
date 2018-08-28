package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class a$1 implements OnClickListener {
    final /* synthetic */ MallTransactionObject lNC;
    final /* synthetic */ Context val$context;

    a$1(MallTransactionObject mallTransactionObject, Context context) {
        this.lNC = mallTransactionObject;
        this.val$context = context;
    }

    public final void onClick(View view) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        if (!bi.oW(this.lNC.lNW)) {
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(this.val$context.getString(i.wallet_order_info_support_biz));
        }
        if (!bi.oW(this.lNC.lNy)) {
            linkedList2.add(Integer.valueOf(1));
            linkedList.add(this.val$context.getString(i.wallet_order_info_support_call));
        }
        if (!bi.oW(this.lNC.lOf)) {
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(this.val$context.getString(i.wallet_order_info_support_safeguard));
        }
        if (linkedList2.size() == 1) {
            a.a(((Integer) linkedList2.get(0)).intValue(), this.val$context, this.lNC);
            return;
        }
        h.a(this.val$context, null, linkedList, linkedList2, null, true, new 1(this));
    }
}
