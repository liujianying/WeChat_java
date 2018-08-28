package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class AddFavoriteUI$12 extends ag {
    final /* synthetic */ AddFavoriteUI uvB;

    AddFavoriteUI$12(AddFavoriteUI addFavoriteUI) {
        this.uvB = addFavoriteUI;
    }

    public final void handleMessage(Message message) {
        AddFavoriteUI.d(this.uvB);
        if (bi.oW(this.uvB.filePath) || (bi.Xh(this.uvB.filePath) && !AddFavoriteUI.aba(this.uvB.filePath))) {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
            AddFavoriteUI.g(this.uvB);
            this.uvB.finish();
            return;
        }
        AddFavoriteUI.h(this.uvB);
    }
}
