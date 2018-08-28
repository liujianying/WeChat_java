package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a {
    private static com.tencent.mm.u.c.e.a fvG = new 1();

    public static void a(String str, ArrayList<LogInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putParcelableArrayList("logList", arrayList);
        c.Cy().c(b.gQn.getClass().getName(), bundle);
    }

    public static com.tencent.mm.u.c.e.a afi() {
        return fvG;
    }
}
