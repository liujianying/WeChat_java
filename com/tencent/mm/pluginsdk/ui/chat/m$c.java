package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;

class m$c {
    PreViewEmojiView ika;
    final /* synthetic */ m qNl;

    public m$c(m mVar, View view) {
        this.qNl = mVar;
        this.ika = (PreViewEmojiView) view.findViewById(e.suggest_emoticon_iv);
        this.ika.setSize(mVar.qMY);
    }
}
