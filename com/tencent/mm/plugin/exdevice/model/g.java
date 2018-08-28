package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.btx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class g implements e {
    String bSW;
    long cYP;
    String dVk = "";
    public a dVu = new 2(this);
    long dlN;
    String iuA = "send_data_sucess";
    String iuB = "send_data_failed";
    private String iuC = "send_data_sending";
    boolean iuD = false;
    boolean iuE = false;
    public HashMap<String, String> iuF = new HashMap();
    amw iuG;
    long iuH;
    List<b> iuI = null;
    List<b> iuJ = new ArrayList();
    HashMap<String, String> iuK = new HashMap();
    HashMap<String, Integer> iuL = new HashMap();
    HashMap<String, Boolean> iuM = new HashMap();
    j.a iuN;
    j.a iuO;
    j.a iuP;
    j.a iuQ;
    Runnable iuR = new 1(this);
    amw iuS;
    String iuT;
    String iuU;
    int iuV;
    HashMap<Integer, String> iuW = new HashMap();
    boolean iuu = false;
    boolean iuv = false;
    boolean iuw = false;
    String iux;
    String iuy;
    int iuz;

    static /* synthetic */ void a(g gVar, String str, int i) {
        ed edVar = new ed();
        edVar.bLX.byN = str;
        if (i >= 100) {
            edVar.bLX.bLZ = gVar.iuA;
        } else {
            edVar.bLX.bLZ = gVar.iuC;
        }
        edVar.bLX.progress = i;
        com.tencent.mm.sdk.b.a.sFg.m(edVar);
    }

    static /* synthetic */ void aR(List list) {
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i)).field_deviceID);
            hashMap.put("displayName", c((b) list.get(i)));
            hashMap.put("iconUrl", ((b) list.get(i)).iconUrl);
            hashMap.put("ability", ((b) list.get(i)).cCX);
            hashMap.put("abilityInf", ((b) list.get(i)).cCY);
            arrayList.add(hashMap);
        }
        dz dzVar = new dz();
        dzVar.bLM.bKZ = arrayList;
        com.tencent.mm.sdk.b.a.sFg.m(dzVar);
    }

    public g() {
        this.iuJ.clear();
        this.iuK.clear();
        this.iuM.clear();
        this.iuI = ad.aHe().aHI();
        if (this.iuI != null && this.iuI.size() > 0) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[]{Integer.valueOf(this.iuI.size())});
            int size = this.iuI.size();
            int i = 0;
            while (i < size) {
                if (((b) this.iuI.get(i)).cCX.contains("internet_to_device") && !((b) this.iuI.get(i)).cCX.contains("wechat_to_device")) {
                    this.iuJ.add(this.iuI.get(i));
                }
                i++;
            }
            this.iuQ = new 3(this);
            this.iuN = new 4(this);
            this.iuO = new 5(this);
            this.iuP = new 6(this);
            au.DF().a(1717, this);
            j.aGV().a(14, this.iuN);
            j.aGV().a(12, this.iuO);
            j.aGV().a(13, this.iuP);
            j.aGV().a(15, this.iuQ);
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    static Boolean cC(long j) {
        boolean z = false;
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        String str = dW.field_content;
        if (dW.getType() == 49) {
            g$a gp = g$a.gp(str);
            if (gp != null && gp.type == 6) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    static Boolean cD(long j) {
        boolean z = false;
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dW.getType() == 3) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean cE(long j) {
        boolean z = false;
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dW.cmo()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean cF(long j) {
        boolean z = false;
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dW.getType() == 62) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static byte[] zX(String str) {
        Throwable e;
        byte[] bArr = null;
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", new Object[]{str});
        u a;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            a = com.tencent.mm.network.b.a(str, null);
            try {
                a.setRequestMethod("GET");
                a.setConnectTimeout(25000);
                a.setReadTimeout(25000);
                inputStream = a.getInputStream();
                try {
                    if (a.getResponseCode() == 200) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.close();
                            inputStream.close();
                            a.aBv.disconnect();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.aBv.disconnect();
                        } catch (Exception e3) {
                            e22 = e3;
                        }
                    } else {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                            }
                        }
                        a.aBv.disconnect();
                    }
                } catch (Exception e4) {
                    e222 = e4;
                    byteArrayOutputStream = bArr;
                    try {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.aBv.disconnect();
                        }
                        return bArr;
                    } catch (Throwable th) {
                        e22222 = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th2) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th2, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th22) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th22, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.aBv.disconnect();
                        }
                        throw e22222;
                    }
                } catch (Throwable th3) {
                    e22222 = th3;
                    byteArrayOutputStream = bArr;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th222, "", new Object[0]);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th2222, "", new Object[0]);
                        }
                    }
                    if (a != null) {
                        a.aBv.disconnect();
                    }
                    throw e22222;
                }
            } catch (Exception e5) {
                e22222 = e5;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
            } catch (Throwable th4) {
                e22222 = th4;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th22222) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th22222, "", new Object[0]);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th222222) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th222222, "", new Object[0]);
                    }
                }
                if (a != null) {
                    a.aBv.disconnect();
                }
                throw e22222;
            }
        } catch (Exception e6) {
            e22222 = e6;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
        } catch (Throwable th5) {
            e22222 = th5;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2222222) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th2222222, "", new Object[0]);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th22222222) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", th22222222, "", new Object[0]);
                }
            }
            if (a != null) {
                a.aBv.disconnect();
            }
            throw e22222;
        }
        return bArr;
    }

    public final bsu aGT() {
        hu huVar = new hu();
        huVar.bRf.bKW = this.iux;
        com.tencent.mm.sdk.b.a.sFg.m(huVar);
        return huVar.bRg.bRh;
    }

    final boolean a(amw amw, long j) {
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String cG = cG(j);
        if (cG != null && cG.length() > 0) {
            File file = new File(cG);
            str2 = file.getName();
            i = (int) file.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = com.tencent.mm.a.g.m(file);
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[]{cG});
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[]{Integer.valueOf(i)});
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[]{str});
        }
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            return false;
        }
        switch (dW.getType()) {
            case 3:
                amx amx = new amx();
                amx.rxo = str3;
                amx.jPe = str2;
                amx.hcy = i;
                amx.rwk = str;
                amw.rPF = amx;
                amw.rPC = 3;
                break;
            case 48:
                au.HU();
                bd.b GS = c.FT().GS(dW.field_content);
                amy amy = new amy();
                amy.rjG = (float) GS.kCw;
                amy.rjH = (float) GS.kCx;
                amy.rPK = (float) GS.bSz;
                amy.jTh = GS.label;
                amy.rPL = GS.kFa;
                amw.rPE = amy;
                amw.rPC = 2;
                break;
            case 49:
            case 268435505:
                g$a gp = g$a.gp(dW.field_content);
                if (gp != null) {
                    if (gp.type != 3) {
                        if (gp.type != 6) {
                            if (gp.type != 5) {
                                if (gp.type == 2) {
                                    amx amx2 = new amx();
                                    amx2.rxo = "jpg";
                                    amx2.jPe = str2;
                                    amx2.hcy = i;
                                    amx2.rwk = str;
                                    amw.rPF = amx2;
                                    amw.rPC = 3;
                                    break;
                                }
                            }
                            ana ana = new ana();
                            ana.jPK = gp.url;
                            ana.bHD = gp.title;
                            ana.rPM = gp.description;
                            ana.jSv = gp.appName;
                            amw.rPH = ana;
                            amw.rPC = 5;
                            break;
                        }
                        amv amv = new amv();
                        amv.rxo = gp.dwp;
                        amv.jPe = gp.title;
                        amv.hcy = i;
                        amv.rwk = str;
                        amw.rPG = amv;
                        amw.rPC = 4;
                        break;
                    }
                    amz amz = new amz();
                    amz.bHD = gp.title;
                    amz.rPM = gp.description;
                    amz.jPK = gp.url;
                    amz.rPN = gp.dwn;
                    amz.rst = gp.dwN;
                    amz.rPO = gp.dwO;
                    amz.jSv = gp.appName;
                    amz.rPP = gp.dwE;
                    amz.rPQ = gp.dwF;
                    amz.rPR = gp.dwL;
                    amw.rPD = amz;
                    amw.rPC = 1;
                    break;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                return false;
                break;
            case 62:
                anb anb = new anb();
                anb.rxo = str3;
                anb.hcy = i;
                anb.rwk = str;
                anb.jPe = str2;
                amw.rPI = anb;
                amw.rPC = 6;
                break;
        }
        return true;
    }

    static String y(String str, long j) {
        Throwable e;
        IOException e2;
        if (str == null) {
            return null;
        }
        String substring = str.substring(0, str.lastIndexOf("/"));
        substring = substring + "/" + ("image_hd_" + str.hashCode());
        OutputStream cVar;
        InputStream openRead;
        try {
            cVar = new com.tencent.mm.modelsfs.c(new File(substring), j);
            try {
                openRead = FileOp.openRead(str);
                try {
                    byte[] bArr = new byte[1024];
                    while (openRead.read(bArr) != -1) {
                        cVar.write(bArr);
                    }
                    try {
                        cVar.flush();
                        cVar.close();
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e3) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3, "", new Object[0]);
                                return null;
                            }
                        }
                        return substring;
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32, "", new Object[0]);
                        return null;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    try {
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e322) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            return null;
                        }
                        try {
                            openRead.close();
                            return null;
                        } catch (Throwable e3222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222, "", new Object[0]);
                            return null;
                        }
                    } catch (Throwable th) {
                        e3222 = th;
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e32222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e322222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222, "", new Object[0]);
                                return null;
                            }
                        }
                        throw e322222;
                    }
                }
            } catch (IOException e5) {
                e2 = e5;
                openRead = null;
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
                if (cVar != null) {
                    try {
                        cVar.flush();
                        cVar.close();
                    } catch (Throwable e3222222) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222222, "", new Object[0]);
                        return null;
                    }
                }
                if (openRead != null) {
                    return null;
                }
                try {
                    openRead.close();
                    return null;
                } catch (Throwable e32222222) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222222, "", new Object[0]);
                    return null;
                }
            } catch (Throwable th2) {
                e32222222 = th2;
                openRead = null;
                if (cVar != null) {
                    try {
                        cVar.flush();
                        cVar.close();
                    } catch (Throwable e322222222) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222222, "", new Object[0]);
                        return null;
                    }
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (Throwable e3222222222) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222222222, "", new Object[0]);
                        return null;
                    }
                }
                throw e3222222222;
            }
        } catch (IOException e6) {
            e2 = e6;
            openRead = null;
            cVar = null;
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
            if (cVar != null) {
                try {
                    cVar.flush();
                    cVar.close();
                } catch (Throwable e32222222222) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222222222, "", new Object[0]);
                    return null;
                }
            }
            if (openRead != null) {
                return null;
            }
            try {
                openRead.close();
                return null;
            } catch (Throwable e322222222222) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222222222, "", new Object[0]);
                return null;
            }
        } catch (Throwable th3) {
            e322222222222 = th3;
            openRead = null;
            cVar = null;
            if (cVar != null) {
                try {
                    cVar.flush();
                    cVar.close();
                } catch (Throwable e3222222222222) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222222222222, "", new Object[0]);
                    return null;
                }
            }
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (Throwable e32222222222222) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222222222222, "", new Object[0]);
                    return null;
                }
            }
            throw e32222222222222;
        }
    }

    private String cG(long j) {
        String str = "";
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            return "";
        }
        int type = dW.getType();
        String str2 = dW.field_content;
        if (dW.aQm()) {
            g$a gp = g$a.gp(str2);
            if (gp != null && (gp.type == 6 || gp.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(gp.bGP);
                if (SR != null) {
                    return SR.field_fileFullPath;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                return str;
            } else if (gp == null) {
                return str;
            } else {
                if (gp.type != 3 && gp.type != 5) {
                    return str;
                }
                this.iuv = true;
                return str;
            }
        } else if (type == 3) {
            com.tencent.mm.ak.e q = o.Pf().q(dW);
            if (q == null) {
                return str;
            }
            str = o.Pf().lN(q.dTL);
            if (bi.oW(str)) {
                return o.Pf().lN(q.dTN);
            }
            return str;
        } else if (type == 62) {
            com.tencent.mm.modelvideo.o.Ta();
            return s.nK(dW.field_imgPath);
        } else if (type != 48) {
            return str;
        } else {
            this.iuv = true;
            return str;
        }
    }

    static void cx(String str, String str2) {
        ed edVar = new ed();
        edVar.bLX.bLZ = str2;
        edVar.bLX.byN = str;
        com.tencent.mm.sdk.b.a.sFg.m(edVar);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar == null) {
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
        } else if (lVar instanceof n) {
            n nVar = (n) lVar;
            if (i == 0 && i2 == 0) {
                btx btx = (nVar.diG == null || nVar.diG.dIE.dIL == null) ? null : (btx) nVar.diG.dIE.dIL;
                String str2 = btx.srp;
                if (1 == nVar.ivD) {
                    cx(nVar.byN, this.iuA);
                    return;
                }
                String str3 = nVar.byN;
                String str4 = (String) this.iuK.get(str3);
                cx(str3, this.iuC);
                String cG = (!this.iuw || this.iux == null) ? cG(this.cYP) : this.iuy;
                if (str4 == null || str4.length() == 0) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    cx(str3, this.iuB);
                    return;
                }
                if (!this.iuu) {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.iuu = true;
                }
                if (!(this.iuM.containsKey(str3) && ((Boolean) this.iuM.get(str3)).booleanValue())) {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: " + str4);
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        cx(str3, this.iuB);
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.iuv) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.iuW.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.iuL.put(str3, Integer.valueOf(useWCLanDeviceService));
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: " + useWCLanDeviceService);
                        return;
                    }
                    cx(str3, this.iuB);
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    return;
                } else if (cG == null || cG.length() == 0) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    cx(str3, this.iuB);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), cG.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.iuW.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.iuL.put(str3, Integer.valueOf(useWCLanDeviceService));
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =" + useWCLanDeviceService);
                        return;
                    }
                    cx(str3, this.iuB);
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                    return;
                }
            }
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            cx(nVar.byN, this.iuB);
        }
    }

    static String c(b bVar) {
        if (bVar == null) {
            return "";
        }
        String str = null;
        if (!bi.oW(bVar.cCR)) {
            str = bVar.cCR;
        } else if (!bi.oW(bVar.cCS)) {
            str = bVar.cCS;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.cY(bVar.field_mac);
        } else if (!bi.oW(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        return bi.oV(str);
    }
}
