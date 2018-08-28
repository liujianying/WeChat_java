package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public final class e {
    private String charset = "UTF-8";
    public WepkgVersion kff;
    private d kfp;
    public Map<String, WepkgPreloadFile> kfq;

    public e(WepkgVersion wepkgVersion, d dVar, Map<String, WepkgPreloadFile> map) {
        this.kff = wepkgVersion;
        this.kfp = dVar;
        this.kfq = map;
        if (wepkgVersion != null && !bi.oW(wepkgVersion.charset)) {
            this.charset = wepkgVersion.charset;
        }
    }

    public final m Eg(String str) {
        if (bi.oW(str)) {
            return null;
        }
        if (!(this.kfq == null || this.kfq.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.kfq.get(str);
            if (!bi.oW(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    try {
                        x.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s", new Object[]{str});
                        return new m(wepkgPreloadFile.mimeType, this.charset, new FileInputStream(file));
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        return this.kfp != null ? this.kfp.df(str, this.charset) : null;
    }
}
