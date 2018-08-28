package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.aa.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a$a;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.d;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.protocal.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.File;

public class RegByMobileSendSmsUI extends MMActivity implements e {
    private String bLe;
    private String bgn;
    private int countDown = 15;
    private String ePV = "";
    private g eSA;
    private String eSE = "";
    private String eSH;
    private int eTw;
    private boolean eUM;
    private String eVe = "";
    private String eVf = "";
    private ProgressDialog eVg;
    private int eVh;
    private Button eVi;
    private Button eVj;
    private al eVk;
    private SecurityImage eVl;

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        regByMobileSendSmsUI.eVj.setEnabled(false);
        if (regByMobileSendSmsUI.eVk != null) {
            regByMobileSendSmsUI.eVk.SO();
            regByMobileSendSmsUI.countDown = 15;
            regByMobileSendSmsUI.eVh = 0;
            regByMobileSendSmsUI.eVk.J(0, 1000);
            return;
        }
        regByMobileSendSmsUI.eVk = new al(new a() {
            public final boolean vD() {
                if (RegByMobileSendSmsUI.this.countDown > 0) {
                    RegByMobileSendSmsUI.this.eVj.setText(RegByMobileSendSmsUI.this.getString(j.regbymobile_reg_send_sms_verifying, new Object[]{Integer.valueOf(RegByMobileSendSmsUI.this.countDown)}));
                    RegByMobileSendSmsUI.this.countDown = RegByMobileSendSmsUI.this.countDown - 1;
                    if (RegByMobileSendSmsUI.this.countDown % 4 != 0) {
                        return true;
                    }
                    RegByMobileSendSmsUI.p(RegByMobileSendSmsUI.this);
                    return true;
                }
                RegByMobileSendSmsUI.this.eVj.setText(j.regbymobile_reg_no_sim_send_sms_btn_title);
                RegByMobileSendSmsUI.this.eVj.setEnabled(true);
                return false;
            }
        }, true);
        regByMobileSendSmsUI.eVk.J(0, 1000);
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI, String str, String str2) {
        g.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, regByMobileSendSmsUI);
        regByMobileSendSmsUI.eSA = new g(new 6(regByMobileSendSmsUI), str, str2, regByMobileSendSmsUI.eVe);
        regByMobileSendSmsUI.eSA.a(regByMobileSendSmsUI);
    }

    static /* synthetic */ void p(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        regByMobileSendSmsUI.eVh++;
        if (regByMobileSendSmsUI.eVh <= 4) {
            com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(regByMobileSendSmsUI.eVe, 15, "", 0, "");
            ((m.a) aVar.dJM.KV()).qWG.rhE = 1;
            g.DF().a(aVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTw = getIntent().getIntExtra("key_reg_style", 1);
        this.eVe = bi.oV(getIntent().getStringExtra("from_mobile"));
        this.eVf = bi.oV(getIntent().getStringExtra("to_mobile"));
        this.ePV = bi.oV(getIntent().getStringExtra("verify_code"));
        this.eSE = bi.oV(getIntent().getStringExtra("regsession_id"));
        this.bgn = bi.oV(getIntent().getStringExtra("kintent_nickname"));
        this.eSH = bi.oV(getIntent().getStringExtra("kintent_password"));
        this.eUM = getIntent().getBooleanExtra("kintent_hasavatar", false);
        initView();
    }

    protected final void initView() {
        super.initView();
        ((TextView) findViewById(a$f.send_sms_tip)).setText(getString(j.regbymobile_reg_send_sms_tip, new Object[]{this.eVe}));
        ((TextView) findViewById(a$f.send_sms_content)).setText(pQ(getString(j.regbymobile_reg_send_sms_content, new Object[]{this.ePV})));
        ((TextView) findViewById(a$f.send_sms_to)).setText(pQ(getString(j.regbymobile_reg_send_sms_to, new Object[]{this.eVf})));
        this.eVi = (Button) findViewById(a$f.send_sms_btn);
        this.eVj = (Button) findViewById(a$f.go_to_reg_btn);
        if (bi.G(new String[]{this.eVe, this.eVf, this.ePV})) {
            this.eVi.setEnabled(false);
            this.eVj.setEnabled(false);
        } else {
            this.eVj.setOnClickListener(new 1(this));
        }
        if (bi.oW(q.getSimCountryIso())) {
            this.eVi.setVisibility(8);
        } else {
            this.eVi.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.this.eVf));
                    intent.putExtra("sms_body", RegByMobileSendSmsUI.this.ePV);
                    try {
                        RegByMobileSendSmsUI.this.startActivity(intent);
                        RegByMobileSendSmsUI.this.overridePendingTransition(a$a.slide_right_in, a$a.slide_left_out);
                    } catch (Exception e) {
                        x.e("MicroMsg.RegByMobileSendSmsUI", e.getMessage());
                    }
                }
            });
        }
        setMMTitle(j.regbymobile_reg_send_sms_title);
        setBackBtn(new 10(this));
    }

    private k pQ(String str) {
        k kVar = new k(str);
        x.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[]{str});
        int indexOf = str.indexOf(32) + 1;
        kVar.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(d.HugersTextSize)), indexOf, str.length(), 33);
        kVar.setSpan(new ForegroundColorSpan(getResources().getColor(c.green_text_color)), indexOf, str.length(), 33);
        return kVar;
    }

    protected final int getLayoutId() {
        return a$g.regbymobile_send_sms;
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(145, this);
    }

    protected void onStop() {
        super.onStop();
        SO();
        g.DF().b(145, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eVg != null) {
            this.eVg.dismiss();
        }
        Intent intent;
        com.tencent.mm.h.a eV;
        if (lVar.getType() == 145 && ((com.tencent.mm.modelfriend.a) lVar).Oh() == 15) {
            com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) lVar;
            this.bLe = aVar.Oj();
            if (i2 == 0) {
                SO();
                if (this.eTw == 1) {
                    g.DF().a(126, this);
                    s sVar = new s("", this.eSH, this.bgn, 0, "", this.eVe, "", "", this.bLe, 1, "", "", "", true, this.eUM);
                    sVar.mX(this.eSE);
                    sVar.im(1);
                    g.DF().a(sVar, 0);
                    getString(j.app_tip);
                    this.eVg = h.a(this, getString(j.regbyqq_reg_waiting), true, new 11(this, sVar));
                    return;
                }
                intent = new Intent();
                intent.putExtra("regsetinfo_ticket", this.bLe);
                intent.putExtra("regsetinfo_user", this.eVe);
                intent.putExtra("regsession_id", this.eSE);
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("regsetinfo_ismobile", 4);
                intent.putExtra("regsetinfo_NextControl", aVar.Op());
                intent.putExtra("key_reg_style", this.eTw);
                intent.setClass(this, RegSetInfoUI.class);
                startActivity(intent);
            } else if (i2 == -35) {
                SO();
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, new 12(this, aVar), new 13(this));
                    return;
                }
                h.a(this, getString(j.bind_mcontact_already_bind_relogin), null, new 14(this, aVar), new 15(this));
            } else if (i2 == -212) {
                SO();
                intent = new Intent(this, MobileLoginOrForceReg.class);
                intent.putExtra("ticket", this.bLe);
                intent.putExtra("moble", this.eVe);
                intent.putExtra("regsession_id", this.eSE);
                intent.putExtra("next_controll", aVar.Op());
                intent.putExtra("username", aVar.getUsername());
                intent.putExtra("password", this.eSH);
                intent.putExtra("nickname", aVar.Ov());
                intent.putExtra("avatar_url", aVar.Ou());
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("kintent_hasavatar", this.eUM);
                intent.putExtra("kintent_nickname", this.bgn);
                intent.putExtra("kintent_password", this.eSH);
                intent.putExtra("key_reg_style", this.eTw);
                startActivity(intent);
            } else if (!bi.oW(str) && this.eVh >= 4) {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null && !eV.a(this, null, null)) {
                }
            }
        } else if (lVar.getType() == 126) {
            s sVar2 = (s) lVar;
            if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.eVl == null) {
                    this.eVl = SecurityImage.a.a(this, j.regbyqq_secimg_title, 0, sVar2.Rf(), sVar2.Re(), "", new 16(this, sVar2), null, new 2(this), new 3(this, sVar2));
                } else {
                    this.eVl.a(0, ((s) lVar).Rf(), ((s) lVar).Re(), "");
                }
            } else if (i == 0 && i2 == 0) {
                String str2 = this.eVe;
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.kernel.a.bt(true);
                if (this.eUM) {
                    String str3 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar";
                    String str4 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
                    new File(str3).renameTo(new File(str4));
                    com.tencent.mm.a.e.deleteFile(str3);
                    com.tencent.mm.sdk.platformtools.c.c(str4, 96, 96, CompressFormat.JPEG, 90, str3);
                    new o(this, com.tencent.mm.compatible.util.e.dgs + "temp.avatar").a(new 4(this, sVar2, str2), new 5(this, sVar2, str2));
                    return;
                }
                this.bLe = sVar2.Rn();
                at.dBv.T("login_user_name", str2);
                intent = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                intent.addFlags(67108864);
                intent.putExtra("LauncherUI.enter_from_reg", true);
                startActivity(intent);
                finish();
                com.tencent.mm.plugin.c.a.pU("RE900_100");
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_600,");
                g.Eg();
                com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_600")).append(",4").toString());
            } else {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                }
            }
        }
    }

    private void SO() {
        if (this.eVk != null) {
            this.eVk.SO();
        }
        this.eVj.setText(j.regbymobile_reg_no_sim_send_sms_btn_title);
        this.eVj.setEnabled(true);
    }

    private void goBack() {
        h.a(this, getString(j.regbymobile_reg_quit_send_sms), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RegByMobileSendSmsUI.this.SO();
                RegByMobileSendSmsUI.this.finish();
            }
        }, null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
