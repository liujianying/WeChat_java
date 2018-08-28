package com.tencent.mm.plugin.order.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private String dxK = "";
    private List<ProductSectionItem> gxb = new ArrayList();
    private BaseAdapter hAv;
    private String hTI = "";
    private ListView lPD;

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        if (!c.aD(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.aE(mallOrderProductListUI, productSectionItem.lPk);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.mall_order_product_list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(0);
        initView();
    }

    @Deprecated
    protected final void initView() {
        setMMTitle(i.mall_order_products_list_ui_title);
        Bundle bundle = this.sy;
        Collection parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.gxb.clear();
            this.gxb.addAll(parcelableArrayList);
        }
        this.hTI = bundle.getString("key_trans_id");
        this.dxK = bundle.getString("appname");
        this.lPD = (ListView) findViewById(f.order_product_list);
        this.hAv = new a(this, (byte) 0);
        this.lPD.setAdapter(this.hAv);
        this.hAv.notifyDataSetChanged();
        this.lPD.setOnItemClickListener(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.af(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.ac(this);
        }
        return true;
    }
}
