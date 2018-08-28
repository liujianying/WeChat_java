package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.o;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class u extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )"};
    public h dCZ;
    Map<String, a> epX = new HashMap();
    Map<String, l> epY = new HashMap();
    Map<String, h> epZ = new HashMap();

    public u(h hVar) {
        b(hVar);
        this.dCZ = hVar;
    }

    private static void b(h hVar) {
        Cursor b = hVar.b("PRAGMA table_info(voiceinfo)", null, 0);
        if (b == null) {
            x.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            return;
        }
        int columnIndex = b.getColumnIndex("name");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (b.moveToNext()) {
            if (columnIndex >= 0) {
                int i6;
                String string = b.getString(columnIndex);
                if ("MsgSource".equals(string)) {
                    i5 = 1;
                }
                if ("MsgFlag".equals(string)) {
                    i4 = 1;
                }
                if ("MsgSeq".equals(string)) {
                    i3 = 1;
                }
                if ("MasterBufId".equals(string)) {
                    i6 = 1;
                } else {
                    i6 = i2;
                }
                if ("checksum".equals(string)) {
                    i = 1;
                }
                i2 = i6;
            }
        }
        b.close();
        if (i5 == 0) {
            hVar.fV("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (i4 == 0) {
            hVar.fV("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (i3 == 0) {
            hVar.fV("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (i2 == 0) {
            hVar.fV("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
        if (i == 0) {
            hVar.fV("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
        }
    }

    public static String ov(String str) {
        return o.l(str, bi.VF());
    }

    public final boolean b(p pVar) {
        Assert.assertTrue(pVar != null);
        ContentValues wH = pVar.wH();
        if (wH.size() <= 0) {
            x.e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.dCZ.insert("voiceinfo", "FileName", wH) != -1) {
            doNotify();
            return true;
        }
        return false;
    }

    public final boolean jy(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.dCZ.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            x.w("MicroMsg.VoiceStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final boolean a(String str, p pVar) {
        boolean z;
        Assert.assertTrue(str.length() > 0);
        if (pVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues wH = pVar.wH();
        if (wH.size() <= 0) {
            x.e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.dCZ.update("voiceinfo", wH, "FileName= ?", new String[]{str}) > 0) {
                doNotify();
                return true;
            }
        }
        return false;
    }

    public final p bE(long j) {
        p pVar = null;
        Cursor b = this.dCZ.b("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgId=" + j, null, 2);
        if (b.moveToFirst()) {
            pVar = new p();
            pVar.d(b);
        }
        b.close();
        return pVar;
    }

    public final p iH(int i) {
        p pVar = null;
        Cursor b = this.dCZ.b("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgLocalId=" + i, null, 2);
        if (b.moveToFirst()) {
            pVar = new p();
            pVar.d(b);
        }
        b.close();
        return pVar;
    }

    public final p ow(String str) {
        p pVar = null;
        String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
        Cursor b = this.dCZ.b(str2, new String[]{str}, 2);
        if (b.moveToFirst()) {
            pVar = new p();
            pVar.d(b);
        }
        b.close();
        return pVar;
    }
}
