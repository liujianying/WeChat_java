package com.tencent.mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;

class g$2 implements a {
    final /* synthetic */ g ihy;

    g$2(g gVar) {
        this.ihy = gVar;
    }

    public final void h(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !this.ihy.ihv.remove(emojiInfo.Xh())) {
            x.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
            return;
        }
        x.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[]{emojiInfo.Xh()});
        ft ftVar = new ft();
        ftVar.bOq.bIH = 2;
        ftVar.bOq.bOs = emojiInfo.field_designerID;
        ftVar.bOq.name = emojiInfo.field_name;
        ftVar.bOq.aeskey = emojiInfo.field_aeskey;
        ftVar.bOq.bOt = emojiInfo.field_encrypturl;
        ftVar.bOq.thumbUrl = emojiInfo.field_thumbUrl;
        ftVar.bOq.bKg = emojiInfo.field_md5;
        ftVar.bOq.bKk = emojiInfo.field_groupId;
        String cnF = emojiInfo.cnF();
        EmojiInfo Zy = i.aEA().igx.Zy(emojiInfo.Xh());
        if (Zy == null || (Zy.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
            ftVar.bOr.path = cnF;
        } else {
            String absolutePath = new File(ad.getContext().getExternalCacheDir(), g.u(emojiInfo.Xh().getBytes())).getAbsolutePath();
            if (FileOp.cn(cnF) && !FileOp.cn(absolutePath)) {
                e.e(absolutePath, ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().a(Zy));
            }
            ftVar.bOr.path = absolutePath;
        }
        com.tencent.mm.sdk.b.a.sFg.a(ftVar, Looper.getMainLooper());
    }
}
