package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final String[] qyy = new String[]{"retCode", "url"};

    public static MatrixCursor BA(int i) {
        x.i("MicroMsg.ExtCommonUtils", "returnMatrix = " + i);
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.iJr);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i)});
        return matrixCursor;
    }

    public static MatrixCursor SI(String str) {
        x.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
        MatrixCursor matrixCursor = new MatrixCursor(qyy);
        matrixCursor.addRow(new Object[]{Integer.valueOf(4207), str});
        return matrixCursor;
    }
}
