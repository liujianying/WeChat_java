package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.y;
import java.util.LinkedList;
import java.util.List;

class q$a implements TextWatcher {
    final /* synthetic */ q tPX;
    private boolean tPY;
    private List<String> tPZ;

    private q$a(q qVar) {
        this.tPX = qVar;
        this.tPY = false;
        this.tPZ = null;
    }

    /* synthetic */ q$a(q qVar, byte b) {
        this(qVar);
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private static void b(List<String> list, String[] strArr) {
        for (String str : strArr) {
            if (str.length() > 0 && str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$")) {
                list.add(str);
            }
        }
    }

    private boolean dm(String str, int i) {
        if (str == null || i < 0 || str.length() <= i) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        if (!str.substring(i - 1, i).matches("[_0-9a-zA-Z]$")) {
            return true;
        }
        if (this.tPZ == null) {
            this.tPZ = new LinkedList();
            b(this.tPZ, this.tPX.bAG.tTq.getMMResources().getStringArray(R.c.merge_smiley_code_smiley));
            b(this.tPZ, this.tPX.bAG.tTq.getMMResources().getStringArray(R.c.merge_smiley_softbank_emoji));
        }
        String substring = str.substring(0, i);
        for (String endsWith : this.tPZ) {
            if (substring.endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        x.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
        ((y) this.tPX.bAG.O(y.class)).Fe(1);
        c cVar = (c) this.tPX.bAG.O(c.class);
        String valueOf = String.valueOf(charSequence);
        String substring = valueOf.substring(i, i + i3);
        String c;
        Intent intent;
        if (s.fq(this.tPX.bAG.getTalkerUserName()) && "@".equals(substring) && !valueOf.equals(this.tPX.laA.getLastContent()) && !this.tPX.laA.qLz) {
            this.tPX.laA.setLastContent(valueOf);
            this.tPX.laA.setInsertPos(i + 1);
            if (dm(valueOf, i)) {
                c = bi.c(m.gI(this.tPX.bAG.getTalkerUserName()), ",");
                intent = new Intent();
                intent.setClass(this.tPX.bAG.tTq.getContext(), AtSomeoneUI.class);
                intent.putExtra("Block_list", q.GF());
                intent.putExtra("Chatroom_member_list", c);
                intent.putExtra("Chat_User", this.tPX.bAG.getTalkerUserName());
                intent.putExtra("Add_address_titile", this.tPX.bAG.tTq.getMMString(R.l.room_at_someone));
                this.tPX.bAG.tTq.startActivityForResult(intent, 212);
            }
        } else if (cVar.cus() && "@".equals(substring) && !valueOf.equals(this.tPX.laA.getLastContent()) && !this.tPX.laA.qLz) {
            this.tPX.laA.setLastContent(valueOf);
            this.tPX.laA.setInsertPos(i + 1);
            if (dm(valueOf, i)) {
                c = cVar.cup().field_userList;
                intent = new Intent();
                intent.setClass(this.tPX.bAG.tTq.getContext(), BizChatAtSomeoneUI.class);
                intent.putExtra("Block_list", z.Nc().cA(this.tPX.bAG.getTalkerUserName()));
                intent.putExtra("Chatroom_member_list", c);
                intent.putExtra("Chat_User", this.tPX.bAG.getTalkerUserName());
                intent.putExtra("Add_address_titile", this.tPX.bAG.tTq.getMMString(R.l.room_at_someone));
                intent.putExtra("key_biz_chat_id", ((c) this.tPX.bAG.O(c.class)).cuC());
                this.tPX.bAG.tTq.startActivityForResult(intent, 212);
            }
        } else if (!valueOf.equals(this.tPX.laA.getLastContent())) {
            this.tPX.laA.setLastContent(valueOf);
        }
        ((com.tencent.mm.ui.chatting.b.b.x) this.tPX.bAG.O(com.tencent.mm.ui.chatting.b.b.x.class)).A(valueOf, i, substring);
        if (!cVar.cur()) {
            ChatFooter chatFooter = this.tPX.laA;
            if (chatFooter.qLv != null && chatFooter.kXG != null) {
                chatFooter.qLv.qNf = true;
                com.tencent.mm.pluginsdk.ui.chat.m mVar = chatFooter.qLv;
                if (!(bi.oW(valueOf) || valueOf.equals(mVar.qNe))) {
                    g.Em().H(new m$6(mVar, valueOf));
                }
                mVar.qNe = valueOf;
            }
        }
    }
}
