package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.c.i;
import com.tencent.d.b.c.b;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import junit.framework.Assert;

public final class h extends d implements a {
    private int fdx = -1;
    String pIu = null;
    String vlV = null;
    private c vmD = null;
    f vmE = null;
    private WeakReference<Context> vmF = null;
    com.tencent.d.b.c.a vmG = null;
    b vmH = null;
    i vmI = null;
    private a vmJ = null;
    boolean vmK;
    boolean vmL;
    boolean vmM;

    private class a extends com.tencent.d.a.a.a.b {
        Signature vmO;

        /* synthetic */ a(h hVar, Signature signature, byte b) {
            this(signature);
        }

        private a(Signature signature) {
            this.vmO = null;
            this.vmO = signature;
        }

        static String T(CharSequence charSequence) {
            return charSequence == null ? "unknown error" : charSequence.toString();
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", new Object[]{Integer.valueOf(i), charSequence});
            if (i != 10308) {
                g.cGb().A(new 1(this, i, charSequence));
                h.this.b(new com.tencent.d.b.a.a(21, T(charSequence)));
            } else {
                h.this.b(new com.tencent.d.b.a.a(25, T(charSequence)));
            }
            cGd();
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[]{Integer.valueOf(i), charSequence});
            g.cGb().A(new 2(this, i, charSequence));
        }

