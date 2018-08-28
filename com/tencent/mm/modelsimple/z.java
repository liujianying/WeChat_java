package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d;
import com.tencent.mm.protocal.c.bqy;
import com.tencent.mm.protocal.c.bqz;
import com.tencent.mm.protocal.c.bra;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.bd;
import java.util.HashSet;

public final class z extends l implements k {
    private static HashSet<Long> egt = new HashSet();
    private final b diG;
    private e diJ;
    private final String toUserName;

    public static void S(String str, int i) {
        if (bi.oW(str) || !g.Eg().Dx()) {
            return;
        }
        if (!s.hO(str) || s.hj(str)) {
            g.Eh().dpP.a(new z(str, i), 0);
        }
    }

    public static void w(bd bdVar) {
        g.Ek();
        if (!((Boolean) g.Ei().DT().get(a.sVp, Boolean.valueOf(true))).booleanValue()) {
            x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
        } else if (egt.contains(Long.valueOf(bdVar.field_msgId))) {
            x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgId)});
        } else {
            egt.add(Long.valueOf(bdVar.field_msgId));
            if (g.Eg().Dx()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<![CDATA[<downloadList>");
                stringBuilder.append("<downloadItem>");
                stringBuilder.append("<username>");
                stringBuilder.append(bdVar.field_talker);
                stringBuilder.append("</username>");
                stringBuilder.append("<msgsvrid>");
                stringBuilder.append(bdVar.field_msgSvrId);
                stringBuilder.append("</msgsvrid>");
                stringBuilder.append("</downloadItem>");
                stringBuilder.append("</downloadList>]]>");
                String stringBuilder2 = stringBuilder.toString();
                x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[]{Long.valueOf(bdVar.field_msgId), stringBuilder});
                g.Eh().dpP.a(new z(q.GF(), 11, "DownloadFile", stringBuilder2), 0);
            }
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        if (!bi.oW(str) && !s.hO(str) && g.Eg().Dx()) {
            g.Eh().dpP.a(new z(str, i, str2, str3), 0);
        }
    }

    public z(String str, int i) {
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.dIG = new bqz();
        aVar.dIH = new bra();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.dIF = d.CTRL_INDEX;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bqz bqz = (bqz) this.diG.dID.dIL;
        bqz.jTv = q.GF();
        bqz.spd = i;
        bqz.jTu = str;
        bqz.rdo = System.currentTimeMillis();
        x.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + str);
    }

    private z(String str, int i, String str2, String str3) {
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.dIG = new bqz();
        aVar.dIH = new bra();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        aVar.dIF = d.CTRL_INDEX;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bqz bqz = (bqz) this.diG.dID.dIL;
        bqz.jTv = q.GF();
        bqz.spd = i;
        bqz.jTu = str;
        bqz.rdo = System.currentTimeMillis();
        bqz.spg = new bqy();
        bqz.spg.jPe = str2;
        bqz.spg.spc = str3;
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
        }
        this.diJ.a(i2, i3, str, this);
    }
}
