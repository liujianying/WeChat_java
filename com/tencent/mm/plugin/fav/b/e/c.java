package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<f> implements t {
    private e diF;

    public final /* synthetic */ boolean a(f fVar) {
        return super.b(fVar);
    }

    public final /* synthetic */ boolean a(f fVar, String[] strArr) {
        return super.c(fVar, strArr);
    }

    public c(e eVar) {
        super(eVar, f.dhO, "FavEditInfo", null);
        this.diF = eVar;
        this.diF.fV("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
    }

    public final f dx(long j) {
        f fVar = null;
        Cursor b = this.diF.b("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j), "0"}, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                fVar = new f();
                fVar.d(b);
            }
            b.close();
        }
        return fVar;
    }

    public final void q(long j, int i) {
        this.diF.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(j), String.valueOf(i)});
    }

    public final List<f> aLy() {
        Cursor b = this.diF.b("select count(*) from FavEditInfo", null, 2);
        if (b == null) {
            x.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
            return null;
        }
        try {
            if (b.moveToFirst()) {
                x.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", new Object[]{Integer.valueOf(b.getInt(0))});
            }
            b.close();
            b = this.diF.b("select * from FavEditInfo", null, 2);
            if (b == null) {
                return null;
            }
            List<f> arrayList = new ArrayList();
            try {
                if (b.moveToFirst()) {
                    do {
                        f fVar = new f();
                        fVar.d(b);
                        arrayList.add(fVar);
                    } while (b.moveToNext());
                }
                b.close();
                return arrayList;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e, "", new Object[0]);
                b.close();
                return null;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e2, "", new Object[0]);
            b.close();
            return null;
        }
    }
}
