package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileChannel;

public final class e {
    public static int a(String str, String str2, String str3, byte[] bArr) {
        return b(str, str2 + str3, bArr);
    }

    public static int b(String str, String str2, byte[] bArr) {
        Throwable e;
        if (bArr == null) {
            return -2;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2, true));
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                    return 0;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendBuf e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, str2, Integer.valueOf(bArr.length));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, str2, Integer.valueOf(bArr.length));
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e42, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e42.getClass().getSimpleName(), e42.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    }
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
            x.w("MicroMsg.FileOperation", "file op appendBuf e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, str2, Integer.valueOf(bArr.length));
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, str2, Integer.valueOf(bArr.length));
                }
            }
            return -1;
        }
    }

    public static int e(String str, byte[] bArr) {
        Throwable e;
        if (bArr == null || bArr.length == 0) {
            return -2;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
            x.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length));
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(bArr.length));
                }
            }
            return -1;
        } catch (Throwable th2) {
            e222 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e42, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e42.getClass().getSimpleName(), e42.getMessage(), str, Integer.valueOf(bArr.length));
                }
            }
            throw e222;
        }
    }

    public static int a(String str, byte[] bArr, int i) {
        Throwable e;
        if (bArr == null || bArr.length == 0 || bArr.length < i + 0) {
            return -2;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                fileOutputStream.write(bArr, 0, i);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
            x.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            return -1;
        } catch (Throwable th2) {
            e222 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e42, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e42.getClass().getSimpleName(), e42.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            throw e222;
        }
    }

    public static int b(String str, byte[] bArr, int i) {
        Throwable e;
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, false);
            try {
                fileOutputStream.write(bArr, 0, i);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op writeFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
            x.w("MicroMsg.FileOperation", "file op writeFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            return -1;
        } catch (Throwable th2) {
            e222 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e42, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e42.getClass().getSimpleName(), e42.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            throw e222;
        }
    }

    public static byte[] e(String str, int i, int i2) {
        Throwable e;
        Throwable th;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (i2 == -1) {
            i2 = (int) file.length();
        }
        if (i < 0) {
            return null;
        }
        if (i2 <= 0) {
            return null;
        }
        if (i + i2 > ((int) file.length())) {
            return null;
        }
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                bArr = new byte[i2];
                try {
                    randomAccessFile.seek((long) i);
                    randomAccessFile.readFully(bArr);
                    try {
                        randomAccessFile.close();
                        return bArr;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                        return bArr;
                    }
                } catch (Throwable e22) {
                    e = e22;
                    try {
                        x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                        if (randomAccessFile != null) {
                            return bArr;
                        }
                        try {
                            randomAccessFile.close();
                            return bArr;
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                            return bArr;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e2222) {
                                x.printErrStackTrace("MicroMsg.FileOperation", e2222, "", new Object[0]);
                                x.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e2222.getClass().getSimpleName(), e2222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bArr = null;
                x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                if (randomAccessFile != null) {
                    return bArr;
                }
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e22222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e22222.getClass().getSimpleName(), e22222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                    return bArr;
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            bArr = null;
            x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            x.w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
            if (randomAccessFile != null) {
                return bArr;
            }
            try {
                randomAccessFile.close();
                return bArr;
            } catch (Throwable e222222) {
                x.printErrStackTrace("MicroMsg.FileOperation", e222222, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e222222.getClass().getSimpleName(), e222222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                return bArr;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e2222222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e2222222.getClass().getSimpleName(), e2222222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
            throw th;
        }
    }

    public static byte[] f(String str, int i, int i2) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        Throwable e;
        Throwable th;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                bArr = new byte[length];
            } catch (Exception e2) {
                e = e2;
                bArr = null;
                try {
                    x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    if (randomAccessFile != null) {
                        return bArr;
                    }
                    try {
                        randomAccessFile.close();
                        return bArr;
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e3, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e3.getClass().getSimpleName(), e3.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                        return bArr;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e32, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e32.getClass().getSimpleName(), e32.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                        }
                    }
                    throw th;
                }
            }
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Throwable e322) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e322, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e322.getClass().getSimpleName(), e322.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    return bArr;
                }
            } catch (Throwable e3222) {
                e = e3222;
                x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                if (randomAccessFile != null) {
                    return bArr;
                }
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Throwable e32222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e32222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e32222.getClass().getSimpleName(), e32222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    return bArr;
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            bArr = null;
            x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            x.w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
            if (randomAccessFile != null) {
                return bArr;
            }
            try {
                randomAccessFile.close();
                return bArr;
            } catch (Throwable e322222) {
                x.printErrStackTrace("MicroMsg.FileOperation", e322222, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e322222.getClass().getSimpleName(), e322222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                return bArr;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable e3222222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e3222222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e3222222.getClass().getSimpleName(), e3222222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                }
            }
            throw th;
        }
    }

    public static int cm(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    public static final boolean i(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return false;
        }
        File file = new File(str + str2);
        File file2 = new File(str + str3);
        if (file.exists()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static final boolean d(File file, File file2) {
        Throwable e;
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i >= listFiles.length) {
                    return z2;
                }
                File file3 = listFiles[i];
                z = d(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
        } else {
            InputStream fileInputStream;
            OutputStream fileOutputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        file.delete();
                        try {
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e2.getClass().getSimpleName(), e2.getMessage(), file, file2);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e22.getClass().getSimpleName(), e22.getMessage(), file, file2);
                        }
                        return true;
                    } catch (Exception e3) {
                        e22 = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e22.getClass().getSimpleName(), e22.getMessage(), file, file2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                                    x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e222.getClass().getSimpleName(), e222.getMessage(), file, file2);
                                }
                            }
                            if (fileOutputStream != null) {
                                return false;
                            }
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (Throwable e2222) {
                                x.printErrStackTrace("MicroMsg.FileOperation", e2222, "", new Object[0]);
                                x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e2222.getClass().getSimpleName(), e2222.getMessage(), file, file2);
                                return false;
                            }
                        } catch (Throwable th) {
                            e2222 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                                    x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e4.getClass().getSimpleName(), e4.getMessage(), file, file2);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e5) {
                                    x.printErrStackTrace("MicroMsg.FileOperation", e5, "", new Object[0]);
                                    x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e5.getClass().getSimpleName(), e5.getMessage(), file, file2);
                                }
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e6) {
                    e2222 = e6;
                    fileOutputStream = null;
                    x.printErrStackTrace("MicroMsg.FileOperation", e2222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e2222.getClass().getSimpleName(), e2222.getMessage(), file, file2);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22222) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e22222, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e22222.getClass().getSimpleName(), e22222.getMessage(), file, file2);
                        }
                    }
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e222222) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e222222, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e222222.getClass().getSimpleName(), e222222.getMessage(), file, file2);
                        return false;
                    }
                } catch (Throwable th2) {
                    e222222 = th2;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e42) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e42, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e42.getClass().getSimpleName(), e42.getMessage(), file, file2);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e52) {
                            x.printErrStackTrace("MicroMsg.FileOperation", e52, "", new Object[0]);
                            x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e52.getClass().getSimpleName(), e52.getMessage(), file, file2);
                        }
                    }
                    throw e222222;
                }
            } catch (Exception e7) {
                e222222 = e7;
                fileOutputStream = null;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.FileOperation", e222222, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e222222.getClass().getSimpleName(), e222222.getMessage(), file, file2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2222222) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e2222222, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e2222222.getClass().getSimpleName(), e2222222.getMessage(), file, file2);
                    }
                }
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Throwable e22222222) {
                    x.printErrStackTrace("MicroMsg.FileOperation", e22222222, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e22222222.getClass().getSimpleName(), e22222222.getMessage(), file, file2);
                    return false;
                }
            } catch (Throwable th3) {
                e22222222 = th3;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e422) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e422, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e422.getClass().getSimpleName(), e422.getMessage(), file, file2);
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e522) {
                        x.printErrStackTrace("MicroMsg.FileOperation", e522, "", new Object[0]);
                        x.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e522.getClass().getSimpleName(), e522.getMessage(), file, file2);
                    }
                }
                throw e22222222;
            }
        }
    }

    public static final boolean cn(String str) {
        if (str != null && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static boolean co(String str) {
        return k(new File(str));
    }

    public static final boolean k(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                while (i < listFiles.length) {
                    k(listFiles[i]);
                    i++;
                }
            }
        }
        file.delete();
        return true;
    }

    public static final String cp(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == name.length() - 1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public static final String cq(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        if (lastIndexOf == 0) {
            return "";
        }
        return name.substring(0, lastIndexOf);
    }

    public static final boolean cr(String str) {
        if (bi.oW(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            return false;
        }
        String str2 = "/";
        for (int i = 0; i < split.length; i++) {
            if (!bi.oW(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    return false;
                }
                if (!(file2.exists() || file2.mkdir())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static long y(String str, String str2) {
        FileChannel channel;
        Throwable e;
        FileChannel fileChannel;
        try {
            FileChannel channel2;
            channel = new FileInputStream(str).getChannel();
            try {
                channel2 = new FileOutputStream(str2).getChannel();
            } catch (Throwable e2) {
                e = e2;
                fileChannel = null;
                try {
                    x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    x.w("MicroMsg.FileOperation", "file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", e.getClass().getSimpleName(), e.getMessage(), str, str2);
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable e22) {
                    e = e22;
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable e222) {
                e = e222;
                fileChannel = null;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e52) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e62) {
                    }
                }
                throw e;
            }
            try {
                channel2.transferFrom(channel, 0, channel.size());
                long size = channel.size();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e7) {
                    }
                }
                if (channel2 != null) {
                    try {
                        channel2.close();
                    } catch (IOException e8) {
                    }
                }
                return size;
            } catch (Exception e9) {
                e = e9;
                fileChannel = channel2;
            } catch (Throwable th) {
                e = th;
                fileChannel = channel2;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e522) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e622) {
                    }
                }
                throw e;
            }
        } catch (Throwable e2222) {
            e = e2222;
            fileChannel = null;
            channel = null;
        } catch (Throwable e22222) {
            e = e22222;
            fileChannel = null;
            channel = null;
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e5222) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e6222) {
                }
            }
            throw e;
        }
    }

    public static long d(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return 0;
        }
        try {
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += (long) read;
            }
        } catch (Exception e) {
            x.w("MicroMsg.FileOperation", "copyStream error: %s", e.getMessage());
            return 0;
        }
    }

    public static void f(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op closeInputStream e type:%s, e msg:%s, stream:%s", e.getClass().getSimpleName(), e.getMessage(), inputStream);
            }
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op closeOutputStream e type:%s, e msg:%s, stream:%s", e.getClass().getSimpleName(), e.getMessage(), outputStream);
            }
        }
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                x.w("MicroMsg.FileOperation", "file op closeReader e type:%s, e msg:%s, reader:%s", e.getClass().getSimpleName(), e.getMessage(), reader);
            }
        }
    }

    public static void cs(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs() || !parentFile.isDirectory()) {
                x.e("MicroMsg.FileOperation", "mkParentDir mkdir error. %s", str);
            }
        }
    }

    public static void d(String... strArr) {
        for (String file : strArr) {
            File file2 = new File(file);
            if (!(file2.exists() || (file2.mkdirs() && file2.isDirectory()))) {
                x.e("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", file);
            }
        }
    }

    public static final boolean l(File file) {
        int i = 0;
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        while (i < listFiles.length) {
            listFiles[i].delete();
            i++;
        }
        return true;
    }

    public static byte[] g(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            try {
                i = inputStream.read(bArr, 0, 1024);
            } catch (IOException e) {
            }
            if (i <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static boolean deleteFile(String str) {
        if (str == null) {
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static String ct(String str) {
        IOException e;
        Throwable th;
        if (!new File(str).exists()) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read != -1) {
                        stringBuffer.append(String.valueOf(cArr, 0, read));
                    } else {
                        try {
                            bufferedReader.close();
                            return stringBuffer.toString();
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e22) {
                    throw e22;
                }
            }
            throw th;
        }
    }
}
