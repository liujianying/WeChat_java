package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.d.a;
import com.tencent.mm.booter.d.c;
import com.tencent.mm.compatible.d.a$a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.l.1;
import com.tencent.mm.model.l.2;
import com.tencent.mm.model.l.3;
import com.tencent.mm.model.l.4;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.d;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class PluginBigBallOfMud extends f implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private e mProfileCompat;

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void installed() {
    }

    public void dependency() {
        dependsOn(b.class);
        dependsOn(o.class);
    }

    public void configure(g gVar) {
        String str;
        e eVar;
        d.a(new 1(this));
        MMReceivers$ToolsProcessReceiver.a(new c());
        SandBoxProcessReceiver.a(new com.tencent.mm.booter.d.b());
        ExdeviceProcessReceiver.a(new a());
        com.tencent.mm.plugin.zero.a.d dVar = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.zero.a.d.class);
        dVar.setILightPushDelegate(new j());
        dVar.addNotifyReceiverCallback(new o());
        dVar.addICoreServiceLifecycleCallback(new g());
        x.i(TAG, "zero %s", new Object[]{dVar});
        this.app = gVar.dsQ;
        com.tencent.mm.modelstat.d.c(this.app);
        x.i(TAG, "app.getResources() is:" + gVar.dsQ.getResources());
        ad.a(com.tencent.mm.bq.a.a(gVar.dsQ.getResources(), gVar.dsQ));
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.compatible.loader.f fVar = new com.tencent.mm.compatible.loader.f();
        Application application = this.app;
        String str2 = gVar.dox;
        if (str2 == null || str2.length() <= 0) {
            HandlerThread Xs = com.tencent.mm.sdk.f.e.Xs("ProfileFactoryImp_handlerThread");
            Xs.start();
            str2 = (String) new f$1(fVar).a(new ag(Xs.getLooper()));
            Xs.getLooper().quit();
            str = str2;
        } else {
            str = str2;
        }
        if (str == null) {
            x.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            eVar = null;
        } else {
            ad.bZ(str);
            if (str.equals(ad.getPackageName())) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.WorkerProfile");
            } else if (str.equals(ad.getPackageName() + ":push")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.PusherProfile");
            } else if (str.equals(ad.getPackageName() + ":tools")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.ToolsProfile");
            } else if (str.equals(ad.getPackageName() + ":sandbox")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.SandBoxProfile");
            } else if (str.equals(ad.getPackageName() + ":exdevice")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.ExDeviceProfile");
            } else if (str.equals(ad.getPackageName() + ":TMAssistantDownloadSDKService")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.TMAssistantProfile");
            } else if (str.equals(ad.getPackageName() + ":nospace")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.NoSpaceProfile");
            } else if (str.equals(ad.getPackageName() + ":patch")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.PatchProfile");
            } else if (str.startsWith(ad.getPackageName() + ":appbrand")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.AppBrandProfile");
            } else if (str.startsWith(ad.getPackageName() + ":support")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.SupportProfile");
            } else {
                com.tencent.mm.sdk.a.b.A("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                eVar = null;
            }
            x.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[]{str});
        }
        this.mProfileCompat = eVar;
        if (!(this.mProfileCompat == null || gVar.ES())) {
            x.i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        x.i(TAG, "after profile oncreate.");
        com.tencent.mm.app.d.aT(this.app.getApplicationContext());
        com.tencent.mm.booter.c bj = com.tencent.mm.booter.c.bj(this.app);
        if (!(bj == null || bj.cWO == -1)) {
            com.tencent.mm.sdk.platformtools.e.bxk = bj.cWO;
        }
        ((h) gVar).mProfileCompat = this.mProfileCompat;
        int i = 0;
        SharedPreferences sharedPreferences = gVar.dsQ.getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        }
        x.i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[]{gVar.dox, Long.valueOf(bi.bH(com.tencent.mm.app.b.bya)), Long.valueOf(bi.bH(currentTimeMillis)), Integer.valueOf(i), aa.duN, com.tencent.mm.compatible.util.e.bnC});
        com.tencent.mm.j.a.a.a(new 7(this));
        com.tencent.mm.compatible.d.a.a(new a$a() {
            public final void aL(long j) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(853, j, 1, false);
            }
        });
        if (gVar.ES()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            k.b("hardcoder", getClass().getClassLoader());
            HardCoderJNI.initReporter(new com.tencent.mm.hardcoder.e());
            currentTimeMillis = SystemClock.elapsedRealtime();
            x.i(TAG, "summerhardcoder initHardCoder[%d %d %d %d] take[%d]ms", new Object[]{Long.valueOf(com.tencent.mm.kernel.a.a.drq), Long.valueOf(com.tencent.mm.kernel.a.a.drr), Long.valueOf(elapsedRealtime), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - com.tencent.mm.kernel.a.a.drq)});
            HardCoderJNI.initHardCoder();
            com.tencent.mm.modelfriend.a.dRB = new com.tencent.mm.modelfriend.a.a() {
                public final String Ox() {
                    if (com.tencent.mm.sdk.platformtools.e.sFF) {
                        return ad.getContext().getString(R.l.safe_device_android_device_nm);
                    }
                    return ad.getContext().getString(R.l.safe_device_android_device);
                }
            };
            com.tencent.mm.bt.f.a(new 10(this));
            com.tencent.mm.storage.e.sNP = new com.tencent.mm.plugin.messenger.foundation.a.k() {
                public final String I(bd bdVar) {
                    int i = (bdVar.field_bizChatId == -1 || !com.tencent.mm.ac.f.eZ(bdVar.field_talker)) ? 0 : 1;
                    if (i == 0) {
                        return bdVar.field_talker;
                    }
                    x.d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", new Object[]{bdVar.field_talker + ":" + bdVar.field_bizChatId});
                    return bdVar.field_talker + ":" + bdVar.field_bizChatId;
                }
            };
            t.a(new 12(this));
            com.tencent.mm.plugin.messenger.foundation.a.t.b(new 13(this));
            com.tencent.mm.modelmulti.a aVar = new com.tencent.mm.modelmulti.a();
            q.a.a(69, aVar);
            q.a.a(68, aVar);
            q.a.a(22, aVar);
            q.a.a(13, aVar);
            q.a.a(15, aVar);
            q.a.a(23, aVar);
            q.a.a(25, aVar);
            q.a.a(24, aVar);
            q.a.a(33, aVar);
            q.a.a(35, aVar);
            q.a.a(44, aVar);
            q.a.a(999999, aVar);
            q.a.a(53, aVar);
            q.a.a(TbsListener$ErrorCode.APK_INVALID, aVar);
            c cVar = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(cVar);
            com.tencent.mm.kernel.g.DF().a(681, cVar);
            com.tencent.mm.plugin.messenger.foundation.a.t.a(5, new l());
            com.tencent.mm.plugin.messenger.foundation.a.t.a(1, new s());
            com.tencent.mm.plugin.messenger.foundation.a.t.a(4, new h());
            ((b) com.tencent.mm.kernel.g.n(b.class)).addHandleAuthResponse(new a());
            m mVar = new m();
            ((p) com.tencent.mm.kernel.g.l(p.class)).a(mVar);
            ((p) com.tencent.mm.kernel.g.l(p.class)).a(mVar);
            com.tencent.mm.model.e.a(new b());
            com.tencent.mm.permission.b bVar = new com.tencent.mm.permission.b();
            new q().cht();
            com.tencent.mm.kernel.g.DF().b(138, n.hex);
            com.tencent.mm.kernel.g.DF().b(39, n.hex);
            com.tencent.mm.kernel.g.DF().b(268369922, n.hex);
            if (n.hex == null) {
                n.hex = new n();
            }
            com.tencent.mm.kernel.g.DF().a(138, n.hex);
            com.tencent.mm.kernel.g.DF().a(39, n.hex);
            com.tencent.mm.kernel.g.DF().a(268369922, n.hex);
            p.cF(this.app);
            com.tencent.mm.ap.a.a.a("delchatroommember", new 1());
            com.tencent.mm.ap.a.a.a("NewXmlChatRoomAccessVerifyApplication", new 2());
            com.tencent.mm.ap.a.a.a("NewXmlChatRoomAccessVerifyApproval", new 3());
            com.tencent.mm.ap.a.a.a("chatroommuteexpt", new 4());
            com.tencent.mm.ap.a.a.a("invokeMessage", new com.tencent.mm.ui.chatting.f.b.1());
            MMAppMgr mMAppMgr = this.appMgr;
            Context context = this.app;
            if (mMAppMgr.tnk == null) {
                mMAppMgr.tnk = new Receiver(mMAppMgr);
            }
            MMActivity.cqb();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            intentFilter.addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intentFilter.addAction("MINIQB_OPEN_RET");
            context.registerReceiver(mMAppMgr.tnk, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
            com.tencent.mm.booter.x xVar = new com.tencent.mm.booter.x(com.tencent.mm.booter.c.bj(this.app));
            xVar.ez("MM");
            af.exs = bi.a(xVar.eA(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            af.ewA = bi.a(xVar.eA(".com.tencent.mm.debug.test.display_errcode"), false);
            af.ewB = bi.a(xVar.eA(".com.tencent.mm.debug.test.display_msgstate"), false);
            af.ewC = bi.a(xVar.eA(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            af.ewD = bi.a(xVar.eA(".com.tencent.mm.debug.test.network.force_touch"), false);
            af.ewE = bi.a(xVar.eA(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            af.ewF = bi.a(xVar.eA(".com.tencent.mm.debug.test.crashIsExit"), false);
            af.exe = bi.getInt(bi.aG(xVar.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            af.exf = bi.getInt(bi.aG(xVar.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            af.ewH = bi.a(xVar.eA(".com.tencent.mm.debug.test.album_drop_table"), false);
            af.ewI = bi.a(xVar.eA(".com.tencent.mm.debug.test.album_dle_file"), false);
            af.ewJ = bi.a(xVar.eA(".com.tencent.mm.debug.test.album_show_info"), false);
            af.ewK = bi.a(xVar.eA(".com.tencent.mm.debug.test.location_help"), false);
            af.ewN = bi.a(xVar.eA(".com.tencent.mm.debug.test.force_soso"), false);
            af.ewO = bi.a(xVar.eA(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            af.ewP = bi.a(xVar.eA(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            af.ewQ = bi.a(xVar.eA(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            af.ewT = bi.a(xVar.eA(".com.tencent.mm.debug.test.filterfpnp"), false);
            af.ewU = bi.a(xVar.eA(".com.tencent.mm.debug.test.testForPull"), false);
            int a = bi.a(xVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            af.ewR = a;
            if (a != 4 && af.ewR > 0) {
                z.sOq = af.ewR;
                x.e("MicroMsg.WorkerDebugger", "cdn thread num " + af.ewR);
            }
            af.ewS = bi.a(xVar.eA(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            af.ewV = bi.aG(xVar.getString(".com.tencent.mm.debug.server.host.http"), "");
            af.ewW = bi.aG(xVar.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bi.a(xVar.eA(".com.tencent.mm.debug.test.show_full_version"), false)) {
                com.tencent.mm.sdk.platformtools.e.sFC = true;
            }
            try {
                a = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                com.tencent.mm.protocal.d.CA(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                str = xVar.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!bi.oW(str)) {
                    com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + str;
                    com.tencent.mm.protocal.d.qVJ = "android-" + str;
                    com.tencent.mm.protocal.d.qVL = str;
                    com.tencent.mm.sdk.a.b.VW(str);
                    new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(com.tencent.mm.sdk.a.b.chq());
                }
            } catch (Exception e2) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                currentTimeMillis = Long.decode(xVar.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.qVM).append(" new: ").append(currentTimeMillis);
                com.tencent.mm.protocal.d.qVM = currentTimeMillis;
            } catch (Exception e3) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                xVar.cXF.cWO = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean a2 = bi.a(xVar.eA(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean a3 = bi.a(xVar.eA(".com.tencent.mm.debug.report.kvstat"), false);
                boolean a4 = bi.a(xVar.eA(".com.tencent.mm.debug.report.clientpref"), false);
                boolean a5 = bi.a(xVar.eA(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
                new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
            } catch (Exception e5) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            af.ewZ = bi.a(xVar.eA(".com.tencent.mm.debug.test.update_test"), false);
            af.exa = bi.a(xVar.eA(".com.tencent.mm.debug.test.scan_save_image"), false);
            af.exc = bi.a(xVar.eA(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            af.exd = bi.a(xVar.eA(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            af.exh = bi.aG(xVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
            x.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + af.exh);
            af.exw = bi.aG(xVar.getString(".com.tencent.mm.debug.cdn.front"), "");
            af.exx = bi.aG(xVar.getString(".com.tencent.mm.debug.cdn.zone"), "");
            af.exy = bi.aG(xVar.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
            af.exz = bi.aG(xVar.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
            af.exA = bi.aG(xVar.getString(".com.tencent.mm.debug.cdn.ptl"), "");
            af.exB = bi.a(xVar.eA(".com.tencent.mm.debug.cdn.usestream"), false);
            af.exC = bi.a(xVar.eA(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            af.exD = bi.a(xVar.eA(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            af.exF = bi.a(xVar.eA(".com.tencent.mm.debug.cdn.enable_debug"), false);
            af.exG = bi.a(xVar.eA(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            af.exH = bi.a(xVar.eA(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            af.exN = bi.a(xVar.eA(".com.tencent.mm.debug.bakmove_hardcode"), false);
            x.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + af.exN);
            af.exO = bi.aG(xVar.getString(".com.tencent.mm.debug.bakmove_ip"), "");
            af.exP = bi.getInt(bi.aG(xVar.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
            af.exK = bi.a(xVar.eA(".com.tencent.mm.debug.cursormode_enabled"), true);
            af.eym = bi.a(xVar.eA(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            af.eyn = bi.a(xVar.eA(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            af.eyo = bi.a(xVar.eA(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            af.eya = bi.a(xVar.eA(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            af.eyc = bi.aG(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
            af.eyb = bi.a(xVar.eA(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            af.eyd = bi.aG(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
            af.eyj = bi.a(xVar.eA(".com.tencent.mm.debug.netmock"), false);
            ComponentName fW = bi.fW(ad.getContext());
            if (fW != null && fW.getPackageName().equals(ad.getPackageName()) && fW.getClassName().equals(ad.chW())) {
                WorkerProfile.vt().bzD = true;
                WorkerProfile.vt().bzE = true;
                x.i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[]{fW.getPackageName(), fW.getClassName()});
            } else {
                if (fW != null) {
                    x.i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[]{fW.getPackageName(), fW.getClassName()});
                } else {
                    x.i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(fW == null || fW.getPackageName().equals(ad.getPackageName()))) {
                    WorkerProfile.vt().bzD = true;
                }
            }
            com.tencent.mm.model.d.b.JG();
            com.tencent.mm.model.d.b.setup();
            AppLogic.setCallBack(new AppCallBack(ad.getContext()));
            SmcLogic.setCallBack(new i());
            i.mEZ = (WorkerProfile) this.mProfileCompat;
            k.b(com.tencent.mm.sdk.a.sFa, getClass().getClassLoader());
            BaseEvent.onCreate();
            SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.mDC);
            str = TAG;
            String str3 = "SmcLogic, class loader %s, %s";
            Object[] objArr = new Object[2];
            if (getClass().getClassLoader() == null) {
                i = -1;
            } else {
                i = getClass().getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str, str3, objArr);
            try {
                if (com.tencent.mm.compatible.util.d.fS(20)) {
                    x.i(TAG, "weird");
                    SmcLogic.setUin(0);
                }
            } catch (Throwable th) {
                x.printErrStackTrace(TAG, th, "", new Object[0]);
            }
            o oVar = (o) com.tencent.mm.kernel.g.n(o.class);
            com.tencent.mm.plugin.zero.a.d dVar2 = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.zero.a.d.class);
            new com.tencent.mm.plugin.i.d().after(oVar).before(this);
            new com.tencent.mm.plugin.i.f().after((com.tencent.mm.plugin.i.b) new com.tencent.mm.plugin.i.b().after(oVar).before(this)).before(this);
            new com.tencent.mm.plugin.i.c().after(oVar).before(this);
            new com.tencent.mm.plugin.i.a().after(dVar2);
        }
        m.a(new 14(this));
        com.tencent.mm.y.g.b.a(new 2(this));
        com.tencent.mm.y.g.b.a(new com.tencent.mm.by.c<com.tencent.mm.y.b>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.y.b();
            }
        });
        com.tencent.mm.y.g.b.a(new 4(this));
        com.tencent.mm.y.g.b.a(new com.tencent.mm.by.c<com.tencent.mm.y.a>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.y.a();
            }
        });
        com.tencent.mm.y.g.b.a(new com.tencent.mm.by.c<com.tencent.mm.y.f>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.y.f();
            }
        });
    }

    public void execute(g gVar) {
    }

    public void onTerminate() {
        x.i(TAG, "onTerminate(%s)", new Object[]{ad.getProcessName()});
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Context context = this.app;
        if (mMAppMgr.tnk != null) {
            context.unregisterReceiver(mMAppMgr.tnk);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Resources resources = ad.getResources();
        if (resources instanceof com.tencent.mm.bq.a) {
            ((com.tencent.mm.bq.a) resources).onConfigurationChanged(configuration);
        }
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        x.i(TAG, "onTrimMemory, level = %d, process = %s", new Object[]{Integer.valueOf(i), ad.getProcessName()});
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}
