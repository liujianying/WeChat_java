package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class a extends b$a {
    private final d iMQ;
    protected RemoteService sCh;
    public b sCi;

    public a(d dVar) {
        this.iMQ = dVar;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        x.d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public Object REMOTE_CALL(String str, Object... objArr) {
        if (this.iMQ.isConnected()) {
            Bundle objectsToBundle = objectsToBundle(objArr);
            this.iMQ.a(this, str, objectsToBundle);
            objectsToBundle.setClassLoader(getClass().getClassLoader());
            return objectsToBundle.get("result_key");
        }
        this.iMQ.K(new 1(this, objArr, str));
        return null;
    }

    public Object CLIENT_CALL(String str, Object... objArr) {
        Bundle objectsToBundle = objectsToBundle(objArr);
        try {
            this.sCi.onCallback(str, objectsToBundle, true);
        } catch (Throwable e) {
            x.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[]{bi.i(e)});
        }
        return objectsToBundle.get("result_key");
    }

    public Bundle objectsToBundle(Object... objArr) {
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        return bundle;
    }

    public Object[] getArgs(Bundle bundle) {
        List linkedList = new LinkedList();
        int size = bundle.size();
        for (int i = 0; i < size; i++) {
            String valueOf = String.valueOf(i);
            if (bundle.containsKey(valueOf)) {
                linkedList.add(bundle.get(valueOf));
            }
        }
        return linkedList.toArray();
    }
}
