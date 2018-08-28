package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends i<k> implements a {
    public static final String[] diD = new String[]{i.a(k.dhO, "EmotionRewardInfo")};
    public e diF;

    public l(e eVar) {
        super(eVar, k.dhO, "EmotionRewardInfo", null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final adj ZF(String str) {
        adj adj = null;
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.diF.a("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                try {
                    adj adj2 = new adj();
                    adj2.aG(a.getBlob(0));
                    adj = adj2;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[]{bi.i(e)});
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return adj;
    }
}
