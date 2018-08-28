package com.tencent.mm.plugin.sns.a.b;

import android.view.View;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public String bNH = "";
    long egG = 0;
    public String egH = "";
    private String fvT = "";
    boolean hxu = false;
    public int iGo = 0;
    private int niA = -10086;
    private int niB = -10086;
    long niC = 0;
    int niD = 0;
    int niE = -1;
    int niF = -1;
    int niG = 0;
    int niH = 0;
    int niI = 0;
    private boolean niJ = false;
    private int niK = 0;
    boolean nia = false;
    public boy nib;
    public View nic;
    public View nid;
    public int nie = 0;
    public int nif = 0;
    public int nig;
    private View nih;
    private int nii = 0;
    private com.tencent.mm.plugin.sns.storage.a nij = null;
    b nik;
    int nil = -10086;
    private int nim = -10086;
    int nin = -10086;
    private int nio = -10086;
    long nip = 0;
    long niq = 0;
    private int nir = -10086;
    private int nis = -10086;
    long nit = 0;
    private int niu = -10086;
    private int niv = -10086;
    long niw = 0;
    private int nix = -10086;
    private int niy = -10086;
    long niz = 0;
    int position = 0;
    public int sceneType = 1;

    public a(com.tencent.mm.plugin.sns.storage.a aVar, String str, long j, View view, int i, View view2, int i2, int i3, boy boy, int i4, b bVar) {
        this.position = i4;
        this.nic = view;
        this.nib = boy;
        this.nik = bVar;
        this.nij = aVar;
        this.sceneType = i3;
        this.fvT = aVar == null ? "" : bi.aG(aVar.fvT, "");
        this.egH = aVar == null ? "" : bi.aG(aVar.ntU, "");
        this.bNH = str;
        this.egG = j;
        this.nig = i;
        this.nih = view2;
        this.nii = i2;
        if (this.nic != null) {
            this.nid = this.nic.findViewById(f.album_list_fatherview);
        }
        initView();
    }

    private void initView() {
        if (this.iGo == 0 && this.nic != null) {
            BackwardSupportUtil.b.b(this.nic.getContext(), 50.0f);
            this.iGo = this.nic.getHeight();
            if (this.nid != null) {
                this.nie = this.nid.getHeight();
            }
            if (this.iGo != 0) {
                int i = 0;
                if (this.nih != null) {
                    i = this.nih.getBottom();
                }
                this.iGo -= this.nie;
                this.nif = this.iGo / 2;
                this.nig = (this.nig - i) - this.nii;
                x.i("MicroMsg.AdViewStatic", "viewHeight " + this.iGo + " SCREEN_HEIGHT: " + this.nig + " abottom: " + i + " stHeight: " + this.nii + " commentViewHeight:" + this.nie);
            }
        }
    }

    public final void bwK() {
        boolean z = true;
        if (this.nic != null) {
            initView();
            if (!this.hxu && this.iGo > 0) {
                int bottom;
                int i;
                this.nia = true;
                int top = this.nic.getTop();
                int bottom2 = this.nic.getBottom() - this.nie;
                if (!this.niJ) {
                    int[] iArr = new int[2];
                    this.nic.getLocationOnScreen(iArr);
                    if (this.nih != null) {
                        bottom = this.nih.getBottom();
                    } else {
                        bottom = 0;
                    }
                    this.niK = top - ((iArr[1] - bottom) - this.nii);
                    this.niJ = true;
                }
                top -= this.niK;
                bottom2 -= this.niK;
                if (top < 0 || bottom2 > this.nig) {
                    this.niI = 0;
                } else {
                    this.niI = 1;
                }
                if (this.nil == -10086 && this.nim == -10086) {
                    this.nil = top;
                    this.nim = bottom2;
                }
                this.nin = top;
                this.nio = bottom2;
                if (top < 0) {
                    i = top + this.iGo;
                    int i2 = this.iGo - i;
                    if (i < this.nif || this.nir != -10086) {
                        boolean z2 = true;
                    } else {
                        this.nir = top;
                        this.nis = bottom2;
                        this.nit = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "up first touch half" + i + " top " + top + " viewhieght " + this.iGo + " inscreenval: " + i + " outscreenval: " + i2);
                        bottom = 0;
                    }
                    if (i2 >= this.nif && this.niu == -10086 && z2 != 0 && this.nit > 0) {
                        this.niu = top;
                        this.niv = bottom2;
                        this.niw = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "down first touch half" + i + " bottom " + bottom2 + " viewhieght " + this.iGo + " inscreenval: " + i + " outscreenval: " + i2);
                    }
                }
                if (bottom2 > this.nig) {
                    bottom = bottom2 - this.nig;
                    i = this.iGo - bottom;
                    if (i >= this.nif && this.nir == -10086) {
                        this.nir = top;
                        this.nis = bottom2;
                        this.nit = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "up first touch half" + bottom + " top " + top + " viewhieght " + this.iGo + " inscreenval: " + i + " outscreenval: " + bottom);
                        z = false;
                    }
                    if (bottom >= this.nif && this.niu == -10086 && z && this.nit > 0) {
                        this.niu = top;
                        this.niv = bottom2;
                        this.niw = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "down first touch half" + bottom + " bottom " + bottom2 + " viewhieght " + this.iGo + " inscreenval: " + i + " outscreenval: " + bottom);
                    }
                }
                if (top < 0 || bottom2 > this.nig) {
                    if (this.niC == 0 && this.niz != 0) {
                        this.niA = top;
                        this.niB = bottom2;
                        this.niC = System.currentTimeMillis();
                    }
                } else if (this.niz == 0) {
                    this.nix = top;
                    this.niy = bottom2;
                    this.niz = System.currentTimeMillis();
                }
                if (top < 0) {
                    bottom = -top;
                    if (this.niE == -1 || this.niE > bottom) {
                        this.niE = bottom;
                    }
                } else {
                    this.niE = 0;
                }
                if (bottom2 > this.nig) {
                    bottom = bottom2 - this.nig;
                    if (this.niF == -1 || this.niF > bottom) {
                        this.niF = bottom;
                    }
                } else {
                    this.niF = 0;
                }
                bottom = this.iGo;
                if (top < 0) {
                    bottom += top;
                }
                if (bottom2 > this.nig) {
                    bottom -= bottom2 - this.nig;
                }
                if (this.niD == -1 || this.niD < bottom) {
                    this.niD = bottom;
                }
            }
        }
    }

    public final com.tencent.mm.protocal.c.bi bwL() {
        com.tencent.mm.protocal.c.bi biVar = new com.tencent.mm.protocal.c.bi();
        n fi = af.byo().fi(this.egG);
        if (fi != null) {
            boy n = aj.n(fi);
            if (n != null) {
                biVar.rbI = n.smO.size();
                biVar.like_count = n.smL.size();
                return biVar;
            }
        }
        if (this.nib == null) {
            return null;
        }
        biVar.rbI = this.nib.smN;
        biVar.like_count = this.nib.smK;
        return biVar;
    }
}
