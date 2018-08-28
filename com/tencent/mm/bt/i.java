package com.tencent.mm.bt;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i {
    private al bAZ = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            if (i.this.tdH.isOpen()) {
                i.this.cob();
            }
            return false;
        }
    }, false);
    private String table = null;
    h tdH;
    private BlockingQueue<a> teb = new LinkedBlockingQueue();

    public static class a {
        public int sIz;
        public String sKz;
        public String sql;
        public String ted;
        public String[] tee;
        public ContentValues values;

        public final void J(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                this.tee = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.tee[i] = new String(strArr[i]);
                }
            }
        }
    }

    public i(h hVar, String str) {
        this.tdH = hVar;
        this.table = str;
    }

    public final int cob() {
        x.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.table, Boolean.valueOf(this.tdH.inTransaction()), Integer.valueOf(this.teb.size()));
        if (!this.teb.isEmpty()) {
            long j;
            if (this.tdH.inTransaction()) {
                j = 0;
            } else {
                j = this.tdH.dO(Thread.currentThread().getId());
            }
            while (!this.teb.isEmpty()) {
                a aVar = (a) this.teb.poll();
                if (aVar == null) {
                    x.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.table);
                } else if (this.tdH == null || !this.tdH.isOpen()) {
                    x.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.table);
                } else if (aVar.sIz == 2) {
                    this.tdH.insert(this.table, aVar.sKz, aVar.values);
                } else if (aVar.sIz == 5) {
                    this.tdH.delete(this.table, aVar.ted, aVar.tee);
                } else if (aVar.sIz == 1) {
                    this.tdH.fV(this.table, aVar.sql);
                } else if (aVar.sIz == 4) {
                    this.tdH.replace(this.table, aVar.sKz, aVar.values);
                } else if (aVar.sIz == 3) {
                    this.tdH.update(this.table, aVar.values, aVar.ted, aVar.tee);
                }
            }
            if (j > 0) {
                this.tdH.gp(j);
            }
        }
        return 0;
    }

    final int a(a aVar) {
        this.teb.add(aVar);
        if (this.teb.size() >= 40) {
            cob();
        }
        if (this.bAZ.ciq()) {
            this.bAZ.J(60000, 60000);
        }
        return 0;
    }
}
