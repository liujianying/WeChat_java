package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class g$108 implements i {
    final /* synthetic */ String jGH;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjV;

    g$108(g gVar, String str, String str2, i iVar) {
        this.qiK = gVar;
        this.jGH = str;
        this.qjV = str2;
        this.qiH = iVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        if (bitmap == null || objArr == null || objArr.length <= 0) {
            g.a(this.qiK, this.qiH, "shareEmoticon:fail", null);
        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
            g.a(this.qiK, this.qiH, "shareEmoticon:fail", null);
        } else if (str.equals(this.jGH)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                String m = g.m(file);
                au.HU();
                FileOp.y(file.getAbsolutePath(), EmojiLogic.L(c.Gg(), "", m));
                g.a(this.qiK, m, this.qjV);
                return;
            }
            g.a(this.qiK, this.qiH, "shareEmoticon:fail", null);
        } else {
            g.a(this.qiK, this.qiH, "shareEmoticon:fail", null);
        }
    }
}
