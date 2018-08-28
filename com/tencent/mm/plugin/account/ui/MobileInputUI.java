package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.al.b;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a$a;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a$i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected int dBM;
    protected String dYy = null;
    protected LinearLayout eGq;
    protected TextView eGs;
    protected String eGw = null;
    protected String eHy;
    protected p eIV;
    protected String eQJ = null;
    protected EditText eQO;
    protected Button eQU;
    protected Button eQV;
    private View eQW;
    protected Button eQX;
    private c eQf = new 1(this);
    private ResizeLayout eRf;
    private Button eRo;
    protected int[] eRw = new int[5];
    protected MMFormInputView eSM;
    protected EditText eSN;
    protected MMFormVerifyCodeInputView eSO;
    protected View eSP;
    protected TextView eSQ;
    protected Button eSR;
    protected Button eSS;
    protected TextView eST;
    protected TextView eSU;
    protected TextView eSV;
    protected Button eSW;
    protected View eSX;
    protected boolean eSY = true;
    protected String eSZ = null;
    protected MMFormInputView eSa;
    protected boolean eSf;
    private d eSg;
    private MMKeyboardUperView eSh;
    protected boolean eSi = false;
    private final int eSj = 128;
    protected String eTa = null;
    private int eTb = 0;
    private b eTc;
    protected boolean eTd;

    static /* synthetic */ void c(MobileInputUI mobileInputUI) {
        View currentFocus = mobileInputUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            int height = (iArr[1] - mobileInputUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                mobileInputUI.eSh.post(new 11(mobileInputUI, height));
            }
        }
    }

    static /* synthetic */ boolean f(MobileInputUI mobileInputUI) {
        if (!(mobileInputUI.eSN.getText() == null || bi.oW(mobileInputUI.eSN.getText().toString()) || !mobileInputUI.eSY)) {
            if (mobileInputUI.eTb != 2) {
                return true;
            }
            if (!(mobileInputUI.eQO.getText() == null || bi.oW(mobileInputUI.eQO.getText().toString()))) {
                return true;
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return a$g.mobile_input_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTb = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.dBM = getIntent().getIntExtra("mobile_auth_type", 0);
        this.eTd = getIntent().getBooleanExtra("can_finish", false);
        setBackBtn(new 12(this), a$i.actionbar_icon_close_black);
        lF(this.mController.tml.getResources().getColor(a.c.normal_actionbar_color));
        cqh();
        switch (this.eTb) {
            case -1:
                this.eTc = new l();
                break;
            case 1:
                if (!bi.oW(getIntent().getStringExtra("auth_ticket"))) {
                    this.eTc = new l();
                    break;
                }
                int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                if (intArrayExtra != null) {
                    this.eRw = intArrayExtra;
                }
                this.eTc = new i();
                break;
            case 2:
                this.eTc = new k();
                break;
            case 3:
                this.eTc = new h();
                break;
            case 4:
                this.eTc = new j();
                break;
            default:
                x.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[]{Integer.valueOf(this.eTb)});
                finish();
                return;
        }
        this.countryCode = ap.Wx(bi.aG(getIntent().getStringExtra("couttry_code"), ""));
        this.dYy = bi.aG(getIntent().getStringExtra("country_name"), "");
        this.eQJ = bi.oV(getIntent().getStringExtra("iso_code"));
        this.eGw = bi.aG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.eSZ = ap.Wy(this.countryCode);
        this.eTa = bi.aG(getIntent().getStringExtra("input_mobile_number"), "");
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
        this.eSi = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(!this.eSi || bi.oW(this.eSZ) || bi.oW(this.eTa))) {
            this.eSM.setText(this.eTa);
        }
        this.eTc.a(this);
        if (com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN) {
            this.eRo.setVisibility(0);
            this.eRo.setOnClickListener(new 13(this));
        }
        this.eSf = getIntent().getBooleanExtra("from_switch_account", false);
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
        this.eTc.start();
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
        this.eTc.stop();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(a$a.anim_not_change, a$a.anim_not_change);
        h.mEJ.h(14262, new Object[]{Integer.valueOf(this.eRw[0]), Integer.valueOf(this.eRw[1]), Integer.valueOf(this.eRw[2]), Integer.valueOf(this.eRw[3]), Integer.valueOf(this.eRw[4])});
    }

    public void onDestroy() {
        this.eSO.reset();
        super.onDestroy();
    }

    protected final void initView() {
        this.eSa = (MMFormInputView) findViewById(a$f.setpassword_container);
        this.eQO = this.eSa.getContentEditText();
        com.tencent.mm.ui.tools.a.c.d(this.eQO).Gi(16).a(null);
        this.eSM = (MMFormInputView) findViewById(a$f.mobile_number_display);
        this.eSM.setInputType(3);
        this.eSN = this.eSM.getContentEditText();
        this.eSO = (MMFormVerifyCodeInputView) findViewById(a$f.sms_verify_container);
        this.eSO.setInputType(3);
        this.eGq = (LinearLayout) findViewById(a$f.country_code_ll);
        this.eGs = (TextView) findViewById(a$f.country_name);
        this.eSP = findViewById(a$f.reg_license);
        this.eSQ = (TextView) findViewById(a$f.agree_text);
        this.eSR = (Button) findViewById(a$f.agree_btn);
        this.eSS = (Button) findViewById(a$f.next_btn);
        this.eST = (TextView) findViewById(a$f.register_title);
        this.eSU = (TextView) findViewById(a$f.login_title);
        this.eSV = (TextView) findViewById(a$f.mobile_input_hint);
        this.eSW = (Button) findViewById(a$f.login_by_other);
        this.eRo = (Button) findViewById(a$f.login_as_other_device_btn);
        this.eQU = (Button) findViewById(a$f.login_find_password_btn);
        this.eQV = (Button) findViewById(a$f.login_freeze_account_btn);
        this.eQW = findViewById(a$f.free_btn_container);
        this.eQX = (Button) findViewById(a$f.login_more_btn);
        this.eSX = findViewById(a$f.bottom_btn_container);
        this.eRf = (ResizeLayout) findViewById(a$f.resize_lv);
        this.eSh = (MMKeyboardUperView) findViewById(a$f.scrollView);
        this.eGq.setVisibility(8);
        this.eSa.setVisibility(8);
        this.eSO.setVisibility(8);
        this.eSM.setVisibility(8);
        this.eST.setVisibility(8);
        this.eSU.setVisibility(8);
        this.eSS.setVisibility(8);
        this.eSP.setVisibility(8);
        this.eSW.setVisibility(8);
        this.eRf.setOnSizeChanged(new ResizeLayout.a() {
            public final void YE() {
                MobileInputUI.c(MobileInputUI.this);
            }
        });
        this.eQU.setOnClickListener(new 15(this));
        this.eQV.setOnClickListener(new 16(this));
        this.eSg = new d(this, 1, false);
        this.eSg.ofp = new n.c() {
            public final void a(l lVar) {
                if (lVar.crF()) {
                    lVar.eR(5001, j.wechat_safe_center);
                    lVar.eR(5002, j.wechat_help_center);
                }
            }
        };
        this.eSg.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 5001:
                        MobileInputUI.P(MobileInputUI.this, MobileInputUI.this.getString(j.wechat_securiy_center_path) + w.chP());
                        return;
                    case 5002:
                        MobileInputUI.P(MobileInputUI.this, MobileInputUI.this.getString(j.wechat_help_center_url) + w.chP());
                        return;
                    default:
                        return;
                }
            }
        };
        this.eSg.uJQ = new 2(this);
        if (w.chM()) {
            this.eQX.setOnClickListener(new 3(this));
        } else {
            this.eQW.setVisibility(8);
            this.eQX.setText(j.login_by_more);
            this.eQX.setOnClickListener(new 4(this));
        }
        this.eSN.addTextChangedListener(new 5(this));
        this.eQO.addTextChangedListener(new 6(this));
        this.eSN.setOnEditorActionListener(new 7(this));
        this.eSN.setOnKeyListener(new 8(this));
        this.eSS.setEnabled(false);
        this.eSS.setOnClickListener(new 9(this));
        if (bi.oW(this.countryCode)) {
            this.dYy = getString(j.country_normal_name);
            this.countryCode = ap.Wx(getString(j.country_normal_code));
        } else {
            this.dYy = b.k(this, this.countryCode, getString(j.country_code));
        }
        if (bi.oW(this.dYy) || bi.oW(this.countryCode)) {
            this.eQJ = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.eQJ);
            if (bi.oW(this.eQJ)) {
                x.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
            } else {
                b.a j = b.j(this, this.eQJ, getString(j.country_code));
                if (j == null) {
                    x.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                } else {
                    this.countryCode = ap.Wx(j.dYx);
                    this.dYy = j.dYy;
                }
            }
        }
        YK();
        if (bi.oW(this.eGw)) {
            this.eSN.setText(this.eGw);
        }
        this.eGq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", MobileInputUI.this.dYy);
                intent.putExtra("couttry_code", MobileInputUI.this.countryCode);
                intent.putExtra("iso_code", MobileInputUI.this.eQJ);
                com.tencent.mm.plugin.account.a.a.ezn.b(intent, MobileInputUI.this);
            }
        });
        String str = "";
        if (com.tencent.mm.protocal.d.qVQ) {
            str = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(str);
        lF(getResources().getColor(a.c.normal_actionbar_color));
        cqh();
    }

    private void YJ() {
        YC();
        this.eTc.jm(a.eTg);
    }

    private void goBack() {
        if (this.eTd) {
            YC();
            Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
            be.addFlags(67108864);
            be.putExtra("can_finish", true);
            startActivity(be);
            finish();
            com.tencent.mm.ui.base.b.gF(this);
            return;
        }
        this.eTc.jm(a.eTf);
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        YC();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void YK() {
        if (bi.oW(this.dYy) || bi.oW(this.countryCode)) {
            this.eGs.setText(getString(j.mobile_code_error));
        } else {
            this.eGs.setText(ap.fP(this.dYy, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundle = null;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i == 32047) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                h.mEJ.a(712, 1, 1, false);
                if (this.eTc instanceof k) {
                    ((k) this.eTc).eSF = 1;
                    return;
                }
                return;
            }
            h.mEJ.a(712, 2, 1, false);
            if (this.eTc instanceof k) {
                ((k) this.eTc).eSF = 0;
            }
            this.eTc.jm(a.eTg);
        } else if (i == 32046) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i2 == -1 && r0 != null && r0.getString("go_next", "").equals("get_reg_verify_code")) {
                if (this.eTc instanceof k) {
                    ((k) this.eTc).eSF = 2;
                }
                this.eTc.jm(a.eTg);
            }
        } else if (i == 32045) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i2 == -1 && bundle != null && bundle.getString("go_next", "").equals("auth_again") && (this.eTc instanceof l)) {
                if (!bi.oW(bundle.getString("VoiceLoginAuthPwd"))) {
                    ((l) this.eTc).eSH = intent.getStringExtra("VoiceLoginAuthPwd");
                }
                this.eTc.jm(a.eTg);
            }
        } else {
            switch (i2) {
                case -1:
                    if (i == 1024 && intent != null) {
                        String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                        int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                        String str = "MicroMsg.MobileInputUI";
                        String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(bi.oW(stringExtra));
                        if (!bi.oW(stringExtra)) {
                            i3 = stringExtra.length();
                        }
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = Integer.valueOf(intExtra);
                        x.d(str, str2, objArr);
                        if (intExtra == -217) {
                            YJ();
                            return;
                        }
                        return;
                    }
                    return;
                case 100:
                    this.dYy = bi.aG(intent.getStringExtra("country_name"), "");
                    this.countryCode = bi.aG(intent.getStringExtra("couttry_code"), "");
                    this.eQJ = bi.aG(intent.getStringExtra("iso_code"), "");
                    if (this.eTb != 2 || b.mm(this.countryCode)) {
                        YK();
                        return;
                    }
                    Intent intent2 = new Intent(this, RegByMobileRegAIOUI.class);
                    intent2.putExtra("couttry_code", this.countryCode);
                    intent2.putExtra("country_name", this.dYy);
                    intent2.putExtra("iso_code", this.eQJ);
                    startActivity(intent2);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    public void setRequestedOrientation(int i) {
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
}
