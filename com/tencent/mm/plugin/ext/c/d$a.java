package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.ext.c.d.c;
import com.tencent.mm.sdk.platformtools.x;

public class d$a implements c {
    public final d$b ar(String str, boolean z) {
        if (FileOp.cn(str)) {
            return d.c(FileOp.e(str, 0, -1), z);
        }
        x.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
        return null;
    }
}
