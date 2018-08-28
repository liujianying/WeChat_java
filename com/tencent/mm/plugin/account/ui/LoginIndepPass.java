package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import com.tencent.ugc.TXRecordCommon;

public class LoginIndepPass extends MMActivity implements e {
    private String account;
    private String cbP;
    private ProgressDialog eHw = null;
    private String eHy;
    private p eIV;
    private SecurityImage eIX = null;
    private String eOW;
    private f eQY = new f();
    private c eQf = new c<iz>() {
        {
            this.sFo = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.bSF == null) {
                return false;
            }
            x.i("MicroMsg.LoginIndepPass", "summerdiz loginDisasterListener callback content[%s], url[%s]", new Object[]{izVar.bSF.content, izVar.bSF.url});
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.bSF.content);
            intent.putExtra("key_disaster_url", izVar.bSF.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(268435456);
            ad.getContext().startActivity(intent);
            return true;
        }
    };
    private EditText eRG;
    private String eRH;
    private Button eRI;
    private String eRa;
    private String eRb;

    static /* synthetic */ void a(LoginIndepPass loginIndepPass, String str, String str2) {
        if (bi.oW(str)) {
            h.i(loginIndepPass, j.verify_username_null_tip, j.login_err_title);
        } else if (bi.oW(str2)) {
            h.i(loginIndepPass, j.verify_password_null_tip, j.login_err_title);
        } else {
            loginIndepPass.eRG.setText(str2);
            loginIndepPass.YC();
            g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, loginIndepPass);
            q qVar = new q(str, str2, null, 1);
            g.DF().a(qVar, 0);
            loginIndepPass.getString(j.app_tip);
            loginIndepPass.eHw = h.a(loginIndepPass, loginIndepPass.getString(j.login_logining), true, new 2(loginIndepPass, qVar));
        }
    }

    static /* synthetic */ void b(LoginIndepPass loginIndepPass) {
        if (bi.oW(loginIndepPass.eRG.getText().toString().trim())) {
            loginIndepPass.enableOptionMenu(false);
        } else {
            loginIndepPass.enableOptionMenu(true);
        }
    }

    protected final int getLayoutId() {
        return a.g.login_indep_pass;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(j.login_indep_title);
        if (d.qVQ) {
            string = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(string);
        this.eRH = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.eRH != null) {
            this.account = ap.Ww(this.eRH);
        }
        com.tencent.mm.plugin.account.a.a.ezo.vo();
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L200_200,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L200_200")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("L200_200");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L200_200,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L200_200")).append(",2").toString());
    }

    public void onDestroy() {
        g.DF().b(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
        super.onDestroy();
    }

    protected final void initView() {
        this.eRG = (EditText) findViewById(f.indep_password);
        this.eRI = (Button) findViewById(f.login_tip);
        enableOptionMenu(false);
        addTextOptionMenu(0, getString(j.login_login), new 9(this));
        this.eRG.addTextChangedListener(new 10(this));
        this.eRG.setOnEditorActionListener(new 11(this));
        this.eRG.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                LoginIndepPass.this.Yz();
                return true;
            }
        });
        this.eRI.setText(getString(j.login_login_by_sms));
        this.eRI.setOnClickListener(new 13(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.c.a.pU("L200_100");
                Intent intent = new Intent(LoginIndepPass.this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.addFlags(67108864);
                LoginIndepPass.this.startActivity(intent);
                LoginIndepPass.this.finish();
                return true;
            }
        });
        this.eOW = getIntent().getStringExtra("auth_ticket");
        if (!bi.oW(this.eOW)) {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    LoginIndepPass.a(LoginIndepPass.this, f.YF(), f.YG());
                }
            }, 500);
        }
    }

    private void Yz() {
        String obj = this.eRG.getText().toString();
        if (bi.oW(this.account)) {
            h.i(this, j.verify_username_null_tip, j.login_err_title);
        } else if (obj.equals("")) {
            h.i(this, j.verify_password_null_tip, j.login_err_title);
        } else {
            YC();
            g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
            q qVar = new q(this.account, obj, null, 1);
            g.DF().a(qVar, 0);
            getString(j.app_tip);
            this.eHw = h.a(this, getString(j.login_logining), true, new 16(this, qVar));
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (this.eIV != null) {
            this.eIV.dismiss();
            this.eIV = null;
        }
        if (lVar.getType() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START) {
            this.cbP = ((q) lVar).Rd();
            g.DF().b(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
            this.eQY.eJa = ((q) lVar).Re();
            this.eQY.eIZ = ((q) lVar).Rf();
            this.eQY.eJb = ((q) lVar).Rg();
            this.eQY.eRQ = ((q) lVar).getSecCodeType();
            this.eQY.account = this.account;
            this.eQY.eIY = this.eRG.getText().toString();
            if (i2 == -75) {
                aa.ch(this.mController.tml);
            } else if (i2 == -106) {
                aa.e(this, str, 0);
            } else if (i2 == -217) {
                aa.a(this, com.tencent.mm.platformtools.f.a((q) lVar), i2);
            } else if (i2 == -205) {
                this.eOW = ((q) lVar).Ok();
                this.eRa = ((q) lVar).Rh();
                this.eRb = ((q) lVar).Rk();
                x.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bi.Xf(this.eOW), this.eRb});
                f.a(this.eQY);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.eOW);
                intent.putExtra("binded_mobile", this.eRa);
                intent.putExtra("close_safe_device_style", this.eRb);
                intent.putExtra("from_source", 5);
                com.tencent.mm.plugin.account.a.a.ezn.g(this, intent);
            } else if (i2 != -140) {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    g.DF().a(new bg(new bg.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar != null) {
                                com.tencent.mm.network.c Lr = eVar.Lr();
                                byte[] bArr = new byte[0];
                                g.Eg();
                                Lr.x(bArr, com.tencent.mm.kernel.a.Df());
                            }
                        }
                    }), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
                    if (this.eIX == null) {
                        this.eIX = SecurityImage.a.a(this.mController.tml, j.regbyqq_secimg_title, this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb, new 4(this), null, new 5(this), this.eQY);
                        return;
                    }
                    x.d("MicroMsg.LoginIndepPass", "imgSid:" + this.eQY.eJa + " img len" + this.eQY.eIZ.length + " " + com.tencent.mm.compatible.util.g.Ac());
                    this.eIX.a(this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb);
                } else if (z || (i == 0 && i2 == 0)) {
                    com.tencent.mm.kernel.a.unhold();
                    aa.oS(this.eQY.account);
                    com.tencent.mm.platformtools.x.bZ(this);
                    aa.showAddrBookUploadConfirm(this, new 6(this), false, 2);
                } else if (!e(i, i2, str)) {
                    if (lVar.getType() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START) {
                        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                        if (eV != null && eV.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (!bi.oW(this.cbP)) {
                aa.n(this, str, this.cbP);
            }
        } else if (lVar.getType() == 145) {
            g.DF().b(145, this);
            String Ol = ((com.tencent.mm.modelfriend.a) lVar).Ol();
            if (i2 == -41) {
                h.i(this, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
            } else if (i2 == -75) {
                h.b(this, getString(j.alpha_version_tip_login), "", true);
            } else {
                com.tencent.mm.plugin.c.a.pU("L3");
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L3,");
                g.Eg();
                com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L3")).append(",1").toString());
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.eRH);
                intent2.putExtra("bindmcontact_shortmobile", Ol);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("login_type", 3);
                intent2.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) lVar).Oq());
                intent2.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) lVar).Or());
                intent2.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) lVar).Os());
                a(MobileVerifyUI.class, intent2);
            }
        } else if (!e(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean e(int i, int i2, String str) {
        if (com.tencent.mm.plugin.account.a.a.ezo.a(this.mController.tml, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bi.oW(this.cbP)) {
                    aa.n(this.mController.tml, str, this.cbP);
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
                h.a(actionBarActivity, af, this.mController.tml.getString(j.app_tip), new 7(this), new 8(this));
                return true;
            case -9:
                h.i(this, j.login_err_mailnotverify, j.login_err_title);
                return true;
            case TXRecordCommon.START_RECORD_ERR_NOT_INIT /*-4*/:
            case -3:
                h.i(this, j.errcode_password, j.login_err_title);
                return true;
            case -1:
                if (g.DF().Lg() != 5) {
                    return false;
                }
                h.i(this, j.net_warn_server_down_tip, j.net_warn_server_down);
                return true;
            default:
                return false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginIndepPass";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginIndepPass";
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
