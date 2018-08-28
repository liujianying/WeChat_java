package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public class q {
    public static final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static final byte[] a(InputStream inputStream) {
        Throwable th;
        Closeable closeable;
        byte[] bArr = null;
        if (inputStream != null) {
            Closeable byteArrayOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr2, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = byteArrayOutputStream;
                    a(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = bArr;
                a(closeable);
                throw th;
            }
        }
        return bArr;
    }

    public static final long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return -1;
        }
        try {
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += (long) read;
            }
        } catch (IOException e) {
            return -1;
        }
    }

    public static int a(byte[] bArr, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return a(bArr, new File(str), z);
    }

    public static int a(byte[] bArr, File file, boolean z) {
        Throwable th;
        int i = 0;
        if (!(bArr == null || bArr.length == 0 || file == null || file.isDirectory())) {
            Closeable closeable = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                Closeable fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    i = bArr.length;
                    a(fileOutputStream);
                } catch (IOException e) {
                    closeable = fileOutputStream;
                    a(closeable);
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileOutputStream;
                    a(closeable);
                    throw th;
                }
            } catch (IOException e2) {
                a(closeable);
                return i;
            } catch (Throwable th3) {
                th = th3;
                a(closeable);
                throw th;
            }
        }
        return i;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    public static final InputStream b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isFile() && file.canRead()) {
                return new FileInputStream(file);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (!file.exists()) {
                stack.pop();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    stack.pop();
                } else {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            stack.push(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                }
            } else {
                file.delete();
                stack.pop();
            }
        }
        return true;
    }

    public static void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
