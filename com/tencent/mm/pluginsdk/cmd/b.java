package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b {
    private static final HashMap<String, a> qyq = new HashMap();
    private static final HashMap<String, a> qyr = new HashMap();
    private static final Pattern qys = Pattern.compile(" +");

    public static void a(a aVar, String... strArr) {
        synchronized (qyq) {
            for (Object put : strArr) {
                qyq.put(put, aVar);
                x.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[]{put});
            }
        }
    }

    public static void D(String... strArr) {
        synchronized (qyq) {
            for (Object remove : strArr) {
                qyq.remove(remove);
                x.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[]{remove});
            }
        }
    }

    public static boolean be(Context context, String str) {
        a aVar;
        String[] split = qys.split(str);
        synchronized (qyq) {
            aVar = (a) qyq.get(split[0]);
        }
        if (aVar == null) {
            return false;
        }
        x.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[]{split[0]});
        return aVar.a(context, split);
    }

    static List<a> cbo() {
        List arrayList;
        synchronized (qyr) {
            arrayList = new ArrayList(qyr.values());
        }
        return arrayList;
    }
}
