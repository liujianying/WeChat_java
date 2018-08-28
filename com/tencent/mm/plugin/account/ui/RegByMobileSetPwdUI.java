package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;

public class RegByMobileSetPwdUI extends SetPwdUI {
    private String bLe = null;
    private TextView eSV;
    public View eVA;
    public EditText eVB;
    private String eVC = null;
    private boolean eVD = false;
    public boolean eVE;
    private int eVF = 0;
    private bhy eVG = null;
    private TextView eVw;
    private View eVx;
    private View eVy;
    private TextView eVz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eVC = getIntent().getStringExtra("kintent_hint");
        this.eWV = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.eVD = getIntent().getBooleanExtra("from_unbind", false);
        g.DF().a(384, this);
        g.DF().a(WebView.NORMAL_MODE_ALPHA, this);
        initView();
        byte[] WP = bi.WP(av.Ib().getString("_auth_key", ""));
        em emVar = new em();
        if (bi.bC(WP)) {
            this.eVG = new bhy().bq(new byte[0]);
        } else {
            this.eVG = new bhy().bq(WP);
            try {
                emVar.aG(WP);
            } catch (Throwable e) {
                x.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", e, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        }
        g.DF().a(new r(1), 0);
        getString(a$j.app_tip);
        this.eHw = h.a((Context) this, getString(a$j.app_loading), false, null);
    }

    public void onDestroy() {
        super.onDestroy();
        g.DF().b(384, this);
        g.DF().b(WebView.NORMAL_MODE_ALPHA, this);
    }

    protected void onNewIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("setpwd_ticket");
        x.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[]{stringExtra});
        if (!bi.oW(stringExtra)) {
            this.bLe = stringExtra;
            this.eVF = 4;
            this.eVA.setVisibility(8);
            this.eVx.setVisibility(8);
        }
    }

    protected final int getLayoutId() {
        return a.g.regbymobilesetpwd_reg;
    }

    protected final void initView() {
        if (!this.eWV) {
            cqi();
        }
        setMMTitle(a$j.regbymobile_reg_setpwd_title);
        this.eVw = (TextView) findViewById(f.username_tv);
        this.eVy = findViewById(f.account_container);
        this.eSV = (TextView) findViewById(f.regbymobilerag_pass_hint);
        this.eVz = (TextView) findViewById(f.account_wording);
        if (this.eVC != null && this.eVC.length() > 0) {
            this.eSV.setText(this.eVC);
        }
        this.eVA = findViewById(f.regbymobile_reg_old_pwd_container);
        this.eVB = (EditText) this.eVA.findViewById(f.regbymobilereg_old_pwd_et);
        this.eVx = findViewById(f.forgot_old_password);
        this.eVx.setOnClickListener(new 1(this));
        if (this.eVD || !g.Eg().Dx()) {
            this.eVy.setVisibility(8);
        } else {
            this.eVy.setVisibility(0);
            CharSequence GG = q.GG();
            if (bi.oW(GG)) {
                GG = q.GF();
                if (ab.XT(GG)) {
                    GG = null;
                }
            }
            if (bi.oW(GG)) {
                String str = (String) g.Ei().DT().get(6, null);
                String str2 = (String) g.Ei().DT().get(5, null);
                if (!bi.oW(str)) {
                    if (bi.Xd(str).booleanValue()) {
                        String replace;
                        ap apVar = new ap();
                        str2 = "86";
                        if (str.startsWith("+")) {
                            replace = str.replace("+", "");
                            str = ap.Fp(replace);
                            if (str != null) {
                                replace = replace.substring(str.length());
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                        } else {
                            replace = str;
                        }
                        GG = ap.formatNumber(str2, replace);
                        this.eVz.setText(a$j.settings_mobile);
                        this.eVw.setText(GG);
                    }
                    this.eSV.setText(a$j.regbymobile_reg_setpwd_title_mobile);
                } else if (bi.oW(str2)) {
                    this.eVy.setVisibility(8);
                } else {
                    this.eVw.setText(str2);
                    this.eVz.setText(a$j.settings_email_addr);
                    this.eSV.setText(a$j.regbymobile_reg_setpwd_title_email);
                }
            } else {
                this.eVz.setText(a$j.settings_username);
                this.eVw.setText(GG);
            }
        }
        TextView textView = (TextView) findViewById(f.old_password_wording);
        TextView textView2 = (TextView) findViewById(f.password_wording);
        TextView textView3 = (TextView) findViewById(f.confirm_wording);
        EditText editText = (EditText) findViewById(f.regbymobilereg_pass_et);
        EditText editText2 = (EditText) findViewById(f.regbymobilereg_pass_again_et);
        if (!w.chL()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            textView3.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        float measureText = this.eVz.getPaint().measureText(this.eVz.getText().toString());
        float measureText2 = textView.getPaint().measureText(textView.getText().toString());
        float measureText3 = textView2.getPaint().measureText(textView2.getText().toString());
        float max = Math.max(Math.max(Math.max(measureText, measureText3), textView3.getPaint().measureText(textView3.getText().toString())), measureText2);
        textView.setWidth((int) max);
        this.eVz.setWidth((int) max);
        textView2.setWidth((int) max);
        textView2.setWidth((int) max);
    }

    protected final String YS() {
        return ((EditText) findViewById(f.regbymobilereg_pass_et)).getText().toString();
    }

    protected final l YR() {
        if (bi.oW(this.bLe)) {
            this.bLe = (String) g.Ei().DT().get(77830, null);
        }
        return new y(this.eWT, this.bLe, this.eVF, this.eVG);
    }

    protected final String YT() {
        return ((EditText) findViewById(f.regbymobilereg_pass_again_et)).getText().toString();
    }

    protected final void Za() {
        if (bi.oW(this.bLe) && this.eVE) {
            g.DF().a(new com.tencent.mm.modelsimple.ab(this.eVB.getText().toString(), "", "", ""), 0);
            getString(a$j.app_tip);
            this.eHw = h.a((Context) this, getString(a$j.app_sending), false, null);
            return;
        }
        super.Za();
    }

    protected final void jo(int i) {
        switch (3.evn[i - 1]) {
            case 1:
                h.i(this, a$j.regbymobile_reg_setpwd_alert_diff, a$j.regbymobile_reg_setpwd_alert_title);
                return;
            case 2:
                h.i(this, a$j.regbymobile_reg_setpwd_alert_more_byte, a$j.regbymobile_reg_setpwd_alert_title);
                return;
            case 3:
                h.i(this, a$j.verify_password_all_num_tip, a$j.regbymobile_reg_setpwd_alert_title);
                return;
            case 4:
                h.i(this, a$j.verify_password_tip, a$j.regbymobile_reg_setpwd_alert_title);
                return;
            default:
                return;
        }
    }

    protected final boolean f(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return e(i, i2, str);
        }
        finish();
        return true;
    }

    public final boolean Zb() {
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[]{Integer.valueOf(i2), str, lVar});
        super.a(i, i2, str, lVar);
        if (lVar.getType() == WebView.NORMAL_MODE_ALPHA) {
            if (((r) lVar).efY != 1) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.eVA.setVisibility(0);
                this.eVx.setVisibility(0);
                this.eVE = true;
            } else if (i2 == -3 && i == 4) {
                this.eVE = false;
            } else {
                this.eVA.setVisibility(0);
                this.eVx.setVisibility(0);
                com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    x.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(eV.showType), eV.url, eV.desc});
                    h.a((Context) this, eV.desc, eV.bHD, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            RegByMobileSetPwdUI.this.finish();
                        }
                    });
                }
            }
        } else if (lVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                g.Ei().DT().set(77830, ((com.tencent.mm.modelsimple.ab) lVar).Oj());
                Zo();
                return;
            }
            h.i(this, a$j.regbymobile_reg_setpwd_old_pwd_alert, a$j.app_tip);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("setpwd_ticket");
            x.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[]{stringExtra});
            if (!bi.oW(stringExtra)) {
                this.bLe = stringExtra;
                this.eVF = 6;
                this.eVA.setVisibility(8);
                this.eVx.setVisibility(8);
            }
        }
    }
}
