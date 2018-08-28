package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.a.h;
import com.tencent.mm.a.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.w;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class NotifyReceiver$NotifyService extends Service {
    Boolean cXf = null;
    private g cXg;

    public void onStart(Intent intent, int i) {
        l(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
        l(intent);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void l(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
            return;
        }
        int i;
        if (com.tencent.mm.kernel.g.Ek().dqL.drf) {
            boolean i2 = false;
        } else {
            x.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", new Object[]{Integer.valueOf(0)});
            if (this.cXg != null) {
                com.tencent.mm.kernel.g.Ek().b(this.cXg);
            }
            this.cXg = new 1(this, System.currentTimeMillis(), intent);
            com.tencent.mm.kernel.g.Ek().a(this.cXg);
            f.mDy.a(99, 213, 1, false);
            i2 = -1;
        }
        if (i2 < 0) {
            x.e("MicroMsg.NotifyReceiver", "summerboot status %s", new Object[]{Integer.valueOf(-1)});
            return;
        }
        m(intent);
    }

    private void m(Intent intent) {
        int intExtra = intent.getIntExtra("notify_option_type", 0);
        if (intExtra == 0) {
            x.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
        } else if (!com.tencent.mm.kernel.g.Eg().Dx() || a.Dr()) {
            x.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", new Object[]{Boolean.valueOf(com.tencent.mm.kernel.g.Eg().Dx()), Boolean.valueOf(a.Dr()), Integer.valueOf(intExtra)});
        } else {
            int i;
            if (com.tencent.mm.kernel.g.DF().dJs == null) {
                x.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", new Object[]{Integer.valueOf(intExtra)});
                com.tencent.mm.kernel.g.DF().bA(true);
            }
            if (this.cXf == null) {
                NotifyReceiver$NotifyService notifyReceiver$NotifyService;
                boolean z;
                NotifyReceiver$NotifyService notifyReceiver$NotifyService2;
                if (b.chp()) {
                    notifyReceiver$NotifyService = this;
                } else {
                    i = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("AndroidOldNotifyReceiver"), 0);
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eg();
                    if (i > h.aM(a.Df(), 100)) {
                        z = true;
                        notifyReceiver$NotifyService2 = this;
                        notifyReceiver$NotifyService2.cXf = Boolean.valueOf(z);
                    } else {
                        notifyReceiver$NotifyService = this;
                    }
                }
                z = false;
                notifyReceiver$NotifyService2 = notifyReceiver$NotifyService;
                notifyReceiver$NotifyService2.cXf = Boolean.valueOf(z);
            }
            x.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", new Object[]{this.cXf, Integer.valueOf(intExtra)});
            switch (intExtra) {
                case 1:
                    if (this.cXf.booleanValue()) {
                        w(ad.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
                    }
                    Context context = ad.getContext();
                    x.i("MicroMsg.NotifyReceiver", "dealWithLooper");
                    if (!com.tencent.mm.kernel.g.Eg().Dx() || a.Dr()) {
                        x.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.g.Eg().Dx() + " isHold:" + a.Dr());
                        return;
                    }
                    if (!com.tencent.mm.kernel.g.DF().foreground) {
                        Object obj = (context == null || ao.isWap(context)) ? null : 1;
                        if (obj != null) {
                            com.tencent.mm.kernel.g.DF().a(new j(), 0);
                            return;
                        }
                    }
                    ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().id(2);
                    return;
                case 2:
                    Object byteArrayExtra;
                    Object byteArrayExtra2;
                    long longExtra;
                    String str;
                    String str2;
                    Object[] objArr;
                    int r;
                    int i2;
                    String str3;
                    String str4;
                    Object[] objArr2;
                    Object obj2;
                    w.b bVar;
                    if (this.cXf.booleanValue()) {
                        w(ad.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
                        intExtra = intent.getIntExtra("notify_respType", 0);
                        byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
                        byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
                        longExtra = intent.getLongExtra("notfiy_recv_time", -1);
                        str = "MicroMsg.NotifyReceiver";
                        str2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
                        objArr = new Object[4];
                        objArr[0] = Integer.valueOf(intExtra);
                        objArr[1] = Long.valueOf(longExtra);
                        objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                        objArr[3] = bi.Xf(bi.bE(byteArrayExtra2));
                        x.i(str, str2, objArr);
                        switch (intExtra) {
                            case 39:
                                com.tencent.mm.kernel.g.DF().a(new j(), 0);
                                return;
                            case 138:
                                r = byteArrayExtra == null ? 7 : n.r(byteArrayExtra, 0);
                                i2 = byteArrayExtra == null ? 2 : 1;
                                str3 = "MicroMsg.NotifyReceiver";
                                str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                                objArr2 = new Object[3];
                                objArr2[0] = Integer.valueOf(r);
                                objArr2[1] = Integer.valueOf(i2);
                                objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                                x.d(str3, str4, objArr2);
                                try {
                                    NotifyReceiver.xE().lock();
                                    i = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a((long) r, i2, "");
                                    if (i > 0) {
                                        x.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[]{Integer.valueOf(i)});
                                        NotifyReceiver.xF().add(Long.valueOf((long) i));
                                        x(ad.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                                    }
                                    try {
                                        NotifyReceiver.xE().unlock();
                                        return;
                                    } catch (Exception e) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    try {
                                        NotifyReceiver.xE().unlock();
                                    } catch (Exception e2) {
                                    }
                                    throw th;
                                }
                            case 268369921:
                                if (bi.bC(byteArrayExtra2)) {
                                    x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + byteArrayExtra2);
                                    return;
                                } else if (bi.bC(byteArrayExtra) || byteArrayExtra.length <= 8) {
                                    x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                                    return;
                                } else {
                                    i = n.r(byteArrayExtra, 0);
                                    i2 = n.r(byteArrayExtra, 4);
                                    if (i2 != byteArrayExtra.length - 8) {
                                        x.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                                        return;
                                    }
                                    obj2 = new byte[i2];
                                    System.arraycopy(byteArrayExtra, 8, obj2, 0, i2);
                                    x.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra)});
                                    try {
                                        NotifyReceiver.xE().lock();
                                        l.a(i, obj2, byteArrayExtra2, longExtra);
                                        NotifyReceiver.xF().add(Long.valueOf(longExtra));
                                        x(ad.getContext(), "NotifyReceiver.NotifyData");
                                        try {
                                            NotifyReceiver.xE().unlock();
                                            return;
                                        } catch (Exception e3) {
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        try {
                                            NotifyReceiver.xE().unlock();
                                        } catch (Exception e4) {
                                        }
                                        throw th2;
                                    }
                                }
                            case 1000000205:
                                x.d("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                                bVar = new w.b();
                                try {
                                    bVar.G(byteArrayExtra);
                                    NotifyReceiver.xE().lock();
                                    i = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a(bVar.qXc, 1, bVar.cgq());
                                    if (i > 0) {
                                        x.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[]{Integer.valueOf(i)});
                                        NotifyReceiver.xF().add(Long.valueOf((long) i));
                                        x(ad.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                                    }
                                    try {
                                        NotifyReceiver.xE().unlock();
                                        return;
                                    } catch (Exception e5) {
                                        return;
                                    }
                                } catch (Throwable th22) {
                                    x.printErrStackTrace("MicroMsg.NotifyReceiver", th22, "", new Object[0]);
                                    try {
                                        NotifyReceiver.xE().unlock();
                                        return;
                                    } catch (Exception e6) {
                                        return;
                                    }
                                } catch (Throwable th222) {
                                    try {
                                        NotifyReceiver.xE().unlock();
                                    } catch (Exception e7) {
                                    }
                                    throw th222;
                                }
                            case 2147480001:
                                x.d("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                                i = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a(7, 13, "");
                                try {
                                    NotifyReceiver.xE().lock();
                                    if (i > 0) {
                                        x.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[]{Integer.valueOf(i)});
                                        NotifyReceiver.xF().add(Long.valueOf((long) i));
                                        x(ad.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY");
                                    }
                                    try {
                                        NotifyReceiver.xE().unlock();
                                        return;
                                    } catch (Exception e8) {
                                        return;
                                    }
                                } catch (Throwable th2222) {
                                    try {
                                        NotifyReceiver.xE().unlock();
                                    } catch (Exception e9) {
                                    }
                                    throw th2222;
                                }
                            default:
                                ((PluginZero) com.tencent.mm.kernel.g.n(PluginZero.class)).qxI.a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                                return;
                        }
                    }
                    intExtra = intent.getIntExtra("notify_respType", 0);
                    byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
                    byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
                    longExtra = intent.getLongExtra("notfiy_recv_time", -1);
                    str = "MicroMsg.NotifyReceiver";
                    str2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
                    objArr = new Object[4];
                    objArr[0] = Integer.valueOf(intExtra);
                    objArr[1] = Long.valueOf(longExtra);
                    objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                    objArr[3] = bi.Xf(bi.bE(byteArrayExtra2));
                    x.i(str, str2, objArr);
                    switch (intExtra) {
                        case 39:
                            com.tencent.mm.kernel.g.DF().a(new j(), 0);
                            return;
                        case 138:
                            r = byteArrayExtra == null ? 7 : n.r(byteArrayExtra, 0);
                            i2 = byteArrayExtra == null ? 2 : 1;
                            str3 = "MicroMsg.NotifyReceiver";
                            str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                            objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(r);
                            objArr2[1] = Integer.valueOf(i2);
                            objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                            x.i(str3, str4, objArr2);
                            ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a((long) r, i2, "");
                            return;
                        case 268369921:
                            if (bi.bC(byteArrayExtra2)) {
                                x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + byteArrayExtra2);
                                return;
                            } else if (bi.bC(byteArrayExtra) || byteArrayExtra.length <= 8) {
                                x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                                return;
                            } else {
                                i = n.r(byteArrayExtra, 0);
                                i2 = n.r(byteArrayExtra, 4);
                                if (i2 != byteArrayExtra.length - 8) {
                                    x.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                                    return;
                                }
                                obj2 = new byte[i2];
                                System.arraycopy(byteArrayExtra, 8, obj2, 0, i2);
                                x.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra)});
                                l.a(i, obj2, byteArrayExtra2, longExtra);
                                return;
                            }
                        case 1000000205:
                            x.i("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                            bVar = new w.b();
                            ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a(bVar.qXc, 1, bVar.cgq());
                            return;
                        case 2147480001:
                            x.i("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                            ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a(7, 13, "");
                            return;
                        default:
                            ((PluginZero) com.tencent.mm.kernel.g.n(PluginZero.class)).qxI.a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                            return;
                    }
                default:
                    x.e("MicroMsg.NotifyReceiver", "invald opCode:" + intExtra);
                    return;
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT < 24 && !com.tencent.mm.compatible.util.h.Ae()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1212, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1212, new Notification());
                startService(new Intent(this, InnerService.class));
                x.i("MicroMsg.NotifyReceiver", "set service for mm.");
            }
            new ag().postDelayed(new 2(this), ad.chZ().getLong("mm_stop_service_time", 86400000));
        }
    }

    public static void eB(String str) {
        synchronized (NotifyReceiver.xB()) {
            if (NotifyReceiver.xC() == null) {
                NotifyReceiver.a(new WakerLock(ad.getContext(), "MicroMsg.NotifyReceiver"));
            }
        }
        NotifyReceiver.xC().lock(5000, str);
    }

    private static void w(Context context, String str) {
        synchronized (NotifyReceiver.xB()) {
            if (NotifyReceiver.xC() == null) {
                NotifyReceiver.a(new WakerLock(context, "MicroMsg.NotifyReceiver"));
            }
            NotifyReceiver.xC().lock(14000, str);
        }
    }

    private static void x(Context context, String str) {
        synchronized (NotifyReceiver.access$400()) {
            if (NotifyReceiver.xD() == null) {
                NotifyReceiver.b(new WakerLock(context, "MicroMsg.NotifyReceiver"));
            }
            NotifyReceiver.xD().lock(60000, str);
        }
    }
}
