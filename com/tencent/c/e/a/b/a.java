package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static ArrayList<e> vks;
    public int bVU = 0;
    public String byN = "";
    public String dMB = "";
    public String imei = "";
    public String imsi = "";
    public String model = "";
    public int pMn = 0;
    public int requestType = 0;
    public int sdkVer = 0;
    public int seW = 0;
    public String vie = "";
    public long vkm = 0;
    public String vkn = "";
    public ArrayList<e> vko = null;
    public String vkp = "";
    public String vkq = "";
    public int vkr = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vkm, 0);
        jceOutputStream.write(this.vkn, 1);
        jceOutputStream.write(this.vko, 2);
        jceOutputStream.write(this.pMn, 3);
        jceOutputStream.write(this.vie, 4);
        jceOutputStream.write(this.bVU, 5);
        jceOutputStream.write(this.requestType, 6);
        jceOutputStream.write(this.vkp, 7);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 8);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 9);
        }
        if (this.dMB != null) {
            jceOutputStream.write(this.dMB, 10);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 11);
        }
        if (this.vkq != null) {
            jceOutputStream.write(this.vkq, 12);
        }
        if (this.vkr != 0) {
            jceOutputStream.write(this.vkr, 13);
        }
        if (this.sdkVer != 0) {
            jceOutputStream.write(this.sdkVer, 14);
        }
        if (this.byN != null) {
            jceOutputStream.write(this.byN, 15);
        }
        jceOutputStream.write(this.seW, 16);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vkm = jceInputStream.read(this.vkm, 0, true);
        this.vkn = jceInputStream.readString(1, true);
        if (vks == null) {
            vks = new ArrayList();
            vks.add(new e());
        }
        this.vko = (ArrayList) jceInputStream.read(vks, 2, true);
        this.pMn = jceInputStream.read(this.pMn, 3, true);
        this.vie = jceInputStream.readString(4, true);
        this.bVU = jceInputStream.read(this.bVU, 5, true);
        this.requestType = jceInputStream.read(this.requestType, 6, true);
        this.vkp = jceInputStream.readString(7, true);
        this.imei = jceInputStream.readString(8, false);
        this.imsi = jceInputStream.readString(9, false);
        this.dMB = jceInputStream.readString(10, false);
        this.model = jceInputStream.readString(11, false);
        this.vkq = jceInputStream.readString(12, false);
        this.vkr = jceInputStream.read(this.vkr, 13, false);
        this.sdkVer = jceInputStream.read(this.sdkVer, 14, false);
        this.byN = jceInputStream.readString(15, false);
        this.seW = jceInputStream.read(this.seW, 16, false);
    }
}
