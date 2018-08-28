package com.tencent.mm.plugin.hp.d;

import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    @Deprecated
    public static boolean aWA() {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e) {
                blockSize = 0;
                if (blockSize != 0) {
                }
                return false;
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            blockSize = 0;
            if (blockSize != 0) {
            }
            return false;
        }
        if (blockSize != 0 || availableBlocks <= 83886080) {
            return false;
        }
        return true;
    }

    public static boolean EI(String str) {
        if (bi.oW(str) || str.length() != 10) {
            return false;
        }
        try {
            int intValue = Integer.decode(str).intValue();
            if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("Tinker.TinkerUtils", e, "checkAplhVersion failed.", new Object[0]);
            return false;
        }
    }

    public static String EJ(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return new String(Base64.decode(str, 0));
    }
}
