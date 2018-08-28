package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class b$a {
    public String eEj;
    public Queue<String> orc = new LinkedList();

    b$a(String str) {
        this.eEj = str;
        x.d("MicroMsg.PushMessageExtension", "DoSceneStruct:" + str);
        ArrayList bl = a.bl(ad.getContext(), str);
        if (bl == null || bl.size() <= 0) {
            x.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bl.size()) {
                Map map = ((a) bl.get(i2)).qDL;
                if (map != null) {
                    for (Entry value : map.entrySet()) {
                        this.orc.offer(value.getValue());
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
