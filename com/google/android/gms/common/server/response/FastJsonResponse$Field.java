package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.Map;

public class FastJsonResponse$Field<I, O> implements SafeParcelable {
    public static final a CREATOR = new a();
    protected final int aOV;
    protected final boolean aOW;
    protected final int aOX;
    protected final boolean aOY;
    protected final String aOZ;
    protected final int aPa;
    protected final Class<? extends FastJsonResponse> aPb;
    protected final String aPc;
    FieldMappingDictionary aPd;
    a<I, O> aPe;
    final int mVersionCode;

    FastJsonResponse$Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
        a aVar = null;
        this.mVersionCode = i;
        this.aOV = i2;
        this.aOW = z;
        this.aOX = i3;
        this.aOY = z2;
        this.aOZ = str;
        this.aPa = i4;
        if (str2 == null) {
            this.aPb = null;
            this.aPc = null;
        } else {
            this.aPb = SafeParcelResponse.class;
            this.aPc = str2;
        }
        if (converterWrapper != null) {
            if (converterWrapper.aOP != null) {
                aVar = converterWrapper.aOP;
            } else {
                throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
            }
        }
        this.aPe = aVar;
    }

    public int describeContents() {
        return 0;
    }

    public final Class<? extends FastJsonResponse> pA() {
        return this.aPb;
    }

    final String pB() {
        return this.aPc == null ? null : this.aPc;
    }

    public final Map<String, FastJsonResponse$Field<?, ?>> pC() {
        w.ah(this.aPc);
        w.ah(this.aPd);
        return this.aPd.bj(this.aPc);
    }

    public final int pu() {
        return this.aOV;
    }

    public final boolean pv() {
        return this.aOW;
    }

    public final int pw() {
        return this.aOX;
    }

    public final boolean px() {
        return this.aOY;
    }

    public final String py() {
        return this.aOZ;
    }

    public final int pz() {
        return this.aPa;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field\n");
        stringBuilder.append("            versionCode=").append(this.mVersionCode).append(10);
        stringBuilder.append("                 typeIn=").append(this.aOV).append(10);
        stringBuilder.append("            typeInArray=").append(this.aOW).append(10);
        stringBuilder.append("                typeOut=").append(this.aOX).append(10);
        stringBuilder.append("           typeOutArray=").append(this.aOY).append(10);
        stringBuilder.append("        outputFieldName=").append(this.aOZ).append(10);
        stringBuilder.append("      safeParcelFieldId=").append(this.aPa).append(10);
        stringBuilder.append("       concreteTypeName=").append(pB()).append(10);
        if (this.aPb != null) {
            stringBuilder.append("     concreteType.class=").append(this.aPb.getCanonicalName()).append(10);
        }
        stringBuilder.append("          converterName=").append(this.aPe == null ? "null" : this.aPe.getClass().getCanonicalName()).append(10);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
