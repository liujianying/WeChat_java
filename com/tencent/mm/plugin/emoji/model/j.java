package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j {
    Set<String> ihY;
    Set<String> ihZ;
    Set<String> iia;
    c iib = new 1(this);
    c iic = new 2(this);

    public j() {
        a.sFg.b(this.iib);
        a.sFg.b(this.iic);
        this.ihY = Collections.synchronizedSet(new HashSet());
        this.ihZ = Collections.synchronizedSet(new HashSet());
        this.iia = Collections.synchronizedSet(new HashSet());
    }

    final void aEE() {
        while (!this.ihZ.isEmpty()) {
            if (this.iia.isEmpty()) {
                Iterator it = this.ihZ.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.ihZ.remove(str);
                    EmojiGroupInfo br = i.aEA().igy.br(str, true);
                    if (br == null || (br.field_flag & 256) <= 0) {
                        x.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[]{str});
                        this.iia.add(str);
                        au.DF().a(new g(str, ""), 0);
                        return;
                    }
                    x.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[]{str});
                } else {
                    return;
                }
            }
            x.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[]{this.iia.toString()});
            return;
        }
        x.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
    }
}
