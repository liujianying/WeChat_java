package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;

class MallProductReceiptUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallProductReceiptUI lSZ;

    MallProductReceiptUI$1(MallProductReceiptUI mallProductReceiptUI) {
        this.lSZ = mallProductReceiptUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i = 0;
        String obj = MallProductReceiptUI.a(this.lSZ).getText().toString();
        if (bi.oW(obj)) {
            s.makeText(this.lSZ, a$i.mall_product_receipt_empty_tips, 0).show();
        } else {
            c b = MallProductReceiptUI.b(this.lSZ);
            b.lQS = new bfm();
            bfm bfm = b.lQS;
            if (!bi.oW(obj)) {
                i = 1;
            }
            bfm.sgM = i;
            b.lQS.jQf = obj;
            this.lSZ.finish();
        }
        return true;
    }
}
