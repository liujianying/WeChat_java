package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class k implements e, b {
    private String eSE;
    int eSF = 1;
    private MobileInputUI eSu;
    private String eSv;
    private String eSw;
    private int eSx = 0;

    public final void a(final MobileInputUI mobileInputUI) {
        this.eSu = mobileInputUI;
        String str = "";
        if (d.qVQ) {
            str = str + mobileInputUI.getString(j.alpha_version_alpha);
        }
        mobileInputUI.setMMTitle(str);
        mobileInputUI.showOptionMenu(false);
        mobileInputUI.eST.setVisibility(0);
        mobileInputUI.eST.setVisibility(0);
        mobileInputUI.eGq.setVisibility(0);
        mobileInputUI.eSM.setVisibility(0);
        mobileInputUI.eSN.requestFocus();
        mobileInputUI.eSP.setVisibility(0);
        mobileInputUI.eSa.setVisibility(0);
        mobileInputUI.eSX.setVisibility(8);
        mobileInputUI.eSS.setVisibility(0);
        mobileInputUI.eSS.setText(j.loginby_new_mobile_reg_ok);
        if (mobileInputUI.eSR != null) {
            mobileInputUI.eSR.setOnClickListener(new 1(this, mobileInputUI));
        }
        str = mobileInputUI.getString(j.license_agree_text);
        String str2 = "  ";
        String string;
        String string2;
        String string3;
        CharSequence newSpannable;
        if (w.chM()) {
            string = mobileInputUI.getString(j.license_detail);
            string2 = mobileInputUI.getString(j.privacy_detail);
            string3 = mobileInputUI.getString(j.and);
            newSpannable = Factory.getInstance().newSpannable(str + str2 + string + string3 + string2);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.L(mobileInputUI.mController.tml, mobileInputUI.getString(j.url_agreement));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(c.link_color));
                    textPaint.setUnderlineText(true);
                }
            }, str.length() + str2.length(), (str.length() + string.length()) + str2.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.L(mobileInputUI, ad.getResources().getString(j.license_read_url, new Object[]{w.fD(mobileInputUI), w.chO(), "setting", Integer.valueOf(1), Integer.valueOf(0)}));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(c.link_color));
                    textPaint.setUnderlineText(true);
                }
            }, ((str.length() + str2.length()) + string.length()) + string3.length(), (((str.length() + string.length()) + str2.length()) + string3.length()) + string2.length(), 33);
            mobileInputUI.eSQ.setText(newSpannable);
        } else {
            string = mobileInputUI.getString(j.license_terms_of_service);
            string2 = mobileInputUI.getString(j.license_privacy_policy);
            string3 = mobileInputUI.getString(j.and);
            newSpannable = Factory.getInstance().newSpannable(str + str2 + string + string3 + string2);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.L(mobileInputUI.mController.tml, mobileInputUI.getString(j.url_terms_of_service));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(c.link_color));
                    textPaint.setUnderlineText(true);
                }
            }, str.length() + str2.length(), (str.length() + str2.length()) + string.length(), 33);
            newSpannable.setSpan(new 6(this, mobileInputUI), ((str.length() + string.length()) + str2.length()) + string3.length(), (((str.length() + string.length()) + str2.length()) + string3.length()) + string2.length(), 33);
            mobileInputUI.eSQ.setText(newSpannable);
        }
        mobileInputUI.eSQ.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void start() {
        g.DF().a(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("R200_100")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("R200_100");
        this.eSx = 0;
    }

    public final void stop() {
        g.DF().b(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("R200_100")).append(",2").toString());
    }

    public final void jm(int i) {
        switch (2.eSz[i - 1]) {
            case 1:
                this.eSu.YC();
                switch (this.eSF) {
                    case 1:
                        com.tencent.mm.platformtools.a.b(this.eSu, this.eSu.getString(j.license_read_url, new Object[]{w.chP(), com.tencent.mm.al.b.l(this.eSu, this.eSu.countryCode, this.eSu.getString(j.country_code)), "reg", Integer.valueOf(1), Integer.valueOf(0)}), 32047, false);
                        break;
                    case 2:
                        YH();
                        break;
                    default:
                        this.eSu.eSZ = ap.Wy(this.eSu.countryCode);
                        this.eSu.eTa = this.eSu.eSM.getText().toString();
                        String str = this.eSu.eSZ + this.eSu.eTa;
                        if (com.tencent.mm.platformtools.a.F(this.eSu, this.eSu.eQO.getText().toString())) {
                            if (this.eSu.eIV == null) {
                                MobileInputUI mobileInputUI = this.eSu;
                                MobileInputUI mobileInputUI2 = this.eSu;
                                this.eSu.getString(j.app_tip);
                                mobileInputUI.eIV = h.a(mobileInputUI2, this.eSu.getString(j.regbyfacebook_reg_setpwd_exiting), true, new 7(this));
                                String obj = this.eSu.eSM.getText().toString();
                                int i2 = (this.eSv == null || this.eSw == null || obj.equals(this.eSv) || !obj.equals(this.eSw)) ? (this.eSv == null || this.eSw == null || this.eSw.equals(this.eSv) || obj.equals(this.eSw)) ? 0 : 2 : 1;
                                com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                                aVar.hG(this.eSx);
                                aVar.hH(i2);
                                g.DF().a(aVar, 0);
                                this.eSv = this.eSu.eSM.getText().toString();
                                this.eSx++;
                                break;
                            }
                            x.d("MicroMsg.MobileInputRegLogic", "already checking ");
                            break;
                        }
                        break;
                }
                this.eSF = 0;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eSu.eIV != null) {
            this.eSu.eIV.dismiss();
            this.eSu.eIV = null;
        }
        if (i2 == -75) {
            h.i(this.eSu, j.alpha_version_tip_reg, j.reg_username_exist_title);
        } else if (lVar.getType() != 145) {
        } else {
            com.tencent.mm.h.a eV;
            if (i2 == -41 || i2 == -59) {
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this.eSu, null, null);
                    return;
                } else {
                    h.i(this.eSu, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
                    return;
                }
            }
            String Ol;
            int Oh = ((com.tencent.mm.modelfriend.a) lVar).Oh();
            if (Oh == 12) {
                this.eSu.eTa = ap.Ww(this.eSu.eTa);
                this.eSw = this.eSu.eSZ + this.eSu.eTa;
                this.eSE = ((com.tencent.mm.modelfriend.a) lVar).Ow();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    Ol = ((com.tencent.mm.modelfriend.a) lVar).Ol();
                    if (!bi.oW(Ol)) {
                        this.eSu.eTa = Ol.trim();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_200,");
                    g.Eg();
                    com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("R200_200")).append(",1").toString());
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eSu, new 8(this), new 9(this));
                        return;
                    }
                    YH();
                    stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_200,");
                    g.Eg();
                    com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("R200_200")).append(",2").toString());
                    return;
                } else if (i2 == -355) {
                    aa.e(this.eSu, str, 32046);
                    return;
                } else if (i2 == -34) {
                    h.b(this.eSu, this.eSu.getString(j.bind_mcontact_err_freq_limit), "", true);
                    return;
                }
            }
            if (Oh == 14) {
                if (i2 == 0 || str == null) {
                    if (((com.tencent.mm.modelfriend.a) lVar).Om() == 1) {
                        String str2 = this.eSu.eSZ + this.eSu.eTa;
                        Ol = ((com.tencent.mm.modelfriend.a) lVar).Oo();
                        String On = ((com.tencent.mm.modelfriend.a) lVar).On();
                        Intent intent = new Intent(this.eSu, RegByMobileSendSmsUI.class);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", Ol);
                        intent.putExtra("verify_code", On);
                        intent.putExtra("key_reg_style", 2);
                        intent.putExtra("kintent_password", this.eSu.eQO.getText().toString());
                        intent.putExtra("regsession_id", this.eSE);
                        this.eSu.startActivity(intent);
                    } else {
                        com.tencent.mm.plugin.c.a.pU("R200_300");
                        Intent intent2 = new Intent();
                        intent2.putExtra("bindmcontact_mobile", this.eSu.eSZ + " " + this.eSu.eSM.getText().toString());
                        intent2.putExtra("bindmcontact_shortmobile", this.eSu.eTa);
                        intent2.putExtra("country_name", this.eSu.dYy);
                        intent2.putExtra("couttry_code", this.eSu.countryCode);
                        intent2.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) lVar).Oq());
                        intent2.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) lVar).Or());
                        intent2.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) lVar).Os());
                        intent2.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a) lVar).Ot());
                        intent2.putExtra("key_reg_style", 2);
                        intent2.putExtra("kintent_password", this.eSu.eQO.getText().toString());
                        intent2.putExtra("mobile_verify_purpose", 2);
                        intent2.putExtra("regsession_id", this.eSE);
                        intent2.setClass(this.eSu, MobileVerifyUI.class);
                        this.eSu.startActivity(intent2);
                        i.jj(i.a.eOl);
                    }
                } else if (i2 == -34) {
                    h.b(this.eSu, this.eSu.getString(j.bind_mcontact_err_freq_limit), "", true);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.ezo.a(this.eSu, i, i2, str)) {
                    return;
                }
            }
            eV = com.tencent.mm.h.a.eV(str);
            if (eV != null && this.eSu != null && !eV.a(this.eSu, null, null)) {
            }
        }
    }

    private void YH() {
        MobileInputUI mobileInputUI = this.eSu;
        MobileInputUI mobileInputUI2 = this.eSu;
        this.eSu.getString(j.app_tip);
        mobileInputUI.eIV = h.a(mobileInputUI2, this.eSu.getString(j.regbyfacebook_reg_setpwd_exiting), true, new 10(this));
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(this.eSu.eSZ + this.eSu.eTa, 14, "", 0, "");
        aVar.lD(this.eSE);
        g.DF().a(aVar, 0);
    }
}
