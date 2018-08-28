package com.tencent.mm.ui.voicesearch;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;

class VoiceSearchResultUI$2 implements OnItemClickListener {
    final /* synthetic */ VoiceSearchResultUI uFT;

    VoiceSearchResultUI$2(VoiceSearchResultUI voiceSearchResultUI) {
        this.uFT = voiceSearchResultUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!VoiceSearchResultUI.a(this.uFT)) {
            h.mEJ.k(10452, VoiceSearchResultUI.b(this.uFT) + "," + VoiceSearchResultUI.c(this.uFT) + "," + (VoiceSearchResultUI.d(this.uFT) == null ? 0 : VoiceSearchResultUI.d(this.uFT).length) + "," + i);
        }
        ab oj = VoiceSearchResultUI.f(this.uFT).getItem(i);
        Context context = this.uFT;
        String str = oj.field_username;
        String BL = oj.BL();
        if (str != null && str.length() > 0) {
            x.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + str);
            Intent intent;
            if (context.showType == 3) {
                intent = new Intent();
                intent.putExtra("Select_Conv_User", str);
                context.setResult(-1, intent);
                context.finish();
            } else if (context.showType != 1 && !s.hP(str) && !s.hf(str) && !s.fq(str) && !s.hc(str) && !VoiceSearchResultUI.abq(BL)) {
                Intent intent2 = new Intent(context, SearchConversationResultUI.class);
                intent2.putExtra("SearchConversationResult_User", BL);
                context.startActivity(intent2);
            } else if (context.showType == 1) {
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                if (s.hc(str)) {
                    intent.putExtra("Is_group_card", true);
                }
                if (str != null && str.length() > 0) {
                    e.a(intent, str);
                    if (context.uFS) {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        context.finish();
                        return;
                    }
                    d.b(context, "profile", ".ui.ContactInfoUI", intent);
                }
            } else if (context.showType != 2) {
            } else {
                if (bi.oW(str)) {
                    x.e("MicroMsg.VoiceSearchResultUI", "username is null " + str);
                } else if (s.hk(str)) {
                    if (q.GY()) {
                        d.b(context.mController.tml, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.hm(str)) {
                    if (q.GV()) {
                        d.b(context.mController.tml, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.hl(str)) {
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.hq(str)) {
                    MMAppMgr.cancelNotification(str);
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.hi(str)) {
                    if (q.Hh()) {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.hv(str)) {
                    if (q.Hc()) {
                        intent = new Intent();
                        intent.putExtra("type", 20);
                        d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                        return;
                    }
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.hD(str)) {
                    if (q.Hd()) {
                        intent = new Intent();
                        intent.putExtra("type", 11);
                        d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                        return;
                    }
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.hn(str)) {
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.ho(str)) {
                    if (q.Hf()) {
                        d.b(context, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.hu(str)) {
                    if (q.GZ()) {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.hs(str) || s.ht(str) || s.hp(str) || s.hx(str) || s.hy(str) || s.hj(str) || s.hG(str)) {
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else {
                    context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                }
            }
        }
    }
}
