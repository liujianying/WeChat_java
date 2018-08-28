package com.tencent.mm.plugin.order.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderDetailInfoUI$1 implements OnClickListener {
    final /* synthetic */ MallOrderDetailInfoUI lPC;

    MallOrderDetailInfoUI$1(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        this.lPC = mallOrderDetailInfoUI;
    }

    public final void onClick(View view) {
        if (view.getId() == f.order_latest_status_info_layout) {
            if (this.lPC.lOC.lNs != null) {
                c.aD(this.lPC, this.lPC.lOC.lNs.jOU);
                MallOrderDetailInfoUI.a(this.lPC, this.lPC.lOC.lNs.lNA);
            }
        } else if (view.getId() == f.order_product_item_text_x4 || view.getId() == f.order_product_item_text_x1) {
            if (this.lPC.lOC.lNt != null && this.lPC.lOC.lNt.size() > 0) {
                boolean z;
                if (TextUtils.isEmpty(((ProductSectionItem) this.lPC.lOC.lNt.get(0)).jumpUrl)) {
                    z = false;
                } else {
                    z = c.aD(this.lPC, ((ProductSectionItem) this.lPC.lOC.lNt.get(0)).jumpUrl);
                }
                if (!z) {
                    c.aE(this.lPC, ((ProductSectionItem) this.lPC.lOC.lNt.get(0)).lPk);
                }
                MallOrderDetailInfoUI.a(this.lPC, ((ProductSectionItem) this.lPC.lOC.lNt.get(0)).name);
            }
        } else if (view.getId() == f.order_product_item_icon_text_x4) {
            Bundle bundle = this.lPC.sy;
            bundle.putParcelableArrayList("order_product_list", this.lPC.lOC.lNt);
            bundle.putInt("key_enter_id", 0);
            bundle.putString("key_trans_id", MallOrderDetailInfoUI.a(this.lPC));
            bundle.putString("appname", this.lPC.lOC.bPg);
            a.j(this.lPC, new Bundle());
            MallOrderDetailInfoUI.a(this.lPC, this.lPC.getResources().getString(a$i.mall_order_products_list_ui_title));
        } else if (view.getId() == f.order_transaction_info_parent_layout) {
            String string = this.lPC.sy.getString("key_trans_id");
            Bundle bundle2 = this.lPC.sy;
            bundle2.putString("key_trans_id", string);
            bundle2.putInt("key_enter_id", 1);
            if (this.lPC.lOC != null) {
                bundle2.putParcelable("transaction_data", this.lPC.lOC.lNr);
            }
            a.j(this.lPC, bundle2);
            MallOrderDetailInfoUI.a(this.lPC, this.lPC.getResources().getString(a$i.mall_order_merchant_info_text));
        } else if (view.getId() == f.order_confirm_result_btn) {
            MallOrderDetailInfoUI.b(this.lPC);
        } else if (view.getId() == f.hot_contact_phone_title_tv) {
            if (this.lPC.lOC != null && this.lPC.lOC.lNy != null) {
                this.lPC.lPn = this.lPC.lOC.lNy;
                MallOrderDetailInfoUI.c(this.lPC);
                MallOrderDetailInfoUI.a(this.lPC, this.lPC.getResources().getString(a$i.mall_order_hot_phone_text));
            }
        } else if (view.getId() == f.wx_contact_service_title_tv) {
            e.ac(this.lPC, this.lPC.lOC.bPg);
            MallOrderDetailInfoUI.a(this.lPC, this.lPC.getResources().getString(a$i.mall_order_wx_service_text));
        }
    }
}
