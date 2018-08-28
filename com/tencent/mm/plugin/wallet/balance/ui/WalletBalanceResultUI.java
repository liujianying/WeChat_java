package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class WalletBalanceResultUI extends WalletBaseUI {
    protected Button eWk;
    protected TextView kLE;
    public Orders mCZ;
    public TextView muz;
    protected TextView onV;
    public TextView paF;
    protected TextView paG;
    public CheckBox paH;
    public Bankcard paI;

    static /* synthetic */ void a(WalletBalanceResultUI walletBalanceResultUI) {
        if (walletBalanceResultUI.sy.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.sy.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceResultUI, bundle, new 2(walletBalanceResultUI));
                walletBalanceResultUI.sy.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        walletBalanceResultUI.bMY();
    }

    protected final int getLayoutId() {
        return g.wallet_balance_result_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        initView();
        aL();
    }

    public void initView() {
        setMMTitle((String) cDL().ui(0));
        this.onV = (TextView) findViewById(f.wallet_balance_result_desc);
        this.onV.setText(cDL().ui(1));
        this.paG = (TextView) findViewById(f.wallet_balance_result_time_title);
        this.kLE = (TextView) findViewById(f.wallet_balance_result_time);
        CharSequence ui = cDL().ui(2);
        if (bi.K(ui)) {
            this.paG.setVisibility(8);
            this.kLE.setVisibility(8);
        } else {
            this.paG.setVisibility(0);
            this.kLE.setVisibility(0);
            this.kLE.setText(ui);
        }
        ImageView imageView = (ImageView) findViewById(f.wallet_balance_result_logo);
        int i = this.sy.getInt("key_balance_result_logo", -1);
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(h.remittance_received);
        }
        this.muz = (TextView) findViewById(f.wallet_balance_result_bankcard);
        this.paF = (TextView) findViewById(f.wallet_balance_result_total_fee);
        TextView textView = (TextView) findViewById(f.wallet_balance_result_total_fee_title);
        if (cDK() instanceof b) {
            textView.setText(getString(i.wallet_balance_result_total_fee_fetch));
        }
        this.paH = (CheckBox) findViewById(f.bind_cb);
        this.paI = (Bankcard) this.sy.getParcelable("key_bankcard");
        if (this.paI != null) {
            this.paH.setVisibility(8);
        } else {
            this.paH.setVisibility(0);
        }
        this.eWk = (Button) findViewById(f.next_btn);
        this.eWk.setOnClickListener(new 1(this));
        showHomeBtn(false);
        enableBackMenu(false);
    }

    private void bMY() {
        if (this.paH.getVisibility() == 0 && this.paH.isChecked()) {
            PayInfo payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
            a(new com.tencent.mm.plugin.wallet.balance.a.a(this.sy.getInt("key_pay_flag", 0), this.sy.getString("key_pwd1"), this.sy.getString("key_verify_code"), payInfo.bOd, payInfo.bVY), true, true);
            return;
        }
        bMZ();
    }

    public void aL() {
        if (this.mCZ != null) {
            this.paF.setText(e.e(this.mCZ.mBj, this.mCZ.lNV));
            if (this.mCZ.ppf != null && this.mCZ.ppf.size() > 0) {
                Commodity commodity = (Commodity) this.mCZ.ppf.get(0);
                if (bi.oW(commodity.ppy)) {
                    this.muz.setText(commodity.lNT);
                } else {
                    this.muz.setText(commodity.lNT + " " + getString(i.wallet_pay_bankcard_tail) + commodity.ppy);
                }
            }
            if (!(cDK() instanceof b)) {
                return;
            }
            if (this.mCZ.mxE > 0.0d) {
                findViewById(f.wallet_balance_result_fetch_fee_title).setVisibility(0);
                TextView textView = (TextView) findViewById(f.wallet_balance_result_fetch_fee);
                textView.setText(e.e(this.mCZ.mxE, this.mCZ.lNV));
                textView.setVisibility(0);
                return;
            }
            x.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
        }
    }

    public final void bMZ() {
        if (!cDL().m(new Object[]{this.mCZ})) {
            super.bMZ();
        }
    }

    public void onBackPressed() {
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof com.tencent.mm.plugin.wallet.balance.a.a)) {
            return false;
        }
        p.bNp();
        p.bNq().prH = bi.VE();
        sz szVar = new sz();
        szVar.cdR.scene = 15;
        szVar.bJX = new Runnable() {
            public final void run() {
                x.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
            }
        };
        com.tencent.mm.sdk.b.a.sFg.m(szVar);
        bMZ();
        return true;
    }
}
