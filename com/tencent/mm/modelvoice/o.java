package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class o {
    public static int oh(String str) {
        if (bi.oW(str)) {
            return -1;
        }
        x.d("MicroMsg.VoiceFile", "fileName " + str);
        if (e(str, 0, false)) {
            return 0;
        }
        if (f(str, 0, false)) {
            return 2;
        }
        return 1;
    }

    public static int d(String str, int i, boolean z) {
        if (bi.oW(str)) {
            return -1;
        }
        x.d("MicroMsg.VoiceFile", "fileName " + str);
        if (e(str, i, z)) {
            return 0;
        }
        if (f(str, i, z)) {
            return 2;
        }
        return 1;
    }

    private static boolean e(String str, int i, boolean z) {
        Throwable e;
        if (!z) {
            if (i == 0) {
                str = q.getFullPath(str);
            } else {
                str = null;
            }
        }
        x.d("MicroMsg.VoiceFile", "path " + str);
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    x.e("MicroMsg.VoiceFile", "read amr file header failed!");
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e2));
                    }
                    return false;
                }
                x.i("MicroMsg.VoiceFile", "isAmrHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bi.bB(bArr), new String(bArr), "#!AMR\n");
                if (new String(bArr).endsWith("#!AMR\n")) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e22));
                    }
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable e222) {
                    x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e222));
                }
                return false;
            } catch (Throwable e2222) {
                e = e2222;
            }
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.VoiceFile", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22222) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e22222));
                    }
                }
                return false;
            } catch (Throwable e222222) {
                e = e222222;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2222222) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e2222222));
                    }
                }
                throw e;
            }
        } catch (Throwable th) {
            e = th;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable e22222222) {
                    x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e22222222));
                }
            }
            throw e;
        }
    }

    public static boolean f(String str, int i, boolean z) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        if (!z) {
            if (i == 0) {
                str = q.getFullPath(str);
            } else if (i == 1) {
                x.e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", str);
                return false;
            } else {
                str = null;
            }
        }
        x.d("MicroMsg.VoiceFile", "isSilkHeader path " + str);
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[9];
                randomAccessFile3.seek(1);
                if (randomAccessFile3.read(bArr, 0, 9) == -1) {
                    try {
                        randomAccessFile3.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e));
                    }
                    return false;
                }
                x.i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bi.bB(bArr), new String(bArr), "#!SILK_V3");
                if (new String(bArr).endsWith("#!SILK_V3")) {
                    try {
                        randomAccessFile3.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e2));
                    }
                    return true;
                }
                try {
                    randomAccessFile3.close();
                } catch (Throwable e22) {
                    x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e22));
                }
                return false;
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile3;
            } catch (Throwable e222) {
                th = e222;
                randomAccessFile = randomAccessFile3;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2222) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e2222));
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            try {
                x.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e22222) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e22222));
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e222222) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e222222));
                    }
                }
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable e2222222) {
                    x.e("MicroMsg.VoiceFile", "exception:%s", bi.i(e2222222));
                }
            }
            throw th;
        }
    }

    public static int nM(String str) {
        boolean z = true;
        String fullPath;
        File file;
        int length;
        switch (oh(str)) {
            case 0:
                return oi(q.getFullPath(str));
            case 1:
                fullPath = q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (!file.exists()) {
                    return 0;
                }
                length = (int) file.length();
                if (length > 0) {
                    return length;
                }
                return 0;
            case 2:
                fullPath = q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (!file.exists()) {
                    return 0;
                }
                length = (int) file.length();
                return length > 0 ? length : 0;
            default:
                return oi(q.getFullPath(str));
        }
    }

    private static int oi(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = ((int) file.length()) - 6;
        if (length > 0) {
            return length;
        }
        return 0;
    }
}
