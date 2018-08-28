package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.d.a$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftReceiveUI$4 implements a$a {
    final /* synthetic */ CardGiftReceiveUI hEd;

    CardGiftReceiveUI$4(CardGiftReceiveUI cardGiftReceiveUI) {
        this.hEd = cardGiftReceiveUI;
    }

    public final void aY(String str, int i) {
        if (CardGiftReceiveUI.b(this.hEd) == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
        } else if (bi.oW(str) || bi.oW(CardGiftReceiveUI.b(this.hEd).hvp) || !str.equals(CardGiftReceiveUI.b(this.hEd).hvp)) {
            CardGiftReceiveUI.g(this.hEd).post(new 1(this));
        } else {
            x.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
        }
    }

    public final void fail(String str) {
        x.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:" + str);
    }

    public final void cf(final String str, final String str2) {
        x.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:" + str);
        if (CardGiftReceiveUI.b(this.hEd) == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
        } else if (bi.oW(str) || bi.oW(CardGiftReceiveUI.b(this.hEd).hvp) || !str.equals(CardGiftReceiveUI.b(this.hEd).hvp)) {
            CardGiftReceiveUI.g(this.hEd).post(new Runnable() {
                public final void run() {
                    if (CardGiftReceiveUI.f(CardGiftReceiveUI$4.this.hEd).getVisibility() != 8) {
                        CardGiftReceiveUI.f(CardGiftReceiveUI$4.this.hEd).setVisibility(8);
                    }
                    if (bi.oW(str) || bi.oW(CardGiftReceiveUI.b(CardGiftReceiveUI$4.this.hEd).hvq) || !str.equals(CardGiftReceiveUI.b(CardGiftReceiveUI$4.this.hEd).hvq)) {
                        CardGiftReceiveUI.h(CardGiftReceiveUI$4.this.hEd).setVisibility(8);
                    } else {
                        CardGiftReceiveUI.h(CardGiftReceiveUI$4.this.hEd).setVisibility(0);
                    }
                    Bitmap oQ = y.oQ(str2);
                    if (oQ == null) {
                        CardGiftReceiveUI.i(CardGiftReceiveUI$4.this.hEd).setImageResource(f.download_image_icon);
                    } else {
                        CardGiftReceiveUI.i(CardGiftReceiveUI$4.this.hEd).setImageBitmap(oQ);
                    }
                }
            });
        } else {
            x.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
        }
    }
}
