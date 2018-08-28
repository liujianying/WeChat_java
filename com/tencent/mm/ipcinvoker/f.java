package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.h.b;

public class f {
    public static <T extends a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String str, InputType inputType, Class<T> cls, c<ResultType> cVar) {
        if (str != null && str.length() != 0) {
            return k.h(new 1(str, cls, inputType, cVar));
        }
        b.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
        return false;
    }

    public static <T extends i<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String str, InputType inputType, Class<T> cls) {
        if (str == null || str.length() == 0) {
            b.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
            return null;
        } else if (e.fC(str)) {
            Object av = ((i) j.a(cls, i.class)).av(inputType);
            if (av == null) {
                return null;
            }
            return (Parcelable) av;
        } else {
            a fA = b.Cq().fA(str);
            if (fA == null) {
                b.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[]{str});
                return null;
            }
            try {
                Bundle d = fA.d(a(inputType), cls.getName());
                if (d == null) {
                    return null;
                }
                d.setClassLoader(f.class.getClassLoader());
                return d.getParcelable("__remote_task_result_data");
            } catch (RemoteException e) {
                b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[]{e});
                return null;
            }
        }
    }

    private static Bundle a(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        return bundle;
    }
}
