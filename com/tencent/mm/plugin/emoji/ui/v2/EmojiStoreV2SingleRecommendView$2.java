package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class EmojiStoreV2SingleRecommendView$2 extends c<cu> {
    final /* synthetic */ EmojiStoreV2SingleRecommendView irH;

    EmojiStoreV2SingleRecommendView$2(EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView) {
        this.irH = emojiStoreV2SingleRecommendView;
        this.sFo = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        if (cuVar instanceof cu) {
            EmojiStoreV2SingleRecommendView.a(this.irH, cuVar.bKj.bKl);
            if (!bi.oW(cuVar.bKj.bKk) && cuVar.bKj.bKk.equalsIgnoreCase(EmojiStoreV2SingleRecommendView.c(this.irH))) {
                EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = this.irH;
                String str = cuVar.bKj.bKk;
                int i = cuVar.bKj.status;
                int i2 = cuVar.bKj.progress;
                String str2 = cuVar.bKj.bKl;
                x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
                if (i == 6) {
                    Message obtain = Message.obtain();
                    obtain.getData().putString("product_id", str);
                    obtain.getData().putInt("progress", i2);
                    obtain.what = 131075;
                    emojiStoreV2SingleRecommendView.m(obtain);
                } else {
                    x.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", new Object[]{Integer.valueOf(i)});
                    Message obtain2 = Message.obtain();
                    obtain2.getData().putString("product_id", str);
                    obtain2.getData().putInt(DownloadInfo.STATUS, i);
                    obtain2.what = 131076;
                    emojiStoreV2SingleRecommendView.m(obtain2);
                }
            }
        }
        return false;
    }
}
