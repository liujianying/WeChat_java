package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ElementQuery implements Parcelable {
    public static final Creator<ElementQuery> CREATOR = new 1();
    public static String pnk = "bind_serial";
    public JSONObject dKT;
    public String knE;
    public String lMV;
    public String lMW;
    public int pjA;
    public String plq;
    public boolean pnA;
    public boolean pnB;
    public boolean pnC;
    public boolean pnD;
    public boolean pnE;
    public boolean pnF;
    public boolean pnG;
    public boolean pnH;
    public boolean pnI;
    public String pnJ;
    private List<Integer> pnK = null;
    public boolean pnL;
    public String pnM;
    public int pnN;
    public boolean pnO = false;
    public String pnl;
    public boolean pnm;
    public boolean pnn;
    public boolean pno;
    public boolean pnp;
    public String pnq;
    public boolean pnr;
    public int pns;
    public int pnt;
    public String pnu;
    public String pnv;
    public String pnw;
    public String pnx;
    public String pny;
    public String pnz;

    public final boolean isError() {
        return "0".equals(bi.aG(this.pnv, "").trim());
    }

    public final boolean bOu() {
        return 2 == this.pnt;
    }

    public final boolean bOE() {
        return 1 == this.pnt;
    }

    public final List<Integer> bOF() {
        if (this.pnK != null) {
            return this.pnK;
        }
        if (bi.oW(this.pnJ)) {
            return null;
        }
        this.pnK = new ArrayList();
        for (String str : this.pnJ.split("\\|")) {
            int i = bi.getInt(str, 0);
            if (i > 0) {
                this.pnK.add(Integer.valueOf(i));
            }
        }
        return this.pnK;
    }

    public ElementQuery(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.lMW = parcel.readString();
        this.knE = parcel.readString();
        this.pnl = parcel.readString();
        this.pnm = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnn = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pno = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnp = z;
        this.pnq = parcel.readString();
        this.lMW = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnr = z;
        this.pns = parcel.readInt();
        this.pnt = parcel.readInt();
        this.lMV = parcel.readString();
        this.pnu = parcel.readString();
        this.pnv = parcel.readString();
        this.pnw = parcel.readString();
        this.pnz = parcel.readString();
        this.pny = parcel.readString();
        this.pnx = parcel.readString();
        this.pnA = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnB = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnC = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnD = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnE = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnF = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnH = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnG = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnI = z;
        this.pjA = parcel.readInt();
        this.pnJ = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.pnO = z;
        this.plq = parcel.readString();
        if (1 != parcel.readInt()) {
            z2 = false;
        }
        this.pnL = z2;
        this.pnM = parcel.readString();
        this.pnN = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(bi.aG(this.lMW, ""));
        parcel.writeString(bi.aG(this.knE, ""));
        parcel.writeString(bi.aG(this.pnl, ""));
        parcel.writeInt(this.pnm ? 1 : 0);
        if (this.pnn) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pno) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnp) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(bi.aG(this.pnq, ""));
        parcel.writeString(bi.aG(this.lMW, ""));
        if (this.pnr) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.pns);
        parcel.writeInt(this.pnt);
        parcel.writeString(bi.aG(this.lMV, ""));
        parcel.writeString(bi.aG(this.pnu, ""));
        parcel.writeString(bi.aG(this.pnv, ""));
        parcel.writeString(bi.aG(this.pnw, ""));
        parcel.writeString(bi.aG(this.pnz, ""));
        parcel.writeString(bi.aG(this.pny, ""));
        parcel.writeString(bi.aG(this.pnx, ""));
        parcel.writeInt(this.pnA ? 1 : 0);
        if (this.pnB) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnC) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnD) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnE) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnF) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnH) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnG) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.pnI) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.pjA);
        parcel.writeString(this.pnJ);
        if (this.pnO) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.plq);
        if (!this.pnL) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.pnM);
        parcel.writeInt(this.pnN);
    }
}
