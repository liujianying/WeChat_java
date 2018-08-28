package com.tencent.xweb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import org.xwalk.core.Log;

public final class a {
    public static boolean fN(String str, String str2) {
        FileChannel channel;
        Exception e;
        FileChannel fileChannel;
        Throwable th;
        try {
            FileChannel channel2;
            channel = new FileInputStream(str).getChannel();
            try {
                channel2 = new FileOutputStream(str2).getChannel();
            } catch (Exception e2) {
                e = e2;
                fileChannel = null;
                try {
                    Log.e("FileUtils", String.format("file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", new Object[]{e.getClass().getSimpleName(), e.getMessage(), str, str2}));
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
                    return false;
                } catch (Throwable th2) {
                    th = th2;
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
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
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
                throw th;
            }
            try {
                channel2.transferFrom(channel, 0, channel.size());
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
                return true;
            } catch (Exception e9) {
                e = e9;
                fileChannel = channel2;
                Log.e("FileUtils", String.format("file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", new Object[]{e.getClass().getSimpleName(), e.getMessage(), str, str2}));
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e32) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e42) {
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
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
                throw th;
            }
        } catch (Exception e22) {
            e = e22;
            fileChannel = null;
            channel = null;
        } catch (Throwable th222) {
            th = th222;
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
            throw th;
        }
    }

    private static boolean o(File file, File file2) {
        try {
            InputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            OutputStream fileOutputStream = new FileOutputStream(file2);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bArr = new byte[5120];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e("FileUtils", "copyFile error:" + e.getMessage());
            return false;
        }
    }

    public static boolean gv(String str, String str2) {
        File file = new File(str2);
        if (!(file.isDirectory() && file.exists())) {
            file.mkdirs();
        }
        File[] listFiles = new File(str).listFiles();
        int i = 0;
        while (i < listFiles.length) {
            if (listFiles[i].isFile() && !o(listFiles[i], new File(new File(str2).getAbsolutePath() + File.separator + listFiles[i].getName()))) {
                return false;
            }
            if (listFiles[i].isDirectory() && gv(str + "/" + listFiles[i].getName(), str2 + "/" + listFiles[i].getName())) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean adE(String str) {
        try {
            ap(new File(str));
            return true;
        } catch (Exception e) {
            Log.i("FileUtils", String.format("delete all files.(%s)", new Object[]{str}));
            return false;
        }
    }

    private static void ap(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists()) {
                            if (file2.isFile()) {
                                file2.delete();
                            } else {
                                ap(file2);
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }
}
