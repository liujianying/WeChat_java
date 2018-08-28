package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.record.b.k.b;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;

class k$b$1 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ e dVz;
    final /* synthetic */ long msm;
    final /* synthetic */ b msn;

    k$b$1(b bVar, e eVar, bd bdVar, long j) {
        this.msn = bVar;
        this.dVz = eVar;
        this.dAs = bdVar;
        this.msm = j;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        boolean z = i3 == 0 && i4 == 0;
        x.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (obj instanceof vx) {
            vx vxVar = (vx) obj;
            vxVar.UP(o.Pf().o(f.c(this.dVz), "", ""));
            vxVar.UQ(o.Pf().E(this.dAs.field_imgPath, true));
            Map z2 = bl.z(this.dVz.dTV, "msg");
            if (z2 != null) {
                vxVar.UF((String) z2.get(".msg.img.$cdnbigimgurl"));
                vxVar.fO((long) bi.getInt((String) z2.get(".msg.img.$length"), 0));
                vxVar.UG((String) z2.get(".msg.img.$aeskey"));
                b.b(this.msn).field_dataProto.rBI.set(b.a(this.msn), vxVar);
            } else {
                x.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[]{this.dVz.dTV});
            }
            this.msn.msh.put(Long.valueOf(vxVar.rAu), Boolean.valueOf(true));
        } else {
            this.msn.msh.put(Long.valueOf(this.msm), Boolean.valueOf(true));
        }
        b.a(this.msn, this.msn.msh, b.c(this.msn), b.b(this.msn));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        this.msn.msh.put(Long.valueOf(this.msm), Boolean.valueOf(true));
        b.a(this.msn, this.msn.msh, b.c(this.msn), b.b(this.msn));
    }
}
