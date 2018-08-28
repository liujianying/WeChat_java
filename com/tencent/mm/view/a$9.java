package com.tencent.mm.view;

import com.tencent.mm.api.i;
import com.tencent.mm.api.n$a;
import com.tencent.mm.sdk.platformtools.x;

class a$9 implements n$a {
    final /* synthetic */ a uSy;

    a$9(a aVar) {
        this.uSy = aVar;
    }

    public final void a(i iVar) {
        x.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[]{iVar});
        this.uSy.getPresenter().c(iVar);
        onHide();
    }

    public final void onHide() {
        this.uSy.setActionBarVisible(true);
        this.uSy.mK(true);
        this.uSy.setFooterVisible(true);
    }
}
