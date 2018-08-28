package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.i;

public final class XIPCInvoker {

    private static class WrapperParcelable implements Parcelable {
        public static final Creator<WrapperParcelable> CREATOR = new 1();
        Object dna;
        String dnd;

        /* synthetic */ WrapperParcelable(byte b) {
            this();
        }

        private WrapperParcelable() {
        }

        public WrapperParcelable(String str, Object obj) {
            this.dnd = str;
            this.dna = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.dnd);
            if (this.dna != null) {
                a ax = c.ax(this.dna);
                if (ax != null) {
                    parcel.writeInt(1);
                    parcel.writeString(ax.getClass().getName());
                    ax.a(this.dna, parcel);
                    return;
                }
            }
            parcel.writeInt(0);
        }
    }

    public static <T extends a<InputType, ResultType>, InputType, ResultType> void a(String str, InputType inputType, Class<T> cls, c<ResultType> cVar) {
        f.a(str, new WrapperParcelable(cls.getName(), inputType), a.class, new 1(cVar));
    }

    public static <T extends i<InputType, ResultType>, InputType, ResultType> ResultType a(String str, InputType inputType, Class<T> cls) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) f.a(str, new WrapperParcelable(cls.getName(), inputType), c.class);
        if (wrapperParcelable != null) {
            return wrapperParcelable.dna;
        }
        b.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
        return null;
    }
}
