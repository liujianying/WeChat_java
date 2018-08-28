package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.g$a;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.y.g.a;

public final class e implements ab {
    public final int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        return l.a(wXMediaMessage, str, str2, str3, 3, null);
    }

    public final int a(a aVar, WXMediaMessage wXMediaMessage, String str) {
        return l.a(aVar, wXMediaMessage, str);
    }

    public final void a(Activity activity, String str, String str2) {
        com.tencent.mm.pluginsdk.ui.tools.a.b(activity, str, str2, 2);
    }

    public final void a(Activity activity, int i, int i2, Intent intent, int i3, int i4) {
        com.tencent.mm.pluginsdk.ui.tools.a.a(activity, i, i2, intent, true, i3, i4, 2);
    }

    public final int Bu(String str) {
        return o.SQ(str);
    }

    public final void a(Context context, String str, g gVar, int i, boolean z, q.a aVar) {
        g$a g_a = new g$a(context);
        g_a.bZ(str);
        d.a(g_a, context, gVar);
        d.b(g_a, context, gVar);
        g_a.g(Boolean.valueOf(z)).BX(i).a(aVar).eIW.show();
    }
}
