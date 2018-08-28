package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements e {
    private String bTi;
    private ProgressDialog eHw = null;
    private EditText eVq;
    private r eVr = null;
    private boolean eVs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eVs = getIntent().getBooleanExtra("is_sync_addr", false);
        this.bTi = getIntent().getExtras().getString("bindmcontact_mobile");
        initView();
        g.DF().a(126, this);
    }

    public void onDestroy() {
        if (this.eVr != null) {
            r rVar = this.eVr;
            s sVar = rVar.eUz;
            sVar.cancel();
            sVar.bAZ.SO();
            sVar.reset();
            rVar.text = null;
        }
        g.DF().b(126, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return a.g.regbymobilesetnick_reg;
    }

    protected final void initView() {
        setMMTitle(a$j.regbymobile_reg_setnick_title);
        this.eVq = (EditText) findViewById(f.regbymobilereg_nick_et);
        this.eVq.addTextChangedListener(new c(this.eVq, null, 16));
        addTextOptionMenu(0, getString(a$j.app_finish), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = RegByMobileSetNickUI.this.eVq.getText().toString().trim();
                if (trim == null || trim.length() <= 0) {
                    h.i(RegByMobileSetNickUI.this, a$j.verify_account_null_tip, a$j.regbymobile_reg_setpwd_alert_title);
                } else {
                    RegByMobileSetNickUI.this.YC();
                    com.tencent.mm.modelsimple.s sVar = new com.tencent.mm.modelsimple.s("", RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", RegByMobileSetNickUI.this.bTi, RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                    g.DF().a(sVar, 0);
                    RegByMobileSetNickUI regByMobileSetNickUI = RegByMobileSetNickUI.this;
                    Context context = RegByMobileSetNickUI.this;
                    RegByMobileSetNickUI.this.getString(a$j.app_tip);
                    regByMobileSetNickUI.eHw = h.a(context, RegByMobileSetNickUI.this.getString(a$j.regbyqq_reg_waiting), true, new 1(this, sVar));
                }
                return true;
            }
        });
        setBackBtn(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, com.tencent.mm.ab.l r11) {
        /*
        r7 = this;
        r2 = 2;
        r6 = 0;
        r3 = 0;
        r1 = 1;
        r0 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "onSceneEnd: errType = ";
        r4.<init>(r5);
        r4 = r4.append(r8);
        r5 = " errCode = ";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r5 = " errMsg = ";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r4);
        r0 = r7.eHw;
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r0 = r7.eHw;
        r0.dismiss();
        r7.eHw = r6;
    L_0x003b:
        r0 = com.tencent.mm.sdk.platformtools.bi.ci(r7);
        if (r0 != 0) goto L_0x0042;
    L_0x0041:
        return;
    L_0x0042:
        if (r8 != 0) goto L_0x0116;
    L_0x0044:
        if (r9 != 0) goto L_0x0116;
    L_0x0046:
        r0 = com.tencent.mm.model.q.GJ();
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile status = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r5 = " isSync = ";
        r4 = r4.append(r5);
        r5 = r7.eVs;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.d(r3, r4);
        r3 = r7.eVs;
        if (r3 == 0) goto L_0x0103;
    L_0x0071:
        r3 = -131073; // 0xfffffffffffdffff float:NaN double:NaN;
        r0 = r0 & r3;
        com.tencent.mm.plugin.account.friend.a.l.Xz();
        r7.getApplicationContext();
        com.tencent.mm.platformtools.b.Vn();
    L_0x007e:
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile update = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.d(r3, r4);
        r3 = com.tencent.mm.kernel.g.Ei();
        r3 = r3.DT();
        r4 = 7;
        r0 = java.lang.Integer.valueOf(r0);
        r3.set(r4, r0);
        r0 = r7.eVs;
        if (r0 != 0) goto L_0x0108;
    L_0x00a8:
        r0 = r1;
    L_0x00a9:
        r2 = new com.tencent.mm.protocal.c.xt;
        r2.<init>();
        r3 = 17;
        r2.rDz = r3;
        r2.rDA = r0;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FQ();
        r3 = new com.tencent.mm.plugin.messenger.foundation.a.a.h$a;
        r4 = 23;
        r3.<init>(r4, r2);
        r0.b(r3);
        r0 = com.tencent.mm.plugin.account.a.a.ezo;
        r0.vl();
        r0 = com.tencent.mm.model.at.dBv;
        r2 = "login_user_name";
        r3 = r7.bTi;
        r0.T(r2, r3);
        r0 = com.tencent.mm.plugin.account.a.a.ezn;
        r0 = r0.be(r7);
        r2 = "LauncherUI.enter_from_reg";
        r0.putExtra(r2, r1);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r0.addFlags(r2);
        r11 = (com.tencent.mm.modelsimple.s) r11;
        r2 = r11.egi;
        if (r2 == 0) goto L_0x010a;
    L_0x00f0:
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.plugin.account.bind.ui.BindQQUI.class;
        r2.<init>(r7, r3);
        r3 = "bindqq_regbymobile";
        r1 = r2.putExtra(r3, r1);
        com.tencent.mm.ui.MMWizardActivity.b(r7, r1, r0);
        goto L_0x0041;
    L_0x0103:
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = r0 | r3;
        goto L_0x007e;
    L_0x0108:
        r0 = r2;
        goto L_0x00a9;
    L_0x010a:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.plugin.account.ui.BindFacebookUI.class;
        r1.<init>(r7, r2);
        com.tencent.mm.ui.MMWizardActivity.b(r7, r1, r0);
        goto L_0x0041;
    L_0x0116:
        r0 = r11.getType();
        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r0 != r4) goto L_0x0129;
    L_0x011e:
        r0 = com.tencent.mm.h.a.eV(r10);
        if (r0 == 0) goto L_0x0129;
    L_0x0124:
        r0.a(r7, r6, r6);
        goto L_0x0041;
    L_0x0129:
        r0 = com.tencent.mm.plugin.account.a.a.ezo;
        r4 = r7.mController;
        r4 = r4.tml;
        r0 = r0.a(r4, r8, r9, r10);
        if (r0 == 0) goto L_0x0155;
    L_0x0135:
        r0 = r1;
    L_0x0136:
        if (r0 != 0) goto L_0x0041;
    L_0x0138:
        r0 = com.tencent.mm.plugin.account.a$j.fmt_reg_err;
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r8);
        r2[r3] = r4;
        r4 = java.lang.Integer.valueOf(r9);
        r2[r1] = r4;
        r0 = r7.getString(r0, r2);
        r0 = android.widget.Toast.makeText(r7, r0, r3);
        r0.show();
        goto L_0x0041;
    L_0x0155:
        switch(r8) {
            case 4: goto L_0x015a;
            default: goto L_0x0158;
        };
    L_0x0158:
        r0 = r3;
        goto L_0x0136;
    L_0x015a:
        r0 = -7;
        if (r9 == r0) goto L_0x0161;
    L_0x015d:
        r0 = -10;
        if (r9 != r0) goto L_0x016a;
    L_0x0161:
        r0 = com.tencent.mm.plugin.account.a$j.reg_username_exist_tip;
        r4 = com.tencent.mm.plugin.account.a$j.reg_username_exist_title;
        com.tencent.mm.ui.base.h.i(r7, r0, r4);
        r0 = r1;
        goto L_0x0136;
    L_0x016a:
        r0 = -75;
        if (r9 != r0) goto L_0x0158;
    L_0x016e:
        r0 = com.tencent.mm.plugin.account.a$j.alpha_version_tip_reg;
        r4 = com.tencent.mm.plugin.account.a$j.reg_username_exist_title;
        com.tencent.mm.ui.base.h.i(r7, r0, r4);
        r0 = r1;
        goto L_0x0136;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }
}
