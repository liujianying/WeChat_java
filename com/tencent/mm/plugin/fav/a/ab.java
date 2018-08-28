package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.y.g;

public interface ab extends a {
    int Bu(String str);

    int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3);

    int a(g.a aVar, WXMediaMessage wXMediaMessage, String str);

    void a(Activity activity, int i, int i2, Intent intent, int i3, int i4);

    void a(Activity activity, String str, String str2);

    void a(Context context, String str, g gVar, int i, boolean z, q.a aVar);
}
