package com.tencent.mm.ag;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import org.json.JSONObject;

public final class a {
    public static int dRu = 1;
    private static String duO = "";

    private static String Ob() {
        if (bi.oW(duO)) {
            duO = e.duO.replace("/data/user/0", "/data/data");
        }
        return duO;
    }

    public static String Oc() {
        File file = new File(Ob(), "emoji/res");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String Od() {
        return Ob() + "emoji/newemoji";
    }

    public static int Oe() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(Oc(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String str2 = str;
                    str = bufferedReader.readLine();
                    if (str != null) {
                        str = str2 + str;
                    } else {
                        x.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", new Object[]{str2, Integer.valueOf(new JSONObject(str2).getInt("version"))});
                        com.tencent.mm.a.e.f(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.f(fileInputStream);
                    return 1;
                } catch (Throwable th) {
                    e = th;
                    com.tencent.mm.a.e.f(fileInputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.f(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.f(fileInputStream);
            throw e;
        }
    }

    private static int Of() {
        Reader bufferedReader;
        Throwable e;
        InputStream open;
        Reader inputStreamReader;
        try {
            open = ad.getContext().getAssets().open("emoji_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    try {
                        x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                        com.tencent.mm.a.e.f(open);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        return 1;
                    } catch (Throwable th) {
                        e = th;
                        com.tencent.mm.a.e.f(open);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    com.tencent.mm.a.e.f(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
                try {
                    String str = "";
                    while (true) {
                        String str2 = str;
                        str = bufferedReader.readLine();
                        if (str != null) {
                            str = str2 + str;
                        } else {
                            x.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", new Object[]{str2, Integer.valueOf(new JSONObject(str2).getInt("version"))});
                            com.tencent.mm.a.e.f(open);
                            com.tencent.mm.a.e.a(inputStreamReader);
                            com.tencent.mm.a.e.a(bufferedReader);
                            return r0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.f(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    return 1;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStreamReader = null;
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                com.tencent.mm.a.e.f(open);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(bufferedReader);
                return 1;
            } catch (Throwable th3) {
                e = th3;
                bufferedReader = null;
                inputStreamReader = null;
                com.tencent.mm.a.e.f(open);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(bufferedReader);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            inputStreamReader = null;
            open = null;
        } catch (Throwable th4) {
            e = th4;
            bufferedReader = null;
            inputStreamReader = null;
            open = null;
            com.tencent.mm.a.e.f(open);
            com.tencent.mm.a.e.a(inputStreamReader);
            com.tencent.mm.a.e.a(bufferedReader);
            throw e;
        }
    }

    private static boolean lC(String str) {
        InputStream open;
        try {
            open = ad.getContext().getAssets().open("emoji_template.zip");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                e(open, fileOutputStream);
                return true;
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e3, "", new Object[0]);
                return false;
            } finally {
                com.tencent.mm.a.e.f(open);
                com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
            }
        } else {
            com.tencent.mm.a.e.f(open);
            return false;
        }
    }

    private static void e(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void bJ(boolean z) {
        File file = new File(Oc());
        x.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", new Object[]{file.getAbsoluteFile()});
        if (d.qVQ || d.qVR) {
            x.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", new Object[]{Boolean.valueOf(z)});
            com.tencent.mm.a.e.k(file);
            r(file);
        } else {
            dRu = Oe();
            if (z) {
                x.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(Of()), Integer.valueOf(dRu)});
                if (dRu < Of()) {
                    com.tencent.mm.a.e.k(file);
                    r(file);
                }
            } else if (dRu == 1) {
                x.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", new Object[]{Integer.valueOf(dRu)});
                com.tencent.mm.a.e.k(file);
                r(file);
            }
        }
        com.tencent.mm.a.e.k(new File(e.bnE, "emoji"));
    }

    private static void r(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(file, "emoji_template.zip");
        if (lC(file2.getAbsolutePath())) {
            int fR = bi.fR(file2.getAbsolutePath(), file2.getParent());
            if (fR < 0) {
                x.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + fR + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            dRu = Oe();
            x.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[]{file2.getParent(), Integer.valueOf(dRu)});
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", new Object[]{file2.getAbsolutePath()});
    }

    public static void s(File file) {
        File file2 = new File(Oc());
        com.tencent.mm.a.e.k(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(file2, "emoji_template.zip");
        com.tencent.mm.a.e.y(file.getAbsolutePath(), file3.getAbsolutePath());
        int fR = bi.fR(file3.getAbsolutePath(), file3.getParent());
        if (fR < 0) {
            x.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + fR + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        dRu = Oe();
        x.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[]{file3.getParent(), Integer.valueOf(dRu)});
    }
}
