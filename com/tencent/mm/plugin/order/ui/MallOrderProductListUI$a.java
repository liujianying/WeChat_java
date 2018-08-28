package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem$Skus;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderProductListUI$a extends BaseAdapter {
    final /* synthetic */ MallOrderProductListUI lPE;

    private MallOrderProductListUI$a(MallOrderProductListUI mallOrderProductListUI) {
        this.lPE = mallOrderProductListUI;
    }

    /* synthetic */ MallOrderProductListUI$a(MallOrderProductListUI mallOrderProductListUI, byte b) {
        this(mallOrderProductListUI);
    }

    public final int getCount() {
        return MallOrderProductListUI.a(this.lPE).size();
    }

    private ProductSectionItem ut(int i) {
        return (ProductSectionItem) MallOrderProductListUI.a(this.lPE).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.lPE, g.mall_order_product_list_item, null);
            b bVar2 = new b(this.lPE, (byte) 0);
            bVar2.hFT = (ImageView) view.findViewById(f.item_product_logo_img);
            bVar2.lPF = (TextView) view.findViewById(f.item_product_descript_tv);
            bVar2.lPG = (TextView) view.findViewById(f.item_product_catalog_tv);
            bVar2.lPH = (TextView) view.findViewById(f.item_product_price_tv);
            bVar2.lPI = (TextView) view.findViewById(f.item_product_count_tv);
            bVar2.lPJ = (TextView) view.findViewById(f.item_product_seperator_tv);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        ProductSectionItem ut = ut(i);
        bVar.huW = ut.iconUrl;
        if (TextUtils.isEmpty(bVar.huW) || !e.abY(bVar.huW)) {
            bVar.hFT.setImageResource(h.mall_order_detail_frame);
        } else {
            bVar.hFT.setImageBitmap(y.a(new com.tencent.mm.plugin.order.c.b(bVar.huW)));
        }
        bVar.lPF.setText(ut.name);
        bVar.lPG.setText(ProductSectionItem$Skus.bD(ut.lPi));
        bVar.lPH.setText(ut.lPj);
        bVar.lPI.setText("+" + ut.count);
        y.a(bVar);
        bVar.lPJ.setVisibility(8);
        return view;
    }
}
