package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends a<c> {
    private c lHR = new c<qi>() {
        {
            this.sFo = qi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final qi qiVar = (qi) bVar;
            ah.A(new Runnable() {
                public final void run() {
                    qi qiVar = qiVar;
                    c cVar = new c();
                    cVar.id = qiVar.caU.caT;
                    e.this.bK(cVar);
                }
            });
            return false;
        }
    };
    private c lHS = new c<qh>() {
        {
            this.sFo = qh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final qh qhVar = (qh) bVar;
            ah.A(new Runnable() {
                public final void run() {
                    au.HU();
                    com.tencent.mm.model.c.DT().set(589825, Boolean.valueOf(true));
                    qh qhVar = qhVar;
                    c cVar = new c();
                    cVar.id = qhVar.caS.caT;
                    e.this.bJ(cVar);
                }
            });
            return false;
        }
    };

    protected final /* bridge */ /* synthetic */ long bL(Object obj) {
        return ((c) obj).id;
    }

    protected final /* synthetic */ ArrayList bM(Object obj) {
        ArrayList bwV = n.nkD.bwV();
        if (bwV.size() == 0) {
            x.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        return bwV;
    }

    protected final void bko() {
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                x.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[]{componentName.getClassName()});
                if (componentName.getClassName().contains("SnsTimeLineUI")) {
                    x.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
    }

    protected final int getType() {
        return 2;
    }

    protected final void I(ArrayList<Long> arrayList) {
        kv kvVar = new kv();
        kvVar.bVg.bQh = arrayList;
        com.tencent.mm.sdk.b.a.sFg.m(kvVar);
    }

    public final void bkt() {
        com.tencent.mm.sdk.b.a.sFg.b(this.lHS);
    }

    public final void bku() {
        com.tencent.mm.sdk.b.a.sFg.b(this.lHR);
    }

    public final void eh(long j) {
        ah.A(new 3(this, j));
    }

    public final void bkv() {
        com.tencent.mm.sdk.b.a.sFg.c(this.lHS);
    }

    public final void bkw() {
        com.tencent.mm.sdk.b.a.sFg.c(this.lHR);
    }

    protected final String ue(int i) {
        return this.mContext.getString(R.l.notificaiton_notify_fail_sns, new Object[]{Integer.valueOf(i)});
    }

    protected final String dc(int i, int i2) {
        return this.mContext.getString(R.l.notification_resending_sns, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String T(int i, int i2, int i3) {
        return this.mContext.getString(R.l.notification_resending_sns_with_fail, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String dd(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.notification_resend_finish_sns_without_fail, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.notificaiton_resend_finish_sns, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean ei(long j) {
        x.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[]{Long.valueOf(j), Boolean.valueOf(n.nkD.wi((int) j))});
        return n.nkD.wi((int) j);
    }

    protected final void bke() {
        if (au.HX()) {
            au.HU();
            com.tencent.mm.model.c.DT().set(589825, Boolean.valueOf(false));
        }
    }
}
