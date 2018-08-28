package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MCacheItem implements Parcelable {
    public static final Creator<MCacheItem> CREATOR = new 1();
    private c dan;

    public MCacheItem(Parcel parcel) {
        this.dan = d(parcel);
    }

    public MCacheItem(c cVar) {
        this.dan = cVar;
    }

    private c d(Parcel parcel) {
        try {
            Class cls = Class.forName(parcel.readString());
            try {
                this.dan = (c) cls.newInstance();
            } catch (Exception e) {
            }
            for (Field type : c.I(cls).sKy) {
                Method method = (Method) a.dap.get(type.getType());
                if (method != null) {
                    try {
                        method.invoke(null, new Object[]{parcel, type, this.dan});
                    } catch (Throwable e2) {
                        x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e2)});
                    }
                }
            }
            return this.dan;
        } catch (Throwable e22) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e22)});
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dan.getClass().getName());
        for (Field type : c.I(this.dan.getClass()).sKy) {
            Method method = (Method) a.dao.get(type.getType());
            if (method != null) {
                try {
                    method.invoke(null, new Object[]{parcel, type, this.dan});
                } catch (Throwable e) {
                    x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
    }
}
