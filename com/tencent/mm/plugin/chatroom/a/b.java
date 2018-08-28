package com.tencent.mm.plugin.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.R;
import java.util.Calendar;
import java.util.Collection;

public final class b extends a<b> implements com.tencent.mm.plugin.chatroom.ui.b.a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray hKJ;
    private final a hKK;
    public final a<com.tencent.mm.plugin.chatroom.d.a> hKL;
    private final Collection<com.tencent.mm.plugin.chatroom.d.a> hKM;
    private final Integer hKN;
    private final Integer hKO;
    private final boolean hKP;
    private final Context mContext;

    public b(Context context, a aVar, TypedArray typedArray, long j, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.hKJ = typedArray;
        this.hKO = Integer.valueOf(typedArray.getInt(R.n.DayPickerView_lastMonth, this.calendar.get(2) % 12));
        if (-1 != j) {
            this.calendar.setTimeInMillis(j);
        }
        this.hKN = Integer.valueOf(typedArray.getInt(R.n.DayPickerView_firstMonth, this.calendar.get(2)));
        this.hKP = typedArray.getBoolean(R.n.DayPickerView_selectRangeEnable, false);
        this.hKL = new a();
        this.hKM = collection;
        this.mContext = context;
        this.hKK = aVar;
        if (this.hKJ.getBoolean(R.n.DayPickerView_currentDaySelected, false)) {
            c(new com.tencent.mm.plugin.chatroom.d.a(System.currentTimeMillis()));
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        int i = ((new com.tencent.mm.plugin.chatroom.d.a(this.hKK.aAv()).year - this.calendar.get(1)) + 1) * 12;
        if (this.hKN.intValue() != -1) {
            i -= this.hKN.intValue();
        }
        if (this.hKO.intValue() != -1) {
            return i - ((12 - this.hKO.intValue()) - 1);
        }
        return i;
    }

    public final void b(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar != null) {
            c(aVar);
        }
    }

    private void c(com.tencent.mm.plugin.chatroom.d.a aVar) {
        this.hKK.a(aVar);
        if (!this.hKP) {
            this.hKL.first = aVar;
        } else if (this.hKL.first != null && this.hKL.hKQ == null) {
            this.hKL.hKQ = aVar;
            if (((com.tencent.mm.plugin.chatroom.d.a) this.hKL.first).month < aVar.month) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= (((com.tencent.mm.plugin.chatroom.d.a) this.hKL.first).month - aVar.month) - 1) {
                        break;
                    }
                    this.hKK.a(aVar);
                    i = i2 + 1;
                }
            }
        } else if (this.hKL.hKQ != null) {
            this.hKL.first = aVar;
            this.hKL.hKQ = null;
        } else {
            this.hKL.first = aVar;
        }
        this.RR.notifyChanged();
    }
}
