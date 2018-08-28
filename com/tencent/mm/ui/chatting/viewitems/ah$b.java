package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.viewitems.ah.d;
import com.tencent.mm.ui.chatting.viewitems.ah.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class ah$b extends b implements m, b {
    private static final int udV = R.h.chatting_item_text_msgid;
    private static final int udW = R.h.chatting_item_text_is_in_chatting;
    private a tKy;
    private d udX;

    private d cxP() {
        if (this.udX == null) {
            this.udX = new d(this.tKy);
        }
        return this.udX;
    }

    public final boolean bba() {
        return true;
    }

    public boolean aq(int i, boolean z) {
        if (z && (i == 1 || i == 11 || i == 21 || i == 31 || i == 36 || i == 301989937)) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to);
        rVar.setTag(new e().q(rVar, false));
        return rVar;
    }

    public void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        Object obj;
        ChattingItemTranslate.b bc;
        Object obj2;
        this.tKy = aVar2;
        e eVar = (e) aVar;
        eVar.ueb.setTag(udV, Long.valueOf(bdVar.field_msgId));
        eVar.ueb.setTag(udW, Boolean.valueOf(true));
        if (cxN()) {
            if (eVar.mgA != null) {
                eVar.mgA.setVisibility(8);
            }
            if (bdVar.field_status == 1 || bdVar.field_status == 5) {
                if (eVar.uai != null) {
                    eVar.uai.setVisibility(8);
                }
                eVar.ueb.setBackgroundResource(R.g.chatto_bg_alpha);
                bdVar.tbz = true;
            } else {
                eVar.ueb.setBackgroundResource(R.g.chatto_bg);
                if (eVar.uai != null) {
                    if (a((g) aVar2.O(g.class), bdVar.field_msgId)) {
                        if (bdVar.tbz) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            eVar.ueb.startAnimation(alphaAnimation);
                            bdVar.tbz = false;
                        }
                        eVar.uai.setVisibility(0);
                    } else {
                        eVar.uai.setVisibility(8);
                    }
                }
            }
        } else if (eVar.mgA != null) {
            eVar.mgA.setVisibility(bdVar.field_status >= 2 ? 8 : 0);
        }
        CharSequence charSequence = bdVar.field_content;
        if (bi.oW(charSequence)) {
            x.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
        }
        if (bdVar.cqb == null || !bdVar.cmG()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            charSequence = j.a(eVar.ueb.getContext(), charSequence, (int) eVar.ueb.getTextSize(), null, bC(bdVar));
            w wVar = (w) aVar2.O(w.class);
            if (wVar.gA(bdVar.field_msgId)) {
                eVar.ueb.Q(f.a(com.tencent.mm.plugin.fts.a.a.d.a(charSequence, wVar.cvK(), com.tencent.mm.plugin.fts.a.a.d.a.jrI, com.tencent.mm.plugin.fts.ui.b.b.jvt)).jrO);
            } else {
                eVar.ueb.Q(charSequence);
            }
            for (n type : (n[]) charSequence.getSpans(0, charSequence.length(), n.class)) {
                if (type.getType() == 44) {
                    h.mEJ.h(12809, new Object[]{Integer.valueOf(6), ""});
                    break;
                }
            }
        } else {
            if (bdVar.cqb.contains("notify@all")) {
                obj = "";
            } else {
                obj = eVar.ueb.getContext().getString(R.l.room_notice_at_all, new Object[]{"@"}) + "\n";
            }
            eVar.ueb.Q(j.a(eVar.ueb.getContext(), obj + charSequence, (int) eVar.ueb.getTextSize(), Integer.valueOf(31), bC(bdVar)));
        }
        ChattingItemTranslate.a aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
        aVar3.ufC = false;
        eVar.ueb.setTag(aVar3);
        eVar.ueb.setOnClickListener(cxP());
        eVar.ueb.setOnLongClickListener(c(aVar2));
        eVar.ueb.setOnDoubleClickListener(this);
        eVar.ueb.setTextListener(new 1(this, eVar));
        ChattingItemTranslate.b bVar = ChattingItemTranslate.b.uep;
        if (com.tencent.mm.app.plugin.b.vy()) {
            String str2;
            if (bdVar.cmt() && bdVar.cmy()) {
                str2 = bdVar.field_transContent;
            } else {
                str2 = null;
            }
            bc = ((ae) aVar2.O(ae.class)).bc(bdVar);
            obj2 = str2;
        } else {
            bc = bVar;
            obj2 = null;
        }
        if (!bi.oW(obj2) || bc != ChattingItemTranslate.b.uep) {
            if (eVar.ueg == null) {
                eVar.ueg = (ChattingItemTranslate) eVar.uef.inflate();
                eVar.ueg.init();
            }
            eVar.ueg.a(j.a(eVar.ueb.getContext(), obj2, (int) eVar.ueb.getTextSize(), null, bC(bdVar)), bc);
            eVar.ueg.setBrandWording(bi.oW(bdVar.field_transBrandWording) ? aVar2.tTq.getMMResources().getString(R.l.text_trans_text_finish) : bdVar.field_transBrandWording);
            if (!bi.oW(obj2)) {
                aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
                aVar3.hER = 2;
                eVar.ueg.setTag(aVar3);
                eVar.ueg.setOnClickListener(cxP());
                eVar.ueg.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
                eVar.ueg.setOnDoubleClickListener(this);
                eVar.ueg.setOnLongClickListener(c(aVar2));
                eVar.ueg.setVisibility(0);
            }
        } else if (eVar.ueg != null) {
            eVar.ueg.setVisibility(8);
        }
        a(i, eVar, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    private void aL(bd bdVar) {
        if (!this.tKy.getTalkerUserName().equals("medianote")) {
            au.HU();
            c.FQ().b(new com.tencent.mm.aq.e(bdVar.field_talker, bdVar.field_msgSvrId));
        }
        ak.aL(bdVar);
        this.tKy.lT(true);
    }

    private String bC(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        String ic = u.ic(bdVar.field_msgSvrId);
        u.b v = u.Hx().v(ic, true);
        v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
        v.p("preUsername", b(this.tKy, bdVar));
        v.p("preChatName", c(this.tKy, bdVar));
        return ic;
    }

    public boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        boolean z;
        if (bdVar.cqb == null || !bdVar.cqb.contains("announcement@all")) {
            z = false;
        } else {
            z = true;
        }
        if (!bdVar.isText() && !bdVar.cmd()) {
            return true;
        }
        ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
        int i = aVar.position;
        if (aVar.hER == 1) {
            if (bdVar.isText()) {
                contextMenu.add(i, 102, 0, view.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
            }
            contextMenu.add(i, 108, 0, view.getContext().getString(R.l.retransmit));
            if (bdVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.chatting_resend_title));
            }
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            if (com.tencent.mm.pluginsdk.model.app.g.U(this.tKy.tTq.getContext(), bdVar.getType())) {
                contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
            }
            if (!z && !bdVar.cky() && bdVar.isText() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
                contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
            }
            if (com.tencent.mm.app.plugin.b.vy()) {
                if (bdVar.cmt() && bdVar.cmy()) {
                    contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_REDIRECT_EMPTY, 0, view.getContext().getString(R.l.chatting_long_click_menu_switch_original));
                } else {
                    contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_REDIRECT_EMPTY, 0, view.getContext().getString(R.l.chatting_long_click_menu_translate));
                }
            }
            if (bdVar.isText() && com.tencent.mm.ac.f.MH()) {
                this.tKy.cws();
            }
            if (this.tKy.cws()) {
                return true;
            }
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
            return true;
        } else if (aVar.hER != 2) {
            return true;
        } else {
            contextMenu.add(i, 141, 0, view.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
            contextMenu.add(i, 142, 0, view.getContext().getString(R.l.retransmit));
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(i, 143, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            if (com.tencent.mm.app.plugin.b.vz() && bdVar.cmA()) {
                contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_THROWABLE, 0, view.getContext().getString(R.l.chatting_long_click_menu_retranslate));
            }
            return false;
        }
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        int i = 0;
        switch (menuItem.getItemId()) {
            case 102:
                break;
            case 103:
                aL(bdVar);
                return false;
            case 108:
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                String bd = ((ae) aVar.O(ae.class)).bd(bdVar);
                if (bdVar.cmd()) {
                    intent.putExtra("Retr_Msg_content", bd);
                    intent.putExtra("Retr_Msg_Type", 6);
                } else {
                    intent.putExtra("Retr_Msg_content", bd);
                    intent.putExtra("Retr_Msg_Type", 4);
                }
                aVar.startActivity(intent);
                return false;
            case TbsListener$ErrorCode.DOWNLOAD_REDIRECT_EMPTY /*124*/:
                ((ae) aVar.O(ae.class)).b(menuItem, bdVar);
                return false;
            case 141:
                ClipboardManager clipboardManager = (ClipboardManager) aVar.tTq.getContext().getSystemService("clipboard");
                CharSequence charSequence = bdVar.field_transContent;
                if (!bi.oW(charSequence)) {
                    clipboardManager.setText(charSequence);
                }
                com.tencent.mm.ui.base.h.bA(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.app_copy_ok));
                return true;
            case 142:
                Intent intent2 = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                String str = bdVar.field_transContent;
                if (bdVar.cmd()) {
                    intent2.putExtra("Retr_Msg_content", str);
                    intent2.putExtra("Retr_Msg_Type", 6);
                } else {
                    intent2.putExtra("Retr_Msg_content", str);
                    intent2.putExtra("Retr_Msg_Type", 4);
                }
                aVar.startActivity(intent2);
                return true;
            case 143:
                ch chVar = new ch();
                com.tencent.mm.pluginsdk.model.e.b(chVar, bdVar.field_transContent, 1);
                chVar.bJF.nd = aVar.tTq;
                chVar.bJF.bJM = 43;
                if (chVar.bJF.bJH == null) {
                    x.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
                    break;
                }
                wr wrVar = chVar.bJF.bJH.rBG;
                if (wrVar != null) {
                    wrVar.Vw(bdVar.field_talker);
                    wrVar.Vx(q.GF());
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    break;
                }
                break;
            default:
                return false;
        }
        android.content.ClipboardManager clipboardManager2 = (android.content.ClipboardManager) aVar.tTq.getContext().getSystemService("clipboard");
        String str2 = bdVar.field_content;
        String str3 = "MicroMsg.ChattingItemTextTo";
        StringBuilder append = new StringBuilder("groupId = ").append(menuItem.getGroupId()).append(", content length: ");
        if (str2 != null) {
            i = str2.length();
        }
        x.d(str3, append.append(i).toString());
        Object bd2 = ((ae) aVar.O(ae.class)).bd(bdVar);
        try {
            clipboardManager2.setText(bd2);
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
        }
        com.tencent.mm.ui.base.h.bA(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.app_copy_ok));
        int i2 = com.tencent.mm.plugin.secinforeport.a.a.mOt;
        com.tencent.mm.plugin.secinforeport.a.a.f(1, bdVar.field_msgSvrId, bi.WK(bd2));
        return true;
    }

    public final void a(a aVar, bd bdVar) {
        bdVar.cmw();
        au.HU();
        c.FT().a(bdVar.field_msgId, bdVar);
        if (bdVar.isText() && bdVar.field_isSend == 1) {
            aL(bdVar);
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }

    public final boolean dK(View view) {
        CharSequence charSequence = ((MMNeatTextView) view).mText;
        Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
        intent.addFlags(67108864);
        intent.putExtra("key_chat_text", charSequence);
        if (view.getTag() instanceof au) {
            au auVar = (au) view.getTag();
            if (auVar != null) {
                intent.putExtra("Chat_Msg_Id", auVar.bXQ.field_msgId);
            }
        }
        view.getContext().startActivity(intent);
        com.tencent.mm.ui.base.b.gE(view.getContext());
        return true;
    }
}
