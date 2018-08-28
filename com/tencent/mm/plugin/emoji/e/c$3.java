package com.tencent.mm.plugin.emoji.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$3 implements OnClickListener {
    final /* synthetic */ EmojiInfo ifm;
    final /* synthetic */ c ifn;

    c$3(c cVar, EmojiInfo emojiInfo) {
        this.ifn = cVar;
        this.ifm = emojiInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.a(this.ifn, this.ifm);
        this.ifn.ifl = true;
        x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{this.ifm.field_groupId});
    }
}
