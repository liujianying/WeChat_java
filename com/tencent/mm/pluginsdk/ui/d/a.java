package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class a {
    public static ArrayList<m> bm(Context context, String str) {
        ArrayList<m> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPQ.matcher(str);
        while (matcher.find()) {
            m a = a(context, matcher.group(), matcher.start(), matcher.end());
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static m a(Context context, String str, int i, int i2) {
        return a(context, str, i, i2, 0, 0);
    }

    public static m a(Context context, String str, int i, int i2, int i3, int i4) {
        if (context == null) {
            context = ad.getContext();
        }
        m u = com.tencent.mm.pluginsdk.ui.d.b.a.qPF.u(context, str);
        if (u != null) {
            u.start = i;
            u.end = i2;
            u.linkColor = i3;
            u.backgroundColor = i4;
        }
        return u;
    }
}
