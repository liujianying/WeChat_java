package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class SettingsAliasUI extends MMActivity implements e {
    private String cCR;
    private ImageView eCl;
    private ProgressDialog eHw = null;
    private TextView eTm;
    private TextView eVw;
    private EditText mRR;
    private d mRS;
    private boolean mRT = false;
    private TextView mRU;
    private e mRa = null;

    static /* synthetic */ void e(SettingsAliasUI settingsAliasUI) {
        if (settingsAliasUI.cCR.equals(q.GF())) {
            h.i(settingsAliasUI.mController.tml, i.modify_username_confirm_modify, i.modify_username);
        } else if (bi.WG(settingsAliasUI.cCR)) {
            ActionBarActivity actionBarActivity = settingsAliasUI.mController.tml;
            settingsAliasUI.getString(i.modify_username);
            settingsAliasUI.eHw = h.a(actionBarActivity, settingsAliasUI.getString(i.modify_ing), true, new 4(settingsAliasUI));
            if (settingsAliasUI.mRS != null) {
                g.DF().c(settingsAliasUI.mRS);
            }
            settingsAliasUI.mRS = new d(settingsAliasUI.cCR);
            g.DF().a(settingsAliasUI.mRS, 0);
        } else {
            h.i(settingsAliasUI.mController.tml, i.verify_account_tip, i.reg_username_format_err_title);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRT = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        initView();
        g.DF().a(177, this);
    }

    protected final int getLayoutId() {
        return a.g.settings_alias;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        if (this.mRS != null) {
            g.DF().c(this.mRS);
        }
        g.DF().b(177, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.modify_username);
        this.eCl = (ImageView) findViewById(f.avatar_iv);
        this.eTm = (TextView) findViewById(f.nickname_tv);
        this.eVw = (TextView) findViewById(f.username_tv);
        this.mRU = (TextView) findViewById(f.modify_username_detail_message);
        this.mRR = (EditText) findViewById(f.regbyqqreg_account_et);
        String GF = q.GF();
        if (!ab.XT(GF)) {
            this.mRR.setText(q.GF());
            this.eVw.setText(getString(i.app_account, new Object[]{GF}));
        }
        this.mRR.setSelection(this.mRR.getText().length());
        this.mRR.setFocusable(true);
        this.mRR.setFocusableInTouchMode(true);
        this.mRR.addTextChangedListener(new 1(this));
        this.eTm.setText(j.a(this, bi.oV(q.GH()), this.eTm.getTextSize()));
        b.a(this.eCl, GF);
        setBackBtn(new 2(this));
        a(0, getString(i.app_save), new 3(this), s.b.tmX);
        enableOptionMenu(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.ab.l r9) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        if (r6 != 0) goto L_0x0043;
    L_0x0004:
        if (r7 != 0) goto L_0x0043;
    L_0x0006:
        r2 = r5.mRT;
        if (r2 == 0) goto L_0x0014;
    L_0x000a:
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;
        r3 = 10358; // 0x2876 float:1.4515E-41 double:5.1175E-320;
        r4 = "1";
        r2.k(r3, r4);
    L_0x0014:
        r5.YC();
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.DT();
        r3 = 42;
        r4 = r5.cCR;
        r2.set(r3, r4);
        r2 = com.tencent.mm.kernel.g.DF();
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = new com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$5;
        r4.<init>(r5);
        r5.mRa = r4;
        r2.a(r3, r4);
        r2 = new com.tencent.mm.modelsimple.r;
        r2.<init>(r0);
        r0 = com.tencent.mm.kernel.g.DF();
        r0.a(r2, r1);
    L_0x0042:
        return;
    L_0x0043:
        r2 = r5.eHw;
        if (r2 == 0) goto L_0x004f;
    L_0x0047:
        r2 = r5.eHw;
        r2.dismiss();
        r2 = 0;
        r5.eHw = r2;
    L_0x004f:
        r2 = com.tencent.mm.plugin.setting.b.ezo;
        r3 = r5.mController;
        r3 = r3.tml;
        r2 = r2.a(r3, r6, r7, r8);
        if (r2 == 0) goto L_0x005e;
    L_0x005b:
        if (r0 == 0) goto L_0x0042;
    L_0x005d:
        goto L_0x0042;
    L_0x005e:
        switch(r6) {
            case 4: goto L_0x0063;
            default: goto L_0x0061;
        };
    L_0x0061:
        r0 = r1;
        goto L_0x005b;
    L_0x0063:
        r2 = -7;
        if (r7 == r2) goto L_0x006a;
    L_0x0066:
        r2 = -10;
        if (r7 != r2) goto L_0x0061;
    L_0x006a:
        r1 = r5.mController;
        r1 = r1.tml;
        r2 = com.tencent.mm.plugin.setting.a.i.reg_username_exist_tip;
        r3 = com.tencent.mm.plugin.setting.a.i.modify_username_failed;
        com.tencent.mm.ui.base.h.i(r1, r2, r3);
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }
}
