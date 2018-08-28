package com.tencent.mm.plugin.monitor;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class b$2 implements Runnable {
    final /* synthetic */ b lsb;
    final /* synthetic */ long lsc;
    final /* synthetic */ long lsd;
    final /* synthetic */ long lse;
    final /* synthetic */ long lsg;
    final /* synthetic */ long lsh;
    final /* synthetic */ long lsi;

    b$2(b bVar, long j, long j2, long j3, long j4, long j5, long j6) {
        this.lsb = bVar;
        this.lsc = j;
        this.lsd = j2;
        this.lse = j3;
        this.lsg = j4;
        this.lsh = j5;
        this.lsi = j6;
    }

    public final void run() {
        try {
            log_14375 log_14375 = new log_14375();
            log_14375.type_ = 1;
            BDStatusInfo bDStatusInfo = new BDStatusInfo();
            log_14375.dbStatusInfo_ = bDStatusInfo;
            g.Ek();
            long length = new File(g.Ei().DR()).length();
            bDStatusInfo.mmDBSize_ = length;
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            long length2 = new File(stringBuilder.append(g.Ei().cachePath).append("SnsMicroMsg.db").toString()).length();
            bDStatusInfo.snsDBSize_ = length2;
            stringBuilder = new StringBuilder();
            g.Ek();
            long length3 = new File(stringBuilder.append(g.Ei().cachePath).append("enFavorite.db").toString()).length();
            bDStatusInfo.favDBSize_ = length3;
            b.a(this.lsb, 4, length, this.lsc);
            b.a(this.lsb, 128, length3, this.lsd);
            String str = length + ";" + length2 + ";" + length3;
            g.Ek();
            h hVar = g.Ei().dqr;
            if (hVar == null || !hVar.isOpen()) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                Cursor b = hVar.b("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                if (b != null) {
                    int columnIndex = b.getColumnIndex("name");
                    while (b.moveToNext()) {
                        arrayList.add(b.getString(columnIndex));
                    }
                    b.close();
                }
                String str2 = str + ";" + arrayList.size();
                bDStatusInfo.mmDBTableCount_ = arrayList.size();
                LinkedList linkedList = new LinkedList();
                bDStatusInfo.tableList_ = linkedList;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    Cursor b2 = hVar.b("select count(*) from " + str, null, 2);
                    length = 0;
                    if (b2 != null) {
                        if (b2.moveToFirst()) {
                            length = b2.getLong(0);
                        }
                        b2.close();
                    }
                    String str3 = str2 + ";" + str + ":" + length;
                    TableInfo tableInfo = new TableInfo();
                    tableInfo.name_ = str;
                    tableInfo.count_ = length;
                    linkedList.add(tableInfo);
                    if ("message".equals(str)) {
                        b.a(this.lsb, 8, length, this.lse);
                        str2 = str3;
                    } else if ("rconversation".equals(str)) {
                        b.a(this.lsb, 16, length, this.lsg);
                        str2 = str3;
                    } else if ("rcontact".equals(str)) {
                        b.a(this.lsb, 32, length, this.lsh);
                        str2 = str3;
                    } else {
                        if ("chatroom".equals(str)) {
                            b.a(this.lsb, 64, length, this.lsi);
                        }
                        str2 = str3;
                    }
                }
                x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                str = str2;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13778, new Object[]{Integer.valueOf(1), Integer.valueOf(1), str});
            com.tencent.mm.plugin.report.service.h.mEJ.c(14375, log_14375);
            com.tencent.mm.plugin.report.service.h.mEJ.a(418, 3, 1, true);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportDBInfo err!", new Object[0]);
            com.tencent.mm.plugin.report.service.h.mEJ.a(418, 4, 1, true);
        }
    }
}
