package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;

class AppBrandServiceChattingUI$a$3 extends c<kz> {
    final /* synthetic */ a tGQ;

    AppBrandServiceChattingUI$a$3(a aVar) {
        this.tGQ = aVar;
        this.sFo = kz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        kz kzVar = (kz) bVar;
        if (kzVar.bVk == null || kzVar.bVk.bGy == null) {
            x.e("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent event is empty");
            return false;
        }
        x.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", new Object[]{this.tGQ.bAG.getTalkerUserName(), kzVar.bVk.bGy, Integer.valueOf(kzVar.bVk.bVl)});
        if (!kzVar.bVk.bGy.equals(this.tGQ.bAG.getTalkerUserName())) {
            return true;
        }
        a aVar = this.tGQ;
        if ((kzVar.bVk.bVl & 2) > 0) {
            z = true;
        }
        a.a(aVar, z);
        this.tGQ.getContext().runOnUiThread(new 1(this));
        return true;
    }
}
