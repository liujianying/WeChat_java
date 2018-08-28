package com.tencent.mm.plugin.game.gamewebview.e;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import java.util.ArrayList;
import java.util.List;

public final class c {
    e gcP;
    private List<b> jKW = new ArrayList();
    long jKX;

    public c(d dVar) {
        this.gcP = dVar.getWebViewPermission();
        this.jKX = dVar.getDeepLinkPermission();
        this.jKW.add(new a(this, (byte) 0));
        this.jKW.add(new b(this, (byte) 0));
    }

    public final boolean Dt(String str) {
        for (b bVar : this.jKW) {
            if (bVar.Dt(str)) {
                bVar.Du(str);
                return true;
            }
        }
        return false;
    }
}
