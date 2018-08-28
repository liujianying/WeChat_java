package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t$d;

public class u$c extends t$d {
    public u$c(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        au.HU();
        if (c.isSDCardAvailable()) {
            EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(auVar.bXQ.field_imgPath);
            if (zi != null && !zi.aaq()) {
                Intent intent = new Intent();
                intent.putExtra("custom_smiley_preview_md5", auVar.bXQ.field_imgPath);
                intent.putExtra("custom_to_talker_name", auVar.bXQ.field_talker);
                if (!(zi.field_catalog == EmojiGroupInfo.tcA || zi.field_catalog == EmojiGroupInfo.tcz || zi.field_catalog == EmojiGroupInfo.tcy)) {
                    intent.putExtra("custom_smiley_preview_productid", zi.field_groupId);
                }
                intent.putExtra("msg_id", auVar.bXQ.field_msgSvrId);
                intent.putExtra("msg_content", auVar.bXQ.field_content);
                String str = auVar.bXQ.field_talker;
                intent.putExtra("msg_sender", s.fq(str) ? com.tencent.mm.model.bd.iB(auVar.bXQ.field_content) : str);
                d.b(this.tKy.tTq.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", intent);
                h.mEJ.h(11592, new Object[]{Integer.valueOf(0)});
            }
        }
    }
}
