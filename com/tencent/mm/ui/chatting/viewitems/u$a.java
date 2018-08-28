package com.tencent.mm.ui.chatting.viewitems;

import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.u.d;

public class u$a extends b {
    private a tKy;
    protected u$c ucN;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 47) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_from_emoji);
        view.setTag(new d().q(view, true));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        if (bdVar == null) {
            x.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[]{str});
            return;
        }
        this.tKy = aVar2;
        EmojiInfo zi = ((c) g.n(c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
        d dVar = (d) aVar;
        if (zi != null) {
            zi.talker = bdVar.field_talker;
            an YJ = an.YJ(bdVar.field_content);
            dVar.ubd.a(zi, bdVar.field_msgId, YJ);
            if (zi.aaq() && !YJ.enG) {
                YJ.enG = true;
                bdVar.setContent(YJ.clN());
                au.HU();
                com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
            }
        }
        String str2 = "";
        if (zi == null || !zi.aaq()) {
            if (zi != null) {
                str2 = bi.aG(((c) g.n(c.class)).getEmojiMgr().zf(zi.Xh()), "");
            }
        } else if (zi.field_name.startsWith("jsb_j")) {
            str2 = this.tKy.tTq.getContext().getString(R.l.emoji_jsb_j);
        } else if (zi.field_name.startsWith("jsb_s")) {
            str2 = this.tKy.tTq.getContext().getString(R.l.emoji_jsb_s);
        } else if (zi.field_name.startsWith("jsb_b")) {
            str2 = this.tKy.tTq.getContext().getString(R.l.emoji_jsb_b);
        } else if (zi.field_name.startsWith("dice")) {
            str2 = zi.field_name.replace("dice_", "").replace(".png", "");
        }
        dVar.ubd.setContentDescription(this.tKy.tTq.getContext().getString(R.l.emoji_store_title) + str2);
        dVar.ubd.setTag(new au(bdVar, aVar2.cwr(), i, str, 0));
        RTChattingEmojiView rTChattingEmojiView = dVar.ubd;
        if (this.ucN == null) {
            this.ucN = new u$c(aVar2);
        }
        rTChattingEmojiView.setOnClickListener(this.ucN);
        dVar.ubd.setOnLongClickListener(c(aVar2));
        dVar.ubd.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
    }

    protected final boolean b(a aVar) {
        return aVar.cwr();
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        if (bdVar.cml()) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i = ((au) view.getTag()).position;
                EmojiInfo zi = ((c) g.n(c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
                if (zi == null) {
                    x.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[]{bdVar.field_imgPath});
                } else {
                    boolean cnv = zi.cnv();
                    if (!(zi.field_catalog == EmojiInfo.tcH || zi.cny() || zi.cnz())) {
                        if (cnv) {
                            contextMenu.add(i, a$i.AppCompatTheme_editTextStyle, 0, view.getContext().getString(R.l.chatting_long_click_menu_save_emoji));
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (zi.field_catalog == EmojiInfo.tcH || bi.oW(zi.field_groupId) || (!bi.oW(zi.field_groupId) && ((c) g.n(c.class)).getEmojiMgr().zl(zi.field_groupId))) {
                        if (cnv) {
                            contextMenu.add(i, 113, 0, R.l.retransmit);
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (!(bi.oW(zi.field_groupId) || zi.aaq() || zi.cnz())) {
                        contextMenu.add(i, 128, 0, R.l.chatting_long_click_menu_show_emoji_detail);
                    }
                    if (!this.tKy.cws()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
                    }
                    h.mEJ.h(12789, new Object[]{Integer.valueOf(0), zi.Xh(), Integer.valueOf(0), zi.field_designerID, zi.field_groupId, "", "", "", "", zi.field_activityid});
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        return ((ah) aVar.O(ah.class)).a(menuItem, aVar, bdVar);
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }
}
