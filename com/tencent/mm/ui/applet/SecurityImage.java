package com.tencent.mm.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;

public class SecurityImage extends LinearLayout {
    private c eIW = null;
    private String eJa = null;
    private String eJb = null;
    private int eRQ = 0;
    ProgressBar trQ = null;
    ImageView trR = null;
    Button trS = null;
    EditText trT = null;
    private b trU;

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setNetworkModel(b bVar) {
        if (this.trU != null) {
            this.trU.trX = null;
        }
        this.trU = bVar;
        this.trU.trX = this;
    }

    public final void a(int i, byte[] bArr, String str, String str2) {
        lH(true);
        this.eJa = str;
        this.eJb = str2;
        this.eRQ = i;
        Bitmap bs = com.tencent.mm.sdk.platformtools.c.bs(bArr);
        if (bs != null) {
            x.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[]{str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bs.getWidth()), Integer.valueOf(bs.getHeight())});
            this.eJa = str;
            this.eJb = str2;
            this.eRQ = i;
            if (bs != null) {
                this.trR.setImageBitmap(bs);
                return;
            } else {
                x.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
                return;
            }
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.e(str3, str4, objArr);
    }

    public int getSecCodeType() {
        return this.eRQ;
    }

    public String getSecImgSid() {
        return this.eJa;
    }

    public String getSecImgCode() {
        return this.trT == null ? "" : this.trT.getText().toString().trim();
    }

    public String getSecImgEncryptKey() {
        return this.eJb;
    }

    public final void dismiss() {
        if (this.eIW != null) {
            this.eIW.dismiss();
            this.eIW = null;
        }
    }

    private void lH(boolean z) {
        int i = 0;
        this.trR.setAlpha(z ? b.CTRL_BYTE : 40);
        this.trR.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.trQ;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }
}
