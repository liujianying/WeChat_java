package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.hh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements e {
    private String bTi;
    private ProgressDialog eHw = null;
    private String eHy;
    private String eOW;
    private String eOX;
    private boolean eOY = false;
    private Button eOZ;
    private String jumpUrl;

    protected final int getLayoutId() {
        return a$g.security_account_intro;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOW = getIntent().getStringExtra("auth_ticket");
        this.bTi = getIntent().getStringExtra("binded_mobile");
        this.eOY = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        x.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[]{bi.Xf(this.eOW), stringExtra});
        if (!bi.oW(stringExtra)) {
            Map z = bl.z(stringExtra, "wording");
            if (z != null) {
                this.eOX = (String) z.get(".wording.title");
                this.jumpUrl = (String) z.get(".wording.url");
                x.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[]{this.eOX, this.jumpUrl});
            }
        }
        this.eHy = a.Zu();
        initView();
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(145, this);
        g.DF().a(132, this);
        if (!this.eOY) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L600_100,");
            g.Eg();
            a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L600_100")).append(",1").toString());
            a.pT("L600_100");
        }
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(145, this);
        g.DF().b(132, this);
        if (!this.eOY) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L600_100,");
            g.Eg();
            a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L600_100")).append(",2").toString());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    protected final void initView() {
        setMMTitle(j.safe_device_verify_phone_title);
        findViewById(a$f.operation_btn).setOnClickListener(new 1(this));
        if (!this.eOY) {
            this.eOZ = (Button) findViewById(a$f.close_account_protect_btn);
            if (!bi.oW(this.eOX)) {
                this.eOZ.setText(this.eOX);
            }
            this.eOZ.setVisibility(0);
            this.eOZ.setOnClickListener(new 2(this));
        }
        setBackBtn(new 3(this));
    }

    private void WL() {
        a.pU(this.eHy);
        cancel();
        DT(1);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.eOY) {
                str2 = ((hh) ((com.tencent.mm.plugin.account.friend.a.x) lVar).diG.dIE.dIL).reE;
            } else {
                str2 = ((com.tencent.mm.modelfriend.a) lVar).Ok();
            }
            x.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.eOW + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.bTi);
            intent.putExtra("re_open_verify", this.eOY);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            D(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
                return;
            }
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                h.a(this, j.bind_mcontact_err_BindPhone_NeedAdjust, j.app_tip, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, j.app_err_system_busy_tip, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, j.bind_mcontact_err_format, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, j.bind_mcontact_err_freq_limit, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0 && !com.tencent.mm.plugin.account.a.a.ezo.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(j.safe_device_send_verify_code_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
