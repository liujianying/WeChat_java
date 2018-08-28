package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d {
    private static d eiM;
    private a eiK = new a();
    private HashSet<String> eiL = new HashSet();

    static class a implements ActivityLifecycleCallbacks {
        private int eiN;
        private int eiO;
        int eiP;
        int eiQ;

        a() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            d.a(d.RV(), 1, activity);
        }

        public final void onActivityStarted(Activity activity) {
            this.eiP++;
            x.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[]{Integer.valueOf(this.eiP)});
            d.a(d.RV(), 2, activity);
        }

        public final void onActivityResumed(Activity activity) {
            this.eiN++;
            x.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[]{Integer.valueOf(this.eiN)});
            d.a(d.RV(), 3, activity);
        }

        public final void onActivityPaused(Activity activity) {
            this.eiO++;
            x.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[]{Integer.valueOf(this.eiO)});
            d.a(d.RV(), 4, activity);
            f RY = f.RY();
            if (activity != null && (activity instanceof MMActivity)) {
                RY.r(activity.getClass().getName(), ((MMActivity) activity).cql());
                x.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[]{r1, Long.valueOf(r2), Integer.valueOf(RY.ejE.size())});
            }
        }

        public final void onActivityStopped(Activity activity) {
            this.eiQ++;
            x.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[]{Integer.valueOf(this.eiQ)});
            d.a(d.RV(), 5, activity);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            d.a(d.RV(), 6, activity);
        }
    }

    static /* synthetic */ void a(d dVar, int i, Activity activity) {
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        x.v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", new Object[]{Integer.valueOf(i), className, Integer.valueOf(hashCode), Boolean.valueOf(dVar.eiL.contains(className)), bi.cjd()});
        if (!dVar.eiL.contains(className)) {
            b(i, className, hashCode);
        }
    }

    public static void c(Application application) {
        application.registerActivityLifecycleCallbacks(RV().eiK);
    }

    public static boolean RU() {
        a aVar = RV().eiK;
        return aVar.eiP > aVar.eiQ;
    }

    public static void b(int i, String str, int i2) {
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        intent.putExtra("opCode", i);
        intent.putExtra("ui", str);
        intent.putExtra("uiHashCode", i2);
        intent.putExtra("nowMilliSecond", bi.VF());
        intent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
        Context context = ad.getContext();
        if (context == null) {
            return;
        }
        if (ad.cic()) {
            c.RT().q(intent);
            return;
        }
        x.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[]{intent, intent.getExtras()});
        context.sendBroadcast(intent);
    }

    private d() {
        this.eiL.add("com.tencent.mm.ui.LauncherUI");
        this.eiL.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
        this.eiL.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        this.eiL.add("com.tencent.mm.ui.conversation.BizConversationUI");
        this.eiL.add("com.tencent.mm.ui.chatting.ChattingUI");
        this.eiL.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
        this.eiL.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
        this.eiL.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
        this.eiL.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
        this.eiL.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
        this.eiL.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    }

    public static d RV() {
        if (eiM == null) {
            synchronized (d.class) {
                if (eiM == null) {
                    eiM = new d();
                }
            }
        }
        return eiM;
    }

    public static void h(String str, long j, long j2) {
        if (com.tencent.mm.protocal.d.qVQ || com.tencent.mm.protocal.d.qVR || com.tencent.mm.protocal.d.qVP) {
            x.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j2 - j)});
            f.mDy.k(13393, "99999,0,0," + j + "," + j2 + "," + str);
        }
    }
}
