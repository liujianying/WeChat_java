package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakOldUSBService extends Service implements e {
    private boolean gWY = false;
    private int gZb = -1;

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.BakOldUSBService", "onBind()");
        return null;
    }

    public void onCreate() {
        x.i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        au.DF().a(595, this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        x.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[]{Integer.valueOf(this.gZb)});
        if (intent == null) {
            x.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (bi.oW(stringExtra)) {
                x.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.gWY = intent.getBooleanExtra("isFromWifi", false);
                x.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[]{stringExtra, Boolean.valueOf(this.gWY)});
                a.asN().asP().IF();
                c asP = a.asN().asP();
                if (this.gWY) {
                    i3 = 2;
                }
                asP.gZt = i3;
                if (au.HW()) {
                    au.DF().a(new f(stringExtra), 0);
                } else {
                    x.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        au.DF().b(595, this);
        b.b(1, this);
        super.onDestroy();
        x.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    }

    private boolean asL() {
        return this.gZb == 0 || this.gZb == 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.BakOldUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = lVar == null ? "" : lVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.gZb);
        x.i(str2, str3, objArr);
        if (lVar instanceof b) {
            x.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(this.gZb)});
            if (lVar.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                str3 = "newPCBackup";
                if (asL()) {
                    z = false;
                } else {
                    z = true;
                }
                className.putExtra(str3, z);
                startActivity(className);
            }
            stopSelf();
        } else if (!(lVar instanceof f)) {
        } else {
            if (i == 0 && i2 == 0) {
                ach atg = ((f) lVar).atg();
                a.asN().gRu = atg.ID;
                a.asN().gRv = atg.rfr;
                a.asN().gRw = atg.rfs;
                this.gZb = atg.otY;
                x.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[]{Integer.valueOf(atg.hcE), Integer.valueOf(atg.otY), Boolean.valueOf(this.gWY)});
                if (!this.gWY && atg.hcE == 1) {
                    x.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    return;
                } else if (asL()) {
                    a.asN().asO().bS(atg.rfj, atg.rfk);
                    b.a(a.asN().asO());
                    b.a(a.asN().asQ());
                    b.mx(1);
                    a.asN().asQ().c(atg.hcE, atg.rfi);
                    return;
                } else {
                    x.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[]{Integer.valueOf(this.gZb)});
                    return;
                }
            }
            a.asN().asP().gZu = 2;
            a.asN().asP().IF();
            if (i == 4 && i2 == -2011) {
                x.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
            } else {
                x.i("MicroMsg.BakOldUSBService", "getConnect info other error");
            }
            a.asN().asO();
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.asX();
            stopSelf();
        }
    }

    public boolean stopService(Intent intent) {
        x.i("MicroMsg.BakOldUSBService", "stopService.");
        return super.stopService(intent);
    }
}
