package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.al.b;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.ui.e.1;
import com.tencent.mm.plugin.account.ui.e.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import java.util.ArrayList;
import java.util.List;

@a(19)
public class LoginHistoryUI extends MMActivity implements e {
    private String cbP = "";
    private SharedPreferences duR;
    protected ProgressDialog eHw = null;
    private SecurityImage eIX = null;
    protected int eLS;
    protected String eOW;
    protected TextView eQN;
    protected EditText eQO;
    protected Button eQP;
    protected Button eQQ;
    protected View eQR;
    protected View eQS;
    protected View eQT;
    protected Button eQU;
    protected Button eQV;
    private View eQW;
    protected Button eQX;
    protected f eQY = new f();
    protected String eQZ;
    private c eQf = new 1(this);
    protected String eRa;
    private String eRb;
    private String eRc;
    private ImageView eRd;
    private MMKeyboardUperView eRe;
    private ResizeLayout eRf;
    protected String eRg;
    private String eRh;
    private d eRi;
    protected LinearLayout eRj;
    protected LinearLayout eRk;
    protected LinearLayout eRl;
    protected MMFormInputView eRm;
    protected MMFormVerifyCodeInputView eRn;
    private Button eRo;
    protected String eRp = "";
    protected boolean eRq = false;
    protected boolean eRr;
    private int eRs;
    private int eRt;
    private boolean eRu = false;
    private String eRv;
    protected int[] eRw = new int[5];
    private int eRx;
    private String eRy;
    private int eRz = 0;

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI) {
        af.Wq("welcome_page_show");
        k.j(loginHistoryUI, true);
        y yVar = new y();
        yVar.bHg.bHh = false;
        com.tencent.mm.sdk.b.a.sFg.m(yVar);
        ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().vo();
        loginHistoryUI.finish();
        ActionBarActivity actionBarActivity = loginHistoryUI.mController.tml;
        x.chR();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(actionBarActivity, Class.forName(ad.chW()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "", new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(actionBarActivity instanceof Activity)) {
            intent.addFlags(268435456);
        }
        actionBarActivity.startActivity(intent);
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI, int i) {
        loginHistoryUI.eRw[3] = 1;
        Intent intent;
        switch (i) {
            case 7001:
                intent = new Intent(loginHistoryUI, LoginVoiceUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.eRc);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            case 7006:
                intent = new Intent(loginHistoryUI, LoginFaceUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.eRc);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            case 7007:
                intent = new Intent(loginHistoryUI, LoginPasswordUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.eRc);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            case 7008:
                intent = new Intent(loginHistoryUI, LoginSmsUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.eRc);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void d(LoginHistoryUI loginHistoryUI) {
        loginHistoryUI.eRw[4] = 1;
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        int[] iArr = new int[5];
        iArr[4] = 1;
        intent.putExtra("kv_report_login_method_data", iArr);
        loginHistoryUI.startActivity(intent);
    }

    static /* synthetic */ void e(LoginHistoryUI loginHistoryUI) {
        if (com.tencent.mm.protocal.d.qVQ) {
            String string = loginHistoryUI.getString(j.create_forbiden_uri, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.qVN), w.chP()});
            x.e("MicroMsg.LoginHistoryUI", "url " + string);
            P(loginHistoryUI.mController.tml, string);
            return;
        }
        Intent intent = new Intent(loginHistoryUI, RegByMobileRegAIOUI.class);
        intent.putExtra("login_type", 0);
        loginHistoryUI.startActivity(intent);
    }

    static /* synthetic */ void g(LoginHistoryUI loginHistoryUI) {
        int i = 0;
        if (loginHistoryUI.eRt == 0) {
            i = !b.PD() ? 7 : 6;
        } else {
            if (!((loginHistoryUI.eRt & 2) == 0 && (loginHistoryUI.eRt & 4) == 0)) {
                i = 2;
            }
            if ((loginHistoryUI.eRt & 4) != 0) {
                i |= 4;
            }
            if ((loginHistoryUI.eRt & 1) != 0) {
                i |= 1;
            }
        }
        i |= 8;
        com.tencent.mm.ui.tools.k kVar = new com.tencent.mm.ui.tools.k(loginHistoryUI);
        kVar.ofp = new 1(i, loginHistoryUI);
        kVar.ofq = new 2(loginHistoryUI);
        kVar.bEo();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[]{com.tencent.mm.plugin.account.a.a.ezo});
        com.tencent.mm.plugin.account.a.a.ezo.vo();
        this.duR = ad.getContext().getSharedPreferences(ad.chY(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.eRu = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            if (this.eRu) {
                this.eRv = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        initView();
        this.eRi = new d();
    }

    public void onDestroy() {
        x.i("MicroMsg.LoginHistoryUI", "onDestroy");
        g.DF().b(701, this);
        if (this.eRi != null) {
            this.eRi.close();
        }
        h.mEJ.h(14262, new Object[]{Integer.valueOf(this.eRw[0]), Integer.valueOf(this.eRw[1]), Integer.valueOf(this.eRw[2]), Integer.valueOf(this.eRw[3]), Integer.valueOf(this.eRw[4])});
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        m mVar;
        super.onResume();
        final List arrayList = new ArrayList();
        if (!(!YD() || this.eLS == 1 || (this.eRs & 131072) == 0)) {
            mVar = new m(this, 7001, 0);
            mVar.setTitle(j.login_login_by_voice_print);
            arrayList.add(mVar);
        }
        if (!(this.eLS == 5 || (this.eRs & 262144) == 0)) {
            mVar = new m(this, 7005, 0);
            mVar.setTitle(j.login_login_by_finger_print);
            arrayList.add(mVar);
        }
        if (!bi.oW(this.eRg)) {
            if (this.eLS != 2) {
                mVar = new m(this, 7007, 0);
                mVar.setTitle(getString(j.login_login_by_password));
                arrayList.add(mVar);
            }
            if (!(bi.oW(this.eRa) || this.eLS == 3)) {
                mVar = new m(this, 7008, 0);
                mVar.setTitle(getString(j.login_login_by_sms));
                arrayList.add(mVar);
            }
            if (this.eRg.equalsIgnoreCase(this.eQZ)) {
                this.eQO.setHint(getString(j.regbyqq_password_hint));
            }
        }
        if (arrayList.size() > 1) {
            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 1, false);
            dVar.ofp = new n.c() {
                public final void a(l lVar) {
                    if (lVar.size() == 0) {
                        for (m mVar : arrayList) {
                            if (mVar != null) {
                                lVar.twb.add(mVar);
                            }
                        }
                    }
                }
            };
            dVar.ofq = new 20(this);
            dVar.uJQ = new 21(this, dVar);
            this.eQQ.setVisibility(0);
            this.eQQ.setText(j.login_by_other_method);
            this.eQQ.setOnClickListener(new 23(this, dVar));
        } else if (arrayList.size() > 0) {
            this.eQQ.setVisibility(0);
            this.eQQ.setText(((m) arrayList.get(0)).getTitle());
            this.eQQ.setOnClickListener(new 24(this, arrayList));
        } else {
            this.eQQ.setVisibility(8);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        g.Eg();
        com.tencent.mm.kernel.a.DB();
        g.Eg();
        if (!com.tencent.mm.kernel.a.Dw() || this.eRg.equals("")) {
            if (com.tencent.mm.o.a.BP() == 2) {
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.Gq(j.check_db_size_tip_dangerous_title);
                aVar.abu(getString(j.check_db_size_tip_dangerous_message));
                aVar.mF(false);
                aVar.Gt(j.check_db_size_btn_dangerous_message).a(new 22(this));
                aVar.anj().show();
                com.tencent.mm.o.a.b(this, System.currentTimeMillis());
            }
        } else if (this.eHw == null || !this.eHw.isShowing()) {
            b(null);
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
    }

    private void goBack() {
        Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
        be.addFlags(67108864);
        if (bi.oW(this.eRc)) {
            be.putExtra("can_finish", true);
        }
        startActivity(be);
        finish();
        com.tencent.mm.ui.base.b.gF(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        this.eRj = (LinearLayout) findViewById(f.voice_print_ll);
        this.eRl = (LinearLayout) findViewById(f.face_print_ll);
        this.eRk = (LinearLayout) findViewById(f.finger_print_ll);
        this.eRm = (MMFormInputView) findViewById(f.login_password_input);
        this.eRn = (MMFormVerifyCodeInputView) findViewById(f.sms_verify_container);
        this.eRc = getIntent().getStringExtra("switch_login_wx_id");
        if (bi.oW(this.eRc)) {
            this.eRg = at.dBv.I("login_user_name", "");
            this.eRh = at.dBv.HL();
            this.eRt = bi.WU(at.dBv.I("last_bind_info", ""));
            if ((this.eRt & 1) != 0) {
                this.eQZ = at.dBv.I("last_login_bind_qq", "");
            }
            if ((this.eRt & 4) != 0) {
                this.eRa = at.dBv.I("last_login_bind_mobile", "");
            }
            this.eRs = bi.WU(at.dBv.I("last_login_use_voice", ""));
        } else {
            this.eRg = bt.dDs.getString(this.eRc, "login_user_name");
            this.eRh = bt.dDs.getString(this.eRc, "last_avatar_path");
            this.eRt = bi.WU(bt.dDs.getString(this.eRc, "last_bind_info"));
            if ((this.eRt & 1) != 0) {
                this.eQZ = bt.dDs.getString(this.eRc, "last_login_bind_qq");
            }
            if ((this.eRt & 4) != 0) {
                this.eRa = bt.dDs.getString(this.eRc, "last_login_bind_mobile");
            }
            this.eRs = bi.WU(bt.dDs.getString(this.eRc, "last_login_use_voice"));
            setBackBtn(new 25(this), i.actionbar_icon_close_black);
        }
        String stringExtra = getIntent().getStringExtra("email_address");
        if (!(bi.oW(stringExtra) || stringExtra.equalsIgnoreCase(this.eRg))) {
            this.eRg = stringExtra;
        }
        this.eRd = (ImageView) findViewById(f.last_avatar);
        if (!bi.oW(this.eRh)) {
            Bitmap jW = com.tencent.mm.aa.f.jW(this.eRh);
            if (jW != null && jW.getWidth() > 10) {
                this.eRd.setImageBitmap(Bitmap.createBitmap(jW, 5, 5, jW.getWidth() - 10, jW.getHeight() - 10, null, false));
            }
        }
        g.Eg();
        if (!com.tencent.mm.kernel.a.Dw() || this.eRg.equals("")) {
            this.eRe = (MMKeyboardUperView) findViewById(f.scrollView);
            this.eQN = (TextView) findViewById(f.login_account_auto);
            this.eQO = this.eRm.getContentEditText();
            this.eQP = (Button) findViewById(f.login_btn);
            this.eQR = findViewById(f.login_voice_btn);
            this.eQS = findViewById(f.login_face_btn);
            this.eQT = (Button) findViewById(f.shua_fingerprint_btn);
            this.eQQ = (Button) findViewById(f.login_change_btn);
            this.eRo = (Button) findViewById(f.login_as_other_device_btn);
            this.eQU = (Button) findViewById(f.login_find_password_btn);
            this.eQV = (Button) findViewById(f.login_freeze_account_btn);
            this.eQW = findViewById(f.free_btn_container);
            this.eQX = (Button) findViewById(f.login_more_btn);
            this.eQU.setOnClickListener(new 26(this));
            this.eQV.setOnClickListener(new 27(this));
            if (!w.chM()) {
                this.eQW.setVisibility(8);
            }
            this.eRm.setVisibility(8);
            this.eRj.setVisibility(8);
            this.eRl.setVisibility(8);
            this.eRk.setVisibility(8);
            this.eQP.setVisibility(8);
            this.eQR.setVisibility(8);
            this.eQS.setVisibility(8);
            this.eQT.setVisibility(8);
            this.eQQ.setVisibility(8);
            com.tencent.mm.ui.tools.a.c.d(this.eQO).fj(4, 16).a(null);
            this.eRf = (ResizeLayout) findViewById(f.resize_lv);
            if (!bi.Xd(this.eRg).booleanValue() || this.eRg.equals(this.eQZ)) {
                this.eRw[2] = 2;
                this.eQN.setText(this.eRg);
            } else {
                this.eRw[2] = 1;
                this.eQN.setText(pK(this.eRg));
            }
            this.eRf.setOnSizeChanged(new 28(this));
            this.eRe.setOnTouchListener(new 29(this));
            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 1, false);
            dVar.ofp = new 30(this);
            dVar.ofq = new 2(this);
            dVar.uJQ = new 3(this, dVar);
            if (bi.oW(this.eRc)) {
                this.eQX.setOnClickListener(new 4(this, dVar));
            } else if (w.chM()) {
                this.eQX.setText(j.wechat_safe_center);
                this.eQX.setOnClickListener(new 6(this));
            } else {
                this.eQX.setText(j.wechat_help_center);
                this.eQX.setOnClickListener(new 5(this));
            }
            setMMTitle("");
            lF(getResources().getColor(com.tencent.mm.plugin.account.a.c.normal_actionbar_color));
            cqh();
            lD(false);
            if (com.tencent.mm.sdk.platformtools.e.sFE) {
                com.tencent.mm.plugin.account.a.a.ezo.g(this);
            }
            if (com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN) {
                this.eRo.setVisibility(0);
                this.eRo.setOnClickListener(new 7(this));
                return;
            }
            return;
        }
        this.eRq = true;
        b(null);
    }

    protected final String pK(String str) {
        ap apVar = new ap();
        String str2 = "86";
        if (this.eRg.startsWith("+")) {
            str = str.replace("+", "");
            str2 = ap.Fp(str);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return ap.formatNumber(str2, str);
    }

    protected final void YA() {
        g.DF().a(701, this);
    }

    protected final void YB() {
        g.DF().b(701, this);
    }

    protected void Yz() {
        this.eQY.account = this.eRg.trim();
    }

    public final void YC() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        String stringExtra;
        if (i != 1024 || intent == null) {
            if (i != 1025 || intent == null) {
                if (i == 31685 && intent != null && i2 == -1) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                        if (!bi.oW(bundleExtra.getString("VoiceLoginAuthPwd"))) {
                            this.eRp = bundleExtra.getString("VoiceLoginAuthPwd");
                        }
                        Yz();
                    }
                }
            } else if (i2 == 2) {
                stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                str = "MicroMsg.LoginHistoryUI";
                str2 = "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bi.oW(stringExtra));
                if (!bi.oW(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                x.i(str, str2, objArr);
                pL(stringExtra);
            }
        } else if (i2 == -1) {
            stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginHistoryUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oW(stringExtra));
            if (!bi.oW(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.d(str2, str3, objArr2);
            pL(stringExtra);
        }
    }

    private void pL(String str) {
        this.eRp = str;
        Yz();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        x.d("MicroMsg.LoginHistoryUI", "Scene Type " + lVar.getType());
        com.tencent.mm.h.a eV;
        boolean z;
        if (lVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX) {
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            int Oh = ((com.tencent.mm.modelfriend.a) lVar).Oh();
            if (Oh == 16) {
                if (i2 == -41) {
                    com.tencent.mm.ui.base.h.i(this, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
                    this.eRn.reset();
                    return;
                } else if (i2 == -75) {
                    com.tencent.mm.ui.base.h.b(this, getString(j.alpha_version_tip_login), "", true);
                    this.eRn.reset();
                    return;
                }
            } else if (Oh == 17) {
                this.eRx = i2;
                this.eRy = str;
                if (i == 0 && i2 == 0) {
                    new g(new 8(this), ((com.tencent.mm.modelfriend.a) lVar).getUsername(), ((com.tencent.mm.modelfriend.a) lVar).Oi(), this.eRa).a(this);
                    return;
                } else if (!e(i, i2, str)) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this, null, null);
                    }
                } else {
                    return;
                }
            }
        } else if (lVar.getType() == 701) {
            this.cbP = ((q) lVar).Rd();
            x.e("MicroMsg.LoginHistoryUI", "url " + this.cbP);
            g.DF().b(701, this);
            this.eQY.eRQ = ((q) lVar).getSecCodeType();
            this.eQY.eJa = ((q) lVar).Re();
            this.eQY.eIZ = ((q) lVar).Rf();
            this.eQY.eJb = ((q) lVar).Rg();
            if (i2 == -205) {
                this.eOW = ((q) lVar).Ok();
                this.eRa = ((q) lVar).Rh();
                this.eRb = ((q) lVar).Rk();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                g.DF().a(new bg(new 9(this)), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.platformtools.x.bZ(this);
                aa.oS(this.eQY.account);
                if (this.eHw != null && this.eHw.isShowing()) {
                    this.eHw.setMessage(getString(j.app_loading));
                }
                b((q) lVar);
                if (this.eLS == 3) {
                    this.eRr = ((q) lVar).Rm();
                    g.DF().a(255, this);
                    r rVar = new r(1);
                    g.DF().a(rVar, 0);
                    getString(j.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(this, getString(j.app_loading), true, new 10(this, rVar));
                    return;
                }
                return;
            }
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i2 == -106) {
                aa.e(this, str, 31685);
                return;
            } else if (i2 == -217) {
                aa.a(this, com.tencent.mm.platformtools.f.a((q) lVar), i2);
                return;
            } else if (!e(i, i2, str)) {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV == null || !eV.a(this, null, null)) {
                    Toast.makeText(this, getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (lVar.getType() == 255) {
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            g.DF().b(255, this);
            if (i != 0 || i2 != 0) {
                z = this.eRr;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(j.settings_modify_password_tip));
                intent.putExtra("kintent_cancelable", z);
                startActivity(intent);
                return;
            }
            return;
        }
        if (!e(i, i2, str)) {
        }
    }

    private void b(q qVar) {
        x.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
        be.addFlags(67108864);
        if (qVar != null) {
            be.putExtra("kstyle_show_bind_mobile_afterauth", qVar.Ri());
            be.putExtra("kstyle_bind_recommend_show", qVar.Rl());
            be.putExtra("kstyle_bind_wording", qVar.Rj());
        }
        startActivity(be);
        finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r12, int r13, java.lang.String r14) {
        /*
        r11 = this;
        r5 = 2;
        r10 = 1;
        r0 = 4;
        if (r12 != r0) goto L_0x0008;
    L_0x0005:
        switch(r13) {
            case -311: goto L_0x00a2;
            case -310: goto L_0x00a2;
            case -205: goto L_0x015b;
            case -140: goto L_0x01a3;
            case -100: goto L_0x0127;
            case -75: goto L_0x007b;
            case -72: goto L_0x0072;
            case -33: goto L_0x0093;
            case -32: goto L_0x0080;
            case -9: goto L_0x0069;
            case -6: goto L_0x00a2;
            case -3: goto L_0x001b;
            case -1: goto L_0x0055;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = com.tencent.mm.plugin.account.a.a.ezo;
        r0 = r0.a(r11, r12, r13, r14);
        if (r0 == 0) goto L_0x01b3;
    L_0x0010:
        r0 = r11.eIX;
        if (r0 == 0) goto L_0x0019;
    L_0x0014:
        r0 = r11.eIX;
        r0.dismiss();
    L_0x0019:
        r0 = r10;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r11.eRz;
        if (r0 > 0) goto L_0x002e;
    L_0x001f:
        r0 = com.tencent.mm.plugin.account.a.j.errcode_password;
        r1 = com.tencent.mm.plugin.account.a.j.login_err_title;
        com.tencent.mm.ui.base.h.i(r11, r0, r1);
        r0 = r11.eRz;
        r0 = r0 + 1;
        r11.eRz = r0;
    L_0x002c:
        r0 = r10;
        goto L_0x001a;
    L_0x002e:
        r0 = com.tencent.mm.plugin.account.a.j.errcode_password_ask_if_forgot_pwd;
        r1 = r11.getString(r0);
        r0 = com.tencent.mm.plugin.account.a.j.login_err_title;
        r2 = r11.getString(r0);
        r0 = com.tencent.mm.plugin.account.a.j.errcode_password_go_forgot_pwd;
        r3 = r11.getString(r0);
        r0 = com.tencent.mm.plugin.account.a.j.app_cancel;
        r4 = r11.getString(r0);
        r5 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$11;
        r5.<init>(r11);
        r6 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$12;
        r6.<init>(r11);
        r0 = r11;
        com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x002c;
    L_0x0055:
        r0 = com.tencent.mm.kernel.g.DF();
        r0 = r0.Lg();
        r1 = 5;
        if (r0 != r1) goto L_0x0069;
    L_0x0060:
        r0 = com.tencent.mm.plugin.account.a.j.net_warn_server_down_tip;
        r1 = com.tencent.mm.plugin.account.a.j.net_warn_server_down;
        com.tencent.mm.ui.base.h.i(r11, r0, r1);
        r0 = r10;
        goto L_0x001a;
    L_0x0069:
        r0 = com.tencent.mm.plugin.account.a.j.login_err_mailnotverify;
        r1 = com.tencent.mm.plugin.account.a.j.login_err_title;
        com.tencent.mm.ui.base.h.i(r11, r0, r1);
        r0 = r10;
        goto L_0x001a;
    L_0x0072:
        r0 = com.tencent.mm.plugin.account.a.j.regbyqq_auth_err_failed_niceqq;
        r1 = com.tencent.mm.plugin.account.a.j.app_tip;
        com.tencent.mm.ui.base.h.i(r11, r0, r1);
        r0 = r10;
        goto L_0x001a;
    L_0x007b:
        com.tencent.mm.platformtools.aa.ch(r11);
        r0 = r10;
        goto L_0x001a;
    L_0x0080:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_verify_error;
        r0 = r11.getString(r0);
        r1 = "";
        r2 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$13;
        r2.<init>(r11);
        com.tencent.mm.ui.base.h.a(r11, r0, r1, r2);
        r0 = r10;
        goto L_0x001a;
    L_0x0093:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_verify_err_time_out_content;
        r1 = com.tencent.mm.plugin.account.a.j.bind_mcontact_verify_tip;
        r2 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$14;
        r2.<init>(r11);
        com.tencent.mm.ui.base.h.a(r11, r0, r1, r2);
        r0 = r10;
        goto L_0x001a;
    L_0x00a2:
        r0 = com.tencent.mm.kernel.g.DF();
        r1 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        r0.a(r1, r11);
        r0 = r11.eIX;
        if (r0 != 0) goto L_0x00d8;
    L_0x00af:
        r1 = com.tencent.mm.plugin.account.a.j.regbyqq_secimg_title;
        r0 = r11.eQY;
        r2 = r0.eRQ;
        r0 = r11.eQY;
        r3 = r0.eIZ;
        r0 = r11.eQY;
        r4 = r0.eJa;
        r0 = r11.eQY;
        r5 = r0.eJb;
        r6 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$15;
        r6.<init>(r11, r12);
        r7 = 0;
        r8 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$16;
        r8.<init>(r11);
        r9 = r11.eQY;
        r0 = r11;
        r0 = com.tencent.mm.ui.applet.SecurityImage.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r11.eIX = r0;
    L_0x00d5:
        r0 = r10;
        goto L_0x001a;
    L_0x00d8:
        r0 = "MicroMsg.LoginHistoryUI";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r11.eQY;
        r2 = r2.eJa;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r11.eQY;
        r2 = r2.eIZ;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.Ac();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r11.eIX;
        r1 = r11.eQY;
        r1 = r1.eRQ;
        r2 = r11.eQY;
        r2 = r2.eIZ;
        r3 = r11.eQY;
        r3 = r3.eJa;
        r4 = r11.eQY;
        r4 = r4.eJb;
        r0.a(r1, r2, r3, r4);
        goto L_0x00d5;
    L_0x0127:
        com.tencent.mm.kernel.a.hold();
        com.tencent.mm.kernel.g.Eg();
        r0 = com.tencent.mm.kernel.a.Dh();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0153;
    L_0x0137:
        r0 = com.tencent.mm.plugin.account.a.j.main_err_another_place;
        r0 = com.tencent.mm.bp.a.af(r11, r0);
    L_0x013d:
        r1 = com.tencent.mm.plugin.account.a.j.app_tip;
        r1 = r11.getString(r1);
        r2 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$17;
        r2.<init>();
        r3 = new com.tencent.mm.plugin.account.ui.LoginHistoryUI$18;
        r3.<init>(r11);
        com.tencent.mm.ui.base.h.a(r11, r0, r1, r2, r3);
        r0 = r10;
        goto L_0x001a;
    L_0x0153:
        com.tencent.mm.kernel.g.Eg();
        r0 = com.tencent.mm.kernel.a.Dh();
        goto L_0x013d;
    L_0x015b:
        r0 = "MicroMsg.LoginHistoryUI";
        r1 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r2 = new java.lang.Object[r5];
        r3 = 0;
        r4 = r11.eOW;
        r4 = com.tencent.mm.sdk.platformtools.bi.Xf(r4);
        r2[r3] = r4;
        r3 = r11.eRb;
        r2[r10] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r11.eQY;
        com.tencent.mm.plugin.account.ui.f.a(r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "auth_ticket";
        r2 = r11.eOW;
        r0.putExtra(r1, r2);
        r1 = "binded_mobile";
        r2 = r11.eRa;
        r0.putExtra(r1, r2);
        r1 = "close_safe_device_style";
        r2 = r11.eRb;
        r0.putExtra(r1, r2);
        r1 = "from_source";
        r0.putExtra(r1, r5);
        r1 = com.tencent.mm.plugin.account.a.a.ezn;
        r1.g(r11, r0);
        r0 = r10;
        goto L_0x001a;
    L_0x01a3:
        r0 = r11.cbP;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x01b0;
    L_0x01ab:
        r0 = r11.cbP;
        com.tencent.mm.platformtools.aa.n(r11, r14, r0);
    L_0x01b0:
        r0 = r10;
        goto L_0x001a;
    L_0x01b3:
        r0 = new com.tencent.mm.platformtools.ah;
        r0.<init>(r12, r13, r14);
        r1 = r11.eRi;
        r0 = r1.a(r11, r0);
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.LoginHistoryUI.e(int, int, java.lang.String):boolean");
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.login_history;
    }

    public void setRequestedOrientation(int i) {
    }

    public static void P(Context context, String str) {
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

    public boolean YD() {
        return true;
    }
}
