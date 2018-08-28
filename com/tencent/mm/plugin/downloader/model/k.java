package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.c.l;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

public final class k {
    protected static final com.tencent.mm.c.k bxv = new com.tencent.mm.c.k(101010256);
    private static l icz = new l(38650);

    private static class a {
        Properties icA;
        byte[] icB;

        private a() {
            this.icA = new Properties();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String toString() {
            return "ApkExternalInfo [p=" + this.icA + ", otherData=" + Arrays.toString(this.icB) + "]";
        }
    }

    private static String e(File file, String str) {
        Throwable th;
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] d = d(randomAccessFile);
                if (d == null) {
                    randomAccessFile.close();
                } else {
                    a aVar = new a();
                    if (d != null) {
                        ByteBuffer wrap = ByteBuffer.wrap(d);
                        icz.getBytes();
                        byte[] bArr = new byte[2];
                        wrap.get(bArr);
                        if (!icz.equals(new l(bArr))) {
                            throw new ProtocolException("unknow protocl [" + Arrays.toString(d) + "]");
                        } else if (d.length - 2 > 2) {
                            bArr = new byte[2];
                            wrap.get(bArr);
                            int i = new l(bArr).value;
                            if ((d.length - 2) - 2 >= i) {
                                byte[] bArr2 = new byte[i];
                                wrap.get(bArr2);
                                aVar.icA.load(new ByteArrayInputStream(bArr2));
                                int length = ((d.length - 2) - i) - 2;
                                if (length > 0) {
                                    aVar.icB = new byte[length];
                                    wrap.get(aVar.icB);
                                }
                            }
                        }
                    }
                    str2 = aVar.icA.getProperty(str);
                    randomAccessFile.close();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String E(File file) {
        return e(file, DownloadInfoColumns.CHANNELID);
    }

    private static byte[] d(RandomAccessFile randomAccessFile) {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = bxv.getBytes();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((16 + length) + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        i = new l(bArr).value;
        if (i == 0) {
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        return bArr;
    }
}
