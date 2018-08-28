package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String pFw = null;
    private c pFx = new c<lp>() {
        {
            this.sFo = lp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            lp lpVar = (lp) bVar;
            x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            g gVar = new g(lpVar);
            WalletPayUChangeBankcardUI.this.sy.putString("app_id", gVar.appId);
            WalletPayUChangeBankcardUI.this.sy.putString("package", gVar.packageExt);
            WalletPayUChangeBankcardUI.this.sy.putString("timestamp", gVar.timeStamp);
            WalletPayUChangeBankcardUI.this.sy.putString("noncestr", gVar.nonceStr);
            WalletPayUChangeBankcardUI.this.sy.putString("pay_sign", gVar.bVW);
            WalletPayUChangeBankcardUI.this.sy.putString("sign_type", gVar.signType);
            WalletPayUChangeBankcardUI.this.sy.putString("url", gVar.url);
            WalletPayUChangeBankcardUI.this.sy.putBoolean("from_jsapi", true);
            WalletPayUChangeBankcardUI.this.sy.putString("key_trans_id", ((PayInfo) WalletPayUChangeBankcardUI.this.sy.getParcelable("key_pay_info")).bOd);
            WalletPayUChangeBankcardUI.this.sy.putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.j(WalletPayUChangeBankcardUI.this, WalletPayUChangeBankcardUI.this.sy);
            return true;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.sFg.b(this.pFx);
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.pFx);
    }

    protected final com.tencent.mm.plugin.wallet_core.ui.g bNB() {
        return new a(this, this.oZG, this.pfw, this.mCZ);
    }

    protected final void bNC() {
        x.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.sy.getString("key_pwd1");
        if (bi.oW(string)) {
            ux(4);
            this.oZD = b.a(this, this.mCZ, this.pfz, this.oZH, new 1(this), new OnClickListener() {
                public final void onClick(View view) {
                    if (WalletPayUChangeBankcardUI.this.oZD != null) {
                        WalletPayUChangeBankcardUI.this.oZD.dismiss();
                    }
                    WalletPayUChangeBankcardUI.this.pfx.e(WalletPayUChangeBankcardUI.this.oZG, true);
                    WalletPayUChangeBankcardUI.this.pfz = (FavorPayInfo) view.getTag();
                    if (WalletPayUChangeBankcardUI.this.pfz != null) {
                        WalletPayUChangeBankcardUI.this.pfz.pnT = "";
                    }
                    WalletPayUChangeBankcardUI.this.sy.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.pfz);
                    WalletPayUChangeBankcardUI.this.aL();
                    WalletPayUChangeBankcardUI.this.ux(0);
                }
            }, new 3(this), "CREDITCARD_PAYU".equals(this.oZH.field_bankcardType));
            return;
        }
        OQ(string);
    }

    protected final void OQ(String str) {
        String str2;
        this.pdF.pli = str;
        if (this.oZH != null) {
            this.sy.putString("key_mobile", this.oZH.field_mobile);
            this.sy.putParcelable("key_bankcard", this.oZH);
            this.pdF.lMW = this.oZH.field_bindSerial;
            this.pdF.lMV = this.oZH.field_bankcardType;
            if (this.pfz != null) {
                this.pdF.plu = this.pfz.pnP;
            } else {
                this.pdF.plu = null;
            }
            if (!(this.mCZ == null || this.mCZ.ppg == null)) {
                this.pdF.plt = this.mCZ.ppg.pdY;
            }
            if (this.mCZ != null && this.mCZ.pjA == 3) {
                boolean z;
                if (this.oZH.bOv()) {
                    this.pdF.bWA = 3;
                } else {
                    this.pdF.bWA = 6;
                }
                Bundle bundle = this.sy;
                str2 = "key_is_oversea";
                if (this.oZH.bOv()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.sy.putParcelable("key_authen", this.pdF);
        if (this.mCn.bVY == 32 || this.mCn.bVY == 31) {
            int i;
            if (this.mCn.bVY == 32) {
                x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            a(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mCn.bOd, this.eWo, this.mCn.qUL.getDouble("total_fee"), this.mCn.qUL.getString("fee_type"), i, this.mCn.qUL.getString("extinfo_key_1"), this.oZH.field_bindSerial, this.mCn.qUL.getString("extinfo_key_4")), true, false);
        } else if (this.mCn.bVY == 11) {
            String str3 = this.eWo;
            str2 = this.pFw;
            String str4 = this.mCn.bOd;
            double d = this.mCn.qUL.getDouble("total_fee");
            String string = this.mCn.qUL.getString("fee_type");
            String str5 = this.oZH.field_bindSerial;
            String str6 = this.oZH.field_bankcardType;
            p.bNp();
            a(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str3, str2, str4, d, string, str5, str6, p.bNq().paw.field_bindSerial), true, false);
        } else {
            a(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.mCn.bOd, this.mCn.qUL.getDouble("total_fee"), this.mCn.qUL.getString("fee_type"), this.oZH.field_bankcardType, this.oZH.field_bindSerial, this.pFw, str), true, true);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(lVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) && !(lVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) && !(lVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b)) {
            return false;
        }
        Bundle bundle = this.sy;
        if (!bi.oW(this.eWo)) {
            bundle.putString("key_pwd1", this.eWo);
        }
        bundle.putBoolean("key_need_verify_sms", false);
        bundle.putParcelable("key_pay_info", this.mCn);
        bundle.putInt("key_pay_flag", 3);
        if (lVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            com.tencent.mm.plugin.wallet_payu.pay.a.b bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) lVar;
            bundle.putString("transid", bVar.hTI);
            bundle.putBoolean("key_should_redirect", bVar.pFq);
            bundle.putString("key_gateway_code", bVar.pDV);
            bundle.putString("key_gateway_reference", bVar.pDU);
            bundle.putString("key_force_adjust_code", bVar.pDX);
            bundle.putBoolean("key_should_force_adjust", bVar.pFr);
            if (bVar.isSuccess()) {
                bundle.putParcelable("key_orders", d.a(this.mCZ, bVar.pFs, bVar.pFt, bVar.timestamp, bVar.psA));
            }
        }
        if (lVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
            com.tencent.mm.plugin.wallet_payu.balance.a.b bVar2 = (com.tencent.mm.plugin.wallet_payu.balance.a.b) lVar;
            bundle.putString("transid", bVar2.hTI);
            bundle.putBoolean("key_should_redirect", bVar2.pDT);
            bundle.putString("key_gateway_code", bVar2.pDV);
            bundle.putString("key_gateway_reference", bVar2.pDU);
            bundle.putString("key_force_adjust_code", bVar2.pDX);
            bundle.putBoolean("key_should_force_adjust", bVar2.pDW);
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 23351) {
            x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                this.sy.putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.j(this, this.sy);
            }
            if (i2 == 0) {
                com.tencent.mm.wallet_core.a.c(this, this.sy, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
