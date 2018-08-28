package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;

class Plugin$1 implements b {
    final /* synthetic */ Plugin mbr;

    Plugin$1(Plugin plugin) {
        this.mbr = plugin;
    }

    public final a Z(Context context, String str) {
        if ("widget_type_contact".equals(str)) {
            return new com.tencent.mm.plugin.qmessage.ui.a(context);
        }
        return new com.tencent.mm.plugin.qmessage.ui.b(context);
    }
}
