package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

final class f {
    private boolean a = false;
    String b = null;

    f() {
    }

    private static boolean a(String str, String str2) {
        return new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString()).exists();
    }

    private static String b(String str, String str2) {
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteBuffer map = fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length());
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(map);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
                return bigInteger;
            } catch (IOException e) {
                return bigInteger;
            }
        } catch (Exception e2) {
            try {
                fileInputStream.close();
                return null;
            } catch (IOException e3) {
                return null;
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
            }
            throw th;
        }
    }

    private static boolean b(String str, String[] strArr) {
        for (String compareTo : strArr) {
            if (str.compareTo(compareTo) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void g(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        FileChannel fileChannel;
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        File file2 = new File(new StringBuilder(String.valueOf(str3)).append("/").append(str).toString());
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        FileChannel channel;
        FileChannel channel2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    channel = fileInputStream2.getChannel();
                    try {
                        channel2 = fileOutputStream2.getChannel();
                        try {
                            channel.transferTo(0, channel.size(), channel2);
                            try {
                                fileInputStream2.close();
                                channel.close();
                                fileOutputStream2.close();
                                channel2.close();
                            } catch (IOException e) {
                            }
                        } catch (IOException e2) {
                            fileOutputStream = fileOutputStream2;
                            fileInputStream = fileInputStream2;
                            try {
                                fileInputStream.close();
                                channel.close();
                                fileOutputStream.close();
                                channel2.close();
                            } catch (IOException e3) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel = channel;
                            try {
                                fileInputStream2.close();
                                fileChannel.close();
                                fileOutputStream2.close();
                                channel2.close();
                            } catch (IOException e4) {
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        channel2 = null;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        fileInputStream.close();
                        channel.close();
                        fileOutputStream.close();
                        channel2.close();
                    } catch (Throwable th3) {
                        th = th3;
                        channel2 = null;
                        fileChannel = channel;
                        fileInputStream2.close();
                        fileChannel.close();
                        fileOutputStream2.close();
                        channel2.close();
                        throw th;
                    }
                } catch (IOException e6) {
                    channel2 = null;
                    channel = null;
                    fileOutputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                } catch (Throwable th4) {
                    th = th4;
                    channel2 = null;
                    fileChannel = null;
                    fileInputStream2.close();
                    fileChannel.close();
                    fileOutputStream2.close();
                    channel2.close();
                    throw th;
                }
            } catch (IOException e7) {
                channel2 = null;
                channel = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                channel.close();
                fileOutputStream.close();
                channel2.close();
            } catch (Throwable th42) {
                th = th42;
                channel2 = null;
                fileChannel = null;
                fileOutputStream2 = null;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream2.close();
                channel2.close();
                throw th;
            }
        } catch (IOException e8) {
            channel2 = null;
            channel = null;
            fileOutputStream = null;
            fileInputStream = null;
            fileInputStream.close();
            channel.close();
            fileOutputStream.close();
            channel2.close();
        } catch (Throwable th422) {
            th = th422;
            channel2 = null;
            fileChannel = null;
            fileOutputStream2 = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            fileChannel.close();
            fileOutputStream2.close();
            channel2.close();
            throw th;
        }
    }

    public final int d(Context context, String str, String str2, String str3) {
        if (this.a) {
            return 0;
        }
        if (!a("libwxvoiceembed.so", str)) {
            return -201;
        }
        if (!a("libwxvoiceembed.bin", str)) {
            return -202;
        }
        String stringBuilder = new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath())).append("/NamesSearch/").toString();
        File file = new File(stringBuilder);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!a("libwxvoiceembed.so", stringBuilder)) {
            g("libwxvoiceembed.so", str, stringBuilder);
        }
        if (!a("libwxvoiceembed.bin", stringBuilder)) {
            g("libwxvoiceembed.bin", str, stringBuilder);
        }
        try {
            String b = b("libwxvoiceembed.so", stringBuilder);
            if (b.compareTo(b("libwxvoiceembed.so", str)) != 0) {
                g("libwxvoiceembed.so", str, stringBuilder);
            }
            if (!b(b, str2.split(";"))) {
                return -203;
            }
            try {
                String b2 = b("libwxvoiceembed.bin", stringBuilder);
                if (b2.compareTo(b("libwxvoiceembed.bin", str)) != 0) {
                    g("libwxvoiceembed.bin", str, stringBuilder);
                }
                if (!b(b2, str3.split(";"))) {
                    return -204;
                }
                this.b = stringBuilder;
                this.a = true;
                return 0;
            } catch (FileNotFoundException e) {
                return -204;
            }
        } catch (FileNotFoundException e2) {
            return -203;
        }
    }

    public final int f(String str, String str2, String str3) {
        if (this.a) {
            return 0;
        }
        if (!a("libwxvoiceembed.so", str)) {
            return -201;
        }
        if (!a("libwxvoiceembed.bin", str)) {
            return -202;
        }
        try {
            if (!b(b("libwxvoiceembed.so", str), str2.split(";"))) {
                return -203;
            }
            try {
                if (!b(b("libwxvoiceembed.bin", str), str3.split(";"))) {
                    return -204;
                }
                this.b = str;
                this.a = true;
                return 0;
            } catch (FileNotFoundException e) {
                return -204;
            }
        } catch (FileNotFoundException e2) {
            return -203;
        }
    }
}
