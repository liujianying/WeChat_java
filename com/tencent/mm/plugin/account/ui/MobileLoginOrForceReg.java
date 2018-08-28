package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.aa.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import java.io.File;

public class MobileLoginOrForceReg extends MMActivity implements e {
    private String bLe;
    private String bTi;
    private String cbP;
    private ImageView eCl;
    private TextView eGD;
    protected ProgressDialog eHw = null;
    private SecurityImage eIX = null;
    private f eQY = null;
    private c eQf = new 12(this);
    private d eRi;
    private g eSA = null;
    private String eSE;
    private Button eTi;
    private Button eTj;
    private LinearLayout eTk;
    private LinearLayout eTl;
    private TextView eTm;
    private int eTn;
    private String eTo;
    private String eTp;
    private int eTq;
    private String eTr;
    private boolean eTs = true;
    private boolean eTt;
    private String eTu;
    private String eTv;
    private int eTw;
    private int egg;
    private ag handler = new 1(this);
    private String nickname;
    private String username;

    static /* synthetic */ void m(MobileLoginOrForceReg mobileLoginOrForceReg) {
        s sVar = new s("", mobileLoginOrForceReg.eTv, mobileLoginOrForceReg.eTu, 0, "", mobileLoginOrForceReg.bTi, "", "", mobileLoginOrForceReg.bLe, mobileLoginOrForceReg.egg, "", "", "", true, mobileLoginOrForceReg.eTt);
        sVar.mX(mobileLoginOrForceReg.eSE);
        sVar.im(mobileLoginOrForceReg.eTq);
        g.DF().a(sVar, 0);
        ActionBarActivity actionBarActivity = mobileLoginOrForceReg.mController.tml;
        mobileLoginOrForceReg.getString(j.app_tip);
        mobileLoginOrForceReg.eHw = h.a(actionBarActivity, mobileLoginOrForceReg.getString(j.regbyqq_reg_waiting), true, new 11(mobileLoginOrForceReg, sVar));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTr = a.Zu();
        g.DF().a(701, this);
        g.DF().a(126, this);
        g.DF().a(255, this);
        this.eTw = getIntent().getIntExtra("key_reg_style", 1);
        this.bLe = getIntent().getStringExtra("ticket");
        this.bTi = getIntent().getStringExtra("moble");
        this.eTn = getIntent().getIntExtra("next_controll", 0);
        this.username = getIntent().getStringExtra("username");
        this.eTo = getIntent().getStringExtra("password");
        this.nickname = getIntent().getStringExtra("nickname");
        this.eTp = getIntent().getStringExtra("avatar_url");
        this.eSE = getIntent().getStringExtra("regsession_id");
        this.eTq = getIntent().getIntExtra("mobile_check_type", 0);
        this.eTt = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.eTu = getIntent().getStringExtra("kintent_nickname");
        this.eTv = getIntent().getStringExtra("kintent_password");
        if (this.eTv == null || this.eTv.length() < 8) {
            this.egg = 4;
        } else {
            this.egg = 1;
        }
        initView();
        this.eRi = new d();
    }

    public final void initView() {
        CharSequence charSequence;
        this.eTi = (Button) findViewById(f.continue_login);
        this.eTj = (Button) findViewById(f.force_reg);
        this.eTk = (LinearLayout) findViewById(f.has_avatar);
        this.eTl = (LinearLayout) findViewById(f.no_avatar);
        this.eCl = (ImageView) findViewById(f.avatar_iv);
        this.eTm = (TextView) findViewById(f.nickname_tv);
        this.eGD = (TextView) findViewById(f.bind_mcontact_verify_hint);
        ap apVar = new ap();
        if (this.bTi.startsWith("+")) {
            String Fp = ap.Fp(this.bTi);
            if (bi.oW(Fp)) {
                charSequence = this.bTi;
            } else {
                charSequence = "+" + Fp + " " + ap.formatNumber(Fp, this.bTi.substring(Fp.length() + 1));
            }
        } else {
            charSequence = "+86 " + ap.formatNumber("86", this.bTi);
        }
        this.eGD.setText(charSequence);
        if (bi.oW(this.nickname) && bi.oW(this.eTp)) {
            this.eTl.setVisibility(0);
            this.eTk.setVisibility(8);
        } else {
            this.eTl.setVisibility(8);
            this.eTk.setVisibility(0);
            if (bi.oW(this.nickname)) {
                this.eTm.setVisibility(8);
            } else {
                this.eTm.setText(this.nickname);
            }
            Bitmap uM = b.ccZ().uM();
            if (uM != null) {
                this.eCl.setImageBitmap(uM);
            }
            if (!bi.oW(this.eTp)) {
                g.Em().H(new 13(this, this.eTp));
            }
        }
        this.eTi.setOnClickListener(new 14(this));
        this.eTj.setOnClickListener(new 15(this));
        setMMTitle(j.mobile_input_already_bind_title_welcome_back);
        setBackBtn(new 16(this));
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_600,");
        g.Eg();
        a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_600")).append(",1").toString());
        a.pT("R200_600");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
    }

