package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

@a(3)
public class WalletIdCardCheckUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView.a {
    private WalletFormView phM;
    private TextView phN;
    private TextView phO;
    private Button phP;
    private int phQ = 1;

    static /* synthetic */ boolean a(WalletIdCardCheckUI walletIdCardCheckUI) {
        boolean z = true;
        if (!walletIdCardCheckUI.phM.dX(walletIdCardCheckUI.phO)) {
            walletIdCardCheckUI.phO.setText(i.wallet_card_identify_err_hint);
            walletIdCardCheckUI.phO.setTextColor(walletIdCardCheckUI.getResources().getColor(a$c.red));
            z = false;
        }
        if (z) {
            walletIdCardCheckUI.phO.setVisibility(4);
        } else {
            walletIdCardCheckUI.phO.setVisibility(0);
        }
        return z;
    }

    protected final int getLayoutId() {
        return g.wallet_check_id_card;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_password_setting_digitalcert_install_title);
        jr(1580);
        initView();
        setBackBtn(new 1(this));
    }

    protected final void baT() {
        x.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
        this.uYO.baT();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        js(1580);
    }

    protected final void initView() {
        String Q;
        this.phM = (WalletFormView) findViewById(f.identity_et);
        this.phO = (TextView) findViewById(f.wallet_card_identify_err_hint);
        this.phN = (TextView) findViewById(f.wallet_card_identify_tipmsg);
        this.phM.setOnInputValidChangeListener(this);
        this.phM.setOnEditorActionListener(this);
        this.phO.setVisibility(4);
        this.phP = (Button) findViewById(f.install_query);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.phM);
        d(this.phM, 1, false);
        this.phP.setOnClickListener(new 2(this));
        this.phQ = o.bOW().bPy();
        ag bOW = o.bOW();
        String str = bOW.prA != null ? bOW.prA.field_cre_name : "";
        x.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[]{Integer.valueOf(this.phQ), str});
        if (bi.oW(str)) {
            Q = o.bPe().Q(this, this.phQ);
        } else {
            Q = str;
        }
        WalletFormView walletFormView = this.phM;
        int i = this.phQ;
        b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).Hf(i);
        }
        this.phM.setTitleText(Q);
        this.phM.bqn();
        if (this.phQ == 1) {
            d(this.phM, 1, false);
        } else {
            d(this.phM, 1, true);
        }
        str = o.bOW().aCl();
        this.phM.setHint(getString(i.wallet_password_setting_digitalcert_hint, new Object[]{e.acc(str)}));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.kMk == null || !this.kMk.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.kMk.setVisibility(8);
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final boolean k(int i, int i2, String str, l lVar) {
        x.d("Micromsg.WalletIdCardCheckUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0 && (lVar instanceof com.tencent.mm.wallet_core.c.g)) {
            h.a(this, getString(i.wallet_password_setting_digitalcert_install_ok), "", getString(i.wallet_i_know_it), false, new 3(this));
        }
        return true;
    }

    public final void fE(boolean z) {
        this.phO.setVisibility(4);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
