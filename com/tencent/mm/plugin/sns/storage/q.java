package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class q extends i<p> {
    public static final String[] diD = new String[]{i.a(p.dhO, "SnsReportKv")};
    public h dCZ;

    public q(h hVar) {
        super(hVar, p.dhO, "SnsReportKv", p.ciG);
        this.dCZ = hVar;
    }

    public final int a(bow bow) {
        bow bow2 = new bow();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bow.rbN.size(); i3++) {
            apz apz = (apz) bow.rbN.get(i3);
            if (apz.rSu.lR.length + i2 > 51200) {
                a(bow2, i2);
                i++;
                bow2.rbN.clear();
                i2 = 0;
            } else {
                i2 += apz.rSu.lR.length;
                bow2.rbN.add(apz);
            }
        }
        if (bow2.rbN.size() <= 0) {
            return i;
        }
        i++;
        a(bow2, i2);
        return i;
    }

    private int a(bow bow, int i) {
        try {
            byte[] toByteArray = bow.toByteArray();
            p pVar = new p();
            pVar.field_value = toByteArray;
            pVar.field_logtime = System.currentTimeMillis();
            pVar.field_logsize = i;
            pVar.field_offset = 0;
            int insert = (int) this.dCZ.insert("SnsReportKv", "", pVar.wH());
            x.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result " + insert);
            return insert;
        } catch (Exception e) {
            return 0;
        }
    }

    public final bow dz(int i, int i2) {
        Throwable e;
        String str = "select rowid, *  from SnsReportKv";
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 > 0) {
            str = str + " where rowid <= " + i2;
        }
        Cursor b = this.dCZ.b(str, null, 0);
        bow bow = new bow();
        List<Integer> arrayList = new ArrayList();
        stringBuffer.append("target size " + i + " current maxcolid " + i2);
        if (b.moveToFirst()) {
            int i3 = 0;
            do {
                p pVar = new p();
                pVar.d(b);
                int i4 = pVar.field_offset;
                stringBuffer.append("|offset: " + i4);
                bow bow2 = new bow();
                try {
                    int i5;
                    bow2.aG(pVar.field_value);
                    while (true) {
                        try {
                            i5 = i3;
                            if (i4 >= bow2.rbN.size()) {
                                i3 = 0;
                                break;
                            }
                            apz apz = (apz) bow2.rbN.get(i4);
                            if (apz.rSu.lR.length + i5 > i) {
                                if (i5 == 0) {
                                    arrayList.add(Integer.valueOf(pVar.nJc));
                                    x.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + i + " vlauesize " + apz.rSu.lR.length);
                                }
                                i3 = 1;
                            } else {
                                pVar.field_offset = i4 + 1;
                                bow.rbN.add(apz);
                                i5 += apz.rSu.lR.length;
                                i3 = i4 + 1;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i3 = i5;
                            x.printErrStackTrace("MicroMsg.SnsKvReportStg", e, "", new Object[0]);
                            arrayList.add(Integer.valueOf(pVar.nJc));
                            x.i("MicroMsg.SnsKvReportStg", "error paser then delete " + pVar.nJc);
                            if (!b.moveToNext()) {
                                x.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
                                b.close();
                                for (Integer intValue : arrayList) {
                                    delete((long) intValue.intValue());
                                }
                                return bow;
                            }
                        }
                    }
                    stringBuffer.append("|read end on " + pVar.nJc + " and get size " + i5);
                    if (i3 == 0 || pVar.field_offset > bow2.rbN.size()) {
                        stringBuffer.append("|read full ");
                        arrayList.add(Integer.valueOf(pVar.nJc));
                    } else {
                        a((long) pVar.nJc, pVar);
                        stringBuffer.append("|update new offset " + pVar.field_offset);
                    }
                    if (i3 != 0) {
                        break;
                    }
                    i3 = i5;
                } catch (Throwable e3) {
                    e = e3;
                }
            } while (b.moveToNext());
            x.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
        }
        b.close();
        while (r1.hasNext()) {
            delete((long) intValue.intValue());
        }
        return bow;
    }
}
