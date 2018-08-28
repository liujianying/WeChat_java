package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.fq;
import com.tencent.mm.protocal.c.fr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends l implements k {
    private final b diG;
    private e diJ;
    private ArrayList<String> iio;

    public d(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.dIG = new fq();
        aVar.dIH = new fr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        aVar.dIF = 696;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iio = arrayList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            x.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            au.HU();
            c.DT().a(aa.a.sOQ, Boolean.valueOf(true));
            h.mEJ.a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            au.HU();
            c.DT().a(aa.a.sOQ, Boolean.valueOf(false));
            com.tencent.mm.storage.emotion.d dVar = i.aEA().igx;
            List list = this.iio;
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[]{Integer.valueOf(list.size())});
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE");
                stringBuilder.append(" EmojiInfo ");
                stringBuilder.append(" SET ");
                stringBuilder.append("source");
                stringBuilder.append("=");
                stringBuilder.append(EmojiInfo.tcT);
                stringBuilder.append(" where ");
                stringBuilder.append("md5");
                stringBuilder.append(" IN (");
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        break;
                    }
                    stringBuilder.append("'" + ((String) list.get(i5)) + "'");
                    if (i5 < list.size() - 1) {
                        stringBuilder.append(",");
                    }
                    i4 = i5 + 1;
                }
                stringBuilder.append(")");
                x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                dVar.diF.fV("EmojiInfo", stringBuilder.toString());
            }
            h.mEJ.a(164, 2, 1, false);
        } else {
            h.mEJ.a(164, 3, 1, false);
        }
        fr frVar = (fr) this.diG.dIE.dIL;
        if (frVar.rff != null && frVar.rff.size() > 0) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            i.aEA().igx.at(frVar.rff);
            au.HU();
            c.DT().set(348165, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.ei(true);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 696;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        ((fq) this.diG.dID.dIL).rfd = new LinkedList(this.iio);
        if (this.iio != null && this.iio.size() > 0) {
            return a(eVar, this.diG, this);
        }
        x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
        au.HU();
        c.DT().set(348162, Boolean.valueOf(false));
        return -1;
    }
}
