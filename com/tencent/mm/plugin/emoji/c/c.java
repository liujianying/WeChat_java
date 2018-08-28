package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.be;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c extends com.tencent.mm.sdk.b.c<be> {
    public c() {
        this.sFo = be.class.getName().hashCode();
    }

    private static boolean a(be beVar) {
        if (beVar.bIK.bIC == 37) {
            if (beVar.bIK.bID == 5 && beVar.bIK.bIH == 2) {
                i aEd = i.aEd();
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    e.deleteFile(stringBuilder.append(com.tencent.mm.model.c.Gp()).append("eggingfo.ini").toString());
                    e.k(new File(i.getDataEmojiPath(), i.ifD));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                aEd.ifU = null;
            }
            if (beVar.bIK.bIH == 0) {
                x.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[]{Integer.valueOf(beVar.bIK.bIC), Integer.valueOf(beVar.bIK.bID)});
            }
        }
        return false;
    }
}
