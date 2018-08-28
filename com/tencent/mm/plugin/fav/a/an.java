package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import org.json.JSONObject;

public final class an {
    private static String duO = "";
    public static Set<String> iXj;
    public static int iXk = 1;

    private static String eO(boolean z) {
        if (z) {
            return g.Ei().dqp;
        }
        if (bi.oW(duO)) {
            duO = e.duO.replace("/data/user/0", "/data/data");
        }
        return duO;
    }

    public static String aLQ() {
        File file;
        if (ax.ciI() > 1048576) {
            file = new File(eO(false), "wenote/res");
        } else {
            file = new File(e.bnE, "wenote/res");
        }
        return file.getAbsolutePath();
    }

    public static String aLR() {
        File file = new File(eO(false), "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        file = new File(e.bnE, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String aLS() {
        File file = new File(eO(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String aLT() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(eO(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
    }

    public static String aLU() {
        File file = new File(eO(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String aLV() {
        File file = new File(eO(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int Oe() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(aLR(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String str2 = str;
                    str = bufferedReader.readLine();
                    if (str != null) {
                        str = str2 + str;
                    } else {
                        x.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str2, Integer.valueOf(new JSONObject(str2).getInt("version"))});
                        com.tencent.mm.a.e.f(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
            x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.f(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.f(fileInputStream);
            throw e;
        }
    }

    public static int Of() {
        Reader bufferedReader;
        Throwable e;
        InputStream open;
        Reader inputStreamReader;
        try {
            open = ad.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    try {
                        x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
                            x.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str2, Integer.valueOf(new JSONObject(str2).getInt("version"))});
                            com.tencent.mm.a.e.f(open);
                            com.tencent.mm.a.e.a(inputStreamReader);
                            com.tencent.mm.a.e.a(bufferedReader);
                            return r0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.f(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    return 1;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStreamReader = null;
                x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
}
