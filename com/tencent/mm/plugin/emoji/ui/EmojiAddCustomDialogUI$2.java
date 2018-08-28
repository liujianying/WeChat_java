package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;

class EmojiAddCustomDialogUI$2 implements a {
    final /* synthetic */ EmojiInfo ifm;
    final /* synthetic */ EmojiAddCustomDialogUI ilg;

    EmojiAddCustomDialogUI$2(EmojiAddCustomDialogUI emojiAddCustomDialogUI, EmojiInfo emojiInfo) {
        this.ilg = emojiAddCustomDialogUI;
        this.ifm = emojiInfo;
    }

    public final void a(b bVar) {
        if (i.aEA().igx.ln(false) >= n.aEj()) {
            x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
            this.ilg.aFs();
            EmojiAddCustomDialogUI.a(this.ilg);
            h.mEJ.h(10431, new Object[]{Integer.valueOf(EmojiAddCustomDialogUI.b(this.ilg)), EmojiAddCustomDialogUI.c(this.ilg).Xh(), EmojiAddCustomDialogUI.c(this.ilg).field_designerID, EmojiAddCustomDialogUI.c(this.ilg).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.c(this.ilg).field_size), EmojiAddCustomDialogUI.d(this.ilg), EmojiAddCustomDialogUI.c(this.ilg).field_activityid});
        } else if (this.ifm.field_catalog == EmojiInfo.tcH || bi.oW(this.ifm.field_groupId) || (!bi.oW(this.ifm.field_groupId) && ((c) g.n(c.class)).getEmojiMgr().zl(this.ifm.field_groupId))) {
            EmojiAddCustomDialogUI.j(this.ifm);
        } else {
            EmojiAddCustomDialogUI.k(this.ifm);
        }
    }

    public final void aFC() {
        this.ilg.aFs();
        EmojiAddCustomDialogUI.e(this.ilg);
        h.mEJ.h(10431, new Object[]{Integer.valueOf(EmojiAddCustomDialogUI.b(this.ilg)), EmojiAddCustomDialogUI.c(this.ilg).Xh(), EmojiAddCustomDialogUI.c(this.ilg).field_designerID, EmojiAddCustomDialogUI.c(this.ilg).field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.c(this.ilg).field_size), EmojiAddCustomDialogUI.d(this.ilg), EmojiAddCustomDialogUI.c(this.ilg).field_activityid});
    }
}
