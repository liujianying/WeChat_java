package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Class<?>> uWQ = new HashMap();
    private static SparseArray<c> uWR = new SparseArray();

    public static void i(String str, Class<?> cls) {
        if (uWQ.containsKey(str)) {
            throw new IllegalArgumentException("register process fail, exist process=" + str);
        }
        uWQ.put(str, cls);
    }

    private static String al(Bundle bundle) {
        return bundle == null ? "" : bundle.toString();
    }

    public static void remove(int i) {
        uWR.remove(i);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle) {
        a(activity, (Class) cls, bundle, null);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar) {
        x.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[]{activity, cls.getSimpleName(), al(bundle)});
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
                return;
            }
        }
        if (bundle.getLong("key_SessionId", 0) == 0) {
            bundle.putLong("key_SessionId", System.currentTimeMillis());
        }
        c cVar = (c) cls.newInstance();
        cVar.am(bundle);
        cVar.a(aVar);
        cVar.a(activity, bundle);
        uWR.put(cls.hashCode(), cVar);
    }

    public static void b(Activity activity, String str, Bundle bundle) {
        a(activity, str, bundle, null);
    }

    public static void a(Activity activity, String str, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar) {
        try {
            x.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[]{activity, str, al(bundle)});
            Class cls = (Class) uWQ.get(str);
            if (cls == null) {
                CharSequence format = String.format("start process=%s fail, process not register or plugin no import", new Object[]{str});
                x.e("MicroMsg.ProcessManager", format);
                s.makeText(activity, format, 1).show();
                return;
            }
            a(activity, cls, bundle, aVar);
        } catch (Throwable e) {
            x.e("MicroMsg.ProcessManager", "plugin load failed : " + e.toString());
            x.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
        }
    }

    public static void j(Activity activity, Bundle bundle) {
        c af = af(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "forwardProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = al(bundle);
        objArr[2] = af == null ? "" : af.aNK();
        x.i(str, str2, objArr);
        if (af != null) {
            af.a(activity, 0, bundle);
        }
    }

    public static void ac(Activity activity) {
        c af = af(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s procname %s";
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = af == null ? "" : af.aNK();
        x.i(str, str2, objArr);
        if (af != null) {
            af.c(activity, 0);
        }
    }

    public static void m(Activity activity, int i) {
        if (activity == null) {
            x.w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        c af = af(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s errCode %s procname %s ";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = af == null ? "" : af.aNK();
        x.i(str, str2, objArr);
        if (af != null) {
            af.c(activity, i);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static void c(Activity activity, Bundle bundle, int i) {
        x.i("MicroMsg.ProcessManager", "endProcess with errCode : " + i);
        if (activity == null) {
            x.w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        c af = af(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "endProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = al(bundle);
        objArr[2] = af == null ? "" : af.aNK();
        x.i(str, str2, objArr);
        if (af != null) {
            af.b(activity, bundle);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static boolean ad(Activity activity) {
        return af(activity) != null;
    }

    public static Bundle ae(Activity activity) {
        c af = af(activity);
        if (af != null) {
            return af.jfZ;
        }
        return new Bundle();
    }

    public static boolean k(Activity activity, Bundle bundle) {
        c af = af(activity);
        if (af == null) {
            return false;
        }
        af.am(bundle);
        return true;
    }

    public static c af(Activity activity) {
        if (activity == null) {
            x.w("MicroMsg.ProcessManager", "hy: ac is null");
            return null;
        } else if (activity.getIntent() != null) {
            return (c) uWR.get(activity.getIntent().getIntExtra("process_id", 0));
        } else {
            x.w("MicroMsg.ProcessManager", "hy: get intent is null");
            return null;
        }
    }
}
