package com.tencent.mm.k;

import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static final String dgQ = (aa.duN + "configlist/");
    public SparseArray<d> dgP = new SparseArray();

    public static String fU(int i) {
        return dgQ + "config_" + i + ".xml";
    }

    public final boolean d(File file, File file2) {
        Throwable e;
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i >= listFiles.length) {
                    return z2;
                }
                File file3 = listFiles[i];
                z = d(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
        } else {
            InputStream fileInputStream;
            OutputStream fileOutputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        file.delete();
                        try {
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e2));
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e22));
                        }
                        return true;
                    } catch (Exception e3) {
                        e22 = e3;
                        try {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e22));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e222) {
                                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e222));
                                }
                            }
                            if (fileOutputStream != null) {
                                return false;
                            }
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (Throwable e2222) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e2222));
                                return false;
                            }
                        } catch (Throwable th) {
                            e2222 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e4) {
                                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e4));
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e5) {
                                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e5));
                                }
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e6) {
                    e2222 = e6;
                    fileOutputStream = null;
                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e2222));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22222) {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e22222));
                        }
                    }
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e222222) {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e222222));
                        return false;
                    }
                } catch (Throwable th2) {
                    e222222 = th2;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e42) {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e42));
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e52) {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e52));
                        }
                    }
                    throw e222222;
                }
            } catch (Exception e7) {
                e222222 = e7;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e222222));
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2222222) {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e2222222));
                    }
                }
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Throwable e22222222) {
                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e22222222));
                    return false;
                }
            } catch (Throwable th3) {
                e22222222 = th3;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e422) {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e422));
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e522) {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e522));
                    }
                }
                throw e22222222;
            }
        }
    }

    public final void init() {
        for (int load : d.dgR) {
            load(load);
        }
    }

    public final void p(int i, String str) {
        d dVar = new d(i);
        dVar.dgT = bl.z(str, "ConfigList");
        if (dVar.dgT.containsKey(".ConfigList.$version")) {
            dVar.version = Integer.valueOf((String) dVar.dgT.get(".ConfigList.$version")).intValue();
        }
        int i2 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (dVar.dgT.get(str2 + ".$name") != null) {
                String str3 = (String) dVar.dgT.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i3 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        String str5 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$key";
                        String str6 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$lang";
                        if (!dVar.dgT.containsKey(str4)) {
                            break;
                        }
                        String str7 = (String) dVar.dgT.get(str5);
                        str4 = (String) dVar.dgT.get(str4);
                        str5 = (String) dVar.dgT.get(str6);
                        x.d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str4 + " itemLang " + str5);
                        if (str5 == null || d.fk(str5)) {
                            if (!dVar.dgS.containsKey(str3)) {
                                dVar.dgS.put(str3, new HashMap());
                            }
                            ((HashMap) dVar.dgS.get(str3)).put(str7, str4);
                        }
                        i3++;
                    }
                }
                i2++;
            } else {
                this.dgP.put(Integer.valueOf(i).intValue(), dVar);
                return;
            }
        }
    }

    public final String G(String str, String str2) {
        d AE = AE();
        if (AE != null && AE.dgS.containsKey(str)) {
            return (String) ((HashMap) AE.dgS.get(str)).get(str2);
        }
        return null;
    }

    public final d AE() {
        if (this.dgP.get(1) == null) {
            load(1);
        }
        return (d) this.dgP.get(1);
    }

    private void load(int i) {
        Throwable e;
        InputStream fileInputStream;
        try {
            File file = new File(fU(i));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    p(i, stringBuffer.toString());
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e3) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e3));
                            }
                        }
                    } catch (Throwable th) {
                        e3 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e4));
                            }
                        }
                        throw e3;
                    }
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e32) {
                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e32));
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            fileInputStream = null;
            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e32));
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e322) {
                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e322));
                }
            }
        } catch (Throwable th2) {
            e322 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e42) {
                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e42));
                }
            }
            throw e322;
        }
    }

    public static int AF() {
        int i;
        String value = ((a) g.l(a.class)).AT().getValue("VoiceVOIPSwitch");
        x.d("MicroMsg.ConfigListDecoder", "voip is " + value);
        try {
            i = bi.getInt(value, 0);
        } catch (Throwable e) {
            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bi.i(e));
            i = 0;
        }
        x.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is " + i);
        return i;
    }

    public final boolean AG() {
        boolean z = true;
        if (bi.getInt(G("WebViewConfig", "disableWePkg"), 0) != 1) {
            z = false;
        }
        x.d("MicroMsg.ConfigListDecoder", "disableWePkg : " + z);
        return z;
    }

    public final String AH() {
        x.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", G("FreeWiFiConfig", "CheckURL"));
        return G("FreeWiFiConfig", "CheckURL");
    }

    public final boolean AI() {
        boolean z = true;
        if (bi.getInt(G("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        x.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : " + z);
        return z;
    }

    public final List<String> AJ() {
        List<String> list = null;
        String G = G("IBeacon", "Content");
        if (!bi.oW(G)) {
            list = new ArrayList();
            try {
                Iterator keys = new JSONObject(G.replace(",}", "}")).keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null) {
                        list.add(next.toString());
                    }
                }
            } catch (JSONException e) {
                x.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e.getMessage());
            }
        }
        return list;
    }

    public final String AK() {
        return G("MailApp", "MailAppRedirectUrAndroid");
    }

    public final String getMailAppEnterUlAndroid() {
        return G("MailApp", "MailAppEnterMailAppUrlAndroid");
    }
}
