package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI extends WalletBaseUI {
    private TextView glY;
    private TextView kLE;
    private String lJJ = "";
    private TextView mzG;
    private azz pEZ;
    private LinearLayout pFa;
    private LinearLayout pFb;
    private LinearLayout pFc;
    private LinearLayout pFd;
    private LinearLayout pFe;
    private LinearLayout pFf;
    private LinearLayout pFg;
    private TextView pFh;
    private TextView pFi;
    private TextView pFj;
    private TextView pFk;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1520);
        this.lJJ = this.sy.getString("key_trans_id");
        if (bi.oW(this.lJJ)) {
            x.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        a(new c(this.lJJ), true, true);
        this.pFa = (LinearLayout) findViewById(a$f.detail_transid);
        this.pFb = (LinearLayout) findViewById(a$f.detail_appname);
        this.pFc = (LinearLayout) findViewById(a$f.detail_goodsname);
        this.pFd = (LinearLayout) findViewById(a$f.detail_moneyspent);
        this.pFe = (LinearLayout) findViewById(a$f.detail_time);
        this.pFf = (LinearLayout) findViewById(a$f.detail_status);
        this.pFg = (LinearLayout) findViewById(a$f.detail_type);
        this.pFh = (TextView) findViewById(a$f.detail_transid_tv);
        this.pFi = (TextView) findViewById(a$f.detail_appname_tv);
        this.pFj = (TextView) findViewById(a$f.detail_goodsname_tv);
        this.mzG = (TextView) findViewById(a$f.detail_moneyspent_tv);
        this.kLE = (TextView) findViewById(a$f.detail_time_tv);
        this.glY = (TextView) findViewById(a$f.detail_status_tv);
        this.pFk = (TextView) findViewById(a$f.detail_type_tv);
        bRm();
    }

    private void bRm() {
        if (this.pEZ != null) {
            if (bi.oW(this.pEZ.lOE)) {
                this.pFa.setVisibility(8);
            } else {
                this.pFa.setVisibility(0);
                this.pFh.setText(this.pEZ.lOE);
            }
            if (bi.oW(this.pEZ.lOO)) {
                this.pFb.setVisibility(8);
            } else {
                this.pFb.setVisibility(0);
                this.pFi.setText(this.pEZ.lOO);
            }
            if (bi.oW(this.pEZ.lOG)) {
                this.pFc.setVisibility(8);
            } else {
                this.pFc.setVisibility(0);
                this.pFj.setText(this.pEZ.lOG);
            }
            if (bi.oW(this.pEZ.lOK)) {
                this.pFd.setVisibility(8);
            } else {
                this.pFd.setVisibility(0);
                this.mzG.setText(e.e(((double) this.pEZ.scI) / 100.0d, this.pEZ.lOK));
            }
            if (this.pEZ.lOH >= 0) {
                this.pFe.setVisibility(0);
                this.kLE.setText(e.hb(this.pEZ.lOH));
            } else {
                this.pFe.setVisibility(8);
            }
            if (bi.oW(this.pEZ.lOI)) {
                this.pFf.setVisibility(8);
            } else {
                this.pFf.setVisibility(0);
                this.glY.setText(this.pEZ.lOI);
            }
            switch (this.pEZ.lOM) {
                case 3:
                    this.pFk.setText(i.wallet_balance_manager_save);
                    return;
                case 5:
                    this.pFk.setText(i.wallet_index_ui_transfer);
                    return;
                default:
                    this.pFk.setText(i.wallet_payu_detail_type_reserve);
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (lVar instanceof c) {
            this.pEZ = ((c) lVar).pEY;
            bRm();
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1520);
    }

    protected final int getLayoutId() {
        return a$g.payu_mall_order_info_detail;
    }
}
