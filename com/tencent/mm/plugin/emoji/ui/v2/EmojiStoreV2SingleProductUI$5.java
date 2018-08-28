package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n$d;

class EmojiStoreV2SingleProductUI$5 implements n$d {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$5(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1000:
                ActionBarActivity actionBarActivity = this.irx.mController.tml;
                String r = EmojiStoreV2SingleProductUI.r(this.irx);
                String s = EmojiStoreV2SingleProductUI.s(this.irx);
                String t = EmojiStoreV2SingleProductUI.t(this.irx);
                i.aEw();
                k.a(actionBarActivity, r, s, t, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreV2SingleProductUI.q(this.irx), EmojiStoreV2SingleProductUI.r(this.irx), EmojiStoreV2SingleProductUI.s(this.irx), EmojiStoreV2SingleProductUI.t(this.irx), EmojiStoreV2SingleProductUI.u(this.irx), EmojiStoreV2SingleProductUI.v(this.irx)), 12);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.irx))});
                return;
            case 1001:
                k.cZ(this.irx.mController.tml);
                this.irx.mController.tml.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.irx))});
                return;
            default:
                return;
        }
    }
}
