package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.k.g;
import com.tencent.mm.model.bf;
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
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.ah.d;
import com.tencent.mm.ui.chatting.viewitems.ah.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class ah$a extends b implements b {
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
        return false;
    }

    public boolean aq(int i, boolean z) {
        if (z || (i != 1 && i != 11 && i != 21 && i != 31 && i != 36 && i != 301989937)) {
            return false;
        }
        return true;
    }

    public View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from);
        rVar.setTag(new e().q(rVar, true));
        return rVar;
    }

    protected final boolean b(a aVar) {
        return aVar.cwr();
    }

    public void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        ChattingItemTranslate.b bc;
        Object obj;
        Object obj2;
        ChattingItemTranslate.a aVar3;
        int i2;
        this.tKy = aVar2;
        final e eVar = (e) aVar;
        String str2 = bdVar.field_content;
        String talkerUserName = aVar2.getTalkerUserName();
        eVar.ueb.setTag(udV, Long.valueOf(bdVar.field_msgId));
        eVar.ueb.setTag(udW, Boolean.valueOf(true));
        ChattingItemTranslate.b bVar = ChattingItemTranslate.b.uep;
        if (com.tencent.mm.app.plugin.b.vy()) {
            String str3;
            if (bdVar.cmt() && bdVar.cmy()) {
                str3 = bdVar.field_transContent;
            } else {
                str3 = null;
            }
            bc = ((ae) aVar2.O(ae.class)).bc(bdVar);
            obj = str3;
        } else {
            bc = bVar;
            obj = null;
        }
        if (aVar2.cwr() && !((c) aVar2.O(c.class)).cur()) {
            int iA = com.tencent.mm.model.bd.iA(str2);
            if (iA != -1) {
                String trim = str2.substring(0, iA).trim();
                if (trim == null || trim.length() <= 0) {
                    trim = talkerUserName;
                }
                CharSequence trim2 = str2.substring(iA + 1).trim();
                if (bi.oW(obj)) {
                    talkerUserName = trim;
                } else {
                    obj = obj.substring(iA + 1).trim();
                    talkerUserName = trim;
                }
                a(eVar, aVar2, bdVar, talkerUserName);
                a(eVar, aVar2, talkerUserName, bdVar);
                if (bdVar.cqb == null && bdVar.cmG()) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 == null) {
                    trim2 = j.a(eVar.ueb.getContext(), trim2, (int) eVar.ueb.getTextSize(), null, bC(bdVar));
                    w wVar = (w) aVar2.O(w.class);
                    if (wVar.gA(bdVar.field_msgId)) {
                        eVar.ueb.Q(f.a(com.tencent.mm.plugin.fts.a.a.d.a(trim2, wVar.cvK(), com.tencent.mm.plugin.fts.a.a.d.a.jrI, com.tencent.mm.plugin.fts.ui.b.b.jvs)).jrO);
                    } else {
                        eVar.ueb.Q(trim2);
                    }
                    for (n type : (n[]) trim2.getSpans(0, trim2.length(), n.class)) {
                        if (type.getType() == 44) {
                            h.mEJ.h(12809, new Object[]{Integer.valueOf(7), ""});
                            break;
                        }
                    }
                } else if (obj2 != null) {
                    if (bdVar.cqb.contains("notify@all")) {
                        obj2 = "";
                    } else {
                        obj2 = eVar.ueb.getContext().getString(R.l.room_notice_at_all, new Object[]{"@"}) + "\n";
                    }
                    eVar.ueb.Q(j.a(eVar.ueb.getContext(), obj2 + trim2, (int) eVar.ueb.getTextSize(), Integer.valueOf(31), bC(bdVar)));
                }
                aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
                eVar.uee.setOnClickListener(new 1(this, eVar));
                eVar.ueb.setOnLongClickListener(c(aVar2));
                eVar.ueb.setOnClickListener(cxP());
                eVar.ueb.setOnDoubleClickListener(this);
                eVar.ueb.setTag(aVar3);
                eVar.ueb.setTag(udV, Long.valueOf(bdVar.field_msgId));
                eVar.ueb.setTextListener(new MMNeatTextView.a() {
                    public final void P(CharSequence charSequence) {
                        if (((Boolean) eVar.ueb.getTag(ah$a.udW)).booleanValue()) {
                            com.tencent.mm.ui.chatting.h.a.a.cxI();
                            com.tencent.mm.ui.chatting.h.a.a.cxJ().a(charSequence, ((Long) eVar.ueb.getTag(ah$a.udV)).longValue());
                        }
                    }
                });
                eVar.uee.setVisibility(8);
                eVar.ued.setVisibility(8);
                eVar.ueb.setMaxLines(Integer.MAX_VALUE);
                i2 = g.AT().getInt("InvalidateTextFoldLineNum", 5);
                if (bf.bG(bdVar)) {
                    com.tencent.neattextview.textview.layout.b Hg = eVar.ueb.Hg(eVar.ueb.getContext().getResources().getDimensionPixelSize(R.f.chatting_normal_item_width));
                    if (Hg != null && Hg.cEg() > i2) {
                        eVar.ueb.setMaxLines(i2);
                        eVar.uee.setVisibility(0);
                        eVar.ued.setVisibility(0);
                    }
                }
                if (bi.oW(obj) || bc != ChattingItemTranslate.b.uep) {
                    if (eVar.ueg == null) {
                        eVar.ueg = (ChattingItemTranslate) eVar.uef.inflate();
                        eVar.ueg.init();
                    }
                    eVar.ueg.a(j.a(eVar.ueb.getContext(), obj, (int) eVar.ueb.getTextSize(), null, bC(bdVar)), bc);
                    eVar.ueg.setBrandWording(bi.oW(bdVar.field_transBrandWording) ? aVar2.tTq.getMMResources().getString(R.l.text_trans_text_finish) : bdVar.field_transBrandWording);
                    if (!bi.oW(obj)) {
                        aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
                        aVar3.ufC = false;
                        aVar3.hER = 2;
                        eVar.ueg.setTag(aVar3);
                        eVar.ueg.setOnClickListener(cxP());
                        eVar.ueg.setOnDoubleClickListener(this);
                        eVar.ueg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
                        eVar.ueg.setOnLongClickListener(c(aVar2));
                        eVar.ueg.setVisibility(0);
                    }
                } else if (eVar.ueg != null) {
                    eVar.ueg.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        Object trim22 = str2;
        a(eVar, aVar2, bdVar, talkerUserName);
        a(eVar, aVar2, talkerUserName, bdVar);
        if (bdVar.cqb == null) {
        }
        obj2 = null;
        if (obj2 == null) {
            trim22 = j.a(eVar.ueb.getContext(), trim22, (int) eVar.ueb.getTextSize(), null, bC(bdVar));
            w wVar2 = (w) aVar2.O(w.class);
            if (wVar2.gA(bdVar.field_msgId)) {
                eVar.ueb.Q(f.a(com.tencent.mm.plugin.fts.a.a.d.a(trim22, wVar2.cvK(), com.tencent.mm.plugin.fts.a.a.d.a.jrI, com.tencent.mm.plugin.fts.ui.b.b.jvs)).jrO);
            } else {
                eVar.ueb.Q(trim22);
            }
            for (n type2 : (n[]) trim22.getSpans(0, trim22.length(), n.class)) {
                if (type2.getType() == 44) {
                    h.mEJ.h(12809, new Object[]{Integer.valueOf(7), ""});
                    break;
                }
            }
        } else if (obj2 != null) {
            if (bdVar.cqb.contains("notify@all")) {
                obj2 = "";
            } else {
                obj2 = eVar.ueb.getContext().getString(R.l.room_notice_at_all, new Object[]{"@"}) + "\n";
            }
            eVar.ueb.Q(j.a(eVar.ueb.getContext(), obj2 + trim22, (int) eVar.ueb.getTextSize(), Integer.valueOf(31), bC(bdVar)));
        }
        aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
        eVar.uee.setOnClickListener(new 1(this, eVar));
        eVar.ueb.setOnLongClickListener(c(aVar2));
        eVar.ueb.setOnClickListener(cxP());
        eVar.ueb.setOnDoubleClickListener(this);
        eVar.ueb.setTag(aVar3);
        eVar.ueb.setTag(udV, Long.valueOf(bdVar.field_msgId));
        eVar.ueb.setTextListener(/* anonymous class already generated */);
        eVar.uee.setVisibility(8);
        eVar.ued.setVisibility(8);
        eVar.ueb.setMaxLines(Integer.MAX_VALUE);
        i2 = g.AT().getInt("InvalidateTextFoldLineNum", 5);
        if (bf.bG(bdVar)) {
            com.tencent.neattextview.textview.layout.b Hg2 = eVar.ueb.Hg(eVar.ueb.getContext().getResources().getDimensionPixelSize(R.f.chatting_normal_item_width));
            if (Hg2 != null && Hg2.cEg() > i2) {
                eVar.ueb.setMaxLines(i2);
                eVar.uee.setVisibility(0);
                eVar.ued.setVisibility(0);
            }
        }
        if (bi.oW(obj)) {
        }
        if (eVar.ueg == null) {
            eVar.ueg = (ChattingItemTranslate) eVar.uef.inflate();
            eVar.ueg.init();
        }
        eVar.ueg.a(j.a(eVar.ueb.getContext(), obj, (int) eVar.ueb.getTextSize(), null, bC(bdVar)), bc);
        if (bi.oW(bdVar.field_transBrandWording)) {
        }
        eVar.ueg.setBrandWording(bi.oW(bdVar.field_transBrandWording) ? aVar2.tTq.getMMResources().getString(R.l.text_trans_text_finish) : bdVar.field_transBrandWording);
        if (!bi.oW(obj)) {
            aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
            aVar3.ufC = false;
            aVar3.hER = 2;
            eVar.ueg.setTag(aVar3);
            eVar.ueg.setOnClickListener(cxP());
            eVar.ueg.setOnDoubleClickListener(this);
            eVar.ueg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            eVar.ueg.setOnLongClickListener(c(aVar2));
            eVar.ueg.setVisibility(0);
        }
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

    protected boolean cxM() {
        return false;
    }

    public boolean a(ContextMenu contextMenu, View view, bd bdVar) {
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
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            if (com.tencent.mm.pluginsdk.model.app.g.U(this.tKy.tTq.getContext(), bdVar.getType())) {
                contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
            }
            if (bdVar.isText() && com.tencent.mm.ac.f.MH()) {
                this.tKy.cws();
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
            }
            if (com.tencent.mm.app.plugin.b.vy()) {
                if (bdVar.cmt() && bdVar.cmy()) {
                    contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_REDIRECT_EMPTY, 0, view.getContext().getString(R.l.chatting_long_click_menu_switch_original));
                } else {
                    contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_REDIRECT_EMPTY, 0, view.getContext().getString(R.l.chatting_long_click_menu_translate));
                }
            }
            if (bf.l(bdVar)) {
                contextMenu.clear();
                if (!this.tKy.cws()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
                }
            }
        } else if (aVar.hER == 2) {
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
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        int iA;
        String str;
        String bd;
        switch (menuItem.getItemId()) {
            case 102:
                break;
            case 108:
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                bd = ((ae) aVar.O(ae.class)).bd(bdVar);
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
            case TbsListener$ErrorCode.DOWNLOAD_THROWABLE /*125*/:
                ((ae) aVar.O(ae.class)).b(menuItem, bdVar);
                return false;
            case 141:
                CharSequence charSequence = bdVar.field_transContent;
                if (aVar.cwr() && !((c) aVar.O(c.class)).cur()) {
                    iA = com.tencent.mm.model.bd.iA(charSequence);
                    if (iA != -1) {
                        charSequence = charSequence.substring(iA + 1).trim();
                    }
                }
                ClipboardManager clipboardManager = (ClipboardManager) aVar.tTq.getContext().getSystemService("clipboard");
                if (!bi.oW(charSequence)) {
                    clipboardManager.setText(charSequence);
                }
                com.tencent.mm.ui.base.h.bA(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.app_copy_ok));
                return true;
            case 142:
                Intent intent2 = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                str = bdVar.field_transContent;
                if (aVar.cwr() && !((c) aVar.O(c.class)).cur()) {
                    iA = com.tencent.mm.model.bd.iA(str);
                    if (iA != -1) {
                        bd = str.substring(iA + 1).trim();
                        if (bdVar.cmd()) {
                            intent2.putExtra("Retr_Msg_content", bd);
                            intent2.putExtra("Retr_Msg_Type", 4);
                        } else {
                            intent2.putExtra("Retr_Msg_content", bd);
                            intent2.putExtra("Retr_Msg_Type", 6);
                        }
                        aVar.startActivity(intent2);
                        return true;
                    }
                }
                bd = str;
                if (bdVar.cmd()) {
                    intent2.putExtra("Retr_Msg_content", bd);
                    intent2.putExtra("Retr_Msg_Type", 4);
                } else {
                    intent2.putExtra("Retr_Msg_content", bd);
                    intent2.putExtra("Retr_Msg_Type", 6);
                }
                aVar.startActivity(intent2);
                return true;
            case 143:
                ch chVar = new ch();
                str = bdVar.field_transContent;
                if (aVar.cwr() && !((c) aVar.O(c.class)).cur()) {
                    iA = com.tencent.mm.model.bd.iA(str);
                    if (iA != -1) {
                        bd = str.substring(iA + 1).trim();
                        com.tencent.mm.pluginsdk.model.e.b(chVar, bd, 1);
                        chVar.bJF.nd = aVar.tTq;
                        chVar.bJF.bJM = 43;
                        if (chVar.bJF.bJH == null) {
                            x.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                            break;
                        }
                        wr wrVar = chVar.bJF.bJH.rBG;
                        if (wrVar != null) {
                            wrVar.Vw(bdVar.field_talker);
                            wrVar.Vx(q.GF());
                            com.tencent.mm.sdk.b.a.sFg.m(chVar);
                            break;
                        }
                    }
                }
                bd = str;
                com.tencent.mm.pluginsdk.model.e.b(chVar, bd, 1);
                chVar.bJF.nd = aVar.tTq;
                chVar.bJF.bJM = 43;
                if (chVar.bJF.bJH == null) {
                    wr wrVar2 = chVar.bJF.bJH.rBG;
                    if (wrVar2 != null) {
                        wrVar2.Vw(bdVar.field_talker);
                        wrVar2.Vx(q.GF());
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                        break;
                    }
                }
                x.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                break;
                break;
            default:
                return false;
        }
        android.content.ClipboardManager clipboardManager2 = (android.content.ClipboardManager) aVar.tTq.getContext().getSystemService("clipboard");
        str = bdVar.field_content;
        x.d("MicroMsg.ChattingItemTextFrom", "groupId = " + menuItem.getGroupId() + ", content length: " + (str == null ? 0 : str.length()));
        Object bd2 = ((ae) aVar.O(ae.class)).bd(bdVar);
        try {
            clipboardManager2.setText(bd2);
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
        }
        com.tencent.mm.ui.base.h.bA(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.app_copy_ok));
        iA = com.tencent.mm.plugin.secinforeport.a.a.mOt;
        com.tencent.mm.plugin.secinforeport.a.a.f(1, bdVar.field_msgSvrId, bi.WK(bd2));
        return true;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        if (view instanceof MMTextView) {
            MMTextView mMTextView = (MMTextView) view;
            com.tencent.mm.ui.chatting.h.a.a.cxI();
            com.tencent.mm.ui.chatting.h.a.a.a(mMTextView.getText(), bdVar);
        }
        return true;
    }

    public final boolean dK(View view) {
        Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
        au auVar = (au) view.getTag();
        if (auVar != null) {
            CharSequence charSequence = ((MMNeatTextView) view).mText;
            intent.putExtra("Chat_Msg_Id", auVar.bXQ.field_msgId);
            intent.putExtra("key_chat_text", charSequence);
            view.getContext().startActivity(intent);
            com.tencent.mm.ui.base.b.gE(view.getContext());
        }
        return true;
    }
}
