package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public e mcd;

    public c(String str) {
        this.mcd = new e(str, 10);
    }

    public final d bU(String str, int i) {
        byte[] readFromFile = e.readFromFile(this.mcd.mcn + bV(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            return null;
        }
        try {
            return (d) new d().aG(readFromFile);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            return null;
        }
    }

    public static String bV(String str, int i) {
        if (str != null && str.length() != 0) {
            return str + "_" + i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(com.tencent.mm.model.c.DT().get(9, null)).toString();
    }
}
