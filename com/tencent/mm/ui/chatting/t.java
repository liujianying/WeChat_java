package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.au;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMTextView;

public final class t {

    public static class b implements OnClickListener {
        private a tKy;

        public b(a aVar) {
            this.tKy = aVar;
        }

        public void onClick(View view) {
            boolean z = false;
            au auVar = (au) view.getTag();
            String str = auVar.userName;
            if (str != null && !str.equals("")) {
                Intent intent;
                if (((q) this.tKy.O(q.class)).cvD()) {
                    Context context = this.tKy.tTq.getContext();
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Encryptusername", true);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_IsLbsChattingProfile", true);
                    d.b(context, "profile", ".ui.ContactInfoUI", intent);
                    return;
                }
                c cVar = (c) this.tKy.O(c.class);
                if (cVar.cur()) {
                    j kZ = cVar.cup().kZ(str);
                    if (kZ == null) {
                        return;
                    }
                    if (kZ == null || ai.oW(kZ.field_profileUrl)) {
                        String str2 = "MicroMsg.ChattingListAvatarListener";
                        str = "onClick userInfo == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(kZ == null);
                        x.w(str2, str, objArr);
                        return;
                    }
                    x.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[]{kZ.field_profileUrl});
                    z.Ng().al(kZ.field_userId, kZ.field_brandUserName);
                    intent = new Intent();
                    intent.putExtra("rawUrl", kZ.field_profileUrl);
                    intent.putExtra("useJs", true);
                    d.b(this.tKy.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                a(intent, auVar);
                com.tencent.mm.model.au.HU();
                ab Yg = com.tencent.mm.model.c.FR().Yg(str);
                if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                    com.tencent.mm.ui.contact.e.a(intent, str);
                }
                if (s.fq(this.tKy.getTalkerUserName())) {
                    com.tencent.mm.model.au.HU();
                    u ii = com.tencent.mm.model.c.Ga().ii(this.tKy.getTalkerUserName());
                    intent.putExtra("Contact_RoomNickname", ii.gT(str));
                    intent.putExtra("Contact_Scene", 14);
                    intent.putExtra("Contact_ChatRoomId", this.tKy.getTalkerUserName());
                    intent.putExtra("room_name", this.tKy.getTalkerUserName());
                    if (ii.field_roomowner != null) {
                        z = ii.field_roomowner.equals(com.tencent.mm.model.q.GF());
                    }
                    intent.putExtra("Is_RoomOwner", z);
                }
                if (auVar.bXQ != null) {
                    switch (auVar.bXQ.getType()) {
                        case 55:
                        case 57:
                            intent.putExtra("Contact_Scene", 34);
                            intent.putExtra("Contact_IsLBSFriend", true);
                            break;
                    }
                }
                d.b(this.tKy.tTq.getContext(), "profile", ".ui.ContactInfoUI", intent, 213);
            }
        }

        public void a(Intent intent, au auVar) {
        }
    }

    public static class e implements com.tencent.mm.ui.widget.MMTextView.b {
        private OnTouchListener ePo = null;
        private o eZB = null;
        private ScrollView fPS = null;
        ag handler = new 1(this);
        private long mmg = 0;
        boolean our = false;
        private boolean ous = false;
        int pVr = 0;
        private MMTextView tKA = null;
        private TextView tKB = null;
        private final int tKC = 3;
        private int tKD = 0;
        private int tKE = 0;
        private a tKy = null;

        public e(a aVar) {
            this.tKy = aVar;
        }

        public final boolean ds(View view) {
            if (view.getTag() instanceof au) {
                au auVar = (au) view.getTag();
                if (!((!(view instanceof TextView) && !(view instanceof MMNeatTextView)) || auVar.bXQ == null || this.tKy == null)) {
                    CharSequence charSequence = "";
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    } else if (view instanceof MMNeatTextView) {
                        charSequence = ((MMNeatTextView) view).mText;
                    }
                    Context context = this.tKy.tTq.getContext();
                    bd bdVar = auVar.bXQ;
                    Intent intent = new Intent(context, TextPreviewUI.class);
                    intent.putExtra("key_chat_text", charSequence);
                    intent.putExtra("Chat_Msg_Id", bdVar.field_msgId);
                    context.startActivity(intent);
                    com.tencent.mm.ui.base.b.gE(context);
                    return true;
                }
            }
            return false;
        }
    }

    public static class n {
        bd bXQ;
        String dxx;
        String otZ;

        public n(String str, bd bdVar, String str2) {
            this.dxx = str;
            this.bXQ = bdVar;
            this.otZ = str2;
        }
    }
}
