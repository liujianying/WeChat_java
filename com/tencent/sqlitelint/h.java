package com.tencent.sqlitelint;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import com.tencent.sqlitelint.a.a;
import java.util.List;

public class h extends b {
    public Context mContext;
    public final a vnw;

    public h(a aVar) {
        this.vnw = aVar;
    }

    public final void a(Application application, c cVar) {
        super.a(application, cVar);
        e.ay(application);
        this.mContext = application.getApplicationContext();
    }

    public final void start() {
        super.start();
        if (this.brg) {
            e.a(new com.tencent.sqlitelint.behaviour.b.a.a() {
                public final void a(SQLiteLintIssue sQLiteLintIssue) {
                    if (sQLiteLintIssue != null) {
                        h.a(h.this, sQLiteLintIssue);
                    }
                }
            });
            List list = this.vnw.vnW;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a.a aVar = (a.a) list.get(i2);
                    String str = aVar.vnX.vnk;
                    e.a(this.mContext, aVar.vnX, aVar.vnY);
                    e.dD(str, aVar.vnZ);
                    e.v(str, aVar.voa);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void stop() {
        super.stop();
        if (this.brg) {
            List list = this.vnw.vnW;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    e.acH(((a.a) list.get(i2)).vnX.vnk);
                    i = i2 + 1;
                } else {
                    e.a(null);
                    return;
                }
            }
        }
    }

    public final String getTag() {
        return "SQLiteLint";
    }
}
