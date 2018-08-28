package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.c;
import com.tencent.mm.vfs.d;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class o {
    public static boolean Wd(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
            return false;
        } else if (str.length() < 3 || !new b(str).exists()) {
            return false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = We(str);
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, decodeResultLogger, 0, new int[0]);
            if (decodeFile != null) {
                x.i("MicroMsg.ImgUtil", "bitmap recycle %s", new Object[]{decodeFile});
                decodeFile.recycle();
            }
            if (options.outWidth <= 0 || options.outHeight <= 0 || decodeResultLogger.getDecodeResult() != 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean b(String str, DecodeResultLogger decodeResultLogger) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
            decodeResultLogger.setDecodeResult(1005);
            return false;
        } else if (str.length() < 3) {
            decodeResultLogger.setDecodeResult(1005);
            return false;
        } else if (new b(str).exists()) {
            Options options = new Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = We(str);
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, decodeResultLogger, 0, new int[0]);
            x.v("MicroMsg.ImgUtil", "hy: isImgFile decode using: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            if (decodeFile != null) {
                x.i("MicroMsg.ImgUtil", "bitmap recycle %s", new Object[]{decodeFile});
                decodeFile.recycle();
            }
            if (options.outWidth <= 0 || options.outHeight <= 0 || decodeResultLogger.getDecodeResult() != 0) {
                return false;
            }
            return true;
        } else {
            decodeResultLogger.setDecodeResult(1005);
            return false;
        }
    }

    private static int We(String str) {
        InputStream openRead;
        Throwable e;
        int[] iArr = null;
        try {
            openRead = d.openRead(str);
            if (openRead == null) {
                try {
                    x.w("MicroMsg.ImgUtil", "hy: the input stream is null");
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
            } else {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(openRead, null, options);
                iArr = new int[]{options.outWidth, options.outHeight};
            }
            if (iArr != null) {
                x.d("MicroMsg.ImgUtil", "hy: decoded file: %s size: width: %d, height: %d", new Object[]{str, Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                int eE = eE(eE, r3);
                x.d("MicroMsg.ImgUtil", "hy: sample rate: %d", new Object[]{Integer.valueOf(eE)});
                if (openRead == null) {
                    return eE;
                }
                try {
                    openRead.close();
                    return eE;
                } catch (IOException e3) {
                    return eE;
                }
            }
            x.w("MicroMsg.ImgUtil", "hy: can not get size from file");
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e4) {
                }
            }
            return 1;
        } catch (FileNotFoundException e5) {
            e = e5;
            openRead = null;
        } catch (Throwable th) {
            e = th;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e6) {
                }
            }
            throw e;
        }
        try {
            x.printErrStackTrace("MicroMsg.ImgUtil", e, "hy: exception in getMaxSampleRateFromFile", new Object[0]);
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e7) {
                }
            }
            return 1;
        } catch (Throwable th2) {
            e = th2;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e62) {
                }
            }
            throw e;
        }
        return 1;
    }

    public static boolean bv(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = "";
        int i = 0;
        while (i < 6) {
            try {
                str = str + ((char) byteArrayInputStream.read());
                i++;
            } catch (IOException e) {
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e2) {
        }
        if (str.startsWith("GIF")) {
            return true;
        }
        return false;
    }

    public static boolean Wf(String str) {
        Throwable th;
        InputStream cVar;
        try {
            cVar = new c(str);
            try {
                byte[] bArr = new byte[6];
                String str2 = "";
                cVar.read(bArr);
                for (int i = 0; i < 6; i++) {
                    str2 = str2 + ((char) bArr[i]);
                }
                if (str2.startsWith("GIF")) {
                    try {
                        cVar.close();
                    } catch (IOException e) {
                    }
                    return true;
                }
                try {
                    cVar.close();
                    return false;
                } catch (IOException e2) {
                    return false;
                }
            } catch (Exception e3) {
                if (cVar != null) {
                    return false;
                }
                try {
                    cVar.close();
                    return false;
                } catch (IOException e4) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            cVar = null;
            if (cVar != null) {
                return false;
            }
            try {
                cVar.close();
                return false;
            } catch (IOException e42) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            if (cVar != null) {
                try {
                    cVar.close();
                } catch (IOException e52) {
                }
            }
            throw th;
        }
    }

    public static boolean bw(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return false;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return true;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return true;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return true;
        }
        if (bArr[0] == (byte) 119 && bArr[1] == (byte) 120 && bArr[2] == (byte) 103 && bArr[3] == (byte) 102) {
            return true;
        }
        return false;
    }

    public static boolean Wg(String str) {
        Throwable th;
        InputStream cVar;
        try {
            cVar = new c(str);
            try {
                byte[] bArr = new byte[8];
                String str2 = "";
                cVar.read(bArr);
                for (int i = 0; i < 8; i++) {
                    str2 = str2 + ((char) bArr[i]);
                }
                if (str2.startsWith("wxgf")) {
                    try {
                        cVar.close();
                    } catch (IOException e) {
                    }
                    return true;
                }
                try {
                    cVar.close();
                    return false;
                } catch (IOException e2) {
                    return false;
                }
            } catch (Exception e3) {
                if (cVar != null) {
                    return false;
                }
                try {
                    cVar.close();
                    return false;
                } catch (IOException e4) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            cVar = null;
            if (cVar != null) {
                return false;
            }
            try {
                cVar.close();
                return false;
            } catch (IOException e42) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            if (cVar != null) {
                try {
                    cVar.close();
                } catch (IOException e52) {
                }
            }
            throw th;
        }
    }

    public static boolean bx(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = "";
        int i = 0;
        while (i < 8) {
            try {
                str = str + ((char) byteArrayInputStream.read());
                i++;
            } catch (IOException e) {
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e2) {
        }
        if (str.startsWith("wxgf")) {
            return true;
        }
        return false;
    }

    private static int eE(int i, int i2) {
        int max = Math.max(i, i2);
        int i3 = 1;
        while (max > 64) {
            i3 *= 2;
            max /= i3;
        }
        return i3;
    }
}
