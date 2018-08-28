package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class b {
    private static final String lHF = (e.bnE + "FailMsgFileCache");

    public static void init() {
        x.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(lHF).mkdirs();
    }

    public static void a(int i, a aVar) {
        String str = null;
        if (i == 1) {
            str = lHF + File.separator + "normalMsg";
        } else if (i == 2) {
            str = lHF + File.separator + "snsMsg";
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            return;
        }
        x.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", new Object[]{str});
        String bkx = aVar.bkx();
        x.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", new Object[]{bkx});
        if (bi.oW(bkx)) {
            x.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
        } else {
            com.tencent.mm.a.e.b(str, bkx.getBytes(), bkx.length());
        }
    }

    public static a uf(int i) {
        String str;
        if (i == 1) {
            str = lHF + File.separator + "normalMsg";
        } else if (i == 2) {
            str = lHF + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            return null;
        }
        x.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", new Object[]{str});
        try {
            x.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", new Object[]{com.tencent.mm.a.e.ct(str)});
            a aVar = new a();
            aVar.IS(r2);
            return aVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            x.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static void ug(int i) {
        String str = null;
        if (i == 1) {
            str = lHF + File.separator + "normalMsg";
        } else if (i == 2) {
            str = lHF + File.separator + "snsMsg";
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            return;
        }
        x.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", new Object[]{str});
        if (com.tencent.mm.a.e.cn(str)) {
            new File(str).delete();
        }
    }
}
