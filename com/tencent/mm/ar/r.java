package com.tencent.mm.ar;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class r implements ar {
    private static HashMap<Integer, d> cVM;
    private n ecW;
    private b ecX;
    private o ecY = new o();
    private p ecZ = new p();
    private q eda = new q();
    private l edb = null;
    c edc = new 3(this);

    private static r Qo() {
        return (r) p.v(r.class);
    }

    public static n Qp() {
        g.Eg().Ds();
        if (Qo().ecW == null) {
            Qo().ecW = new n(g.Ei().dqq);
        }
        return Qo().ecW;
    }

    public static b Qq() {
        g.Eg().Ds();
        if (Qo().ecX == null) {
            Qo().ecX = new b(g.Ei().dqq);
        }
        return Qo().ecX;
    }

    public final void onAccountRelease() {
        a.sFg.c(this.ecY);
        a.sFg.c(this.ecZ);
        a.sFg.c(this.eda);
        a.sFg.c(this.edb.ecS);
        a.sFg.c(this.edb.ecT);
        a.sFg.c(this.edc);
    }

    public final void bn(boolean z) {
        a.sFg.b(this.ecY);
        a.sFg.b(this.ecZ);
        a.sFg.b(this.eda);
        a.sFg.b(this.edc);
        if (this.edb != null) {
            this.edb.ecR.clear();
        } else {
            this.edb = new l();
        }
        a.sFg.b(this.edb.ecS);
        a.sFg.b(this.edb.ecT);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    private boolean mx(String str) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        File file = new File(str);
        if (file.exists()) {
            Map hashMap = new HashMap();
            InputStream fileInputStream;
            BufferedWriter bufferedWriter;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    File file2;
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split("\\|");
                        if (split.length < 2 || bi.oW(split[0]) || bi.oW(split[1])) {
                            x.e("MicroMsg.SubCorePacakge", "dispatch regioncode, error line = " + readLine);
                        } else {
                            bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                            if (bufferedWriter == null) {
                                RegionCodeDecoder.cmS();
                                str2 = RegionCodeDecoder.Zg(split[0]);
                                if (bi.oW(str2)) {
                                    x.e("MicroMsg.SubCorePacakge", "dispatch regioncode, output language unsupported");
                                } else {
                                    file2 = new File(str2);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                    hashMap.put(split[0], bufferedWriter);
                                }
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(split[1]);
                            stringBuffer.append('|');
                            stringBuffer.append(split[2]);
                            stringBuffer.append(10);
                            bufferedWriter.write(stringBuffer.toString());
                        }
                    }
                    for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.flush();
                        }
                    }
                    if (!bi.oW(str2)) {
                        for (File file22 : new File(str2).getParentFile().listFiles(new 4(this))) {
                            RegionCodeDecoder.cmS();
                            RegionCodeDecoder.h(file22, file22.getParentFile());
                        }
                        RegionCodeDecoder.cmS().ckJ();
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    file.delete();
                    try {
                        fileInputStream.close();
                        for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                            if (bufferedWriter22 != null) {
                                bufferedWriter22.close();
                            }
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SubCorePacakge", e2, "", new Object[0]);
                    }
                    return true;
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = fileInputStream;
                    try {
                        x.printErrStackTrace("MicroMsg.SubCorePacakge", e2, "", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.SubCorePacakge", e22, "", new Object[0]);
                                return false;
                            }
                        }
                        for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                            if (bufferedWriter222 != null) {
                                bufferedWriter222.close();
                            }
                        }
                        return false;
                    } catch (Throwable e222) {
                        th = e222;
                        fileInputStream = inputStream;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e2222) {
                                x.printErrStackTrace("MicroMsg.SubCorePacakge", e2222, "", new Object[0]);
                                throw th;
                            }
                        }
                        for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                            if (bufferedWriter2222 != null) {
                                bufferedWriter2222.close();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable e22222) {
                    th = e22222;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e222222) {
                            x.printErrStackTrace("MicroMsg.SubCorePacakge", e222222, "", new Object[0]);
                            throw th;
                        }
                    }
                    for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                        if (bufferedWriter22222 != null) {
                            bufferedWriter22222.close();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e222222 = e4;
                inputStream = null;
                x.printErrStackTrace("MicroMsg.SubCorePacakge", e222222, "", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2222222) {
                        x.printErrStackTrace("MicroMsg.SubCorePacakge", e2222222, "", new Object[0]);
                        return false;
                    }
                }
                for (BufferedWriter bufferedWriter222222 : hashMap.values()) {
                    if (bufferedWriter222222 != null) {
                        bufferedWriter222222.close();
                    }
                }
                return false;
            } catch (Throwable e22222222) {
                th = e22222222;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e222222222) {
                        x.printErrStackTrace("MicroMsg.SubCorePacakge", e222222222, "", new Object[0]);
                        throw th;
                    }
                }
                for (BufferedWriter bufferedWriter2222222 : hashMap.values()) {
                    if (bufferedWriter2222222 != null) {
                        bufferedWriter2222222.close();
                    }
                }
                throw th;
            }
        }
        x.e("MicroMsg.SubCorePacakge", "update regioncode failed, file not exist, packagePath:" + str);
        return false;
    }
}
