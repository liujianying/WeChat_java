package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af extends x {
    List<String> qAq;

    public af(List<String> list) {
        a aVar = new a();
        aVar.dIG = new zj();
        aVar.dIH = new zk();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        aVar.dIF = com.tencent.mm.plugin.appbrand.game.d.a.CTRL_INDEX;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        this.qAq = list;
        x.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                dj djVar = new dj();
                djVar.jPc = str;
                linkedList.add(djVar);
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        zj zjVar = (zj) this.ivx.dID.dIL;
        zjVar.rFr = linkedList;
        zjVar.rFq = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            zk zkVar = (zk) this.ivx.dIE.dIL;
            x.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + zkVar.rFq);
            LinkedList linkedList = zkVar.rFs;
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                return;
            }
            i bmf = com.tencent.mm.plugin.ac.a.bmf();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                di diVar = (di) it.next();
                f bl = g.bl(diVar.jPc, false);
                if (bl != null) {
                    bl.field_authFlag = diVar.rdF;
                    bl.field_openId = diVar.jRd;
                    x.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bmf.a(bl, new String[0]) + ", appId = " + diVar.jPc);
                }
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
    }

    public final byte[] cbx() {
        try {
            return ((b) this.ivx.KV()).Ie();
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            return null;
        }
    }

    public final void bg(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            return;
        }
        try {
            this.ivx.dIE.G(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 1;
    }
}
