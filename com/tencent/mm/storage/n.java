package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends i<m> {
    public static final String[] diD = new String[]{i.a(m.dhO, "BackupTempMoveTime")};
    public e diF;

    public final /* bridge */ /* synthetic */ boolean a(long j, c cVar) {
        return super.a(j, (m) cVar);
    }

    public n(h hVar) {
        super(hVar, m.dhO, "BackupTempMoveTime", null);
        this.diF = hVar;
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        if (getCount() <= 0) {
            linkedList3.addAll(linkedList);
            linkedList4.addAll(linkedList2);
            return;
        }
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    LinkedList linkedList5;
                    long longValue2 = ((Long) it.next()).longValue();
                    if (longValue2 == 0) {
                        longValue2 = Long.MAX_VALUE;
                    }
                    LinkedList linkedList6 = new LinkedList();
                    String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\" ";
                    x.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:" + str2);
                    Cursor rawQuery = this.diF.rawQuery(str2, null);
                    if (rawQuery == null) {
                        x.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", new Object[]{str});
                        linkedList5 = null;
                    } else {
                        while (rawQuery.moveToNext()) {
                            m mVar = new m();
                            mVar.d(rawQuery);
                            es esVar = new es();
                            esVar.startTime = mVar.field_startTime;
                            esVar.endTime = mVar.field_endTime;
                            linkedList6.add(esVar);
                        }
                        rawQuery.close();
                        linkedList5 = linkedList6;
                    }
                    if (linkedList5 == null || linkedList5.size() <= 0 || longValue2 < ((es) linkedList5.getFirst()).startTime || longValue > ((es) linkedList5.getLast()).endTime) {
                        linkedList3.add(str);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    } else {
                        Object obj2;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= linkedList5.size() || longValue > longValue2) {
                                obj2 = obj;
                            } else {
                                es esVar2 = (es) linkedList5.get(i2);
                                if (longValue <= esVar2.endTime) {
                                    if (longValue < esVar2.startTime) {
                                        obj = 1;
                                        linkedList3.add(str);
                                        linkedList4.add(Long.valueOf(longValue));
                                        if (longValue2 < esVar2.startTime) {
                                            linkedList4.add(Long.valueOf(longValue2));
                                            longValue = esVar2.startTime;
                                            obj2 = 1;
                                            break;
                                        }
                                        linkedList4.add(Long.valueOf(esVar2.startTime));
                                    }
                                    longValue = esVar2.endTime;
                                }
                                i = i2 + 1;
                            }
                        }
                        if (longValue <= longValue2) {
                            linkedList3.add(str);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                            linkedList3.add(str);
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

    public final boolean ckt() {
        x.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", new Object[]{Boolean.valueOf(this.diF.fV("BackupTempMoveTime", "delete from BackupTempMoveTime"))});
        return this.diF.fV("BackupTempMoveTime", "delete from BackupTempMoveTime");
    }
}
