package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public interface q extends f {
    public static final String[] diD = new String[]{i.a(c.dhO, "FavCdnInfo")};

    c Br(String str);

    void a(p pVar);

    boolean a(c cVar, String... strArr);

    void aLt();

    LinkedList<c> aLu();

    Cursor aLv();

    Cursor aLw();

    void b(p pVar);

    boolean b(c cVar, String... strArr);

    List<c> dt(long j);

    List<c> du(long j);

    void dv(long j);

    boolean dw(long j);

    boolean e(c cVar);

    int p(long j, int i);

    void x(g gVar);
}
