package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine {
    private final Context a;
    private final IX5JsVirtualMachine b;
    private final HashSet<WeakReference<a>> c;

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        this.c = new HashSet();
        this.a = context;
        this.b = X5JsCore.a(context, looper);
    }

    protected final IX5JsContext a() {
        if (this.b != null) {
            return this.b.createJsContext();
        }
        a aVar = new a(this.a);
        this.c.add(new WeakReference(aVar));
        return aVar;
    }

    public final void destroy() {
        if (this.b != null) {
            this.b.destroy();
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((a) weakReference.get()).destroy();
            }
        }
    }

    public final Looper getLooper() {
        return this.b != null ? this.b.getLooper() : Looper.myLooper();
    }

    public final boolean isFallback() {
        return this.b == null;
    }

    public final void onPause() {
        if (this.b != null) {
            this.b.onPause();
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((a) weakReference.get()).a();
            }
        }
    }

    public final void onResume() {
        if (this.b != null) {
            this.b.onResume();
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((a) weakReference.get()).b();
            }
        }
    }
}
