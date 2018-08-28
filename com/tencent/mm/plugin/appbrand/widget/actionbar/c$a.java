package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.g;

public class c$a {
    public static c c(Context context, g gVar) {
        if (gVar.aap()) {
            return new a(context);
        }
        return new b(context, false);
    }
}
