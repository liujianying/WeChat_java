package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;

public final class i implements e, MobileInputUI$b {
    private SecurityImage eIX = null;
    private g eSA = null;
    private MobileInputUI eSu;

    public final void a(MobileInputUI mobileInputUI) {
        this.eSu = mobileInputUI;
        mobileInputUI.eGq.setVisibility(0);
        mobileInputUI.eSM.setVisibility(0);
        mobileInputUI.eSN.requestFocus();
        mobileInputUI.eSS.setText(j.app_nextstep);
        mobileInputUI.eSS.setVisibility(0);
        mobileInputUI.eSU.setVisibility(0);
        mobileInputUI.eSW.setText(j.login_by_other_account);
        mobileInputUI.eSW.setVisibility(0);
        mobileInputUI.eSW.setOnClickListener(new 1(this, mobileInputUI));
    }

    public final void start() {
        g.DF().a(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",L200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("L200_100")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("L200_100");
    }

    public final void stop() {
        g.DF().b(145, this);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",L200_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("L200_100")).append(",2").toString());
    }

    public final void jm(int i) {
        switch (3.eSz[i - 1]) {
            case 1:
                this.eSu.eSZ = ap.Wy(this.eSu.countryCode);
                this.eSu.eTa = this.eSu.eSN.getText().toString();
                String Ww = ap.Ww(this.eSu.eSZ + this.eSu.eTa);
                MobileInputUI mobileInputUI = this.eSu;
                MobileInputUI mobileInputUI2 = this.eSu;
                this.eSu.getString(j.app_tip);
                mobileInputUI.eIV = h.a(mobileInputUI2, this.eSu.getString(j.regbyfacebook_reg_setpwd_exiting), true, new 2(this));
                g.DF().a(new com.tencent.mm.modelfriend.a(Ww, 13, "", 0, ""), 0);
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eSu.eIV != null) {
            this.eSu.eIV.dismiss();
            this.eSu.eIV = null;
        }
        if (lVar.getType() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START && this.eSA != null) {
            this.eSA.eSi = this.eSu.eSi;
            this.eSA.a(this.eSu, i, i2, str, lVar);
        } else if (lVar.getType() != 145 || ((com.tencent.mm.modelfriend.a) lVar).Oh() != 13) {
        } else {
            if (i2 == -41) {
                com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this.eSu, null, null);
                } else {
                    h.i(this.eSu, j.regbymobile_reg_mobile_format_err_msg, j.regbymobile_reg_mobile_format_err_title);
                }
            } else if (i2 == -1) {
                Toast.makeText(this.eSu, this.eSu.getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i2 == -34) {
                h.b(this.eSu, this.eSu.getString(j.bind_mcontact_err_freq_limit), "", true);
            } else {
                this.eSu.YC();
                Intent intent = new Intent(this.eSu, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", -1);
                intent.putExtra("mobile_auth_type", 7);
                intent.putExtra("from_switch_account", this.eSu.eSf);
                intent.putExtra("couttry_code", this.eSu.countryCode);
                intent.putExtra("input_mobile_number", this.eSu.eTa);
                this.eSu.startActivity(intent);
            }
        }
    }
}
