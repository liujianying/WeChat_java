package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$1 implements b {
    final /* synthetic */ Plugin mnn;

    Plugin$1(Plugin plugin) {
        this.mnn = plugin;
    }

    public final a Z(Context context, String str) {
        x.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[]{str});
        if ("widget_type_news".equals(str)) {
            return new com.tencent.mm.plugin.readerapp.ui.b(context);
        }
        return null;
    }
}
