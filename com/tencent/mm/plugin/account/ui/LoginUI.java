package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.a.d$a;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;

public class LoginUI extends MMActivity implements e {
    private TextWatcher UE = new 1(this);
    private String bLe = null;
    private String cbP = "";
    private ProgressDialog eHw = null;
    private String eHy;
    private SecurityImage eIX = null;
    private String eOW;
    protected Button eQU;
    protected Button eQV;
    private View eQW;
    protected Button eQX;
    private f eQY = new f();
    private c eQf = new 12(this);
    private MMClearEditText eRX;
    private MMClearEditText eRY;
    private MMFormInputView eRZ;
    private String eRa;
    private String eRb;
    private ResizeLayout eRf;
    private d eRi;
    private Button eRo;
    private MMFormInputView eSa;
    private Button eSb;
    private Button eSc;
    protected View eSd;
    private String eSe;
    private boolean eSf;
    private com.tencent.mm.ui.widget.a.d eSg;
    private MMKeyboardUperView eSh;
    private boolean eSi = false;
    private final int eSj = 128;
    private int sceneType = 0;

    static /* synthetic */ void a(LoginUI loginUI) {
        if (bi.oW(loginUI.eRX.getText().toString()) || bi.oW(loginUI.eRY.getText().toString())) {
            loginUI.eSb.setEnabled(false);
        } else {
            loginUI.eSb.setEnabled(true);
        }
    }

