package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aa.a;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.12;
import com.tencent.mm.network.w;
import com.tencent.mm.network.y;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ab.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class CoreService extends Service implements IResetProcess, a, m {
    private t cWB;
    private e cWC = new e();
    private boolean cWD = true;
    private final b cWE = new 1(this);
    private int cWF = -1;
    private long cWG = 0;
    private long cWH = 0;
    private long cWI = 0;
    private WakerLock cWJ = null;
    private com.tencent.mm.platformtools.t cWK = new com.tencent.mm.platformtools.t();
    private al cWL = new al(new 4(this), false);

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String string;
        String string2;
        String str;
        NetworkInfo networkInfo = null;
        x.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 24 && !h.Ae()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                x.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        ag agVar = new ag(Looper.getMainLooper());
        Mars.init(ad.getContext(), agVar);
        StnLogic.setCallBack(new af());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.CM();
        com.tencent.mm.sdk.b.a.sFg.b(new 2(this));
        aa.UT();
        ab.a(this.cWE);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        aa.setHandler(agVar);
        aa.setContext(getApplicationContext());
        aa.a(new com.tencent.mm.network.ab());
        aa.a(new ac());
        aa.a(this);
        aa.a(new w());
        this.cWB = aa.UZ();
        if (this.cWB == null) {
            x.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.cWB = new t(aa.UX());
            aa.b(this.cWB);
        } else {
            x.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.cWB.reset();
        }
        Mars.onCreate(true);
        if (aa.Va() == null) {
            x.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            aa.a(new z());
        } else {
            x.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            aa.Va().reset();
        }
        if (aa.Vb() == null) {
            x.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            aa.a(new y());
            aa.Vb().etf = this;
            if (aa.Ve()) {
                aa.cb(false);
                aa.UX().post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.CoreService", "NetNotifyAdapter NeedNotifyGCM after init");
                        aa.Vb().onPush(2147480001, new byte[0]);
                    }

                    public final String toString() {
                        return "NotifyGCM";
                    }
                });
            }
        }
        c cVar = ((com.tencent.mm.kernel.b.h) g.Ef().DM()).cXF;
        if (cVar != null) {
            this.cWB.d(cVar.getString(".com.tencent.mm.debug.server.host.http"), cVar.getString(".com.tencent.mm.debug.server.ports.http"), cVar.getString(".com.tencent.mm.debug.server.host.socket"), cVar.getString(".com.tencent.mm.debug.server.ports.socket"));
            string = cVar.getString(".com.tencent.mm.debug.server.wallet.host");
            string2 = cVar.getString(".com.tencent.mm.debug.server.wallet.ip");
            t tVar = this.cWB;
            if (!(bi.oW(string) || bi.G(new String[0]))) {
                new 12(tVar, string, string2).a(tVar.handler);
            }
        }
        if (cVar == null) {
            string = networkInfo;
        } else {
            string = cVar.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (string == null || !string.contains(":")) {
            Object str2 = networkInfo;
        } else {
            String[] split = string.split(":");
            string = split[0];
            str2 = split[1];
        }
        this.cWB.setNewDnsDebugHost(string, str2);
        AlarmReceiver.bn(getApplicationContext());
        AlarmReceiver.bm(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
            x.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[]{e.getMessage()});
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            string = "MicroMsg.CoreService";
            string2 = "networkInfo.state: %s";
            Object[] objArr = new Object[1];
            objArr[0] = networkInfo == null ? "null" : networkInfo.getState();
            x.e(string, string2, objArr);
            aa.UV().ety = false;
            aa.UW().iO(0);
        } else {
            aa.UV().ety = true;
            aa.UW().iO(6);
        }
        ((PluginZero) g.n(PluginZero.class)).qxJ.a(this);
        x.i("MicroMsg.CoreService", "CoreService OnCreate ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int myPid = Process.myPid();
        x.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[]{Integer.valueOf(this.cWF), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2)});
        if (myPid != this.cWF) {
            this.cWF = myPid;
            f.mDy.a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                f.mDy.a(99, 140, 1, false);
            }
        }
        return 1;
    }

    public void onDestroy() {
        x.d("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        ((PluginZero) g.n(PluginZero.class)).qxJ.b(this);
        com.tencent.mm.jni.a.a.CN();
        super.onDestroy();
        xx();
    }

    public boolean onUnbind(Intent intent) {
        x.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        aa.UV().etx = null;
        aa.Vd().esY = null;
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        x.d("MicroMsg.CoreService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.cWB;
    }

    public void onRebind(Intent intent) {
        x.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }

    public final boolean e(int i, byte[] bArr) {
        if (k.bA(this)) {
            x.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = aa.US().getBoolean("is_in_notify_mode", false);
        boolean bC = bi.bC(this.cWB.esl.DE());
        boolean UG = aa.UZ().UG();
        if (!(!z || bC || UG)) {
            if (f.a(2, i2, bArr, this.cWB.esl.DE(), bi.VF())) {
                x.i("MicroMsg.CoreService", "deal with notify sync in push");
                return true;
            }
        }
        x.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isSessionKeyNull:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[]{Boolean.valueOf(bC), Boolean.valueOf(UG), Boolean.valueOf(z)});
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.cWB.esl.Df());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", bi.VF());
        intent.putExtra("notify_skey", this.cWB.esl.DE());
        x.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            x.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", new Object[]{Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(bi.i(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length)});
            sendBroadcast(intent);
            com.tencent.mm.af.a.hD(i2);
        } catch (Throwable th) {
            x.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[]{bi.i(th)});
        }
        return true;
    }

    public final void aP(boolean z) {
        if (z) {
            x.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            aa.UV().ety = true;
            boolean xy = this.cWC.xy();
            if (!this.cWD || xy) {
                if (xy) {
                    aa.UZ().Uy();
                }
                this.cWD = true;
                aa.UW().iO(6);
                if (this.cWJ == null) {
                    this.cWJ = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
                }
                if (!this.cWJ.isLocking()) {
                    this.cWJ.lock(6000, "CoreService.setNetworkAvailable");
                    this.cWG++;
                }
                if (0 == this.cWI) {
                    this.cWH = bi.VF();
                }
                this.cWI++;
                x.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[]{Long.valueOf(this.cWG), Long.valueOf(this.cWI), Long.valueOf(bi.VF() - this.cWH)});
                this.cWL.J(3000, 3000);
                return;
            }
            x.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", new Object[]{Boolean.valueOf(this.cWD)});
            return;
        }
        x.w("MicroMsg.CoreService", "[NETWORK LOST]");
        aa.UV().ety = false;
        aa.UW().iO(0);
        if (this.cWD) {
            aa.UZ().Uy();
            e eVar = this.cWC;
            eVar.cWU = null;
            eVar.cWV = null;
        }
        this.cWD = false;
    }

    public static void xw() {
        Intent intent = new Intent(aa.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", aa.UZ().esl.Df());
        try {
            aa.getContext().sendBroadcast(intent);
        } catch (Exception e) {
            x.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[]{e.toString()});
        }
    }

    private void xx() {
        x.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        aa.Va().d(3, 10000, "");
        Mars.onDestroy();
        try {
            AlarmReceiver.bn(getApplicationContext());
            AlarmReceiver.bl(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
        }
        x.appenderClose();
        Process.killProcess(Process.myPid());
    }

    public void restartProcess() {
        x.w("MicroMsg.CoreService", "restartProcess");
        xx();
    }
}
