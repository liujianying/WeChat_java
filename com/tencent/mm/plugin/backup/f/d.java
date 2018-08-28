package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ab.e;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends b {
    private e dKj;
    private z gXT = new z();
    public aa gXU = new aa();

    public d(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList, e eVar) {
        x.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size())});
        this.gXT.hbD = str;
        this.gXT.hcP = j;
        this.gXT.hcQ = j2;
        this.gXT.hcR = str2;
        this.gXT.hcS = str3;
        this.gXT.hcv = linkedList;
        this.dKj = eVar;
    }

    public final boolean ass() {
        boolean ast = super.ast();
        if (!ast) {
            this.dKj.a(1, -2, "doScene failed", this);
        }
        return ast;
    }

    public final int getType() {
        return 15;
    }

    public final a asj() {
        return this.gXU;
    }

    public final a ask() {
        return this.gXT;
    }

    public final void mI(int i) {
        x.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        g(0, 0, "success");
        this.dKj.a(0, 0, "", this);
    }
}
