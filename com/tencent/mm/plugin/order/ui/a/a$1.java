package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class a$1 implements OnClickListener {
    final /* synthetic */ MallTransactionObject lNC;
    final /* synthetic */ a lQe;
    final /* synthetic */ Context val$context;

    a$1(a aVar, MallTransactionObject mallTransactionObject, Context context) {
        this.lQe = aVar;
        this.lNC = mallTransactionObject;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.lNC.lNW)) {
            e.ab(this.val$context, this.lNC.lNW);
        }
    }
}
