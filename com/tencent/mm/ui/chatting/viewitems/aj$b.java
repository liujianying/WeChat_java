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
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.mm.ui.chatting.viewitems.aj.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class aj$b extends b implements m {
    private int qHv = 3;
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 34) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_voice);
        rVar.setTag(new c().b(rVar, false, this.tGg));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        c cVar = (c) aVar;
        cVar.ueJ.setFromVoice(false);
        cVar.ueJ.setFromGroup(aVar2.cwr());
        g gVar = (g) aVar2.O(g.class);
        a(gVar, bdVar.field_msgId);
        c.a(cVar, bdVar, i, aVar2, false, c(aVar2));
        ad adVar = (ad) aVar2.O(ad.class);
        String str2 = null;
        b bVar = b.uep;
        if (aj.f(bdVar, aVar2)) {
            str2 = adVar.w(bdVar.field_msgId, bdVar.field_imgPath);
            if (!bi.oW(str2)) {
                bVar = b.ues;
            }
        } else if (adVar.gD(bdVar.field_msgId)) {
            str2 = adVar.w(bdVar.field_msgId, bdVar.field_imgPath);
            bVar = adVar.gC(bdVar.field_msgId);
        }
        if (!bi.oW(str2) || bVar != b.uep) {
            if (cVar.ueg == null) {
                cVar.ueg = (ChattingItemTranslate) cVar.uef.inflate();
                cVar.ueg.setMinimumWidth(cVar.ueG - com.tencent.mm.bp.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ad.getContext(), 5));
                cVar.ueg.init();
            }
            cVar.ueg.a(str2, bVar);
            if (!bi.oW(str2)) {
                ChattingItemTranslate.a aVar3 = new ChattingItemTranslate.a(bdVar, aVar2.cwr(), i);
                aVar3.hER = 2;
                cVar.ueg.setTag(aVar3);
                cVar.ueg.setOnTouchListener(gVar.ctw());
                cVar.ueg.setOnDoubleClickListener(new 1(this, str2, bdVar));
                cVar.ueg.setOnLongClickListener(c(aVar2));
                cVar.ueg.setVisibility(0);
            }
        } else if (cVar.ueg != null) {
            cVar.ueg.setVisibility(8);
        }
        if (cxN()) {
            if (cVar.ueO != null) {
                cVar.ueO.setVisibility(8);
            }
            if (cVar.uai != null) {
                cVar.uai.setVisibility(8);
            }
            if (bdVar.field_status == 1 || bdVar.field_status == 5) {
                cVar.ueP.setBackgroundResource(R.g.chatto_bg_alpha);
                bdVar.tbz = true;
            } else {
                cVar.ueP.setBackgroundResource(R.g.chatto_bg);
                if (cVar.uai != null && a(gVar, bdVar.field_msgId)) {
                    if (bdVar.tbz) {
                        Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                        alphaAnimation.setDuration(300);
                        cVar.ueP.startAnimation(alphaAnimation);
                        bdVar.tbz = false;
                    }
                    cVar.uai.setVisibility(0);
                }
            }
        } else if (cVar.ueO != null) {
            cVar.ueO.setVisibility(0);
            if (bdVar.field_status >= 2) {
                cVar.ueO.setVisibility(8);
            }
        }
        a(i, cVar, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au.HU();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            return true;
        }
        ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
        int i = aVar.position;
        if (aVar.hER == 1) {
            int i2;
            boolean z;
            n nVar = new n(bdVar.field_content);
            if (!((nVar.time == 0 && bdVar.field_isSend == 0) || (bdVar.field_status == 1 && bdVar.field_isSend == 1))) {
                if (((ag) this.tKy.O(ag.class)).cwn()) {
                    contextMenu.add(i, 120, 0, R.l.chatfooter_SpeakerOff);
                } else {
                    contextMenu.add(i, 119, 0, R.l.chatfooter_SpeakerON);
                }
            }
            if (bdVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.chatting_resend_title));
            }
            if (d.QS("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            if (!bdVar.cky() && bdVar.ckz() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
            }
            ad adVar = (ad) this.tKy.O(ad.class);
            if (aj.f(bdVar, this.tKy)) {
                if (bi.oW(adVar.w(bdVar.field_msgId, bdVar.field_imgPath))) {
                    i2 = R.l.chatting_long_click_menu_voice_trans;
                } else {
                    i2 = R.l.chatting_long_click_menu_switch_voice_trans;
                }
            } else if (adVar.gD(bdVar.field_msgId)) {
                i2 = R.l.chatting_long_click_menu_stop_voice_trans;
            } else {
                i2 = R.l.chatting_long_click_menu_voice_trans;
            }
            if (s.hf(bdVar.field_talker) && w.chL() && i2 != -1) {
                contextMenu.add(i, 121, 0, i2);
                z = true;
            } else {
                z = false;
            }
            if (!((nVar.time == 0 && bdVar.field_isSend == 0) || ((bdVar.field_status == 1 && bdVar.field_isSend == 1) || this.tKy.cws()))) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_voice));
            }
            if (z || !w.chL() || i2 == -1) {
                return true;
            }
            contextMenu.add(i, 121, 0, i2);
            return true;
        } else if (aVar.hER != 2) {
            return true;
        } else {
            contextMenu.add(i, 141, 0, view.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
            contextMenu.add(i, 142, 0, view.getContext().getString(R.l.retransmit));
            if (d.QS("favorite")) {
                contextMenu.add(i, 143, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            return false;
        }
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        ad adVar = (ad) aVar.O(ad.class);
        String w;
        switch (menuItem.getItemId()) {
            case 100:
                ((ag) aVar.O(ag.class)).be(bdVar);
                break;
            case 103:
                ((ag) aVar.O(ag.class)).bf(bdVar);
                break;
            case 119:
                ((ag) aVar.O(ag.class)).lY(true);
                return true;
            case 120:
                ((ag) aVar.O(ag.class)).lY(false);
                return true;
            case 121:
                aj.e(aVar, bdVar);
                if (adVar.cwh()) {
                    h.a(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.voice_trans_text_tips), "", new 2(this, adVar, bdVar));
                } else {
                    adVar.e(bdVar, true);
                }
                com.tencent.mm.modelstat.b.ehL.A(bdVar);
                return true;
            case 141:
                ClipboardManager clipboardManager = (ClipboardManager) aVar.tTq.getContext().getSystemService("clipboard");
                CharSequence w2 = adVar.w(bdVar.field_msgId, bdVar.field_imgPath);
                if (!bi.oW(w2)) {
                    clipboardManager.setText(w2);
                }
                aj.e(8, bdVar);
                return true;
            case 142:
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                w = adVar.w(bdVar.field_msgId, bdVar.field_imgPath);
                if (bdVar.cmd()) {
                    intent.putExtra("Retr_Msg_content", w);
                    intent.putExtra("Retr_Msg_Type", 6);
                } else {
                    intent.putExtra("Retr_Msg_content", w);
                    intent.putExtra("Retr_Msg_Type", 4);
                }
                aVar.startActivity(intent);
                aj.e(9, bdVar);
                return true;
            case 143:
                w = adVar.w(bdVar.field_msgId, bdVar.field_imgPath);
                ch chVar = new ch();
                e.b(chVar, w, 1);
                chVar.bJF.nd = aVar.tTq;
                chVar.bJF.bJM = 43;
                if (chVar.bJF.bJH != null) {
                    wr wrVar = chVar.bJF.bJH.rBG;
                    if (wrVar != null) {
                        wrVar.Vw(q.GF());
                        wrVar.Vx(bdVar.field_talker);
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    }
                } else {
                    x.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                }
                aj.e(10, bdVar);
                return true;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        com.tencent.mm.modelstat.b.ehL.z(auVar.bXQ);
        aj.a(aVar, auVar);
        return true;
    }

    public final void a(a aVar, bd bdVar) {
    }
}
