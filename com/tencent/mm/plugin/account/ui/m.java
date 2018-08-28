package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class m implements e, b {
    SecurityImage eIX = null;
    f eQY = null;
    private g eSA = null;
    MobileVerifyUI eTG;
    private int eTb;

    public m(int i) {
        this.eTb = i;
        x.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[]{Integer.valueOf(i)});
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.eTG = mobileVerifyUI;
    }

    public final void start() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",F200_300,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("F200_300")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("F200_300");
    }

    public final void stop() {
        int i = 2;
        if (this.eTG.eUl != -1) {
            i = this.eTG.eUl;
        }
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",F200_300,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("F200_300")).append(",").append(i).toString());
    }

    public final boolean jn(int i) {
        switch (5.eTK[i - 1]) {
            case 1:
                YM();
                break;
            case 2:
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_400,");
                g.Eg();
                com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R200_400")).append(",1").toString());
                l lVar = null;
                if (this.eTb == 3) {
                    lVar = new com.tencent.mm.modelfriend.a(this.eTG.bTi, 8, "", 0, "");
                } else if (this.eTb == 5) {
                    lVar = new com.tencent.mm.plugin.account.friend.a.x(this.eTG.bTi, 20, "", 0, "");
                }
                if (lVar != null) {
                    g.DF().a(lVar, 0);
                    break;
                }
                break;
            case 3:
                YM();
                break;
        }
        return false;
    }

    private void YM() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_350_auto,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R200_350_auto")).append(",1").toString());
        g.DF().a(145, this);
        g.DF().a(132, this);
        l lVar = null;
        if (this.eTb == 3) {
            lVar = new com.tencent.mm.modelfriend.a(this.eTG.bTi, 9, this.eTG.eGC.getText().toString().trim(), 0, "");
        } else if (this.eTb == 5) {
            lVar = new com.tencent.mm.plugin.account.friend.a.x(this.eTG.bTi, 21, this.eTG.eGC.getText().toString().trim(), 0, "");
        }
        if (lVar != null) {
            g.DF().a(lVar, 0);
            MobileVerifyUI mobileVerifyUI = this.eTG;
            MobileVerifyUI mobileVerifyUI2 = this.eTG;
            this.eTG.getString(j.app_tip);
            mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.bind_mcontact_verifing), true, new 1(this, lVar));
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eTG.eHw != null) {
            this.eTG.eHw.dismiss();
            this.eTG.eHw = null;
        }
        if (this.eQY == null) {
            this.eQY = new f();
        }
        if (lVar.getType() != TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL || this.eSA == null) {
            com.tencent.mm.h.a eV;
            if (lVar.getType() == 145) {
                this.eQY.account = ((com.tencent.mm.modelfriend.a) lVar).getUsername();
                this.eQY.eRP = ((com.tencent.mm.modelfriend.a) lVar).Oi();
                g.DF().b(145, this);
                if (i == 0 && i2 == 0) {
                    if (this.eTb == 3) {
                        g.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
                        this.eSA = new g(new 4(this), ((com.tencent.mm.modelfriend.a) lVar).getUsername(), ((com.tencent.mm.modelfriend.a) lVar).Oi(), this.eTG.bTi);
                        this.eSA.a(this.eTG);
                        return;
                    }
                    return;
                } else if (i2 == -51) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eTG, null, null);
                        return;
                    } else {
                        h.i(this.eTG, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip);
                        return;
                    }
                }
            }
            if (lVar.getType() == 132) {
                g.DF().b(132, this);
                if (i == 0 && i2 == 0) {
                    if (this.eTb == 5) {
                        String Oj = ((com.tencent.mm.plugin.account.friend.a.x) lVar).Oj();
                        Intent intent = new Intent();
                        intent.putExtra("setpwd_ticket", Oj);
                        this.eTG.setResult(-1, intent);
                        this.eTG.finish();
                        return;
                    }
                    return;
                } else if (i2 == -51) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eTG, null, null);
                        return;
                    } else {
                        h.i(this.eTG, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip);
                        return;
                    }
                }
            }
            if (!this.eTG.e(i, i2, str)) {
                if (lVar.getType() == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null && eV.a(this.eTG, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.eTG, this.eTG.getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
                return;
            }
            return;
        }
        g.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
        this.eQY.eJa = ((q) lVar).Re();
        this.eQY.eIZ = ((q) lVar).Rf();
        this.eQY.eJb = ((q) lVar).Rg();
        this.eQY.eRQ = ((q) lVar).getSecCodeType();
        if (i2 == -6 || i2 == -311 || i2 == -310) {
            g.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
            if (this.eIX == null) {
                this.eIX = SecurityImage.a.a(this.eTG, j.regbyqq_secimg_title, this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb, new 2(this), null, new 3(this), this.eQY);
                return;
            }
            x.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.eQY.eJa + " img len" + this.eQY.eIZ.length + " " + com.tencent.mm.compatible.util.g.Ac());
            this.eIX.a(this.eQY.eRQ, this.eQY.eIZ, this.eQY.eJa, this.eQY.eJb);
            return;
        }
        this.eSA.a(this.eTG, i, i2, str, lVar);
        if (i == 0 && i2 == 0) {
            boolean Rm;
            if (lVar instanceof q) {
                Rm = ((q) lVar).Rm();
            } else {
                Rm = true;
            }
            this.eTG.co(Rm);
        }
    }
}
