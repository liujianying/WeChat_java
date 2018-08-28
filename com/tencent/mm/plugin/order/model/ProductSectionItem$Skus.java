package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ProductSectionItem$Skus implements Parcelable {
    public static final Creator<ProductSectionItem$Skus> CREATER = new 1();
    public String aAL;
    public String value;

    public ProductSectionItem$Skus(Parcel parcel) {
        this.aAL = parcel.readString();
        this.value = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aAL);
        parcel.writeString(this.value);
    }

    public static String bD(List<ProductSectionItem$Skus> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuilder.toString();
            }
            ProductSectionItem$Skus productSectionItem$Skus = (ProductSectionItem$Skus) list.get(i2);
            if (i2 != 0) {
                stringBuilder.append("、");
            }
            stringBuilder.append(productSectionItem$Skus.value);
            i = i2 + 1;
        }
    }
}
