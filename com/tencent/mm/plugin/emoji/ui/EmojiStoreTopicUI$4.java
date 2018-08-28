package com.tencent.mm.plugin.emoji.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class EmojiStoreTopicUI$4 implements d {
    final /* synthetic */ EmojiStoreTopicUI inJ;

    EmojiStoreTopicUI$4(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.inJ = emojiStoreTopicUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case BaseReportManager.MAX_READ_COUNT /*1000*/:
                ActionBarActivity actionBarActivity = this.inJ.mController.tml;
                String a = EmojiStoreTopicUI.a(this.inJ);
                String e = EmojiStoreTopicUI.e(this.inJ);
                String b = EmojiStoreTopicUI.b(this.inJ);
                i.aEw();
                k.a(actionBarActivity, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreTopicUI.d(this.inJ), EmojiStoreTopicUI.a(this.inJ), EmojiStoreTopicUI.e(this.inJ), EmojiStoreTopicUI.b(this.inJ), EmojiStoreTopicUI.f(this.inJ), 0), 13);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.d(this.inJ))});
                return;
            case 1001:
                k.cZ(this.inJ.mController.tml);
                this.inJ.mController.tml.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.d(this.inJ))});
                return;
            default:
                return;
        }
    }
}
