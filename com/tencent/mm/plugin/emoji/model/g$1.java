package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;

class g$1 extends c<ft> {
    final /* synthetic */ g ihy;

    g$1(g gVar) {
        this.ihy = gVar;
        this.sFo = ft.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ft ftVar = (ft) bVar;
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_designerID = ftVar.bOq.bOs;
        emojiInfo.field_name = ftVar.bOq.name;
        emojiInfo.field_aeskey = ftVar.bOq.aeskey;
        emojiInfo.field_encrypturl = ftVar.bOq.bOt;
        emojiInfo.field_thumbUrl = ftVar.bOq.thumbUrl;
        emojiInfo.field_md5 = ftVar.bOq.bKg;
        emojiInfo.field_groupId = ftVar.bOq.bKk;
        EmojiInfo Zy = i.aEA().igx.Zy(emojiInfo.Xh());
        if (ftVar.bOq.bIH == 3) {
            String cnF = emojiInfo.cnF();
            if (Zy == null || (Zy.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
                ftVar.bOr.path = cnF;
            } else {
                String absolutePath = new File(ad.getContext().getCacheDir(), g.u(ftVar.bOq.bKg.getBytes())).getAbsolutePath();
                if (FileOp.cn(cnF) && !FileOp.cn(absolutePath)) {
                    e.e(absolutePath, ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(Zy));
                }
                ftVar.bOr.path = absolutePath;
            }
            x.i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", new Object[]{ftVar.bOr.path});
        } else if (ftVar.bOq.bIH == 1) {
            x.i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", new Object[]{emojiInfo.Xh()});
            this.ihy.ihv.add(emojiInfo.Xh());
            i.aEu().g(emojiInfo);
        }
        return false;
    }
}
