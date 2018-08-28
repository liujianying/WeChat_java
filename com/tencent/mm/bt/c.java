package com.tencent.mm.bt;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class c {
    private static int index = 0;
    private static boolean on = false;
    private static a tdp = null;
    private static long tdq = 0;
    private static int tdr = 0;

    public static void k(Exception exception) {
        if (on) {
            x.e("MicroMsg.DKTest", "exception:%s", bi.i(exception));
        }
    }

    static void begin() {
        if (on) {
            tdp = new a();
            index++;
        }
    }

    private static void q(Cursor cursor) {
        if (on && cursor != null) {
            tdr = cursor.getCount();
            a aVar = new a();
            for (int i = 0; i < tdr; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            tdq = aVar.Ad();
        }
    }

    static void a(String str, Cursor cursor, long j) {
        if (on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + tdp.Ad() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                q(cursor);
                str2 = str2 + "[cuCnt:" + tdr + ",cuTime:" + tdq + "]";
            }
            str2 = str2 + "[" + str + "]--";
            x.v("MicroMsg.dbtest", str2 + bi.cjd());
        }
    }
}
