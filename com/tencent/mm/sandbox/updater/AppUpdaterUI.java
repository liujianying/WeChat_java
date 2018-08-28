package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c;
import org.xwalk.core.XWalkEnvironment;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI sDt = null;
    private c eIW = null;
    private Button haQ;
    private OnClickListener sDp = new 10(this);
    private Button sDs;
    private j sDu;
    private g sDv = new g() {
        public final void co(int i, int i2) {
            int i3 = (int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i));
            if (i3 == 100) {
                AppUpdaterUI.this.sDs.setText(AppUpdaterUI.this.getString(R.l.update_merge_apk));
            } else {
                AppUpdaterUI.this.sDs.setText(AppUpdaterUI.this.getString(R.l.update_getting_updatepack) + i3 + "%");
            }
        }

        public final void cgR() {
            x.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (AppUpdaterUI.this.eIW != null) {
                AppUpdaterUI.this.eIW.dismiss();
            }
            if (!AppUpdaterUI.this.isFinishing()) {
                AppUpdaterUI.c(AppUpdaterUI.this);
            }
        }

        public final void cgS() {
            if (AppUpdaterUI.this.eIW != null) {
                AppUpdaterUI.this.eIW.dismiss();
            }
            if (!AppUpdaterUI.this.isFinishing()) {
                AppUpdaterUI.d(AppUpdaterUI.this);
            }
        }

        public final void bzS() {
            if (!AppUpdaterUI.this.isFinishing()) {
                AppUpdaterUI.this.sDs.setText(R.l.update_getting_updatepack);
                AppUpdaterUI.this.sDs.setEnabled(false);
            }
        }

        public final void MX(String str) {
            if (AppUpdaterUI.this.eIW != null) {
                AppUpdaterUI.this.eIW.dismiss();
            }
            if (!AppUpdaterUI.this.isFinishing()) {
                x.d("MicroMsg.AppUpdaterUI", str);
                if (str != null) {
                    AppUpdaterUI.a(AppUpdaterUI.this, str);
                    AppUpdaterUI.this.sDs.setEnabled(false);
                }
            }
        }

        public final void a(com.tencent.mm.sandbox.monitor.c cVar) {
            if (!AppUpdaterUI.this.isFinishing()) {
                if (cVar instanceof c) {
                    h.mEJ.a(405, 67, 1, true);
                    x.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                    if (AppUpdaterUI.this.eIW != null) {
                        AppUpdaterUI.this.eIW.setMessage(AppUpdaterUI.this.getString(R.l.fmt_update_info, new Object[]{AppUpdaterUI.this.sDu.desc, AppUpdaterUI.this.getString(R.l.update_full_web_tips), bi.bF((long) AppUpdaterUI.this.sDu.size)}));
                    }
                    if (AppUpdaterUI.this.sDu.sEF) {
                        h.mEJ.a(405, 68, 1, true);
                        AppUpdaterUI.a(AppUpdaterUI.this, cVar);
                        return;
                    }
                    return;
                }
                h.mEJ.a(405, 69, 1, true);
                com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, R.l.update_get_pack_error, R.l.app_tip, new 1(this), new 2(this));
            }
        }
    };
    private OnClickListener sDw = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppUpdaterUI.g(AppUpdaterUI.this);
        }
    };

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        h.mEJ.a(405, 65, 1, true);
        com.tencent.mm.ui.base.h.a(appUpdaterUI, appUpdaterUI.getString(R.l.update_no_sdcard_tips), appUpdaterUI.getString(R.l.app_tip), new 3(appUpdaterUI)).setOnCancelListener(new 4(appUpdaterUI));
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        h.mEJ.a(405, 66, 1, true);
        com.tencent.mm.ui.base.h.a(appUpdaterUI, appUpdaterUI.getString(R.l.update_sdcard_full), appUpdaterUI.getString(R.l.app_tip), new 14(appUpdaterUI)).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(AppUpdaterUI.this);
            }
        });
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.sDu.sEK) {
            com.tencent.mm.ui.base.h.b(appUpdaterUI, R.l.cancel_download, R.l.app_tip, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (AppUpdaterUI.this.eIW != null && AppUpdaterUI.this.eIW.isShowing()) {
                        AppUpdaterUI.this.eIW.dismiss();
                    }
                    i.ah(AppUpdaterUI.this, 6);
                    if (AppUpdaterUI.this.sDu.sEJ) {
                        h.mEJ.a(614, 59, 1, true);
                        x.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
                    }
                    AppUpdaterUI.this.sDu.cancel();
                    AppUpdaterUI.this.sDu.ai(2, true);
                    AppUpdaterUI.this.cgQ();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (AppUpdaterUI.this.eIW != null && !AppUpdaterUI.this.eIW.isShowing()) {
                        AppUpdaterUI.this.eIW.show();
                    }
                }
            });
            return;
        }
        if (appUpdaterUI.sDu.nPm == 1) {
            i.ai(appUpdaterUI, 7);
            if (appUpdaterUI.sDu.sEJ) {
                h.mEJ.a(614, 57, 1, true);
                x.d("MicroMsg.AppUpdaterUI", "boots download cancel.");
            }
        }
        i.ah(appUpdaterUI, 6);
        appUpdaterUI.sDu.ai(2, true);
        appUpdaterUI.cgQ();
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        appUpdaterUI.sDu.cancel();
        appUpdaterUI.sDu.ai(2, true);
        appUpdaterUI.cgQ();
    }

    public static AppUpdaterUI cgO() {
        return sDt;
    }

    public static void cgP() {
        if (sDt != null) {
            sDt.cgQ();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.i(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppInstallerUI.cgN() != null && !AppInstallerUI.cgN().isFinishing()) {
            x.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
        } else if (sDt == null || sDt.isFinishing() || sDt == this) {
            sDt = this;
            setContentView(R.i.empty);
            this.sDu = a.sER;
            if (!this.sDu.ap(getIntent())) {
                x.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                cgQ();
            } else if (this.sDu.sDi != XWalkEnvironment.LOCAL_TEST_VERSION || this.sDu.sDK == null || this.sDu.sDK.length <= 0) {
                String string;
                x.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.sDu.sDK);
                c.a aVar = new c.a(this);
                aVar.Gq(R.l.fmt_update);
                aVar.mF(true);
                aVar.e(new 8(this));
                if (!this.sDu.sEF || this.sDu.sEE == null) {
                    x.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(R.l.fmt_update_info, new Object[]{this.sDu.desc, getString(R.l.update_full_web_tips), bi.bF((long) this.sDu.size)});
                } else {
                    string = getString(R.l.fmt_update_info, new Object[]{this.sDu.desc, getString(R.l.update_increment_tips), bi.bF((long) this.sDu.sEE.size)});
                }
                int i = this.sDu.sDi != 1 ? R.l.update_cancel : R.l.update_exit;
                aVar.abu(string);
                aVar.Gt(R.l.update_now).a(false, this.sDp);
                aVar.Gu(i);
                this.eIW = aVar.anj();
                this.eIW.setCanceledOnTouchOutside(false);
                this.sDs = this.eIW.getButton(-1);
                this.haQ = this.eIW.getButton(-2);
                this.eIW.show();
                if (this.sDu.nPm == 1) {
                    i.ai(this, 5);
                }
                if (this.sDu.sEJ) {
                    h.mEJ.a(614, 60, 1, false);
                }
                j jVar = this.sDu;
                g gVar = this.sDv;
                if (gVar != null && !jVar.sEA.contains(gVar)) {
                    jVar.sEA.add(gVar);
                }
            } else {
                x.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, AppUpdaterUI.this.sDu.desc, AppUpdaterUI.this.getString(R.l.app_tip), new 1(this)).setOnCancelListener(new 2(this));
                    }
                }, 100);
            }
        } else {
            x.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            x.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
        }
    }

    protected void onDestroy() {
        x.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.j(hashCode(), this);
        if (this.sDu != null) {
            j jVar = this.sDu;
            jVar.sEA.remove(this.sDv);
        }
        if (sDt == this) {
            sDt = null;
        }
        super.onDestroy();
    }

    private void cgQ() {
        if (this.eIW != null && this.eIW.isShowing()) {
            this.eIW.dismiss();
        }
        finish();
    }
}
