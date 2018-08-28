package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b extends JceStruct {
    static byte[] viV;
    static byte[] viW;
    static ArrayList<Integer> viX = new ArrayList();
    static ArrayList<byte[]> viY = new ArrayList();
    public int viC = 0;
    public byte[] viD = null;
    public String viE = "";
    public byte[] viF = null;
    public long viG = 0;
    public String viH = "";
    public int viI = 0;
    public String viJ = "";
    public int viK = 0;
    public String viL = "";
    public int viM = 0;
    public int viN = 0;
    public int viO = 0;
    public ArrayList<Integer> viP = null;
    public int viQ = 0;
    public boolean viR = false;
    public int viS = 0;
    public int viT = 0;
    public ArrayList<byte[]> viU = null;

    public final JceStruct newInit() {
        return new b();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.viC, 0);
        if (this.viD != null) {
            jceOutputStream.write(this.viD, 1);
        }
        if (this.viE != null) {
            jceOutputStream.write(this.viE, 2);
        }
        if (this.viF != null) {
            jceOutputStream.write(this.viF, 3);
        }
        if (this.viG != 0) {
            jceOutputStream.write(this.viG, 4);
        }
        if (this.viH != null) {
            jceOutputStream.write(this.viH, 5);
        }
        if (this.viI != 0) {
            jceOutputStream.write(this.viI, 6);
        }
        if (this.viJ != null) {
            jceOutputStream.write(this.viJ, 7);
        }
        if (this.viK != 0) {
            jceOutputStream.write(this.viK, 8);
        }
        if (this.viL != null) {
            jceOutputStream.write(this.viL, 9);
        }
        jceOutputStream.write(this.viM, 10);
        if (this.viN != 0) {
            jceOutputStream.write(this.viN, 11);
        }
        if (this.viO != 0) {
            jceOutputStream.write(this.viO, 12);
        }
        if (this.viP != null) {
            jceOutputStream.write(this.viP, 13);
        }
        if (this.viQ != 0) {
            jceOutputStream.write(this.viQ, 14);
        }
        jceOutputStream.write(this.viR, 15);
        if (this.viS != 0) {
            jceOutputStream.write(this.viS, 16);
        }
        jceOutputStream.write(this.viT, 17);
        if (this.viU != null) {
            jceOutputStream.write(this.viU, 18);
        }
    }

    static {
        byte[] bArr = new byte[1];
        viV = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        viW = bArr;
        bArr[0] = (byte) 0;
        viX.add(Integer.valueOf(0));
        bArr = new byte[1];
        bArr[0] = (byte) 0;
        viY.add(bArr);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.viC = jceInputStream.read(this.viC, 0, true);
        this.viD = jceInputStream.read(viV, 1, false);
        this.viE = jceInputStream.readString(2, false);
        this.viF = jceInputStream.read(viW, 3, false);
        this.viG = jceInputStream.read(this.viG, 4, false);
        this.viH = jceInputStream.readString(5, false);
        this.viI = jceInputStream.read(this.viI, 6, false);
        this.viJ = jceInputStream.readString(7, false);
        this.viK = jceInputStream.read(this.viK, 8, false);
        this.viL = jceInputStream.readString(9, false);
        this.viM = jceInputStream.read(this.viM, 10, false);
        this.viN = jceInputStream.read(this.viN, 11, false);
        this.viO = jceInputStream.read(this.viO, 12, false);
        this.viP = (ArrayList) jceInputStream.read(viX, 13, false);
        this.viQ = jceInputStream.read(this.viQ, 14, false);
        this.viR = jceInputStream.read(this.viR, 15, false);
        this.viS = jceInputStream.read(this.viS, 16, false);
        this.viT = jceInputStream.read(this.viT, 17, false);
        this.viU = (ArrayList) jceInputStream.read(viY, 18, false);
    }
}
