package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bm.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public abstract class g extends i {
    String code;
    private Bitmap eZA;
    MMActivity gKS;
    private j hCm;
    private ViewStub hHA;
    private ViewGroup hHy;
    private ab hHz;
    protected b htQ;
    private Bitmap hyO;
    private OnLongClickListener hyX = new 1(this);

    public abstract ab azN();

    public abstract ab azO();

    public abstract ab azP();

    public abstract String e(c cVar);

    public abstract boolean h(b bVar);

    public final void initView() {
        this.gKS = this.hHF.ayx();
        this.hCm = this.hHF.ayD();
        this.htQ = this.hHF.ayu();
        if (this.htQ == null) {
            x.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
            return;
        }
        switch (this.htQ.awn().rnc) {
            case 0:
                this.hHz = azP();
                break;
            case 1:
                this.hHz = azO();
                break;
            case 2:
                this.hHz = azN();
                break;
            default:
                this.hHz = azN();
                break;
        }
        if (this.hHz == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.htQ.awn().rnc) {
            case 0:
                if (this.hHA == null) {
                    this.hHA = (ViewStub) findViewById(d.card_code_stub);
                    break;
                }
                break;
            case 1:
                if (this.hHA == null) {
                    this.hHA = (ViewStub) findViewById(d.card_barcode_stub);
                    break;
                }
                break;
            case 2:
                if (this.hHA == null) {
                    this.hHA = (ViewStub) findViewById(d.card_qrcode_stub);
                    break;
                }
                break;
            default:
                if (this.hHA == null) {
                    this.hHA = (ViewStub) findViewById(d.card_qrcode_stub);
                    break;
                }
                break;
        }
        if (this.hHA == null) {
            x.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.hHz == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.hHz.getLayoutId() == 0) {
            x.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.hHA.setLayoutResource(this.hHz.getLayoutId());
            if (this.hHy == null) {
                this.hHy = (ViewGroup) this.hHA.inflate();
            }
        }
        if (this.hHy == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    public final void d(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.htQ = bVar;
        }
    }

    public final void destroy() {
        super.destroy();
        this.gKS = null;
        this.hCm = null;
        this.htQ = null;
        this.hHy = null;
        this.hHz = null;
        l.x(this.eZA);
        l.x(this.hyO);
    }

    public final void update() {
        if (this.htQ == null) {
            x.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.hHz == null) {
            x.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.hHy == null) {
            x.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.hCm.ayS();
            d(c.hID);
            this.hHz.c(this.hHy, this.htQ);
        }
    }

    public final void d(c cVar) {
        int i = 1;
        if (this.htQ == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (cVar == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (this.hHz.i(this.htQ)) {
            this.hHz.g(this.hHy);
            x.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[]{Integer.valueOf(cVar.action)});
            this.code = e(cVar);
            if (bi.oW(this.code)) {
                x.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            View view;
            String str;
            ImageView imageView;
            switch (this.htQ.awn().rnc) {
                case 0:
                    view = this.hHy;
                    str = this.code;
                    TextView textView = (TextView) view.findViewById(d.code_text);
                    textView.setText(m.yd(str));
                    textView.setOnLongClickListener(this.hyX);
                    String str2 = this.htQ.awm().dxh;
                    if (!bi.oW(str2)) {
                        textView.setTextColor(l.xV(str2));
                    }
                    if (str.length() <= 12) {
                        textView.setTextSize(1, 33.0f);
                        return;
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView.setTextSize(1, 30.0f);
                        return;
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView.setTextSize(1, 24.0f);
                        return;
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView.setTextSize(1, 18.0f);
                        return;
                    } else if (str.length() > 40) {
                        textView.setVisibility(8);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    view = this.hHy;
                    String str3 = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(d.code_bar_area);
                        l.x(this.hyO);
                        if (str3 != null && str3.length() > 0) {
                            this.hyO = a.b(this.gKS, str3, 5, 0);
                        }
                        a(imageView, this.hyO);
                        imageView.setOnClickListener(this.hHF.ayy());
                        this.hCm.hyO = this.hyO;
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
                        return;
                    }
                case 2:
                    view = this.hHy;
                    str = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(d.code_qr_area);
                        l.x(this.eZA);
                        if (!(this.htQ == null || this.htQ.awm() == null)) {
                            i = this.htQ.awm().ron;
                        }
                        this.eZA = a.b(this.gKS, str, 0, i);
                        a(imageView, this.eZA);
                        imageView.setOnClickListener(this.hHF.ayy());
                        this.hCm.eZA = this.eZA;
                        j jVar = this.hCm;
                        if (jVar.eZB != null && jVar.eZB.isShowing()) {
                            jVar.eZC.setImageBitmap(jVar.eZA);
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardBaseCodeView", e2, "", new Object[0]);
                        return;
                    }
                default:
                    return;
            }
        } else {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[]{Integer.valueOf(cVar.action)});
            azL();
        }
    }

    public final void azL() {
        if (this.hHz != null && this.htQ != null && this.hHy != null) {
            this.hHz.a(this.hHy, this.htQ);
        }
    }

    public final void azM() {
        if (this.htQ == null || this.hHz == null || this.hHy == null) {
            x.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
            return;
        }
        this.hHz.b(this.hHy, this.htQ);
        if (this.htQ.awn().rnc == 2 && this.hCm != null) {
            j jVar = this.hCm;
            if (jVar.eZB != null && jVar.eZB.isShowing()) {
                jVar.eZB.dismiss();
            }
        }
    }

    public final void azI() {
        if (this.hHy != null) {
            this.hHy.setVisibility(8);
        }
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
