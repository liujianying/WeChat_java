package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class MallProductReceiptUI$2 implements OnItemClickListener {
    final /* synthetic */ MallProductReceiptUI lSZ;

    MallProductReceiptUI$2(MallProductReceiptUI mallProductReceiptUI) {
        this.lSZ = mallProductReceiptUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d c = MallProductReceiptUI.c(this.lSZ);
        CharSequence charSequence = (c.lRd == null || i >= c.lRd.size()) ? null : (String) c.lRd.get(i);
        x.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = " + charSequence);
        if (!bi.oW(charSequence)) {
            MallProductReceiptUI.a(this.lSZ).setText(charSequence);
        }
    }
}
