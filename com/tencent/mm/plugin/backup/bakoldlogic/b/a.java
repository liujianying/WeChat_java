package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.plugin.backup.a.a {
    private static String END = "img";
    private static String gWc = "icon_";
    private static String gWd = "iphone";
    private static String gWe = "android";
    private static String gWf = "s60v3";
    private static String gWg = "s60v5";
    private static a gZc;
    private Map<String, a> gWi = null;

    public static a wJ(String str) {
        if (gZc == null) {
            gZc = new a();
        }
        a aVar = gZc;
        if (aVar.gWi == null) {
            aVar.arU();
        }
        for (a aVar2 : aVar.gWi.values()) {
            if (aVar2.gWk != null && aVar2.gWk.equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    public static a wK(String str) {
        a aVar;
        if (gZc == null) {
            aVar = new a();
            gZc = aVar;
            a(aVar);
        }
        aVar = gZc;
        if (aVar.gWi == null) {
            aVar.arU();
        }
        return (a) aVar.gWi.get(str);
    }

    public final void aqK() {
        gZc = null;
    }

    public a() {
        arU();
    }

    private void arU() {
        Throwable e;
        Throwable th;
        int i = 0;
        this.gWi = new HashMap();
        InputStream open;
        BufferedReader bufferedReader;
        try {
            open = ad.getContext().getAssets().open("emojiconf");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Exception e2) {
                            }
                        } else if (readLine.contains(gWc)) {
                            a aVar = new a();
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && !readLine2.contains(END)) {
                                    int indexOf = readLine2.indexOf("=");
                                    if (indexOf + 1 >= readLine2.length()) {
                                        break;
                                    }
                                    String substring = readLine2.substring(indexOf + 1);
                                    if (readLine2.startsWith(gWd)) {
                                        aVar.gWk = substring;
                                    } else if (readLine2.startsWith(gWe)) {
                                        aVar.gWj = substring;
                                    } else if (readLine2.startsWith(gWf)) {
                                        aVar.gWl = substring;
                                    } else if (readLine2.startsWith(gWg)) {
                                        aVar.gWm = substring;
                                    }
                                    this.gWi.put(aVar.gWj, aVar);
                                } else {
                                    break;
                                }
                            }
                            x.d("MicroMsg.BakOldEmojiCovertMap", "emojiValue:%s", aVar.toString());
                            i++;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (open != null) {
                                open.close();
                            }
                            x.d("MicroMsg.BakOldEmojiCovertMap", "id " + i);
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e5) {
                                    throw th;
                                }
                            }
                            if (open != null) {
                                open.close();
                            }
                            throw th;
                        }
                    }
                }
                bufferedReader.close();
                if (open != null) {
                    open.close();
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
                x.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e42) {
                    }
                }
                if (open != null) {
                    open.close();
                }
                x.d("MicroMsg.BakOldEmojiCovertMap", "id " + i);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e52) {
                        throw th;
                    }
                }
                if (open != null) {
                    open.close();
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
            open = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            open = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e522) {
                    throw th;
                }
            }
            if (open != null) {
                open.close();
            }
            throw th;
        }
        x.d("MicroMsg.BakOldEmojiCovertMap", "id " + i);
    }
}
