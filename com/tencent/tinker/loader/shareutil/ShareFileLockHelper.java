package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class ShareFileLockHelper implements Closeable {
    private final FileOutputStream vvt;
    private final FileLock vvu;

    private ShareFileLockHelper(File file) {
        this.vvt = new FileOutputStream(file);
        Throwable th = null;
        FileLock fileLock = null;
        int i = 0;
        while (i < 3) {
            i++;
            try {
                fileLock = this.vvt.getChannel().lock();
                if ((fileLock != null ? 1 : null) != null) {
                    break;
                }
                Thread.sleep(10);
            } catch (Throwable e) {
                th = e;
            }
        }
        if (fileLock == null) {
            throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), th);
        }
        this.vvu = fileLock;
    }

    public static ShareFileLockHelper ag(File file) {
        return new ShareFileLockHelper(file);
    }

    public void close() {
        try {
            if (this.vvu != null) {
                this.vvu.release();
            }
            if (this.vvt != null) {
                this.vvt.close();
            }
        } catch (Throwable th) {
            if (this.vvt != null) {
                this.vvt.close();
            }
        }
    }
}
