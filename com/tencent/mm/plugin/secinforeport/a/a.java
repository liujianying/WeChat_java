package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class a {
    public static final int mOt = 1;
    private static b mOu = new 1();
    private static final /* synthetic */ int[] mOv = new int[]{mOt};

    public static void a(b bVar) {
        if (bVar != null) {
            mOu = bVar;
        }
    }

    public static void f(int i, String str, int i2) {
        x.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        mOu.a(i, str, i2, null);
    }

    public static void s(int i, String str, String str2) {
        x.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[]{Integer.valueOf(5), Integer.valueOf(i), str, str2});
        ats ats = new ats();
        ats.bPS = str;
        ats.rWX = str2;
        byte[] bArr = null;
        try {
            bArr = ats.toByteArray();
        } catch (IOException e) {
            x.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[]{e.getMessage()});
        }
        mOu.a(5, "", i, bArr);
    }
}
