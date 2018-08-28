package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class w {
    public boolean nJO = false;

    public static boolean a(h hVar, h hVar2) {
        try {
            if (bi.oW(hVar.getKey())) {
                hVar2.fV("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old ");
            } else {
                hVar2.fV("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old KEY '" + hVar.getKey() + "'");
            }
            x.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + hVar.getKey());
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.TrimSnsDb", e, "", new Object[0]);
            return false;
        }
    }

    public static int a(h hVar, h hVar2, String str) {
        String str2 = null;
        Cursor b = hVar.b(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
        if (b != null) {
            if (b.getCount() == 1) {
                b.moveToFirst();
                str2 = b.getString(0);
            }
            b.close();
        }
        if (str2 == null) {
            x.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            return -1;
        }
        x.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[]{str2});
        x.i("MicroMsg.TrimSnsDb", "create result " + hVar2.fV("", str2));
        return 1;
    }

    public static void NI(String str) {
        List<FileEntry> H = FileOp.H(str, false);
        if (H != null) {
            for (FileEntry fileEntry : H) {
                if (fileEntry.name.startsWith("SnsMicroMsg.dberr")) {
                    x.i("MicroMsg.TrimSnsDb", "find error %s", new Object[]{str + fileEntry.name});
                    FileOp.deleteFile(str + fileEntry.name);
                }
            }
        }
    }
}
