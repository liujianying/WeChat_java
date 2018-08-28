package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.z;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.v;
import com.tencent.mm.k.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    public static String cYw = "com.tencent.preference.notification.key.unread.msg";
    public static String cYx = "com.tencent.preference.notification.key.unread.talker";
    public static String cYy = "com.tencent.preference.notification.key.all.notified.msgid";
    public g bzK = new g(this.mContext);
    Context mContext = ad.getContext();

    public static Notification xV() {
        Notification notification = new Notification();
        notification.icon = R.g.icon;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 300;
        notification.ledOffMS = BaseReportManager.MAX_READ_COUNT;
        return notification;
    }

    public static boolean a(String str, bd bdVar, int i, boolean z) {
        x.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
        if (!au.HX()) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
            return false;
        } else if (bdVar != null && aJ(bdVar.field_msgSvrId) && !z) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[]{Long.valueOf(bdVar.field_msgSvrId)});
            return false;
        } else if ((i & 1) == 0) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
            return false;
        } else {
            au.HU();
            if (com.tencent.mm.model.c.FM() && !q.gT(q.GL())) {
                r4 = new Object[4];
                au.HU();
                r4[2] = Boolean.valueOf(com.tencent.mm.model.c.FM());
                r4[3] = Boolean.valueOf(q.gT(q.GL()));
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", r4);
                return false;
            } else if (s.ha(str)) {
                iv ivVar = new iv();
                ivVar.bSp.bNI = 3;
                a.sFg.m(ivVar);
                if (!ivVar.bSq.bJm) {
                    ivVar = new iv();
                    ivVar.bSp.bNI = 1;
                    ivVar.bSp.bSr = str;
                    ivVar.bSp.bSs = 3;
                    a.sFg.m(ivVar);
                }
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
                return false;
            } else if (!s.hT(str) && (!s.fq(str) || s.hS(str) || bdVar == null || bdVar.YU(q.GF()) || bdVar.getType() == 64 || bdVar == null || bdVar.cmG())) {
                return true;
            } else {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[]{str, Integer.valueOf(i)});
                return false;
            }
        }
    }

    public final int a(NotificationItem notificationItem, g gVar) {
        if (l.fv(this.mContext)) {
            x.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
            if (d.DEBUG || d.duK) {
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.startsWith("com.tencent.mm") && l.a(runningAppProcessInfo) == 3) {
                            l.fu(this.mContext);
                        }
                    }
                }
            }
        } else if (!(VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.pQ == null)) {
            notificationItem.pQ.priority = 1;
            if (!f.Ai()) {
                notificationItem.pQ.vibrate = new long[0];
                if (!(gVar.cZF || gVar.cZE)) {
                    notificationItem.pQ.priority = 0;
                }
            }
        }
        return super.a(notificationItem, gVar);
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
    }

    @TargetApi(21)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i3, String str4, PendingIntent pendingIntent2, int i4, String str5, PendingIntent pendingIntent3, String str6) {
        if (VERSION.SDK_INT < 11) {
            return notification;
        }
        z.d dVar = new z.d(this.mContext);
        if (i == -1) {
            i = com.tencent.mm.bf.a.cbg();
        }
        dVar.pQ.ledARGB = -16711936;
        dVar.pQ.ledOnMS = 300;
        dVar.pQ.ledOffMS = BaseReportManager.MAX_READ_COUNT;
        Object obj = (dVar.pQ.ledOnMS == 0 || dVar.pQ.ledOffMS == 0) ? null : 1;
        dVar.pQ.flags = (obj != null ? 1 : 0) | (dVar.pQ.flags & -2);
        dVar.Y(i).d(str3).pu = pendingIntent;
        dVar.pL = true;
        if (str != null) {
            dVar.b(str);
        }
        if (str2 != null) {
            dVar.c(str2);
        }
        dVar.pQ.defaults = i2;
        if ((i2 & 4) != 0) {
            Notification notification2 = dVar.pQ;
            notification2.flags |= 1;
        }
        if (bitmap != null) {
            dVar.px = bitmap;
        }
        if (notification != null) {
            if (notification.sound != null) {
                dVar.pQ.sound = notification.sound;
                dVar.pQ.audioStreamType = -1;
            }
            if (notification.vibrate != null) {
                dVar.pQ.vibrate = notification.vibrate;
            }
        }
        if (VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                dVar.a(i3, str4, pendingIntent2);
            }
            if (str5 != null) {
                dVar.a(i4, str5, pendingIntent3);
            }
        }
        if (VERSION.SDK_INT >= 21) {
            dVar.pM = "msg";
            v vVar = new v();
            vVar.bHd.username = str6;
            vVar.bHd.title = str;
            a.sFg.m(vVar);
            if (vVar.bHd.bHe != null) {
                vVar.bHd.bHe.a(dVar);
            }
        }
        return dVar.getNotification();
    }

    public static a a(List<a> list, String str) {
        if (list == null || str == null) {
            return null;
        }
        for (a aVar : list) {
            if (aVar.userName.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public static int xW() {
        return f.Ah().getInt(cYw, 0);
    }

    public static ArrayList<a> xX() {
        try {
            ArrayList<a> arrayList = (ArrayList) com.tencent.mm.booter.notification.queue.c.eN(f.Ah().getString(cYx, ""));
            if (arrayList == null) {
                return new ArrayList();
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
            return new ArrayList();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
            return new ArrayList();
        }
    }

    public static void d(ArrayList<a> arrayList) {
        if (arrayList == null) {
            f.Ah().edit().putString(cYx, "").apply();
        } else {
            try {
                f.Ah().edit().putString(cYx, com.tencent.mm.booter.notification.queue.c.a(new ArrayList(arrayList))).apply();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
                f.Ah().edit().putString(cYx, "").apply();
            }
        }
        String str = "MicroMsg.Notification.AppMsg.Handle";
        String str2 = "saveTotalUnreadTalker %s";
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? "null" : arrayList.toString();
        x.i(str, str2, objArr);
    }

    public static void fs(int i) {
        f.Ah().edit().putInt(cYw, Math.max(0, i)).apply();
        x.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[]{Integer.valueOf(r0)});
    }

    public static void aI(long j) {
        if (j != 0) {
            String xY = xY();
            if (xY.length() > 3000) {
                xY = xY.substring(xY.length() / 2, xY.length());
            }
            if (!aJ(j)) {
                f.Ah().edit().putString(cYy, xY + j + "%").apply();
                x.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[]{xY});
            }
        }
    }

    public static boolean aJ(long j) {
        if (j == 0) {
            return false;
        }
        x.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[]{xY(), Long.valueOf(j)});
        if (xY().contains(j + "%")) {
            return true;
        }
        return false;
    }

    private static String xY() {
        return f.Ah().getString(cYy, "");
    }

    public static void xU() {
        f.Ah().edit().putString(cYy, "").apply();
    }
}
