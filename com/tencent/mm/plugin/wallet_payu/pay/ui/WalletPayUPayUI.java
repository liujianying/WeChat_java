package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.td;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_payu.balance.a.b;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String pFw = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
    }

    protected final void bNK() {
        a(new c(bNW().bOd), bNW().qUJ, false);
        a(new com.tencent.mm.plugin.wallet_core.c.b.a(bNW().bOd), bNW().qUJ, false);
    }

    protected final void bNC() {
        if (ZB()) {
            x.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.oZD = b.a(this, this.mCZ, this.pfz, this.oZH, new 1(this), new 2(this), new 3(this), "CREDITCARD_PAYU".equals(this.oZH.field_bankcardType));
        }
    }

    protected final void J(Bundle bundle) {
        boolean z = true;
        this.pgn = true;
        if (this.mCZ != null) {
            bundle.putInt("key_support_bankcard", this.mCZ.pjA);
        }
        String str = "key_is_oversea";
        if (bNP()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a(this, e.class, bundle);
    }

    protected final void jp(boolean z) {
        if (this.mCn.bVY == 32 || this.mCn.bVY == 31) {
            int i;
            if (this.mCn.bVY == 32) {
                x.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            a(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mCn.bOd, this.eWo, this.mCn.qUL.getDouble("total_fee"), this.mCn.qUL.getString("fee_type"), i, this.mCn.qUL.getString("extinfo_key_1"), this.oZH.field_bindSerial, this.mCn.qUL.getString("extinfo_key_4")), true, false);
        } else if (this.mCn.bVY == 11) {
            String str = this.eWo;
            String str2 = this.pFw;
            String str3 = this.mCn.bOd;
            double d = this.mCn.qUL.getDouble("total_fee");
            String string = this.mCn.qUL.getString("fee_type");
            String str4 = this.oZH.field_bindSerial;
            String str5 = this.oZH.field_bankcardType;
            p.bNp();
            a(new b(str, str2, str3, d, string, str4, str5, p.bNq().paw.field_bindSerial), true, false);
        } else {
            a(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.mCn.bOd, this.mCn.qUL.getDouble("total_fee"), this.mCn.qUL.getString("fee_type"), this.oZH.field_bankcardType, this.oZH.field_bindSerial, this.pFw, this.eWo), true, true);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        int i3 = 0;
        com.tencent.mm.plugin.wallet_payu.pay.a.b bVar;
        if (i == 0 && i2 == 0) {
            Bundle bundle;
            if (lVar instanceof c) {
                this.mCZ = ((c) lVar).mCZ;
                if (this.mCZ != null) {
                    i3 = this.mCZ.ppf.size();
                }
                this.mCount = i3;
                x.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.mCZ != null ? Integer.valueOf(this.mCZ.pjA) : ""));
                ZB();
                if (!(this.mCZ == null || this.mCZ.ppf == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.mCZ.ppf) {
                        if (bi.oW(commodity.bOe)) {
                            commodity.bOe = this.mCn.bOd;
                        }
                        linkedList.add(commodity.bOe);
                    }
                    if (linkedList.size() > 0) {
                        td tdVar = new td();
                        tdVar.ceE.ceG = linkedList;
                        com.tencent.mm.sdk.b.a.sFg.m(tdVar);
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putDouble("total_fee", this.mCZ.mBj);
                    bundle2.putString("fee_type", "ZAR");
                    if (this.mCn.qUL == null) {
                        this.mCn.qUL = bundle2;
                    } else {
                        this.mCn.qUL.putAll(bundle2);
                    }
                }
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
                p.bNp();
                this.oZG = p.bNq().jl(bNz());
                p.bNp();
                this.oZH = p.bNq().a(null, null, bNz(), false);
                this.mAE.setClickable(true);
                if (!(this.mCZ == null || this.oZG == null || this.mCn == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.mCn, this.mCZ);
                    h hVar = h.mEJ;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.mCn.bVY);
                    objArr[1] = Integer.valueOf(0);
                    p.bNp();
                    objArr[2] = Integer.valueOf(p.bNq().bPs() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.mCZ.mBj * 100.0d));
                    objArr[4] = this.mCZ.lNV;
                    hVar.h(10690, objArr);
                }
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) lVar;
                bundle = this.sy;
                bundle.putParcelable("key_pay_info", this.mCn);
                bundle.putParcelable("key_bankcard", this.oZH);
                bundle.putString("key_bank_type", this.oZH.field_bankcardType);
                if (!bi.oW(this.eWo)) {
                    bundle.putString("key_pwd1", this.eWo);
                }
                bundle.putString("kreq_token", bVar.blM());
                bundle.putParcelable("key_authen", bNO());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.oZH.field_mobile);
                if (bVar.isSuccess()) {
                    bundle.putParcelable("key_orders", d.a(this.mCZ, bVar.pFs, bVar.pFt, bVar.timestamp, bVar.psA));
                }
                this.sy.putBoolean("key_should_redirect", bVar.pFq);
                this.sy.putString("key_gateway_code", bVar.pDV);
                this.sy.putString("key_gateway_reference", bVar.pDU);
                this.sy.putBoolean("key_should_force_adjust", bVar.pFr);
                this.sy.putString("key_force_adjust_code", bVar.pDX);
                bundle.putInt("key_pay_flag", 3);
                J(bundle);
                return true;
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) lVar;
                bundle = this.sy;
                bundle.putParcelable("key_pay_info", this.mCn);
                bundle.putParcelable("key_bankcard", this.oZH);
                bundle.putString("key_bank_type", this.oZH.field_bankcardType);
                if (!bi.oW(this.eWo)) {
                    bundle.putString("key_pwd1", this.eWo);
                }
                bundle.putString("kreq_token", aVar.blM());
                bundle.putParcelable("key_authen", bNO());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.oZH.field_mobile);
                bundle.putParcelable("key_orders", this.mCZ);
                bundle.putInt("key_pay_flag", 3);
                J(bundle);
                return true;
            }
            aL();
            return true;
        }
        if (lVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) lVar;
                    this.pgr = this.sy;
                    this.pgr.putParcelable("key_pay_info", this.mCn);
                    this.pgr.putParcelable("key_bankcard", this.oZH);
                    if (!bi.oW(this.eWo)) {
                        this.pgr.putString("key_pwd1", this.eWo);
                    }
                    this.pgr.putString("kreq_token", bVar.blM());
                    this.pgr.putString("key_mobile", this.oZH.field_mobile);
                    this.pgr.putInt("key_err_code", i2);
                    this.pgr.putParcelable("key_orders", this.mCZ);
                    if (bi.oW(str)) {
                        string = getString(a$i.wallet_pay_reset_info_tips);
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.h.a(this, string, "", getString(a$i.wallet_pay_reset_info), getString(a$i.app_cancel), new 4(this), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (WalletPayUPayUI.this.bbR()) {
                                WalletPayUPayUI.this.finish();
                            }
                        }
                    });
                    return true;
                case 404:
                    if (!(this.oZH == null || this.mCZ == null)) {
                        this.oZH.plU = this.mCZ.bOd;
                        if (this.oZG == null || this.oZG.size() <= 1) {
                            b(true, 4, str);
                            return true;
                        }
                        c(true, 4, str);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
