package com.tencent.mm.h;

import com.tencent.mm.g.a.ry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class b$a {
    String cZU = null;
    long cZV = 0;
    String cZW = null;
    Map<Integer, ry> cZX = new HashMap();

    b$a() {
    }

    public final String toString() {
        String str;
        String str2 = "";
        Iterator it = this.cZX.keySet().iterator();
        while (true) {
            str = str2;
            if (!it.hasNext()) {
                break;
            }
            str2 = str + ((Integer) it.next()) + ",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[]{Integer.valueOf(hashCode()), this.cZU, Long.valueOf(this.cZV), this.cZW, str});
    }
}
