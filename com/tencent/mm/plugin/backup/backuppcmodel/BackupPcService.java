package com.tencent.mm.plugin.backup.backuppcmodel;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.plugin.backup.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupPcService extends Service {
    private boolean fTW = false;
    private boolean gWY = false;

    public void onCreate() {
        x.i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            x.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
        } else {
            final String stringExtra = intent.getStringExtra("url");
            if (bi.oW(stringExtra)) {
                x.e("MicroMsg.BackupPcService", "onStartCommand url is null");
                stopSelf();
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                x.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
                startService(new Intent(this, BakOldUSBService.class).putExtra("url", intent.getStringExtra("url")).putExtra("isFromWifi", true));
                stopSelf();
            } else {
                this.gWY = intent.getBooleanExtra("isFromWifi", false);
                this.fTW = intent.getBooleanExtra("isMove", false);
                x.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[]{stringExtra, Boolean.valueOf(this.gWY), Boolean.valueOf(this.fTW)});
                if (this.fTW || au.HW()) {
                    ah.A(new Runnable() {
                        public final void run() {
                            c arW = b.arV().arW();
                            x.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[]{stringExtra});
                            d.mx(1);
                            au.HU();
                            arW.gWC = ((Integer) c.DT().get(a.sUX, Integer.valueOf(0))).intValue();
                            b.arV();
                            Editor edit = b.aqU().edit();
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
                            edit.commit();
                            arW.gWD = true;
                            au.DF().a(595, arW.gUj);
                            au.DF().a(new e(r2), 0);
                        }
                    });
                } else {
                    x.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    }
}
