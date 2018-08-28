package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b {
    public static HashMap<String, Integer> edk;

    public static void Qs() {
        List<RecoveryStatusItem> a = RecoveryReporter.a(ad.getContext(), "ProcessStatus", RecoveryStatusItem.class);
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + a.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : a) {
            a aVar = hashMap.containsKey(recoveryStatusItem.processName) ? (a) hashMap.get(recoveryStatusItem.processName) : new a();
            b bVar = hashMap2.containsKey(recoveryStatusItem.processName) ? (b) hashMap2.get(recoveryStatusItem.processName) : new b();
            aVar.edl++;
            if (recoveryStatusItem.vhi == 1) {
                aVar.edo++;
            } else {
                aVar.edp++;
            }
            Object obj = null;
            int obj2;
            switch (recoveryStatusItem.vhk) {
                case 1:
                    if (recoveryStatusItem.vhi != 1) {
                        bVar.eds++;
                        switch (recoveryStatusItem.vhl) {
                            case 4096:
                                bVar.edA++;
                                obj2 = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.edw++;
                                obj2 = 1;
                                break;
                        }
                    }
                    bVar.edr++;
                    switch (recoveryStatusItem.vhl) {
                        case 4096:
                            bVar.edz++;
                            obj2 = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.edv++;
                            obj2 = 1;
                            break;
                    }
                    break;
                case 16:
                    if (recoveryStatusItem.vhi != 1) {
                        bVar.edu++;
                        switch (recoveryStatusItem.vhl) {
                            case 4096:
                                bVar.edC++;
                                obj2 = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.edy++;
                                obj2 = 1;
                                break;
                        }
                    }
                    bVar.edt++;
                    switch (recoveryStatusItem.vhl) {
                        case 4096:
                            bVar.edB++;
                            obj2 = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.edx++;
                            obj2 = 1;
                            break;
                    }
                    break;
            }
            if (obj2 == null) {
                x.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, aVar);
            hashMap2.put(recoveryStatusItem.processName, bVar);
        }
        j(hashMap);
        k(hashMap2);
        RecoveryReporter.bH(ad.getContext(), "ProcessStatus");
    }

    private static void j(HashMap<String, a> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (edk.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) edk.get(entry.getKey())).intValue();
                a aVar = (a) entry.getValue();
                if (aVar.edl > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) aVar.edl);
                    arrayList.add(iDKey);
                }
                if (aVar.edm > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) aVar.edm);
                    arrayList.add(iDKey);
                }
                if (aVar.edn > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) aVar.edn);
                    arrayList.add(iDKey);
                }
                if (aVar.edo > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) aVar.edo);
                    arrayList.add(iDKey);
                }
                if (aVar.edp > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) aVar.edp);
                    arrayList.add(iDKey);
                }
                if (aVar.edq > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) aVar.edq);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            h.mEJ.b(arrayList, true);
        }
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", ad.getProcessName(), hashMap.toString());
    }

    private static void k(HashMap<String, b> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (edk.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) edk.get(entry.getKey())).intValue();
                b bVar = (b) entry.getValue();
                if (bVar.edr > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) bVar.edr);
                    arrayList.add(iDKey);
                }
                if (bVar.eds > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) bVar.eds);
                    arrayList.add(iDKey);
                }
                if (bVar.edt > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) bVar.edt);
                    arrayList.add(iDKey);
                }
                if (bVar.edu > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) bVar.edu);
                    arrayList.add(iDKey);
                }
                if (bVar.edv > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) bVar.edv);
                    arrayList.add(iDKey);
                }
                if (bVar.edw > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) bVar.edw);
                    arrayList.add(iDKey);
                }
                if (bVar.edx > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 6);
                    iDKey.SetValue((long) bVar.edx);
                    arrayList.add(iDKey);
                }
                if (bVar.edy > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 7);
                    iDKey.SetValue((long) bVar.edy);
                    arrayList.add(iDKey);
                }
                if (bVar.edz > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 8);
                    iDKey.SetValue((long) bVar.edz);
                    arrayList.add(iDKey);
                }
                if (bVar.edA > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 9);
                    iDKey.SetValue((long) bVar.edA);
                    arrayList.add(iDKey);
                }
                if (bVar.edB > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 10);
                    iDKey.SetValue((long) bVar.edB);
                    arrayList.add(iDKey);
                }
                if (bVar.edC > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(442);
                    iDKey.SetKey(intValue + 11);
                    iDKey.SetValue((long) bVar.edC);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            h.mEJ.b(arrayList, true);
        }
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", ad.getProcessName(), hashMap.toString());
    }

    static {
        HashMap hashMap = new HashMap();
        edk = hashMap;
        hashMap.put(ad.getPackageName(), Integer.valueOf(0));
        edk.put(ad.getPackageName() + ":push", Integer.valueOf(20));
        edk.put(ad.getPackageName() + ":tools", Integer.valueOf(40));
        edk.put(ad.getPackageName() + ":exdevice", Integer.valueOf(60));
        edk.put(ad.getPackageName() + ":sandbox", Integer.valueOf(80));
    }
}
