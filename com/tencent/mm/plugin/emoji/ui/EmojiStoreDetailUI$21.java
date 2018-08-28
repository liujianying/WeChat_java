package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.bp.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreDetailUI$21 implements i {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$21(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (bitmap != null && objArr != null && objArr.length > 0 && EmojiStoreDetailUI.o(this.inz) != null) {
            Object obj;
            int intValue = ((Integer) objArr[0]).intValue();
            au.HU();
            String K = EmojiLogic.K(c.Gg(), EmojiStoreDetailUI.a(this.inz), str);
            String a = EmojiStoreDetailUI.a(this.inz);
            String str2 = ((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(intValue)).sbC;
            a.getDensity(EmojiStoreDetailUI.p(this.inz));
            EmojiInfo a2 = EmojiLogic.a(a, 8, str2, true);
            e aDM = e.aDM();
            if (com.tencent.mm.a.e.cn(K)) {
                long currentTimeMillis = System.currentTimeMillis();
                int cm = com.tencent.mm.a.e.cm(K);
                int i = cm > 1024 ? 1024 : cm;
                Object e = com.tencent.mm.a.e.e(K, 0, cm);
                Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.e(K, 0, i), aDM.aDN().getBytes(), true, false);
                if (bi.bC(aesCryptEcb) || bi.bC(e)) {
                    i = -1;
                } else {
                    System.arraycopy(aesCryptEcb, 0, e, 0, i);
                    i = com.tencent.mm.a.e.b(K, e, cm);
                }
                if (i == 0) {
                    h.mEJ.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                    h.mEJ.a(252, 6, 1, false);
                    x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(e.length), Long.valueOf(r10)});
                    obj = 1;
                } else {
                    x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    h.mEJ.a(252, 3, 1, false);
                    obj = null;
                }
            } else {
                x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file do no exsit.");
                obj = null;
            }
            if (a2 != null) {
                if (obj != null) {
                    a2.field_reserved4 = EmojiInfo.tcW;
                } else {
                    a2.field_reserved4 = 0;
                }
                EmojiStoreDetailUI.o(this.inz).post(new 1(this, a2, intValue));
                return;
            }
            x.i("MicroMsg.emoji.EmojiStoreDetailUI", "ignore no call back preview loader. ");
        }
    }
}
