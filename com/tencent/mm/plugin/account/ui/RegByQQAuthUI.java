package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public class RegByQQAuthUI extends MMActivity implements e {
    private String account;
    private String bLe;
    private String bWI;
    private ProgressDialog eHw = null;
    private String eIY;
    private EditText eWe = null;
    private int eWf;

    protected final int getLayoutId() {
        return g.regbyqq_auth;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.DF().a(126, this);
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.DF().b(126, this);
    }

    protected final void initView() {
        this.eWf = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.eIY = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.account = getIntent().getStringExtra("RegByQQ_Account");
        this.bLe = getIntent().getStringExtra("RegByQQ_Ticket");
        this.bWI = getIntent().getStringExtra("RegByQQ_Nick");
        x.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.eWf + "  pass:" + this.eIY + "  ticket:" + this.bLe);
        this.eWe = (EditText) findViewById(f.nick_et);
        if (!(this.bWI == null || this.bWI.equals(""))) {
            this.eWe.setText(this.bWI);
        }
        setMMTitle(j.regbyqq_auth_title);
        addTextOptionMenu(0, getString(j.app_nextstep), new 1(this));
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!bi.ci(this)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 126:
                    a.unhold();
                    at.dBv.T("login_user_name", this.account);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                    be.addFlags(67108864);
                    be.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, be);
                    return;
                default:
                    return;
            }
        }
        boolean z;
        if (lVar.getType() == 126) {
            com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
            if (eV != null) {
                eV.a(this, null, null);
                return;
            }
        }
        if (com.tencent.mm.plugin.account.a.a.ezo.a(this.mController.tml, i, i2, str)) {
            z = true;
        } else {
            if (i == 4) {
                switch (i2) {
                    case -75:
                        h.i(this.mController.tml, j.alpha_version_tip_reg, j.app_tip);
                        z = true;
                        break;
                    case -72:
                        h.i(this.mController.tml, j.regbyqq_auth_err_failed_niceqq, j.app_tip);
                        z = true;
                        break;
                    case IX5WebViewClient.ERROR_BAD_URL /*-12*/:
                        h.i(this, j.regbyqq_auth_err_uinexsit, j.regbyqq_auth_err_title);
                        z = true;
                        break;
                    case IX5WebViewClient.ERROR_FAILED_SSL_HANDSHAKE /*-11*/:
                        h.i(this, j.regbyqq_auth_err_nickinvalid, j.regbyqq_auth_err_title);
                        z = true;
                        break;
                    case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                        h.i(this, j.app_err_nouser, j.regbyqq_auth_err_title);
                        z = true;
                        break;
                    case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                        if (com.tencent.mm.kernel.g.DF().Lg() == 5) {
                            h.i(this, j.net_warn_server_down_tip, j.net_warn_server_down);
                            z = true;
                            break;
                        }
                    case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                        h.i(this, j.app_err_password, j.regbyqq_auth_err_title);
                        z = true;
                        break;
                }
            }
            z = false;
        }
        if (!z) {
            Toast.makeText(this, getString(j.fmt_reg_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
