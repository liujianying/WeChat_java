package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.am;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    private String lJJ;
    private Orders pfb;
    protected b.a pwB = new 1(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (brH()) {
            this.pfb = bQo();
            this.lJJ = this.sy.getString("key_trans_id");
            int i = this.sy.getInt("key_pay_type", -1);
            x.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[]{this.lJJ});
            if (this.lJJ != null) {
                if (i == -1) {
                    Pt(this.lJJ);
                } else {
                    cr(this.lJJ, i);
                }
            } else if (this.pfb != null) {
                d(this.pfb);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.pfb != null && !bi.oW(this.pfb.username)) {
            am.a.dBr.iw(this.pfb.username);
        }
    }

    protected boolean brH() {
        return true;
    }

    public Orders bQo() {
        return (Orders) this.sy.getParcelable("key_orders");
    }

    protected int getLayoutId() {
        return g.transparent_layout;
    }

    public void Pt(String str) {
        a(new z(str), true, true);
    }

    protected void cr(String str, int i) {
        a(new z(str, i), true, true);
    }

    private void d(Orders orders) {
        x.l("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[]{Integer.valueOf(orders.ppp)});
        if (orders.ppp == 1) {
            cDK().c(this, WalletOrderInfoNewUI.class, this.sy);
        } else {
            cDK().c(this, WalletOrderInfoOldUI.class, this.sy);
        }
        finish();
    }

    protected void M(ab abVar) {
        if (abVar != null && ((int) abVar.dhP) != 0) {
            String BK = abVar.BK();
            x.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + BK + " username: " + abVar.field_username);
            if (this.pfb.ppf != null && this.pfb.ppf.size() > 0) {
                for (Commodity commodity : this.pfb.ppf) {
                    commodity.lNW = BK;
                }
            }
        }
    }

    protected static String e(String str, String str2, String str3, String str4, String str5) {
        try {
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                x.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                return str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
            } else if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                x.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                return str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                x.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                return str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[]{str2, str3, str4, encode});
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
            return str;
        }
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof z) || i != 0 || i2 != 0) {
            return false;
        }
        this.pfb = ((z) lVar).pjG;
        if (this.pfb != null) {
            if (!(this.pfb.ppf == null || this.pfb.ppf.size() == 0)) {
                Commodity commodity = (Commodity) this.pfb.ppf.get(0);
                this.lJJ = commodity.bOe;
                x.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                com.tencent.mm.kernel.g.Ek();
                ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(commodity.lNW);
                if (Yg == null || ((int) Yg.dhP) == 0) {
                    am.a.dBr.a(commodity.lNW, "", this.pwB);
                } else {
                    M(Yg);
                }
            }
            d(this.pfb);
        } else {
            x.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
            h.a(this.mController.tml, com.tencent.mm.plugin.wxpay.a.i.wallet_order_info_err, 0, new 2(this));
        }
        return true;
    }
}
