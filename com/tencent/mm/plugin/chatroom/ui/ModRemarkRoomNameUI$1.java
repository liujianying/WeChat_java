package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;

class ModRemarkRoomNameUI$1 extends c<ll> {
    final /* synthetic */ ModRemarkRoomNameUI hMW;

    ModRemarkRoomNameUI$1(ModRemarkRoomNameUI modRemarkRoomNameUI) {
        this.hMW = modRemarkRoomNameUI;
        this.sFo = ll.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ll llVar = (ll) bVar;
        String str = llVar.bVN.bVO;
        String str2 = llVar.bVN.bVP;
        int i = llVar.bVN.ret;
        if (i != 0 && str2 != null) {
            h.b(this.hMW, str2, str, true);
            if (ModRemarkRoomNameUI.a(this.hMW) != null) {
                au.HU();
                com.tencent.mm.model.c.FQ().c(ModRemarkRoomNameUI.a(this.hMW));
            }
        } else if (i == 0 && ModRemarkRoomNameUI.b(this.hMW)) {
            Intent intent = new Intent();
            intent.putExtra("room_name", ModRemarkRoomNameUI.c(this.hMW));
            this.hMW.setResult(-1, intent);
            this.hMW.finish();
        }
        if (ModRemarkRoomNameUI.d(this.hMW) != null) {
            ModRemarkRoomNameUI.d(this.hMW).dismiss();
        }
        return false;
    }
}
