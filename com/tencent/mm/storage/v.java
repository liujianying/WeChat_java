package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.model.af;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v extends i<u> implements a, af {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] diD = new String[]{i.a(u.dhO, "chatroom")};
    private e diF;

    public v(e eVar) {
        super(eVar, u.dhO, "chatroom", ciG);
        this.diF = eVar;
    }

    public final u ih(String str) {
        c uVar = new u();
        uVar.field_chatroomname = str;
        return super.b(uVar, "chatroomname") ? uVar : null;
    }

    public final u ii(String str) {
        c uVar = new u();
        uVar.field_chatroomname = str;
        return super.b(uVar, "chatroomname") ? uVar : uVar;
    }

    public final void m(String str, long j) {
        this.diF.fV("chatroom", "update chatroom set modifytime = " + j + " where chatroomname = '" + bi.oU(str) + "'");
    }

    public final String ij(String str) {
        Assert.assertTrue(str.length() > 0);
        Cursor b = this.diF.b("select roomowner from chatroom where chatroomname='" + bi.oU(str) + "'", null, 2);
        if (b == null) {
            x.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            return null;
        }
        u uVar;
        if (b.moveToFirst()) {
            uVar = new u();
            uVar.d(b);
        } else {
            uVar = null;
        }
        b.close();
        if (uVar != null) {
            return uVar.field_roomowner;
        }
        return null;
    }

    public final String ik(String str) {
        u uVar;
        Assert.assertTrue(str.length() > 0);
        Cursor b = this.diF.b("select memberlist from chatroom where chatroomname='" + bi.oU(str) + "'", null, 2);
        if (b.moveToFirst()) {
            uVar = new u();
            uVar.d(b);
        } else {
            uVar = null;
        }
        b.close();
        if (uVar == null) {
            return null;
        }
        return uVar.field_memberlist;
    }

    public final String gT(String str) {
        u uVar;
        Assert.assertTrue(str.length() > 0);
        Cursor b = this.diF.b("select displayname from chatroom where chatroomname='" + bi.oU(str) + "'", null, 2);
        if (b.moveToFirst()) {
            uVar = new u();
            uVar.d(b);
        } else {
            uVar = null;
        }
        b.close();
        if (uVar == null) {
            return null;
        }
        return uVar.field_displayname;
    }

    public final List<String> il(String str) {
        String ik = ik(str);
        if (ik == null) {
            return null;
        }
        List<String> linkedList = new LinkedList();
        if (!ik.equals("")) {
            String[] split = ik.split(";");
            for (Object add : split) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    public final boolean im(String str) {
        u uVar = null;
        Cursor b = this.diF.b("select * from chatroom where chatroomname='" + bi.oU(str) + "'", null, 2);
        if (b.moveToFirst()) {
            uVar = new u();
            uVar.d(b);
        }
        b.close();
        return uVar != null && (uVar.field_roomflag & 1) == 0;
    }

    public final boolean in(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.diF.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            return false;
        }
        Xp(str);
        return true;
    }

    public final int a(g gVar) {
        return 0;
    }
}
