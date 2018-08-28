package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class b$1$1 implements Runnable {
    final /* synthetic */ ArrayList hyi;
    final /* synthetic */ 1 hyj;

    b$1$1(1 1, ArrayList arrayList) {
        this.hyj = 1;
        this.hyi = arrayList;
    }

    public final void run() {
        Map map = (Map) am.axn().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        map.put(this.hyj.hyg, this.hyi);
        am.axn().putValue("key_share_user_info_map", map);
    }
}
