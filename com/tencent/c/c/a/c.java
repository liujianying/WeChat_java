package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static b viv = new b();
    public String eMI = "";
    public String fMk = "";
    public String guid = "";
    public String hvl = "";
    public String imei = "";
    public String imsi = "";
    public String ip = "";
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public String nyk = "";
    public String vie = "";
    public String vif = "";
    public String vig = "";
    public int vih = 0;
    public int vii = 0;
    public b vij = null;
    public int vik = 0;
    public int vil = 0;
    public int vim = 0;
    public int vin = 0;
    public short vio = (short) 0;
    public String vip = "";
    public int viq = 0;
    public String vir = "";
    public String vis = "";
    public String vit = "";
    public String viu = "";

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imei, 0);
        if (this.eMI != null) {
            jceOutputStream.write(this.eMI, 1);
        }
        if (this.hvl != null) {
            jceOutputStream.write(this.hvl, 2);
        }
        if (this.ip != null) {
            jceOutputStream.write(this.ip, 3);
        }
        if (this.vie != null) {
            jceOutputStream.write(this.vie, 4);
        }
        if (this.vif != null) {
            jceOutputStream.write(this.vif, 5);
        }
        if (this.vig != null) {
            jceOutputStream.write(this.vig, 6);
        }
        if (this.vih != 0) {
            jceOutputStream.write(this.vih, 7);
        }
        if (this.vii != 0) {
            jceOutputStream.write(this.vii, 8);
        }
        if (this.vij != null) {
            jceOutputStream.write(this.vij, 9);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 10);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 11);
        }
        if (this.vik != 0) {
            jceOutputStream.write(this.vik, 12);
        }
        if (this.vil != 0) {
            jceOutputStream.write(this.vil, 13);
        }
        if (this.vim != 0) {
            jceOutputStream.write(this.vim, 14);
        }
        if (this.vin != 0) {
            jceOutputStream.write(this.vin, 15);
        }
        if (this.fMk != null) {
            jceOutputStream.write(this.fMk, 16);
        }
        if (this.vio != (short) 0) {
            jceOutputStream.write(this.vio, 17);
        }
        if (this.longitude != 0.0d) {
            jceOutputStream.write(this.longitude, 18);
        }
        if (this.latitude != 0.0d) {
            jceOutputStream.write(this.latitude, 19);
        }
        if (this.vip != null) {
            jceOutputStream.write(this.vip, 20);
        }
        if (this.viq != 0) {
            jceOutputStream.write(this.viq, 21);
        }
        if (this.vir != null) {
            jceOutputStream.write(this.vir, 22);
        }
        if (this.vis != null) {
            jceOutputStream.write(this.vis, 23);
        }
        if (this.nyk != null) {
            jceOutputStream.write(this.nyk, 24);
        }
        if (this.vit != null) {
            jceOutputStream.write(this.vit, 25);
        }
        if (this.viu != null) {
            jceOutputStream.write(this.viu, 26);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, true);
        this.eMI = jceInputStream.readString(1, false);
        this.hvl = jceInputStream.readString(2, false);
        this.ip = jceInputStream.readString(3, false);
        this.vie = jceInputStream.readString(4, false);
        this.vif = jceInputStream.readString(5, false);
        this.vig = jceInputStream.readString(6, false);
        this.vih = jceInputStream.read(this.vih, 7, false);
        this.vii = jceInputStream.read(this.vii, 8, false);
        this.vij = (b) jceInputStream.read(viv, 9, false);
        this.guid = jceInputStream.readString(10, false);
        this.imsi = jceInputStream.readString(11, false);
        this.vik = jceInputStream.read(this.vik, 12, false);
        this.vil = jceInputStream.read(this.vil, 13, false);
        this.vim = jceInputStream.read(this.vim, 14, false);
        this.vin = jceInputStream.read(this.vin, 15, false);
        this.fMk = jceInputStream.readString(16, false);
        this.vio = jceInputStream.read(this.vio, 17, false);
        this.longitude = jceInputStream.read(this.longitude, 18, false);
        this.latitude = jceInputStream.read(this.latitude, 19, false);
        this.vip = jceInputStream.readString(20, false);
        this.viq = jceInputStream.read(this.viq, 21, false);
        this.vir = jceInputStream.readString(22, false);
        this.vis = jceInputStream.readString(23, false);
        this.nyk = jceInputStream.readString(24, false);
        this.vit = jceInputStream.readString(25, false);
        this.viu = jceInputStream.readString(26, false);
    }
}
