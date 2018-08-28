package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class l extends i<k> {
    public static final String[] diD = new String[]{i.a(k.dhO, "BackupRecoverMsgListDataId")};
    private e diF;

    public final /* bridge */ /* synthetic */ boolean a(long j, c cVar) {
        return super.a(j, (k) cVar);
    }

    public l(h hVar) {
        super(hVar, k.dhO, "BackupRecoverMsgListDataId", null);
        this.diF = hVar;
    }

    public final String XI(String str) {
        String str2 = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + str + "\" ";
        x.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:" + str2);
        Cursor rawQuery = this.diF.rawQuery(str2, null);
        if (rawQuery == null) {
            x.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", new Object[]{str});
            return null;
        } else if (rawQuery.moveToFirst()) {
            k kVar = new k();
            kVar.d(rawQuery);
            rawQuery.close();
            return kVar.field_sessionName;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final HashMap<String, String> cku() {
        HashMap<String, String> hashMap = new HashMap();
        Cursor axc = axc();
        if (axc == null) {
            x.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
        } else {
            while (axc.moveToNext()) {
                k kVar = new k();
                kVar.d(axc);
                hashMap.put(kVar.field_msgListDataId, kVar.field_sessionName);
            }
            axc.close();
        }
        return hashMap;
    }

    public final boolean ckv() {
        String str = "SELECT * FROM BackupRecoverMsgListDataId";
        x.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:" + str);
        Cursor rawQuery = this.diF.rawQuery(str, null);
        if (rawQuery == null) {
            x.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
            return false;
        } else if (rawQuery.getCount() <= 0) {
            x.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
            rawQuery.close();
            return false;
        } else {
            rawQuery.close();
            return true;
        }
    }

    public final int ckw() {
        int i = 0;
        String str = "SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ";
        x.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:" + str);
        Cursor rawQuery = this.diF.rawQuery(str, null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public final boolean ckt() {
        x.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", new Object[]{Boolean.valueOf(this.diF.fV("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId"))});
        return this.diF.fV("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    }
}
