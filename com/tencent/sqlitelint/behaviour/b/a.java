package com.tencent.sqlitelint.behaviour.b;

import com.tencent.sqlitelint.SQLiteLintIssue;
import java.util.List;

public final class a extends com.tencent.sqlitelint.behaviour.a {
    private final a vnV;

    public interface a {
        void a(SQLiteLintIssue sQLiteLintIssue);
    }

    public a(a aVar) {
        this.vnV = aVar;
    }

    public final void eh(List<SQLiteLintIssue> list) {
        if (this.vnV != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    this.vnV.a((SQLiteLintIssue) list.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
