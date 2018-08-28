package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.FileInputStream;
import java.util.HashSet;

class c$a {
    private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
    int dHI = 0;
    String filePath = null;
    private HashSet<c> gXQ = new HashSet();
    byte[] gXR = null;
    private FileInputStream gXS = null;
    int offset = 0;

    static /* synthetic */ boolean a(c$a c_a, c cVar) {
        if (!c_a.gXQ.contains(cVar) && cVar.gXK.hcJ == 2) {
            x.e(TAG, "checkSceneAllFinish Error!! media scene not in sceneHashSet");
        }
        c_a.gXQ.remove(cVar);
        return c_a.gXQ.isEmpty();
    }

    public c$a(String str) {
        int i;
        this.filePath = str;
        this.gXR = null;
        String str2 = this.filePath;
        au.HU();
        if (str2.startsWith(c.Gg())) {
            EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
            if (zi == null) {
                i = 0;
            } else if ((zi.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
                i = 0;
            } else {
                this.gXR = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(zi);
                i = bi.bD(this.gXR) <= 0 ? 0 : 1;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            this.dHI = bi.bD(this.gXR);
        } else {
            this.dHI = e.cm(this.filePath);
        }
        if (this.dHI < 0) {
            this.dHI = 0;
        }
    }

    final boolean b(byte[] bArr, boolean z) {
        try {
            if (this.gXS == null) {
                this.gXS = new FileInputStream(this.filePath);
            }
            if (this.gXS.read(bArr) != bArr.length) {
                return false;
            }
            if (z) {
                this.gXS.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
