package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class EmojiStoreV2SingleRecommendView$1 extends ag {
    final /* synthetic */ EmojiStoreV2SingleRecommendView irH;

    EmojiStoreV2SingleRecommendView$1(EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView) {
        this.irH = emojiStoreV2SingleRecommendView;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 131075:
                int i = message.getData().getInt("progress");
                if (bi.oW(message.getData().getString("product_id"))) {
                    x.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                    return;
                }
                if (EmojiStoreV2SingleRecommendView.a(this.irH) != null) {
                    EmojiStoreV2SingleRecommendView.a(this.irH).setVisibility(8);
                }
                if (EmojiStoreV2SingleRecommendView.b(this.irH) != null) {
                    EmojiStoreV2SingleRecommendView.b(this.irH).setVisibility(0);
                    EmojiStoreV2SingleRecommendView.b(this.irH).setProgress(i);
                    return;
                }
                return;
            case 131076:
                message.getData().getInt(DownloadInfo.STATUS);
                if (bi.oW(message.getData().getString("product_id"))) {
                    x.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                    return;
                }
                if (EmojiStoreV2SingleRecommendView.a(this.irH) != null) {
                    EmojiStoreV2SingleRecommendView.a(this.irH).setVisibility(0);
                }
                if (EmojiStoreV2SingleRecommendView.b(this.irH) != null) {
                    EmojiStoreV2SingleRecommendView.b(this.irH).setVisibility(8);
                    EmojiStoreV2SingleRecommendView.b(this.irH).setProgress(0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
