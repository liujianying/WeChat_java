package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.aq.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.k;
import java.util.LinkedList;
import java.util.List;

@a(cwo = ah.class)
public class o extends a implements ah {
    private c tPC = new 1(this);

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        EmojiInfo zi;
        an YJ;
        String str;
        switch (menuItem.getItemId()) {
            case i$l.AppCompatTheme_checkedTextViewStyle /*103*/:
                return bB(bdVar);
            case i$l.AppCompatTheme_editTextStyle /*104*/:
                if (!bdVar.cml() && !bdVar.cmm()) {
                    return true;
                }
                String iB;
                if (bdVar.cml()) {
                    zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
                } else {
                    com.tencent.mm.y.g.a aVar2;
                    YJ = an.YJ(bdVar.field_content);
                    com.tencent.mm.y.g.a J = com.tencent.mm.y.g.a.J(bdVar.field_content, bdVar.field_reserved);
                    if (J == null) {
                        J = new com.tencent.mm.y.g.a();
                        J.dwq = YJ.bKg;
                        aVar2 = J;
                    } else {
                        aVar2 = J;
                    }
                    if (bi.oW(aVar2.dwq) || aVar2.dwq.equals("-1")) {
                        return true;
                    }
                    zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(aVar2.dwq);
                }
                str = bdVar.field_talker;
                if (s.fq(str)) {
                    iB = com.tencent.mm.model.bd.iB(bdVar.field_content);
                } else {
                    iB = str;
                }
                ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(aVar.tTq.getContext(), zi, 0, iB);
                return true;
            case 113:
                if (!bdVar.cml() && !bdVar.cmm()) {
                    return true;
                }
                List linkedList = new LinkedList();
                linkedList.add(bdVar);
                boolean z = ((com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus() || s.fq(aVar.getTalkerUserName());
                k.a(aVar.tTq.getContext(), linkedList, z, aVar.getTalkerUserName(), null);
                if (bdVar.cml()) {
                    zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
                } else {
                    YJ = an.YJ(bdVar.field_content);
                    if (bi.oW(YJ.bKg) || YJ.bKg.equals("-1")) {
                        return true;
                    }
                    zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(YJ.bKg);
                }
                if (zi == null) {
                    return true;
                }
                str = aVar.getTalkerUserName();
                if (s.fq(str)) {
                    str = com.tencent.mm.model.bd.iB(bdVar.field_content);
                }
                h.mEJ.h(12789, new Object[]{Integer.valueOf(1), zi.Xh(), Integer.valueOf(0), zi.field_designerID, zi.field_groupId, str, "", "", "", zi.field_activityid});
                return true;
            case 114:
                if (!bdVar.cml() && !bdVar.cmm()) {
                    return false;
                }
                am.d(bdVar, aVar.tTq.getContext());
                return true;
            case MapRouteSectionWithName.kMaxRoadNameLength /*128*/:
                EmojiInfo zi2;
                if (bdVar.cml()) {
                    zi2 = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
                } else {
                    YJ = an.YJ(bdVar.field_content);
                    if (bi.oW(YJ.bKg) || YJ.bKg.equals("-1")) {
                        return true;
                    }
                    zi2 = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(YJ.bKg);
                }
                if (zi2 != null) {
                    h.mEJ.h(12789, new Object[]{Integer.valueOf(2), zi2.Xh(), Integer.valueOf(0), zi2.field_designerID, zi2.field_groupId, "", "", "", "", "", zi2.field_activityid});
                }
                str = zi2 == null ? "" : zi2.field_groupId;
                if (bi.oW(str)) {
                    return true;
                }
                Intent intent = new Intent();
                intent.putExtra("preceding_scence", 3);
                intent.putExtra("download_entrance_scene", 16);
                intent.putExtra("extra_id", str);
                d.b(aVar.tTq.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                return true;
            default:
                return false;
        }
    }

    public final void cpH() {
        x.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
        com.tencent.mm.sdk.b.a.sFg.b(this.tPC);
    }

    public final void cpK() {
        x.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
        com.tencent.mm.sdk.b.a.sFg.c(this.tPC);
    }

    public final boolean bB(bd bdVar) {
        x.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        if (bdVar.cml()) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                x.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
                if (!this.bAG.getTalkerUserName().equals("medianote")) {
                    au.HU();
                    com.tencent.mm.model.c.FQ().b(new e(bdVar.field_talker, bdVar.field_msgSvrId));
                }
                ak.aJ(bdVar);
                return true;
            }
            com.tencent.mm.ui.base.s.gH(this.bAG.tTq.getContext());
            return true;
        } else if (!bdVar.cmm()) {
            return false;
        } else {
            x.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
            if (!this.bAG.getTalkerUserName().equals("medianote")) {
                au.HU();
                com.tencent.mm.model.c.FQ().b(new e(bdVar.field_talker, bdVar.field_msgSvrId));
            }
            ak.aK(bdVar);
            this.bAG.lT(true);
            return true;
        }
    }
}
