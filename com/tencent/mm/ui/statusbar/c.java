package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c {
    public static final boolean uuT;
    @SuppressLint({"StaticFieldLeak"})
    private static final c uuX = new c() {
        public final void a(a aVar) {
        }
    };
    private static final WeakHashMap<Activity, c> uuY = new WeakHashMap();
    private final WeakReference<Activity> mActivityRef;
    private final Set<WeakReference<a>> uuU;
    private boolean uuV;
    int uuW;

    public interface a {
        void lH(int i);
    }

    /* synthetic */ c() {
        this(null);
    }

    static /* synthetic */ void b(c cVar, int i) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(cVar.uuU);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.lH(i);
            } else {
                cVar.uuU.remove(weakReference);
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT < 21 || d.apT()) {
            z = false;
        } else {
            z = true;
        }
        uuT = z;
    }

    private c(Activity activity) {
        this.uuU = new HashSet();
        this.uuV = false;
        this.uuW = 0;
        this.mActivityRef = new WeakReference(activity);
    }

    public void a(a aVar) {
        if (!this.uuV) {
            this.uuV = true;
            Activity activity = (Activity) this.mActivityRef.get();
            if (!(activity == null || activity.getWindow() == null)) {
                try {
                    ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0).setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            c.b(c.this, c.this.uuW = windowInsets.getSystemWindowInsetTop());
                            return windowInsets.consumeSystemWindowInsets();
                        }
                    });
                } catch (Exception e) {
                    x.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", e);
                }
            }
        }
        if (aVar != null) {
            this.uuU.add(new WeakReference(aVar));
            if (this.uuW > 0) {
                aVar.lH(this.uuW);
            }
        }
    }

    public static c ab(Activity activity) {
        if (!uuT || activity == null) {
            return uuX;
        }
        c cVar = (c) uuY.get(activity);
        if (cVar != null) {
            return cVar;
        }
        cVar = new c(activity);
        uuY.put(activity, cVar);
        return cVar;
    }
}
