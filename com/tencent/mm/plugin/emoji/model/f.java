package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.protocal.c.th;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int ihp;
    public List<com.tencent.mm.plugin.emoji.a.a.f> ihq;
    public th ihr;
    public List<th> ihs;
    public List<tj> iht;
    public List<tj> ihu;

    public final void oL(int i) {
        this.ihp += i;
    }

    public final void aEr() {
        if (this.ihu != null && !this.ihu.isEmpty()) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.ihu);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.ihq.add(0, new com.tencent.mm.plugin.emoji.a.a.f((tj) arrayList.get(size)));
                this.ihp++;
                this.ihu.remove(arrayList.get(size));
            }
        }
    }

    public final void aN(List<com.tencent.mm.plugin.emoji.a.a.f> list) {
        if (this.ihq == null) {
            this.ihq = new ArrayList();
        } else {
            int size = this.ihq.size() - 1;
            if (size >= 0 && size < this.ihq.size()) {
                com.tencent.mm.plugin.emoji.a.a.f fVar = (com.tencent.mm.plugin.emoji.a.a.f) this.ihq.get(size);
                if (!(fVar == null || fVar.iez == null || bi.oW(fVar.iez.rem) || !fVar.iez.rem.equals(EmojiGroupInfo.tcy))) {
                    this.ihq.remove(fVar);
                }
            }
        }
        this.ihq.addAll(list);
    }
}
