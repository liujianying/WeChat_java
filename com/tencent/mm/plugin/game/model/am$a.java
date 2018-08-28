package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.x;

public class am$a {
    public int eiF;
    public String jOg;

    public am$a(int i, String str) {
        this.eiF = i;
        this.jOg = str;
    }

    public static am$a g(int i, Object... objArr) {
        am$a am_a = new am$a();
        am_a.eiF = i;
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuilder.append(String.valueOf(objArr[i2])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        am_a.jOg = stringBuilder.toString();
        if (l.bPH > 0) {
            x.i("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString()});
        } else {
            x.d("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString()});
        }
        return am_a;
    }
}
