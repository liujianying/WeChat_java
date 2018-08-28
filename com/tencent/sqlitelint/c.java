package com.tencent.sqlitelint;

import android.database.Cursor;

public interface c {
    void execSQL(String str);

    Cursor rawQuery(String str, String... strArr);
}
