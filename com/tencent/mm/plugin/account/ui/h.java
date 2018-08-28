package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.ui.MobileInputUI.a;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h implements e, b {
    private MobileInputUI eSu;
    private String eSv;
    private String eSw;
    private int eSx = 0;

    /* renamed from: com.tencent.mm.plugin.account.ui.h$5 */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] eSz = new int[a.YL().length];

        static {
            try {
                eSz[a.eTg - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.eSu = mobileInputUI;
        mobileInputUI.eSN.requestFocus();
        mobileInputUI.showVKB();
        String string = mobileInputUI.getString(a$j.regbymoile_reg_title);
        if (d.qVQ) {
            string = string + mobileInputUI.getString(a$j.alpha_version_alpha);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.eGq.setVisibility(0);
        mobileInputUI.eSM.setVisibility(0);
        mobileInputUI.eSN.requestFocus();
        mobileInputUI.eSS.setText(a$j.app_nextstep);
        mobileInputUI.eSS.setVisibility(0);
    }

    public final void start() {
        g.DF().a(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",F200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("F200_100")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("F200_100");
        this.eSx = 0;
    }

    public final void stop() {
        g.DF().b(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",F200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("F200_100")).append(",2").toString());
    }

    public final void jm(int i) {
        switch (AnonymousClass5.eSz[i - 1]) {
            case 1:
                this.eSu.eSZ = ap.Wy(this.eSu.countryCode);
                this.eSu.eTa = this.eSu.eSM.getText().toString();
                String str = this.eSu.eSZ + this.eSu.eTa;
                if (this.eSu.eIV != null) {
                    x.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.eSu;
                Context context = this.eSu;
                this.eSu.getString(a$j.app_tip);
                mobileInputUI.eIV = com.tencent.mm.ui.base.h.a(context, this.eSu.getString(a$j.regbyfacebook_reg_setpwd_exiting), true, new 1(this));
                String obj = this.eSu.eSM.getText().toString();
                int i2 = (this.eSv == null || this.eSw == null || obj.equals(this.eSv) || !obj.equals(this.eSw)) ? (this.eSv == null || this.eSw == null || this.eSw.equals(this.eSv) || obj.equals(this.eSw)) ? 0 : 2 : 1;
                com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                aVar.hG(this.eSx);
                aVar.hH(i2);
                g.DF().a(aVar, 0);
                this.eSv = this.eSu.eSM.getText().toString();
                this.eSx++;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eSu.eIV != null) {
            this.eSu.eIV.dismiss();
            this.eSu.eIV = null;
        }
        com.tencent.mm.h.a eV;
        if (i2 == -75) {
            com.tencent.mm.ui.base.h.i(this.eSu, a$j.alpha_version_tip_reg, a$j.reg_username_exist_title);
        } else if (i2 == -41 || i2 == -59) {
            eV = com.tencent.mm.h.a.eV(str);
            if (eV != null) {
                eV.a(this.eSu, null, null);
            } else {
                com.tencent.mm.ui.base.h.i(this.eSu, a$j.regbymobile_reg_mobile_format_err_msg, a$j.regbymobile_reg_mobile_format_err_title);
            }
        } else if (lVar.getType() == 145) {
            int Oh = ((com.tencent.mm.modelfriend.a) lVar).Oh();
            if (Oh == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String Ol = ((com.tencent.mm.modelfriend.a) lVar).Ol();
                    if (!bi.oW(Ol)) {
                        this.eSu.eTa = Ol.trim();
                    }
                    this.eSu.eTa = ap.Ww(this.eSu.eTa);
                    this.eSw = this.eSu.eSZ + this.eSu.eTa;
                    StringBuilder stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",F200_200,");
                    g.Eg();
                    com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("F200_200")).append(",1").toString());
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eSu, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                h.this.YH();
                                StringBuilder stringBuilder = new StringBuilder();
                                g.Eg();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",F200_200,");
                                g.Eg();
                                com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("F200_200")).append(",2").toString());
                            }
                        }, new 3(this));
                        return;
                    }
                    YH();
                    stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",F200_200,");
                    g.Eg();
                    com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("F200_200")).append(",2").toString());
                    return;
                } else if (i2 == -34) {
                    com.tencent.mm.ui.base.h.b(this.eSu, this.eSu.getString(a$j.bind_mcontact_err_freq_limit), "", true);
                    return;
                } else {
                    Toast.makeText(this.eSu, this.eSu.getString(a$j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (Oh == 8 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.eSu.eSZ + " " + this.eSu.eSM.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.eSu.eTa);
                intent.putExtra("country_name", this.eSu.dYy);
                intent.putExtra("couttry_code", this.eSu.countryCode);
                intent.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) lVar).Oq());
                intent.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) lVar).Or());
                intent.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) lVar).Os());
                intent.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a) lVar).Ot());
                intent.putExtra("mobile_verify_purpose", 3);
                intent.setClass(this.eSu, MobileVerifyUI.class);
                this.eSu.startActivity(intent);
            }
        }
    }

    private void YH() {
        MobileInputUI mobileInputUI = this.eSu;
        Context context = this.eSu;
        this.eSu.getString(a$j.app_tip);
        mobileInputUI.eIV = com.tencent.mm.ui.base.h.a(context, this.eSu.getString(a$j.regbyfacebook_reg_setpwd_exiting), true, new 4(this));
        g.DF().a(new com.tencent.mm.modelfriend.a(this.eSu.eSZ + this.eSu.eTa, 8, "", 0, ""), 0);
    }
}
