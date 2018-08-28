package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.x5.sdk.d;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static volatile boolean dpg;
    private static final List<a> fwO = new LinkedList();

    public interface a {
        void aaS();
    }

    public static void initialize() {
        if (!dpg) {
            r.a(ad.getContext(), new 1(), new 2(), new 3());
            if (e.chv()) {
                d.forceSysWebView();
            }
            WebView.initWebviewCore(ad.getContext(), MMWebView.uHn, "support", new 4());
        }
    }

    public static boolean a(a aVar) {
        if (fwO.contains(aVar)) {
            return false;
        }
        if (!dpg) {
            return fwO.add(aVar);
        }
        aVar.aaS();
        return true;
    }
}
