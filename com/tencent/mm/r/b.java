package com.tencent.mm.r;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class b implements e {
    private List<d> div = null;
    private List<d> diw = null;
    private d dix = null;
    private a diy;

    public b(List<d> list, a aVar) {
        this.div = list;
        this.diw = new ArrayList();
        this.diy = aVar;
    }

    public final boolean start() {
        if (this.div == null || this.div.size() <= 0) {
            return false;
        }
        x.i("MicroMsg.FunctionMsgFetchLooper", "start, fetchItemList.size: %s", Integer.valueOf(this.div.size()));
        g.DF().a(825, (e) this);
        BW();
        return true;
    }

    private void BW() {
        x.d("MicroMsg.FunctionMsgFetchLooper", "fetchNext, fetchItemList.size: %s", Integer.valueOf(this.div.size()));
        if (this.div.size() > 0) {
            this.dix = (d) this.div.remove(0);
            d dVar = this.dix;
            if (dVar != null) {
                x.i("MicroMsg.FunctionMsgFetchLooper", "fetchInternal, functionMsgId: %s", dVar.field_functionmsgid);
                dVar.field_status = 0;
                g.DF().a(new g(dVar), 0);
                return;
            }
            return;
        }
        g.DF().b(825, (e) this);
        if (this.diy != null) {
            this.diy.D(this.diw);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FunctionMsgFetchLooper", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (lVar.getType() == 825) {
            g gVar = (g) lVar;
            adt adt = gVar.diI;
            d dVar = gVar.diK;
            if (dVar != null && dVar.field_functionmsgid.equals(this.dix.field_functionmsgid)) {
                if (i == 0 || i2 == 0) {
                    x.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s", dVar.field_functionmsgid, Long.valueOf(adt.rIg), Long.valueOf(dVar.field_version));
                    if (adt.rIg >= dVar.field_version) {
                        dVar.field_preVersion = dVar.field_version;
                        dVar.field_version = adt.rIg;
                        dVar.field_status = 2;
                        dVar.b(adt.rIh);
                        i.Cg().a(dVar.field_functionmsgid, dVar);
                        this.diw.add(dVar);
                    }
                } else {
                    x.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s", dVar.field_functionmsgid, Long.valueOf(dVar.field_preVersion), Long.valueOf(dVar.field_version));
                    dVar.field_status = 3;
                    dVar.field_version = dVar.field_preVersion;
                    i.Cg().a(dVar.field_functionmsgid, dVar);
                }
                BW();
            }
        }
    }
}
