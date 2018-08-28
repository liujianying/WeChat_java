package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class h implements e {
    private Context context;
    private ProgressDialog dId;
    a eNk;

    public h(Context context, a aVar) {
        this.context = context;
        this.eNk = aVar;
    }

    final void e(Cursor cursor) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                n nVar = new n();
                nVar.d(cursor);
                arrayList.add(nVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(nVar);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(j.gcontact_select_email);
        this.context.getResources().getString(j.app_cancel);
        com.tencent.mm.ui.base.h.a(context, string, arrayList, arrayList2, new 1(this, arrayList3));
    }

    final void pD(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ae aeVar = new ae(arrayList);
        g.DF().a(aeVar, 0);
        Context context = this.context;
        this.context.getString(j.inviteqqfriends_title);
        this.dId = com.tencent.mm.ui.base.h.a(context, this.context.getString(j.inviteqqfriends_inviting), true, new 2(this, aeVar));
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        if (lVar.getType() == 489) {
            if (this.dId != null) {
                this.dId.dismiss();
                this.dId = null;
            }
            g.DF().b(489, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
                com.tencent.mm.ui.base.h.a(this.context, j.inviteqqfriends_invite_success, j.app_tip, new 3(this));
                return;
            }
            x.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
            this.eNk.ck(false);
        }
    }
}
