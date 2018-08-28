package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    private b mWm = new b() {
        public final a Z(Context context, String str) {
            return new com.tencent.mm.plugin.shake.ui.a(context);
        }
    };

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.mWm;
    }

    public ar createSubCore() {
        return new m();
    }
}
