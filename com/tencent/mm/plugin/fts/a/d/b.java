package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.fts.a.d.a.a;
import java.util.List;

public abstract class b implements e {
    public Context context;
    public com.tencent.mm.plugin.fts.a.d.e.b jsY;
    public int jsZ;

    public b(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        this.context = context;
        this.jsY = bVar;
        this.jsZ = i;
    }

    public static boolean bk(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean a(View view, a aVar, boolean z) {
        return false;
    }
}
