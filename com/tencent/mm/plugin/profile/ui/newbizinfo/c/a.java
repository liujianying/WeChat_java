package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a {
    public static int lZn = 0;
    public static int lZo = 1;
    public static int lZp = 2;

    private static void a(String str, int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, int i7, String str2, String str3) {
        x.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str2, str3});
        h.mEJ.h(10298, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str2, str3});
    }

    public static void a(String str, int i, int i2, long j) {
        a(str, i, uP(i2), 1, j, 0, 0, 0, 0, 0, "", "");
    }

    public static void a(String str, int i, int i2, long j, long j2, int i3, int i4, int i5, int i6, String str2, String str3) {
        a(str, i, uP(i2), 2, j, j2, i3, i4, i5, i6, str2, str3);
    }

    public static void a(String str, int i, int i2, long j, int i3, int i4, int i5, int i6, String str2, String str3) {
        a(str, i, uP(i2), 3, j, 0, i3, i4, i5, i6, str2, str3);
    }

    private static int uP(int i) {
        if (i == 0) {
            return lZo;
        }
        if (i == 1) {
            return lZp;
        }
        return lZn;
    }

    public static String bJ(List<b> list) {
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (b bVar : list) {
            stringBuilder.append("[");
            stringBuilder.append(bVar.lZj + "," + bVar.lZk);
            stringBuilder.append("]");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String bK(List<d> list) {
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (d dVar : list) {
            stringBuilder.append("[");
            stringBuilder.append(dVar.id + "," + dVar.aAL);
            stringBuilder.append("]");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
