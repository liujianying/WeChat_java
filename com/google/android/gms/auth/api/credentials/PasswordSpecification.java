package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class PasswordSpecification implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final PasswordSpecification aIS = new a().on().bb("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").bc("abcdefghijkmnopqrstxyz").bc("ABCDEFGHJKLMNPQRSTXY").bc("3456789").oo();
    public static final PasswordSpecification aIT = new a().on().bb("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").bc("abcdefghijklmnopqrstuvwxyz").bc("ABCDEFGHIJKLMNOPQRSTUVWXYZ").bc("1234567890").oo();
    final String aIU;
    final List<String> aIV;
    final List<Integer> aIW;
    final int aIX;
    final int aIY;
    private final int[] aIZ = om();
    private final Random aJa = new SecureRandom();
    final int mVersionCode;

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.aIU = str;
        this.aIV = Collections.unmodifiableList(list);
        this.aIW = Collections.unmodifiableList(list2);
        this.aIX = i2;
        this.aIY = i3;
    }

    static /* synthetic */ String b(Collection collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = ((Character) it.next()).charValue();
        }
    }

    static /* synthetic */ boolean dh(int i) {
        return i < 32 || i > 126;
    }

    private int[] om() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.aIV) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        return iArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
