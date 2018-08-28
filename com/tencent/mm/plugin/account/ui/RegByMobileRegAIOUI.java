package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.a$c;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;

public class RegByMobileRegAIOUI extends MMActivity implements e {
    private String countryCode = null;
    private String dYy = null;
    private ImageView eCl;
    private LinearLayout eGq;
    private TextView eGs;
    private String eGw = null;
    private String eHy;
    private p eIV;
    private int eLS;
    private ProgressBar eNA;
    private ag eNF = new 13(this);
    private c eNq = null;
    private String eQJ = null;
    private com.tencent.mm.sdk.b.c eQf = new 1(this);
    private ResizeLayout eRf;
    private String eSE;
    private TextView eSQ;
    private Button eSS;
    private boolean eSY = true;
    private final int eSj = 128;
    private String eSv;
    private String eSw;
    private int eSx = 0;
    private String eTa = null;
    private EditText eUI;
    private MMFormInputView eUJ;
    private String eUK = null;
    private MMFormInputView eUL;
    private boolean eUM = false;
    private ImageView eUN;
    private MMFormInputView eUO;
    private boolean eUP;
    private boolean eUQ;
    private ScrollView eUR;
    private boolean eUS = false;
    private boolean eUT = true;
    private s eUU;
    private boolean eUV = false;
    private s$a eUW = new 14(this);
    private int eUX;
    private int eUY;
    private boolean eUZ;
    private boolean eVa;
    private int progress = 0;

    protected final int getLayoutId() {
        return g.regbymobile_reg_aio;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dYy = bi.aG(getIntent().getStringExtra("country_name"), "");
        this.countryCode = ap.Wx(bi.aG(getIntent().getStringExtra("couttry_code"), ""));
        this.eQJ = bi.oV(getIntent().getStringExtra("iso_code"));
        this.eGw = bi.aG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.eLS = getIntent().getIntExtra("login_type", 0);
        initView();
    }

    public void onResume() {
        a.sFg.b(this.eQf);
        super.onResume();
        com.tencent.mm.kernel.g.DF().a(701, this);
        com.tencent.mm.kernel.g.DF().a(145, this);
        com.tencent.mm.kernel.g.DF().a(132, this);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE200_100,");
        com.tencent.mm.kernel.g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE200_100")).append(",1").toString());
        this.eSx = 0;
    }

    public void onPause() {
        super.onPause();
        if (this.eIV != null) {
            this.eIV.dismiss();
        }
        a.sFg.c(this.eQf);
        com.tencent.mm.kernel.g.DF().b(701, this);
        com.tencent.mm.kernel.g.DF().b(145, this);
        com.tencent.mm.kernel.g.DF().b(132, this);
        com.tencent.mm.plugin.c.a.pT("RE200_100");
    }

