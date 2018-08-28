package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd.d;
import java.util.ArrayList;
import java.util.List;

public final class as extends i<ar> implements c, a {
    public static final String[] diD = new String[]{i.a(ar.dhO, "fmessage_conversation")};
    private static final String[] tbj = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    private final int bzG = 1;
    public e diF;
    protected Context mContext = null;
    private Runnable tbk = new Runnable() {
        public final void run() {
            x.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(as.this.clP()));
            g.Ei().DT().set(143618, Integer.valueOf(r0));
        }
    };

    public as(e eVar) {
        super(eVar, ar.dhO, "fmessage_conversation", tbj);
        this.diF = eVar;
        this.mContext = ad.getContext();
    }

    public final Cursor axc() {
        return this.diF.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    }

    public final int getCount() {
        int i = 0;
        Cursor b = this.diF.b("select count(*) from fmessage_conversation", null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        x.d("MicroMsg.FMessageConversationStorage", "getCount = " + i);
        return i;
    }

    public final boolean db(String str, int i) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c Gx = Gx(str);
        if (Gx == null) {
            x.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = " + str);
            return false;
        } else if (i == Gx.field_state) {
            x.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            return true;
        } else {
            Gx.field_state = i;
            Gx.field_lastModifiedTime = System.currentTimeMillis();
            if (!super.c(Gx, new String[0])) {
                return false;
            }
            Xp(str);
            return true;
        }
    }

    public final boolean clO() {
        if (this.diF.fV("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            x.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            return true;
        }
        x.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        return false;
    }

    public final int clP() {
        int i = 0;
        Cursor b = this.diF.b(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        x.d("MicroMsg.FMessageConversationStorage", "getNewCount = " + i);
        return i;
    }

    public final List<String> clQ() {
        Cursor b = this.diF.b(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null, 2);
        List<String> arrayList = new ArrayList();
        while (b.moveToNext()) {
            arrayList.add(b.getString(b.getColumnIndex("contentNickname")));
        }
        b.close();
        return arrayList;
    }

    public final boolean YK(String str) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c Gx = Gx(str);
        if (Gx == null || !str.equals(Gx.field_talker)) {
            x.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = " + str);
            return false;
        }
        Gx.field_isNew = 0;
        return super.c(Gx, new String[0]);
    }

    public final ar Gx(String str) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            return null;
        }
        com.tencent.mm.sdk.e.c arVar = new ar();
        arVar.field_talker = str;
        if (super.b(arVar, new String[0])) {
            return arVar;
        }
        x.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = " + str);
        return null;
    }

    public final ar YL(String str) {
        ar arVar = null;
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
        } else {
            Cursor b = this.diF.b("select * from fmessage_conversation  where encryptTalker=" + h.fz(str), null, 2);
            if (b.moveToFirst()) {
                arVar = new ar();
                arVar.d(b);
            }
            b.close();
        }
        return arVar;
    }

    public final void a(String str, l lVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        } else if (g.Eg().Dx()) {
            com.tencent.mm.sdk.e.c atVar = new at();
            if (((au) ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcX()).b(j, atVar)) {
                x.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = " + j);
                com.tencent.mm.sdk.e.c Gx = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcW().Gx(atVar.field_talker);
                bd.a YV;
                d YY;
                if (Gx == null) {
                    x.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + atVar.field_talker);
                    if (bi.oW(atVar.field_talker)) {
                        x.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                        return;
                    }
                    Gx = new ar();
                    if (atVar.field_type == 0) {
                        YV = bd.a.YV(atVar.field_msgContent);
                        Gx.field_displayName = YV.getDisplayName();
                        if (YV.scene == 4 && YV.cmJ() != null) {
                            Gx.field_displayName = YV.cmJ();
                        }
                        Gx.field_addScene = YV.scene;
                        Gx.field_isNew = 1;
                        Gx.field_contentFromUsername = YV.otZ;
                        Gx.field_contentNickname = YV.nickname;
                        Gx.field_contentPhoneNumMD5 = YV.tbE;
                        Gx.field_contentFullPhoneNumMD5 = YV.tbF;
                        x.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + Gx.field_contentFromUsername + "new friend Nickname: " + Gx.field_contentNickname);
                    } else if (atVar.clS()) {
                        YY = d.YY(atVar.field_msgContent);
                        Gx.field_displayName = YY.getDisplayName();
                        Gx.field_addScene = YY.scene;
                        Gx.field_isNew = 1;
                        Gx.field_contentFromUsername = YY.otZ;
                        Gx.field_contentNickname = YY.nickname;
                        Gx.field_contentVerifyContent = YY.content;
                        x.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + Gx.field_contentFromUsername + "new friend Nickname: " + Gx.field_contentNickname);
                    }
                    Gx.field_lastModifiedTime = System.currentTimeMillis();
                    Gx.field_state = 0;
                    Gx.field_talker = atVar.field_talker;
                    Gx.field_encryptTalker = atVar.field_encryptTalker;
                    Gx.field_fmsgSysRowId = j;
                    Gx.field_fmsgIsSend = atVar.field_isSend;
                    Gx.field_fmsgType = atVar.field_type;
                    Gx.field_fmsgContent = atVar.field_msgContent;
                    Gx.field_recvFmsgType = atVar.clS() ? atVar.field_type : 0;
                    x.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + Gx.field_fmsgContent);
                    ((as) ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcW()).b(Gx);
                } else {
                    x.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + atVar.field_talker);
                    if (atVar.clS()) {
                        Gx.field_isNew = 1;
                    }
                    Gx.field_lastModifiedTime = System.currentTimeMillis();
                    Gx.field_encryptTalker = atVar.field_encryptTalker;
                    Gx.field_fmsgSysRowId = j;
                    Gx.field_fmsgIsSend = atVar.field_isSend;
                    Gx.field_fmsgType = atVar.field_type;
                    Gx.field_fmsgContent = atVar.field_msgContent;
                    if (atVar.clS()) {
                        Gx.field_recvFmsgType = atVar.field_type;
                        x.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + Gx.field_recvFmsgType);
                    }
                    if (atVar.field_type == 0) {
                        YV = bd.a.YV(atVar.field_msgContent);
                        Gx.field_contentFromUsername = YV.otZ;
                        Gx.field_contentNickname = YV.nickname;
                        Gx.field_contentPhoneNumMD5 = YV.tbE;
                        Gx.field_contentFullPhoneNumMD5 = YV.tbF;
                        x.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + Gx.field_contentFromUsername + "new friend Nickname: " + Gx.field_contentNickname);
                    } else if (atVar.clS()) {
                        if ((atVar.field_isSend >= 2 ? 1 : 0) == 0) {
                            YY = d.YY(atVar.field_msgContent);
                            Gx.field_contentVerifyContent = YY.content;
                            Gx.field_contentFromUsername = YY.otZ;
                            Gx.field_contentNickname = YY.nickname;
                            x.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + Gx.field_contentVerifyContent + " receive, new friend Username: " + Gx.field_contentFromUsername + " new friend Nickname: " + Gx.field_contentNickname);
                            String str2 = Gx.field_contentFromUsername;
                            String str3 = Gx.field_contentNickname;
                            b klVar = new kl();
                            klVar.bUL.userName = str2;
                            klVar.bUL.bgn = str3;
                            klVar.bUL.type = 1;
                            com.tencent.mm.sdk.b.a.sFg.m(klVar);
                        }
                    }
                    ((as) ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcW()).c(Gx, new String[0]);
                    if (clP() == 0) {
                        g.Ei().DT().set(340225, Long.valueOf(System.currentTimeMillis()));
                    }
                }
                clR();
                return;
            }
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = " + j);
        } else {
            x.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        }
    }

    public final void clR() {
        ah.M(this.tbk);
        ah.i(this.tbk, 500);
    }

    public final boolean m(long j, String str) {
        String str2;
        x.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", Long.valueOf(j), str);
        if (!bi.oW(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + bi.oU(str) + "'";
        } else if (j <= 0) {
            return false;
        } else {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j + "'";
        }
        if (!this.diF.fV("fmessage_conversation", str2)) {
            return false;
        }
        x.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", Long.valueOf(j), str);
        Xp(str);
        return true;
    }
}