    public void onDestroy() {
        g.DF().b(701, this);
        g.DF().b(126, this);
        g.DF().b(255, this);
        if (this.eRi != null) {
            this.eRi.close();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.mobile_login_or_force_reg;
    }

    private void goBack() {
        Intent intent;
        a.pU("R200_100");
        if (this.eTw == 1) {
            intent = new Intent(this, RegByMobileRegAIOUI.class);
        } else {
            intent = new Intent(this, MobileInputUI.class);
        }
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        startActivity(intent);
        a.pT(this.eTr);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_600,");
        g.Eg();
        a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_600")).append(",2").toString());
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (this.eQY == null) {
            this.eQY = new f();
        }
        if (lVar.getType() == 255) {
            if (i != 0 || i2 != 0) {
                boolean z = this.eTs;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(j.settings_modify_password_tip));
                intent.putExtra("kintent_cancelable", z);
                startActivityForResult(intent, 0);
            }
        } else if (lVar.getType() != 701 || this.eSA == null) {
            String str2;
            com.tencent.mm.h.a eV;
            Object obj;
            if (lVar.getType() == 126) {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    Boolean valueOf = Boolean.valueOf(this.eTt);
                    String str3 = this.eTv;
                    String str4 = this.eTu;
                    if (this.eIX == null) {
                        int i3 = j.regbyqq_secimg_title;
                        byte[] Rf = ((s) lVar).Rf();
                        String Re = ((s) lVar).Re();
                        int i4 = i3;
                        int i5 = 0;
                        byte[] bArr = Rf;
                        String str5 = Re;
                        this.eIX = SecurityImage.a.a(this, i4, i5, bArr, str5, "", new 2(this, str3, str4, lVar, valueOf), null, new 3(this), new 4(this, str3, str4, lVar, valueOf));
                        return;
                    }
                    this.eIX.a(0, ((s) lVar).Rf(), ((s) lVar).Re(), "");
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str6 = this.bTi;
                    Boolean valueOf2 = Boolean.valueOf(this.eTt);
                    g.Eg();
                    com.tencent.mm.kernel.a.unhold();
                    com.tencent.mm.kernel.a.bt(true);
                    if (valueOf2.booleanValue()) {
                        String str7 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar";
                        str2 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
                        new File(str7).renameTo(new File(str2));
                        com.tencent.mm.a.e.deleteFile(str7);
                        com.tencent.mm.sdk.platformtools.c.c(str2, 96, 96, CompressFormat.JPEG, 90, str7);
                        new o(this, com.tencent.mm.compatible.util.e.dgs + "temp.avatar").a(new 5(this, lVar, str6), new 6(this, lVar, str6));
                    } else {
                        this.bLe = ((s) lVar).Rn();
                        at.dBv.T("login_user_name", str6);
                        Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                        be.addFlags(67108864);
                        be.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(be);
                        finish();
                        a.pU("RE900_100");
                        StringBuilder stringBuilder = new StringBuilder();
                        g.Eg();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_600,");
                        g.Eg();
                        a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_600")).append(",4").toString());
                    }
                }
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                    return;
                }
            }
            if (!this.eRi.a(this, new ah(i, i2, str))) {
                obj = null;
                switch (i2) {
                    case -140:
                        if (!bi.oW(this.cbP)) {
                            aa.n(this.mController.tml, str, this.cbP);
                        }
                        obj = 1;
                        break;
                    case -100:
                        g.Eg();
                        com.tencent.mm.kernel.a.hold();
                        ActionBarActivity actionBarActivity = this.mController.tml;
                        g.Eg();
                        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.Dh())) {
                            str2 = com.tencent.mm.bp.a.af(this.mController.tml, j.main_err_another_place);
                        } else {
                            g.Eg();
                            str2 = com.tencent.mm.kernel.a.Dh();
                        }
                        h.a(actionBarActivity, str2, this.mController.tml.getString(j.app_tip), new 9(this), new 10(this));
                        obj = 1;
                        break;
                    case -75:
                        h.i(this, j.alpha_version_tip_reg, j.reg_username_exist_title);
                        obj = 1;
                        break;
                    case -43:
                        Toast.makeText(this, j.bind_mcontact_err_binded, 0).show();
                        obj = 1;
                        break;
                    case -41:
                        Toast.makeText(this, j.bind_mcontact_err_format, 0).show();
                        obj = 1;
                        break;
                    case -36:
                        Toast.makeText(this, j.bind_mcontact_err_unbinded_notbinded, 0).show();
                        obj = 1;
                        break;
                    case -34:
                        Toast.makeText(this, j.bind_mcontact_err_freq_limit, 0).show();
                        obj = 1;
                        break;
                    case -33:
                        h.a(this, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip, new 8(this));
                        obj = 1;
                        break;
                    case -32:
                        h.a(this, getString(j.bind_mcontact_verify_error), "", new 7(this));
                        obj = 1;
                        break;
                }
            }
            obj = 1;
            if (obj == null) {
                if (lVar.getType() == 701) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null && eV.a(this.mController.tml, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.mController.tml, getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (i2 == -6 || i2 == -311 || i2 == -310) {
            this.eQY.account = this.username;
            this.eQY.eRP = this.eTv;
            this.eQY.eJa = ((q) lVar).Re();
            this.eQY.eIZ = ((q) lVar).Rf();
            this.eQY.eJb = ((q) lVar).Rg();
            this.eQY.eRQ = ((q) lVar).getSecCodeType();
            if (this.eIX == null) {
                this.eIX = SecurityImage.a.a(this, j.regbyqq_secimg_title, this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb, new 17(this), null, new 18(this), this.eQY);
            } else {
                this.eIX.a(this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb);
            }
        } else {
            this.cbP = ((q) lVar).Rd();
            this.eSA.a(this, i, i2, str, lVar);
            if (lVar instanceof q) {
                this.eTs = ((q) lVar).Rm();
            }
            if (i == 0 && i2 == 0) {
                final r rVar = new r(1);
                g.DF().a(rVar, 0);
                getString(j.app_tip);
                this.eHw = h.a(this, getString(j.app_loading), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.DF().c(rVar);
                    }
                });
            }
        }
    }
}
