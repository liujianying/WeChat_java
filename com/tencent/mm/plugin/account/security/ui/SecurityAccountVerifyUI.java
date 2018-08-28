package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class SecurityAccountVerifyUI extends MMWizardActivity implements e {
    private al bAZ;
    private String bQX;
    private String bQZ;
    private String bTi;
    private ProgressDialog eHw = null;
    private String eHy;
    private String eOW;
    private Button eOZ;
    private EditText ePd;
    private TextView ePe;
    private TextView ePf;
    private Button ePg;
    private boolean ePh = false;

    protected final int getLayoutId() {
        return a$g.security_account_verify;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eHy = a.Zu();
        initView();
    }

    protected void onResume() {
        g.DF().a(145, this);
        g.DF().a(132, this);
        super.onResume();
        if (!this.ePh) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L600_200,");
            g.Eg();
            a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L600_200")).append(",1").toString());
            a.pT("L600_200");
        }
    }

    protected void onPause() {
        g.DF().b(145, this);
        g.DF().b(132, this);
        super.onPause();
        if (!this.ePh) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L600_200,");
            g.Eg();
            a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L600_200")).append(",2").toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.bAZ.SO();
    }

    protected final void initView() {
        this.bTi = getIntent().getStringExtra("binded_mobile");
        this.eOW = getIntent().getStringExtra("auth_ticket");
        this.ePh = getIntent().getBooleanExtra("re_open_verify", false);
        this.ePd = (EditText) findViewById(a$f.bind_mcontact_verify_num);
        this.ePe = (TextView) findViewById(a$f.mobile_number_tv);
        this.ePf = (TextView) findViewById(a$f.resend_verify_code_tips_tv);
        this.ePg = (Button) findViewById(a$f.resend_verify_code_btn);
        this.ePd.addTextChangedListener(new 1(this));
        this.ePe.setText(bi.Xc(this.bTi));
        this.ePf.setTag(Integer.valueOf(60));
        this.bAZ = new al(new 2(this), true);
        this.ePg.setOnClickListener(new 3(this));
        if (!this.ePh) {
            this.eOZ = (Button) findViewById(a$f.close_account_protect_btn);
            this.eOZ.setVisibility(0);
            this.eOZ.setOnClickListener(new 4(this));
        }
        setBackBtn(new 5(this));
        addTextOptionMenu(0, getString(j.app_nextstep), new 6(this));
        enableOptionMenu(false);
        setMMTitle(j.safe_device_input_verify_code);
        this.bAZ.J(1000, 1000);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    private void WL() {
        cancel();
        DT(1);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        Intent intent;
        switch (lVar.getType()) {
            case 132:
                if (i == 0 && i2 == 0) {
                    f.n(true, true);
                    intent = new Intent(this, MySafeDeviceListUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    finish();
                    return;
                } else if (!e(i, i2, str)) {
                    Toast.makeText(this, getString(j.safe_device_verify_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            case 145:
                com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) lVar;
                if (aVar.Oh() == 10) {
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        return;
                    }
                    x.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!e(i, i2, str)) {
                        Toast.makeText(this.mController.tml, getString(j.safe_device_send_verify_code_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                } else if (aVar.Oh() != 11) {
                    x.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[]{Integer.valueOf(aVar.Oh()), Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.eOW = aVar.Ok();
                    x.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.eOW);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    intent2.putExtra("binded_mobile", this.bTi);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.eOW);
                            com.tencent.mm.plugin.account.a.a.ezn.a(this, intent2, null);
                            finish();
                            return;
                        case 3:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.eOW);
                            Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            intent = (Intent) tob.get(stringExtra);
                            tob.clear();
                            if (intent != null) {
                                com.tencent.mm.plugin.account.a.a.ezn.a(this, intent2, intent);
                            } else {
                                com.tencent.mm.plugin.account.a.a.ezn.a(this, intent2, null);
                            }
                            finish();
                            return;
                        default:
                            DT(1);
                            return;
                    }
                } else {
                    x.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!e(i, i2, str)) {
                        Toast.makeText(this.mController.tml, getString(j.safe_device_verify_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private boolean e(int i, int i2, String str) {
        if (com.tencent.mm.plugin.account.a.a.ezo.a(this.mController.tml, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -74:
                h.a(this.mController.tml, j.bind_mcontact_err_BindPhone_NeedAdjust, j.app_tip, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.mController.tml, j.app_err_system_busy_tip, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mController.tml, j.bind_mcontact_err_format, 0).show();
                return true;
            case -34:
                Toast.makeText(this, j.bind_mcontact_err_freq_limit, 0).show();
                return true;
            case -33:
                h.a(this.mController.tml, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip, null);
                return true;
            case -32:
                h.a(this.mController.tml, j.bind_mcontact_verify_err_unmatch_content, j.bind_mcontact_verify_tip, null);
                return true;
            default:
                return false;
        }
    }
}
