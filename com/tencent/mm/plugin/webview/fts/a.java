package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final a pNM = new a();
    public Map<Integer, d> pNK = new HashMap();
    private c pNL;

    public static a bTE() {
        return pNM;
    }

    private a() {
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXy = true;
        aVar.dXx = true;
        this.pNL = aVar.Pt();
    }
}
