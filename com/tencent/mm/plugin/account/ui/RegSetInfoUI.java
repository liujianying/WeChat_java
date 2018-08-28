package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.t;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.u;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI extends MMActivity implements e {
    private String bgn;
    private String eHp;
    private ProgressDialog eHw = null;
    private SecurityImage eIX = null;
    private d eRi;
    private String eSE;
    private int eTq;
    private int eTw;
    private boolean eUM = false;
    private EditText eVq;
    private View eWA;
    private TextView eWB;
    private String eWC = null;
    private boolean eWD = false;
    private o eWE;
    private View eWF;
    private boolean eWG = false;
    private String eWH;
    private al eWI = new al(Looper.myLooper(), new 1(this), true);
    private EditText eWj;
    private Button eWk;
    private String eWl;
    private String eWm;
    private int eWn;
    private String eWo;
    private String eWp;
    private TextView eWq;
    private View eWr;
    private boolean eWs = false;
    private ImageView eWt;
    private int eWu = 3;
    private LinkedList<String> eWv = new LinkedList();
    private ImageView eWw;
    private ProgressBar eWx;
    private String eWy = "";
    private ImageView eWz;
    private int sceneType = 0;

    static /* synthetic */ void p(RegSetInfoUI regSetInfoUI) {
        regSetInfoUI.bgn = regSetInfoUI.eVq.getText().toString().trim();
        regSetInfoUI.eWH = regSetInfoUI.eWj.getText().toString().trim();
        String charSequence;
        if (bi.oW(regSetInfoUI.bgn)) {
            h.i(regSetInfoUI, j.verify_account_null_tip, j.regbymobile_reg_setpwd_alert_title);
        } else if (regSetInfoUI.eWx.getVisibility() == 0) {
            regSetInfoUI.getString(j.app_tip);
            regSetInfoUI.eHw = h.a(regSetInfoUI, regSetInfoUI.getString(j.regbyqq_reg_waiting), true, new 6(regSetInfoUI));
        } else if (regSetInfoUI.Ze() && regSetInfoUI.Zh() && !bi.oW(regSetInfoUI.eWH)) {
            charSequence = regSetInfoUI.eWq.getText().toString();
            if (bi.oW(charSequence) || charSequence.equals(regSetInfoUI.getString(j.regsetinfo_tip))) {
                charSequence = bi.oW(regSetInfoUI.eWC) ? regSetInfoUI.getString(j.regsetinfo_wechat_id_error) : regSetInfoUI.eWC;
            }
            h.b(regSetInfoUI, charSequence, "", true);
        } else {
            regSetInfoUI.YC();
            charSequence = ap.Fp(regSetInfoUI.eWl);
            x.i("MiroMsg.RegSetInfoUI", "countryCode %s", new Object[]{charSequence});
            boolean z = !bi.oW(charSequence) && b.mm(charSequence);
            if (z) {
                if (bi.G(new String[]{regSetInfoUI.eWl, regSetInfoUI.eSE})) {
                    Intent intent = new Intent(regSetInfoUI, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 2);
                    intent.addFlags(67108864);
                    regSetInfoUI.startActivity(intent);
                    regSetInfoUI.finish();
                    return;
                }
                a.b(regSetInfoUI, regSetInfoUI.getString(j.gdpr_reg_verifybirthday_url, new Object[]{regSetInfoUI.eWl, regSetInfoUI.eSE, w.chP()}), 300, false);
                return;
            }
            regSetInfoUI.Zd();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(j.regsetinfo_title);
        if (com.tencent.mm.protocal.d.qVQ) {
            string = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(string);
        com.tencent.mm.plugin.account.a.a.ezo.vo();
        this.eWl = getIntent().getStringExtra("regsetinfo_user");
        this.eWm = getIntent().getStringExtra("regsetinfo_bind_email");
        this.eHp = getIntent().getStringExtra("regsetinfo_ticket");
        this.eWo = getIntent().getStringExtra("regsetinfo_pwd");
        this.eWp = getIntent().getStringExtra("regsetinfo_binduin");
        this.eTq = getIntent().getIntExtra("mobile_check_type", 0);
        if (!bi.oW(this.eWp)) {
            this.eWn = com.tencent.mm.a.o.cx(this.eWp);
        }
        this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.eWs = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.eWu = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        this.eSE = getIntent().getStringExtra("regsession_id");
        this.eTw = getIntent().getIntExtra("key_reg_style", 1);
        initView();
        StringBuilder stringBuilder;
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R200_900_phone");
        } else if (this.sceneType == 2) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R4_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R4_QQ")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R4_QQ");
        } else if (this.sceneType == 3) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_email,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_email")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R200_900_email");
        }
        this.eWG = false;
        this.eRi = new d();
    }

    public void onResume() {
        super.onResume();
        this.eVq.postDelayed(new 12(this), 500);
    }

    public void onDestroy() {
        super.onDestroy();
        StringBuilder stringBuilder;
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",2").toString());
        } else if (this.sceneType == 2) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R4_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R4_QQ")).append(",2").toString());
        } else if (this.sceneType == 3) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_email,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_email")).append(",2").toString());
        }
        if (this.eRi != null) {
            this.eRi.close();
        }
    }

    protected final void initView() {
        int i;
        int i2 = 0;
        this.eWF = findViewById(f.popup_anchor);
        this.eWA = findViewById(f.setinfo_avatar_ly);
        this.eWt = (ImageView) findViewById(f.setinfo_avatar);
        this.eVq = (EditText) findViewById(f.reg_nick);
        this.eWB = (TextView) findViewById(f.setinfo_tip);
        this.eWj = (EditText) findViewById(f.reg_wechatid);
        this.eWq = (TextView) findViewById(f.alias_tip);
        this.eWr = findViewById(f.regsetinfo_wid);
        this.eWw = (ImageView) findViewById(f.wechaid_iv);
        this.eWx = (ProgressBar) findViewById(f.progressBar);
        this.eWz = (ImageView) findViewById(f.setinfo_camera);
        this.eWk = (Button) findViewById(f.next_btn);
        this.eWw.setVisibility(8);
        this.eWx.setVisibility(8);
        this.eWz.setVisibility(8);
        this.eUM = false;
        this.eWD = false;
        this.eWA.setVisibility(Zg() ? 0 : 8);
        View view = this.eWr;
        if (Zh()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.eWq;
        if (!Zh()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (Zg() && Zh()) {
            this.eWB.setText(getString(j.regsetinfo_settip4));
        } else if (Zg() && !Zh()) {
            this.eWB.setText(getString(j.regsetinfo_settip2));
        } else if (Zg() || !Zh()) {
            this.eWB.setText(getString(j.regsetinfo_settip1));
        } else {
            this.eWB.setText(getString(j.regsetinfo_settip3));
        }
        g.Em().a(new 23(this));
        this.eVq.addTextChangedListener(new 28(this));
        this.eWk.setOnClickListener(new 29(this));
        this.eWj.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    RegSetInfoUI.this.eWG = true;
                    RegSetInfoUI.this.eWI.J(200, 200);
                }
            }
        });
        this.eWj.addTextChangedListener(new 31(this));
        setBackBtn(new 32(this));
        this.eVq.setOnEditorActionListener(new 33(this));
        this.eVq.setOnKeyListener(new 2(this));
        this.eWj.setOnEditorActionListener(new 3(this));
        this.eWj.setOnKeyListener(new 4(this));
        this.eWt.setOnClickListener(new 5(this));
        File file = new File(com.tencent.mm.compatible.util.e.dgs);
        if (!file.exists()) {
            file.mkdir();
        }
        Zf();
    }

    private void Zd() {
        s sVar;
        int Zm = Zm();
        g.DF().a(126, this);
        if (Zh()) {
            int i;
            if (this.eWv == null || this.eWv.size() == 0) {
                i = 0;
            } else if (this.eWv.contains(this.eWH)) {
                i = 1;
            } else {
                i = 2;
            }
            sVar = new s("", this.eWo, this.bgn, this.eWn, this.eWm, this.eWl, "", "", this.eHp, Zm, this.eWH, "", "", this.eWs, this.eUM);
            ((u.a) sVar.dJM.KV()).qWY.rYY = i;
        } else {
            sVar = new s("", this.eWo, this.bgn, this.eWn, this.eWm, this.eWl, "", "", this.eHp, Zm, "", "", "", this.eWs, this.eUM);
        }
        sVar.mX(this.eSE);
        sVar.im(this.eTq);
        g.DF().a(sVar, 0);
        getString(j.app_tip);
        this.eHw = h.a(this, getString(j.regbyqq_reg_waiting), true, new 7(this, sVar));
    }

    private void o(boolean z, boolean z2) {
        boolean z3 = false;
        if (bi.oW(this.eWj.getText().toString().trim())) {
            z = false;
        }
        this.eWw.setImageResource(z2 ? com.tencent.mm.plugin.account.a.e.signup_error : com.tencent.mm.plugin.account.a.e.signup_choose);
        this.eWw.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.eWD = z3;
    }

    private boolean Ze() {
        return this.eWw.getVisibility() == 8 || this.eWD;
    }

    private void Zf() {
        this.eWk.setEnabled(!bi.oW(this.eVq.getText().toString().trim()));
    }

    private boolean Zg() {
        return (this.eWu & 1) > 0;
    }

    private boolean Zh() {
        return (this.eWu & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent == null || i != 300) {
            Bitmap a = com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, intent);
            if (a != null) {
                this.eWt.setImageBitmap(a);
                this.eUM = true;
                this.eWz.setVisibility(0);
                return;
            }
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("birthdayComfirmOK")) {
            Zd();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.regbyqq_setinfo;
    }

    private boolean Zi() {
        return this.sceneType == 1;
    }

    private boolean Zj() {
        return this.sceneType == 2;
    }

    private boolean Zk() {
        return this.sceneType == 4;
    }

    private boolean Zl() {
        return this.sceneType == 3;
    }

    private int Zm() {
        if (Zi()) {
            return 4;
        }
        if (Zj()) {
            return 2;
        }
        if (Zl()) {
            return 6;
        }
        if (Zk()) {
            return 1;
        }
        return 2;
    }

    private String Zn() {
        if (Zi() || Zk()) {
            return this.eWl;
        }
        if (Zl()) {
            return this.eWm;
        }
        return this.eWp;
    }

    public final void a(int i, int i2, String str, l lVar) {
        int WU;
        com.tencent.mm.h.a eV;
        x.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 126) {
            g.DF().b(126, this);
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                this.eWC = null;
                String Zn = Zn();
                String Rp = ((s) lVar).Rp();
                int Rq = ((s) lVar).Rq();
                String str3 = null;
                String str4 = null;
                boolean z = false;
                Map z2 = bl.z(((s) lVar).Rr(), "wording");
                if (z2 != null) {
                    String str5 = (String) z2.get(".wording.switch");
                    if (bi.oW(str5)) {
                        z = true;
                    } else {
                        WU = bi.WU(str5);
                        if (WU == 0) {
                            z = false;
                        } else if (WU == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        str5 = (String) z2.get(".wording.title");
                        if (!bi.oW(str5)) {
                            str3 = str5;
                        }
                        str5 = (String) z2.get(".wording.desc");
                        if (bi.oW(str5)) {
                            str2 = str3;
                        } else {
                            str4 = str5;
                            str2 = str3;
                        }
                        x.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[]{r4});
                        com.tencent.mm.kernel.a.unhold();
                        com.tencent.mm.kernel.a.bt(true);
                        if (this.eUM) {
                            this.eHp = ((s) lVar).Rn();
                            at.dBv.T("login_user_name", Zn);
                            Intent be;
                            if (Rp == null || !Rp.contains("0")) {
                                be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                                be.addFlags(67108864);
                                be.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(be);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.Eg();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                                g.Eg();
                                com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",4").toString());
                                finish();
                            } else {
                                com.tencent.mm.plugin.c.a.pU("R300_100_phone");
                                if (z) {
                                    be = new Intent(this, FindMContactAlertUI.class);
                                    be.putExtra("alert_title", str2);
                                    be.putExtra("alert_message", str4);
                                } else {
                                    be = new Intent(this, FindMContactIntroUI.class);
                                }
                                be.addFlags(67108864);
                                be.putExtra("regsetinfo_ticket", this.eHp);
                                be.putExtra("regsetinfo_NextStep", Rp);
                                be.putExtra("regsetinfo_NextStyle", Rq);
                                Intent be2 = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                                be2.addFlags(67108864);
                                be2.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this, be, be2);
                                finish();
                            }
                        } else {
                            String str6 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar";
                            str5 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
                            new File(str6).renameTo(new File(str5));
                            com.tencent.mm.a.e.deleteFile(str6);
                            c.c(str5, 96, 96, CompressFormat.JPEG, 90, str6);
                            new com.tencent.mm.aa.o(this, com.tencent.mm.compatible.util.e.dgs + "temp.avatar").a(new 8(this, lVar, Zn, Rp, z, str2, str4, Rq), new 9(this, lVar, Zn, Rp, z, str2, str4, Rq));
                        }
                    }
                }
                str2 = null;
                x.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[]{r4});
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.kernel.a.bt(true);
                if (this.eUM) {
                    this.eHp = ((s) lVar).Rn();
                    at.dBv.T("login_user_name", Zn);
                    Intent be3;
                    if (Rp == null || !Rp.contains("0")) {
                        be3 = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                        be3.addFlags(67108864);
                        be3.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(be3);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        g.Eg();
                        stringBuilder2 = stringBuilder2.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                        g.Eg();
                        com.tencent.mm.plugin.c.a.pV(stringBuilder2.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",4").toString());
                        finish();
                    } else {
                        com.tencent.mm.plugin.c.a.pU("R300_100_phone");
                        if (z) {
                            be3 = new Intent(this, FindMContactAlertUI.class);
                            be3.putExtra("alert_title", str2);
                            be3.putExtra("alert_message", str4);
                        } else {
                            be3 = new Intent(this, FindMContactIntroUI.class);
                        }
                        be3.addFlags(67108864);
                        be3.putExtra("regsetinfo_ticket", this.eHp);
                        be3.putExtra("regsetinfo_NextStep", Rp);
                        be3.putExtra("regsetinfo_NextStyle", Rq);
                        Intent be22 = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                        be22.addFlags(67108864);
                        be22.putExtra("LauncherUI.enter_from_reg", true);
                        MMWizardActivity.b(this, be3, be22);
                        finish();
                    }
                } else {
                    String str62 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar";
                    str5 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
                    new File(str62).renameTo(new File(str5));
                    com.tencent.mm.a.e.deleteFile(str62);
                    c.c(str5, 96, 96, CompressFormat.JPEG, 90, str62);
                    new com.tencent.mm.aa.o(this, com.tencent.mm.compatible.util.e.dgs + "temp.avatar").a(new 8(this, lVar, Zn, Rp, z, str2, str4, Rq), new 9(this, lVar, Zn, Rp, z, str2, str4, Rq));
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                    return;
                } else if (e(i, i2, str)) {
                    return;
                }
            } else if (this.eIX == null) {
                this.eIX = SecurityImage.a.a(this.mController.tml, j.regbyqq_secimg_title, 0, ((s) lVar).Rf(), ((s) lVar).Re(), "", new 10(this, lVar), null, new 11(this), new 13(this, lVar));
                return;
            } else {
                this.eIX.a(0, ((s) lVar).Rf(), ((s) lVar).Re(), "");
                return;
            }
        }
        if (lVar.getType() == 429) {
            g.DF().b(429, this);
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            this.eWx.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.eWC = null;
                WU = ((t.b) ((ad) lVar).dJM.Id()).eKD.rLc;
                x.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[]{Integer.valueOf(WU)});
                if (WU == -14 || WU == -10 || WU == -7) {
                    LinkedList linkedList = ((t.b) ((ad) lVar).dJM.Id()).eKD.hbG;
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        this.eWq.setText(eV.desc);
                    }
                    this.eWv.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        String[] strArr = new String[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            strArr[i3] = ((bhz) linkedList.get(i3)).siM;
                            this.eWv.add(strArr[i3]);
                        }
                        if (this.eWG) {
                            if (this.eWE != null) {
                                this.eWE.dismiss();
                                this.eWE = null;
                            }
                            this.eWE = p.a(this, this.eWF, strArr, new 18(this, strArr));
                        }
                    }
                    o(true, true);
                    return;
                } else if (bi.oW(this.eWj.getText().toString().trim())) {
                    o(false, false);
                    return;
                } else {
                    o(true, false);
                    this.eWq.setText(getString(j.regsetinfo_tip));
                    if (this.eWE != null) {
                        this.eWE.dismiss();
                        this.eWE = null;
                    }
                    this.eWj.postDelayed(new 14(this), 50);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                o(true, true);
            } else if (this.eIX == null) {
                this.eIX = SecurityImage.a.a(this.mController.tml, j.regbyqq_secimg_title, 0, ((ad) lVar).Rf(), ((ad) lVar).Re(), "", new 15(this, lVar), null, new 16(this), new 17(this, lVar));
                return;
            } else {
                this.eIX.a(0, ((ad) lVar).Rf(), ((ad) lVar).Re(), "");
                return;
            }
        }
        if (!e(i, i2, str)) {
            if (i == 8) {
                this.eWC = getString(j.fmt_http_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, this.eWC, 0).show();
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(j.fmt_reg_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean e(int i, int i2, String str) {
        if (this.eRi.a(this, new ah(i, i2, str))) {
            return true;
        }
        if (com.tencent.mm.plugin.account.a.a.ezo.a(this.mController.tml, i, i2, str)) {
            return true;
        }
        switch (i2) {
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
                h.a(actionBarActivity, af, this.mController.tml.getString(j.app_tip), new 19(this), new 20(this));
                return true;
            case -75:
                h.i(this, j.alpha_version_tip_reg, j.reg_username_exist_title);
                return true;
            case -48:
                com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                } else {
                    h.b(this, getString(j.regsetinfo_ticket_notfound), "", true);
                }
                return true;
            case IX5WebViewClient.ERROR_UNSUPPORTED_SCHEME /*-10*/:
            case IX5WebViewClient.ERROR_IO /*-7*/:
                h.i(this, j.reg_username_exist_tip, j.reg_username_exist_title);
                return true;
            default:
                return false;
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
        YC();
        if (Zi()) {
            h.a(this, getString(j.regsetinfo_reverify), "", new 21(this), new 22(this));
        } else if (!Zj()) {
            if ((this.sceneType == 0 ? 1 : null) != null) {
                h.a(this, getString(j.regsetinfo_regqq_remind), "", new 24(this), new 25(this));
            } else if (Zl()) {
                h.a(this, getString(j.regsetinfo_regqq_remind), "", new 26(this), new 27(this));
            } else {
                com.tencent.mm.plugin.c.a.pU("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
    }
}
