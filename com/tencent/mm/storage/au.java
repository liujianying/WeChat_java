package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class au extends i<at> implements d {
    public static final String[] diD = new String[]{i.a(at.dhO, "fmessage_msginfo")};
    private static final String[] tbj = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    public e diF;

    public au(e eVar) {
        super(eVar, at.dhO, "fmessage_msginfo", tbj);
        this.diF = eVar;
    }

    public final at[] YM(String str) {
        x.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor b = this.diF.b("select *, rowid from fmessage_msginfo  where talker = '" + bi.oU(str) + "' order by createTime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            at atVar = new at();
            atVar.d(b);
            arrayList.add(atVar);
        }
        b.close();
        return (at[]) arrayList.toArray(new at[arrayList.size()]);
    }

    public final at YN(String str) {
        at atVar = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
        } else {
            Cursor b = this.diF.b("select * from fmessage_msginfo where talker = '" + bi.oU(str) + "' order by createTime DESC limit 1", null, 2);
            atVar = new at();
            if (b.moveToFirst()) {
                atVar.d(b);
            }
            b.close();
        }
        return atVar;
    }

    public final at YO(String str) {
        at[] dc = dc(str, 1);
        if (dc == null || dc.length <= 0) {
            return null;
        }
        return dc[0];
    }

    public final at[] dc(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
            return null;
        }
        Cursor b = this.diF.b("select * from fmessage_msginfo where isSend != 1 and talker = '" + bi.oU(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            at atVar = new at();
            atVar.d(b);
            arrayList.add(atVar);
        }
        b.close();
        return (at[]) arrayList.toArray(new at[arrayList.size()]);
    }

    public final boolean b(at atVar) {
        if (atVar == null) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            return false;
        } else if (!super.b((c) atVar)) {
            return false;
        } else {
            Xp(atVar.sKx);
            return true;
        }
    }

    public final List<at> bdb() {
        x.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
        List arrayList = new ArrayList();
        Cursor b = this.diF.b("select *, rowid from fmessage_msginfo where type = 0", null, 2);
        while (b.moveToNext()) {
            at atVar = new at();
            atVar.d(b);
            arrayList.add(atVar);
        }
        b.close();
        x.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        return arrayList;
    }

    public final boolean Gy(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
            return false;
        }
        return this.diF.fV("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + bi.oU(str) + "'");
    }
}
