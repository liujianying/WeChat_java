package com.tencent.mm.plugin.normsg.b;

import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class f {
    private static String[] lGX = new String[]{IR(ad.getContext().getFilesDir().getParent() + "/dumeq/tekcos/ved/"), IR(ad.getContext().getFilesDir().getParent() + "/epip_umeq/ved/")};
    private static String[] lGY = new String[]{IR(ad.getContext().getFilesDir().getParent() + "/hsifdlog")};
    private static String[] lGZ = new String[]{IR(ad.getContext().getFilesDir().getParent() + "/os.umeq_gubed_collam_cbil/bil/metsys/"), IR(ad.getContext().getFilesDir().getParent() + "/ecart_umeq/sys/"), IR(ad.getContext().getFilesDir().getParent() + "/sporp-umeq/nib/metsys/")};
    public static boolean lHa;
    public static boolean lHb;
    public static boolean lHc;

    static {
        Throwable th;
        InputStream inputStream;
        lHa = false;
        lHb = false;
        lHc = false;
        for (String file : lGX) {
            if (new File(file).exists()) {
                lHa = true;
                break;
            }
        }
        File file2 = new File("/proc/tty/drivers");
        if (file2.exists() && file2.canRead() && file2.length() > 0) {
            String str;
            byte[] bArr = new byte[((int) file2.length())];
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e22) {
                    }
                }
                throw th;
            }
            str = new String(bArr);
            while (r0 < r4) {
                if (str.contains(r5)) {
                    lHb = true;
                    break;
                }
            }
        }
        while (r0 < r3) {
            if (new File(r2).exists()) {
                lHc = true;
                return;
            }
        }
    }

    private static String IR(String str) {
        String[] strArr = new String[]{ad.getContext().getFilesDir().getParent(), str, f.class.toString()};
        return new StringBuilder(strArr[1].substring(strArr[0].length() + 1)).reverse().toString();
    }
}
