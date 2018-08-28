package com.tencent.d.a.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import com.tencent.d.a.a.b.1;
import com.tencent.d.a.a.b.b;
import com.tencent.d.a.c.c;

public final class a {
    static final e vkT;
    private Context mContext;

    private static class a implements e {
        static /* synthetic */ boolean a(com.tencent.d.a.a.b.a aVar, Context context) {
            if (c.cFG()) {
                c.v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                return false;
            } else if (c.hI(context)) {
                if (c.hJ(context)) {
                    return false;
                }
                c.v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                c.hH(context);
                return false;
            } else if (c.hJ(context)) {
                c.v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                return false;
            } else {
                a(aVar);
                return true;
            }
        }

        public final boolean hC(Context context) {
            return b.hC(context);
        }

        public final boolean hD(Context context) {
            return b.hD(context);
        }

        public final void a(final Context context, d dVar, CancellationSignal cancellationSignal, final b bVar) {
            b.c cVar;
            AnonymousClass1 anonymousClass1;
            if (dVar != null) {
                if (dVar.vkY != null) {
                    cVar = new b.c(dVar.vkY);
                } else if (dVar.vkX != null) {
                    cVar = new b.c(dVar.vkX);
                } else if (dVar.vkZ != null) {
                    cVar = new b.c(dVar.vkZ);
                }
                anonymousClass1 = new com.tencent.d.a.a.b.a() {
                    private boolean vkU = false;

                    public final void onAuthenticationError(int i, CharSequence charSequence) {
                        while (true) {
                            c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
                            if (!this.vkU) {
                                this.vkU = true;
                                if (i == 5) {
                                    c.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                                    bVar.aNH();
                                    return;
                                } else if (i == 7) {
                                    c.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                                    if (!(c.hJ(context) || c.hI(context) || c.cFG())) {
                                        c.hG(context);
                                    }
                                    this.vkU = false;
                                    i = 10308;
                                    charSequence = "Too many failed times";
                                } else {
                                    bVar.onAuthenticationError(i, charSequence);
                                    return;
                                }
                            }
                            return;
                        }
                    }

                    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                        c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
                        if (!this.vkU && !a.a(this, context)) {
                            bVar.onAuthenticationHelp(i, charSequence);
                        }
                    }

                    public final void a(b bVar) {
                        c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
                        if (!this.vkU && !a.a(this, context)) {
                            d dVar;
                            c cVar;
                            if (!c.cFG()) {
                                c.hH(context);
                            }
                            this.vkU = true;
                            b bVar2 = bVar;
                            b.c cVar2 = bVar.vlb;
                            if (cVar2 != null) {
                                if (cVar2.vkY != null) {
                                    dVar = new d(cVar2.vkY);
                                } else if (cVar2.vkX != null) {
                                    dVar = new d(cVar2.vkX);
                                } else if (cVar2.vkZ != null) {
                                    dVar = new d(cVar2.vkZ);
                                }
                                cVar = new c(dVar);
                                bVar2.bFm();
                            }
                            dVar = null;
                            cVar = new c(dVar);
                            bVar2.bFm();
                        }
                    }

                    public final void onAuthenticationFailed() {
                        c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
                        if (!this.vkU && !a.a(this, context)) {
                            if (!c.cFG()) {
                                Context context = context;
                                c.as(context, Integer.valueOf(Integer.valueOf(c.hF(context)).intValue() + 1).intValue());
                                if (!c.hJ(context)) {
                                    c.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                                    c.hG(context);
                                    a.a(this);
                                    return;
                                }
                            }
                            bVar.onAuthenticationFailed();
                        }
                    }
                };
                if (b.f(context, "android.permission.USE_FINGERPRINT") == 0) {
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
                }
                try {
                    FingerprintManager hE = b.hE(context);
                    if (hE != null) {
                        CryptoObject cryptoObject;
                        if (cVar != null) {
                            if (cVar.vkY != null) {
                                cryptoObject = new CryptoObject(cVar.vkY);
                            } else if (cVar.vkX != null) {
                                cryptoObject = new CryptoObject(cVar.vkX);
                            } else if (cVar.vkZ != null) {
                                cryptoObject = new CryptoObject(cVar.vkZ);
                            }
                            hE.authenticate(cryptoObject, cancellationSignal, 0, new 1(anonymousClass1), null);
                            return;
                        }
                        cryptoObject = null;
                        hE.authenticate(cryptoObject, cancellationSignal, 0, new 1(anonymousClass1), null);
                        return;
                    }
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                } catch (SecurityException e) {
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    return;
                }
            }
            cVar = null;
            anonymousClass1 = /* anonymous class already generated */;
            if (b.f(context, "android.permission.USE_FINGERPRINT") == 0) {
                try {
                    FingerprintManager hE2 = b.hE(context);
                    if (hE2 != null) {
                        CryptoObject cryptoObject2;
                        if (cVar != null) {
                            if (cVar.vkY != null) {
                                cryptoObject2 = new CryptoObject(cVar.vkY);
                            } else if (cVar.vkX != null) {
                                cryptoObject2 = new CryptoObject(cVar.vkX);
                            } else if (cVar.vkZ != null) {
                                cryptoObject2 = new CryptoObject(cVar.vkZ);
                            }
                            hE2.authenticate(cryptoObject2, cancellationSignal, 0, new 1(anonymousClass1), null);
                            return;
                        }
                        cryptoObject2 = null;
                        hE2.authenticate(cryptoObject2, cancellationSignal, 0, new 1(anonymousClass1), null);
                        return;
                    }
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                } catch (SecurityException e2) {
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    return;
                }
            }
            c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
        }

        static void a(com.tencent.d.a.a.b.a aVar) {
            c.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            aVar.onAuthenticationError(10308, "Too many failed times");
        }
    }

    private static class f implements e {
        public final boolean hC(Context context) {
            return false;
        }

        public final boolean hD(Context context) {
            return false;
        }

        public final void a(Context context, d dVar, CancellationSignal cancellationSignal, b bVar) {
        }
    }

    public static a hB(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        if (com.tencent.d.a.a.cFz()) {
            vkT = new a();
        } else {
            vkT = new f();
        }
    }

    public final boolean hasEnrolledFingerprints() {
        return vkT.hC(this.mContext);
    }

    public final boolean isHardwareDetected() {
        return vkT.hD(this.mContext);
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        vkT.a(this.mContext, dVar, cancellationSignal, bVar);
    }
}
