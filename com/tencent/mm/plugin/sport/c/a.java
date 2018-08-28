package com.tencent.mm.plugin.sport.c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.a$a;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bn;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Calendar;

public final class a {
    public c<qt> ooJ = new 1(this);
    public f ooK;
    private long ooL;
    long ooM;
    public com.tencent.mm.plugin.sport.a.a ooN;
    private ServiceConnection ooO = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.Sport.DeviceStepManager", "onServiceConnected %s", new Object[]{componentName.toShortString()});
            a.this.ooN = a$a.T(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.Sport.DeviceStepManager", "onServiceDisconnected %s", new Object[]{componentName.toShortString()});
            a.this.ooN = null;
        }
    };

    static /* synthetic */ boolean bFF() {
        return n.ei(ad.getContext()) && n.bFv();
    }

    public a() {
        this.ooJ.cht();
    }

    public final boolean fs(long j) {
        if (this.ooK != null) {
            g.DF().c(this.ooK);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        x.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[]{n.bx(System.currentTimeMillis()), Long.valueOf(j)});
        this.ooK = new f("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (r6 / 1000), (int) j, bn.cmZ(), 1);
        g.DF().a(this.ooK, 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.ooM = currentTimeMillis;
        i.M(3, currentTimeMillis);
        this.ooL = j;
        i.M(4, this.ooL);
        return true;
    }

    public final long bFC() {
        if (this.ooL == 0) {
            this.ooL = i.L(4, 0);
        }
        return this.ooL;
    }

    public final long bFD() {
        long bFz;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        if (this.ooN != null) {
            try {
                bFz = this.ooN.bFz();
                try {
                    str = "exdevice";
                } catch (RemoteException e) {
                }
            } catch (RemoteException e2) {
                bFz = -1;
            }
        } else {
            bFz = -1;
        }
        if (bFz == -1) {
            long ciZ = bi.ciZ() / 10000;
            long xS = i.xS(TbsListener$ErrorCode.APK_PATH_ERROR);
            bFz = i.xS(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM);
            if (xS == ciZ) {
                str = "mm";
            } else {
                str = "unknow";
                bFz = 0;
            }
        }
        x.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", new Object[]{str, Long.valueOf(bFz), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return bFz;
    }

    public final void bFE() {
        if (!n.ei(ad.getContext())) {
            try {
                if (this.ooN != null) {
                    ad.getContext().unbindService(this.ooO);
                }
                ad.getContext().stopService(new Intent(ad.getContext(), SportService.class));
            } catch (Exception e) {
            }
            this.ooN = null;
        } else if (this.ooN != null) {
            x.i("MicroMsg.Sport.DeviceStepManager", "Not need bind");
        } else {
            x.i("MicroMsg.Sport.DeviceStepManager", "start to bind sport aidl");
            try {
                Intent intent = new Intent(ad.getContext(), SportService.class);
                intent.setFlags(268435456);
                ad.getContext().bindService(intent, this.ooO, 1);
            } catch (Exception e2) {
            }
        }
    }
}
