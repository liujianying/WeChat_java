package com.tencent.matrix.trace.d;

import android.app.Activity;
import android.os.Process;
import android.support.v4.app.Fragment;
import com.tencent.matrix.c.c;
import com.tencent.matrix.trace.b.b;
import org.json.JSONObject;

public abstract class a extends c implements b, com.tencent.matrix.trace.core.a.a {
    final com.tencent.matrix.trace.a btG;
    String btH;
    boolean isBackground;

    protected abstract String getTag();

    a(com.tencent.matrix.trace.a aVar) {
        super(aVar);
        this.btG = aVar;
    }

    public void onChange(Activity activity, Fragment fragment) {
        String str;
        if (activity == null) {
            str = "null";
        } else {
            str = activity.getClass().getName() + (fragment == null ? "" : "&" + fragment.getClass().getName());
        }
        this.btH = str;
    }

    public void onFront(Activity activity) {
        this.isBackground = false;
    }

    public void onBackground(Activity activity) {
        this.isBackground = true;
    }

    public void onActivityCreated(Activity activity) {
    }

    public void onActivityPause(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onCreate() {
        com.tencent.matrix.d.b.i("Matrix.BaseTracer", "[onCreate] name:%s process:%s", getClass().getSimpleName(), Integer.valueOf(Process.myPid()));
        com.tencent.matrix.trace.core.a.tE().a((com.tencent.matrix.trace.core.a.a) this);
        com.tencent.matrix.trace.core.b tF = com.tencent.matrix.trace.core.b.tF();
        if (tF.bty != null && !tF.bty.contains(this)) {
            tF.bty.add(this);
        }
    }

    public void onDestroy() {
        com.tencent.matrix.d.b.i("Matrix.BaseTracer", "[onDestroy] name:%s  process:%s", getClass().getSimpleName(), Integer.valueOf(Process.myPid()));
        com.tencent.matrix.trace.core.a.tE().b((com.tencent.matrix.trace.core.a.a) this);
        com.tencent.matrix.trace.core.b tF = com.tencent.matrix.trace.core.b.tF();
        if (tF.bty != null) {
            tF.bty.remove(this);
        }
    }

    protected final void b(JSONObject jSONObject) {
        com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b();
        bVar.tag = getTag();
        bVar.brm = jSONObject;
        this.btG.a(bVar);
    }
}
