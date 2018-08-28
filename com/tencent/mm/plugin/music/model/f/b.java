package com.tencent.mm.plugin.music.model.f;

import android.database.Cursor;
import com.tencent.mm.an.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<f> {
    public e diF;
    public com.tencent.mm.a.f<String, f> lzX = new com.tencent.mm.a.f(20);

    public b(e eVar) {
        super(eVar, f.dhO, "PieceMusicInfo", null);
        this.diF = eVar;
    }

    public final f ID(String str) {
        if (this.lzX.get(str) != null) {
            return (f) this.lzX.get(str);
        }
        String format = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
        Cursor b = this.diF.b(format, new String[]{str}, 2);
        if (b == null || !b.moveToFirst()) {
            if (b != null) {
                b.close();
            }
            return null;
        }
        f fVar = new f();
        fVar.d(b);
        b.close();
        this.lzX.put(str, fVar);
        return fVar;
    }
}
