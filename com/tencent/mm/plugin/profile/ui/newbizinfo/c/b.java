package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.mm.ac.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static final String lZq = j.dMg;

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        x.d("MicroMsg.Kv10809", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[]{str, str2, str3, str4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), str5, str6, str7});
        h.mEJ.h(10809, new Object[]{str, str2, str3, str4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), str5, str6, str7});
    }

    public static String dl(int i, int i2) {
        if (i < 0) {
            return "";
        }
        if (i2 < 0) {
            return String.valueOf(i);
        }
        return i + "-" + i2;
    }
}
