package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    private b hjL = new b() {
        public final a Z(Context context, String str) {
            return new com.tencent.mm.plugin.nearby.ui.a(context);
        }
    };

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.hjL;
    }

    public ar createSubCore() {
        return new f();
    }
}
