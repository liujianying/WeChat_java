package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.f.a;

public final class g extends f {
    private int idM = 0;
    private int idN = 0;
    private int idO = 0;

    public final /* synthetic */ Object getItem(int i) {
        return super.oG(i);
    }

    public g(Context context) {
        super(context);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        if (this.idM > 0) {
            if (i == 0) {
                aVar.idl.setVisibility(0);
                aVar.idl.setText(this.mContext.getString(R.l.emoji_store_hot));
            } else if (this.idN > 0 && i == this.idM) {
                aVar.idl.setVisibility(0);
                aVar.idl.setText(this.mContext.getString(R.l.emoji_store_recent));
            } else if (i == this.idM + this.idN) {
                aVar.idl.setVisibility(0);
                aVar.idl.setText(this.mContext.getString(R.l.emoji_store_all));
            } else {
                aVar.idl.setVisibility(8);
            }
        } else if (this.idN > 0) {
            if (i == 0) {
                aVar.idl.setVisibility(0);
                aVar.idl.setText(this.mContext.getString(R.l.emoji_store_recent));
            } else if (i == this.idM + this.idN) {
                aVar.idl.setVisibility(0);
                aVar.idl.setText(this.mContext.getString(R.l.emoji_store_all));
            } else {
                aVar.idl.setVisibility(8);
            }
        }
        if (aVar.idn != null) {
            aVar.idn.postDelayed(new 1(this, aVar), 100);
        }
        return super.b(i, view, viewGroup);
    }

    public final f oG(int i) {
        return super.oG(i);
    }

    public final int aDz() {
        return this.idM;
    }

    public final void oD(int i) {
        this.idM = i;
    }

    public final int aDA() {
        return this.idN;
    }

    public final void oE(int i) {
        this.idN = i;
    }

    public final int aDB() {
        return this.idO;
    }

    public final void oF(int i) {
        this.idO = i;
    }
}
