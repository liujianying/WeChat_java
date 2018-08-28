package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView$h;

class EmojiSortUI$4 implements DragSortListView$h {
    final /* synthetic */ EmojiSortUI imq;

    EmojiSortUI$4(EmojiSortUI emojiSortUI) {
        this.imq = emojiSortUI;
    }

    public final void cu(int i, int i2) {
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) EmojiSortUI.b(this.imq).getItem(i);
        EmojiSortUI.b(this.imq).remove(emojiGroupInfo);
        EmojiSortUI.b(this.imq).insert(emojiGroupInfo, i2);
    }
}
