package com.tencent.mm.vfs;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.FileSystem.a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public final class d {
    public static InputStream openRead(String str) {
        if (str != null && !str.isEmpty()) {
            return o(a.abO(str));
        }
        throw new FileNotFoundException("path is empty");
    }

    public static InputStream o(Uri uri) {
        c a = a.cBR().a(uri, null);
        if (a.valid()) {
            try {
                return a.uSi.openRead(a.path);
            } catch (Throwable e) {
                throw ((FileNotFoundException) new FileNotFoundException(e.getMessage()).initCause(e));
            }
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    public static OutputStream mG(String str) {
        if (str != null && !str.isEmpty()) {
            return b(a.abO(str), null);
        }
        throw new FileNotFoundException("path is empty");
    }

    static OutputStream b(Uri uri, c cVar) {
        c a = a.cBR().a(uri, cVar);
        if (a.valid()) {
            try {
                return a.uSi.mG(a.path);
            } catch (Throwable e) {
                throw ((FileNotFoundException) new FileNotFoundException(e.getMessage()).initCause(e));
            }
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    public static long abQ(String str) {
        c a = a.cBR().a(a.abO(str), null);
        if (!a.valid()) {
            return 0;
        }
        a abK = a.uSi.abK(a.path);
        if (abK != null) {
            return abK.size;
        }
        return 0;
    }

    public static byte[] dv(String str, int i) {
        IOException e;
        Throwable th;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i < 0 ? 2048 : i);
        InputStream openRead;
        try {
            openRead = openRead(str);
            try {
                byte[] bArr = new byte[1024];
                if (i < 0) {
                    i = Integer.MAX_VALUE;
                }
                while (true) {
                    int read = openRead.read(bArr, 0, Math.min(i, 1024));
                    if (read != -1 && i > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        i -= read;
                    } else if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e2) {
                        }
                    }
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e22) {
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
                x.d("MicroMsg.VFSFileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
                return bArr;
            } catch (IOException e4) {
                e = e4;
                try {
                    x.w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            openRead = null;
            x.w("MicroMsg.VFSFileOp", "readFromFile failed: " + str + ", " + e.getMessage());
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e52) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e62) {
                }
            }
            throw th;
        }
    }

    public static String ct(String str) {
        IOException e;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                return stringBuilder.toString();
            } catch (IOException e3) {
                e = e3;
                try {
                    x.e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            x.e("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }

    public static int b(String str, byte[] bArr, int i) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            outputStream = mG(str);
            outputStream.write(bArr, 0, i);
            if (outputStream == null) {
                return 0;
            }
            try {
                outputStream.close();
                return 0;
            } catch (IOException e) {
                return 0;
            }
        } catch (IOException e2) {
            x.e("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    public static boolean mL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        b bVar = new b(str);
        if (bVar.exists() && bVar.isDirectory()) {
            return true;
        }
        return bVar.mkdirs();
    }

    public static long y(String str, String str2) {
        InputStream openRead;
        IOException e;
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStream2 = null;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        long j = 0;
        try {
            openRead = openRead(str);
            try {
                outputStream2 = mG(str2);
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                try {
                    x.e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e52) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e62) {
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream2.write(bArr, 0, read);
                    j += (long) read;
                }
                x.d("MicroMsg.VFSFileOp", "copyFile: %s -> %s", str, str2);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                if (outputStream2 == null) {
                    return j;
                }
                try {
                    outputStream2.close();
                    return j;
                } catch (IOException e8) {
                    return j;
                }
            } catch (IOException e9) {
                e = e9;
                outputStream = outputStream2;
                x.e("MicroMsg.VFSFileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e32) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e42) {
                    }
                }
                return -1;
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e522) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e622) {
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            outputStream = outputStream2;
            openRead = outputStream2;
        } catch (Throwable th5) {
            th = th5;
            outputStream = outputStream2;
            openRead = outputStream2;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e5222) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6222) {
                }
            }
            throw th;
        }
    }

    public static boolean cn(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        c a = a.cBR().a(a.abO(str), null);
        if (a.valid()) {
            return a.uSi.abJ(a.path);
        }
        return false;
    }

    public static boolean deleteFile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return new b(str).delete();
    }

    public static boolean av(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (new b(str).a(new b(str2))) {
            return true;
        }
        if (y(str, str2) < 0) {
            return false;
        }
        deleteFile(str);
        return true;
    }

    public static boolean I(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return false;
        }
        c a = a.cBR().a(a.abO(str), null);
        if (a.valid()) {
            return a.uSi.I(str, z);
        }
        return false;
    }

    static String i(String str, boolean z, boolean z2) {
        int i = 1;
        if (str.isEmpty()) {
            return str;
        }
        int i2 = str.startsWith("/") ? 1 : 0;
        if (str.endsWith("/") && str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(i2), "/");
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z && "..".equals(nextToken)) {
                if (arrayList.isEmpty()) {
                    return null;
                }
                arrayList.remove(arrayList.size() - 1);
                i = 0;
            } else if ((z && ".".equals(nextToken)) || "".equals(nextToken)) {
                i = 0;
            } else {
                arrayList.add(nextToken);
            }
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!z2 && i2 > 0) {
                stringBuilder.append('/');
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                stringBuilder.append(it.next());
                while (it.hasNext()) {
                    stringBuilder.append('/');
                    stringBuilder.append(it.next());
                }
            }
            return stringBuilder.toString();
        } else if (z2) {
            return str.substring(i2);
        } else {
            return str;
        }
    }
}
