package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.account.friend.a.r$a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private String eHy;
    private TextView ePN;
    private TextView ePO;
    private MMAutoSwitchEditTextView ePP;
    private Button ePQ;
    private Button ePR;
    private String ePS;
    private String ePT;
    private String ePU;
    private String ePV;
    private boolean ePW = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.eHy = a.Zu();
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(481, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R500_200,");
        g.Eg();
        a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R500_200")).append(",1").toString());
        a.pT("R500_200");
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(481, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R500_200,");
        g.Eg();
        a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R500_200")).append(",2").toString());
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.verify_email_address;
    }

    protected final void initView() {
        setMMTitle(j.regby_email_verify_email);
        this.ePN = (TextView) findViewById(f.verify_email_hint);
        this.ePN.setText(Html.fromHtml(getString(j.regby_email_input_verify_tip)));
        this.ePO = (TextView) findViewById(f.email_address);
        this.ePS = getIntent().getStringExtra("email_address");
        if (bi.oW(this.ePS)) {
            x.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.ePO.setText(this.ePS);
        }
        this.ePU = getIntent().getStringExtra("password");
        this.ePT = getIntent().getStringExtra("email_login_page");
        x.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[]{this.ePS, this.ePT});
        this.ePP = (MMAutoSwitchEditTextView) findViewById(f.auto_switch_ll);
        this.ePP.setOnInputFinished(new 1(this));
        this.ePP.setOnTextChanged(new b() {
            public final void Yu() {
                EmailVerifyUI.this.enableOptionMenu(false);
            }
        });
        this.ePR = (Button) findViewById(f.re_send_verify_code_btn);
        this.ePR.setOnClickListener(new 3(this));
        this.ePQ = (Button) findViewById(f.open_browser_btn);
        if (bi.oW(this.ePT) || bi.oW(this.ePS)) {
            this.ePQ.setVisibility(8);
        } else {
            this.ePQ.setVisibility(0);
            this.ePQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    bi.L(EmailVerifyUI.this, EmailVerifyUI.this.ePT);
                }
            });
        }
        setBackBtn(new 5(this));
        addTextOptionMenu(0, getString(j.app_nextstep), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmailVerifyUI.this.ePV = EmailVerifyUI.this.ePP.getText();
                if (bi.oW(EmailVerifyUI.this.ePV) || EmailVerifyUI.this.ePV.length() != 12) {
                    EmailVerifyUI.this.enableOptionMenu(false);
                } else {
                    EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.this.ePV);
                }
                return true;
            }
        });
        enableOptionMenu(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        a.pU(this.eHy);
        finish();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.ePW = false;
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() != 481) {
            x.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(lVar.getType())});
            return;
        }
        int i3 = ((r$a) ((z) lVar).dJM.KV()).eKz.rfe;
        StringBuilder stringBuilder;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, j.regby_email_err_freq_limit, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        h.a(this, j.regby_email_err_time_out_content, j.regby_email_err_tip_title, null);
                        i4 = 1;
                        break;
                    case -32:
                        h.a(this, j.regby_email_err_unmatch_content, j.regby_email_err_tip_title, null);
                        stringBuilder = new StringBuilder();
                        g.Eg();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R500_260,");
                        g.Eg();
                        a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R500_260")).append(",3").toString());
                        i4 = 1;
                        break;
                    default:
                        boolean i42 = false;
                        break;
                }
            }
            i42 = 1;
            if (i42 != 0) {
                return;
            }
            if (i3 == 2) {
                Toast.makeText(this, getString(j.regby_email_verify_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i3 == 1) {
                Toast.makeText(this, getString(j.regby_email_send_verify_code_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (i3 == 2) {
            a.pU("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((r.b) ((z) lVar).dJM.Id()).eKA.rwj);
            intent.putExtra("regsetinfo_user", this.ePS);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((z) lVar).Ro());
            intent.putExtra("regsetinfo_pwd", this.ePU);
            intent.putExtra("regsetinfo_bind_email", this.ePS);
            startActivity(intent);
        } else if (i3 == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
            g.Eg();
            a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R22_resend_email_code_alert")).append(",3").toString());
            h.bA(this, getString(j.regby_email_send_verify_code_ok));
        } else {
            x.e("MicroMsg.EmailVerifyUI", "err opcode");
        }
    }
}
