package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ag.a;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONObject;

public final class b extends c<bc> {
    public b() {
        this.sFo = bc.class.getName().hashCode();
    }

    private static boolean a(bc bcVar) {
        Reader inputStreamReader;
        Throwable e;
        Reader reader;
        int i;
        Throwable th;
        if (bcVar instanceof bc) {
            String str;
            if (bcVar.bIB.bIC == 33) {
                File file = new File(bcVar.bIB.filePath);
                if (file.exists()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(a.Oc(), "temp");
                    File file3 = new File(file2, "emoji_template.zip");
                    file2.mkdirs();
                    e.y(file.getAbsolutePath(), file3.getAbsolutePath());
                    if (bi.fR(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0) {
                        InputStream fileInputStream;
                        try {
                            String str2;
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                inputStreamReader = new InputStreamReader(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                reader = null;
                                inputStreamReader = null;
                                i = 1;
                                try {
                                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                    e.f(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.k(file2);
                                    e.deleteFile(file3.getPath());
                                    if (a.dRu >= i) {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                    } else {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                        a.s(file);
                                    }
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    e.f(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                reader = null;
                                inputStreamReader = null;
                                e.f(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw th;
                            }
                            try {
                                reader = new BufferedReader(inputStreamReader);
                                try {
                                    str = "";
                                    while (true) {
                                        str2 = str;
                                        str = reader.readLine();
                                        if (str == null) {
                                            break;
                                        }
                                        str = str2 + str;
                                    }
                                    i = new JSONObject(str2).getInt("version");
                                } catch (Exception e3) {
                                    e = e3;
                                    i = 1;
                                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                    e.f(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.k(file2);
                                    e.deleteFile(file3.getPath());
                                    if (a.dRu >= i) {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                    } else {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                        a.s(file);
                                    }
                                    return false;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                reader = null;
                                i = 1;
                                x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                e.f(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.k(file2);
                                e.deleteFile(file3.getPath());
                                if (a.dRu >= i) {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                } else {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                    a.s(file);
                                }
                                return false;
                            } catch (Throwable th4) {
                                th = th4;
                                reader = null;
                                e.f(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw th;
                            }
                            try {
                                x.d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", new Object[]{str2, Integer.valueOf(i)});
                                e.f(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                            } catch (Exception e5) {
                                e = e5;
                                x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                e.f(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.k(file2);
                                e.deleteFile(file3.getPath());
                                if (a.dRu >= i) {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                    a.s(file);
                                } else {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                }
                                return false;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            reader = null;
                            inputStreamReader = null;
                            i = 1;
                            fileInputStream = null;
                            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                            e.f(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            e.k(file2);
                            e.deleteFile(file3.getPath());
                            if (a.dRu >= i) {
                                x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                                a.s(file);
                            } else {
                                x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                            }
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            e.f(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            throw th;
                        }
                    }
                    i = 1;
                    e.k(file2);
                    e.deleteFile(file3.getPath());
                    if (a.dRu >= i) {
                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                        a.s(file);
                    } else {
                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.dRu), Integer.valueOf(i)});
                    }
                } else {
                    x.e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (bcVar.bIB.bIC == 37) {
                File file4;
                if (bcVar.bIB.bID == 1) {
                    i.aEd();
                    i.a(bcVar, false);
                } else if (bcVar.bIB.bID == 2) {
                    i.aEd();
                    i.b(bcVar, false);
                } else if (bcVar.bIB.bID == 3) {
                    i.aEd();
                    if (!i.a(bcVar, i.a.ifY)) {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (i.a(bcVar, i.a.ifY, i.ifC)) {
                        file4 = new File(new File(i.getDataEmojiPath(), i.ifC), i.ifN);
                        if (file4.exists()) {
                            i.I(file4);
                        } else {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (bcVar.bIB.bID == 5) {
                    i.aEd();
                    if (i.a(bcVar, i.a.iga)) {
                        if (i.a(bcVar, i.a.iga, i.ifD)) {
                            file4 = new File(new File(i.getDataEmojiPath(), i.ifD), i.ifO);
                            if (file4.exists()) {
                                i.J(file4);
                            } else {
                                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (bcVar.bIB.bID == 4) {
                    i.aEd();
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (i.b(bcVar)) {
                        com.tencent.mm.br.b.cjC();
                        str = bcVar.bIB.filePath;
                        com.tencent.mm.br.b.cjD();
                        j.fN(str, com.tencent.mm.br.b.sLq);
                        com.tencent.mm.br.b.cjC().init();
                    }
                }
            }
        }
        return false;
    }
}
