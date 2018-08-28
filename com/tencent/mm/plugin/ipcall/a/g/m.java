package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public final class m {
    public static k b(k kVar) {
        if (kVar == null) {
            return null;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.sKx)});
        if (kVar.sKx == -1) {
            return kVar;
        }
        kVar.field_status = 7;
        i.aXw().a(kVar);
        return kVar;
    }

    public static k a(k kVar, long j) {
        if (kVar == null) {
            return null;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.sKx), Long.valueOf(j)});
        if (kVar.sKx == -1) {
            return kVar;
        }
        kVar.field_status = 4;
        kVar.field_duration = j;
        i.aXw().a(kVar);
        return kVar;
    }

    public static ArrayList<k> aXY() {
        Cursor query;
        long currentTimeMillis = System.currentTimeMillis();
        l aXw = i.aXw();
        Calendar instance = Calendar.getInstance();
        instance.add(6, -30);
        long timeInMillis = instance.getTimeInMillis();
        Cursor query2 = aXw.diF.query("IPCallRecord", l.ksH, "calltime>=?", new String[]{String.valueOf(timeInMillis)}, "addressId, phonenumber", null, "calltime desc");
        if (query2.getCount() < 30) {
            query2.close();
            query = i.aXw().diF.query("IPCallRecord", l.ksH, null, null, "addressId, phonenumber", null, "calltime desc");
        } else {
            query = query2;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "finish query used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        HashMap hashMap = new HashMap();
        ArrayList<k> arrayList = new ArrayList();
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast() && arrayList.size() <= 30) {
                    k kVar = new k();
                    kVar.d(query);
                    if (kVar.field_addressId == -1) {
                        c EQ = i.aXv().EQ(a.aw(ad.getContext(), kVar.field_phonenumber));
                        if (EQ != null) {
                            aXw = i.aXw();
                            long dO = aXw.diF instanceof h ? ((h) aXw.diF).dO(-1) : -1;
                            query2 = i.aXw().ET(kVar.field_phonenumber);
                            if (query2.moveToFirst()) {
                                while (!query2.isAfterLast()) {
                                    k kVar2 = new k();
                                    kVar2.d(query2);
                                    kVar2.field_addressId = EQ.sKx;
                                    i.aXw().a(kVar2);
                                    query2.moveToNext();
                                }
                            }
                            aXw = i.aXw();
                            if ((aXw.diF instanceof h) && dO != -1) {
                                ((h) aXw.diF).gp(dO);
                            }
                            if (!hashMap.containsKey(kVar.field_addressId)) {
                                hashMap.put(kVar.field_addressId, kVar);
                                arrayList.add(kVar);
                            }
                        } else if (!hashMap.containsKey(kVar.field_phonenumber)) {
                            hashMap.put(kVar.field_phonenumber, kVar);
                            arrayList.add(kVar);
                        }
                    } else if (!hashMap.containsKey(kVar.field_addressId)) {
                        hashMap.put(kVar.field_addressId, kVar);
                        arrayList.add(kVar);
                    }
                    query.moveToNext();
                }
            }
            query.close();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser error: %s", new Object[]{e.getMessage()});
            query.close();
        } catch (Throwable th) {
            query.close();
            throw th;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser, used: %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList;
    }
}
