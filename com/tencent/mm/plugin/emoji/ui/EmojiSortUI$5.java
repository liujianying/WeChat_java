package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;

class EmojiSortUI$5 implements l {
    final /* synthetic */ EmojiSortUI imq;

    EmojiSortUI$5(EmojiSortUI emojiSortUI) {
        this.imq = emojiSortUI;
    }

    public final void remove(int i) {
        EmojiSortUI.b(this.imq).remove(EmojiSortUI.b(this.imq).getItem(i));
    }
}
