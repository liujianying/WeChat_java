package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.ui.SelectDelRoomMemberUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.List;

class SelectDelRoomMemberUI$3 implements TextWatcher {
    final /* synthetic */ SelectDelRoomMemberUI hPa;

    SelectDelRoomMemberUI$3(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.hPa = selectDelRoomMemberUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        a b = SelectDelRoomMemberUI.b(this.hPa);
        Object charSequence2 = charSequence.toString();
        b.dBm = charSequence2;
        List arrayList = new ArrayList();
        if (bi.oW(charSequence2)) {
            a.bTR = a.hOR;
        } else {
            for (ab abVar : a.hOR) {
                if (abVar != null) {
                    if (abVar.field_conRemark != null && abVar.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase())) {
                        arrayList.add(abVar);
                    } else if (!bi.oW(SelectDelRoomMemberUI.b(b.hLB, abVar.field_username)) && SelectDelRoomMemberUI.b(b.hLB, abVar.field_username).contains(charSequence2)) {
                        arrayList.add(abVar);
                    } else if (abVar.BK() != null && abVar.BK().toUpperCase().contains(charSequence2.toUpperCase())) {
                        arrayList.add(abVar);
                    } else if (abVar.wP() != null && abVar.wP().toUpperCase().contains(charSequence2.toUpperCase())) {
                        arrayList.add(abVar);
                    } else if (abVar.wM() != null && abVar.wM().contains(charSequence2)) {
                        arrayList.add(abVar);
                    } else if (abVar.field_username != null && abVar.field_username.contains(charSequence2)) {
                        arrayList.add(abVar);
                    } else if (!com.tencent.mm.l.a.gd(abVar.field_type)) {
                        au.HU();
                        bq Hh = c.FS().Hh(abVar.field_username);
                        if (!(Hh == null || Hh.field_conRemark == null || !Hh.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase()))) {
                            arrayList.add(abVar);
                        }
                    }
                }
            }
            x.i("MicroMsg.SelectDelRoomMemberUI", "--->setMemberListBySearch:search");
            a.bTR = arrayList;
        }
        b.notifyDataSetChanged();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
