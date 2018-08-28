package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static c sCW = null;
    private static Map<Integer, Boolean> sCX = new HashMap();

    public static void i(int i, Object obj) {
        x.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i + ", class=%s", new Object[]{obj.getClass().getName()});
        sCX.put(Integer.valueOf(i), Boolean.valueOf(true));
        x.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + sCX.size());
    }

    public static void j(int i, Object obj) {
        x.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i + ", class=%s", new Object[]{obj.getClass().getName()});
        sCX.remove(Integer.valueOf(i));
        x.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + sCX.size());
        if (sCX.size() == 0) {
            Process.killProcess(Process.myPid());
            x.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            x.chS();
        }
    }
}
