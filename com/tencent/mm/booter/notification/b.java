package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z.2;
import com.tencent.mm.platformtools.z.AnonymousClass1;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.bbom.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import java.util.List;
import java.util.Map;

public final class b implements al, ao {
    bd bXQ;
    private String cYi;
    private String cYj;
    String cYk;
    Intent cYl;
    private boolean cYm;
    private int cYn;
    private boolean cYo;
    private long cYp;
    f cYq = f$a.cYV;
    private e cYr;
    @SuppressLint({"HandlerLeak"})
    ag cYs = new 1(this, Looper.getMainLooper());
    private final c cYt = new 2(this);
    private final c cYu = new 3(this);
    Context context = null;
    String talker;

    public b(Context context) {
        this.context = context;
        this.talker = "";
        this.cYk = "";
        this.cYi = "";
        this.cYp = 0;
        this.cYo = false;
        this.cYl = null;
        this.cYr = new e();
        r.a(this);
        com.tencent.mm.modelvoice.e.a(this);
        com.tencent.mm.plugin.base.stub.b.a(this);
        a.sFg.b(this.cYu);
        a.sFg.b(this.cYt);
    }

    public final void eJ(String str) {
        this.cYi = str;
    }

    public final String xQ() {
        return this.cYi;
    }

    public final void aR(boolean z) {
        x.i("MicroMsg.MMNotification", "set isMainUI: %s, stack[%s]", new Object[]{Boolean.valueOf(z), bi.cjd()});
        this.cYm = z;
    }

