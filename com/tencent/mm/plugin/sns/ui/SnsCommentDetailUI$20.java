package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;

class SnsCommentDetailUI$20 implements a {
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ View nUR;

    SnsCommentDetailUI$20(SnsCommentDetailUI snsCommentDetailUI, View view) {
        this.nUO = snsCommentDetailUI;
        this.nUR = view;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        if (!bi.oW(str)) {
            Bitmap decodeFile = c.decodeFile(str, null);
            if (decodeFile != null) {
                this.nUR.setVisibility(0);
                ImageView imageView = (ImageView) this.nUR.findViewById(f.sns_ad_card_header_avatar);
                imageView.setImageBitmap(decodeFile);
                imageView.setVisibility(0);
            }
        }
    }
}
