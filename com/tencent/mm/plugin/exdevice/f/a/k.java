package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k extends a<akd, ake> {
    private final WeakReference<b<k>> isV;
    public List<String> ixY;
    public List<String> ixZ;
    public List<String> iya;

    protected final /* synthetic */ com.tencent.mm.bk.a aGw() {
        return new akd();
    }

    protected final /* synthetic */ com.tencent.mm.bk.a aGx() {
        return new ake();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bk.a aVar) {
    }

    public k(b<k> bVar) {
        this.isV = new WeakReference(bVar);
    }

    public final int getType() {
        return 1758;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ake ake = (ake) asj();
            this.iya = new ArrayList();
            Iterator it = ake.rMT.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                au.HU();
                if (c.FR().Yc(str2)) {
                    this.iya.add(str2);
                }
            }
            this.ixY = new ArrayList();
            this.ixZ = new ArrayList();
            if (ake.rMU != null) {
                Iterator it2 = ake.rMU.iterator();
                while (it2.hasNext()) {
                    xl xlVar = (xl) it2.next();
                    if (xlVar.rDp) {
                        this.ixZ.add(xlVar.username);
                    }
                    au.HU();
                    if (c.FR().Yc(xlVar.username)) {
                        this.ixY.add(xlVar.username);
                    }
                }
            }
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[]{Integer.valueOf(this.ixZ.size()), this.ixZ.toString()});
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[]{Integer.valueOf(this.ixY.size()), this.ixY});
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.isV.get();
        if (bVar != null) {
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            bVar.b(i2, i3, str, this);
            return;
        }
        x.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }
}
