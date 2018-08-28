package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.bk.b;
import com.tencent.mm.protocal.c.bbu;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String bZR;
    public String cbH;
    public int fOu;
    public LinkedList<bbu> gUH = new LinkedList();
    public int iwS;
    public String iwT;
    public boolean kpA = false;
    public boolean kpB = false;
    public boolean kpC = false;
    public boolean kpD = true;
    public int kpE = 0;
    public int kpF;
    public int kpG;
    public int kpH;
    public b kpI;
    public int kpJ;
    public int kpK;
    public b kpL;
    public LinkedList<bbu> kpM = new LinkedList();
    public int kpN = 999;
    public LinkedList<d> kpO = new LinkedList();
    public String kpP;
    public String kpQ;
    public String kpR;
    public int kpS;
    public boolean kpT = false;
    public int kpo;
    public long kpp;
    public long kpq;
    public int kpr;
    public int kps;
    public int kpt;
    public int kpu;
    public String kpv;
    public int kpw;
    public int kpx;
    public int kpy;
    public int kpz;
    public String nickname;

    public final int aXG() {
        if (this.kpO == null || this.kpO.size() <= 0) {
            return this.kpx;
        }
        return ((d) this.kpO.get(0)).kpx;
    }

    public final int aXH() {
        if (this.kpO == null || this.kpO.size() <= 0) {
            return this.fOu;
        }
        return ((d) this.kpO.get(0)).dpx;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("IPCallInfo: ");
        stringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[]{Integer.valueOf(this.kpo), Long.valueOf(this.kpp), Long.valueOf(this.kpq), Integer.valueOf(this.kpr), Integer.valueOf(this.kpw), Integer.valueOf(this.kpx), Integer.valueOf(this.kpy), Integer.valueOf(this.fOu), this.iwT, Integer.valueOf(this.iwS), Integer.valueOf(this.kpu)}));
        stringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[]{this.bZR, this.kpQ}));
        stringBuilder.append("[addrList: ");
        Iterator it = this.gUH.iterator();
        while (it.hasNext()) {
            bbu bbu = (bbu) it.next();
            stringBuilder.append(String.format("{IP: %s, port: %d}", new Object[]{bbu.rTO, Integer.valueOf(bbu.sed)}));
        }
        stringBuilder.append("]");
        stringBuilder.append("\n");
        if (this.kpO == null || this.kpO.size() <= 0) {
            stringBuilder.append("userInfoList is empty");
        } else {
            stringBuilder.append("[userInfoList: ");
            it = this.kpO.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                stringBuilder.append("{");
                stringBuilder.append(dVar.toString());
                stringBuilder.append("}");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }
}
