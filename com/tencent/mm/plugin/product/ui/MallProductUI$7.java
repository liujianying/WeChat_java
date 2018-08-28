package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

class MallProductUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ MallProductUI lUa;

    MallProductUI$7(MallProductUI mallProductUI) {
        this.lUa = mallProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String[] stringArray = this.lUa.getResources().getStringArray(b.mall_product_share_opt_list);
        List arrayList = new ArrayList();
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        boolean z = (this.lUa.lSG.bmI().lSC & 1) > 0;
        x.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = " + z);
        if (z) {
            arrayList.add(this.lUa.getString(i.mall_product_seller_opt));
        }
        h.a(this.lUa.mController.tml, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new 1(this));
        return true;
    }
}
