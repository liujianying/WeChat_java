package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;

public abstract class c<T> {
    private final String aQt;
    private T aQu;

    public c(String str) {
        this.aQt = str;
    }

    public final T ak(Context context) {
        if (this.aQu == null) {
            w.ah(context);
            Context ah = e.ah(context);
            if (ah == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.aQu = e((IBinder) ah.getClassLoader().loadClass(this.aQt).newInstance());
            } catch (Throwable e) {
                throw new a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new a("Could not access creator.", e22);
            }
        }
        return this.aQu;
    }

    public abstract T e(IBinder iBinder);
}
