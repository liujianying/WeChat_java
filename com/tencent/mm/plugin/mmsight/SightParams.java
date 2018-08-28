package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;

public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new 1();
    public int lel = 2;
    public VideoTransPara lem;
    public String len = "";
    public String leo = "";
    public String lep = "";
    public String leq = "";
    public String ler = "";
    public boolean les = true;
    public boolean let = true;
    public String leu = "";
    public int lev;
    public int mode = 0;
    public int scene = -1;

    public SightParams(int i, int i2) {
        if (i == 1) {
            this.lem = d.NP().NQ();
        } else if (i == 2 || i == 3 || i == 4) {
            this.lem = d.NP().NR();
        } else {
            this.lem = d.NP().NR();
        }
        this.scene = i;
        this.mode = i2;
        g.Ek();
        this.lev = ((Integer) g.Ei().DT().get(344066, Integer.valueOf(0))).intValue();
    }

    protected SightParams(Parcel parcel) {
        boolean z = true;
        this.mode = parcel.readInt();
        this.lem = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.len = parcel.readString();
        this.leo = parcel.readString();
        this.lep = parcel.readString();
        this.leq = parcel.readString();
        this.lev = parcel.readInt();
        this.lel = parcel.readInt();
        this.les = parcel.readInt() > 0;
        this.scene = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.let = z;
        this.leu = parcel.readString();
    }

    public final SightParams m(String str, String str2, String str3, String str4) {
        this.lep = str;
        this.len = str2;
        this.leo = str3;
        this.leq = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.lem, i);
        parcel.writeString(this.len);
        parcel.writeString(this.leo);
        parcel.writeString(this.lep);
        parcel.writeString(this.leq);
        parcel.writeInt(this.lev);
        parcel.writeInt(this.lel);
        parcel.writeInt(this.les ? 1 : 0);
        parcel.writeInt(this.scene);
        if (!this.let) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.leu);
    }
}
