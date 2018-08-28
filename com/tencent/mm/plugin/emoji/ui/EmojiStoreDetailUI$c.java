package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;

class EmojiStoreDetailUI$c {
    SquareImageView inC;
    final /* synthetic */ EmojiStoreDetailUI inz;

    public EmojiStoreDetailUI$c(EmojiStoreDetailUI emojiStoreDetailUI, View view) {
        this.inz = emojiStoreDetailUI;
        this.inC = (SquareImageView) view.findViewById(R.h.detail_image);
        this.inC.setScaleType(ScaleType.FIT_CENTER);
    }
}
