package com.tencent.mm.plugin.account.bind.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class VerifyQQUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ VerifyQQUI eJq;
    final /* synthetic */ EditText eJr;
    final /* synthetic */ EditText eJs;

    VerifyQQUI$2(VerifyQQUI verifyQQUI, EditText editText, EditText editText2) {
        this.eJq = verifyQQUI;
        this.eJr = editText;
        this.eJs = editText2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = this.eJr.getText().toString().trim();
        VerifyQQUI.a(this.eJq, this.eJs.getText().toString().trim());
        try {
            VerifyQQUI.a(this.eJq, bi.getLong(trim, 0));
            if (VerifyQQUI.b(this.eJq) < 10000) {
                h.i(this.eJq.mController.tml, j.bind_qq_verify_alert_qq, j.bind_qq_verify_alert_failed_title);
            } else if (VerifyQQUI.c(this.eJq).equals("")) {
                h.i(this.eJq.mController.tml, j.bind_qq_verify_alert_pwd, j.bind_qq_verify_alert_failed_title);
            } else {
                this.eJq.YC();
                b bVar = new b(VerifyQQUI.b(this.eJq), VerifyQQUI.c(this.eJq), "", "", "", VerifyQQUI.d(this.eJq), VerifyQQUI.e(this.eJq), false);
                g.DF().a(bVar, 0);
                VerifyQQUI verifyQQUI = this.eJq;
                ActionBarActivity actionBarActivity = this.eJq.mController.tml;
                this.eJq.getString(j.bind_qq_verify_alert_title);
                VerifyQQUI.a(verifyQQUI, h.a(actionBarActivity, this.eJq.getString(j.bind_qq_verify_alert_binding), true, new 1(this, bVar)));
            }
        } catch (Exception e) {
            h.i(this.eJq.mController.tml, j.bind_qq_verify_alert_qq, j.bind_qq_verify_alert_failed_title);
        }
        return true;
    }
}
