package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WmaDecoder extends FfmpegPlayer {
    public static String TAG = "WmaDecoder";
    private final int HEARER_LENGTH = 16;
    private final byte[] WMA_HEADER = new byte[]{(byte) 48, (byte) 38, (byte) -78, (byte) 117, (byte) -114, (byte) 102, (byte) -49, (byte) 17, (byte) -90, (byte) -39, (byte) 0, (byte) -86, (byte) 0, (byte) 98, (byte) -50, (byte) 108};

    public AudioType getAudioType(String str, byte[] bArr) {
        byte[] bArr2;
        Throwable e;
        int i;
        if (bArr == null || bArr.length < 16) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    bArr2 = new byte[16];
                    try {
                        fileInputStream.read(bArr2);
                        try {
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            Logger.e(TAG, e2);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        try {
                            Logger.e(TAG, e2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e22) {
                                    Logger.e(TAG, e22);
                                }
                            }
                            i = 0;
                            while (i < 16) {
                                i++;
                            }
                            if (i == 16) {
                                return AudioType.WMA;
                            }
                            return AudioType.UNSUPPORT;
                        } catch (Throwable th) {
                            e22 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e4) {
                                    Logger.e(TAG, e4);
                                }
                            }
                            throw e22;
                        }
                    }
                } catch (IOException e5) {
                    e22 = e5;
                    bArr2 = null;
                    Logger.e(TAG, e22);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e222) {
                            Logger.e(TAG, e222);
                        }
                    }
                    i = 0;
                    while (i < 16) {
                        i++;
                    }
                    if (i == 16) {
                        return AudioType.WMA;
                    }
                    return AudioType.UNSUPPORT;
                }
            } catch (IOException e6) {
                e222 = e6;
                bArr2 = null;
                fileInputStream = null;
                Logger.e(TAG, e222);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2222) {
                        Logger.e(TAG, e2222);
                    }
                }
                i = 0;
                while (i < 16) {
                    i++;
                }
                if (i == 16) {
                    return AudioType.WMA;
                }
                return AudioType.UNSUPPORT;
            } catch (Throwable th2) {
                e2222 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e42) {
                        Logger.e(TAG, e42);
                    }
                }
                throw e2222;
            }
        }
        bArr2 = bArr;
        if (bArr2 != null && bArr2.length >= 16) {
            i = 0;
            while (i < 16 && bArr2[i] == this.WMA_HEADER[i]) {
                i++;
            }
            if (i == 16) {
                return AudioType.WMA;
            }
        }
        return AudioType.UNSUPPORT;
    }

    public AudioType guessAudioType(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".wma")) {
            return AudioType.UNSUPPORT;
        }
        return AudioType.WMA;
    }

    public int getErrorCodeMask() {
        return 117440511;
    }
}
