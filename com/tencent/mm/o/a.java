package com.tencent.mm.o;

import android.content.Context;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static int dhT = -1;
    public static final long[] dhU = new long[]{17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L};
    public static final long[] dhV = new long[]{104857600, 314572800, 524288000, 1073741824, 1073741824};

    public static int BP() {
        long availableBlocks;
        long blockCount;
        long freeBlocks;
        int i;
        double d = 0.0d;
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                freeBlocks = ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
                d = ((double) availableBlocks) / ((double) blockCount);
            } catch (Exception e) {
                x.e("MicroMsg.DbChecker", "get db spare space error");
                freeBlocks = 0;
                blockCount = 0;
                if (blockCount > 0) {
                    if (availableBlocks < 52428800) {
                        i = 2;
                    } else {
                        if (dhT < 0) {
                            dhT = dhU.length - 1;
                            for (i = 0; i < dhU.length; i++) {
                                if (blockCount < dhU[i]) {
                                    dhT = i;
                                    break;
                                }
                            }
                        }
                        if (availableBlocks < dhV[dhT]) {
                            i = 1;
                        }
                    }
                    x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(dhT)});
                    return i;
                }
                i = 0;
                x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(dhT)});
                return i;
            }
        } catch (Exception e2) {
            availableBlocks = 0;
            x.e("MicroMsg.DbChecker", "get db spare space error");
            freeBlocks = 0;
            blockCount = 0;
            if (blockCount > 0) {
                if (availableBlocks < 52428800) {
                    i = 2;
                } else {
                    if (dhT < 0) {
                        dhT = dhU.length - 1;
                        for (i = 0; i < dhU.length; i++) {
                            if (blockCount < dhU[i]) {
                                dhT = i;
                                break;
                            }
                        }
                    }
                    if (availableBlocks < dhV[dhT]) {
                        i = 1;
                    }
                }
                x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(dhT)});
                return i;
            }
            i = 0;
            x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(dhT)});
            return i;
        }
        if (blockCount > 0) {
            if (availableBlocks < 52428800) {
                i = 2;
            } else {
                if (dhT < 0) {
                    dhT = dhU.length - 1;
                    for (i = 0; i < dhU.length; i++) {
                        if (blockCount < dhU[i]) {
                            dhT = i;
                            break;
                        }
                    }
                }
                if (availableBlocks < dhV[dhT]) {
                    i = 1;
                }
            }
            x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(dhT)});
            return i;
        }
        i = 0;
        x.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[]{Integer.valueOf(i), Long.valueOf(availableBlocks), Long.valueOf(blockCount), Long.valueOf(freeBlocks), Double.valueOf(d), Integer.valueOf(dhT)});
        return i;
    }

    public static void b(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("db_check_tip_time", j).commit();
    }
}
