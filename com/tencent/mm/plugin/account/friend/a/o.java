package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class o extends i<n> implements a {
    public static final String[] diD = new String[]{i.a(n.dhO, "GoogleFriend")};
    public e diF;
    public m eKw = new 1(this);

    public o(e eVar) {
        super(eVar, n.dhO, "GoogleFriend", null);
        this.diF = eVar;
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    private boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (((int) this.diF.insert("GoogleFriend", "googleitemid", nVar.wH())) > 0) {
            return true;
        }
        return false;
    }

    public final boolean h(ArrayList<n> arrayList) {
        if (arrayList.size() <= 0) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            return false;
        }
        long dO;
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(Thread.currentThread().getId());
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[]{Long.valueOf(dO)});
            hVar = hVar2;
        } else {
            dO = -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            a((n) arrayList.get(i));
        }
        if (hVar != null) {
            hVar.gp(dO);
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.eKw.b(2, this.eKw, "");
        return true;
    }

    public final Cursor py(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        return this.diF.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder, null);
    }

    public final boolean b(n nVar) {
        Cursor b = this.diF.b("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bi.oU(nVar.field_googleitemid) + "\"", null, 2);
        boolean moveToFirst = b.moveToFirst();
        b.close();
        if (!moveToFirst) {
            return a(nVar);
        }
        int update = this.diF.update("GoogleFriend", nVar.wH(), "googleitemid=?", new String[]{nVar.field_googleitemid});
        if (update > 0) {
            doNotify();
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean aa(String str, int i) {
        return this.diF.fV("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid='" + str + "'");
    }

    public final boolean ab(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.diF.fV("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status='0' WHERE username='" + str + "'");
    }

    public final void clear() {
        this.diF.fV("GoogleFriend", " delete from GoogleFriend");
        this.eKw.b(5, this.eKw, "");
    }
}
