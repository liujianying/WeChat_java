package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ar.n;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.b;
import java.util.HashMap;

@a(cwo = b.class)
public class f extends a implements b {
    private static HashMap<String, e> tOJ = new HashMap();
    private e mnM = null;
    private Bitmap tOG;
    private ImageView tOH;
    private final j.a tOI = new 1(this);

    public final void bVP() {
        int intValue;
        com.tencent.mm.ar.a mw = r.Qq().mw(this.bAG.getTalkerUserName());
        if (mw == null) {
            au.HU();
            intValue = ((Integer) c.DT().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = mw.ecv;
        }
        if (intValue == -2) {
            setBackgroundColor(cuL());
            bC(this.bAG.tTq.getContext(), "chatting/purecolor_chat.xml");
            return;
        }
        r.Qp();
        int bP = n.bP(this.bAG.tTq.getContext());
        if (intValue == 0) {
            switch (bP) {
                case 1:
                case 2:
                case 3:
                case 4:
                    intValue = R.g.chatting_bg_default;
                    break;
                default:
                    intValue = -1;
                    break;
            }
            if (intValue != -1) {
                cuK();
                try {
                    this.tOG = BitmapFactory.decodeResource(this.bAG.tTq.getMMResources(), intValue);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable th) {
                }
                if (this.tOG == null) {
                    x.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = " + intValue);
                    setBackgroundColor(this.bAG.tTq.getMMResources().getColor(R.e.chatting_bg_purecolor));
                } else {
                    if (this.tOH == null) {
                        this.tOH = (ImageView) this.bAG.findViewById(R.h.chatting_bg_iv);
                    }
                    if (this.tOH != null) {
                        this.tOH.setImageBitmap(this.tOG);
                    }
                }
                bC(this.bAG.tTq.getContext(), "chatting/reserved_chat.xml");
                return;
            }
            return;
        }
        String str;
        n Qp = r.Qp();
        if (intValue > 0) {
            bC(this.bAG.tTq.getContext(), "chatting/default_chat.xml");
            switch (bP) {
                case 1:
                    str = Qp.bl(intValue, 1) + "horizontal_hdpi.jpg";
                    break;
                case 2:
                    str = Qp.bl(intValue, 1) + "horizontal_ldpi.jpg";
                    break;
                case 3:
                    str = Qp.bl(intValue, 1) + "vertical_hdpi.jpg";
                    break;
                case 4:
                    str = Qp.bl(intValue, 1) + "vertical_ldpi.jpg";
                    break;
                default:
                    str = null;
                    break;
            }
        }
        bC(this.bAG.tTq.getContext(), "chatting/default_chat.xml");
        str = mw == null ? n.Q("default", bP) : n.Q(this.bAG.getTalkerUserName(), bP);
        cuK();
        this.tOG = y.oQ(str);
        if (this.tOG == null) {
            x.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = " + str);
            setBackgroundColor(cuL());
            return;
        }
        if (this.tOH == null) {
            this.tOH = (ImageView) this.bAG.findViewById(R.h.chatting_bg_iv);
        }
        if (this.tOH != null) {
            this.tOH.setImageBitmap(this.tOG);
        }
    }

    private void cuK() {
        if (!(this.tOG == null || this.tOG.isRecycled())) {
            x.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[]{this.tOG.toString()});
            this.tOG.recycle();
        }
        if (this.tOH != null) {
            this.tOH.setImageBitmap(null);
        }
    }

    private int cuL() {
        return this.bAG.tTq.getMMResources().getColor(R.e.chatting_bg_purecolor);
    }

    private void setBackgroundColor(int i) {
        cuK();
        if (this.tOH == null) {
            View findViewById = this.bAG.findViewById(R.h.chatting_bg_ll);
            if (findViewById != null) {
                findViewById.setBackgroundColor(i);
                return;
            }
            return;
        }
        this.tOH.setImageDrawable(new ColorDrawable(i));
    }

    private boolean bC(Context context, String str) {
        if (tOJ.containsKey(str)) {
            this.mnM = (e) tOJ.get(str);
            return true;
        }
        try {
            this.mnM = new e(bi.convertStreamToString(context.getAssets().open(str)));
            tOJ.put(str, this.mnM);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", e, "", new Object[0]);
            return false;
        }
    }

    public final e cuM() {
        return this.mnM;
    }

    public final void cpF() {
    }

    public final void cpG() {
        x.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
        bVP();
    }

    public final void cpH() {
        r.Qq().c(this.tOI);
        r.Qp().c(this.tOI);
    }

    public final void cpI() {
    }

    public final void cpJ() {
    }

    public final void cpL() {
        x.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
        if (au.HX()) {
            r.Qq().d(this.tOI);
            r.Qp().d(this.tOI);
        }
        cuK();
    }
}
