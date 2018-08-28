package com.tencent.mm.plugin.readerapp.ui;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a;
import com.tencent.mm.sdk.platformtools.bi;

class ReaderAppUI$a$1 implements ImageGetter {
    final /* synthetic */ a mnZ;

    ReaderAppUI$a$1(a aVar) {
        this.mnZ = aVar;
    }

    public final Drawable getDrawable(String str) {
        Drawable drawable = this.mnZ.mnQ.getResources().getDrawable(bi.getInt(str, 0));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }
}
