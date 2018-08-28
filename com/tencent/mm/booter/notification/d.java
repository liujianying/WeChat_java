package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static boolean cYA = true;
    private static boolean cYB = true;
    private static boolean cYC = false;
    private static int cYD = -1;
    private static int cYE = -1;
    private static boolean cYF = true;
    private static String cYG = "samsung";
    public static boolean cYH = true;
    public static boolean cYI = false;
    private static int cYJ = -1;
    private static boolean cYK = true;
    private static Uri cYL = Uri.parse("content://com.android.badge/badge");

    public static void ft(int i) {
        boolean z;
        if (ad.getContext() != null && xZ()) {
            Context context = ad.getContext();
            int AQ = i == -1 ? f.AQ() : i;
            if (!(context == null || !xZ() || cYJ == AQ)) {
                cYJ = AQ;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", AQ);
                intent.putExtra("badge_count_package_name", ad.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                x.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[]{Integer.valueOf(AQ), Build.BRAND});
                context.sendBroadcast(intent);
            }
        }
        if (cYF) {
            if (VERSION.SDK_INT < 11) {
                cYF = false;
            } else if (cYE != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", ad.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    cYF = ad.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    x.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(cYF)});
                } catch (Exception e) {
                    x.i("MicroMsg.BusinessNotification", "no huawei badge");
                    x.e("MicroMsg.BusinessNotification", "alvin: no badge" + e.toString());
                    cYF = false;
                }
            }
        }
        if (cYC) {
            z = cYB;
        } else {
            cYC = true;
            if (Build.BRAND.equals("vivo")) {
                cYB = true;
                z = true;
            } else {
                cYB = false;
                z = false;
            }
        }
        if (z && cYD != i) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra("packageName", ad.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                ad.getContext().sendBroadcast(intent2);
                x.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                cYB = false;
                x.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        x(null, i);
    }

    public static void w(String str, int i) {
        if (ai.oW(str)) {
            x.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            return;
        }
        String wM = b.wM(str);
        if (!ai.oW(wM)) {
            x(wM, i);
        }
    }

    public static void aT(boolean z) {
        if (cYK) {
            Context context = ad.getContext();
            if (context != null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    try {
                        x.i("MicroMsg.BusinessNotification", "sync all user badge");
                        Bundle call = contentResolver.call(cYL, "getShortcutList", null, null);
                        if (call == null) {
                            x.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                            return;
                        }
                        String string = call.getString("shortcut_list");
                        if (string != null) {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                                if (!(string == null || string.equalsIgnoreCase("null"))) {
                                    String wL = b.wL(string);
                                    w(wL, z ? 0 : f.fo(wL));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                    }
                }
            }
        }
    }

    public static int a(Notification notification, g gVar) {
        if (notification == null || !cYA) {
            return 0;
        }
        int i;
        if (gVar == null) {
            i = 0;
        } else {
            int i2 = gVar.cZz;
            NotificationQueue notificationQueue = com.tencent.mm.booter.notification.queue.b.yb().cZa;
            if (notificationQueue.cYZ == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.cYZ.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).cYT + i3;
            }
            i = i2 - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            x.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[]{Integer.valueOf(i)});
            return i;
        } catch (NoSuchFieldException e) {
            cYA = false;
            return i;
        } catch (IllegalArgumentException e2) {
            cYA = false;
            return i;
        } catch (IllegalAccessException e3) {
            cYA = false;
            return i;
        } catch (ClassNotFoundException e4) {
            cYA = false;
            return i;
        } catch (InstantiationException e5) {
            cYA = false;
            return i;
        } catch (Exception e6) {
            cYA = false;
            return i;
        }
    }

    private static boolean xZ() {
        if (cYI) {
            return cYH;
        }
        cYI = true;
        if (Build.BRAND.equals(cYG)) {
            cYH = true;
            return true;
        }
        cYH = false;
        return false;
    }

    private static void x(String str, int i) {
        if (ad.getContext() == null) {
            x.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            return;
        }
        Context context = ad.getContext();
        if (i < 0) {
            i = f.AQ();
        }
        c(context, str, i);
    }

    private static boolean c(Context context, String str, int i) {
        boolean z = true;
        if (!cYK) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
            } else {
                bundle.putStringArrayList("app_shortcut_custom_id", null);
            }
            bundle.putInt("app_badge_count", i);
            bundle.putString("app_shortcut_class_name", ad.chX() + ".ui.LauncherUI");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null || contentResolver.call(cYL, "setAppBadgeCount", null, bundle) == null) {
                z = false;
            }
            x.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)});
            return z;
        } catch (Exception e) {
            cYK = false;
            x.i("MicroMsg.BusinessNotification", "no support normal badge");
            x.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            return false;
        }
    }
}
