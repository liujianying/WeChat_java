package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.a.g.b;
import com.tencent.mm.plugin.fts.a.g;
import java.util.ArrayList;
import java.util.List;

public class g$c {
    public List<b> jse = new ArrayList();

    public final String aQb() {
        List arrayList = new ArrayList();
        for (b bVar : this.jse) {
            if (!arrayList.contains(bVar.content)) {
                arrayList.add(bVar.content);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return stringBuilder.toString();
            }
            String str = (String) arrayList.get(i2);
            stringBuilder.append("\"");
            stringBuilder.append(str);
            char charAt = str.charAt(str.length() - 1);
            if (g.j(charAt) || g.k(charAt)) {
                stringBuilder.append("\"*");
            } else {
                stringBuilder.append("\"");
            }
            if (i2 != arrayList.size() - 1) {
                stringBuilder.append(" OR ");
            }
            i = i2 + 1;
        }
    }
}
