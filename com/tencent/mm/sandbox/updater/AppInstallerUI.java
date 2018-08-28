package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI sDo = null;
    private String bKg;
    private String desc;
    private c eIW = null;
    private int nPm;
    private c sDn = null;
    private OnClickListener sDp = new 2(this);

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        x.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.eIW != null && appInstallerUI.eIW.isShowing()) {
            appInstallerUI.eIW.dismiss();
        }
        if (appInstallerUI.sDn == null || !appInstallerUI.sDn.isShowing()) {
            appInstallerUI.sDn = h.a(appInstallerUI, R.l.cancel_install, R.l.app_tip, R.l.cancel_install_btn, R.l.continue_install_btn, false, new 4(appInstallerUI), new 5(appInstallerUI));
            return;
        }
        x.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
    }

    public static AppInstallerUI cgN() {
        return sDo;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.AppInstallerUI", "onCreate");
        com.tencent.mm.sandbox.c.i(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppUpdaterUI.cgO() != null && !AppUpdaterUI.cgO().isFinishing()) {
            x.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
        } else if (sDo == null || sDo.isFinishing() || sDo == this) {
            sDo = this;
            this.bKg = i.cce();
            if (bi.oW(this.bKg) || com.tencent.mm.sandbox.monitor.c.Hw(this.bKg) == null) {
                finish();
                return;
            }
            this.desc = i.cgY();
            this.nPm = i.cgZ();
            setContentView(R.i.empty);
            a aVar = new a(this);
            aVar.Gq(R.l.fmt_update);
            aVar.mF(true);
            aVar.e(new 1(this));
            aVar.abu(getString(R.l.fmt_update_install_info, new Object[]{this.desc}));
            aVar.Gt(R.l.install_now).a(false, this.sDp);
            aVar.Gu(R.l.update_cancel).b(null);
            this.eIW = aVar.anj();
            this.eIW.setCanceledOnTouchOutside(false);
            this.eIW.show();
            com.tencent.mm.plugin.report.service.h.mEJ.a(405, 71, 1, true);
            if (this.nPm == 2) {
                i.g(this, 2, i.cha() + 1);
            }
        } else {
            x.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
        }
    }

    protected void onDestroy() {
        x.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.eIW != null && this.eIW.isShowing()) {
            this.eIW.dismiss();
        }
        if (this.sDn != null && this.sDn.isShowing()) {
            this.sDn.dismiss();
        }
        if (sDo == this) {
            sDo = null;
        }
        com.tencent.mm.sandbox.c.j(hashCode(), this);
        super.onDestroy();
    }
}
