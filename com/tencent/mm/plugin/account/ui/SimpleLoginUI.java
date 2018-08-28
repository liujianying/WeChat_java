package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.ab.e;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.xlog.app.XLogSetup;

public class SimpleLoginUI extends MMWizardActivity implements e {
    private TextWatcher UE = new 1(this);
    private String cbP = "";
    private ProgressDialog eHw = null;
    private SecurityImage eIX = null;
    private String eOW;
    private f eQY = new f();
    private c eQf = new 12(this);
    private MMClearEditText eRX;
    private MMClearEditText eRY;
    private MMFormInputView eRZ;
    private String eRa;
    private String eRb;
    private ResizeLayout eRf;
    private MMFormInputView eSa;
    private Button eSb;
    private MMKeyboardUperView eSh;

    static /* synthetic */ void a(SimpleLoginUI simpleLoginUI) {
        if (bi.oW(simpleLoginUI.eRX.getText().toString()) || bi.oW(simpleLoginUI.eRY.getText().toString())) {
            simpleLoginUI.eSb.setEnabled(false);
        } else {
            simpleLoginUI.eSb.setEnabled(true);
        }
    }

    protected final int getLayoutId() {
        return g.login;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", 4);
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        setMMTitle(j.app_name);
        if (a.ezo != null) {
            a.ezo.vo();
        }
        initView();
        com.tencent.mm.kernel.g.DF().a(701, this);
        x.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.f(this, "android.permission.WRITE_EXTERNAL_STORAGE"))});
        if (com.tencent.mm.pluginsdk.permission.a.f(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            x.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.f(this, "android.permission.READ_PHONE_STATE"))});
            if (com.tencent.mm.pluginsdk.permission.a.f(this, "android.permission.READ_PHONE_STATE")) {
                z = true;
            }
        }
        if (!z) {
            new Intent().addFlags(67108864);
            a.ezn.q(new Intent(), this);
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
    }

    public void onDestroy() {
        com.tencent.mm.kernel.g.DF().b(701, this);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.eOW = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.eOW = extras.getString("auth_ticket");
        }
        if (!bi.oW(this.eOW)) {
            this.eRX.setText(bi.oV(f.YF()));
            this.eRY.setText(bi.oV(f.YG()));
            new ag().postDelayed(new 13(this), 500);
        }
    }

    protected final void initView() {
        this.eRZ = (MMFormInputView) findViewById(f.login_account_auto);
        this.eSa = (MMFormInputView) findViewById(f.login_password_et);
        this.eRX = (MMClearEditText) this.eRZ.getContentEditText();
        this.eRX.setFocusableInTouchMode(false);
        this.eRX.setOnTouchListener(new 14(this));
        this.eRY = (MMClearEditText) this.eSa.getContentEditText();
        this.eRY.setFocusableInTouchMode(false);
        this.eRY.setOnTouchListener(new 15(this));
        com.tencent.mm.ui.tools.a.c.d(this.eRY).Gi(16).a(null);
        this.eSb = (Button) findViewById(f.login_btn);
        this.eSb.setEnabled(false);
        this.eRX.addTextChangedListener(this.UE);
        this.eRY.addTextChangedListener(this.UE);
        this.eRY.setOnEditorActionListener(new 16(this));
        this.eRY.setOnKeyListener(new 17(this));
        this.eRf = (ResizeLayout) findViewById(f.resize_lv);
        this.eSh = (MMKeyboardUperView) findViewById(f.scrollView);
        this.eRf.setOnSizeChanged(new ResizeLayout.a() {
            public final void YE() {
                SimpleLoginUI.this.eSh.post(new Runnable() {
                    public final void run() {
                        SimpleLoginUI.this.eSh.fullScroll(130);
                    }
                });
            }
        });
        this.eSh.setOnTouchListener(new 19(this));
        findViewById(f.login_by_other).setVisibility(8);
        View findViewById = findViewById(f.fblogin_tip);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        setMMTitle(j.login_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SimpleLoginUI.this.WL();
                return true;
            }
        });
        this.eOW = getIntent().getStringExtra("auth_ticket");
        if (!bi.oW(this.eOW)) {
            this.eRX.setText(bi.oV(f.YF()));
            this.eRY.setText(bi.oV(f.YG()));
            new ag().postDelayed(new 3(this), 500);
        }
        if (com.tencent.mm.sdk.platformtools.e.sFE) {
            a.ezo.g(this);
        }
        this.eSb.setOnClickListener(new 4(this));
    }

    private void WL() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        DT(1);
        if (booleanExtra) {
            exit(1);
        }
    }

    private void Yz() {
        this.eQY.account = this.eRX.getText().toString().trim();
        this.eQY.eIY = this.eRY.getText().toString();
        if (this.eQY.account.equals("")) {
            h.i(this, j.verify_username_null_tip, j.login_err_title);
        } else if (this.eQY.eIY.equals("")) {
            h.i(this, j.verify_password_null_tip, j.login_err_title);
        } else {
            YC();
            q qVar = new q(this.eQY.account, this.eQY.eIY, this.eOW, 0);
            com.tencent.mm.kernel.g.DF().a(qVar, 0);
            getString(j.app_tip);
            this.eHw = h.a(this, getString(j.login_logining), true, new 5(this, qVar));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    protected void onPause() {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.ab.l r14) {
        /*
        r10 = this;
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "onSceneEnd: errType = ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " errCode = ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " errMsg = ";
        r1 = r1.append(r2);
        r1 = r1.append(r13);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "Scene Type ";
        r1.<init>(r2);
        r2 = r14.getType();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r10.eHw;
        if (r0 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r10.eHw;
        r0.dismiss();
        r0 = 0;
        r10.eHw = r0;
    L_0x0052:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Rd();
        r10.cbP = r0;
        r1 = 0;
        r0 = r14.getType();
        r2 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r0 != r2) goto L_0x02e4;
    L_0x0064:
        r2 = r10.eQY;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.getSecCodeType();
        r2.eRQ = r0;
        r2 = r10.eQY;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Re();
        r2.eJa = r0;
        r2 = r10.eQY;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Rf();
        r2.eIZ = r0;
        r2 = r10.eQY;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Rg();
        r2.eJb = r0;
        r0 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        if (r12 != r0) goto L_0x00af;
    L_0x0094:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Ok();
        r10.eOW = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Rh();
        r10.eRa = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.q) r0;
        r0 = r0.Rk();
        r10.eRb = r0;
    L_0x00af:
        r0 = 4;
        if (r11 != r0) goto L_0x02e4;
    L_0x00b2:
        r0 = -16;
        if (r12 == r0) goto L_0x00ba;
    L_0x00b6:
        r0 = -17;
        if (r12 != r0) goto L_0x02e4;
    L_0x00ba:
        r0 = 1;
        r1 = com.tencent.mm.kernel.g.DF();
        r2 = new com.tencent.mm.model.bg;
        r3 = new com.tencent.mm.plugin.account.ui.SimpleLoginUI$10;
        r3.<init>();
        r2.<init>(r3);
        r3 = 0;
        r1.a(r2, r3);
    L_0x00cd:
        if (r0 != 0) goto L_0x00d3;
    L_0x00cf:
        if (r11 != 0) goto L_0x0153;
    L_0x00d1:
        if (r12 != 0) goto L_0x0153;
    L_0x00d3:
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.platformtools.x.bZ(r10);
        r0 = r10.eQY;
        r0 = r0.account;
        com.tencent.mm.platformtools.aa.oS(r0);
        r0 = r10.mController;
        r0 = r0.tml;
        r1 = new com.tencent.mm.plugin.account.ui.SimpleLoginUI$11;
        r1.<init>();
        r2 = new com.tencent.mm.plugin.account.model.c;
        r2.<init>(r0, r1);
        r0 = com.tencent.mm.plugin.account.a.a.ezo;
        r0 = r0.a(r2);
        r2.bKq = r0;
        r0 = r2.bKq;
        if (r0 != 0) goto L_0x0104;
    L_0x00fa:
        r0 = r2.eNU;
        if (r0 == 0) goto L_0x0103;
    L_0x00fe:
        r0 = r2.eNU;
        r0.Yk();
    L_0x0103:
        return;
    L_0x0104:
        r0 = r2.bKq;
        r0 = r0.getType();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        if (r0 != r1) goto L_0x013f;
    L_0x010e:
        r0 = com.tencent.mm.kernel.g.DF();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r0.a(r1, r2);
    L_0x0117:
        r0 = com.tencent.mm.kernel.g.DF();
        r1 = r2.bKq;
        r3 = 0;
        r0.a(r1, r3);
        r0 = r2.context;
        r1 = r2.context;
        r3 = com.tencent.mm.plugin.account.a.j.app_tip;
        r1.getString(r3);
        r1 = r2.context;
        r3 = com.tencent.mm.plugin.account.a.j.app_loading_data;
        r1 = r1.getString(r3);
        r3 = 1;
        r4 = new com.tencent.mm.plugin.account.model.c$1;
        r4.<init>(r2);
        r0 = com.tencent.mm.ui.base.h.a(r0, r1, r3, r4);
        r2.tipDialog = r0;
        goto L_0x0103;
    L_0x013f:
        r0 = r2.bKq;
        r0 = r0.getType();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        if (r0 != r1) goto L_0x0117;
    L_0x0149:
        r0 = com.tencent.mm.kernel.g.DF();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r0.a(r1, r2);
        goto L_0x0117;
    L_0x0153:
        r0 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
        if (r12 != r0) goto L_0x0161;
    L_0x0157:
        r14 = (com.tencent.mm.modelsimple.q) r14;
        r0 = com.tencent.mm.platformtools.f.a(r14);
        com.tencent.mm.platformtools.aa.a(r10, r0, r12);
        goto L_0x0103;
    L_0x0161:
        r0 = com.tencent.mm.plugin.account.a.a.ezo;
        r1 = r10.mController;
        r1 = r1.tml;
        r0 = r0.a(r1, r11, r12, r13);
        if (r0 == 0) goto L_0x019f;
    L_0x016d:
        r0 = 1;
    L_0x016e:
        if (r0 != 0) goto L_0x0103;
    L_0x0170:
        r0 = com.tencent.mm.h.a.eV(r13);
        if (r0 == 0) goto L_0x017e;
    L_0x0176:
        r1 = 0;
        r2 = 0;
        r0 = r0.a(r10, r1, r2);
        if (r0 != 0) goto L_0x0103;
    L_0x017e:
        r0 = com.tencent.mm.plugin.account.a.j.fmt_auth_err;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r11);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r12);
        r1[r2] = r3;
        r0 = r10.getString(r0, r1);
        r1 = 0;
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
        goto L_0x0103;
    L_0x019f:
        r0 = 4;
        if (r11 != r0) goto L_0x01a5;
    L_0x01a2:
        switch(r12) {
            case -311: goto L_0x01e3;
            case -310: goto L_0x01e3;
            case -205: goto L_0x0282;
            case -140: goto L_0x02cd;
            case -106: goto L_0x02dd;
            case -100: goto L_0x0262;
            case -75: goto L_0x01da;
            case -72: goto L_0x01cd;
            case -30: goto L_0x01bb;
            case -9: goto L_0x01c4;
            case -6: goto L_0x01e3;
            case -4: goto L_0x01bb;
            case -3: goto L_0x01bb;
            case -1: goto L_0x01a7;
            default: goto L_0x01a5;
        };
    L_0x01a5:
        r0 = 0;
        goto L_0x016e;
    L_0x01a7:
        r0 = com.tencent.mm.kernel.g.DF();
        r0 = r0.Lg();
        r1 = 5;
        if (r0 != r1) goto L_0x01bb;
    L_0x01b2:
        r0 = com.tencent.mm.plugin.account.a.j.net_warn_server_down_tip;
        r1 = com.tencent.mm.plugin.account.a.j.net_warn_server_down;
        com.tencent.mm.ui.base.h.i(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01bb:
        r0 = com.tencent.mm.plugin.account.a.j.errcode_password;
        r1 = com.tencent.mm.plugin.account.a.j.login_err_title;
        com.tencent.mm.ui.base.h.i(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01c4:
        r0 = com.tencent.mm.plugin.account.a.j.login_err_mailnotverify;
        r1 = com.tencent.mm.plugin.account.a.j.login_err_title;
        com.tencent.mm.ui.base.h.i(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01cd:
        r0 = r10.mController;
        r0 = r0.tml;
        r1 = com.tencent.mm.plugin.account.a.j.regbyqq_auth_err_failed_niceqq;
        r2 = com.tencent.mm.plugin.account.a.j.app_tip;
        com.tencent.mm.ui.base.h.i(r0, r1, r2);
        r0 = 1;
        goto L_0x016e;
    L_0x01da:
        r0 = r10.mController;
        r0 = r0.tml;
        com.tencent.mm.platformtools.aa.ch(r0);
        r0 = 1;
        goto L_0x016e;
    L_0x01e3:
        r0 = r10.eIX;
        if (r0 != 0) goto L_0x0213;
    L_0x01e7:
        r0 = r10.mController;
        r0 = r0.tml;
        r1 = com.tencent.mm.plugin.account.a.j.regbyqq_secimg_title;
        r2 = r10.eQY;
        r2 = r2.eRQ;
        r3 = r10.eQY;
        r3 = r3.eIZ;
        r4 = r10.eQY;
        r4 = r4.eJa;
        r5 = r10.eQY;
        r5 = r5.eJb;
        r6 = new com.tencent.mm.plugin.account.ui.SimpleLoginUI$6;
        r6.<init>(r10);
        r7 = 0;
        r8 = new com.tencent.mm.plugin.account.ui.SimpleLoginUI$7;
        r8.<init>(r10);
        r9 = r10.eQY;
        r0 = com.tencent.mm.ui.applet.SecurityImage$a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r10.eIX = r0;
    L_0x0210:
        r0 = 1;
        goto L_0x016e;
    L_0x0213:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r10.eQY;
        r2 = r2.eJa;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r10.eQY;
        r2 = r2.eIZ;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.Ac();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r10.eIX;
        r1 = r10.eQY;
        r1 = r1.eRQ;
        r2 = r10.eQY;
        r2 = r2.eIZ;
        r3 = r10.eQY;
        r3 = r3.eJa;
        r4 = r10.eQY;
        r4 = r4.eJb;
        r0.a(r1, r2, r3, r4);
        goto L_0x0210;
    L_0x0262:
        com.tencent.mm.kernel.a.hold();
        com.tencent.mm.kernel.g.Eg();
        r0 = com.tencent.mm.kernel.a.Dh();
        r1 = com.tencent.mm.plugin.account.a.j.app_tip;
        r1 = r10.getString(r1);
        r2 = new com.tencent.mm.plugin.account.ui.SimpleLoginUI$8;
        r2.<init>(r10);
        r3 = new com.tencent.mm.plugin.account.ui.SimpleLoginUI$9;
        r3.<init>(r10);
        com.tencent.mm.ui.base.h.a(r10, r0, r1, r2, r3);
        r0 = 1;
        goto L_0x016e;
    L_0x0282:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.eOW;
        r4 = com.tencent.mm.sdk.platformtools.bi.Xf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r10.eRb;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r10.eQY;
        com.tencent.mm.plugin.account.ui.f.a(r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "auth_ticket";
        r2 = r10.eOW;
        r0.putExtra(r1, r2);
        r1 = "binded_mobile";
        r2 = r10.eRa;
        r0.putExtra(r1, r2);
        r1 = "close_safe_device_style";
        r2 = r10.eRb;
        r0.putExtra(r1, r2);
        r1 = "from_source";
        r2 = 3;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.plugin.account.a.a.ezn;
        r1.g(r10, r0);
        r0 = 1;
        goto L_0x016e;
    L_0x02cd:
        r0 = r10.cbP;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x02da;
    L_0x02d5:
        r0 = r10.cbP;
        com.tencent.mm.platformtools.aa.n(r10, r13, r0);
    L_0x02da:
        r0 = 1;
        goto L_0x016e;
    L_0x02dd:
        r0 = 0;
        com.tencent.mm.platformtools.aa.e(r10, r13, r0);
        r0 = 1;
        goto L_0x016e;
    L_0x02e4:
        r0 = r1;
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.SimpleLoginUI.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oW(stringExtra));
            if (!bi.oW(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.d(str2, str3, objArr2);
            if (intExtra == -217) {
                Yz();
            }
        }
    }
}
