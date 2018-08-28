package com.tencent.mm.ak.a.b;

import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.c.f;
import com.tencent.mm.ak.a.g.b;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class a implements com.tencent.mm.ak.a.c.a {
    private f dYd;

    private String a(String str, c cVar) {
        String str2 = cVar.dXA;
        if (str2 == null || str2.length() == 0) {
            str2 = cVar.dXB;
            if (!(str2 == null || str2.length() == 0)) {
                str2 = str2 + "/" + this.dYd.mc(str);
            }
        }
        if (cVar.dXx && bi.oW(r0)) {
            str2 = b.Pw() + "/" + this.dYd.mc(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    private String b(String str, c cVar) {
        String str2 = cVar.dXC;
        if (str2 == null || str2.length() == 0) {
            String str3 = cVar.dXA;
            if (str3 != null && str3.length() > 0) {
                str2 = cVar.dXB;
                if (str2 == null || str2.length() == 0 || !str3.startsWith(str2)) {
                    x.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", new Object[]{str3});
                    throw new IllegalArgumentException("SFS can't deal with absolute path: " + str3);
                }
                str2 = str3.substring(str2.length());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
            }
        }
        if (str2 == null || str2.length() == 0) {
            str2 = this.dYd.mc(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    public final boolean a(String str, byte[] bArr, c cVar) {
        SFSContext sFSContext = cVar.dXU;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                String str2 = "";
                if (com.tencent.mm.modelsfs.f.mP(b)) {
                    str2 = com.tencent.mm.modelsfs.f.mS(b);
                    b = com.tencent.mm.modelsfs.f.mQ(b);
                }
                outputStream = sFSContext.aw(b, str2);
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (outputStream == null) {
                    return false;
                }
                try {
                    outputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } else {
            String a = a(str, cVar);
            if (a == null) {
                return false;
            }
            com.tencent.mm.vfs.b cBW = new com.tencent.mm.vfs.b(a).cBW();
            if (!(cBW == null || cBW.exists())) {
                cBW.mkdirs();
            }
            cBW = new com.tencent.mm.vfs.b(a);
            if (!cBW.exists()) {
                try {
                    cBW.createNewFile();
                } catch (Throwable e5) {
                    x.i("MicroMsg.imageloader.DefaultImageDiskCache", bi.i(e5));
                }
            }
            if (bArr != null && d.b(a, bArr, bArr.length) < 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(String str, c cVar) {
        SFSContext sFSContext = cVar.dXU;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            return sFSContext.jy(b);
        }
        String a = a(str, cVar);
        if (a != null) {
            return new com.tencent.mm.vfs.b(a).delete();
        }
        return false;
    }

    public final void Pu() {
        b.Py();
    }

    public final InputStream d(String str, c cVar) {
        try {
            SFSContext sFSContext = cVar.dXU;
            String b;
            if (sFSContext != null) {
                b = b(str, cVar);
                if (b == null) {
                    return null;
                }
                return sFSContext.openRead(b);
            }
            b = a(str, cVar);
            if (b != null) {
                return new com.tencent.mm.vfs.c(b);
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public final void a(f fVar) {
        this.dYd = fVar;
    }
}
