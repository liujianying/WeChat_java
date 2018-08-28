package com.tencent.mm.plugin.expt.c;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c extends i<b> {
    public static final String[] ciG = new String[0];
    public static final String[] diD = new String[]{i.a(b.dhO, "ExptKeyMapId")};
    private e diF;

    public c(e eVar) {
        super(eVar, b.dhO, "ExptKeyMapId", ciG);
        this.diF = eVar;
    }

    public final int AD(String str) {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            int i;
            query = this.diF.query("ExptKeyMapId", new String[]{"exptId"}, "exptKey=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        i = query.getInt(0);
                        if (query != null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", new Object[]{str, e.toString()});
                        if (query != null) {
                            query.close();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            i = -1;
            if (query != null) {
                return i;
            }
            query.close();
            return i;
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final b AE(String str) {
        b bVar;
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = this.diF.query("ExptKeyMapId", null, "exptKey=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        bVar = new b();
                        try {
                            bVar.d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", new Object[]{str, e.toString()});
                                if (query != null) {
                                    query.close();
                                }
                                return bVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        return bVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bVar = null;
                    x.e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", new Object[]{str, e.toString()});
                    if (query != null) {
                        query.close();
                    }
                    return bVar;
                }
            }
            bVar = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            bVar = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return bVar;
    }

    public final int aW(List<b> list) {
        h hVar;
        Exception e;
        long j = -1;
        if (list.size() <= 0) {
            return 0;
        }
        int i;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            j = hVar2.dO(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            i = 0;
            for (b a : list) {
                try {
                    int i2;
                    if (a(a, false)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", new Object[]{e.toString()});
                        if (hVar != null) {
                            hVar.gp(j);
                        }
                        x.i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
                        return i;
                    } catch (Throwable th) {
                        if (hVar != null) {
                            hVar.gp(j);
                        }
                    }
                }
            }
            if (hVar != null) {
                hVar.gp(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            x.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", new Object[]{e.toString()});
            if (hVar != null) {
                hVar.gp(j);
            }
            x.i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
            return i;
        }
        x.i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
        return i;
    }

    public final int aX(List<b> list) {
        h hVar;
        Exception e;
        long j = -1;
        if (list.size() <= 0) {
            return 0;
        }
        int i;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            j = hVar2.dO(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            i = 0;
            for (b bVar : list) {
                try {
                    int i2;
                    if (a(bVar.sKx, bVar, false)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", new Object[]{e.toString()});
                        if (hVar != null) {
                            hVar.gp(j);
                        }
                        x.i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
                        return i;
                    } catch (Throwable th) {
                        if (hVar != null) {
                            hVar.gp(j);
                        }
                    }
                }
            }
            if (hVar != null) {
                hVar.gp(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            x.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", new Object[]{e.toString()});
            if (hVar != null) {
                hVar.gp(j);
            }
            x.i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
            return i;
        }
        x.i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
        return i;
    }

    public final int aY(List<Integer> list) {
        h hVar;
        Exception e;
        long j = -1;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            j = hVar2.dO(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            i = 0;
            for (Integer intValue : list) {
                try {
                    int intValue2 = intValue.intValue();
                    if (this.diF.delete("ExptKeyMapId", "exptId=?", new String[]{String.valueOf(intValue2)}) > 0) {
                        intValue2 = i + 1;
                    } else {
                        intValue2 = i;
                    }
                    i = intValue2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", new Object[]{e.toString(), Integer.valueOf(i)});
                        if (hVar != null) {
                            hVar.gp(j);
                        }
                        x.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
                        return i;
                    } catch (Throwable th) {
                        if (hVar != null) {
                            hVar.gp(j);
                        }
                    }
                }
            }
            if (hVar != null) {
                hVar.gp(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            x.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", new Object[]{e.toString(), Integer.valueOf(i)});
            if (hVar != null) {
                hVar.gp(j);
            }
            x.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
            return i;
        }
        x.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i)});
        return i;
    }

    public final int aIG() {
        int i = 0;
        try {
            return this.diF.delete("ExptKeyMapId", null, null);
        } catch (Exception e) {
            x.e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", new Object[]{e.toString()});
            return i;
        }
    }
}
