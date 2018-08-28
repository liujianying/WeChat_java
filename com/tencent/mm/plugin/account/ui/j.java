package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class j implements e, b {
    protected String eHp = null;
    protected String eHq = "";
    protected int eHr = 2;
    private MobileInputUI eSu;

    public final void a(MobileInputUI mobileInputUI) {
        this.eSu = mobileInputUI;
        mobileInputUI.eSN.requestFocus();
        mobileInputUI.showVKB();
        this.eHp = mobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.eHq = mobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.eHr = mobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        String string = mobileInputUI.getString(a$j.regbymoile_reg_title);
        if (d.qVQ) {
            string = string + mobileInputUI.getString(a$j.alpha_version_alpha);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.eGq.setVisibility(0);
        mobileInputUI.eSM.setVisibility(0);
        mobileInputUI.eSN.requestFocus();
        mobileInputUI.eSP.setVisibility(0);
        mobileInputUI.eSS.setVisibility(0);
        mobileInputUI.eSS.setText(a$j.loginby_new_mobile_reg_ok);
    }

    public final void start() {
        g.DF().a(132, this);
    }

    public final void stop() {
        g.DF().b(132, this);
    }

    public final void jm(int i) {
        switch (2.eSz[i - 1]) {
            case 1:
                this.eSu.eSZ = ap.Wy(this.eSu.countryCode);
                this.eSu.eTa = this.eSu.eSM.getText().toString();
                String str = this.eSu.eSZ + this.eSu.eTa;
                if (this.eSu.eIV != null) {
                    x.d("MicroMsg.MobileInputRegLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.eSu;
                Context context = this.eSu;
                this.eSu.getString(a$j.app_tip);
                mobileInputUI.eIV = h.a(context, this.eSu.getString(a$j.regbyfacebook_reg_setpwd_exiting), true, new 1(this));
                g.DF().a(new com.tencent.mm.plugin.account.friend.a.x(str, 1, "", 0, ""), 0);
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
        if (lVar.getType() != 132) {
            return;
        }
        if (i == 0 && i2 == 0) {
            if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() == 1) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.eSu.eSZ + " " + this.eSu.eSM.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.eSu.eSM.getText().toString());
                intent.putExtra("country_name", this.eSu.dYy);
                intent.putExtra("couttry_code", this.eSu.countryCode);
                intent.putExtra("mobile_verify_purpose", 4);
                intent.putExtra("regsetinfo_ticket", this.eHp);
                intent.putExtra("regsetinfo_NextStep", this.eHq);
                intent.putExtra("regsetinfo_NextStyle", this.eHr);
                intent.setClass(this.eSu, MobileVerifyUI.class);
                this.eSu.startActivity(intent);
                this.eSu.finish();
            }
        } else if (!a.ezo.a(this.eSu, i, i2, str)) {
            Toast.makeText(this.eSu, this.eSu.getString(a$j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
