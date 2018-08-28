package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.br.e;
import com.tencent.mm.br.f;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$10 extends c<co> {
    final /* synthetic */ b ifh;

    b$10(b bVar) {
        this.ifh = bVar;
        this.sFo = co.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((co) bVar).bJZ.bID) {
            case 1:
                f.cjI().cjK();
                e.cjH().apV();
                a.sFg.m(new nb());
                break;
            case 2:
                e.cjH().apV();
                a.sFg.m(new nb());
                break;
            default:
                x.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                break;
        }
        return false;
    }
}