        public final void bFm() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.cGb().C(new Runnable() {
                public final void run() {
                    if (com.tencent.d.a.c.f.oW(h.this.pIu)) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        a.this.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "challenge is null");
                        return;
                    }
                    try {
                        a.this.vmO.update(h.this.pIu.getBytes(Charset.forName("UTF-8")));
                        h hVar = h.this;
                        try {
                            hVar.vmI = com.tencent.d.a.a.bP(a.this.vmO.sign());
                            if (hVar.vmE == null) {
                                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                hVar.b(new com.tencent.d.b.a.a(hVar.vmI));
                            } else if (hVar.vmI == null) {
                                hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                            } else {
                                hVar.vmE.bx(new com.tencent.d.b.e.f.a(hVar.vmI.signature, hVar.vmI.vlM, hVar.vmI.vlL));
                                hVar.vmE.a(new 3(hVar));
                                hVar.vmE.execute();
                            }
                        } catch (Throwable e) {
                            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", new Object[]{e.getMessage()});
                            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: sign failed due to exception");
                            hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                        }
                    } catch (Throwable e2) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                        com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e2, "soter: exception in update");
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: remove the auth key: %s", new Object[]{h.this.vlV});
                        com.tencent.d.a.a.bD(h.this.vlV, false);
                        a.this.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "update signature failed");
                    }
                }
            });
            g.cGb().A(new Runnable() {
                public final void run() {
                    if (h.this.vmH != null) {
                        h.this.vmH.aNG();
                    }
                }
            });
            cGd();
        }

        public final void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            g.cGb().A(new Runnable() {
                public final void run() {
                    if (h.this.vmH != null) {
                        h.this.vmH.onAuthenticationFailed();
                    }
                }
            });
            if (h.this.vmK) {
                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                h.this.vmG.mR(false);
                g.cGb().C(new 7(this));
                g.cGb().l(new 8(this), 1000);
            }
        }

        public final void aNH() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (h.this.vmM) {
                com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                return;
            }
            super.aNH();
            g.cGb().A(new 6(this));
            h.this.b(new com.tencent.d.b.a.a(24, "user cancelled authentication"));
            cGd();
        }

        @SuppressLint({"NewApi"})
        private void cGd() {
            if (h.this.vmL) {
                h.this.vmG.mR(false);
                h.this.vmM = true;
            }
        }
    }

    public h(b bVar) {
        boolean z = true;
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.vmK = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.vmL = z;
        this.vmM = false;
        if (bVar == null) {
            throw new IllegalArgumentException("param is null!");
        }
        this.fdx = bVar.fdx;
        this.vmD = bVar.vmi;
        this.vmE = bVar.vmj;
        this.vmF = new WeakReference(bVar.mContext);
        this.vmH = bVar.vmk;
        this.vmG = bVar.jgQ;
        this.pIu = bVar.pIu;
    }

    @SuppressLint({"DefaultLocale", "NewApi"})
    final boolean cFX() {
        if (!com.tencent.d.b.b.a.cFO().isInit()) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.a(14));
            return true;
        } else if (com.tencent.d.b.b.a.cFO().cFN()) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            this.vlV = (String) com.tencent.d.b.b.a.cFO().cFQ().get(this.fdx, "");
            if (com.tencent.d.a.c.f.oW(this.vlV)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.fdx)})));
                return true;
            } else if (!com.tencent.d.a.a.cFD()) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: app secure key not exists. need re-generate", new Object[0]);
                b(new com.tencent.d.b.a.a(3));
                return true;
            } else if (!com.tencent.d.a.a.acz(this.vlV) || com.tencent.d.a.a.acB(this.vlV) == null) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", new Object[]{this.vlV});
                b(new com.tencent.d.b.a.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.fdx)})));
                return true;
            } else if (!com.tencent.d.a.a.acA(this.vlV)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s has already expired, and we've already deleted them. need re-generate", new Object[]{this.vlV});
                b(new com.tencent.d.b.a.a(11, String.format("the auth key to scene %d has already been expired. in Android versions above 6.0, a key would be expired when user enrolls a new fingerprint. please prepare the key again", new Object[]{Integer.valueOf(this.fdx)})));
                return true;
            } else if (this.vmD == null && com.tencent.d.a.c.f.oW(this.pIu)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                b(new com.tencent.d.b.a.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                return true;
            } else {
                Context context = (Context) this.vmF.get();
                if (context == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    b(new com.tencent.d.b.a.a(17));
                    return true;
                } else if (!com.tencent.d.a.a.a.hB(context).hasEnrolledFingerprints()) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    b(new com.tencent.d.b.a.a(18));
                    return true;
                } else if (com.tencent.d.a.a.hA(context)) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    b(new com.tencent.d.b.a.a(25, "Too many failed times"));
                    return true;
                } else if (this.vmG == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.vmG = new com.tencent.d.b.c.a();
                    return false;
                } else {
                    if (this.vmE == null) {
                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    return false;
                }
            }
        } else {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.a(2));
            return true;
        }
    }

    final void cFY() {
        if (this.vmG != null) {
            this.vmG.mR(true);
        }
    }

    final void execute() {
        if (com.tencent.d.a.c.f.oW(this.pIu)) {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.vmD.bx(new com.tencent.d.b.e.c.a());
            this.vmD.a(new 1(this));
            this.vmD.execute();
            return;
        }
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        cGc();
    }

    final void cGc() {
        Signature acC = com.tencent.d.a.a.acC(this.vlV);
        if (acC == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            b(new com.tencent.d.b.a.a(13));
            return;
        }
        this.vmJ = new a(this, acC, (byte) 0);
        a(acC);
        g.cGb().A(new 2(this));
    }

    @SuppressLint({"NewApi"})
    final void a(Signature signature) {
        if (this.vlZ) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = (Context) this.vmF.get();
        if (context == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            b(new com.tencent.d.b.a.a(17));
            return;
        }
        try {
            com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.d.a.a.a.hB(context).a(new d(signature), this.vmG != null ? this.vmG.vlR : null, this.vmJ);
        } catch (Throwable e) {
            String message = e.getMessage();
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", new Object[]{message});
            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: caused exception when authenticating");
            b(new com.tencent.d.b.a.a(20, String.format("start authentication failed due to %s", new Object[]{message})));
        }
    }

    public final void cFW() {
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.vmJ != null) {
            this.vmJ.aNH();
        }
    }

    public final boolean isCancelled() {
        return this.vmM;
    }
}
