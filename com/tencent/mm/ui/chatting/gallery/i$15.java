package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.al.a;

class i$15 implements a {
    final /* synthetic */ i tWK;

    i$15(i iVar) {
        this.tWK = iVar;
    }

    public final boolean vD() {
        if (!i.f(this.tWK).isStreaming()) {
            return false;
        }
        j cwO = this.tWK.tTx.cwO();
        if (cwO == null || cwO.tWX == null || cwO.cxz().tWX.getVisibility() != 0) {
            return false;
        }
        boolean z = true;
        if (cwO.cxz().tXa.isPlaying()) {
            z = i.b(this.tWK, cwO);
        }
        if (!z) {
            return false;
        }
        return i.f(this.tWK).iC(cwO.cxz().tXa.getCurrentPosition() / 1000);
    }
}
