package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class t {
    private static final List<a> dAW = new ArrayList();

    public static int hX(String str) {
        return b(str, null);
    }

    public static int b(String str, List<String> list) {
        if (g.Eg().Dx()) {
            int i;
            long VG = bi.VG();
            Cursor t = ((i) g.l(i.class)).FW().t(str, list);
            long VG2 = bi.VG();
            if (t == null || t.getCount() <= 0) {
                i = 0;
            } else {
                t.moveToFirst();
                i = t.getInt(0);
            }
            if (t != null) {
                t.close();
            }
            x.d("MicroMsg.ConversationLogic", "unreadcheck unRead getTotalUnread %d", Integer.valueOf(i));
            if (i <= 0) {
                i = 0;
            } else {
                Cursor Yz = ((i) g.l(i.class)).FW().Yz(str);
                if (Yz == null) {
                    x.w("MicroMsg.ConversationLogic", "cursor is null, return");
                    x.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bi.bI(VG2)));
                } else {
                    Yz.moveToFirst();
                    while (!Yz.isAfterLast()) {
                        int i2;
                        ai Yg = ((i) g.l(i.class)).FR().Yg(Yz.getString(0));
                        if (Yg == null || Yg.csI != 0) {
                            i2 = i;
                        } else {
                            i2 = i - Yz.getInt(1);
                            x.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", Yg.field_username, Integer.valueOf(i2));
                        }
                        Yz.moveToNext();
                        i = i2;
                    }
                    x.i("MicroMsg.ConversationLogic", "unreadcheck  result talker count is %d", Integer.valueOf(i));
                    Yz.close();
                    x.i("MicroMsg.ConversationLogic", "unreadcheck get count use %d ms", Long.valueOf(bi.bI(VG2)));
                    i = Math.max(0, i);
                }
            }
            t.close();
            x.i("MicroMsg.ConversationLogic", "get count with black list use %d ms", Long.valueOf(bi.bI(VG)));
            return i;
        }
        x.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        return 0;
    }

    public static int M(String str, String str2) {
        if (g.Eg().Dx()) {
            int i;
            Cursor fZ = ((i) g.l(i.class)).FW().fZ(str, str2);
            if (fZ == null || fZ.getCount() <= 0) {
                i = 0;
            } else {
                fZ.moveToFirst();
                i = fZ.getInt(0);
            }
            if (fZ == null) {
                return i;
            }
            fZ.close();
            return i;
        }
        x.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        return 0;
    }

    public static int hY(String str) {
        if (g.Eg().Dx()) {
            int i;
            long VG = bi.VG();
            Cursor YA = ((i) g.l(i.class)).FW().YA(str);
            if (YA.getCount() > 0) {
                YA.moveToFirst();
                i = YA.getInt(0);
            } else {
                i = 0;
            }
            YA.close();
            if (i <= 0) {
                return 0;
            }
            YA = ((i) g.l(i.class)).FW().Yz(str);
            if (YA == null) {
                x.w("MicroMsg.ConversationLogic", "cursor is null, return");
                x.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bi.bI(VG)));
                return i;
            }
            YA.moveToFirst();
            while (!YA.isAfterLast()) {
                ai Yg = ((i) g.l(i.class)).FR().Yg(YA.getString(0));
                int i2 = (Yg == null || Yg.csI != 0) ? i : i - 1;
                YA.moveToNext();
                i = i2;
            }
            x.i("MicroMsg.ConversationLogic", "result talker count is %d", Integer.valueOf(i));
            YA.close();
            x.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bi.bI(VG)));
            return Math.max(0, i);
        }
        x.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        return 0;
    }

    public static List<String> hZ(String str) {
        List<String> list = null;
        if (g.Eg().Dx()) {
            Cursor YB = ((i) g.l(i.class)).FW().YB(str);
            if (YB.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    x.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", YB.getString(0));
                    arrayList.add(YB.getString(0));
                } while (YB.moveToNext());
                list = arrayList;
            }
            YB.close();
            if (list != null) {
                YB = ((i) g.l(i.class)).FW().Yz(str);
                if (YB != null) {
                    YB.moveToFirst();
                    while (!YB.isAfterLast()) {
                        ai Yg = ((i) g.l(i.class)).FR().Yg(YB.getString(0));
                        if (Yg != null && Yg.csI == 0) {
                            x.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", Yg.BK());
                            list.remove(Yg.BK());
                        }
                        YB.moveToNext();
                    }
                    YB.close();
                }
            }
        } else {
            x.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        return list;
    }

    public static int N(String str, String str2) {
        int i = 0;
        if (bi.oW(str)) {
            return 0;
        }
        if ("notification_messages".equals(str)) {
            return 8;
        }
        if (str2 != null && str2.endsWith("@chatroom")) {
            return 2;
        }
        boolean a;
        PInt pInt = new PInt();
        synchronized (dAW) {
            int i2 = 0;
            boolean z = false;
            while (i2 < dAW.size()) {
                a aVar = (a) dAW.get(i2);
                if (aVar != null) {
                    a = aVar.a(str, str2, pInt);
                    if (a) {
                        i = pInt.value;
                        break;
                    }
                } else {
                    a = z;
                }
                i2++;
                z = a;
            }
            a = z;
        }
        if (a) {
            return i;
        }
        return 1;
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        synchronized (dAW) {
            dAW.add(aVar);
        }
    }
}
