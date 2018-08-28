package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.fts.a.a;

public final class c extends a {
    protected final void BR() {
        if (BS()) {
            t(-104, 2);
        }
    }

    protected final String getTableName() {
        return "WeApp";
    }

    public final String getName() {
        return "FTS5WeAppStorage";
    }

    public final int getType() {
        return 512;
    }

    public final int getPriority() {
        return 512;
    }

    protected final boolean BS() {
        return !cE(-104, 2);
    }
}
