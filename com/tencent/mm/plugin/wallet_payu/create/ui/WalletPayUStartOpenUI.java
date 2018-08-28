package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUStartOpenUI extends WalletBaseUI {
    private String eTa;
    private WalletPayUOpenIntroView pEK;
    private MMFormMobileInputView pEL;
    private EditText pEM;
    private EditText pEN;
    private Button pEO;
    private TextView pEP;
    private TextView pEQ;
    private String pER;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTa = this.sy.getString("key_mobile");
        this.pER = this.sy.getString("dial_code");
        if (bi.oW(this.pER)) {
            this.pER = "27";
        }
        this.pEK = (WalletPayUOpenIntroView) findViewById(f.intro_view);
        this.pEK.setPagerData(new d[]{new d(e.payu_open_logo_1, i.wallet_payu_start_tip_1, i.wallet_payu_start_hint_1), new d(e.payu_open_logo_2, i.wallet_payu_start_tip_2, i.wallet_payu_start_hint_2), new d(e.payu_open_logo_3, i.wallet_payu_start_tip_3, i.wallet_payu_start_hint_3)});
        this.pEL = (MMFormMobileInputView) findViewById(f.start_mobile_et);
        this.pEO = (Button) findViewById(f.start_btn);
        this.pEM = this.pEL.getCountryCodeEditText();
        this.pEN = this.pEL.getMobileNumberEditText();
        if (!bi.oW(this.eTa)) {
            this.pEN.setText(this.eTa);
        }
        if (!bi.oW(this.pER)) {
            this.pEM.setText(this.pER);
        }
        1 1 = new 1(this);
        this.pEN.addTextChangedListener(1);
        this.pEM.addTextChangedListener(1);
        this.pEO.setOnClickListener(new 2(this));
        this.pEP = (TextView) findViewById(f.start_introduction_tv);
        c.a(this, this.pEP);
        this.pEQ = (TextView) findViewById(f.start_power_tv);
        this.pEQ.setText(v.cDl());
    }

    public void onResume() {
        super.onResume();
        bRj();
    }

    private String bNr() {
        return this.pEL.getCountryCode().startsWith("+") ? this.pEL.getCountryCode().substring(1) : this.pEL.getCountryCode();
    }

    private void bRj() {
        if (this.pEL.getVisibility() == 0) {
            boolean z = (bi.oW(bNr()) || bi.oW(this.pEN.getText().toString())) ? false : true;
            if (z) {
                this.pER = bNr();
                this.eTa = this.pEL.getMobileNumber();
                this.pEO.setEnabled(true);
                return;
            }
            this.pEO.setEnabled(false);
        }
    }

    protected final boolean bND() {
        return true;
    }

    protected final int getLayoutId() {
        return g.payu_ui_startopen;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }
}
