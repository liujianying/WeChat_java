package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.sqlitelint.behaviour.a;
import com.tencent.sqlitelint.behaviour.a.c;
import com.tencent.sqlitelint.e.b;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import java.util.ArrayList;
import java.util.List;

final class f implements b {
    final Context mContext;
    final String vnk;
    final c vnl;
    private final List<a> vns;

    f(Context context, e.a aVar, b bVar) {
        Object obj = 1;
        this.mContext = context;
        c.vnS.initialize(context);
        this.vnk = aVar.vnk;
        this.vnl = aVar.vnl;
        if (e.cGf() == e.c.vnp) {
            SQLite3ProfileHooker.cGj();
        }
        SQLiteLintNativeBridge.nativeInstall(this.vnk);
        this.vns = new ArrayList();
        this.vns.add(new com.tencent.sqlitelint.behaviour.a.b());
        if (((bVar.vnn & 1) > 0 ? 1 : null) != null) {
            this.vns.add(new com.tencent.sqlitelint.behaviour.alert.a(context, this.vnk));
        }
        if ((bVar.vnn & 2) <= 0) {
            obj = null;
        }
        if (obj != null) {
            this.vns.add(new com.tencent.sqlitelint.behaviour.b.a(e.vnj));
        }
    }

    public final void eh(List<SQLiteLintIssue> list) {
        int i = 0;
        for (SQLiteLintIssue sQLiteLintIssue : list) {
            if (com.tencent.sqlitelint.behaviour.a.a.acJ(sQLiteLintIssue.id)) {
                sQLiteLintIssue.isNew = false;
            } else {
                sQLiteLintIssue.isNew = true;
            }
        }
        while (i < this.vns.size()) {
            ((a) this.vns.get(i)).eh(list);
            i++;
        }
    }
}