    public final void cancelNotification(String str) {
        Object obj = 1;
        x.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.cYj + "  curChattingTalker:" + this.cYi + " talker count:" + this.cYn);
        if (this.cYo) {
            if (!(this.cYj != null && this.cYj.equals(this.cYi) && this.cYn == 1)) {
                obj = null;
            }
            if (obj != null) {
                cancel();
                return;
            }
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(str);
            if (Yq != null && Yq.field_unReadCount != 0) {
                cancel();
            } else if (t.hX(s.dAN) == 0) {
                cancel();
            }
        }
    }

    public final void xR() {
        try {
            String string = ad.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String WU : string.split(",")) {
                    int WU2 = bi.WU(WU);
                    if (WU2 > 0) {
                        au.getNotification().cancel(WU2);
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMNotification", e, "try cancel notification fail: %s", new Object[]{e.getMessage()});
        }
    }

    public final void vo() {
        x.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
    }

    private void cancel() {
        this.cYo = false;
        e.cancel();
    }

    public final void a(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.field_isSend == 1) {
                x.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[]{Long.valueOf(bdVar.field_msgSvrId)});
                return;
            }
            com.tencent.mm.model.bd.b iF = com.tencent.mm.model.bd.iF(bdVar.cqb);
            if (iF == null || iF.scene != 1) {
                int b = b(bdVar);
                this.bXQ = bdVar;
                this.talker = bdVar.field_talker;
                String str = bdVar.field_content;
                int type = bdVar.getType();
                this.cYk = "";
                this.cYl = null;
                x.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[]{this.talker, Long.valueOf(bdVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b), bi.Xf(str)});
                if (f.a(this.talker, this.bXQ, b, false)) {
                    this.cYs.sendMessageDelayed(b(this.talker, str, type, b, 0), 200);
                } else {
                    x.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                }
            }
        }
    }

    static Message b(String str, String str2, int i, int i2, int i3) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        return obtain;
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void B(List<bd> list) {
        cm cmVar = null;
        if (list == null || list.size() <= 0) {
            int i;
            String str = "MicroMsg.MMNotification";
            String str2 = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            if (list == null) {
                i = -1;
            } else {
                i = list.size();
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        int b;
        int size = list.size() - 1;
        boolean z = false;
        while (size >= 0) {
            bd bdVar = (bd) list.get(size);
            b = b(bdVar);
            if (f.a(bdVar.field_talker, bdVar, b, false)) {
                cmVar = bdVar;
                break;
            } else {
                size--;
                z = b;
            }
        }
        boolean b2 = z;
        if (cmVar == null) {
            x.w("MicroMsg.MMNotification", "notifyOther msg == null");
            return;
        }
        this.cYk = "";
        this.talker = cmVar.field_talker;
        String str3 = cmVar.field_content;
        size = cmVar.getType();
        this.bXQ = cmVar;
        x.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[]{this.talker, Long.valueOf(cmVar.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(b2), bi.Xf(str3)});
        this.cYs.sendMessageDelayed(b(this.talker, str3, size, b2, 0), 200);
    }

    public final void eK(String str) {
        CharSequence str2;
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.putExtra("Intro_Notify_User", this.talker);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        if (!bi.oW(str2) && str2.startsWith("autoauth_errmsg_")) {
            str2 = str2.substring(16);
        }
        if (!bi.oW(str2) && str2.startsWith("<")) {
            Map z = bl.z(str2, "e");
            if (!(z == null || bi.oW((String) z.get(".e.Content")))) {
                str2 = (String) z.get(".e.Content");
            }
        }
        Notification notification = new Builder(this.context).setContentTitle(str2).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, 268435456)).getNotification();
        notification.icon = com.tencent.mm.bf.a.cbg();
        notification.flags = 16;
        a(notification, true);
    }

    public final void fp(int i) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("nofification_type", "update_nofification");
        intent.putExtra("show_update_dialog", true);
        intent.putExtra("update_type", i);
        Notification notification = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.app_update_package_notify)).setContentText(this.context.getString(R.l.app_recommend_update)).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, 0)).getNotification();
        notification.flags |= 16;
        a(34, notification, false);
    }

    @TargetApi(16)
    public final boolean xS() {
        boolean z = true;
        x.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[]{((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName()});
        if (MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
            z = false;
        }
        if (z) {
            Notification build;
            Intent intent = new Intent(this.context, MobileVerifyUI.class);
            intent.addFlags(2);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("nofification_type", "no_reg_notification");
            PendingIntent activity = PendingIntent.getActivity(this.context, 36, intent, 1073741824);
            if (VERSION.SDK_INT >= 16) {
                Builder builder = new Builder(this.context);
                builder.setContentTitle(this.context.getString(R.l.app_pushcontent_title));
                builder.setSmallIcon(com.tencent.mm.bf.a.cbg());
                builder.setWhen(System.currentTimeMillis());
                builder.setContentIntent(activity);
                build = new BigTextStyle(builder).bigText(this.context.getString(R.l.message_mobile_reg_no_verify_code)).build();
                build.defaults |= 1;
                build.flags |= 16;
            } else {
                build = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.app_pushcontent_title)).setContentText(this.context.getString(R.l.message_mobile_reg_no_verify_code)).setContentIntent(activity).getNotification();
                build.icon = com.tencent.mm.bf.a.cbg();
                build.defaults |= 1;
                build.flags |= 16;
            }
            a(36, build, false);
        }
        return z;
    }

    public final void xT() {
        cancel(36);
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        d.a("webview", new AnonymousClass1(str3, str4, bundle, str, str2, i), new 2());
    }

    public final Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6) {
        return f$a.cYV.cYU.cYM.a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, i2, str4, pendingIntent2, i3, str5, pendingIntent3, str6);
    }

    public final void n(int i, String str) {
        f$a.cYV;
        f.n(i, str);
    }

    public final void xU() {
        f$a.cYV;
        c.xU();
    }

    public final void fq(int i) {
        d.ft(i);
    }

    public final void v(String str, int i) {
        d.w(str, i);
    }

    public final void aS(boolean z) {
        d.aT(z);
    }

    public final void fr(int i) {
        f$a.cYV;
        if (i != 0) {
            List<Integer> fu = com.tencent.mm.booter.notification.queue.b.yb().cZb.fu(i);
            if (!fu.isEmpty()) {
                android.support.v4.app.ag L = android.support.v4.app.ag.L(ad.getContext());
                for (Integer intValue : fu) {
                    com.tencent.mm.booter.notification.queue.b.yb().a(L, intValue.intValue());
                }
            }
        }
    }

    public final void notify(int i, Notification notification) {
        a(i, notification, true);
    }

    public final void a(int i, Notification notification, boolean z) {
        f$a.cYV.a(new NotificationItem(i, notification, z));
    }

    public final int a(Notification notification, boolean z) {
        return f$a.cYV.a(new NotificationItem(notification, z));
    }

    public final int b(Notification notification) {
        return a(notification, true);
    }

    public final void cancel(int i) {
        f$a.cYV;
        com.tencent.mm.booter.notification.queue.b.yb().cancel(i);
    }

    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return f$a.cYV.cYU.cYM.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
    }

    public static int b(bd bdVar) {
        int i = 0;
        int i2 = s.hf(bdVar.field_talker) ? 0 : 3;
        if (bdVar.field_bizChatId != -1 && f.eZ(bdVar.field_talker)) {
            com.tencent.mm.ac.a.c ak = z.Na().ak(bdVar.field_bizChatId);
            if (!ak.isGroup() && ak.hu(1)) {
                return i2;
            }
        }
        String str = bdVar.cqb;
        if (bi.oW(str)) {
            return i2;
        }
        Map z = bl.z(str, "msgsource");
        if (z == null || z.isEmpty()) {
            return i2;
        }
        try {
            int i3 = bi.getInt((String) z.get(".msgsource.tips"), i2);
            if ((i3 & 1) != 0 || (i3 & 2) == 0) {
                i = i3;
            }
            return i;
        } catch (Exception e) {
            return i2;
        }
    }
}
