package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;

public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener, WalletFormView$a {
    private String countryCode;
    private String dDe;
    private String dDf;
    private Button eWk;
    private TextView kyF;
    private Profession[] pjD;
    private ElementQuery pkA;
    private Profession pkB;
    private boolean pkC = false;
    private boolean pkD = false;
    private WalletFormView pku;
    private WalletFormView pkv;
    private WalletFormView pkw;
    private WalletFormView pkx;
    private CheckBox pky;
    private TextView pkz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uYO.jr(1616);
        this.pkA = (ElementQuery) this.sy.getParcelable("elemt_query");
        initView();
        a(new g(), true, false);
    }

    public void onDestroy() {
        this.uYO.js(1616);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.wallet_real_name_verify_title);
        this.eWk = (Button) findViewById(f.next_btn);
        this.pku = (WalletFormView) findViewById(f.name_et);
        this.pkv = (WalletFormView) findViewById(f.card_num_et);
        this.pkw = (WalletFormView) findViewById(f.private_profession_et);
        this.pkx = (WalletFormView) findViewById(f.private_address_et);
        this.pkz = (TextView) findViewById(f.input_tip);
        this.pku.setOnInputValidChangeListener(this);
        this.pkv.setOnInputValidChangeListener(this);
        this.pkw.setOnInputValidChangeListener(this);
        this.pkx.setOnInputValidChangeListener(this);
        this.pku.setFocusable(true);
        this.pku.getInfoIv().setVisibility(8);
        a.d(this.pkv);
        b logicDelegate = this.pkv.getLogicDelegate();
        if (logicDelegate instanceof a.a) {
            ((a.a) logicDelegate).Hf(1);
        }
        this.pkw.setOnClickListener(new 1(this));
        this.pkx.setOnClickListener(new 2(this));
        this.eWk.setOnClickListener(new 3(this));
        d(this.pkv, 1, false);
        setBackBtn(new 4(this));
        this.pky = (CheckBox) findViewById(f.agree_wx_cb);
        this.kyF = (TextView) findViewById(f.agree_tv);
        this.pky.setChecked(true);
        this.pky.setOnCheckedChangeListener(new 5(this));
        this.kyF.setOnClickListener(new 6(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (lVar instanceof d) {
            c cDK = cDK();
            Bundle bundle = null;
            if (cDK != null) {
                bundle = cDK.jfZ;
            }
            String str2 = ((d) lVar).token;
            x.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (cDK == null) {
                return true;
            }
            bundle.putString("key_real_name_token", str2);
            bundle.putString("key_country_code", this.countryCode);
            bundle.putString("key_province_code", this.dDf);
            bundle.putString("key_city_code", this.dDe);
            bundle.putParcelable("key_profession", this.pkB);
            cDK.a(this, 0, bundle);
            return true;
        } else if (lVar instanceof g) {
            g gVar = (g) lVar;
            this.pkC = gVar.pjB == 1;
            if (gVar.pjC == 1) {
                z = true;
            }
            this.pkD = z;
            if (!this.pkD) {
                this.pkw.setVisibility(8);
            }
            if (!this.pkC) {
                this.pkx.setVisibility(8);
            }
            if (this.pkC || this.pkD) {
                this.pkz.setText(i.wallet_real_name_verify_desc2);
            }
            this.pjD = gVar.pkS;
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_real_name_verify_ui;
    }

    public void onClick(View view) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.pkB = (Profession) intent.getParcelableExtra("key_select_profession");
                this.pkw.setText(this.pkB.pkT);
                return;
            }
            x.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
        } else if (i != 2) {
        } else {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("ProviceName");
                String stringExtra3 = intent.getStringExtra("CityName");
                this.countryCode = intent.getStringExtra("Country");
                this.dDf = intent.getStringExtra("Contact_Province");
                this.dDe = intent.getStringExtra("Contact_City");
                StringBuilder stringBuilder = new StringBuilder();
                if (!bi.oW(stringExtra)) {
                    stringBuilder.append(stringExtra);
                }
                if (!bi.oW(stringExtra2)) {
                    stringBuilder.append(" ").append(stringExtra2);
                }
                if (!bi.oW(stringExtra3)) {
                    stringBuilder.append(" ").append(stringExtra3);
                }
                this.pkx.setText(stringBuilder.toString());
                return;
            }
            x.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
        }
    }

    public final void fE(boolean z) {
        boolean z2;
        x.d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.pku.getText();
        String text2 = this.pkv.getText();
        if (bi.oW(text)) {
            z2 = false;
        } else if (bi.oW(text2)) {
            z2 = false;
        } else {
            if (this.pkC) {
                z2 = (bi.oW(this.countryCode) && bi.oW(this.dDf) && bi.oW(this.dDe)) ? false : true;
                if (!z2) {
                    z2 = false;
                }
            }
            z2 = (this.pkD && this.pkB == null) ? false : true;
        }
        if (z2) {
            this.eWk.setEnabled(true);
            this.eWk.setClickable(true);
            return;
        }
        this.eWk.setEnabled(false);
        this.eWk.setClickable(false);
    }
}
