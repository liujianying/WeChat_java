package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.ui.base.h;

public class RegByFacebookSetPwdUI extends SetPwdUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.regbyfacebook_reg_setpwd_title);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return g.regbyfacebooksetpwd_reg;
    }

    protected final void initView() {
        setMMTitle(j.regbyfacebook_reg_setpwd_title);
    }

    protected final ProgressDialog a(Context context, String str, OnCancelListener onCancelListener) {
        return h.a(context, getString(j.regbyfacebook_reg_setpwd_exiting), true, onCancelListener);
    }

    protected final l YR() {
        return new ak(this.eWT);
    }

    protected final String YS() {
        return ((EditText) findViewById(f.regbyfacebookreg_pass_et)).getText().toString();
    }

    protected final String YT() {
        return ((EditText) findViewById(f.regbyfacebookreg_pass_again_et)).getText().toString();
    }

    protected final int YU() {
        return 382;
    }

    protected final void jo(int i) {
        switch (2.evn[i - 1]) {
            case 1:
                h.i(this, j.regbyfacebook_reg_setpwd_alert_diff, j.regbyfacebook_reg_setpwd_alert_title);
                return;
            case 2:
                h.i(this, j.regbyfacebook_reg_setpwd_alert_more_byte, j.regbyfacebook_reg_setpwd_alert_title);
                return;
            case 3:
                h.i(this, j.verify_password_all_num_tip, j.app_err_reg_title);
                return;
            case 4:
                h.i(this, j.verify_password_tip, j.app_err_reg_title);
                return;
            default:
                return;
        }
    }

    protected final boolean f(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return e(i, i2, str);
        }
        com.tencent.mm.kernel.g.Ei().DT().set(57, Integer.valueOf(0));
        String str2 = (String) com.tencent.mm.kernel.g.Ei().DT().get(5, null);
        h.a(this, getString(j.regbyfacebook_reg_setpwd_success, new Object[]{str2}), getString(j.regbyfacebook_reg_setpwd_alert_title), new 1(this));
        return true;
    }
}
