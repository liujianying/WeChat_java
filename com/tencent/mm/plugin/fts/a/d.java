package com.tencent.mm.plugin.fts.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static final HashMap<String, String> jqH = new HashMap();
    private static String[] jqI = new String[]{"wxid_", "wx_", "gh_"};

    public static String Ct(String str) {
        if (s.fq(str)) {
            return str;
        }
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            return str;
        }
        if (!bi.oW(Yg.field_conRemarkPYFull)) {
            return Yg.field_conRemarkPYFull;
        }
        if (!bi.oW(Yg.wQ())) {
            return Yg.wQ();
        }
        if (bi.oW(Yg.wM())) {
            return str;
        }
        return Yg.wM();
    }

    public static final HashMap<String, String> aPY() {
        HashMap<String, String> hashMap = new HashMap();
        for (Entry entry : jqH.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public static final void bj(List<l> list) {
        jqH.clear();
        for (l lVar : list) {
            if (lVar.userData instanceof String) {
                jqH.put(lVar.jrv, (String) lVar.userData);
            } else {
                jqH.put(lVar.jrv, "");
            }
        }
    }

    public static String l(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static final String u(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str : strArr) {
            Object obj;
            stringBuilder.append("\"");
            stringBuilder.append(str);
            char charAt = str.charAt(str.length() - 1);
            int obj2;
            if (charAt >= '0' && charAt <= '9') {
                obj2 = 1;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                obj2 = 1;
            } else if (charAt < 'a' || charAt > 'z') {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                stringBuilder.append("\"* ");
            } else {
                stringBuilder.append("\" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static int c(int[] iArr, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        int i4 = i >= iArr.length ? Integer.MAX_VALUE : iArr[i];
        if (i2 < iArr.length) {
            i3 = iArr[i2];
        }
        return i4 - i3;
    }

    public static int a(Map<Integer, Integer> map, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        Integer num = (Integer) map.get(Integer.valueOf(i));
        int intValue = num == null ? Integer.MAX_VALUE : num.intValue();
        num = (Integer) map.get(Integer.valueOf(i2));
        if (num != null) {
            i3 = num.intValue();
        }
        return intValue - i3;
    }

    public static List<l> a(List<l> list, Map<Integer, Integer> map) {
        int i;
        int i2;
        1 1 = new 1(map);
        l lVar = new l();
        lVar.type = 131073;
        int binarySearch = Collections.binarySearch(list, lVar, 1);
        lVar.type = 131074;
        int binarySearch2 = Collections.binarySearch(list, lVar, 1);
        if (binarySearch < 0) {
            i = (-binarySearch) - 1;
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((l) list.get(i2)).type != 131073) {
                    i = i2 + 1;
                } else {
                    binarySearch = i2;
                }
            }
            i = i2 + 1;
        }
        if (binarySearch2 < 0) {
            binarySearch = (-binarySearch2) - 1;
        } else {
            int size = list.size();
            i2 = binarySearch2 + 1;
            while (i2 < size && ((l) list.get(i2)).type == 131074) {
                i2++;
            }
            binarySearch = i2;
        }
        return list.subList(i, binarySearch);
    }

    public static final String Cu(String str) {
        if (str == null) {
            return null;
        }
        return g.Cz(((a) g.l(a.class)).cp(str.trim(), " "));
    }

    public static final String Cv(String str) {
        return g.Cz(str.toLowerCase());
    }

    public static final String Cw(String str) {
        if (str != null) {
            return str.replace('*', ' ').trim();
        }
        return null;
    }

    public static String cS(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String startsWith : jqI) {
            if (str.startsWith(startsWith)) {
                return null;
            }
        }
        if (str.indexOf(64) >= 0) {
            return null;
        }
        return str;
    }

    public static String av(String str, boolean z) {
        if (str == null) {
            return null;
        }
        String toLowerCase = Cu(str).toLowerCase();
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < toLowerCase.length(); i2++) {
            char charAt = toLowerCase.charAt(i2);
            if (g.i(charAt)) {
                String[] strArr = (String[]) g.jrm.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 1) {
                    arrayList.add(" ");
                } else {
                    List arrayList2 = new ArrayList();
                    for (i = 0; i < strArr.length; i++) {
                        Object substring;
                        if (z) {
                            substring = strArr[i].substring(0, 1);
                        } else {
                            substring = strArr[i];
                        }
                        if (!arrayList2.contains(substring)) {
                            arrayList2.add(substring);
                        }
                    }
                    arrayList.add(bi.c(arrayList2, "‏"));
                    i = 1;
                }
            } else {
                arrayList.add(" ");
            }
        }
        return i != 0 ? bi.c(arrayList, "‍") : null;
    }

    public static String v(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('(');
        for (String sqlEscapeString : strArr) {
            stringBuilder.append(DatabaseUtils.sqlEscapeString(sqlEscapeString) + ',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static boolean f(int[] iArr, int i) {
        return Arrays.binarySearch(iArr, i) >= 0;
    }

    public static boolean Cx(String str) {
        if (str != null && str.length() < 20 && str.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean Cy(String str) {
        if (str != null && str.length() < 20 && str.matches("^[A-Za-z0-9\\-_]+$")) {
            return true;
        }
        return false;
    }

    public static boolean b(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean u(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.setTimeInMillis(j2);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        if (timeInMillis == instance.getTimeInMillis()) {
            return true;
        }
        return false;
    }

    public static String Bc(String str) {
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            return str;
        }
        if (!bi.oW(Yg.field_conRemark)) {
            return Yg.field_conRemark;
        }
        if (!bi.oW(Yg.field_nickname)) {
            return Yg.field_nickname;
        }
        if (s.fq(Yg.field_username)) {
            str = ((b) g.l(b.class)).Ga().gT(str);
            if (!bi.oW(str)) {
                return str;
            }
        }
        return Yg.field_username;
    }

    public static void b(Context context, String str, Intent intent) {
        try {
            String str2 = ad.chX() + ".plugin.fts";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(ad.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[]{e});
        }
    }

    public static void b(Context context, String str, Intent intent, Bundle bundle) {
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                x.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[]{e});
                return;
            }
        }
        String str2 = ad.chX() + ".plugin.fts";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(ad.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
    }
}
