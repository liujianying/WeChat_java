package com.tencent.mm.plugin.exdevice.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.e;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

final class ExdeviceBindDeviceUI$a extends BaseAdapter {
    private c iAs;
    List<f> iBm = new ArrayList();
    private String iBn;
    private int iBo;
    private String iBp;

    public ExdeviceBindDeviceUI$a(String str, int i, String str2) {
        this.iBn = str;
        this.iBo = i;
        this.iBp = str2;
        a aVar = new a();
        aVar.dXR = R.e.settings_bg;
        this.iAs = aVar.Pt();
    }

    public final void aHM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iBm.size()) {
                f fVar = (f) this.iBm.get(i2);
                fVar.iBy = c(fVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final boolean b(f fVar) {
        if (At(fVar.getKey()) < 0) {
            return false;
        }
        fVar.iBy = c(fVar);
        return true;
    }

    public final boolean Ar(String str) {
        return At(str) >= 0;
    }

    public final f As(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iBm.size()) {
                return null;
            }
            f fVar = (f) this.iBm.get(i2);
            if (!Au(fVar.aHN()) && str.equalsIgnoreCase(fVar.aHN())) {
                return fVar;
            }
            i = i2 + 1;
        }
    }

    public final int getCount() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.iBm.size()) {
                return i3;
            }
            if (((f) this.iBm.get(i2)).iBy) {
                i3++;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: pe */
    public final f getItem(int i) {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.iBm.size()) {
                return null;
            }
            if (((f) this.iBm.get(i4)).iBy) {
                i2++;
            }
            if (i2 == i) {
                return (f) this.iBm.get(i4);
            }
            i3 = i4 + 1;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View inflate;
        f pe = getItem(i);
        if (view == null) {
            aVar = new a((byte) 0);
            inflate = View.inflate(viewGroup.getContext(), R.i.exdevice_bind_device_item, null);
            aVar.eMe = (TextView) inflate.findViewById(R.h.nameTV);
            aVar.gmn = (ImageView) inflate.findViewById(R.h.iconIV);
            inflate.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            inflate = view;
        }
        if (pe == null || pe.iBD == null) {
            Assert.assertTrue(false);
            return inflate;
        }
        String str;
        String str2;
        Object obj;
        CharSequence spannableString;
        if (pe.iBz == ExdeviceBindDeviceUI$b.iBr) {
            x.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[]{Integer.valueOf(i), pe.iBA.iBt, pe.iBA.bvw, pe.iBD.rOC});
            str = "";
            str2 = pe.iBD.cCZ;
            if (str2 != null && str2.length() >= 4) {
                str = str2.substring(str2.length() - 4, str2.length());
            } else if (pe.iBA.bvw != null && pe.iBA.bvw.length() >= 4) {
                str = pe.iBA.bvw;
                str = str.substring(str.length() - 4, str.length());
            }
            obj = pe.iBD.rOC + " " + str;
            spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.hint_text_color)), pe.iBD.rOC.length() + 1, obj.length(), 17);
            aVar.eMe.setText(spannableString);
        } else if (pe.iBz == ExdeviceBindDeviceUI$b.iBq) {
            str = "";
            str2 = pe.iBD.cCZ;
            if (str2 != null && str2.length() >= 4) {
                str = str2.substring(str2.length() - 4, str2.length());
            } else if (pe.iBD.rgL != null && pe.iBD.rgL.length() >= 4) {
                str = pe.iBD.rgL;
                str = str.substring(str.length() - 4, str.length());
            }
            obj = pe.iBD.rOC + " " + str;
            spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.hint_text_color)), pe.iBD.rOC.length() + 1, obj.length(), 17);
            aVar.eMe.setText(spannableString);
        } else {
            Assert.assertTrue(false);
        }
        str = pe.iBD.jPG;
        if (!Au(str)) {
            o.Pj().a(str, aVar.gmn, this.iAs);
        }
        return inflate;
    }

    private int At(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iBm.size()) {
                return -1;
            }
            if (((f) this.iBm.get(i2)).getKey().compareTo(str) == 0) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    final int cC(String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iBm.size()) {
                return -1;
            }
            f fVar = (f) this.iBm.get(i2);
            String str3 = fVar.iBC != null ? fVar.iBC.reT : fVar.iBz == ExdeviceBindDeviceUI$b.iBq ? fVar.iBB.izI : null;
            String str4 = fVar.iBC != null ? fVar.iBC.hbO : fVar.iBz == ExdeviceBindDeviceUI$b.iBq ? fVar.iBB.iut : null;
            if (!Au(str3) && !Au(str4) && str.compareTo(str3) == 0 && str2.compareTo(str4) == 0) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    final boolean c(f fVar) {
        if (fVar.iBD == null) {
            return false;
        }
        if (this.iBo == e.iBw) {
            if (fVar.iBD.rOv == null || fVar.iBD.rOv.compareTo(this.iBn) != 0 || fVar.iBD.rOE == null || fVar.iBD.rOE.compareTo(this.iBp) != 0) {
                return false;
            }
        } else if (this.iBo != e.iBv) {
            Assert.assertTrue(false);
            return false;
        } else if (fVar.iBD.cCV == 0) {
            return false;
        }
        return true;
    }

    private static boolean Au(String str) {
        return str == null || str.length() == 0;
    }
}
