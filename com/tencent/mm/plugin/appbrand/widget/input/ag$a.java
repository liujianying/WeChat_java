package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.drawable.Drawable;
import com.tencent.mm.br.e;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.widget.input.ag.c;
import com.tencent.mm.sdk.platformtools.ad;

final class ag$a extends e {
    private String[] gJz;

    ag$a() {
        super(new c(ad.getContext()));
        this.gJz = null;
        this.gJz = ad.getContext().getResources().getStringArray(b.merge_smiley_unicode_emoji);
    }

    public final int apV() {
        return 0;
    }

    public final int apW() {
        return this.gJz != null ? this.gJz.length : 0;
    }

    public final Drawable mg(int i) {
        return new ag.b(mh(i), ag.bB(), (byte) 0);
    }

    public final String mh(int i) {
        if (this.gJz == null || i < 0 || i > this.gJz.length - 1) {
            return "";
        }
        String[] split = this.gJz[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        return toChars + Character.toChars(Integer.decode(split[1]).intValue());
    }

    public final String getText(int i) {
        return mh(i);
    }

    public final String mi(int i) {
        return mh(i);
    }
}
