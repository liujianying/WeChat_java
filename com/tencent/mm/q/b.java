package com.tencent.mm.q;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m dhW;
    a dhX;
    private com.tencent.mm.sdk.e.m.b dhY = new 1(this);

    static /* synthetic */ boolean BU() {
        String str = (String) g.Ei().DT().get(6, null);
        return str != null && str.length() > 0;
    }

    static /* synthetic */ int a(b bVar, a aVar) {
        int i;
        String str;
        String str2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        String oV = bi.oV(aVar.userName);
        int i2 = aVar.status != 0 ? 131073 : 131074;
        if (aVar.bTi == null || aVar.bTi.length() <= 0) {
            i = 0;
        } else {
            bVar.dhX.a(i2, 16, aVar.id, aVar.userName, currentTimeMillis, aVar.bTi);
            i = 1;
        }
        String str3 = aVar.dia;
        String str4 = aVar.dib;
        String str5 = aVar.dic;
        if (str3 != null && str3.length() > 0) {
            String str6 = str3.equalsIgnoreCase(str4) ? null : str4;
            str = (str6 == null || str6.equalsIgnoreCase(str5)) ? null : str5;
            bVar.dhX.a(i2, 12, aVar.id, oV, currentTimeMillis, str3);
            i++;
            if (str6 != null) {
                bVar.dhX.a(i2, 13, aVar.id, oV, currentTimeMillis, str6);
                i++;
            }
            if (str != null) {
                bVar.dhX.a(i2, 14, aVar.id, oV, currentTimeMillis, str);
                i++;
            }
        }
        str3 = aVar.bgn;
        str4 = aVar.did;
        str5 = aVar.die;
        if (str3 == null || str3.length() <= 0) {
            return i;
        }
        str = str3.equalsIgnoreCase(str4) ? null : str4;
        if (!(str == null || str.equalsIgnoreCase(str5))) {
            str2 = str5;
        }
        bVar.dhX.a(i2, 5, aVar.id, oV, currentTimeMillis, str3);
        i++;
        if (str != null) {
            bVar.dhX.a(i2, 6, aVar.id, oV, currentTimeMillis, str);
            i++;
        }
        if (str2 == null) {
            return i;
        }
        bVar.dhX.a(i2, 7, aVar.id, oV, currentTimeMillis, str2);
        return i + 1;
    }

    public final String getName() {
        return "FTS5SearchFriendLogic";
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
            this.dhX = (a) ((n) g.n(n.class)).getFTSIndexStorage(1280);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.dhW.a(131172, new b(this, (byte) 0));
            ((a) g.n(a.class)).getAddrUploadStg().a(this.dhY);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        ((a) g.n(a.class)).getAddrUploadStg().b(this.dhY);
        return true;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        return this.dhW.a(-65536, new g(this, iVar));
    }
}
