package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;

class MallProductSelectSkuUI$4 implements OnClickListener {
    final /* synthetic */ MallProductSelectSkuUI lTq;

    MallProductSelectSkuUI$4(MallProductSelectSkuUI mallProductSelectSkuUI) {
        this.lTq = mallProductSelectSkuUI;
    }

    public final void onClick(View view) {
        f d = MallProductSelectSkuUI.d(this.lTq);
        if (d.lSE) {
            s.makeText(d.ftd, i.mall_product_data_loading, 1).show();
        } else if (!d.lSG.bmT()) {
            String str;
            c cVar = d.lSG;
            if (cVar.lQX != null && cVar.lQX.size() < cVar.lQV && cVar.lQV > 0) {
                Iterator it = cVar.lQL.lRp.lRJ.iterator();
                while (it.hasNext()) {
                    m mVar = (m) it.next();
                    if (!cVar.lQX.containsKey(mVar.lRU)) {
                        str = mVar.lRV;
                        break;
                    }
                }
            }
            str = null;
            if (!bi.oW(str)) {
                s.makeText(d.ftd, d.ftd.getString(i.mall_product_select_sku_err, new Object[]{str}), 0).show();
            }
        } else if (d.lSG.lQR != null) {
            g.Ek();
            g.Eh().dpP.a(new j(d.lSG.bmV(), f.fdx), 0);
        } else {
            d.c(d.ftd, "address", ".ui.WalletAddAddressUI", 2);
        }
    }
}
