package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
    private Button eUb;
    private TextView gmo;
    private Orders mCZ;
    private Bankcard paI;
    private WalletFormView pdA;
    private WalletFormView pdB;
    private WalletFormView pdC;
    private WalletFormView pdD;
    private WalletPhoneInputView pdE;
    private Authen pdF;
    private ElementQuery pdG;

    protected final int getLayoutId() {
        return g.wallet_reset_info_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        this.gmo = (TextView) findViewById(f.wallet_reset_info_tips);
        Bankcard bankcard = (Bankcard) this.sy.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.sy.getParcelable("key_bankcard");
        }
        this.paI = bankcard;
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        this.pdF = (Authen) this.sy.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.sy.getString("key_pwd1", ""))) {
            this.sy.putString("key_pwd1", this.pdF.pli);
            x.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.pdG = (ElementQuery) this.sy.getParcelable("elemt_query");
        this.pdE = (WalletPhoneInputView) findViewById(f.mobile_new_et);
        this.pdD = this.pdE.getPhoneNumberEt();
        if (this.paI.pml == 1) {
            this.pdE.bQO();
        } else {
            this.pdE.bQN();
        }
        EditText editText = (EditText) this.pdE.findViewById(f.prefix_input_et);
        d(this.pdE.getPhoneNumberEt(), 0, false);
        a(this.pdE.getPhoneNumberEt(), editText, 0, false, false, true);
        this.pdA = (WalletFormView) findViewById(f.bankcard_et);
        this.pdB = (WalletFormView) findViewById(f.date_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.pdB);
        this.pdC = (WalletFormView) findViewById(f.cvv_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.pdC);
        this.pdB.setOnInputValidChangeListener(this);
        this.pdC.setOnInputValidChangeListener(this);
        this.pdD.setOnInputValidChangeListener(this);
        MMScrollView mMScrollView = (MMScrollView) findViewById(f.wallet_sv);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.paI != null) {
            this.pdA.setText(this.paI.field_desc);
        } else {
            this.pdA.setVisibility(8);
        }
        bNo();
        if (bNn()) {
            a(new t("", "", null), true, false);
        }
    }

    private boolean bNn() {
        return this.sy.getInt("key_err_code", TbsListener$ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH) == TbsListener$ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH && this.pdG == null;
    }

    private void bNo() {
        switch (this.sy.getInt("key_err_code", TbsListener$ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH)) {
            case 402:
                setMMTitle(i.wallet_reset_cvv_title);
                this.pdC.setVisibility(0);
                this.gmo.setText(i.wallet_reset_cvv_tips);
                break;
            case TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR /*403*/:
                setMMTitle(i.wallet_reset_valid_date_title);
                this.pdB.setVisibility(0);
                this.gmo.setText(i.wallet_reset_valid_date_tips);
                break;
            default:
                if (this.sy.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    setMMTitle(i.wallet_reset_mobile_title);
                    this.pdE.setVisibility(0);
                } else {
                    setMMTitle(i.wallet_reset_mobile_info_tips);
                }
                if (this.paI != null) {
                    x.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[]{this.paI.field_bankPhone});
                    this.gmo.setText(String.format(getString(i.wallet_reset_mobile_tips), new Object[]{this.paI.field_bankPhone}));
                }
                if (this.pdG == null && this.paI != null) {
                    this.pdG = o.bPe().OW(this.paI.field_bankcardType);
                }
                if (this.pdG != null && this.pdG.pno) {
                    this.pdC.setVisibility(0);
                }
                if (this.pdG != null && this.pdG.pnp) {
                    this.pdB.setVisibility(0);
                    break;
                }
        }
        this.eUb = (Button) findViewById(f.next_btn);
        this.eUb.setOnClickListener(new 1(this));
        ZB();
        if (bNn()) {
            ux(4);
        } else {
            ux(0);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.sy;
            if ((lVar instanceof b) || (lVar instanceof c)) {
                b bVar = (b) lVar;
                bundle.putBoolean("key_need_verify_sms", !bVar.pfa);
                bundle.putString("kreq_token", bVar.token);
                if (bVar.pgm) {
                    bundle.putParcelable("key_orders", bVar.pfb);
                }
                RealnameGuideHelper realnameGuideHelper = bVar.lJN;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                bundle.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.j(this, bundle);
                return true;
            } else if ((lVar instanceof t) && this.paI != null) {
                this.pdG = o.bPe().OX(this.paI.field_bindSerial);
                bNo();
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.pdE.d(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    private boolean ZB() {
        boolean z;
        if (this.pdB.dX(null)) {
            z = true;
        } else {
            z = false;
        }
        if (this.pdE.getVisibility() == 0 && this.pdE.bQM() && !this.pdD.dX(null)) {
            z = false;
        }
        if (!this.pdC.dX(null)) {
            z = false;
        }
        if (this.mCZ == null || this.pdF == null) {
            z = false;
        }
        if (z) {
            this.eUb.setEnabled(true);
            this.eUb.setClickable(true);
        } else {
            this.eUb.setEnabled(false);
            this.eUb.setClickable(false);
        }
        return z;
    }

    public final void fE(boolean z) {
        ZB();
    }
}
