package com.tencent.mm.plugin.game.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class b extends i<a> {
    public static final String[] diD = new String[]{i.a(a.dzU, "WepkgPreloadFiles")};
    private static volatile b kdT = null;
    private final h dCZ;
    public final boolean fAQ;

    public static b aVn() {
        if (!g.Eg().Dx()) {
            return new b(null);
        }
        if (kdT == null) {
            synchronized (b.class) {
                if (kdT == null || !kdT.fAQ) {
                    kdT = new b(g.Ei().dqq);
                }
            }
        }
        return kdT;
    }

    private b(h hVar) {
        super(hVar, a.dzU, "WepkgPreloadFiles", a.ciG);
        this.dCZ = hVar;
        this.fAQ = hVar != null;
        if (!this.fAQ) {
            x.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
    }

    public final a de(String str, String str2) {
        if (!this.fAQ || bi.oW(str) || bi.oW(str2)) {
            return null;
        }
        String di = d.di(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "key"}), new String[]{di});
        if (rawQuery.moveToFirst()) {
            a aVar = new a();
            aVar.d(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[]{aVar.field_pkgId, aVar.field_rid, aVar.field_version});
            return aVar;
        }
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[]{str, str2});
        rawQuery.close();
        return null;
    }

    public final List<WepkgPreloadFile> DT(String str) {
        List<WepkgPreloadFile> list = null;
        if (this.fAQ && !bi.oW(str)) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "pkgId"}), new String[]{str});
            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    a aVar = new a();
                    aVar.d(rawQuery);
                    wepkgPreloadFile.a(aVar);
                    list.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            }
        }
        return list;
    }

    public final boolean DU(String str) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        a aVar = new a();
        aVar.field_pkgId = str;
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.a(aVar, new String[]{"pkgId"}))});
        return super.a(aVar, new String[]{"pkgId"});
    }

    public final boolean d(String str, String str2, String str3, boolean z) {
        if (!this.fAQ || bi.oW(str) || bi.oW(str2)) {
            return false;
        }
        a de = de(str, str2);
        if (de == null) {
            return false;
        }
        de.field_completeDownload = z;
        de.field_filePath = str3;
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[]{str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(super.c(de, new String[0]))});
        return super.c(de, new String[0]);
    }
}
