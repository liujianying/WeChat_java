package com.tencent.mm.plugin.z;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static String bfF() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gp()).append("msgsynchronize/syncFile/").toString();
    }

    public static String bfG() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gp()).append("msgsynchronize/").toString();
    }

    public static String bfH() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gp()).append("msgsynchronize.zip").toString();
    }

    public static void e(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            x.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[]{str, str2});
            return;
        }
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                long ws = g.ws(str + str2);
                i = e.b(str, str2, bArr);
                long ws2 = g.ws(str + str2);
                if (i != 0 || ws2 < ((long) bArr.length)) {
                    x.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ws), Long.valueOf(ws2), Integer.valueOf(bArr.length)});
                    i = i2;
                } else {
                    x.d("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ws), Long.valueOf(ws2), Integer.valueOf(bArr.length)});
                    return;
                }
            }
            return;
        }
    }
}
