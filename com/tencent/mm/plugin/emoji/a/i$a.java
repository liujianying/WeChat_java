package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;

class i$a {
    final /* synthetic */ i iei;
    StoreBannerEmojiView iek;
    ImageView iel;

    public i$a(i iVar, View view) {
        this.iei = iVar;
        this.iek = (StoreBannerEmojiView) view.findViewById(R.h.emoji_bar_view);
        this.iel = (ImageView) view.findViewById(R.h.new_tips);
        this.iek.setDefaultImageResource(0);
    }
}
