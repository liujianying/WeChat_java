package com.tencent.mm.bt;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public final class b {
    static String cnQ() {
        Exception e;
        Throwable th;
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String str = "";
        String str2 = "";
        String str3 = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            try {
                Pattern compile = Pattern.compile("\\s+");
                while (true) {
                    CharSequence readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = compile.split(readLine);
                    if (split.length >= 3 && split[1].equals(absolutePath)) {
                        str = split[2];
                        if (split.length > 3) {
                            str3 = split[3];
                        }
                    }
                }
                if (new StatFs(absolutePath).getBlockSize() > 0) {
                    str2 = String.format("blockSize: %d, blocks: %d / %d", new Object[]{Integer.valueOf(new StatFs(absolutePath).getBlockSize()), Integer.valueOf(new StatFs(absolutePath).getAvailableBlocks()), Integer.valueOf(new StatFs(absolutePath).getBlockCount())});
                }
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return str + 10 + str2 + 10 + str3;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            x.e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e42) {
                }
            }
            return str + 10 + str2 + 10 + str3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e52) {
                }
            }
            throw th;
        }
        return str + 10 + str2 + 10 + str3;
    }
}
