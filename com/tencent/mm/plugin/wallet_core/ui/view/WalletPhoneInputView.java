package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b$a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletPhoneInputView extends LinearLayout {
    private int mMode = 0;
    private WalletFormView pzR;
    private WalletFormView pzS;
    private TenpaySecureEditText pzT;
    private Map<String, b$a> pzU;
    private String pzV = "";
    private String pzW = "";
    private boolean pzX = true;

    public WalletPhoneInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        b(context, attributeSet, -1);
    }

    public WalletPhoneInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
        b(context, attributeSet, i);
    }

    private void init(Context context) {
        inflate(context, g.wallet_phone_input_view_layout, this);
        this.pzR = (WalletFormView) findViewById(f.phone_area_code_et);
        this.pzS = (WalletFormView) findViewById(f.phone_number_et);
        this.pzR.setOnClickListener(new 1(this));
        this.pzT = (TenpaySecureEditText) this.pzS.findViewById(f.prefix_input_et);
        this.pzT.setFixedHeaderText("+");
        if (getContext() instanceof MMActivity) {
            this.pzS.setOnInfoIvClickListener(new 2(this));
            this.pzS.setLogicDelegate(new 3(this));
        }
        List<b$a> E = b.E(getContext(), getContext().getString(a$i.country_code));
        this.pzU = new HashMap();
        for (b$a b_a : E) {
            this.pzU.put(b_a.dYx, b_a);
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$k.WalletPhoneInputViewAttrs, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(a$k.WalletPhoneInputViewAttrs_phoneHint, 0);
        if (resourceId != 0) {
            this.pzS.setHint(context.getString(resourceId));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a$k.WalletPhoneInputViewAttrs_phoneTitle, 0);
        if (resourceId2 != 0) {
            this.pzS.setTitleText(context.getString(resourceId2));
        }
    }

    public WalletFormView getPhoneNumberEt() {
        return this.pzS;
    }

    public String getCountryCode() {
        if (bQM()) {
            return "86";
        }
        return this.pzT.getText().toString();
    }

    public final boolean d(int i, int i2, Intent intent) {
        if (i != 65521) {
            return false;
        }
        if (i2 != 100) {
            return true;
        }
        String stringExtra = intent.getStringExtra("country_name");
        String stringExtra2 = intent.getStringExtra("couttry_code");
        x.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[]{this.pzV, this.pzW});
        if (bi.oW(stringExtra) || bi.oW(stringExtra2)) {
            x.i("MicroMsg.WalletPhoneInputView", "cancel pick");
            return true;
        }
        this.pzV = stringExtra;
        this.pzW = stringExtra2;
        this.pzX = false;
        bQK();
        this.pzT.clearFocus();
        return true;
    }

    private void bQK() {
        this.pzR.setText(this.pzV);
        this.pzT.setText(this.pzW);
    }

    private void bQL() {
        b$a b_a = (b$a) this.pzU.get("86");
        this.pzW = b_a.dYx;
        this.pzV = b_a.dYy;
        bQK();
    }

    public final boolean bQM() {
        return this.mMode == 0;
    }

    public final void bQN() {
        this.mMode = 0;
        bQL();
        this.pzR.setVisibility(8);
        this.pzT.setVisibility(8);
    }

    public final void bQO() {
        this.mMode = 1;
        bQL();
        this.pzR.setVisibility(0);
        this.pzT.setVisibility(0);
        this.pzT.addTextChangedListener(new 4(this));
        this.pzT.setOnFocusChangeListener(new 5(this));
    }
}
