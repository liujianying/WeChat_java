package com.tencent.mm.loader.stub;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;

public class b {
    public static String bnC = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String bnD = "/tencent/MicroMsg/";
    public static String bnE = (bnC + bnD);
    public static final String duM;
    public static final String duN = (duM + "MicroMsg/");
    public static final String duO = (duM + "files/public/");
    public static String duP = (bnE + "crash/");

    static {
        Context context = ad.getContext();
        if (context == null) {
            throw new RuntimeException("MMApplicationContext not initialized.");
        }
        duM = context.getFilesDir().getParentFile().getAbsolutePath() + "/";
        try {
            File file = new File(duN);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Error e) {
        }
    }
}
