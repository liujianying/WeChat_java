package com.tencent.mm.plugin.expt.c;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends i<a> {
    public static final String[] ciG = new String[0];
    public static final String[] diD = new String[]{i.a(a.dhO, "ExptItem")};
    private e diF;

    public d(e eVar) {
        super(eVar, a.dhO, "ExptItem", ciG);
        this.diF = eVar;
    }

    public final a pp(int i) {
        a aVar;
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = this.diF.query("ExptItem", null, "exptId=?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar = new a();
                        try {
                            aVar.d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.ExptStorage", "get expt error [%s]", new Object[]{e.toString()});
                                if (query != null) {
                                    query.close();
                                }
                                return aVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        return aVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    aVar = null;
                    x.e("MicroMsg.ExptStorage", "get expt error [%s]", new Object[]{e.toString()});
                    if (query != null) {
                        query.close();
                    }
                    return aVar;
                }
            }
            aVar = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            aVar = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return aVar;
    }

    public final List<a> aIH() {
        List<a> linkedList;
        Exception e;
        Throwable th;
        Cursor rawQuery;
        try {
            rawQuery = this.diF.rawQuery("select rowid,exptId,groupId,exptSeq from ExptItem order by exptId", null);
            if (rawQuery != null) {
                try {
                    linkedList = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        try {
                            a aVar = new a();
                            aVar.d(rawQuery);
                            linkedList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.ExptStorage", "get all expt without content error [%s]", new Object[]{e.toString()});
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                throw th;
                            }
                        }
                    }
                    x.d("MicroMsg.ExptStorage", "get all expt without content [%d]", new Object[]{Integer.valueOf(linkedList.size())});
                } catch (Exception e3) {
                    e = e3;
                    linkedList = null;
                    x.e("MicroMsg.ExptStorage", "get all expt without content error [%s]", new Object[]{e.toString()});
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return linkedList;
                }
            }
            linkedList = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e4) {
            e = e4;
            rawQuery = null;
            linkedList = null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return linkedList;
    }

    public final ArrayList<Integer> aII() {
        ArrayList<Integer> arrayList;
        Exception e;
        Throwable th;
        Cursor rawQuery;
        try {
            rawQuery = this.diF.rawQuery("select exptId from ExptItem", null);
            if (rawQuery != null) {
                try {
                    arrayList = new ArrayList();
                    while (rawQuery.moveToNext()) {
                        try {
                            arrayList.add(Integer.valueOf(rawQuery.getInt(0)));
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.ExptStorage", "get all expt id error[%s]", new Object[]{e.toString()});
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                    x.e("MicroMsg.ExptStorage", "get all expt id error[%s]", new Object[]{e.toString()});
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return arrayList;
                }
            }
            arrayList = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e4) {
            e = e4;
            rawQuery = null;
            arrayList = null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return arrayList;
    }

    private boolean pq(int i) {
        int delete;
        try {
            delete = this.diF.delete("ExptItem", "exptId=?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            x.e("MicroMsg.ExptStorage", "delete expt by id [%s]", new Object[]{e.toString()});
            delete = 0;
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    private boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean a;
        try {
            a = super.a(aVar);
        } catch (Exception e) {
            x.e("MicroMsg.ExptStorage", "replace expt error [%s]", new Object[]{e.toString()});
            a = false;
        }
        x.d("MicroMsg.ExptStorage", "replace expt ret[%b] item[%s]", new Object[]{Boolean.valueOf(a), aVar.toString()});
        return a;
    }

    public final List<a> aZ(List<a> list) {
        h hVar;
        long j = -1;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<a> list2 = this.diF instanceof h;
        if (list2 != null) {
            h hVar2 = (h) this.diF;
            j = hVar2.dO(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            list2 = new LinkedList();
            for (a aVar : list) {
                if (a(aVar)) {
                    list2.add(aVar);
                }
            }
            return list2;
        } finally {
            if (hVar != null) {
                hVar.gp(j);
            }
        }
    }

    public final int aV(List<Integer> list) {
        long j = -1;
        int i = 0;
        if (list != null && list.size() > 0) {
            h hVar;
            if (this.diF instanceof h) {
                h hVar2 = (h) this.diF;
                j = hVar2.dO(-1);
                hVar = hVar2;
            } else {
                hVar = null;
            }
            try {
                for (Integer intValue : list) {
                    int i2;
                    if (pq(intValue.intValue())) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (hVar != null) {
                    hVar.gp(j);
                }
            } catch (Throwable th) {
                if (hVar != null) {
                    hVar.gp(j);
                }
            }
        }
        return i;
    }

    public final int aIG() {
        int i = 0;
        try {
            return this.diF.delete("ExptItem", null, null);
        } catch (Exception e) {
            x.e("MicroMsg.ExptStorage", "delete all expt error[%s]", new Object[]{e.toString()});
            return i;
        }
    }
}
