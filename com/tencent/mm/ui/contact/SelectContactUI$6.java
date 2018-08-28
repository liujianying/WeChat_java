package com.tencent.mm.ui.contact;

import android.widget.Toast;
import com.tencent.mm.R;
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

class SelectContactUI$6 extends b {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$6(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        if (bVar instanceof jw) {
            jw jwVar = (jw) bVar;
            if (SelectContactUI.f(this.ulL) != null) {
                if (SelectContactUI.e(this.ulL) != null) {
                    SelectContactUI.e(this.ulL).dismiss();
                    SelectContactUI.g(this.ulL);
                }
                SelectContactUI.h(this.ulL);
                SelectContactUI.d(this.ulL, false);
                SelectContactUI.a(this.ulL, jwVar.bTP.bTT);
                if (!a.a(this.ulL, i, i2, str, 4)) {
                    List linkedList;
                    int i3;
                    if (i == 0 && i2 == 0 && !bi.oW(SelectContactUI.i(this.ulL))) {
                        l.a(SelectContactUI.i(this.ulL), jwVar.bTP.bTY, this.ulL.getString(R.l.chatroom_sys_msg_invite), false, "");
                        List list = jwVar.bTP.bTX;
                        if (list != null && list.size() > 0) {
                            linkedList = new LinkedList();
                            for (i3 = 0; i3 < list.size(); i3++) {
                                linkedList.add(list.get(i3));
                            }
                            l.a(SelectContactUI.i(this.ulL), linkedList, this.ulL.getString(R.l.chatroom_sys_msg_invite_error_tip), true, "weixin://findfriend/verifycontact/" + SelectContactUI.i(this.ulL) + "/");
                        }
                        SelectContactUI.b(this.ulL, bi.F(new String[]{SelectContactUI.i(this.ulL)}));
                        return;
                    }
                    String str2 = "";
                    String str3 = "";
                    String string = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
                    if (i2 == -23) {
                        str2 = this.ulL.getString(R.l.room_member_toomuch_tip);
                        str3 = this.ulL.getString(R.l.room_member_toomuch);
                    }
                    linkedList = jwVar.bTP.bTX;
                    List list2 = jwVar.bTP.bTV;
                    if (linkedList == null || linkedList.size() <= 0 || (linkedList.size() != jwVar.bTP.bTS && (list2 == null || list2.size() <= 0 || jwVar.bTP.bTS != linkedList.size() + list2.size()))) {
                        String str4;
                        linkedList = jwVar.bTP.bTV;
                        if (linkedList == null || linkedList.size() <= 0 || jwVar.bTP.bTS != linkedList.size()) {
                            str4 = str3;
                        } else {
                            str2 = this.ulL.getString(R.l.launchchatting_create_chatroom_fail);
                            str4 = str3 + this.ulL.getString(R.l.fmt_in_blacklist, new Object[]{bi.c(SelectContactUI.dV(linkedList), string)});
                        }
                        List<String> list22 = jwVar.bTP.bTU;
                        if (list22 != null && list22.size() > 0) {
                            boolean z;
                            for (String str32 : list22) {
                                if (ab.XR(str32)) {
                                    str2 = this.ulL.getString(R.l.launchchatting_create_chatroom_fail);
                                    str4 = this.ulL.getString(R.l.launchchatting_create_chatroom_openim_fail);
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (!z) {
                                str2 = this.ulL.getString(R.l.launchchatting_create_chatroom_fail);
                                str4 = str4 + this.ulL.getString(R.l.fmt_invalid_username, new Object[]{bi.c(SelectContactUI.dV(list22), string)});
                            }
                        }
                        if (str2 == null || str2.length() <= 0) {
                            Toast.makeText(this.ulL, this.ulL.getString(R.l.fmt_create_chatroom_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                        h.b(this.ulL, str4, str2, true);
                        return;
                    }
                    LinkedList linkedList2 = new LinkedList();
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        linkedList2.add(linkedList.get(i3));
                    }
                    SelectContactUI.a(this.ulL, linkedList2, list22);
                }
            }
        }
    }
}
