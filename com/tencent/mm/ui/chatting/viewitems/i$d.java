package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.y.g;
import java.lang.ref.WeakReference;

public class i$d extends b implements m {
    private a tKy;
    protected i.a ubj;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 1048625) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg_emoji);
        rVar.setTag(new i$b().q(rVar, false));
        return rVar;
    }

    public final void a(b$a b_a, int i, a aVar, bd bdVar, String str) {
        this.tKy = aVar;
        ((i) aVar.O(i.class)).aX(bdVar);
        b_a = (i$b) b_a;
        if (bdVar != null) {
            EmojiInfo emojiInfo;
            g.a aVar2;
            EmojiInfo emojiInfo2;
            RTChattingEmojiView rTChattingEmojiView;
            String str2 = bdVar.field_content;
            an YJ = an.YJ(bdVar.field_content);
            if (YJ.enG) {
                emojiInfo = null;
                aVar2 = null;
            } else {
                if (str2 != null) {
                    aVar2 = g.a.J(str2, bdVar.field_reserved);
                } else {
                    aVar2 = null;
                }
                emojiInfo = aVar2 != null ? ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().zi(aVar2.dwq) : null;
            }
            if (YJ.bKg == null || YJ.bKg.equals("-1") || emojiInfo != null) {
                emojiInfo2 = emojiInfo;
            } else {
                emojiInfo2 = ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().zi(YJ.bKg);
            }
            if (emojiInfo2 == null || !emojiInfo2.cnv()) {
                long j;
                String E = o.Pf().E(bdVar.field_imgPath, true);
                Bitmap ma = o.Pj().ma(E);
                if (ma == null || ma.isRecycled()) {
                    ma = com.tencent.mm.sdk.platformtools.c.decodeFile(E, null);
                    o.Pj().j(E, ma);
                }
                b_a.mgA.setVisibility(8);
                b_a.ubg.setVisibility(0);
                b_a.ubf.setVisibility(8);
                TextView textView = b_a.ubh;
                if (aVar2 == null) {
                    j = 0;
                } else {
                    j = (long) aVar2.dwo;
                }
                textView.setText(ai.bF(j));
                b_a.ubh.setVisibility(0);
                b_a.ubg.setImageResource(R.g.emoji_download_btn);
                if (ma == null || ma.isRecycled()) {
                    ma = com.tencent.mm.sdk.platformtools.c.s(this.tKy.tTq.getMMResources().getDrawable(R.g.appshareimage_icon));
                }
                b_a.ubd.setImageBitmap(ma);
                if (!(aVar2 == null || bi.oW(aVar2.dwq))) {
                    i$b.ubi.put(aVar2.dwq, new WeakReference(b_a));
                }
            } else {
                int i2;
                b_a.ubd.a(emojiInfo2, bdVar.field_msgId);
                rTChattingEmojiView = b_a.ubd;
                if (rTChattingEmojiView.qOj != null) {
                    rTChattingEmojiView.qOj.resume();
                }
                boolean z = bdVar.field_status != 1;
                ProgressBar progressBar = b_a.mgA;
                if (z) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
                a(bdVar, emojiInfo2);
            }
            if (cxN()) {
                if (bdVar != null && bdVar.field_status == 2 && a((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class), bdVar.field_msgId)) {
                    if (b_a.uai != null) {
                        b_a.uai.setVisibility(0);
                    }
                } else if (b_a.uai != null) {
                    b_a.uai.setVisibility(8);
                }
            }
            b_a.ubd.setTag(new au(bdVar, aVar.cwr(), i, aVar.cwp(), 0));
            rTChattingEmojiView = b_a.ubd;
            if (this.ubj == null) {
                this.ubj = new i.a(aVar);
            }
            rTChattingEmojiView.setOnClickListener(this.ubj);
            b_a.ubd.setOnLongClickListener(c(aVar));
            b_a.ubd.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            a(i, b_a, bdVar, aVar.cwp(), aVar.cwr(), aVar, this);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
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
                    h.mEJ.h(12789, new Object[]{Integer.valueOf(0), zi.Xh(), Integer.valueOf(0), zi.field_designerID, zi.field_groupId, "", "", "", "", zi.field_activityid});
                    boolean cnv = zi.cnv();
                    if (zi.field_catalog == EmojiInfo.tcH || bi.oW(zi.field_groupId) || (!bi.oW(zi.field_groupId) && ((c) com.tencent.mm.kernel.g.n(c.class)).getEmojiMgr().zl(zi.field_groupId))) {
                        if (cnv) {
                            contextMenu.add(i, 113, 0, R.l.retransmit);
                        } else {
                            x.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                } else {
                    x.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[]{aVar.dwq});
                }
            }
            if (bdVar.field_status == 5) {
                contextMenu.add(i, s$l.AppCompatTheme_checkedTextViewStyle, 0, view.getContext().getString(R.l.chatting_resend_title));
            }
            if (!bdVar.cky() && bdVar.cmm() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
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
        if (bdVar.aQm()) {
            l.ae(bdVar);
            com.tencent.mm.model.bd.aU(bdVar.field_msgId);
            aVar.lT(true);
        }
    }
}
