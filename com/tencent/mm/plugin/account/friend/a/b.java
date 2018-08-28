package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class b extends m {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final h dCZ;

    public b(h hVar) {
        this.dCZ = hVar;
        String str = "addr_upload2";
        Cursor b = hVar.b("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = b.getColumnIndex("name");
        Object obj = null;
        Object obj2 = null;
        while (b.moveToNext()) {
            if (columnIndex >= 0) {
                String string = b.getString(columnIndex);
                if ("lvbuf".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("showhead".equalsIgnoreCase(string)) {
                    obj = 1;
                }
            }
        }
        b.close();
        if (obj2 == null) {
            hVar.fV(str, "Alter table " + str + " add lvbuf BLOB ");
        }
        if (obj == null) {
            hVar.fV(str, "Alter table " + str + " add showhead int ");
        }
    }

    public final boolean Z(List<String> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        bg bgVar = new bg("MicroMsg.AddrUploadStorage", "delete transaction");
        bgVar.addSplit("begin");
        long dO = this.dCZ.dO(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.dCZ.delete("addr_upload2", "id =?", new String[]{a.pn(str)});
                    x.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        b(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUploadStorage", e, "", new Object[0]);
            z = false;
        }
        this.dCZ.gp(dO);
        bgVar.addSplit("end");
        bgVar.dumpToLog();
        return z;
    }

    public final boolean L(List<a> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z;
        bg bgVar = new bg("MicroMsg.AddrUploadStorage", "transaction");
        bgVar.addSplit("transation begin");
        long dO = this.dCZ.dO(Thread.currentThread().getId());
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= list.size()) {
                    z = true;
                    break;
                }
                a aVar = (a) list.get(i2);
                if (aVar != null) {
                    boolean z2;
                    Cursor b = this.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + a.pn(aVar.Xh()) + "\"", null, 2);
                    if (b == null) {
                        z2 = false;
                    } else {
                        z2 = b.moveToFirst();
                        b.close();
                    }
                    if (z2) {
                        int pn = a.pn(aVar.Xh());
                        ContentValues wH = aVar.wH();
                        int i3 = 0;
                        if (wH.size() > 0) {
                            i3 = this.dCZ.update("addr_upload2", wH, "id=?", new String[]{String.valueOf(pn)});
                        }
                        if (i3 == 0) {
                            x.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", new Object[]{aVar.Xp(), aVar.Xq()});
                        } else if (i3 < 0) {
                            x.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", new Object[]{aVar.Xp(), aVar.Xq()});
                            z = true;
                            break;
                        } else {
                            b(3, this, aVar.Xh());
                        }
                    } else {
                        aVar.bWA = -1;
                        if (((int) this.dCZ.insert("addr_upload2", "id", aVar.wH())) == -1) {
                            x.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", new Object[]{aVar.Xp(), aVar.Xq()});
                            z = true;
                            break;
                        }
                        b(2, this, aVar.Xh());
                    }
                }
                i = i2 + 1;
            } catch (Exception e) {
                x.e("MicroMsg.AddrUploadStorage", e.getMessage());
                z = false;
            }
        }
        this.dCZ.gp(dO);
        bgVar.addSplit("transation end");
        bgVar.dumpToLog();
        return z;
    }

    public final boolean aa(List<String> list) {
        boolean z;
        bg bgVar = new bg("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        bgVar.addSplit("transation begin");
        long dO = this.dCZ.dO(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    a aVar = new a();
                    aVar.bWA = 8;
                    aVar.eJx = bi.VE();
                    ContentValues wH = aVar.wH();
                    int i = 0;
                    if (wH.size() > 0) {
                        i = this.dCZ.update("addr_upload2", wH, "id=?", new String[]{a.pn(str)});
                    }
                    x.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
                }
            }
            z = true;
        } catch (Exception e) {
            x.e("MicroMsg.AddrUploadStorage", e.getMessage());
            z = false;
        }
        this.dCZ.gp(dO);
        bgVar.addSplit("transation end");
        bgVar.dumpToLog();
        if (z) {
            b(3, this, null);
        }
        return z;
    }

    public final int a(String str, a aVar) {
        int i = 0;
        ContentValues wH = aVar.wH();
        if (wH.size() > 0) {
            i = this.dCZ.update("addr_upload2", wH, "id=?", new String[]{a.pn(str)});
        }
        if (i > 0) {
            if (aVar.Xh().equals(str)) {
                b(3, this, str);
            } else {
                b(5, this, str);
                b(2, this, aVar.Xh());
            }
        }
        return i;
    }

    public final a pp(String str) {
        if (bi.oW(str)) {
            return null;
        }
        a aVar = new a();
        Cursor b = this.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + bi.oU(str) + "\"", null, 2);
        x.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str);
        if (b.moveToFirst()) {
            aVar.d(b);
        }
        b.close();
        return aVar;
    }

    public final a pq(String str) {
        a aVar = null;
        if (str != null && str.length() > 0) {
            Cursor b = this.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + a.pn(str) + "\"", null, 2);
            if (b.moveToFirst()) {
                aVar = new a();
                aVar.d(b);
            }
            x.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + (aVar != null ? 1 : 0));
            b.close();
        }
        return aVar;
    }

    public final List<String[]> Xt() {
        Cursor b = this.dCZ.b("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
        List<String[]> arrayList = new ArrayList();
        while (b.moveToNext()) {
            arrayList.add(new String[]{b.getString(0), b.getString(1)});
        }
        b.close();
        return arrayList;
    }

    public final List<a> pr(String str) {
        x.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        List<a> arrayList = new ArrayList();
        x.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        Cursor b = this.dCZ.b(str, null, 2);
        while (b.moveToNext()) {
            a aVar = new a();
            aVar.d(b);
            arrayList.add(aVar);
        }
        b.close();
        return arrayList;
    }

    protected final boolean Xu() {
        if (this.dCZ != null && !this.dCZ.cjr()) {
            return true;
        }
        String str = "MicroMsg.AddrUploadStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.dCZ == null ? "null" : Boolean.valueOf(this.dCZ.cjr());
        x.w(str, str2, objArr);
        return false;
    }

    public final String pt(String str) {
        Exception e;
        Throwable th;
        if (!bi.oW(str)) {
            Cursor a;
            try {
                a = this.dCZ.a("addr_upload2", null, "peopleid=?", new String[]{str}, null, null, null, 2);
                try {
                    if (a.moveToFirst()) {
                        a aVar = new a();
                        aVar.d(a);
                        String username = aVar.getUsername();
                        if (a == null) {
                            return username;
                        }
                        a.close();
                        return username;
                    } else if (a != null) {
                        a.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", new Object[]{e.getMessage()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return null;
    }
}
