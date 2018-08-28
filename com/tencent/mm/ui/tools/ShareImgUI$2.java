package com.tencent.mm.ui.tools;

import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class ShareImgUI$2 implements ShareImgUI$b {
    final /* synthetic */ ShareImgUI uBN;

    ShareImgUI$2(ShareImgUI shareImgUI) {
        this.uBN = shareImgUI;
    }

    public final void ah(ArrayList<String> arrayList) {
        this.uBN.uvy = arrayList;
        if (this.uBN.uvy == null || this.uBN.uvy.size() == 0) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
            ShareImgUI.b(this.uBN);
            this.uBN.finish();
            return;
        }
        Iterator it = this.uBN.uvy.iterator();
        while (it.hasNext()) {
            if (o.Wf((String) it.next())) {
                x.i("MicroMsg.ShareImgUI", "%s is not image", new Object[]{(String) it.next()});
                ShareImgUI.b(this.uBN);
                this.uBN.finish();
                return;
            }
        }
        String resolveType = this.uBN.getIntent().resolveType(this.uBN);
        if (resolveType == null || !resolveType.contains("image")) {
            x.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
            this.uBN.getIntent().setDataAndType(this.uBN.getIntent().getData(), "image/*");
        }
        ShareImgUI.c(this.uBN);
    }
}
