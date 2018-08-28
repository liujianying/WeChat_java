package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends i<m> implements a {
    public static final String[] diD = new String[]{i.a(m.dhO, "EmotionRewardTipInfo")};
    private e diF;

    public n(e eVar) {
        this(eVar, m.dhO, "EmotionRewardTipInfo");
    }

    private n(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final m cnO() {
        Throwable e;
        Cursor b;
        try {
            b = this.diF.b("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0], 2);
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        m mVar = new m();
                        mVar.d(b);
                        if (b == null) {
                            return mVar;
                        }
                        b.close();
                        return mVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{bi.i(e)});
                        if (b != null) {
                            b.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (b != null) {
                            b.close();
                        }
                        throw e;
                    }
                }
            }
            if (b != null) {
                b.close();
            }
        } catch (Exception e3) {
            e = e3;
            b = null;
        } catch (Throwable th2) {
            e = th2;
            b = null;
            if (b != null) {
                b.close();
            }
            throw e;
        }
        return null;
    }

    public final boolean dg(String str, int i) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            return false;
        }
        x.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", new Object[]{Boolean.valueOf(this.diF.fV("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'"))});
        return this.diF.fV("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    public final boolean a(m mVar) {
        if (mVar == null) {
            x.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            return false;
        }
        long replace = this.diF.replace("EmotionRewardTipInfo", "prodcutID", mVar.wH());
        if (replace > 0) {
            x.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            x.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            return true;
        }
        return false;
    }
}
