package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;

class EditSignatureUI$1 extends c<ll> {
    final /* synthetic */ EditSignatureUI mPP;

    EditSignatureUI$1(EditSignatureUI editSignatureUI) {
        this.mPP = editSignatureUI;
        this.sFo = ll.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ll llVar = (ll) bVar;
        String str = llVar.bVN.bVO;
        String str2 = llVar.bVN.bVP;
        int i = llVar.bVN.ret;
        if (i != 0 && EditSignatureUI.a(this.mPP) != null) {
            h.b(this.mPP, str2, str, true);
            if (EditSignatureUI.b(this.mPP) != null) {
                ((i) g.l(i.class)).FQ().c(EditSignatureUI.b(this.mPP));
            }
        } else if (i == 0 && EditSignatureUI.c(this.mPP)) {
            g.Ei().DT().set(12291, EditSignatureUI.a(this.mPP).getText().toString().trim());
            this.mPP.finish();
        }
        if (EditSignatureUI.d(this.mPP) != null) {
            EditSignatureUI.d(this.mPP).dismiss();
        }
        return true;
    }
}
