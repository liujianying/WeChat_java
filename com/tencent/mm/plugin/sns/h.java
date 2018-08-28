package com.tencent.mm.plugin.sns;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends c<lv> {
    public h() {
        this.sFo = lv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lv lvVar = (lv) bVar;
        if (!(lvVar instanceof lv)) {
            x.f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            return false;
        } else if (lvVar.bWj.list == null) {
            x.e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            return false;
        } else {
            l wVar = new w(lvVar.bWj.bNI, lvVar.bWj.bWk, "", lvVar.bWj.list.size(), lvVar.bWj.list, lvVar.bWj.scene);
            x.i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + lvVar.bWj.bNI + " memberList " + lvVar.bWj.list.size() + " scene " + lvVar.bWj.scene);
            g.Eh().dpP.a(wVar, 0);
            return true;
        }
    }
}
