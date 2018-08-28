package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends i<i> {
    public static final String[] diD = new String[]{i.a(i.dhO, "BackupMoveTime")};
    public e diF;

    public j(h hVar) {
        super(hVar, i.dhO, "BackupMoveTime", null);
        this.diF = hVar;
        long currentTimeMillis = System.currentTimeMillis();
        long dO = hVar.dO(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new String[]{"CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )"}));
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.fV("BackupMoveTime", (String) arrayList.get(i));
        }
        x.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        hVar.gp(dO);
        x.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(String str, LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    et etVar;
                    long longValue2 = ((Long) it.next()).longValue();
                    if (longValue2 == 0) {
                        longValue2 = Long.MAX_VALUE;
                    }
                    String str3 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" AND sessionName = \"" + str2 + "\" ";
                    x.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:" + str3);
                    Cursor rawQuery = this.diF.rawQuery(str3, null);
                    if (rawQuery == null) {
                        x.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", new Object[]{str, str2});
                        etVar = null;
                    } else if (rawQuery.moveToFirst()) {
                        i iVar = new i();
                        iVar.d(rawQuery);
                        rawQuery.close();
                        etVar = iVar.field_moveTime;
                    } else {
                        rawQuery.close();
                        etVar = null;
                    }
                    if (etVar == null || etVar.rfg.size() <= 0 || longValue2 < ((es) etVar.rfg.getFirst()).startTime || longValue > ((es) etVar.rfg.getLast()).endTime) {
                        linkedList3.add(str2);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    } else {
                        Object obj2;
                        LinkedList linkedList5 = etVar.rfg;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= linkedList5.size() || longValue > longValue2) {
                                obj2 = obj;
                            } else {
                                es esVar = (es) linkedList5.get(i2);
                                if (longValue <= esVar.endTime) {
                                    if (longValue < esVar.startTime) {
                                        obj = 1;
                                        linkedList3.add(str2);
                                        linkedList4.add(Long.valueOf(longValue));
                                        if (longValue2 < esVar.startTime) {
                                            linkedList4.add(Long.valueOf(longValue2));
                                            longValue = esVar.startTime;
                                            obj2 = 1;
                                            break;
                                        }
                                        linkedList4.add(Long.valueOf(esVar.startTime));
                                    }
                                    longValue = esVar.endTime;
                                }
                                i = i2 + 1;
                            }
                        }
                        obj2 = obj;
                        if (longValue <= longValue2) {
                            linkedList3.add(str2);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                            linkedList3.add(str2);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void d(String str, LinkedList<m> linkedList) {
        HashMap hashMap;
        x.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
        HashMap hashMap2 = new HashMap();
        String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" ";
        x.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:" + str2);
        Cursor rawQuery = this.diF.rawQuery(str2, null);
        if (rawQuery == null) {
            x.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", new Object[]{str});
            hashMap = hashMap2;
        } else {
            while (rawQuery.moveToNext()) {
                i iVar = new i();
                iVar.d(rawQuery);
                hashMap2.put(iVar.field_sessionName, iVar);
            }
            rawQuery.close();
            hashMap = hashMap2;
        }
        if (this.diF.delete("BackupMoveTime", "deviceId= ? ", new String[]{str}) < 0) {
            x.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", new Object[]{str});
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            i iVar2 = (i) hashMap.get(mVar.field_sessionName);
            if (iVar2 == null) {
                es esVar = new es();
                esVar.startTime = mVar.field_startTime;
                esVar.endTime = mVar.field_endTime;
                i iVar3 = new i();
                iVar3.field_deviceId = str;
                iVar3.field_sessionName = mVar.field_sessionName;
                iVar3.field_moveTime = new et();
                iVar3.field_moveTime.rfg = new LinkedList();
                iVar3.field_moveTime.rfg.add(esVar);
                hashMap.put(mVar.field_sessionName, iVar3);
            } else {
                a(iVar2.field_moveTime.rfg, mVar);
            }
        }
        for (String str3 : hashMap.keySet()) {
            x.i("MicroMsg.BackupMoveTimeStorage", "summerbak insert BackupMoveTimeStorage ret[%b], sessionName:%s", new Object[]{Boolean.valueOf(b((c) hashMap.get(str3))), str3});
        }
    }

    private static void a(LinkedList<es> linkedList, m mVar) {
        if (mVar.field_startTime <= mVar.field_endTime) {
            Object obj;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                es esVar = (es) it.next();
                if (mVar.field_startTime < esVar.endTime) {
                    if (mVar.field_endTime < esVar.startTime) {
                        esVar = new es();
                        esVar.startTime = mVar.field_startTime;
                        esVar.endTime = mVar.field_endTime;
                        linkedList.add(esVar);
                        obj = 1;
                    } else {
                        int obj2;
                        if (mVar.field_startTime < esVar.startTime) {
                            esVar.startTime = mVar.field_startTime;
                        }
                        if (mVar.field_endTime > esVar.endTime) {
                            esVar.endTime = mVar.field_endTime;
                            while (it.hasNext()) {
                                es esVar2 = (es) it.next();
                                if (mVar.field_endTime <= esVar2.startTime) {
                                    break;
                                } else if (mVar.field_endTime <= esVar2.endTime) {
                                    esVar.endTime = esVar2.endTime;
                                    it.remove();
                                    obj2 = 1;
                                    break;
                                } else {
                                    it.remove();
                                }
                            }
                        }
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        esVar = new es();
                        esVar.startTime = mVar.field_startTime;
                        esVar.endTime = mVar.field_endTime;
                        linkedList.add(esVar);
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
                esVar = new es();
                esVar.startTime = mVar.field_startTime;
                esVar.endTime = mVar.field_endTime;
                linkedList.add(esVar);
            }
        }
    }

    public final boolean ckt() {
        x.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", new Object[]{Boolean.valueOf(this.diF.fV("BackupMoveTime", "delete from BackupMoveTime"))});
        return this.diF.fV("BackupMoveTime", "delete from BackupMoveTime");
    }
}
