package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;
import junit.framework.Assert;

public final class h {
    public static String aY(String str, boolean z) {
        au.HU();
        String b = com.tencent.mm.sdk.platformtools.h.b(c.Ge(), "recbiz_", str, ".rec", 2);
        if (bi.oW(b)) {
            return null;
        }
        return (z || new File(b).exists()) ? b : b;
    }

    public static boolean op(String str) {
        if (str == null) {
            return false;
        }
        g Ok = Ok(str);
        if (Ok == null) {
            x.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + str);
            return true;
        }
        x.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + Ok.field_msglocalid);
        if (Ok.field_msglocalid != 0) {
            au.HU();
            c.FT().dX((long) Ok.field_msglocalid);
        }
        if (str == null) {
            return false;
        }
        d.bGt().jy(str);
        ol(str);
        return new File(aY(str, false)).delete();
    }

    static void ol(String str) {
        d.bGt().ol(aY(str, false));
    }

    public static g Ok(String str) {
        k bGt = d.bGt();
        g gVar = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor b = bGt.diF.b(str2, new String[]{str}, 2);
        if (b.moveToFirst()) {
            gVar = new g();
            gVar.d(b);
        }
        b.close();
        return gVar;
    }

    public static boolean nP(String str) {
        boolean z = false;
        if (str != null) {
            g Ok = Ok(str);
            if (Ok == null) {
                x.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + str);
            } else {
                Ok.field_status = 98;
                Ok.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Ok.bWA = 320;
                z = a(Ok);
                x.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + Ok.field_msglocalid + " old stat:" + Ok.field_status);
                if (Ok.field_msglocalid == 0 || bi.oW(Ok.field_user)) {
                    x.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + Ok.field_msglocalid + " user:" + Ok.field_user);
                } else {
                    au.HU();
                    bd dW = c.FT().dW((long) Ok.field_msglocalid);
                    dW.setMsgId((long) Ok.field_msglocalid);
                    dW.setStatus(5);
                    dW.ep(Ok.field_user);
                    dW.setContent(f.b(Ok.field_human, -1, true));
                    au.HU();
                    c.FT().a(dW.field_msgId, dW);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        if (gVar == null || gVar.bWA == -1) {
            return false;
        }
        k bGt = d.bGt();
        Assert.assertTrue(gVar.field_filename.length() > 0);
        Assert.assertTrue(gVar != null);
        ContentValues wH = gVar.wH();
        if (wH.size() <= 0) {
            x.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
            return false;
        }
        if (bGt.diF.update("VoiceRemindInfo", wH, "filename= ?", new String[]{r4}) <= 0) {
            return false;
        }
        bGt.doNotify();
        return true;
    }

    public static c Ol(String str) {
        k bGt = d.bGt();
        String aY = aY(str, false);
        if (bGt.orF.get(aY) == null) {
            bGt.orF.put(aY, new c(aY));
        }
        return (c) bGt.orF.get(aY);
    }
}
