package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements d {
    private final List<e> awy;
    private final long[] ayz = new long[(this.azS * 2)];
    private final int azS;
    private final long[] azT;

    public i(List<e> list) {
        this.awy = list;
        this.azS = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.azS) {
                e eVar = (e) list.get(i2);
                int i3 = i2 * 2;
                this.ayz[i3] = eVar.startTime;
                this.ayz[i3 + 1] = eVar.endTime;
                i = i2 + 1;
            } else {
                this.azT = Arrays.copyOf(this.ayz, this.ayz.length);
                Arrays.sort(this.azT);
                return;
            }
        }
    }

    public final int P(long j) {
        int a = t.a(this.azT, j);
        return a < this.azT.length ? a : -1;
    }

    public final int lj() {
        return this.azT.length;
    }

    public final long cM(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        a.ao(z);
        if (i >= this.azT.length) {
            z2 = false;
        }
        a.ao(z2);
        return this.azT[i];
    }

    public final List<com.google.android.exoplayer2.f.a> Q(long j) {
        ArrayList arrayList;
        e eVar = null;
        int i = 0;
        CharSequence charSequence = null;
        e eVar2 = null;
        while (true) {
            arrayList = eVar;
            if (i >= this.azS) {
                break;
            }
            if (this.ayz[i * 2] <= j && j < this.ayz[(i * 2) + 1]) {
                Object obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                eVar = (e) this.awy.get(i);
                if (eVar.avU == Float.MIN_VALUE && eVar.avX == Float.MIN_VALUE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (eVar2 != null) {
                        if (charSequence == null) {
                            charSequence = new SpannableStringBuilder();
                            charSequence.append(eVar2.text).append("\n").append(eVar.text);
                            eVar = eVar2;
                        } else {
                            charSequence.append("\n").append(eVar.text);
                            eVar = eVar2;
                        }
                    }
                    i++;
                } else {
                    arrayList.add(eVar);
                }
            }
            eVar = eVar2;
            i++;
        }
        if (charSequence != null) {
            arrayList.add(new e(charSequence));
        } else if (eVar2 != null) {
            arrayList.add(eVar2);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
