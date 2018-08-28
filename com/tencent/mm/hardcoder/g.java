package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class g {

    public interface a {
        boolean fx(String str);
    }

    public static void a(InputStream inputStream, a aVar) {
        Exception e;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String readLine;
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                    }
                    break;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.HardCoderUtil", "exception:" + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                x.e("MicroMsg.HardCoderUtil", "exception:" + e3.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                x.e("MicroMsg.HardCoderUtil", "exception:" + e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } while (aVar.fx(readLine));
            try {
                bufferedReader.close();
            } catch (Exception e32) {
                x.e("MicroMsg.HardCoderUtil", "exception:" + e32.getMessage());
            }
        } catch (Exception e5) {
            e32 = e5;
            bufferedReader = null;
            x.e("MicroMsg.HardCoderUtil", "exception:" + e32.getMessage());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e322) {
                    x.e("MicroMsg.HardCoderUtil", "exception:" + e322.getMessage());
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e42) {
                    x.e("MicroMsg.HardCoderUtil", "exception:" + e42.getMessage());
                }
            }
            throw th;
        }
    }
}
