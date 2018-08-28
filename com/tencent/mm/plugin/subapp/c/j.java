package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j implements e {
    private static int bFl = 0;
    Queue<String> bFd = new LinkedList();
    Queue<String> bFe = new LinkedList();
    Map<String, a> bFf = new HashMap();
    private boolean bFg = false;
    private boolean bFh = false;
    private boolean bFi = false;
    int bFj = 0;
    private long bFk = 0;
    a bFn = new a();
    private al bFo = new al(au.Em().lnJ.getLooper(), new 3(this), false);

    static /* synthetic */ void h(j jVar) {
        jVar.bFk = System.currentTimeMillis();
        if ((!jVar.bFg && jVar.bFe.size() == 0) || (!jVar.bFh && jVar.bFd.size() == 0)) {
            Cursor b = d.bGt().diF.b(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            List list = null;
            int i = 0;
            if (b.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(b);
                    list.add(gVar);
                    i++;
                } while (b.moveToNext());
            }
            b.close();
            x.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:" + i);
            if (list == null) {
                x.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                x.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + list.size());
            }
            if (!(list == null || list.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String gb = bi.gb(currentTimeMillis);
                for (g gVar2 : list) {
                    if (jVar.bFf.containsKey(gVar2.field_filename)) {
                        x.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        x.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + bi.gb(gVar2.field_createtime) + " last:" + bi.gb(gVar2.field_lastmodifytime) + " now:" + bi.gb(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        Object obj = (gVar2.field_status == 5 || gVar2.field_status == 6) ? 1 : null;
                        if (obj != null) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.gb(gVar2.field_lastmodifytime) + " now:" + gb);
                                h.nP(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.gb(gVar2.field_lastmodifytime) + " now:" + gb);
                                h.nP(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                x.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                jVar.bFe.offer(gVar2.field_filename);
                                jVar.bFf.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.TM()) {
                            x.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.gb(gVar2.field_lastmodifytime) + " now:" + gb);
                                h.nP(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.gb(gVar2.field_lastmodifytime) + " now:" + gb);
                                h.nP(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                x.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                jVar.bFd.offer(gVar2.field_filename);
                                jVar.bFf.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                x.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + jVar.bFf.size() + " [recv:" + jVar.bFe.size() + ",send:" + jVar.bFd.size() + "]");
                jVar.bFe.size();
                jVar.bFd.size();
            }
        }
        if (jVar.bFg || jVar.bFe.size() != 0 || jVar.bFh || jVar.bFd.size() != 0) {
            String str;
            if (!jVar.bFg && jVar.bFe.size() > 0) {
                str = (String) jVar.bFe.poll();
                x.d("MicroMsg.VoiceRemindService", "Start Recv :" + str);
                if (str != null) {
                    jVar.bFf.put(str, new a());
                    jVar.bFg = true;
                    x.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!jVar.bFh && jVar.bFd.size() > 0) {
                str = (String) jVar.bFd.poll();
                x.d("MicroMsg.VoiceRemindService", "Start Send :" + str);
                if (str != null) {
                    jVar.bFf.put(str, new a());
                    jVar.bFh = true;
                    au.DF().a(new b(str), 0);
                    return;
                }
                return;
            }
            return;
        }
        jVar.wx();
        x.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
    }

    static /* synthetic */ int wy() {
        int i = bFl;
        bFl = i + 1;
        return i;
    }

    static /* synthetic */ int wz() {
        int i = bFl;
        bFl = i - 1;
        return i;
    }

    public j() {
        au.DF().a(329, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.Em().H(new 1(this, lVar, i, i2));
    }

    private void wx() {
        this.bFf.clear();
        this.bFd.clear();
        this.bFe.clear();
        this.bFh = false;
        this.bFg = false;
        this.bFi = false;
        x.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.bFn.Ad());
    }

    public final void run() {
        au.Em().H(new 2(this));
    }
}
