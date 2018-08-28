package com.tencent.mm.compatible.util;

import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class f {
    public static boolean zZ() {
        boolean z = false;
        String absolutePath = h.getExternalStorageDirectory().getAbsolutePath();
        if (e.bnC.equalsIgnoreCase(absolutePath)) {
            try {
                if (h.getExternalStorageState().equals("mounted") && new File(absolutePath).canWrite()) {
                    return true;
                }
                return z;
            } catch (Exception e) {
                x.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e.getMessage() + " SDCARD_ROOT: " + e.bnC);
                return z;
            }
        }
        try {
            return new File(e.bnC).canWrite();
        } catch (Exception e2) {
            x.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + e.bnC);
            return z;
        }
    }

    public static boolean Aa() {
        Exception e;
        if (!zZ()) {
            return false;
        }
        StatFs statFs;
        long blockCount;
        long j;
        long j2;
        try {
            statFs = new StatFs(e.bnC);
            try {
                blockCount = (long) statFs.getBlockCount();
            } catch (Exception e2) {
                e = e2;
                j = 0;
                blockCount = 0;
                x.e("MicroMsg.CUtil", "checkSDCardFull", e);
                j2 = 0;
                return statFs == null ? false : false;
            }
            try {
                j = (long) statFs.getAvailableBlocks();
                try {
                    j2 = (long) statFs.getBlockSize();
                } catch (Exception e3) {
                    e = e3;
                    x.e("MicroMsg.CUtil", "checkSDCardFull", e);
                    j2 = 0;
                    if (statFs == null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                j = 0;
                x.e("MicroMsg.CUtil", "checkSDCardFull", e);
                j2 = 0;
                if (statFs == null) {
                }
            }
        } catch (Exception e5) {
            e = e5;
            j = 0;
            blockCount = 0;
            statFs = null;
            x.e("MicroMsg.CUtil", "checkSDCardFull", e);
            j2 = 0;
            if (statFs == null) {
            }
        }
        if (statFs == null || blockCount <= 0 || blockCount - j < 0) {
            return false;
        }
        long j3 = j2 * blockCount;
        x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(blockCount), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2 * j), Integer.valueOf((int) (((blockCount - j) * 100) / blockCount)));
        if (95 > ((int) (((blockCount - j) * 100) / blockCount)) || r6 > 314572800) {
            return false;
        }
        x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
        return true;
    }

    public static boolean aM(long j) {
        long blockCount;
        Exception e;
        long j2;
        if (zZ()) {
            StatFs statFs;
            long availableBlocks;
            try {
                statFs = new StatFs(e.bnC);
                try {
                    blockCount = (long) statFs.getBlockCount();
                    try {
                        availableBlocks = (long) statFs.getAvailableBlocks();
                    } catch (Exception e2) {
                        e = e2;
                        j2 = blockCount;
                        x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                        availableBlocks = 0;
                        blockCount = j2;
                        return statFs != null ? false : false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    j2 = 0;
                    x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                    availableBlocks = 0;
                    blockCount = j2;
                    if (statFs != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                statFs = null;
                j2 = 0;
                x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                availableBlocks = 0;
                blockCount = j2;
                if (statFs != null) {
                }
            }
            if (statFs != null || blockCount <= 0 || blockCount - availableBlocks < 0) {
                return false;
            }
            if (((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize()) >= j) {
                return true;
            }
            x.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + j + " not enough and ret false");
            return false;
        }
        x.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
        return false;
    }
}
