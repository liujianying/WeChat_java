package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.c.c;
import com.tencent.matrix.c.c.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c implements InvocationHandler {
    private final Object brc;

    public b(a aVar, Object obj) {
        super(aVar);
        this.brc = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        com.tencent.matrix.d.b.i("Matrix.CloseGuardInvocationHandler", "invoke method: %s", method.getName());
        if (!method.getName().equals("report")) {
            return method.invoke(this.brc, objArr);
        }
        if (objArr.length != 2) {
            com.tencent.matrix.d.b.e("Matrix.CloseGuardInvocationHandler", "closeGuard report should has 2 params, current: %d", Integer.valueOf(objArr.length));
            return null;
        } else if (objArr[1] instanceof Throwable) {
            String throwableStack = com.tencent.matrix.iocanary.c.a.getThrowableStack((Throwable) objArr[1]);
            if (cb(throwableStack)) {
                com.tencent.matrix.d.b.d("Matrix.CloseGuardInvocationHandler", "close leak issue published; key:%s", throwableStack);
            } else {
                com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(4);
                bVar.aAL = throwableStack;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("stack", throwableStack);
                } catch (JSONException e) {
                    com.tencent.matrix.d.b.e("Matrix.CloseGuardInvocationHandler", "json content error: %s", e);
                }
                bVar.brm = jSONObject;
                c(bVar);
                ca(throwableStack);
            }
            return null;
        } else {
            com.tencent.matrix.d.b.e("Matrix.CloseGuardInvocationHandler", "closeGuard report args 1 should be throwable, current: %s", objArr[1]);
            return null;
        }
    }
}
