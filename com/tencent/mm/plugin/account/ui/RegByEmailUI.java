package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.k;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.h;
import java.util.Map;
import org.xwalk.core.XWalkResourceClient;

public class RegByEmailUI extends MMActivity implements e {
    private static String[] eUF;
    private String csD;
    private ProgressDialog eHw = null;
    private String eHy;
    private String eIY;
    private MMAutoCompleteTextView eUA;
    private EditText eUB;
    private CheckBox eUC;
    private String eUD;
    private Map<String, String> eUE;

    static /* synthetic */ void b(RegByEmailUI regByEmailUI) {
        if (bi.oW(regByEmailUI.eUA.getText().toString().trim()) || bi.oW(regByEmailUI.eUB.getText().toString().trim()) || !regByEmailUI.eUC.isChecked()) {
            regByEmailUI.enableOptionMenu(false);
        } else {
            regByEmailUI.enableOptionMenu(true);
        }
    }

    static /* synthetic */ void c(RegByEmailUI regByEmailUI) {
        regByEmailUI.csD = regByEmailUI.eUA.getText().toString().trim();
        regByEmailUI.eIY = regByEmailUI.eUB.getText().toString();
        if (bi.oW(regByEmailUI.csD)) {
            h.i(regByEmailUI, j.regby_email_null_email, j.regby_email_err_tip_title);
        } else if (!bi.WF(regByEmailUI.csD)) {
            h.i(regByEmailUI, j.regby_email_invaild_email, j.regby_email_err_tip_title);
        } else if (bi.oW(regByEmailUI.eIY)) {
            h.i(regByEmailUI, j.regby_email_null_password, j.regby_email_err_tip_title);
        } else if (bi.WH(regByEmailUI.eIY)) {
            regByEmailUI.YC();
            z zVar = new z(regByEmailUI.csD, regByEmailUI.eIY);
            g.DF().a(zVar, 0);
            regByEmailUI.getString(j.app_tip);
            regByEmailUI.eHw = h.a(regByEmailUI, regByEmailUI.getString(j.app_waiting), true, new 3(regByEmailUI, zVar));
        } else {
            h.i(regByEmailUI, j.verify_password_tip, j.regby_email_err_tip_title);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(j.regby_email_title);
        if (d.qVQ) {
            string = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(string);
        a.ezo.vo();
        this.eUD = x.cg(this);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[]{this.eUD});
        this.eUE = k.evQ.bY(this);
        if (!(this.eUE == null || this.eUE.isEmpty())) {
            eUF = new String[this.eUE.size()];
            this.eUE.keySet().toArray(eUF);
        }
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(481, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R500_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R500_100")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("R500_100");
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(481, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R500_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R500_100")).append(",2").toString());
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.reg_by_email;
    }

    protected final void initView() {
        this.eUA = (MMAutoCompleteTextView) findViewById(f.reg_email);
        this.eUB = (EditText) findViewById(f.reg_password);
        this.eUC = (CheckBox) findViewById(f.agree_cb);
        if (!bi.oW(this.eUD)) {
            this.eUB.postDelayed(new 1(this), 500);
            this.eUA.setText(this.eUD);
        }
        if (eUF != null) {
            c cVar = new c(this, eUF, "@");
            this.eUA.setSpilter("@");
            this.eUA.setDropDownAnchor(f.reg_email_ll);
            this.eUA.setDropDownVerticalOffset(this.eUA.getPaddingBottom());
            this.eUA.setAdapter(cVar);
        }
        findViewById(f.agree_btn).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                bi.L(RegByEmailUI.this, RegByEmailUI.this.getString(j.url_agreement));
            }
        });
        this.eUC.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RegByEmailUI.b(RegByEmailUI.this);
            }
        });
        addTextOptionMenu(0, getString(j.app_nextstep), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByEmailUI.c(RegByEmailUI.this);
                return true;
            }
        });
        enableOptionMenu(false);
        this.eUA.addTextChangedListener(new 8(this));
        this.eUB.addTextChangedListener(new 9(this));
        this.eUB.setOnEditorActionListener(new 10(this));
        this.eUB.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0 || !RegByEmailUI.this.eUC.isChecked()) {
                    return false;
                }
                RegByEmailUI.c(RegByEmailUI.this);
                return true;
            }
        });
        setBackBtn(new 12(this));
    }

    private void goBack() {
        h.a(this, j.regby_email_cancel_registion_tip, j.regby_email_err_tip_title, j.app_ok, j.app_cancel, new 2(this), null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() != 481) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(lVar.getType())});
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.c.a.pU("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.csD);
            intent.putExtra("password", this.eIY);
            if (!(this.eUE == null || this.eUE.isEmpty())) {
                String[] split = this.csD.split("@");
                if (split != null && split.length == 2) {
                    intent.putExtra("email_login_page", (String) this.eUE.get(split[1]));
                }
            }
            startActivity(intent);
        } else {
            boolean z;
            if (!a.ezo.a(this, i, i2, str)) {
                switch (i2) {
                    case -111:
                        h.i(this, j.regby_email_invaild_email, j.regby_email_err_tip_title);
                        z = true;
                        break;
                    case -75:
                        h.i(this, j.alpha_version_tip_reg, j.reg_username_exist_title);
                        z = true;
                        break;
                    case -34:
                        Toast.makeText(this, j.regby_email_err_freq_limit, 0).show();
                        z = true;
                        break;
                    case XWalkResourceClient.ERROR_IO /*-7*/:
                        StringBuilder stringBuilder = new StringBuilder();
                        g.Eg();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
                        g.Eg();
                        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R20_email_duplicate_confirm")).append(",3").toString());
                        h.a(this, j.regby_email_user_already_exist, j.regby_email_err_tip_title, j.regby_email_user_already_exist_op_signin, j.regby_email_user_already_exist_op_cancel, new 4(this), null);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            z = true;
            if (!z) {
                if (!bi.oW(str)) {
                    Map z2 = bl.z(str, "e");
                    if (z2 != null && z2.size() > 0) {
                        String str2 = (String) z2.get(".e.Content");
                        if (!bi.oW(str2)) {
                            h.b(this, str2, getString(j.regby_email_err_tip_title), true);
                            return;
                        }
                    }
                }
                Toast.makeText(this, getString(j.regby_email_send_verify_code_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
