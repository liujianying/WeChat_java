package com.tencent.smtt.sdk;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class a {
    public static int a = Downloads.DOWNLOAD_ERR_INTERRUPTED;
    private static int b = 0;

    public static int a() {
        Throwable th;
        int i = 0;
        if (b > 0) {
            return b;
        }
        BufferedReader bufferedReader;
        try {
            int indexOf;
            String readLine;
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        indexOf = readLine.indexOf("MemTotal:");
                    }
                    break;
                } catch (IOException e) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                        }
                    }
                    b = i;
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } while (-1 == indexOf);
            readLine = readLine.substring(indexOf + 9).trim();
            if (readLine != null && readLine.length() != 0 && readLine.contains("k")) {
                i = Integer.parseInt(readLine.substring(0, readLine.indexOf("k")).trim()) / 1024;
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
            }
        } catch (IOException e5) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e22) {
                }
            }
            b = i;
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e32) {
                }
            }
            throw th;
        }
        b = i;
        return i;
    }
}
