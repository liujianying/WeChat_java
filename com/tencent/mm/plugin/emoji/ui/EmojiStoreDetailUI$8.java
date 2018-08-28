package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreDetailUI$8 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$8(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (a.zT(EmojiStoreDetailUI.a(this.inz))) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
            com.tencent.mm.plugin.emoji.f.a.aEF().aEH();
        } else {
            au.DF().c(EmojiStoreDetailUI.v(this.inz));
        }
        if (!TextUtils.isEmpty(EmojiStoreDetailUI.w(this.inz))) {
            g.ND().lx(EmojiStoreDetailUI.w(this.inz));
            x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[]{EmojiStoreDetailUI.w(this.inz)});
        }
        if (e.cs(EmojiStoreDetailUI.b(this.inz).rwV, 1) || e.oK(EmojiStoreDetailUI.b(this.inz).rwU)) {
            EmojiStoreDetailUI.a(this.inz, 3);
        } else {
            EmojiStoreDetailUI.a(this.inz, -1);
        }
        i.aEC().g(EmojiStoreDetailUI.a(this.inz), EmojiStoreDetailUI.x(this.inz), 0, EmojiStoreDetailUI.w(this.inz));
        EmojiStoreDetailUI.i(this.inz).setVisibility(8);
        EmojiStoreDetailUI.l(this.inz).setProgress(0);
        EmojiStoreDetailUI.j(this.inz).setVisibility(4);
        EmojiStoreDetailUI.h(this.inz).setVisibility(0);
        EmojiStoreDetailUI.y(this.inz);
        EmojiStoreDetailUI.g(this.inz);
        au.DF().a(new q(EmojiStoreDetailUI.a(this.inz), 2), 0);
    }
}