    static /* synthetic */ void b(LoginUI loginUI) {
        View currentFocus = loginUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            int height = (iArr[1] - loginUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                loginUI.eSh.post(new 11(loginUI, height));
            }
        }
    }

    static /* synthetic */ void l(LoginUI loginUI) {
        g.Ek().gi("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        a.ezn.q(intent, loginUI);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.login;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = "";
        if (com.tencent.mm.protocal.d.qVQ) {
            str = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        this.sceneType = getIntent().getIntExtra("login_type", 0);
        setMMTitle(str);
        lF(getResources().getColor(com.tencent.mm.plugin.account.a.c.normal_actionbar_color));
        cqh();
        a.ezo.vo();
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
        this.eRi = new d();
        this.eSf = getIntent().getBooleanExtra("from_switch_account", false);
        this.eSe = at.dBv.I("login_weixin_username", "");
        if (getIntent().getIntArrayExtra("kv_report_login_method_data") != null) {
            h.mEJ.h(14262, new Object[]{Integer.valueOf(r0[0]), Integer.valueOf(r0[1]), Integer.valueOf(r0[2]), Integer.valueOf(r0[3]), Integer.valueOf(r0[4])});
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
        StringBuilder stringBuilder;
        if (this.sceneType == 0) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L100_100_logout")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("L100_100_logout");
        } else if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L400_100_login,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L400_100_login")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("L400_100_login");
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
        StringBuilder stringBuilder;
        if (this.sceneType == 0) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L100_100_logout")).append(",2").toString());
        } else if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L400_100_login,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L400_100_login")).append(",2").toString());
        }
    }

    public void onDestroy() {
        if (this.eRi != null) {
            this.eRi.close();
        }
        g.DF().b(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
        super.onDestroy();
    }

    protected final void initView() {
        this.eRZ = (MMFormInputView) findViewById(f.login_account_auto);
        this.eSa = (MMFormInputView) findViewById(f.login_password_et);
        this.eRX = (MMClearEditText) this.eRZ.getContentEditText();
        this.eRY = (MMClearEditText) this.eSa.getContentEditText();
        com.tencent.mm.ui.tools.a.c.d(this.eRY).Gi(16).a(null);
        this.eSb = (Button) findViewById(f.login_btn);
        this.eSb.setEnabled(false);
        this.eSc = (Button) findViewById(f.login_by_other);
        this.eRo = (Button) findViewById(f.login_as_other_device_btn);
        this.eSd = findViewById(f.login_bottom_container);
        this.eSd.setVisibility(0);
        this.eQU = (Button) findViewById(f.login_find_password_btn);
        this.eQW = findViewById(f.free_btn_container);
        this.eQV = (Button) findViewById(f.login_freeze_account_btn);
        this.eQX = (Button) findViewById(f.login_more_btn);
        this.eRf = (ResizeLayout) findViewById(f.resize_lv);
        this.eSh = (MMKeyboardUperView) findViewById(f.scrollView);
        this.eRf.setOnSizeChanged(new 20(this));
        boolean PA = b.PA();
        View findViewById = findViewById(f.fblogin_tip);
        findViewById.setVisibility(!PA ? 8 : 0);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LoginUI.this.startActivity(new Intent(LoginUI.this, FacebookLoginUI.class));
            }
        });
        this.eQU.setOnClickListener(new 22(this));
        this.eQV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LoginUI.P(LoginUI.this, LoginUI.this.getString(j.freeze_account_url, new Object[]{w.chP()}));
            }
        });
        this.eSg = new com.tencent.mm.ui.widget.a.d(this, 1, false);
        this.eSg.ofp = new 24(this);
        this.eSg.uJQ = new d$a() {
            public final void onDismiss() {
                LoginUI.this.eSg.bzW();
            }
        };
        this.eSg.ofq = new 26(this);
        if (w.chM()) {
            this.eQX.setOnClickListener(new 2(this));
        } else {
            this.eQW.setVisibility(8);
            this.eQX.setText(j.login_by_more);
            this.eQX.setOnClickListener(new 3(this));
        }
        setMMTitle("");
        setBackBtn(new 4(this), i.actionbar_icon_close_black);
        this.eSb.setOnClickListener(new 5(this));
        this.eSc.setOnClickListener(new 6(this));
        this.eOW = getIntent().getStringExtra("auth_ticket");
        if (!bi.oW(this.eOW)) {
            this.eRX.setText(bi.oV(f.YF()));
            this.eRY.setText(bi.oV(f.YG()));
            new ag().postDelayed(new 7(this), 500);
        }
        this.eRX.addTextChangedListener(this.UE);
        this.eRY.addTextChangedListener(this.UE);
        this.eRY.setOnEditorActionListener(new 8(this));
        this.eRY.setOnKeyListener(new 9(this));
        if (com.tencent.mm.sdk.platformtools.e.sFE) {
            a.ezo.g(this);
        }
        CharSequence stringExtra = getIntent().getStringExtra("login_username");
        this.eSi = getIntent().getBooleanExtra("from_deep_link", false);
        if (!bi.oW(stringExtra)) {
            this.eRX.setText(stringExtra);
        }
        if (com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN) {
            this.eRo.setVisibility(0);
            this.eRo.setOnClickListener(new 10(this));
        }
    }

    private static void P(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        com.tencent.mm.bg.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        YC();
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        p.cbS();
        finish();
    }

    private boolean e(int i, int i2, String str) {
        if (a.ezo.a(this.mController.tml, i, i2, str)) {
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
                    if (this.eIX == null) {
                        this.eIX = SecurityImage.a.a(this, j.regbyqq_secimg_title, this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb, new 13(this), null, new 14(this), this.eQY);
                    } else {
                        x.d("MicroMsg.LoginUI", "imgSid:" + this.eQY.eJa + " img len" + this.eQY.eIZ.length + " " + com.tencent.mm.compatible.util.g.Ac());
                        this.eIX.a(this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb);
                    }
                    return true;
                case -205:
                    x.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bi.Xf(this.eOW), this.eRb});
                    f.a(this.eQY);
                    com.tencent.mm.plugin.c.a.pU("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.eOW);
                    intent.putExtra("binded_mobile", this.eRa);
                    intent.putExtra("close_safe_device_style", this.eRb);
                    intent.putExtra("from_source", 1);
                    a.ezn.g(this, intent);
                    return true;
                case -140:
                    if (!bi.oW(this.cbP)) {
                        aa.n(this, str, this.cbP);
                    }
                    return true;
                case -100:
                    String af;
                    com.tencent.mm.kernel.a.hold();
                    ActionBarActivity actionBarActivity = this.mController.tml;
                    g.Eg();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.Dh())) {
                        af = com.tencent.mm.bp.a.af(this.mController.tml, j.main_err_another_place);
                    } else {
                        g.Eg();
                        af = com.tencent.mm.kernel.a.Dh();
                    }
                    com.tencent.mm.ui.base.h.a(actionBarActivity, af, this.mController.tml.getString(j.app_tip), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LoginUI.l(LoginUI.this);
                        }
                    }, new 16(this));
                    return true;
                case -75:
                    aa.ch(this.mController.tml);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.h.i(this.mController.tml, j.regbyqq_auth_err_failed_niceqq, j.app_tip);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.h.i(this, j.login_err_mailnotverify, j.login_err_title);
                    return true;
                case -3:
                    com.tencent.mm.ui.base.h.i(this, j.errcode_password, j.login_err_title);
                    return true;
                case -1:
                    if (g.DF().Lg() != 5) {
                        return false;
                    }
                    com.tencent.mm.ui.base.h.i(this, j.net_warn_server_down_tip, j.net_warn_server_down);
                    return true;
            }
        }
        return this.eRi.a(this, new ah(i, i2, str));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START) {
            int i3;
            g.DF().b(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
            this.cbP = ((q) lVar).Rd();
            this.eQY.eJa = ((q) lVar).Re();
            this.eQY.eIZ = ((q) lVar).Rf();
            this.eQY.eJb = ((q) lVar).Rg();
            this.eQY.eRQ = ((q) lVar).getSecCodeType();
            this.eQY.account = ((q) lVar).account;
            if (i2 == -205) {
                this.eOW = ((q) lVar).Ok();
                this.eRa = ((q) lVar).Rh();
                this.eRb = ((q) lVar).Rk();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                g.DF().a(new bg(new 17(this)), 0);
                i3 = 1;
            } else {
                boolean i32 = false;
            }
            if (i32 != 0 || (i == 0 && i2 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                aa.oS(this.eQY.account);
                String I = at.dBv.I("login_weixin_username", "");
                com.tencent.mm.platformtools.x.bZ(this);
                if (this.eSf) {
                    bt.dDs.W(this.eSe, I);
                    bt.dDs.d(com.tencent.mm.model.q.GF(), com.tencent.mm.model.q.Ho());
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(9), bt.dDs.II()});
                }
                aa.showAddrBookUploadConfirm(this, new 18(this, lVar), false, 2);
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                g.Eg();
                com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",4").toString());
                if (this.eSi) {
                    I = ad.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                    h.mEJ.h(11930, new Object[]{I, Integer.valueOf(4)});
                }
            } else if (i2 == -106) {
                aa.e(this, str, 32644);
            } else if (i2 == -217) {
                aa.a(this, com.tencent.mm.platformtools.f.a((q) lVar), i2);
            } else if (!e(i, i2, str)) {
                if (i2 == -5) {
                    Toast.makeText(this, getString(j.loginby_access_denied), 0).show();
                    return;
                }
                com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                if (eV == null || !eV.a(this, null, null)) {
                    Toast.makeText(this, getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }

    private void Yz() {
        this.eQY.account = this.eRX.getText().toString().trim();
        this.eQY.eIY = this.eRY.getText().toString();
        if (this.eQY.account.equals("")) {
            com.tencent.mm.ui.base.h.i(this, j.verify_username_null_tip, j.login_err_title);
        } else if (this.eQY.eIY.equals("")) {
            com.tencent.mm.ui.base.h.i(this, j.verify_password_null_tip, j.login_err_title);
        } else {
            YC();
            g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
            q qVar = new q(this.eQY.account, this.eQY.eIY, this.eOW, 2);
            g.DF().a(qVar, 0);
            getString(j.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(this, getString(j.login_logining), true, new 19(this, qVar));
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(com.tencent.mm.plugin.account.a.a.anim_not_change, com.tencent.mm.plugin.account.a.a.anim_not_change);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 != -1) {
            return;
        }
        if (i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginUI";
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
                this.eQY.eIY = stringExtra;
                Yz();
            }
        } else if (i == 32644 && intent != null) {
            Bundle bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                if (!bi.oW(bundleExtra.getString("VoiceLoginAuthPwd"))) {
                    this.eQY.eIY = intent.getStringExtra("VoiceLoginAuthPwd");
                }
                Yz();
            }
        }
    }
}
