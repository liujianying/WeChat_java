package com.tencent.matrix.b;

import android.content.Context;
import com.tencent.matrix.d.b;

public class a implements c {
    private final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final void b(b bVar) {
        b.i("Matrix.DefaultPluginListener", "%s plugin is inited", bVar.getTag());
    }

    public final void c(b bVar) {
        b.i("Matrix.DefaultPluginListener", "%s plugin is started", bVar.getTag());
    }

    public final void d(b bVar) {
        b.i("Matrix.DefaultPluginListener", "%s plugin is stopped", bVar.getTag());
    }

    public void b(com.tencent.matrix.c.b bVar) {
        b.e("Matrix.DefaultPluginListener", "report issue content: %s", bVar);
    }
}
