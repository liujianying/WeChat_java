package com.tencent.mm.ui.chatting.viewitems;

import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.l;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.viewitems.u.c;
import com.tencent.mm.ui.chatting.viewitems.u.d;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class u$b extends b implements m {
    private a tKy;
    protected c ucN;
    protected l ucO;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 47) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_emoji);
        rVar.setTag(new d().q(rVar, false));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        d dVar = (d) aVar;
        EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
        if (zi != null) {
            an YJ = an.YJ(bdVar.field_content);
            dVar.ubd.a(zi, bdVar.field_msgId, YJ);
            if (dVar.ucP != null) {
                if (YJ.taS) {
                    dVar.ucP.setVisibility(0);
                    TextView textView = (TextView) dVar.jEz.findViewById(R.h.chatting_reward_tips_inflated).findViewById(R.h.chatting_emoji_reward_tv);
                    textView.setText(Html.fromHtml(aVar2.tTq.getMMResources().getString(R.l.emoji_chatting_reward_tips)));
                    ImageView imageView = (ImageView) dVar.jEz.findViewById(R.h.chatting_reward_tips_inflated).findViewById(R.h.chatting_emoji_reward_hand);
                    TextView textView2 = textView;
                    textView2.setTag(new au(bdVar, false, i, aVar2.cwp(), false, "", "", "", "", zi.field_groupId, "", true, false));
                    textView.setOnClickListener(h(aVar2));
                    if (((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aDP()) {
                        imageView.setVisibility(0);
                        ImageView imageView2 = imageView;
                        imageView2.setTag(new au(bdVar, aVar2.cwr(), i, aVar2.cwp(), 0));
                        if (this.ucO == null) {
                            this.ucO = new l(aVar2);
                        }
                        imageView.setOnClickListener(this.ucO);
                    } else {
                        imageView.setVisibility(8);
                    }
                } else {
                    dVar.ucP.setVisibility(8);
                }
            }
            if (zi.aaq() && !YJ.enG) {
                YJ.enG = true;
                bdVar.setContent(YJ.clN());
                au.HU();
                bdVar.setStatus(com.tencent.mm.model.c.FT().dW(bdVar.field_msgId).field_status);
                au.HU();
                com.tencent.mm.model.c.FT().V(bdVar);
            }
            if (cxN()) {
                dVar.mgA.setVisibility(8);
                if (bdVar.field_status == 2) {
                    if (a((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class), bdVar.field_msgId)) {
                        if (dVar.uai != null) {
                            dVar.uai.setVisibility(0);
                        }
                    }
                }
                if (dVar.uai != null) {
                    dVar.uai.setVisibility(8);
                }
            } else {
                if (dVar.uai != null) {
                    dVar.uai.setVisibility(8);
                }
                if (dVar.mgA != null) {
                    dVar.mgA.setVisibility(0);
                    if (bdVar.field_status >= 2) {
                        dVar.mgA.setVisibility(8);
                    }
                }
            }
        }
        String str2 = "";
        if (zi == null || !zi.aaq()) {
            if (zi != null) {
                str2 = bi.aG(((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(zi.Xh()), "");
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
        dVar.ubd.setTag(new au(bdVar, aVar2.cwr(), i, aVar2.cwp(), 0));
        RTChattingEmojiView rTChattingEmojiView = dVar.ubd;
        if (this.ucN == null) {
            this.ucN = new c(aVar2);
        }
        rTChattingEmojiView.setOnClickListener(this.ucN);
        dVar.ubd.setOnLongClickListener(c(aVar2));
        dVar.ubd.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        a(i, dVar, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        if (bdVar.cml()) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i = ((au) view.getTag()).position;
                EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
                if (zi == null) {
                    x.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[]{bdVar.field_imgPath});
                } else {
                    boolean cnv = zi.cnv();
                    if (!(zi.field_catalog == EmojiInfo.tcH || zi.cny() || zi.cnz())) {
                        if (cnv) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.l.chatting_long_click_menu_save_emoji));
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (zi.field_catalog == EmojiInfo.tcH || bi.oW(zi.field_groupId) || (!bi.oW(zi.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zl(zi.field_groupId))) {
                        if (cnv) {
                            contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH, 0, R.l.retransmit);
                        } else {
                            x.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (!(bi.oW(zi.field_groupId) || zi.aaq() || zi.cnz())) {
                        contextMenu.add(i, 128, 0, R.l.chatting_long_click_menu_show_emoji_detail);
                    }
                    if (!bdVar.cky() && bdVar.cml() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
                        contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
                    }
                    if (!this.tKy.cws()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
                    }
                    if (bdVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(R.l.chatting_resend_title));
                    }
                    h.mEJ.h(12789, new Object[]{Integer.valueOf(0), zi.Xh(), Integer.valueOf(0), zi.field_designerID, zi.field_groupId, "", "", "", "", "", zi.field_activityid});
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

    public final void a(a aVar, bd bdVar) {
        bdVar.cmw();
        au.HU();
        com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
        ((ah) aVar.O(ah.class)).bB(bdVar);
    }
}
