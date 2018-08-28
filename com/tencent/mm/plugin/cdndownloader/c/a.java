package com.tencent.mm.plugin.cdndownloader.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.cdndownloader.a.b;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
    private static a hJY;
    private long hJZ = 0;
    long hKa = 0;
    com.tencent.mm.plugin.cdndownloader.a.a hKb;
    Set<CDNTaskInfo> hKc = new com.tencent.mm.plugin.cdndownloader.d.a(new 1(this));
    public b hKd;
    private ServiceConnection hKe = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
            a.this.hKb = com.tencent.mm.plugin.cdndownloader.a.a.a.H(iBinder);
            a aVar = a.this;
            try {
                x.i("MicroMsg.CDNDownloadClient", "registerCallback");
                aVar.hKb.a(aVar.hKg);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "registerCallback: " + e.getMessage());
            }
            a.c(a.this);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
            if (a.this.hKc.size() != 0) {
                for (CDNTaskInfo cDNTaskInfo : a.this.hKc) {
                    cDNTaskInfo.hKp = true;
                }
            }
        }
    };
    al hKf = new al(com.tencent.mm.bu.a.coq().getLooper(), new 3(this), true);
    b hKg = new 4(this);
    private com.tencent.mm.network.n.a hKh = new com.tencent.mm.network.n.a() {
        public final void ev(int i) {
            a aVar = a.this;
            x.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: " + i);
            if (aVar.hKb != null) {
                try {
                    aVar.hKb.od(i);
                } catch (RemoteException e) {
                }
            }
        }
    };
    private Context mContext = ad.getContext();

    static /* synthetic */ void c(a aVar) {
        x.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected");
        if (aVar.hKc.size() > 0) {
            aVar.aAg();
        }
        for (CDNTaskInfo cDNTaskInfo : aVar.hKc) {
            x.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected, url: %s, resume: %b", new Object[]{cDNTaskInfo.downloadUrl, Boolean.valueOf(cDNTaskInfo.hKp)});
            try {
                if (cDNTaskInfo.hKp) {
                    aVar.hKb.b(cDNTaskInfo);
                } else {
                    aVar.hKb.a(cDNTaskInfo);
                }
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected: " + e);
                h.mEJ.a(710, 0, 1, false);
            }
        }
    }

    public static synchronized a aAk() {
        a aVar;
        synchronized (a.class) {
            if (hJY == null) {
                hJY = new a();
            }
            aVar = hJY;
        }
        return aVar;
    }

    public a() {
        g.Ek();
        g.Eh().a(this.hKh);
        aAl();
    }

    final synchronized void aAl() {
        try {
            x.i("MicroMsg.CDNDownloadClient", "bindService: " + this.mContext.bindService(new Intent(this.mContext, CDNDownloadService.class), this.hKe, 1));
        } catch (Exception e) {
            x.e("MicroMsg.CDNDownloadClient", "bindService: " + e.getMessage());
        }
        return;
    }

    public final int a(CDNTaskInfo cDNTaskInfo) {
        if (cDNTaskInfo == null || bi.oW(cDNTaskInfo.downloadUrl)) {
            x.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
            return -1;
        }
        x.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[]{cDNTaskInfo.filePath, cDNTaskInfo.downloadUrl});
        if (this.hKc.contains(cDNTaskInfo)) {
            x.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
            return -2;
        }
        if (this.hKb != null) {
            try {
                int a = this.hKb.a(cDNTaskInfo);
                if (a == 0 || a == -2) {
                    this.hKc.add(cDNTaskInfo);
                }
                return a;
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + e.getMessage());
            }
        }
        this.hKc.add(cDNTaskInfo);
        aAl();
        return 0;
    }

    public final boolean yj(String str) {
        boolean z = false;
        x.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: " + str);
        if (bi.oW(str)) {
            x.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
            return z;
        }
        if (this.hKb != null) {
            try {
                this.hKc.remove(new CDNTaskInfo(str));
                return this.hKb.yj(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + e.getMessage());
            }
        }
        x.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
        return z;
    }

    public final int b(CDNTaskInfo cDNTaskInfo) {
        if (cDNTaskInfo == null || bi.oW(cDNTaskInfo.downloadUrl)) {
            x.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
            return -1;
        }
        x.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + cDNTaskInfo.downloadUrl);
        cDNTaskInfo.hKp = true;
        if (this.hKb != null) {
            try {
                int b = this.hKb.b(cDNTaskInfo);
                if (b != 0 && b != -2) {
                    return b;
                }
                this.hKc.add(cDNTaskInfo);
                return b;
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + e.getMessage());
            }
        }
        this.hKc.add(cDNTaskInfo);
        aAl();
        return 0;
    }

    public final boolean yk(String str) {
        boolean z = false;
        x.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: " + str);
        if (bi.oW(str)) {
            x.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
            return z;
        }
        if (this.hKb != null) {
            try {
                this.hKc.remove(new CDNTaskInfo(str));
                return this.hKb.yk(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + e.getMessage());
            }
        }
        x.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
        return z;
    }

    public final CDNTaskState yl(String str) {
        CDNTaskState cDNTaskState = null;
        if (bi.oW(str)) {
            x.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
            return cDNTaskState;
        } else if (this.hKb == null) {
            return cDNTaskState;
        } else {
            try {
                return this.hKb.yl(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + e.getMessage());
                return cDNTaskState;
            }
        }
    }

    final void aAg() {
        if (this.hKb != null) {
            try {
                this.hKb.aAg();
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: " + e);
            }
        }
    }
}
