package com.tencent.tmassistantsdk.protocol;

import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ZipUtils {
    private static final String TAG = "ZipUtils";

    public static byte[] zip(byte[] bArr) {
        Throwable e;
        Deflater deflater = new Deflater();
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                deflater.setLevel(9);
                deflater.setInput(bArr);
                deflater.finish();
                byte[] bArr2 = new byte[1024];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                deflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                e2 = th;
                deflater.end();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace(TAG, e3, "", new Object[0]);
                    }
                }
                throw e2;
            }
        } catch (Throwable th2) {
            e2 = th2;
            byteArrayOutputStream = null;
            deflater.end();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e32) {
                    x.printErrStackTrace(TAG, e32, "", new Object[0]);
                }
            }
            throw e2;
        }
    }

    public static byte[] unzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Inflater inflater = new Inflater();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[1024];
                inflater.setInput(bArr);
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                }
                inflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (DataFormatException e3) {
                e = e3;
                try {
                    x.printErrStackTrace(TAG, e, "", new Object[0]);
                    inflater.end();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    e = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (DataFormatException e6) {
            e = e6;
            byteArrayOutputStream = null;
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            inflater.end();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e42) {
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            e = th2;
            inflater.end();
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e52) {
                }
            }
            throw e;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
