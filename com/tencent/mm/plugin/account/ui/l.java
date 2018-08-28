package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class l implements e, b {
    String account;
    private String cbP;
    SecurityImage eIX = null;
    private String eOW;
    private boolean eRr = true;
    String eSH;
    private String eSe;
    MobileInputUI eSu;

    static /* synthetic */ void a(l lVar, String str) {
        final a aVar = new a(str, 16, "", 0, "");
        g.DF().a(aVar, 0);
        MobileInputUI mobileInputUI = lVar.eSu;
        MobileInputUI mobileInputUI2 = lVar.eSu;
        lVar.eSu.getString(j.app_tip);
        mobileInputUI.eIV = h.a(mobileInputUI2, lVar.eSu.getString(j.app_waiting), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.DF().c(aVar);
            }
        });
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.eSu = mobileInputUI;
        mobileInputUI.eSU.setVisibility(0);
        this.account = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (bi.oW(this.account)) {
            this.account = ap.Ww(mobileInputUI.eSZ + mobileInputUI.eTa);
        }
        mobileInputUI.eSN.setTextColor(mobileInputUI.getResources().getColor(c.hint_text_color));
        mobileInputUI.eSN.setEnabled(false);
        mobileInputUI.eSN.setFocusable(false);
        mobileInputUI.eSM.setFocusable(false);
        mobileInputUI.eSM.setText(ap.Ww(this.account));
        mobileInputUI.eSM.setVisibility(0);
        YI();
        mobileInputUI.eSW.setVisibility(0);
        mobileInputUI.eSS.setText(j.login_login);
        mobileInputUI.eSS.setVisibility(0);
        mobileInputUI.eSS.setEnabled(true);
        this.eSe = at.dBv.I("login_weixin_username", "");
        this.eOW = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!bi.oW(this.eOW)) {
            new ag().postDelayed(new 1(this), 500);
        }
    }

    private void YI() {
        if (this.eSu.dBM == 6) {
            this.eSu.eSO.reset();
            this.eSu.eSW.setText(j.login_login_by_password);
            this.eSu.eSa.setVisibility(8);
            this.eSu.eSO.setVisibility(0);
            this.eSu.eSO.getContentEditText().requestFocus();
            this.eSu.eSO.setSendSmsBtnClickListener(new 9(this));
            this.eSu.eSW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    l.this.eSu.eRw[1] = 2;
                    l.this.eSu.dBM = 7;
                    l.this.eSu.eSO.reset();
                    g.DF().b(145, l.this);
                    l.this.YI();
                }
            });
        } else if (this.eSu.dBM == 7) {
            this.eSu.eSW.setText(j.login_login_by_sms);
            this.eSu.eSa.setVisibility(0);
            this.eSu.eQO.requestFocus();
            this.eSu.eSO.setVisibility(8);
            this.eSu.eSW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    l.this.eSu.eRw[1] = 1;
                    l.this.eSu.dBM = 6;
                    g.DF().a(145, l.this);
                    l.this.YI();
                }
            });
        }
    }

    public final void start() {
        g.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
        g.DF().a(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L200_100")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("L200_100");
    }

    public final void stop() {
        g.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
        g.DF().b(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L200_100")).append(",2").toString());
    }

    public final void jm(int i) {
        switch (8.eSz[i - 1]) {
            case 1:
                this.eSu.YC();
                this.eSu.eSZ = ap.Wy(this.eSu.countryCode);
                this.eSu.eTa = this.eSu.eSN.getText().toString();
                if (!bi.oW(this.eSu.eSZ) && !bi.oW(this.eSu.eTa)) {
                    if (this.eSu.dBM == 7) {
                        if (bi.oW(this.eSH)) {
                            aN(this.account, this.eSu.eQO.getText().toString());
                            return;
                        } else {
                            aN(this.account, this.eSH);
                            return;
                        }
                    } else if (this.eSu.dBM == 6) {
                        String trim = this.eSu.eSO.getText().toString().trim();
                        if (bi.oW(trim)) {
                            h.i(this.eSu, j.verify_seccode_tip, j.login_err_title);
                            return;
                        }
                        this.eSu.YC();
                        final a aVar = new a(this.account, 17, trim, 0, "");
                        g.DF().a(aVar, 0);
                        MobileInputUI mobileInputUI = this.eSu;
                        MobileInputUI mobileInputUI2 = this.eSu;
                        this.eSu.getString(j.app_tip);
                        mobileInputUI.eIV = h.a(mobileInputUI2, this.eSu.getString(j.bind_mcontact_verifing), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                g.DF().c(aVar);
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    private void aN(String str, String str2) {
        if (bi.oW(str)) {
            h.i(this.eSu, j.verify_username_null_tip, j.login_err_title);
        } else if (bi.oW(str2)) {
            h.i(this.eSu, j.verify_password_null_tip, j.login_err_title);
        } else {
            this.eSu.eQO.setText(str2);
            this.eSu.YC();
            q qVar = new q(str, str2, null, 1);
            g.DF().a(qVar, 0);
            MobileInputUI mobileInputUI = this.eSu;
            MobileInputUI mobileInputUI2 = this.eSu;
            this.eSu.getString(j.app_tip);
            mobileInputUI.eIV = h.a(mobileInputUI2, this.eSu.getString(j.login_logining), true, new 14(this, qVar));
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        com.tencent.mm.h.a eV;
        x.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eSu.eIV != null) {
            this.eSu.eIV.dismiss();
            this.eSu.eIV = null;
        }
        if (lVar.getType() == 145) {
            int Oh = ((a) lVar).Oh();
            if (Oh == 16) {
                if (i2 == -41) {
                    this.eSu.eSO.reset();
                    h.i(this.eSu, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
                    return;
                } else if (i2 == -75) {
                    this.eSu.eSO.reset();
                    h.b(this.eSu, this.eSu.getString(j.alpha_version_tip_login), "", true);
                    return;
                }
            } else if (Oh == 17) {
                if (i == 0 && i2 == 0) {
                    new g(new 15(this), ((a) lVar).getUsername(), ((a) lVar).Oi(), this.account).a(this.eSu);
                    return;
                } else if (!e(i, i2, str)) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eSu, null, null);
                    }
                } else {
                    return;
                }
            }
        } else if (lVar.getType() == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL) {
            this.cbP = ((q) lVar).Rd();
            f fVar = new f();
            fVar.eJa = ((q) lVar).Re();
            fVar.eIZ = ((q) lVar).Rf();
            fVar.eJb = ((q) lVar).Rg();
            fVar.eRQ = ((q) lVar).getSecCodeType();
            fVar.account = ((q) lVar).account;
            fVar.eIY = this.eSu.eQO.getText().toString();
            String Rh;
            if (i2 == -75) {
                aa.ch(this.eSu);
                return;
            } else if (i2 == -106) {
                aa.e(this.eSu, str, 32045);
                return;
            } else if (i2 == -217) {
                aa.a(this.eSu, f.a((q) lVar), i2);
                return;
            } else if (i2 == -205) {
                this.eOW = ((q) lVar).Ok();
                Rh = ((q) lVar).Rh();
                x.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{bi.Xf(this.eOW), ((q) lVar).Rk()});
                f.a(fVar);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.eOW);
                intent.putExtra("binded_mobile", Rh);
                intent.putExtra("close_safe_device_style", r3);
                intent.putExtra("from_source", 6);
                com.tencent.mm.plugin.account.a.a.ezn.g(this.eSu, intent);
                return;
            } else if (i2 != -140) {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    g.DF().a(new bg(new 16(this)), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    if (this.eIX == null) {
                        this.eIX = SecurityImage.a.a(this.eSu, j.regbyqq_secimg_title, fVar.eRQ, fVar.eIZ, fVar.eJa, fVar.eJb, new 2(this, fVar), null, new 3(this), fVar);
                        return;
                    }
                    x.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.eJa + " img len" + fVar.eIZ.length + " " + com.tencent.mm.compatible.util.g.Ac());
                    this.eIX.a(fVar.eRQ, fVar.eIZ, fVar.eJa, fVar.eJb);
                    return;
                } else if (z || (i == 0 && i2 == 0)) {
                    g.Eg();
                    com.tencent.mm.kernel.a.unhold();
                    x.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[]{fVar.account});
                    aa.oS(fVar.account);
                    Rh = at.dBv.I("login_weixin_username", "");
                    com.tencent.mm.platformtools.x.bZ(this.eSu);
                    if (this.eSu.eSf) {
                        bt.dDs.W(this.eSe, Rh);
                        bt.dDs.d(com.tencent.mm.model.q.GF(), com.tencent.mm.model.q.Ho());
                        com.tencent.mm.plugin.report.service.h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(9), bt.dDs.II()});
                    }
                    aa.showAddrBookUploadConfirm(this.eSu, new 4(this), false, 2);
                    if (this.eSu.dBM == 6) {
                        this.eRr = ((q) lVar).Rm();
                        g.DF().a(255, this);
                        r rVar = new r(1);
                        g.DF().a(rVar, 0);
                        MobileInputUI mobileInputUI = this.eSu;
                        MobileInputUI mobileInputUI2 = this.eSu;
                        this.eSu.getString(j.app_tip);
                        mobileInputUI.eIV = h.a(mobileInputUI2, this.eSu.getString(j.app_loading), true, new 5(this, rVar));
                        return;
                    }
                    return;
                } else if (!e(i, i2, str)) {
                    if (!(i == 0 && i2 == 0)) {
                        Toast.makeText(this.eSu, this.eSu.getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                } else {
                    return;
                }
            } else if (!bi.oW(this.cbP)) {
                aa.n(this.eSu, str, this.cbP);
                return;
            } else {
                return;
            }
        } else if (lVar.getType() == 255) {
            g.DF().b(255, this);
            if (i != 0 || i2 != 0) {
                MobileInputUI mobileInputUI3 = this.eSu;
                boolean z2 = this.eRr;
                Intent intent2 = new Intent(mobileInputUI3, RegByMobileSetPwdUI.class);
                intent2.putExtra("kintent_hint", mobileInputUI3.getString(j.settings_modify_password_tip));
                intent2.putExtra("kintent_cancelable", z2);
                mobileInputUI3.startActivity(intent2);
                return;
            }
            return;
        }
        eV = com.tencent.mm.h.a.eV(str);
        if (eV != null && this.eSu != null && !eV.a(this.eSu, null, null)) {
        }
    }

    private boolean e(int i, int i2, String str) {
        if (com.tencent.mm.plugin.account.a.a.ezo.a(this.eSu, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bi.oW(this.cbP)) {
                    aa.n(this.eSu, str, this.cbP);
                }
                return true;
            case -100:
                String af;
                g.Eg();
                com.tencent.mm.kernel.a.hold();
                MobileInputUI mobileInputUI = this.eSu;
                g.Eg();
                if (TextUtils.isEmpty(com.tencent.mm.kernel.a.Dh())) {
                    af = com.tencent.mm.bp.a.af(this.eSu, j.main_err_another_place);
                } else {
                    g.Eg();
                    af = com.tencent.mm.kernel.a.Dh();
                }
                h.a(mobileInputUI, af, this.eSu.getString(j.app_tip), new 6(this), new 7(this));
                return true;
            case -34:
                Toast.makeText(this.eSu, j.bind_mcontact_err_freq_limit, 0).show();
                return true;
            case -33:
                h.a(this.eSu, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip, null);
                return true;
            case -32:
                h.a(this.eSu, j.bind_mcontact_verify_error, j.bind_mcontact_verify_tip, null);
                return true;
            case -9:
                h.i(this.eSu, j.login_err_mailnotverify, j.login_err_title);
                return true;
            case -3:
                h.i(this.eSu, j.errcode_password, j.login_err_title);
                return true;
            case -1:
                if (g.DF().Lg() != 5) {
                    return false;
                }
                h.i(this.eSu, j.net_warn_server_down_tip, j.net_warn_server_down);
                return true;
            default:
                return false;
        }
    }
}
