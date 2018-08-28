package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.ab;
import java.util.List;

public interface j {
    ab Co(String str);

    boolean Cp(String str);

    long Cq(String str);

    List<String> Cr(String str);

    Cursor h(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);
}
