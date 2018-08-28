package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new 1();
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public List<Skus> lPi;
    public String lPj;
    public String lPk;
    public String name;
    public int scene;

    public ProductSectionItem(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.lPi = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.aAL = parcel.readString();
                skus.value = parcel.readString();
                this.lPi.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.lPj = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.lPk = parcel.readString();
        this.scene = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.lPi != null) {
            parcel.writeInt(this.lPi.size());
            while (true) {
                int i3 = i2;
                if (i3 >= this.lPi.size()) {
                    break;
                }
                Skus skus = (Skus) this.lPi.get(i3);
                parcel.writeString(skus.aAL);
                parcel.writeString(skus.value);
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.lPj);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.lPk);
        parcel.writeInt(this.scene);
    }
}
