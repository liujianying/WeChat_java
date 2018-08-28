package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.design.a$i;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;

public class EmojiStoreV2RankUI extends BaseEmojiStoreUI {
    protected final void initView() {
        super.initView();
        setMMTitle(R.l.emoji_store_new_suggest);
    }

    protected final a aFf() {
        return new f(this.mController.tml);
    }

    protected final int aFm() {
        return 10;
    }

    protected final int aFd() {
        return 5;
    }

    protected final int aFe() {
        return a$i.AppCompatTheme_radioButtonStyle;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
