package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae extends x {
    private static final String[] qAp = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ae(List<String> list) {
        int i = 0;
        a aVar = new a();
        aVar.dIG = new zf();
        aVar.dIH = new zg();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        aVar.dIF = 451;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        zf zfVar = (zf) this.ivx.dID.dIL;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (!bi.oW(str)) {
                    linkedList.add(ab.oT(str));
                }
                i++;
            }
        }
        zfVar.rFm = linkedList;
        zfVar.hbF = linkedList.size();
    }

    public final int getType() {
        return 7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((zg) this.ivx.dIE.dIL).rFn;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ho hoVar = (ho) it.next();
                    if (hoVar != null) {
                        a(g.bl(hoVar.jQb, false), hoVar);
                    }
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, ho hoVar) {
        boolean z;
        int i = 0;
        if (fVar == null) {
            fVar = new f();
            fVar.field_appId = hoVar.jQb;
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[]{hoVar.jQb, Integer.valueOf(hoVar.jPj), Long.valueOf(hoVar.riz)});
        x.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[]{fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_status), Integer.valueOf(fVar.field_appInfoFlag)});
        if (!fVar.cbJ() || bi.oW(fVar.field_appName)) {
            fVar.field_appName = hoVar.jPe;
        }
        if (!fVar.cbJ() || bi.oW(fVar.field_appName_en)) {
            fVar.field_appName_en = hoVar.rik;
        }
        if (!fVar.cbJ() || bi.oW(fVar.field_appName_tw)) {
            fVar.field_appName_tw = hoVar.rim;
        }
        fVar.field_appDiscription = hoVar.rej;
        fVar.field_appDiscription_en = hoVar.ril;
        fVar.field_appDiscription_tw = hoVar.rin;
        fVar.field_appWatermarkUrl = hoVar.rir;
        fVar.field_packageName = hoVar.rbj;
        fVar.field_signature = p.Ta(hoVar.ris);
        x.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", new Object[]{hoVar.ris, fVar.field_signature});
        fVar.field_appType = hoVar.rit;
        if (!bi.oW(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            fVar.field_appType = "," + fVar.field_appType;
        }
        fVar.field_appInfoFlag = hoVar.jPj;
        fVar.field_appVersion = hoVar.riv;
        fVar.dh(hoVar.riu);
        fVar.field_appWatermarkUrl = hoVar.rir;
        if (!(bi.oW(hoVar.rcY) || bi.oW(hoVar.riy))) {
            x.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[]{fVar.field_appName, hoVar.rcY, hoVar.riy});
            fVar.di(hoVar.rcY);
            fVar.dl(hoVar.riy);
        }
        fVar.dm(hoVar.rbk);
        fVar.field_svrAppSupportContentType = hoVar.riz;
        if (hoVar.riw > fVar.cmF) {
            fVar.cmG = 1;
            fVar.clZ = true;
        }
        fVar.cmF = hoVar.riw;
        fVar.clZ = true;
        String str = hoVar.rbj;
        String str2 = hoVar.rbj;
        int i2 = (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? true : 0;
        if (i2 != 0) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + hoVar.rbj + "appid: " + fVar.field_appId);
        }
        if (fVar.aaq()) {
            b.TX(fVar.field_appId);
        }
        i bmf = com.tencent.mm.plugin.ac.a.bmf();
        if (z) {
            fVar.field_status = i2 != 0 ? 3 : 4;
            fVar.field_modifyTime = System.currentTimeMillis();
            fVar.field_appIconUrl = hoVar.rip;
            if (fVar.field_appId != null) {
                while (i < qAp.length) {
                    if (fVar.field_appId.equals(qAp[i])) {
                        fVar.field_status = -1;
                        break;
                    }
                    i++;
                }
            }
            if (bmf.b(fVar)) {
                com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 1);
                com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 2);
                com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 3);
                com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 4);
                com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 5);
                return;
            }
            x.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            return;
        }
        fVar.field_status = i2 != 0 ? 3 : fVar.field_status;
        if (fVar.field_appId != null) {
            for (Object equals : qAp) {
                if (fVar.field_appId.equals(equals)) {
                    fVar.field_status = -1;
                    break;
                }
            }
        }
        z = (fVar == null || fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? true : (hoVar == null || hoVar.rix == null || hoVar.rix.length() == 0) ? false : !fVar.field_appIconUrl.equals(hoVar.rip);
        if (z) {
            x.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[]{fVar.field_appIconUrl, hoVar.rip});
            fVar.field_appIconUrl = hoVar.rip;
            z = bmf.c(fVar, new String[0]);
            com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 1);
            com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 2);
            com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 3);
            com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 4);
            com.tencent.mm.plugin.ac.a.bmd().cO(fVar.field_appId, 5);
        } else {
            z = bmf.c(fVar, new String[0]);
        }
        x.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + z + ", appid = " + hoVar.jQb);
    }

    public final byte[] cbx() {
        try {
            return ((com.tencent.mm.ab.b.b) this.ivx.KV()).Ie();
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void bg(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            return;
        }
        try {
            this.ivx.dIE.G(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e, "", new Object[0]);
        }
    }
}
