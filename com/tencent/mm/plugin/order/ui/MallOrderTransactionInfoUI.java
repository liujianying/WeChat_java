package com.tencent.mm.plugin.order.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected f gua;
    private int lQa;
    private MallTransactionObject lQb = null;
    private c lQc;

    public void onCreate(Bundle bundle) {
        String string;
        String str;
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c af = a.af(this);
        String string2;
        if (af != null && (af instanceof com.tencent.mm.plugin.order.a.a)) {
            string2 = bmD().getString("key_trans_id");
            string = bmD().getString("bill_id");
            str = string2;
        } else if (getIntent().getIntExtra("scene", 0) == 1 || getIntent().getIntExtra("scene", 0) == 2) {
            string2 = getIntent().getStringExtra("trans_id");
            string = getIntent().getStringExtra("bill_id");
            str = string2;
        } else {
            string = null;
            str = null;
        }
        if (bi.oW(str)) {
            x.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            h.a(this.mController.tml, a$i.wallet_order_info_err, 0, new 1(this));
        }
        this.lQa = bmD().getInt("key_pay_type");
        initView();
        cDP().a(new com.tencent.mm.plugin.order.model.h(str, string), true, 1);
    }

    protected final void initView() {
        setMMTitle(a$i.mall_order_detail_ui_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MallOrderTransactionInfoUI.this.finish();
                return false;
            }
        });
        this.gua = this.tCL;
        this.lQc = new c(this);
        this.lQc.init();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lQc != null) {
            this.lQc.release();
        }
    }

    protected final int getLayoutId() {
        return g.mall_order_ui;
    }

    public final int Ys() {
        return l.mall_order_preference;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final boolean h(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (lVar instanceof com.tencent.mm.plugin.order.model.h) {
            MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) lVar).lOC;
            if (mallOrderDetailObject != null) {
                List list;
                this.lQb = mallOrderDetailObject.lNr;
                this.gua.removeAll();
                ActionBarActivity actionBarActivity = this.mController.tml;
                f fVar = this.gua;
                MallTransactionObject mallTransactionObject = this.lQb;
                Object[] objArr = new Object[]{this.lQc};
                if (mallTransactionObject == null) {
                    list = null;
                } else {
                    com.tencent.mm.plugin.order.model.a.a bVar;
                    switch (mallTransactionObject.lNG) {
                        case 21:
                            bVar = new b();
                            break;
                        default:
                            bVar = new com.tencent.mm.plugin.order.ui.a.a();
                            if (objArr[0] instanceof c) {
                                ((com.tencent.mm.plugin.order.ui.a.a) bVar).lQc = (c) objArr[0];
                                break;
                            }
                            break;
                    }
                    list = bVar.a(actionBarActivity, fVar, mallTransactionObject);
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        this.gua.a((Preference) list.get(i3));
                    }
                }
                this.gua.notifyDataSetChanged();
            }
        }
        return true;
    }

    private Bundle bmD() {
        Bundle ae = a.ae(this);
        if (ae == null) {
            return new Bundle();
        }
        return ae;
    }
}
