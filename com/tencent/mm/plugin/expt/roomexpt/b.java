package com.tencent.mm.plugin.expt.roomexpt;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class b extends i<e> {
    public static final String[] ciG = new String[0];
    public static final String[] diD = new String[]{i.a(e.dhO, "RoomMuteExpt"), "CREATE UNIQUE INDEX IF NOT EXISTS namedayIndex ON RoomMuteExpt( chatroom,daySec )"};
    e diF;

    public b(e eVar) {
        super(eVar, e.dhO, "RoomMuteExpt", ciG);
        this.diF = eVar;
    }

    public final e cG(String str, String str2) {
        e eVar;
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = this.diF.query("RoomMuteExpt", null, "chatroom=? AND daySec=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        eVar = new e();
                        try {
                            eVar.d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.ChatRoomExptStorage", "getRoomExpt item error[%s]", new Object[]{e.toString()});
                                if (query != null) {
                                    query.close();
                                }
                                return eVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        return eVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    eVar = null;
                    x.e("MicroMsg.ChatRoomExptStorage", "getRoomExpt item error[%s]", new Object[]{e.toString()});
                    if (query != null) {
                        query.close();
                    }
                    return eVar;
                }
            }
            eVar = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            eVar = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return eVar;
    }

    public final boolean b(e eVar) {
        return super.a(eVar, false);
    }

    public final boolean c(e eVar) {
        if (eVar == null) {
            return false;
        }
        return super.b(eVar, false, new String[]{"chatroom", "daySec"});
    }

    public final Cursor aIC() {
        Cursor cursor = null;
        try {
            return this.diF.rawQuery("SELECT chatroom, nickname, isMute, count(daySec), sum(score) FROM RoomMuteExpt group by chatroom", null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "get calc cursor", new Object[0]);
            return cursor;
        }
    }

    public final List<e> aID() {
        Throwable e;
        List<e> arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.diF.query("RoomMuteExpt", null, null, null, null, null, "chatroom,daySec ASC");
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        e eVar = new e();
                        eVar.d(query);
                        arrayList.add(eVar);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "getAllExpt", new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return arrayList;
    }
}
