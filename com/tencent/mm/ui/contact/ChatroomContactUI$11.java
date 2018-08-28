package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.ChattingUI;

class ChatroomContactUI$11 implements OnItemClickListener {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$11(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (ChatroomContactUI.d(this.uiv) == null ? ChatroomContactUI.d(this.uiv) : Boolean.valueOf(ChatroomContactUI.d(this.uiv).uFK)));
        if (i >= ChatroomContactUI.b(this.uiv).getHeaderViewsCount()) {
            int headerViewsCount = i - ChatroomContactUI.b(this.uiv).getHeaderViewsCount();
            if (ChatroomContactUI.d(this.uiv) == null || !ChatroomContactUI.d(this.uiv).uFK) {
                ChatroomContactUI.b(this.uiv, ((ab) ChatroomContactUI.f(this.uiv).getItem(headerViewsCount)).field_username);
                return;
            }
            boolean qY = ChatroomContactUI.d(this.uiv).qY(headerViewsCount);
            boolean Gl = ChatroomContactUI.d(this.uiv).Gl(headerViewsCount);
            x.d("MicroMsg.ChatroomContactUI", "onItemClick " + Gl);
            Intent intent;
            if (Gl) {
                ChatroomContactUI.d(this.uiv).abn(ChatroomContactUI.e(this.uiv) == null ? "" : ChatroomContactUI.e(this.uiv).getSearchContent());
            } else if (qY) {
                biy Gk = ChatroomContactUI.d(this.uiv).Gk(headerViewsCount);
                String str = Gk.rvi.siM;
                au.HU();
                ab Yg = c.FR().Yg(str);
                if (a.gd(Yg.field_type)) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Scene", 3);
                    if (str != null && str.length() > 0) {
                        if (Yg.ckW()) {
                            h.mEJ.k(10298, str + ",3");
                        }
                        e.a(intent, str);
                        d.b(this.uiv, "profile", ".ui.ContactInfoUI", intent);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", Gk.rvi.siM);
                intent2.putExtra("Contact_Alias", Gk.eJM);
                intent2.putExtra("Contact_Nick", Gk.rQz.siM);
                intent2.putExtra("Contact_Signature", Gk.eJK);
                intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(Gk.eJQ, Gk.eJI, Gk.eJJ));
                intent2.putExtra("Contact_Sex", Gk.eJH);
                intent2.putExtra("Contact_VUser_Info", Gk.rTf);
                intent2.putExtra("Contact_VUser_Info_Flag", Gk.rTe);
                intent2.putExtra("Contact_KWeibo_flag", Gk.rTi);
                intent2.putExtra("Contact_KWeibo", Gk.rTg);
                intent2.putExtra("Contact_KWeiboNick", Gk.rTh);
                intent2.putExtra("Contact_KSnsIFlag", Gk.rTk.eJS);
                intent2.putExtra("Contact_KSnsBgId", Gk.rTk.eJU);
                intent2.putExtra("Contact_KSnsBgUrl", Gk.rTk.eJT);
                if (Gk.rTl != null) {
                    try {
                        intent2.putExtra("Contact_customInfo", Gk.rTl.toByteArray());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChatroomContactUI", e, "", new Object[0]);
                    }
                }
                if ((Gk.rTe & 8) > 0) {
                    h.mEJ.k(10298, str + ",3");
                }
                d.b(this.uiv, "profile", ".ui.ContactInfoUI", intent2);
            } else {
                ab oj = ChatroomContactUI.d(this.uiv).oj(headerViewsCount);
                if (oj == null) {
                    x.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[]{Integer.valueOf(ChatroomContactUI.d(this.uiv).getCount()), Integer.valueOf(headerViewsCount)});
                    return;
                }
                x.n(ChatroomContactUI.e(this.uiv).getSearchContent(), 9, 3, headerViewsCount + 1);
                String str2 = oj.field_username;
                intent = new Intent(this.uiv.mController.tml, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", str2);
                intent.putExtra("Chat_Mode", 1);
                this.uiv.mController.tml.startActivity(intent);
            }
        }
    }
}
