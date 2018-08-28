package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public abstract class b implements k {
    private boolean isCreated;
    public boolean jpR;

    public abstract boolean BT();

    public abstract boolean onCreate();

    public b() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[]{getName()});
    }

    public final boolean aPX() {
        return this.isCreated;
    }

    public final synchronized void create() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[]{getName(), Boolean.valueOf(this.isCreated)});
        if (!this.isCreated && onCreate()) {
            x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.isCreated = true;
        }
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{getName(), Boolean.valueOf(this.jpR), Boolean.valueOf(this.isCreated)});
        if (!this.jpR && this.isCreated && BT()) {
            x.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.jpR = true;
        }
    }

    public void a(String str, l lVar, int i, HashMap<String, String> hashMap) {
    }

    public void addSOSHistory(String str) {
    }

    public void deleteSOSHistory(String str) {
    }

    public void deleteSOSHistory() {
    }

    public a a(i iVar) {
        return null;
    }
}
