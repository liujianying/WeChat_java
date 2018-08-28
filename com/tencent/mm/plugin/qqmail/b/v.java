package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.k.a;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class v implements e {
    String bSS;
    String[] mcN;
    String[] mcO;
    String[] mcP;
    String mck;
    String mdA;
    Map<String, String> mdB = new HashMap();
    Map<String, String> mdC = new LinkedHashMap();
    Map<String, String> mdD = new LinkedHashMap();
    private b mdE;
    public t mdF;
    Map<String, String> mdG = new HashMap();
    f mdH = null;
    HashMap<Long, Integer> mdI = new HashMap();
    HashMap<Long, String> mdJ = new HashMap();
    HashMap<String, Integer> mdK = new HashMap();
    int mdL = 0;
    ArrayList<g> mdM = new ArrayList();
    String mdN = null;
    String mdO = null;
    HashMap<String, String> mdP = new HashMap();
    c mdQ;
    d mdR;
    int mdS = 0;
    f mdT = new 7(this);
    e mdy = null;

    public v() {
        au.DF().a(483, this);
        au.DF().a(484, this);
        au.DF().a(485, this);
    }

    public final void uW(int i) {
        if (this.mdH != null) {
            ah.A(new 1(this, i));
        }
    }

    public final void a(f fVar, e eVar) {
        this.mdH = fVar;
        this.mdy = eVar;
        if (this.mdB.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.mdB.keySet()) {
                x.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[]{str});
                arrayList.add(Long.valueOf(bi.getLong(str, 0)));
            }
            2 2 = new 2(this);
            x.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
            this.mdL = 0;
            J(arrayList);
            if (this.mdJ != null) {
                this.mdJ.clear();
                this.mdJ = null;
            }
            this.mdJ = new HashMap();
            this.mdE = 2;
            au.DF().a(new l(arrayList), 0);
            return;
        }
        uW(90);
        bos();
    }

    final void bos() {
        a[] aVarArr;
        int i;
        int i2;
        String str;
        a[] aVarArr2;
        int i3;
        int i4;
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i5 = 0;
        int i6 = 0;
        if (this.mdC == null || this.mdC.size() <= 0) {
            aVarArr = null;
        } else {
            a[] aVarArr3 = new a[this.mdC.size()];
            Iterator it = this.mdC.keySet().iterator();
            while (true) {
                i = i6;
                i2 = i5;
                if (!it.hasNext()) {
                    break;
                }
                str = (String) it.next();
                a aVar = new a();
                aVar.mcT = (String) this.mdC.get(str);
                aVar.fileName = str;
                aVar.name = (String) this.mdD.get(str);
                aVar.fileSize = com.tencent.mm.a.e.cm(str);
                aVarArr3[i2] = aVar;
                x.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[]{Integer.valueOf(i2), aVar.mcT, aVar.fileName, aVar.name, Integer.valueOf(aVar.fileSize)});
                i5 = i2 + 1;
                i6 = aVar.fileSize + i;
            }
            aVarArr = aVarArr3;
            i6 = i;
        }
        i5 = 0;
        if (this.mdG == null || this.mdG.size() <= 0) {
            aVarArr2 = null;
            i3 = i6;
        } else {
            a[] aVarArr4 = new a[this.mdG.size()];
            Iterator it2 = this.mdG.keySet().iterator();
            while (true) {
                i = i6;
                i4 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                str = (String) it2.next();
                a aVar2 = new a();
                aVar2.mcT = (String) this.mdG.get(str);
                aVar2.fileName = str;
                aVar2.fileSize = bi.a((Integer) this.mdK.get(aVar2.mcT), 0);
                if (aVar2.fileSize == 0) {
                    aVar2.fileSize = com.tencent.mm.a.e.cm(str);
                }
                aVarArr4[i4] = aVar2;
                x.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[]{Integer.valueOf(i4), aVar2.mcT, aVar2.fileName, Integer.valueOf(aVar2.fileSize)});
                i5 = i4 + 1;
                i6 = aVar2.fileSize + i;
            }
            aVarArr2 = aVarArr4;
            i3 = i;
        }
        x.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[]{Integer.valueOf(i3)});
        a[] aVarArr5 = (aVarArr2 == null || aVarArr2.length == 0) ? null : aVarArr2;
        a[] aVarArr6 = (aVarArr == null || aVarArr.length == 0) ? null : aVarArr;
        5 5 = new 5(this);
        k kVar = new k(this.bSS, this.mcN, this.mcO, this.mcP, this.mck);
        kVar.mcQ = this.mdA;
        if (aVarArr6 == null || aVarArr6.length <= 0) {
            kVar.mcS = null;
        } else {
            kVar.mcS = new a[aVarArr6.length];
            for (i5 = 0; i5 < kVar.mcS.length; i5++) {
                kVar.mcS[i5] = aVarArr6[i5];
            }
            x.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[]{Integer.valueOf(kVar.mcS.length)});
        }
        if (aVarArr5 == null || aVarArr5.length <= 0) {
            kVar.mcR = null;
        } else {
            kVar.mcR = aVarArr5;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (kVar.bSS != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(kVar.bSS.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(kVar.bSS);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bon();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.boo();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bop();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder4.append("Subject: ");
        if (kVar.mck != null) {
            stringBuilder4.append(kVar.mck);
        }
        stringBuilder4.append("\n");
        stringBuilder4.append("Mime-Version: 1.0");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Transfer-Encoding: 8Bit");
        stringBuilder4.append("\n");
        stringBuilder4.append("Date: " + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()));
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-MIME: TCMime 1.0 by Tencent");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3.append("This is a multi-part message in MIME format.");
        stringBuilder3.append("\n");
        stringBuilder3.append("\r\n");
        stringBuilder = new StringBuilder("");
        stringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Type:text/html;charset=\"utf-8\"");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Transfer-Encoding:base64");
        stringBuilder.append("\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(Base64.encodeToString(kVar.mcQ.getBytes(), 0));
        stringBuilder.append("\n");
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        if (kVar.mcR != null && kVar.mcR.length > 0) {
            for (a aVar3 : kVar.mcR) {
                String str2 = aVar3.mcT;
                String str3 = aVar3.fileName;
                int i7 = aVar3.fileSize;
                StringBuilder stringBuilder5 = new StringBuilder("");
                stringBuilder5.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append("Content-Transfer-Encoding:base64");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-ID:<%s>", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append("\r\n");
                stringBuilder5.append(String.format("QQMail-LinkID:%s", new Object[]{str2}));
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i7)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LineLen:72");
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-BreakType:1");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{k.JU(str2)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append("\n");
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("\r\n");
        if (kVar.mcS != null && kVar.mcS.length > 0) {
            for (a aVar4 : kVar.mcS) {
                String str4 = aVar4.mcT;
                int i8 = aVar4.fileSize;
                String str5 = aVar4.name;
                StringBuilder stringBuilder6 = new StringBuilder("");
                stringBuilder6.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str5.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str5.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("Content-Transfer-Encoding:base64");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-ID:<%s>", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                stringBuilder6.append("\n");
                stringBuilder6.append("\r\n");
                stringBuilder6.append(String.format("QQMail-LinkID:%s", new Object[]{str4}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i8)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LineLen:72");
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-BreakType:1");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{k.JU(str4)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append("\n");
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        au.DF().a(new m(stringBuilder3.toString(), this.bSS, this.mcN, i3, new 8(this, 5)), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (lVar.getType() == 483) {
                a((l) lVar);
            } else if (this.mdy != null) {
                ah.A(new 6(this));
            }
        } else if (lVar.getType() == 483) {
            a((l) lVar);
        } else if (lVar.getType() != 484) {
            lVar.getType();
        }
    }

    private void J(ArrayList<Long> arrayList) {
        if (this.mdI != null) {
            this.mdI.clear();
            this.mdI = null;
        }
        this.mdI = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mdI.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
    }

    private static ArrayList<Long> m(HashMap<Long, Integer> hashMap) {
        ArrayList<Long> arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void a(l lVar) {
        this.mdL++;
        x.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[]{Integer.valueOf(this.mdL)});
        Iterator it = ((np) lVar.diG.dIE.dIL).rrF.iterator();
        while (it.hasNext()) {
            qd qdVar = (qd) it.next();
            long j = (long) qdVar.rci;
            int i = qdVar.hcd;
            if (this.mdI.containsKey(Long.valueOf(j))) {
                x.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                if (i == 0) {
                    this.mdI.remove(Long.valueOf(j));
                    if (qdVar.ruD != null) {
                        x.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[]{Long.valueOf(j), qdVar.ruD});
                        this.mdJ.put(Long.valueOf(j), qdVar.ruD);
                        this.mdK.put(qdVar.ruD, Integer.valueOf(qdVar.ruE));
                    }
                } else {
                    this.mdI.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.mdI.isEmpty()) {
            x.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.mdE != null) {
                this.mdE.a(new ArrayList(), this.mdJ);
            }
        } else if (this.mdL < 3) {
            x.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            au.DF().a(new l(m(this.mdI)), 0);
        } else {
            this.mdE.a(m(this.mdI), this.mdJ);
        }
    }
}
