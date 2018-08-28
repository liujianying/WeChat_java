package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class b {

    static class a implements Runnable {
        private File ixn;
        private String url;

        a(String str, File file) {
            this.url = str;
            this.ixn = file;
        }

        public final void run() {
            byte[] WY = bi.WY(this.url);
            if (WY != null) {
                FileOp.l(this.ixn.getAbsolutePath(), WY);
            }
        }

        public final String toString() {
            return super.toString() + "|DownloadRunnable";
        }
    }

    public static String Ab(String str) {
        if (bi.oW(str) || "#".equals(str)) {
            return "";
        }
        File file = new File(d.aHr(), ac.ce(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            x.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[]{e.toString()});
        }
        au.Em().H(new a(str, file));
        return "";
    }
}
