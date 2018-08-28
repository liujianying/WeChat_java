package com.tencent.mm.ui.tools;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class d {
    private static int uwS = 0;

    public static void i(File file, File file2) {
        InputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                x.e("MicroMsg.DBRecover", "copy file fail");
                return;
            }
        }
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                fileOutputStream = null;
                try {
                    x.e("MicroMsg.DBRecover", "copy file fail");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            return;
                        }
                    }
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            throw th;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e42) {
                        throw th;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (fileInputStream.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            } catch (Exception e6) {
                x.e("MicroMsg.DBRecover", "copy file fail");
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e32) {
                        return;
                    }
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            }
        } catch (Exception e7) {
            fileOutputStream = null;
            fileInputStream = null;
            x.e("MicroMsg.DBRecover", "copy file fail");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e322) {
                    return;
                }
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th32) {
            th = th32;
            fileOutputStream2 = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e422) {
                    throw th;
                }
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }
}
