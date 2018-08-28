package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;

public final class c {
    private static int hjT = 1;
    private static int hjU = 1;

    public static int auc() {
        return hjT;
    }

    public static int aud() {
        return hjU;
    }

    public static void ng(int i) {
        hjT = i;
    }

    public static void nh(int i) {
        hjU = i;
    }

    public static int aue() {
        return k.GB();
    }

    public static int ni(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 34;
            case 4:
                return 43;
            default:
                return -1;
        }
    }

    public static String wU(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public static void wV(String str) {
        String[] strArr = null;
        a.ezo.vl();
        au.HU();
        if (com.tencent.mm.model.c.FT().GT(str) == 1) {
            au.HU();
            bd GE = com.tencent.mm.model.c.FT().GE(str);
            if (GE != null && GE.field_talker.equals(str)) {
                String wU = wU(str);
                if (!bi.oW(wU)) {
                    a aVar;
                    Cursor b = i.auk().dCZ.b("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bi.oU(wU) + "\"", null, 0);
                    if (b == null) {
                        aVar = null;
                    } else {
                        if (b.moveToFirst()) {
                            strArr = new a();
                            strArr.hjN = b.getString(0);
                            strArr.hjO = b.getInt(1);
                            strArr.hjP = b.getString(2);
                            strArr.hjQ = b.getInt(3);
                            strArr.msgType = b.getInt(4);
                            strArr.hjR = b.getInt(5);
                            strArr.content = b.getString(6);
                            strArr.hjS = b.getLong(7);
                            strArr.dCV = b.getInt(8);
                            strArr.dSJ = b.getInt(9);
                            strArr.dCX = b.getString(10);
                            strArr.dCY = b.getString(11);
                        }
                        b.close();
                        aVar = strArr;
                    }
                    if (aVar != null && aVar.aub().equals(wU) && aVar.hjQ == 1) {
                        bd bdVar = new bd();
                        bdVar.ep(str);
                        bdVar.ay(GE.field_createTime <= aVar.hjS ? GE.field_createTime - 1 : aVar.hjS);
                        bdVar.setType(ni(aVar.msgType));
                        bdVar.setStatus(2);
                        bdVar.eX(1);
                        if (bdVar.getType() == 34) {
                            bdVar.setContent(n.b(q.GF(), (long) aVar.hjR, false));
                            String str2 = aVar.getContent() + bi.VF();
                            if (j.fN(com.tencent.mm.modelvoice.q.getFullPath(aVar.getContent()), com.tencent.mm.modelvoice.q.getFullPath(str2))) {
                                bdVar.eq(str2);
                            } else {
                                x.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.getContent());
                                return;
                            }
                        }
                        bdVar.setContent(aVar.getContent());
                        au.HU();
                        com.tencent.mm.model.c.FT().T(bdVar);
                    }
                }
            }
        }
    }

    public static void auf() {
        String[] strArr;
        b auk = i.auk();
        Cursor b = auk.dCZ.b("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < " + (bi.VF() - 7776000000L), null, 0);
        int count = b.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i = 0; i < count; i++) {
                b.moveToPosition(i);
                if (b.getInt(1) == 3) {
                    strArr[i] = b.getString(0);
                } else {
                    strArr[i] = null;
                }
            }
        } else {
            strArr = null;
        }
        b.close();
        if (count > 0) {
            auk.dCZ.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(r6)});
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                x.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]));
                if (!bi.oW(com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]))) {
                    e.deleteFile(com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]));
                }
            }
        }
    }

    public static String a(Context context, ab abVar) {
        if (abVar == null) {
            return context.getString(R.l.bottle_unknowed_city);
        }
        if (!RegionCodeDecoder.Zh(abVar.getCountryCode())) {
            return context.getString(R.l.bottle_unknowed_city);
        }
        String city = abVar.getCity();
        if (!bi.oW(city)) {
            return city;
        }
        city = r.gV(abVar.getProvince());
        if (!bi.oW(city)) {
            return city;
        }
        RegionCodeDecoder.cmS();
        return RegionCodeDecoder.getLocName(abVar.getCountryCode());
    }

    public static String b(Context context, ab abVar) {
        if (abVar == null) {
            return context.getString(R.l.bottle_unknowed_city);
        }
        String gV = r.gV(abVar.getProvince());
        if (RegionCodeDecoder.Zh(abVar.getCountryCode())) {
            if (bi.oW(abVar.getCity())) {
                StringBuilder stringBuilder = new StringBuilder();
                RegionCodeDecoder.cmS();
                gV = stringBuilder.append(RegionCodeDecoder.getLocName(abVar.getCountryCode())).append(gV).toString();
            } else {
                gV = gV + abVar.getCity();
            }
        }
        return bi.oW(gV) ? context.getString(R.l.bottle_unknowed_city) : gV;
    }
}