    protected final void initView() {
        this.eGq = (LinearLayout) findViewById(f.country_code_ll);
        this.eGs = (TextView) findViewById(f.country_name);
        this.eUJ = (MMFormInputView) findViewById(f.regbymobilereg_mobile_input_view);
        this.eUJ.setInputType(3);
        this.eUI = this.eUJ.getContentEditText();
        this.eSQ = (TextView) findViewById(f.agree_text);
        this.eSS = (Button) findViewById(f.reg_next);
        this.eCl = (ImageView) findViewById(f.setinfo_avatar);
        this.eUN = (ImageView) findViewById(f.setinfo_camera);
        this.eUL = (MMFormInputView) findViewById(f.regbymobile_setpassword_container);
        com.tencent.mm.ui.tools.a.c.d(this.eUL.getContentEditText()).Gi(16).a(null);
        this.eUR = (ScrollView) findViewById(f.scrollView);
        this.eRf = (ResizeLayout) findViewById(f.resize_lv);
        this.eUO = (MMFormInputView) findViewById(f.reg_nick_input_view);
        this.eRf.setOnSizeChanged(new 12(this));
        this.eUQ = true;
        this.eUP = true;
        String string = getString(j.license_agree_text);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        CharSequence newSpannable;
        if (w.chM()) {
            string2 = getString(j.license_detail);
            string3 = getString(j.privacy_detail);
            string4 = getString(j.and);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new 16(this), string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new 17(this), ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + str.length()) + string2.length()) + string4.length()) + string3.length(), 33);
            this.eSQ.setText(newSpannable);
        } else {
            string2 = getString(j.license_terms_of_service);
            string3 = getString(j.license_privacy_policy);
            string4 = getString(j.and);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new 18(this), string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new 19(this), ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            this.eSQ.setText(newSpannable);
        }
        this.eSQ.setMovementMethod(LinkMovementMethod.getInstance());
        this.eUI.addTextChangedListener(new TextWatcher() {
            private ap eVd = new ap();

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.this.YW();
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.eUL.addTextChangedListener(new 21(this));
        this.eUO.addTextChangedListener(new 22(this));
        this.eSS.setOnClickListener(new 2(this));
        this.eSS.setEnabled(false);
        if (bi.oW(this.countryCode)) {
            this.dYy = getString(j.country_normal_name);
            this.countryCode = ap.Wx(getString(j.country_normal_code));
        } else {
            this.dYy = b.k(this, this.countryCode, getString(j.country_code));
        }
        if (bi.oW(this.dYy) || bi.oW(this.countryCode)) {
            this.eQJ = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.eQJ);
            if (bi.oW(this.eQJ)) {
                x.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
            } else {
                b.a j = b.j(this, this.eQJ, getString(j.country_code));
                if (j == null) {
                    x.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                } else {
                    this.dYy = j.dYy;
                    this.countryCode = j.dYx;
                }
            }
        }
        YK();
        if (this.eGw == null || this.eGw.equals("")) {
            com.tencent.mm.kernel.g.Em().a(new 3(this));
        } else {
            this.eUI.setText(this.eGw);
        }
        this.eGq.setOnClickListener(new 4(this));
        setBackBtn(new 5(this), i.actionbar_icon_close_black);
        this.eCl.setOnClickListener(new 6(this));
        com.tencent.mm.kernel.g.Em().a(new ah.a() {
            Bitmap bitmap;
            String nickname;

            public final boolean Ks() {
                if (!bi.oW(this.nickname) && bi.oW((RegByMobileRegAIOUI.this.eUO.getText()).trim())) {
                    RegByMobileRegAIOUI.this.eUO.setText(this.nickname);
                }
                if (com.tencent.mm.compatible.util.f.zZ()) {
                    if (!(this.bitmap == null || this.bitmap.isRecycled() || RegByMobileRegAIOUI.this.eUM)) {
                        RegByMobileRegAIOUI.this.eCl.setImageBitmap(this.bitmap);
                        RegByMobileRegAIOUI.this.eUN.setVisibility(8);
                        RegByMobileRegAIOUI.this.eUM = true;
                    }
                    return true;
                }
                x.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
                return false;
            }

            public final boolean Kr() {
                this.nickname = com.tencent.mm.platformtools.j.bW(RegByMobileRegAIOUI.this);
                this.bitmap = com.tencent.mm.platformtools.j.bX(RegByMobileRegAIOUI.this);
                if (!(this.bitmap == null || this.bitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.c.a(this.bitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.dgs + "temp.avatar", false);
                    } catch (Throwable e) {
                        x.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + e.getMessage());
                        x.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "", new Object[0]);
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|initView2";
            }
        });
        string = "";
        if (d.qVQ) {
            string = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(string);
        lF(getResources().getColor(a$c.normal_actionbar_color));
        cqh();
        if (com.tencent.mm.compatible.util.d.fR(23)) {
            getWindow().setStatusBarColor(getResources().getColor(a$c.navpage));
            cqc();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    private void WL() {
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE200_100,");
        com.tencent.mm.kernel.g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE200_100")).append(",2").toString());
        finish();
        overridePendingTransition(com.tencent.mm.plugin.account.a.a.anim_not_change, com.tencent.mm.plugin.account.a.a.anim_not_change);
    }

    private void pM(String str) {
        if (!this.eUQ || com.tencent.mm.platformtools.a.F(this, this.eUL.getText().toString())) {
            if (this.eIV != null) {
                this.eIV.dismiss();
            }
            getString(j.app_tip);
            this.eIV = h.a(this, getString(j.regbyfacebook_reg_setpwd_exiting), true, new 8(this));
            if (this.eLS == 0) {
                String Ww = ap.Ww(this.eUI.getText().toString().trim());
                int i = (this.eSv == null || this.eSw == null || Ww.equals(this.eSv) || !Ww.equals(this.eSw)) ? (this.eSv == null || this.eSw == null || this.eSw.equals(this.eSv) || Ww.equals(this.eSw)) ? 0 : 2 : 1;
                com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                aVar.hG(this.eSx);
                aVar.hH(i);
                com.tencent.mm.kernel.g.DF().a(aVar, 0);
                this.eSv = ap.Ww(this.eUI.getText().toString().trim());
                this.eSx++;
                return;
            }
            throw new IllegalArgumentException("NO IMPLEMENT");
        }
    }

    private void YK() {
        if (bi.oW(this.dYy) || bi.oW(this.countryCode)) {
            this.eGs.setText(getString(j.mobile_code_error));
        } else {
            this.eGs.setText(ap.fP(this.dYy, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 30846) {
            if (i2 == -1 && YW()) {
                YV();
                com.tencent.mm.plugin.c.a.pU("RE200_250");
                this.eUS = false;
            }
        } else if (i == 30847) {
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(712, 1, 1, false);
                return;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.a(712, 2, 1, false);
            this.eUT = false;
            pM(this.eUK + this.eTa);
        } else {
            switch (i2) {
                case 100:
                    this.dYy = bi.aG(intent.getStringExtra("country_name"), "");
                    this.countryCode = bi.aG(intent.getStringExtra("couttry_code"), "");
                    this.eQJ = bi.aG(intent.getStringExtra("iso_code"), "");
                    if (b.mm(this.countryCode)) {
                        Intent intent2 = new Intent(this, MobileInputUI.class);
                        intent2.putExtra("mobile_input_purpose", 2);
                        intent2.putExtra("couttry_code", this.countryCode);
                        intent2.putExtra("country_name", this.dYy);
                        startActivity(intent2);
                        finish();
                        overridePendingTransition(com.tencent.mm.plugin.account.a.a.anim_not_change, com.tencent.mm.plugin.account.a.a.anim_not_change);
                        return;
                    }
                    YK();
                    return;
                default:
                    Bitmap a = com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, intent);
                    if (a != null) {
                        this.eCl.setImageBitmap(a);
                        this.eUM = true;
                        this.eUN.setVisibility(8);
                        return;
                    }
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eIV != null) {
            this.eIV.dismiss();
            this.eIV = null;
        }
        if (i2 == -75) {
            h.i(this, j.alpha_version_tip_reg, j.reg_username_exist_title);
            return;
        }
        com.tencent.mm.h.a eV;
        if (lVar.getType() == 145) {
            String Ol;
            int Oh = ((com.tencent.mm.modelfriend.a) lVar).Oh();
            if (Oh == 12) {
                if (i2 == -41 || i2 == -59) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this, null, null);
                        return;
                    } else {
                        h.i(this, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
                        return;
                    }
                }
                this.eTa = ap.Ww(this.eTa);
                this.eSw = this.eUK + this.eTa;
                this.eSE = ((com.tencent.mm.modelfriend.a) lVar).Ow();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    Ol = ((com.tencent.mm.modelfriend.a) lVar).Ol();
                    if (!bi.oW(Ol)) {
                        this.eTa = Ol.trim();
                    }
                    com.tencent.mm.plugin.c.a.pT("RE200_100");
                    StringBuilder stringBuilder = new StringBuilder();
                    com.tencent.mm.kernel.g.Eg();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE200_200,");
                    com.tencent.mm.kernel.g.Eg();
                    com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE200_200")).append(",1").toString());
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                RegByMobileRegAIOUI.this.YV();
                                com.tencent.mm.plugin.c.a.pU("RE200_250");
                                RegByMobileRegAIOUI.this.eUS = true;
                            }
                        }, new 10(this));
                        return;
                    }
                    YV();
                    com.tencent.mm.plugin.c.a.pU("RE200_250");
                    this.eUS = false;
                    return;
                } else if (i2 == -355) {
                    aa.e(this, str, 30846);
                    return;
                } else if (i2 == -34) {
                    h.b(this, getString(j.bind_mcontact_err_freq_limit), "", true);
                    return;
                } else if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
                    Toast.makeText(this, getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            }
            if (Oh == 14) {
                if (i2 == 0 || str == null) {
                    if (((com.tencent.mm.modelfriend.a) lVar).Om() == 1) {
                        String str2 = this.eUK + this.eTa;
                        String Oo = ((com.tencent.mm.modelfriend.a) lVar).Oo();
                        Ol = ((com.tencent.mm.modelfriend.a) lVar).On();
                        Intent intent = new Intent(this, RegByMobileSendSmsUI.class);
                        intent.putExtra("regsession_id", this.eSE);
                        intent.putExtra("key_reg_style", 1);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", Oo);
                        intent.putExtra("verify_code", Ol);
                        intent.putExtra("kintent_nickname", this.eUO.getText().toString());
                        intent.putExtra("kintent_password", this.eUL.getText().toString());
                        intent.putExtra("kintent_hasavatar", this.eUM);
                        startActivity(intent);
                    } else {
                        this.eUX = ((com.tencent.mm.modelfriend.a) lVar).Oq();
                        this.eUY = ((com.tencent.mm.modelfriend.a) lVar).Or();
                        this.eUZ = ((com.tencent.mm.modelfriend.a) lVar).Os();
                        this.eVa = ((com.tencent.mm.modelfriend.a) lVar).Ot();
                        if (this.eUU == null) {
                            this.eUU = new s(this, this.eUW);
                            this.eUU.Zr();
                        }
                        if (this.eNq == null) {
                            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(g.reg_mobile_verify_progress_dialog_view, null);
                            this.eNA = (ProgressBar) inflate.findViewById(f.progress_dialog_bar);
                            TextView textView = (TextView) inflate.findViewById(f.verify_mobile_number);
                            this.eNq = h.a(this, false, getString(j.bind_mcontact_title_bind), inflate, "", "", null, null);
                            this.eUK = ap.Wy(this.countryCode);
                            textView.setText(this.eUK + " " + this.eUI.getText().toString());
                        } else {
                            this.eNq.show();
                        }
                        this.progress = 0;
                        this.eNA.setIndeterminate(false);
                        this.eNF.sendEmptyMessage(10);
                    }
                } else if (i2 == -41) {
                    h.i(this, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
                    return;
                } else if (i2 == -34) {
                    h.b(this, getString(j.bind_mcontact_err_freq_limit), "", true);
                    return;
                } else if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
                    Toast.makeText(this, getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            }
        }
        if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str) && lVar.getType() == 701) {
            eV = com.tencent.mm.h.a.eV(str);
            if (eV != null && !eV.a(this, null, null)) {
            }
        }
    }

    private void YV() {
        getString(j.app_tip);
        this.eIV = h.a(this, getString(j.regbyfacebook_reg_setpwd_exiting), true, new 11(this));
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(this.eUK + this.eTa, 14, "", 0, "");
        aVar.lD(this.eSE);
        com.tencent.mm.kernel.g.DF().a(aVar, 0);
    }

    protected void onDestroy() {
        if (this.eUU != null) {
            this.eUU.Zs();
            this.eUU = null;
        }
        if (this.eNq != null) {
            this.eNq.dismiss();
        }
        super.onDestroy();
    }

    private synchronized void pN(String str) {
        if (this.eUU != null) {
            this.eUU.Zs();
            this.eUU = null;
        }
        if (!this.eUV) {
            this.eUV = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.eUK + " " + this.eUI.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.eTa);
            intent.putExtra("country_name", this.dYy);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("login_type", this.eLS);
            intent.putExtra("mobileverify_countdownsec", this.eUX);
            intent.putExtra("mobileverify_countdownstyle", this.eUY);
            intent.putExtra("mobileverify_fb", this.eUZ);
            intent.putExtra("mobileverify_reg_qq", this.eVa);
            intent.putExtra("kintent_nickname", this.eUO.getText().toString());
            intent.putExtra("kintent_password", this.eUL.getText().toString());
            intent.putExtra("kintent_hasavatar", this.eUM);
            intent.putExtra("key_reg_style", 1);
            intent.putExtra("regsession_id", this.eSE);
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
        }
    }

    private boolean YW() {
        int i;
        boolean a;
        if (bi.oW(this.countryCode)) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.eUQ) {
            a = i & a(this.eUI.getText(), this.eUL.getText(), this.eUO.getText());
        } else {
            a = i & a(this.eUI.getText(), this.eUO.getText());
        }
        if (a) {
            this.eSS.setEnabled(true);
        } else {
            this.eSS.setEnabled(false);
        }
        return a;
    }

    private boolean a(Editable... editableArr) {
        boolean z;
        for (Object obj : editableArr) {
            if (obj == null || obj.toString().length() == 0) {
                z = false;
                break;
            }
        }
        z = true;
        if (z && this.eSY) {
            return true;
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileRegAIOUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0 && this.eUU != null) {
                    this.eUU.Yh();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
