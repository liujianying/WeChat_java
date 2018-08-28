package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.a.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e {
    private com.tencent.mm.ak.a.c.c ihc = new 1(this);

    static /* synthetic */ void a(ta taVar, boolean z) {
        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s", new Object[]{taVar.rwk});
        if (z) {
            com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 3, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.cA(8);
        } else {
            com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 2, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.cA(3);
        }
        bi(taVar.rwk, 2);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (lVar.getType()) {
            case 221:
                return;
            case 697:
                String str2 = "";
                com.tencent.mm.plugin.emoji.f.e eVar = (com.tencent.mm.plugin.emoji.f.e) lVar;
                if (eVar.iis == com.tencent.mm.plugin.emoji.f.e.iiq) {
                    fs fsVar = eVar.diG == null ? null : (fs) eVar.diG.dID.dIL;
                    if (!(fsVar == null || fsVar.rgB == null || fsVar.rgB.size() <= 0)) {
                        str2 = (String) fsVar.rgB.get(0);
                    }
                    if (i == 0 && i2 == 0) {
                        ft ftVar = eVar.diG == null ? null : (ft) eVar.diG.dIE.dIL;
                        if (ftVar == null || ftVar.rgD == null || ftVar.rgD.size() <= 0) {
                            bi(str2, 2);
                            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            return;
                        }
                        ta taVar = (ta) ftVar.rgD.get(0);
                        au.HU();
                        String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", taVar.rwk);
                        a aDZ;
                        String str3;
                        String str4;
                        if (!bi.oW(taVar.rwm) && !bi.oW(taVar.rwn)) {
                            aDZ = i.aDZ();
                            str3 = taVar.rwm;
                            str4 = taVar.rwm;
                            aDZ.a(str3, f.p(L + "_encrypt", new Object[]{taVar, Boolean.valueOf(true)}), this.ihc);
                            com.tencent.mm.plugin.emoji.c.cA(6);
                            return;
                        } else if (bi.oW(taVar.jPK)) {
                            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            bi(str2, 2);
                            return;
                        } else {
                            aDZ = i.aDZ();
                            str3 = taVar.jPK;
                            str4 = taVar.jPK;
                            aDZ.a(str3, f.o(L, new Object[]{taVar, Boolean.valueOf(false)}), this.ihc);
                            com.tencent.mm.plugin.emoji.c.cA(1);
                            return;
                        }
                    }
                    bi(str2, 2);
                    return;
                }
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                return;
            default:
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                return;
        }
    }

    public static void bi(String str, int i) {
        q qVar = new q();
        qVar.bGO.bGP = str;
        qVar.bGO.status = i;
        qVar.bGO.bGQ = 0;
        com.tencent.mm.sdk.b.a.sFg.m(qVar);
        x.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
    }
}
