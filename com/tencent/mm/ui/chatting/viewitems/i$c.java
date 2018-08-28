package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.i.b;
import com.tencent.mm.y.g;
import java.lang.ref.WeakReference;

public class i$c extends b {
    private a tKy;
    protected i.a ubj;

    private i.a i(a aVar) {
        if (this.ubj == null) {
            this.ubj = new i.a(aVar);
        }
        return this.ubj;
    }

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 1048625) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_emoji);
        rVar.setTag(new b().q(rVar, true));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        EmojiInfo emojiInfo;
        this.tKy = aVar2;
        ((i) aVar2.O(i.class)).aX(bdVar);
        b bVar = (b) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J == null || J.dwq == null) {
            emojiInfo = null;
        } else {
            emojiInfo = ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().zi(J.dwq);
        }
        if (emojiInfo == null || !emojiInfo.cnv()) {
            Bitmap s;
            String E = o.Pf().E(bdVar.field_imgPath, true);
            Bitmap ma = o.Pj().ma(E);
            if (ma == null || ma.isRecycled()) {
                ma = com.tencent.mm.sdk.platformtools.c.decodeFile(E, null);
                o.Pj().j(E, ma);
            }
            if (emojiInfo == null) {
                bVar.ubg.setVisibility(0);
                bVar.ubf.setVisibility(8);
                bVar.ubh.setText(ai.bF(J == null ? 0 : (long) J.dwo));
                bVar.ubh.setVisibility(0);
                bVar.ubg.setImageResource(R.g.emoji_download_btn);
            } else {
                bVar.ubf.setVisibility(0);
                bVar.ubh.setVisibility(8);
                bVar.ubg.setVisibility(8);
                bVar.ubf.setProgress(0);
                bVar.ubh.setVisibility(8);
            }
            if (!(J == null || bi.oW(J.dwq))) {
                b.ubi.put(J.dwq, new WeakReference(bVar));
            }
            if (ma == null || ma.isRecycled()) {
                s = com.tencent.mm.sdk.platformtools.c.s(this.tKy.tTq.getMMResources().getDrawable(R.g.appshareimage_icon));
            } else {
                s = ma;
            }
            bVar.ubd.setImageBitmap(s);
        } else {
            bVar.ubd.a(emojiInfo, bdVar.field_msgId);
            bVar.ubg.setVisibility(8);
            bVar.ubf.setVisibility(8);
            bVar.ubh.setVisibility(8);
            bVar.ubg.setVisibility(8);
            if (!(J == null || bi.oW(J.dwq))) {
                b.ubi.remove(J.dwq);
            }
            a(bdVar, emojiInfo);
        }
        bVar.ubd.setTag(new au(bdVar, aVar2.cwr(), i, str, 0));
        bVar.ubd.setOnClickListener(i(aVar2));
        bVar.ubd.setOnLongClickListener(c(aVar2));
        bVar.ubd.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        bVar.ubg.setOnClickListener(i(aVar2));
        bVar.ubg.setOnLongClickListener(c(aVar2));
        bVar.ubg.setTag(bVar.ubd.getTag());
    }

    protected final boolean b(a aVar) {
        return aVar.cwr();
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        g.a aVar;
        int i = ((au) view.getTag()).position;
        an YJ = an.YJ(bdVar.field_content);
        g.a J = g.a.J(bdVar.field_content, bdVar.field_reserved);
        if (J == null) {
            J = new g.a();
            J.dwq = YJ.bKg;
            aVar = J;
        } else {
            aVar = J;
        }
        if (!(ai.oW(aVar.dwq) || aVar.dwq.equals("-1"))) {
            EmojiInfo zi = ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().zi(aVar.dwq);
            if (zi != null) {
                if (!(zi.field_catalog == EmojiInfo.tcH || zi.cny())) {
                    contextMenu.add(i, 104, 0, view.getContext().getString(R.l.chatting_long_click_menu_save_emoji));
                }
                if (zi != null) {
                    h.mEJ.h(12789, new Object[]{Integer.valueOf(0), zi.Xh(), Integer.valueOf(0), zi.field_designerID, zi.field_groupId, "", "", "", "", zi.field_activityid});
                }
                boolean cnv = zi.cnv();
                if (zi.field_catalog == EmojiInfo.tcH || bi.oW(zi.field_groupId) || (!bi.oW(zi.field_groupId) && ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().zl(zi.field_groupId))) {
                    if (cnv) {
                        contextMenu.add(i, 113, 0, R.l.retransmit);
                    } else {
                        x.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                    }
                }
            }
        }
        if (bf.l(bdVar)) {
            contextMenu.clear();
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
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
