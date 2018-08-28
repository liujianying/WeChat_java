package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w.a;
import java.util.LinkedList;
import java.util.List;

class MMCreateChatroomUI$3 extends b {
    final /* synthetic */ MMCreateChatroomUI uDk;

    MMCreateChatroomUI$3(MMCreateChatroomUI mMCreateChatroomUI) {
        this.uDk = mMCreateChatroomUI;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        int i3 = 0;
        if (bVar instanceof jw) {
            jw jwVar = (jw) bVar;
            if (MMCreateChatroomUI.e(this.uDk) != null) {
                if (MMCreateChatroomUI.f(this.uDk) != null) {
                    MMCreateChatroomUI.f(this.uDk).dismiss();
                    MMCreateChatroomUI.g(this.uDk);
                }
                MMCreateChatroomUI.h(this.uDk);
                MMCreateChatroomUI.a(this.uDk, false);
                MMCreateChatroomUI.a(this.uDk, jwVar.bTP.bTT);
                if (!a.a(this.uDk, i, i2, str, 4)) {
                    String i4;
                    if (i == 0 && i2 == 0 && !bi.oW(MMCreateChatroomUI.i(this.uDk))) {
                        l.a(MMCreateChatroomUI.i(this.uDk), jwVar.bTP.bTY, this.uDk.getString(R.l.chatroom_sys_msg_invite), false, "");
                        List list = jwVar.bTP.bTX;
                        if (list != null && list.size() > 0) {
                            List linkedList = new LinkedList();
                            while (i3 < list.size()) {
                                linkedList.add(list.get(i3));
                                i3++;
                            }
                            l.a(MMCreateChatroomUI.i(this.uDk), linkedList, this.uDk.getString(R.l.chatroom_sys_msg_invite_error_tip), true, "weixin://findfriend/verifycontact/" + MMCreateChatroomUI.i(this.uDk) + "/");
                        }
                        i4 = MMCreateChatroomUI.i(this.uDk);
                        Intent intent = new Intent();
                        if (MMCreateChatroomUI.j(this.uDk)) {
                            intent.putExtra("Chat_User", i4);
                            d.e(this.uDk, ".ui.chatting.ChattingUI", intent);
                        } else {
                            intent.putExtra("Select_Contact", i4);
                            intent.putExtra("Select_Conv_User", i4);
                            intent.putExtra("Select_Contact", i4);
                            intent.putExtra("need_delete_chatroom_when_cancel", true);
                            this.uDk.setResult(-1, intent);
                        }
                        this.uDk.finish();
                        return;
                    }
                    String str2 = "";
                    i4 = "";
                    String string = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
                    if (i2 == -23) {
                        str2 = this.uDk.getString(R.l.room_member_toomuch_tip);
                        i4 = this.uDk.getString(R.l.room_member_toomuch);
                    }
                    List list2 = jwVar.bTP.bTX;
                    List list3 = jwVar.bTP.bTV;
                    if (list2 == null || list2.size() <= 0 || (list2.size() != jwVar.bTP.bTS && (list3 == null || list3.size() <= 0 || jwVar.bTP.bTS != list2.size() + list3.size()))) {
                        String str3;
                        list2 = jwVar.bTP.bTV;
                        if (list2 == null || list2.size() <= 0 || jwVar.bTP.bTS != list2.size()) {
                            str3 = i4;
                        } else {
                            str2 = this.uDk.getString(R.l.launchchatting_create_chatroom_fail);
                            str3 = i4 + this.uDk.getString(R.l.fmt_in_blacklist, new Object[]{bi.c(MMCreateChatroomUI.eb(list2), string)});
                        }
                        List<String> list32 = jwVar.bTP.bTU;
                        if (list32 != null && list32.size() > 0) {
                            boolean z;
                            for (String i42 : list32) {
                                if (ab.XR(i42)) {
                                    str2 = this.uDk.getString(R.l.launchchatting_create_chatroom_fail);
                                    str3 = this.uDk.getString(R.l.launchchatting_create_chatroom_openim_fail);
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (!z) {
                                str2 = this.uDk.getString(R.l.launchchatting_create_chatroom_fail);
                                str3 = str3 + this.uDk.getString(R.l.fmt_invalid_username, new Object[]{bi.c(MMCreateChatroomUI.eb(list32), string)});
                            }
                        }
                        if (str2 == null || str2.length() <= 0) {
                            Toast.makeText(this.uDk, this.uDk.getString(R.l.fmt_create_chatroom_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                        h.b(this.uDk, str3, str2, true);
                        return;
                    }
                    LinkedList linkedList2 = new LinkedList();
                    for (int i5 = 0; i5 < list2.size(); i5++) {
                        linkedList2.add(list2.get(i5));
                    }
                    MMCreateChatroomUI.a(this.uDk, linkedList2, list32);
                }
            }
        }
    }
}
