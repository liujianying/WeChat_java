package com.tencent.rtmp;

import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TXLiveBase {
    private static final String FILE_MD5_FFMPEG = "5753d7d975ad20192b89bb21dc4b1af4";
    private static final String FILE_MD5_LITEAV = "e548196c9f305cc75540d87758c3447c";
    private static final String FILE_MD5_SATURN = "0c6fbb163d6d3021be67317b9def0b45";
    private static final String FILE_MD5_TRAE = "fd98cdc1d0ea13d2889e84b72b723a98";
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance = new TXLiveBase();
    private static ITXLiveBaseListener listener = null;

    private static class a implements com.tencent.liteav.basic.log.TXCLog.a {
        private a() {
        }

        public void a(int i, String str, String str2) {
            if (TXLiveBase.listener != null) {
                TXLiveBase.listener.OnLog(i, str, str2);
            }
        }
    }

    private TXLiveBase() {
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public static void setListener(ITXLiveBaseListener iTXLiveBaseListener) {
        TXCLog.setListener(new a());
        listener = iTXLiveBaseListener;
    }

    public static void setLogLevel(int i) {
        TXCLog.setLevel(i);
    }

    public static void setConsoleEnabled(boolean z) {
        TXCLog.setConsoleEnabled(z);
    }

    public static void setAppVersion(String str) {
        TXCDRApi.txSetAppVersion(str);
        TXCCommonUtil.setAppVersion(str);
    }

    public static void setLibraryPath(String str) {
        com.tencent.liteav.basic.util.a.b(str);
    }

    public static boolean isLibraryPathValid(String str) {
        String fileMD5 = getFileMD5(str, "libliteavsdk.so");
        String fileMD52 = getFileMD5(str, "libsaturn.so");
        String fileMD53 = getFileMD5(str, "libtxffmpeg.so");
        String fileMD54 = getFileMD5(str, "libtraeimp-rtmp-armeabi.so");
        new StringBuilder("MD5-Check libliteavsdk = ").append(fileMD5).append(" FILE_MD5_LITEAV = e548196c9f305cc75540d87758c3447c");
        new StringBuilder("MD5-Check libsaturn = ").append(fileMD52).append(" FILE_MD5_SATURN = 0c6fbb163d6d3021be67317b9def0b45");
        new StringBuilder("MD5-Check libtxffmpeg = ").append(fileMD53).append(" FILE_MD5_FFMPEG = 5753d7d975ad20192b89bb21dc4b1af4");
        new StringBuilder("MD5-Check libtraeimpl = ").append(fileMD54).append(" FILE_MD5_TRAE = fd98cdc1d0ea13d2889e84b72b723a98");
        if (fileMD5 == null || !fileMD5.equalsIgnoreCase(FILE_MD5_LITEAV) || fileMD52 == null || !fileMD52.equalsIgnoreCase(FILE_MD5_SATURN) || fileMD53 == null || !fileMD53.equalsIgnoreCase(FILE_MD5_FFMPEG) || fileMD54 == null || !fileMD54.equalsIgnoreCase(FILE_MD5_TRAE)) {
            return false;
        }
        return true;
    }

    public static String getSDKVersionStr() {
        return TXCCommonUtil.getSDKVersionStr();
    }

    public static void setPituLicencePath(String str) {
        TXCCommonUtil.setPituLicencePath(str);
    }

    public static String getPituSDKVersion() {
        return o.a();
    }

    private static String getFileMD5(String str, String str2) {
        MessageDigest messageDigest = null;
        File file = new File(str, str2);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            fileInputStream.close();
        } catch (NoSuchAlgorithmException e) {
        } catch (FileNotFoundException e2) {
        } catch (IOException e3) {
        }
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
