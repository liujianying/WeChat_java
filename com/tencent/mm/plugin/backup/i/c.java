package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

public final class c {
    private static String TAG = "MicroMsg.BackupModelFactory";

    public static d mV(int i) {
        switch (i) {
            case -1:
                return a.asN();
            case 1:
                return b.arV();
            case 2:
                return com.tencent.mm.plugin.backup.c.b.arv();
            default:
                return null;
        }
    }
}
