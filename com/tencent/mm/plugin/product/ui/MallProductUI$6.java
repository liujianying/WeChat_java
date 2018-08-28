package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.s;

class MallProductUI$6 implements OnClickListener {
    final /* synthetic */ MallProductUI lUa;

    MallProductUI$6(MallProductUI mallProductUI) {
        this.lUa = mallProductUI;
    }

    public final void onClick(View view) {
        f e = MallProductUI.e(this.lUa);
        if (e.lSG.bmS()) {
            e.ftd.startActivity(new Intent(e.ftd, MallProductSelectSkuUI.class));
            h.mEJ.h(11008, new Object[]{e.lSG.bmO(), e.lSG.lQL.lRl, Integer.valueOf(f.fdx), Integer.valueOf(1)});
            return;
        }
        s.makeText(e.ftd, i.mall_product_data_loading, 1).show();
    }
}
