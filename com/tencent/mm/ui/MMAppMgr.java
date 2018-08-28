package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.aa.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.z;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.w;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.bag.j;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class MMAppMgr {
    static StringBuffer tni;
    private static long tnj;
    String eTr;
    long egx;
    public Receiver tnk;
    boolean tnl = false;
    boolean tnm = false;
    final al tnn = new al(new 1(this), true);
    private final al tno = new al(Looper.getMainLooper(), new 8(this), false);
    public int vLK = 0;
    boolean vLL = true;
    private final al vLM = new al(Looper.getMainLooper(), new 9(this), true);

    static /* synthetic */ void a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("classname");
        if (bi.oW(stringExtra)) {
            x.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        b.VV(stringExtra);
        if (tni == null) {
            tni = new StringBuffer(HardCoderJNI.sHCQUITCHATTINGTIMEOUT);
            tnj = bi.VE();
            tni.append("start:");
            tni.append(bi.VE());
            tni.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.eTr)) {
                tni.append("desktop:");
                tni.append(bi.bI(mMAppMgr.egx) + 800);
                tni.append("|");
            }
            mMAppMgr.egx = bi.VG();
            mMAppMgr.eTr = stringExtra;
        } else {
            tni.append(mMAppMgr.eTr + ":");
            tni.append(bi.bI(mMAppMgr.egx));
            tni.append("|");
        }
        e eVar = new e();
        eVar.bGf.ahg = z;
        eVar.bGf.className = stringExtra;
        a.sFg.m(eVar);
        x.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
    }

    public final void e(Intent intent, boolean z) {
        String str;
        if (z) {
            p.KB();
            nf nfVar = new nf();
            nfVar.bYj.state = 1;
            a.sFg.m(nfVar);
            d dVar = new d();
            dVar.bGd.bGe = true;
            a.sFg.m(dVar);
            oa oaVar = new oa();
            oaVar.bYW.ahg = true;
            a.sFg.m(oaVar);
            com.tencent.mm.sdk.b.b cqVar = new cq();
            cqVar.bKc.state = 1;
            a.sFg.m(cqVar);
        }
        fv fvVar = new fv();
        fvVar.bOw.bGv = z;
        a.sFg.m(fvVar);
        this.tnl = z;
        String stringExtra = intent.getStringExtra("classname");
        if (bi.oW(stringExtra)) {
            str = "";
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        z zVar;
        if (z) {
            zVar = z.cXH;
            if (zVar.cXS == -1) {
                if (zVar.cXI.Di(3) == 0) {
                    zVar.cXI.setLong(1, ai.VE());
                }
                zVar.cXS = ai.VE();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                objArr[0] = zVar.cXL == null ? "null" : zVar.cXL.cXY;
                objArr[1] = str;
                x.i(str2, str3, objArr);
                if (zVar.cXL != null) {
                    zVar.cXP = ai.VG();
                    if (str != null && str.contains("WebViewUI")) {
                        zVar.cXQ = ai.VG();
                    }
                }
            }
        } else {
            zVar = z.cXH;
            if (zVar.cXS != -1) {
                stringExtra = ((String) zVar.cXI.get(2, "")) + zVar.cXS + "|" + ai.VE() + "#";
                zVar.cXI.set(2, stringExtra);
                int Di = zVar.cXI.Di(3) + 1;
                zVar.cXI.setInt(3, Di);
                x.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(Di), Long.valueOf(zVar.cXS), Long.valueOf(r4));
                zVar.cXS = -1;
                if (ai.bG(zVar.cXI.getLong(1, 0)) > 3600 * ((long) zVar.cXU) || Di > zVar.cXT) {
                    h.mEJ.k(13110, stringExtra);
                    x.i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    zVar.cXI.set(2, "");
                    zVar.cXI.setInt(3, 0);
                }
                if (zVar.cXL != null) {
                    z.a aVar = zVar.cXL;
                    aVar.time += ai.bI(zVar.cXP) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        aVar = zVar.cXL;
                        aVar.cYc = (int) (((long) aVar.cYc) + (ai.bI(zVar.cXQ) / 1000));
                    }
                    x.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(zVar.cXL.time));
                }
            }
        }
        if (g.Eg().Dx()) {
            if ((!bi.oW(j.qcm.qcr.url) ? 1 : null) != null) {
                this.vLK = 0;
                this.vLM.J(100, 20);
            }
        }
        this.tno.J(800, 800);
    }

    public static void cqu() {
        StringBuffer stringBuffer = new StringBuffer(HardCoderJNI.sHCQUITCHATTINGTIMEOUT);
        if (tni == null) {
            tni = stringBuffer;
            tnj = bi.VE();
            return;
        }
        String stringBuffer2 = tni.toString();
        stringBuffer.append(ZR(stringBuffer2));
        tni = stringBuffer;
        x.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        h.mEJ.k(10508, "1," + tnj + "," + stringBuffer2);
        tnj = bi.VE();
    }

    private static String ZR(String str) {
        int i = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i++;
            }
            if (i == 3) {
                break;
            }
            length--;
        }
        return str.substring(length + 1);
    }

    public static void cancelNotification(String str) {
        au.getNotification().cancelNotification(str);
    }

    public static void vo() {
        au.getNotification().vo();
    }

    public static void afu() {
        lE(true);
    }

    public static void lE(boolean z) {
        x.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bi.cjd(), Boolean.valueOf(z));
        com.tencent.mm.plugin.report.b.d.n(2, 0, "");
        if (z) {
            Context context = ad.getContext();
            if (context != null) {
                context.stopService(new Intent(context, CoreService.class));
                context.stopService(new Intent(context, NotifyService.class));
                context.stopService(new Intent(context, CacheService.class));
                context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
            }
        }
        a.sFg.m(new w());
        ja jaVar = new ja();
        jaVar.bSG.status = 0;
        jaVar.bSG.aAk = 2;
        a.sFg.m(jaVar);
        cqu();
        if (z) {
            au.gc(bi.cjd().toString());
            g.Ek().releaseAll();
        }
        x.appenderClose();
        BaseEvent.onSingalCrash(0);
        com.tencent.mrs.a.onDestroy();
        com.tencent.mm.bj.a.e(ad.getContext(), new String[]{"com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4"});
        try {
            com.tencent.xweb.x5.sdk.d.clearAllWebViewCache(ad.getContext(), true);
            x.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
        } catch (Exception e) {
            x.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", e);
        }
        Process.killProcess(Process.myPid());
    }

    public static void bc(Context context) {
        h(context, true);
    }

    public static void h(Context context, boolean z) {
        g.Ek().dqL.drh.aF(z);
        com.tencent.mrs.a.onDestroy();
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        o.vr();
        if (!(au.DF() == null || au.DF().dJs == null)) {
            au.DF().dJs.bE(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static void V(Activity activity) {
        com.tencent.mm.bg.d.b(activity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
    }

    public static void go(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ad.chY(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.l.launcher_name));
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), ad.chX() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.g.icon));
            intent.putExtra("shortcut_icon_resource_id", R.g.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            com.tencent.mm.plugin.base.model.b.o(context, intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
    }

    public static boolean a(final Activity activity, OnClickListener onClickListener) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(ad.chY(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        com.tencent.mm.sdk.platformtools.e.sFD &= z;
        if (z) {
            View inflate = View.inflate(activity, R.i.gprs_alert_dialog_view, null);
            Context context = activity;
            c a = com.tencent.mm.ui.base.h.a(context, false, null, inflate, activity.getString(R.l.confirm_dialog_ok), activity.getString(R.l.main_exit), new 3((CheckBox) inflate.findViewById(R.h.gprs_alert_cb), sharedPreferences, activity, onClickListener), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MMAppMgr.h(activity, true);
                }
            });
            if (a == null) {
                return false;
            }
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    activity.onKeyDown(4, new KeyEvent(0, 4));
                }
            });
        }
        return z;
    }

    public static boolean a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        View inflate = View.inflate(context, R.i.network_tips, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.network_tips_cb);
        checkBox.setText(context.getString(R.l.network_cancel));
        checkBox.setOnCheckedChangeListener(new 6());
        inflate.findViewById(R.h.network_tips_subcontent).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.h.network_tips_content);
        switch (i) {
            case 1:
                textView.setText(R.l.network_bg_process_limited);
                z = true;
                break;
            case 3:
                textView.setText(R.l.network_wifi_limited);
                z = false;
                break;
            default:
                textView.setText(R.l.network_wifi_limited);
                z = true;
                break;
        }
        if (!z) {
            return false;
        }
        c.a aVar = new c.a(context);
        aVar.Gq(R.l.app_tip);
        aVar.mF(false);
        aVar.dR(inflate);
        aVar.Gt(R.l.network_ok).a(onClickListener);
        aVar.Gu(R.l.network_cancel).b(onClickListener2);
        aVar.anj().show();
        return true;
    }

    public static c bd(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (ao.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                return null;
            }
            au.HU();
            Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(4105, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                return null;
            }
            View inflate = View.inflate(context, R.i.lbs_tips_alert, null);
            ((CheckBox) inflate.findViewById(R.h.lbs_tips_alert_cb)).setOnCheckedChangeListener(new 7());
            2 2 = new 2(context);
            c.a aVar = new c.a(context);
            aVar.Gq(R.l.nearby_friend_setting_tips_title);
            aVar.dR(inflate);
            aVar.Gt(R.l.app_set).a(2);
            aVar.Gu(R.l.app_ignore_it);
            c anj = aVar.anj();
            anj.show();
            return anj;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            return null;
        }
    }
}
