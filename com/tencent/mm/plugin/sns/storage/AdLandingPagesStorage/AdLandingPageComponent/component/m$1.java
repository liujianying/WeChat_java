package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements a {
    final /* synthetic */ m nDK;

    m$1(m mVar) {
        this.nDK = mVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            m mVar = this.nDK;
            if (decodeFile == null) {
                x.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            } else if (mVar.nDJ == null) {
                x.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            } else if (decodeFile.getWidth() == 0) {
                x.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
            } else {
                mVar.nDJ.setImageBitmap(decodeFile);
            }
        } catch (Throwable e) {
            x.e("AdLandingPageCircleImgComp", "%s" + bi.i(e));
        }
    }
}
