package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

@a(3)
public class BackupPcUI extends MMWizardActivity {
    private static boolean eFl = false;
    private TextView gVr;
    private TextView gVs;
    private TextView gVt;
    private TextView gVu;
    private TextView gVv;
    private ImageView gVw;
    public c gXk = new 3(this);

    static /* synthetic */ void m(BackupPcUI backupPcUI) {
        x.i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(R.l.backup_pc_network_disconnect_doc_title));
        intent.putExtra("rawUrl", backupPcUI.getString(R.l.backup_pc_network_disconnect_doc, new Object[]{w.chP()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupPcUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ezn.vo();
            initView();
            if (b.arV().arW().gWD) {
                b.arV().arW().gWD = false;
                int ara = g.ara();
                if (ara < 50) {
                    h.mEJ.a(400, 4, 1, false);
                    h.mEJ.h(13736, new Object[]{Integer.valueOf(4), b.arV().arW().gWx, g.cQ(this), Integer.valueOf(0), Integer.valueOf(b.arV().arW().gWC)});
                    com.tencent.mm.ui.base.h.a(this, R.l.backup_pc_error_low_battery_tip, R.l.backup_pc_error_low_battery, R.l.backup_sure, 0, false, new 1(this, ara), null, R.e.backup_green);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.BackupPcUI", "onStart.");
        eFl = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.BackupPcUI", "onPause.");
        e arX = b.arV().arX();
        c cVar = this.gXk;
        synchronized (arX.gWI) {
            arX.gWI.remove(cVar);
        }
        com.tencent.mm.plugin.backup.backuppcmodel.d arY = b.arV().arY();
        cVar = this.gXk;
        synchronized (arY.gWI) {
            arY.gWI.remove(cVar);
        }
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.BackupPcUI", "onResume.");
        e arX = b.arV().arX();
        c cVar = this.gXk;
        synchronized (arX.gWI) {
            arX.gWI.add(cVar);
        }
        com.tencent.mm.plugin.backup.backuppcmodel.d arY = b.arV().arY();
        cVar = this.gXk;
        synchronized (arY.gWI) {
            arY.gWI.add(cVar);
        }
        this.gXk.mw(b.arV().aqP().gRC);
    }

    public final void initView() {
        this.gVv = (TextView) findViewById(R.h.backup_close_btn);
        this.gVw = (ImageView) findViewById(R.h.backup_image);
        this.gVt = (TextView) findViewById(R.h.backup_status_title);
        this.gVu = (TextView) findViewById(R.h.backup_status_content);
        this.gVr = (TextView) findViewById(R.h.backup_btn);
        this.gVs = (TextView) findViewById(R.h.backup_bottom_btn);
    }

    protected final int getLayoutId() {
        return R.i.backup_pc;
    }

    public void onDestroy() {
        x.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[]{bi.cjd()});
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        arR();
        return true;
    }

    private void arR() {
        x.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d", new Object[]{Integer.valueOf(b.arV().aqP().gRC)});
        switch (b.arV().aqP().gRC) {
            case -22:
            case -21:
            case IX5WebViewClient.ERROR_FILE /*-13*/:
            case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
            case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
            case 1:
            case 11:
            case 21:
                if (1 != b.arV().arW().gWw && 3 != b.arV().arW().gWw) {
                    if (2 != b.arV().arW().gWw && 4 != b.arV().arW().gWw) {
                        b.arV().aqP().gRC = -100;
                        break;
                    } else {
                        b.arV().arY().a(false, false, -100);
                        return;
                    }
                }
                b.arV().arX().an(false);
                b.arV().aqP().gRC = -100;
                break;
            case 15:
                x.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                ash();
                return;
            case 24:
                b.arV().aqP().gRC = 25;
                break;
            case 26:
                com.tencent.mm.ui.base.h.a(this, R.l.backup_pc_error_alert_stop_recover_tip, R.l.backup_pc_error_alert_stop_recover, R.l.backup_pc_stop_recover, R.l.backup_cancel, false, new 2(this), null, R.e.backup_red);
                return;
            case 27:
                x.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                ash();
                return;
        }
        DT(1);
    }

    private void ash() {
        x.i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == b.arV().arW().gWw || 3 == b.arV().arW().gWw) {
            b.arV().arZ().cancel();
            b.arV().arZ().art();
            b.arV().arX().an(true);
            b.arV().arw().stop();
            b.arV().aqP().gRC = -100;
            DT(1);
        } else if (2 == b.arV().arW().gWw || 4 == b.arV().arW().gWw) {
            b.arV().arY().a(true, true, -100);
            b.arV().arw().stop();
        }
    }
}
