package com.tencent.mm.plugin.order.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;

class MallOrderProductListUI$1 implements OnItemClickListener {
    final /* synthetic */ MallOrderProductListUI lPE;

    MallOrderProductListUI$1(MallOrderProductListUI mallOrderProductListUI) {
        this.lPE = mallOrderProductListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.a(this.lPE).get(i);
        if (productSectionItem != null) {
            MallOrderProductListUI.a(this.lPE, productSectionItem);
            c.a(Boolean.valueOf(false), MallOrderProductListUI.b(this.lPE), MallOrderProductListUI.c(this.lPE), productSectionItem.name, productSectionItem.lPk);
        }
    }
}
