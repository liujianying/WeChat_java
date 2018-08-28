package com.tencent.mm.plugin.emoji.ui.fts;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class FTSEmojiDetailPageUI$10 implements i {
    final /* synthetic */ FTSEmojiDetailPageUI ioG;

    FTSEmojiDetailPageUI$10(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.ioG = fTSEmojiDetailPageUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(FTSEmojiDetailPageUI.a(this.ioG).field_encrypturl)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                FTSEmojiDetailPageUI.a(this.ioG).field_md5 = g.m(file);
                FTSEmojiDetailPageUI fTSEmojiDetailPageUI = this.ioG;
                au.HU();
                FTSEmojiDetailPageUI.a(fTSEmojiDetailPageUI, EmojiLogic.L(c.Gg(), "", FTSEmojiDetailPageUI.a(this.ioG).field_md5));
                FileOp.y(file.getAbsolutePath(), FTSEmojiDetailPageUI.e(this.ioG));
                ah.A(new 1(this));
            }
        }
    }
}
