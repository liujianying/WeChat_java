package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1 implements i {
    final /* synthetic */ String dUT;
    final /* synthetic */ String jGH;
    final /* synthetic */ a jGI;
    final /* synthetic */ c jGJ;
    final /* synthetic */ Context val$context;

    c$1(c cVar, String str, Context context, String str2, a aVar) {
        this.jGJ = cVar;
        this.jGH = str;
        this.val$context = context;
        this.dUT = str2;
        this.jGI = aVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.GameJsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        if (bitmap == null || objArr == null || objArr.length <= 0) {
            this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("addToEmoticon:fail", null));
        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
            this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("addToEmoticon:fail", null));
        } else if (str.equals(this.jGH)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                String m = g.m(file);
                au.HU();
                FileOp.y(file.getAbsolutePath(), EmojiLogic.L(c.Gg(), "", m));
                c.a(this.val$context, m, this.dUT, this.jGI);
                return;
            }
            this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("addToEmoticon:fail", null));
        } else {
            this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("addToEmoticon:fail", null));
        }
    }
}
