package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public final class f {
    public static final String giQ = b.bnE;

    public static String bF(String str, String str2) {
        String str3;
        File file = new File(giQ, "AudioRecord");
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder append = new StringBuilder("audio").append(ac.ce(str2));
        if (!TextUtils.isEmpty(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                str3 = ".m4a";
            } else if ("mp3".equalsIgnoreCase(str)) {
                str3 = ".mp3";
            } else if ("wav".equalsIgnoreCase(str)) {
                str3 = ".wav";
            }
            x.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[]{append.append(str3).toString(), new File(file, append.append(str3).toString()).getAbsoluteFile()});
            return new File(file, append.append(str3).toString()).getAbsolutePath();
        }
        str3 = "";
        x.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[]{append.append(str3).toString(), new File(file, append.append(str3).toString()).getAbsoluteFile()});
        return new File(file, append.append(str3).toString()).getAbsolutePath();
    }

    public static String ux(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("aac".equalsIgnoreCase(str)) {
            return "m4a";
        }
        if ("mp3".equalsIgnoreCase(str)) {
            return "mp3";
        }
        if ("wav".equalsIgnoreCase(str)) {
            return "wav";
        }
        return "";
    }

    public static boolean uy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("aac".equalsIgnoreCase(str)) {
            return true;
        }
        if ("mp3".equalsIgnoreCase(str)) {
            return true;
        }
        return "wav".equalsIgnoreCase(str) ? false : false;
    }

    public static boolean uz(String str) {
        boolean z = false;
        File file = new File(str);
        if (file.exists()) {
            x.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
            file.delete();
            try {
                return file.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e, "prepareCacheFile", new Object[z]);
                return z;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e2, "prepareCacheFile", new Object[z]);
                return z;
            }
        }
        try {
            x.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
            return file.createNewFile();
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e22, "prepareCacheFile", new Object[z]);
            return z;
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e222, "prepareCacheFile", new Object[z]);
            return z;
        }
    }

    public static long uA(String str) {
        File file = new File(str);
        if (file.exists()) {
            x.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
            return file.length();
        }
        x.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", new Object[]{str});
        return -1;
    }

    public static short[] E(byte[] bArr, int i) {
        short[] sArr = new short[(i / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & WebView.NORMAL_MODE_ALPHA) | ((bArr[(i2 * 2) + 1] & WebView.NORMAL_MODE_ALPHA) << 8));
        }
        return sArr;
    }
}
