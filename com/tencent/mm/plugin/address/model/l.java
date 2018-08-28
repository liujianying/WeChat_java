package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l {
    private static final Pattern eXS = Pattern.compile("(-|\\s)+");
    public a eXO = new a();
    public final List<RcptItem> eXP = new ArrayList();
    public final HashMap<String, List<RcptItem>> eXQ = new HashMap();
    public final HashMap<String, List<RcptItem>> eXR = new HashMap();
    public String path;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Zy() {
        /*
        r13 = this;
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = "load data";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        com.tencent.mm.model.au.HU();
        r8 = com.tencent.mm.model.c.Gq();
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = "initAddressData";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r9 = r0.getAssets();
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r6 = "";
        r5 = "";
        r10 = new java.util.ArrayList;
        r10.<init>();
        r7 = 0;
        r1 = new java.io.FileReader;	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r0.<init>();	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r0 = r0.append(r8);	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r11 = "address";
        r0 = r0.append(r11);	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r0 = r0.toString();	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r1.<init>(r0);	 Catch:{ IOException -> 0x02ce, all -> 0x017f }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x02d2 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x02d2 }
        r10.clear();	 Catch:{ IOException -> 0x005b, all -> 0x02ca }
    L_0x0051:
        r0 = r2.readLine();	 Catch:{ IOException -> 0x005b, all -> 0x02ca }
        if (r0 == 0) goto L_0x0155;
    L_0x0057:
        r10.add(r0);	 Catch:{ IOException -> 0x005b, all -> 0x02ca }
        goto L_0x0051;
    L_0x005b:
        r0 = move-exception;
        r3 = r2;
    L_0x005d:
        r2 = "MicroMsg.WalletAddrMgr";
        r11 = "";
        r12 = 0;
        r12 = new java.lang.Object[r12];	 Catch:{ all -> 0x02c7 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r11, r12);	 Catch:{ all -> 0x02c7 }
        if (r1 == 0) goto L_0x006e;
    L_0x006b:
        r1.close();	 Catch:{ Exception -> 0x016f }
    L_0x006e:
        if (r3 == 0) goto L_0x0073;
    L_0x0070:
        r3.close();	 Catch:{ Exception -> 0x016f }
    L_0x0073:
        r2 = r3;
    L_0x0074:
        if (r7 != 0) goto L_0x00ab;
    L_0x0076:
        r10.clear();	 Catch:{ IOException -> 0x02be, all -> 0x01c4 }
        r0 = "address";
        r3 = r9.open(r0);	 Catch:{ IOException -> 0x02be, all -> 0x01c4 }
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x02c3, all -> 0x01c4 }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x02c3, all -> 0x01c4 }
        r4 = "utf-8";
        r0.<init>(r3, r4);	 Catch:{ IOException -> 0x02c3, all -> 0x01c4 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x02c3, all -> 0x01c4 }
    L_0x008d:
        r0 = r1.readLine();	 Catch:{ IOException -> 0x0097 }
        if (r0 == 0) goto L_0x019a;
    L_0x0093:
        r10.add(r0);	 Catch:{ IOException -> 0x0097 }
        goto L_0x008d;
    L_0x0097:
        r0 = move-exception;
    L_0x0098:
        r2 = "MicroMsg.WalletAddrMgr";
        r4 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x02bb }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r4, r9);	 Catch:{ all -> 0x02bb }
        if (r1 == 0) goto L_0x00a9;
    L_0x00a6:
        r1.close();	 Catch:{ IOException -> 0x01b5 }
    L_0x00a9:
        if (r3 == 0) goto L_0x00ab;
    L_0x00ab:
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = new java.lang.StringBuilder;
        r2 = "read from addr ";
        r1.<init>(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r9 = r10.size();
        r0 = 0;
        r2 = r5;
        r3 = r6;
        r7 = r0;
    L_0x00c9:
        if (r7 >= r9) goto L_0x0269;
    L_0x00cb:
        r0 = r10.get(r7);
        r0 = (java.lang.String) r0;
        r1 = r7 + 1;
        if (r1 >= r9) goto L_0x01da;
    L_0x00d5:
        r1 = r7 + 1;
        r1 = r10.get(r1);
        r1 = (java.lang.String) r1;
    L_0x00dd:
        r4 = "\t";
        r5 = "-";
        r0 = r0.replace(r4, r5);
        r4 = "　";
        r5 = "-";
        r0 = r0.replace(r4, r5);
        r4 = "\t";
        r5 = "-";
        r1 = r1.replace(r4, r5);
        r4 = "　";
        r5 = "-";
        r5 = r1.replace(r4, r5);
        r1 = 0;
        r4 = 6;
        r1 = r0.substring(r1, r4);
        r4 = 6;
        r6 = r0.substring(r4);
        r0 = new java.lang.StringBuilder;
        r4 = "-";
        r0.<init>(r4);
        r0 = r0.append(r6);
        r0 = r0.toString();
        r4 = eXS;
        r4 = r4.split(r0);
        r0 = r4.length;
        r11 = 3;
        if (r0 != r11) goto L_0x01df;
    L_0x012a:
        r0 = new com.tencent.mm.plugin.address.model.RcptItem;
        r11 = 1;
        r11 = r4[r11];
        r12 = 2;
        r4 = r4[r12];
        r0.<init>(r11, r1, r4);
        r4 = r0;
    L_0x0136:
        if (r4 != 0) goto L_0x01e3;
    L_0x0138:
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = new java.lang.StringBuilder;
        r4 = "analyze address data. missing ";
        r1.<init>(r4);
        r1 = r1.append(r6);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r2;
    L_0x014f:
        r1 = r7 + 1;
        r2 = r0;
        r7 = r1;
        goto L_0x00c9;
    L_0x0155:
        r3 = 1;
        r1.close();	 Catch:{ Exception -> 0x015f }
        r2.close();	 Catch:{ Exception -> 0x015f }
        r7 = r3;
        goto L_0x0074;
    L_0x015f:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r7 = "";
        r11 = 0;
        r11 = new java.lang.Object[r11];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r7, r11);
        r7 = r3;
        goto L_0x0074;
    L_0x016f:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r2 = "";
        r11 = 0;
        r11 = new java.lang.Object[r11];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r11);
        r2 = r3;
        goto L_0x0074;
    L_0x017f:
        r0 = move-exception;
        r1 = r2;
    L_0x0181:
        if (r1 == 0) goto L_0x0186;
    L_0x0183:
        r1.close();	 Catch:{ Exception -> 0x018c }
    L_0x0186:
        if (r3 == 0) goto L_0x018b;
    L_0x0188:
        r3.close();	 Catch:{ Exception -> 0x018c }
    L_0x018b:
        throw r0;
    L_0x018c:
        r1 = move-exception;
        r2 = "MicroMsg.WalletAddrMgr";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x018b;
    L_0x019a:
        r1.close();	 Catch:{ IOException -> 0x0097 }
        r3.close();	 Catch:{ IOException -> 0x0097 }
        r1.close();	 Catch:{ IOException -> 0x01a7 }
    L_0x01a3:
        if (r3 == 0) goto L_0x00ab;
    L_0x01a5:
        goto L_0x00ab;
    L_0x01a7:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r2 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r4);
        goto L_0x01a3;
    L_0x01b5:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r2 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r4);
        goto L_0x00a9;
    L_0x01c4:
        r0 = move-exception;
        r1 = r2;
    L_0x01c6:
        if (r1 == 0) goto L_0x01cb;
    L_0x01c8:
        r1.close();	 Catch:{ IOException -> 0x01cc }
    L_0x01cb:
        throw r0;
    L_0x01cc:
        r1 = move-exception;
        r2 = "MicroMsg.WalletAddrMgr";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x01cb;
    L_0x01da:
        r1 = "";
        goto L_0x00dd;
    L_0x01df:
        r0 = 0;
        r4 = r0;
        goto L_0x0136;
    L_0x01e3:
        r0 = "----";
        r0 = r6.startsWith(r0);
        if (r0 == 0) goto L_0x0211;
    L_0x01ec:
        r0 = r13.eXR;
        r0 = r0.containsKey(r2);
        if (r0 != 0) goto L_0x01fe;
    L_0x01f4:
        r0 = r13.eXR;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.put(r2, r1);
    L_0x01fe:
        r0 = r13.eXR;
        r0 = r0.get(r2);
        r0 = (java.util.List) r0;
        r0.add(r4);
        r1 = r13.eXR;
        r1.put(r2, r0);
        r0 = r2;
        goto L_0x014f;
    L_0x0211:
        r0 = "---";
        r0 = r6.startsWith(r0);
        if (r0 == 0) goto L_0x024b;
    L_0x021a:
        r0 = r13.eXQ;
        r0 = r0.containsKey(r3);
        if (r0 != 0) goto L_0x022c;
    L_0x0222:
        r0 = r13.eXQ;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r0.put(r3, r2);
    L_0x022c:
        r0 = r13.eXQ;
        r0 = r0.get(r3);
        r0 = (java.util.List) r0;
        r2 = "----";
        r2 = aO(r5, r2);
        if (r2 == 0) goto L_0x0240;
    L_0x023d:
        r2 = 1;
        r4.eXN = r2;
    L_0x0240:
        r0.add(r4);
        r2 = r13.eXQ;
        r2.put(r3, r0);
        r0 = r1;
        goto L_0x014f;
    L_0x024b:
        r0 = "-";
        r0 = r6.startsWith(r0);
        if (r0 == 0) goto L_0x02d5;
    L_0x0254:
        r0 = "---";
        r0 = aO(r5, r0);
        if (r0 == 0) goto L_0x0260;
    L_0x025d:
        r0 = 1;
        r4.eXN = r0;
    L_0x0260:
        r0 = r13.eXP;
        r0.add(r4);
        r0 = r2;
        r3 = r1;
        goto L_0x014f;
    L_0x0269:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r8);
        r1 = "addrmgr";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r13.path = r0;
        r0 = new java.io.File;
        r1 = r13.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x028f;
    L_0x028c:
        r0.mkdir();
    L_0x028f:
        r0 = r13.path;
        r1 = 0;
        r2 = -1;
        r0 = com.tencent.mm.a.e.e(r0, r1, r2);
        r1 = r13.ZA();
        r0 = decrypt(r0, r1);
        r1 = new com.tencent.mm.plugin.address.d.a;	 Catch:{ Exception -> 0x02ad }
        r1.<init>();	 Catch:{ Exception -> 0x02ad }
        r0 = r1.aG(r0);	 Catch:{ Exception -> 0x02ad }
        r0 = (com.tencent.mm.plugin.address.d.a) r0;	 Catch:{ Exception -> 0x02ad }
        r13.eXO = r0;	 Catch:{ Exception -> 0x02ad }
    L_0x02ac:
        return;
    L_0x02ad:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x02ac;
    L_0x02bb:
        r0 = move-exception;
        goto L_0x01c6;
    L_0x02be:
        r0 = move-exception;
        r1 = r2;
        r3 = r4;
        goto L_0x0098;
    L_0x02c3:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0098;
    L_0x02c7:
        r0 = move-exception;
        goto L_0x0181;
    L_0x02ca:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0181;
    L_0x02ce:
        r0 = move-exception;
        r1 = r2;
        goto L_0x005d;
    L_0x02d2:
        r0 = move-exception;
        goto L_0x005d;
    L_0x02d5:
        r0 = r2;
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.model.l.Zy():void");
    }

    public final b jq(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.eXO.eXW.size()) {
                return null;
            }
            b bVar = (b) this.eXO.eXW.get(i3);
            if (bVar.id == i) {
                return bVar;
            }
            i2 = i3 + 1;
        }
    }

    public final boolean a(b bVar) {
        if (this.eXO == null) {
            this.eXO = new a();
        }
        for (int i = 0; i < this.eXO.eXW.size(); i++) {
            if (((b) this.eXO.eXW.get(i)).id == bVar.id) {
                this.eXO.eXW.remove(i);
                return true;
            }
        }
        return false;
    }

    public final boolean q(LinkedList<bez> linkedList) {
        this.eXO.eXW.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bez bez = (bez) it.next();
            b bVar = new b();
            bVar.id = bez.id;
            bVar.eYf = bez.sgF.siM;
            bVar.eXZ = bez.sgz.siM;
            bVar.eYc = bez.sgC.siM;
            bVar.eYa = bez.sgA.siM;
            bVar.eYd = bez.sgD.siM;
            bVar.eYe = bez.sgE.siM;
            bVar.eXY = bez.sgy.siM;
            bVar.eYb = bez.sgB.siM;
            this.eXO.eXW.add(bVar);
        }
        return true;
    }

    public final void Zz() {
        try {
            byte[] toByteArray = this.eXO.toByteArray();
            long currentTimeMillis = System.currentTimeMillis();
            toByteArray = encrypt(toByteArray, ZA());
            e.deleteFile(this.path);
            e.b(this.path, toByteArray, toByteArray.length);
            x.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
        }
    }

    private byte[] ZA() {
        return g.u(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            return null;
        }
    }

    public final List<RcptItem> pW(String str) {
        return this.eXQ.containsKey(str) ? (List) this.eXQ.get(str) : new ArrayList();
    }

    public final List<RcptItem> pX(String str) {
        return this.eXR.containsKey(str) ? (List) this.eXR.get(str) : new ArrayList();
    }

    private static boolean aO(String str, String str2) {
        if (str.substring(6).startsWith(str2)) {
            return true;
        }
        return false;
    }

    public final RcptItem x(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        RcptItem e = e(this.eXP, str);
        if (e == null || TextUtils.isEmpty(e.code)) {
            return null;
        }
        e = e(pW(e.code), str2);
        if (e == null || TextUtils.isEmpty(e.code)) {
            return null;
        }
        if (TextUtils.isEmpty(str3)) {
            return e;
        }
        RcptItem e2 = e(pX(e.code), str3);
        if (e2 != null) {
            return e2;
        }
        return e;
    }

    private static RcptItem e(List<RcptItem> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            RcptItem rcptItem = (RcptItem) list.get(i2);
            if (rcptItem != null && str.equals(rcptItem.name)) {
                return rcptItem;
            }
            i = i2 + 1;
        }
    }

    public final boolean y(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        RcptItem e = e(this.eXP, str);
        if (e == null || TextUtils.isEmpty(e.code)) {
            return false;
        }
        e = e(pW(e.code), str2);
        if (e == null || TextUtils.isEmpty(e.code)) {
            return false;
        }
        if (TextUtils.isEmpty(str3) || e(pX(e.code), str3) != null) {
            return true;
        }
        return false;
    }
}
