package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map.Entry;

class FacingCreateChatRoomAllInOneUI$7 implements Runnable {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;
    final /* synthetic */ LinkedList man;

    FacingCreateChatRoomAllInOneUI$7(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI, LinkedList linkedList) {
        this.mam = facingCreateChatRoomAllInOneUI;
        this.man = linkedList;
    }

    public final void run() {
        int size;
        int i;
        vt vtVar;
        if (FacingCreateChatRoomAllInOneUI.q(this.mam) != null) {
            FacingCreateChatRoomAllInOneUI.q(this.mam).clear();
        }
        if (FacingCreateChatRoomAllInOneUI.r(this.mam) != null) {
            FacingCreateChatRoomAllInOneUI.r(this.mam).clear();
        }
        if (this.man != null && this.man.size() > 0) {
            size = this.man.size();
            for (i = 0; i < size; i++) {
                vtVar = (vt) this.man.get(i);
                if (!bi.oW(vtVar.ryZ)) {
                    FacingCreateChatRoomAllInOneUI.r(this.mam).put(vtVar.ryZ, vtVar);
                }
            }
        }
        size = FacingCreateChatRoomAllInOneUI.c(this.mam).size();
        for (i = 0; i < size; i++) {
            vtVar = (vt) FacingCreateChatRoomAllInOneUI.c(this.mam).get(i);
            if (FacingCreateChatRoomAllInOneUI.r(this.mam).containsKey(vtVar.ryZ)) {
                FacingCreateChatRoomAllInOneUI.r(this.mam).remove(vtVar.ryZ);
            } else {
                x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[]{vtVar.ryZ});
            }
        }
        if (FacingCreateChatRoomAllInOneUI.r(this.mam) != null && FacingCreateChatRoomAllInOneUI.r(this.mam).size() > 0) {
            for (Entry value : FacingCreateChatRoomAllInOneUI.r(this.mam).entrySet()) {
                FacingCreateChatRoomAllInOneUI.q(this.mam).add((vt) value.getValue());
                x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[]{vtVar.ryZ});
            }
        }
        FacingCreateChatRoomAllInOneUI.c(this.mam).addAll(FacingCreateChatRoomAllInOneUI.q(this.mam));
        FacingCreateChatRoomAllInOneUI.s(this.mam).sendEmptyMessage(10001);
    }
}
