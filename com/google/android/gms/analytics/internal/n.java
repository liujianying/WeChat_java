package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public class n {
    public final q aFn;

    public n(q qVar) {
        w.ah(qVar);
        this.aFn = qVar;
    }

    protected static String a(String str, Object obj, Object obj2, Object obj3) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        Object ac = ac(obj);
        Object ac2 = ac(obj2);
        Object ac3 = ac(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
            str3 = ": ";
        }
        if (!TextUtils.isEmpty(ac)) {
            stringBuilder.append(str3);
            stringBuilder.append(ac);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(ac2)) {
            stringBuilder.append(str3);
            stringBuilder.append(ac2);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(ac3)) {
            stringBuilder.append(str3);
            stringBuilder.append(ac3);
        }
        return stringBuilder.toString();
    }

    private static String ac(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    protected static void nl() {
        if (f.aNr) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    public static boolean no() {
        return Log.isLoggable((String) aj.aHt.get(), 2);
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        f fVar = null;
        if (this.aFn != null) {
            fVar = this.aFn.aFW;
        }
        if (fVar != null) {
            fVar.a(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) aj.aHt.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, a(str, obj, obj2, obj3));
        }
    }

    public final void a(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public final void aO(String str) {
        a(2, str, null, null, null);
    }

    public final void aP(String str) {
        a(3, str, null, null, null);
    }

    public final void aQ(String str) {
        a(4, str, null, null, null);
    }

    public final void aR(String str) {
        a(5, str, null, null, null);
    }

    public final void aS(String str) {
        a(6, str, null, null, null);
    }

    public final void b(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final void d(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void d(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public final void e(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void f(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void g(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    protected final ag nm() {
        q qVar = this.aFn;
        q.a(qVar.aFZ);
        return qVar.aFZ;
    }

    protected final i nn() {
        q qVar = this.aFn;
        q.a(qVar.aGb);
        return qVar.aGb;
    }
}
