package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.am;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

class y$b$a implements a {
    private Bitmap dHf = null;
    private int ewk = 0;
    private w ewl;

    public y$b$a(w wVar) {
        if (y.b(wVar)) {
            this.ewl = wVar;
            return;
        }
        throw new IllegalArgumentException("from net, picture strategy here must be validity");
    }

    public final boolean Kr() {
        Throwable e;
        if (this.ewl == null) {
            x.e("MicroMsg.MMPictureLogic", "picStrategy == null");
        } else {
            FileOutputStream fileOutputStream;
            String contentType;
            InputStream inputStream;
            try {
                this.ewl.VB();
                File file = new File(this.ewl.Vv());
                fileOutputStream = new FileOutputStream(file.getAbsolutePath() + "_tmp");
                try {
                    u a = b.a(this.ewl.Vw(), null);
                    if (q.Pn() && q.lY(this.ewl.Vw())) {
                        x.d("MicroMsg.MMPictureLogic", "webp referer:%s", new Object[]{q.hZ(d.qVN)});
                        a.oz(contentType);
                    }
                    a.setConnectTimeout(10000);
                    a.setReadTimeout(20000);
                    a.setRequestMethod("GET");
                    if (b.a(a) == 0) {
                        inputStream = a.getInputStream();
                    } else {
                        inputStream = null;
                    }
                    try {
                        contentType = a.aBv.getContentType();
                        try {
                            x.d("MicroMsg.MMPictureLogic", "contentType:%s", new Object[]{contentType});
                            if (inputStream == null) {
                                x.w("MicroMsg.MMPictureLogic", "download %s error, can not open http stream", new Object[]{this.ewl.Vw()});
                                this.ewl.P(contentType, false);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e2) {
                                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e2)});
                                    }
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e22)});
                                }
                            } else {
                                Bitmap a2;
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    this.ewk += read;
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                x.i("MicroMsg.MMPictureLogic", "get url[%s] ok, bufSize[%d]", new Object[]{this.ewl.Vw(), Integer.valueOf(this.ewk)});
                                this.ewl.P(contentType, true);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e222) {
                                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e222)});
                                    }
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e2222) {
                                    x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e2222)});
                                }
                                try {
                                    Bitmap oO;
                                    g.cu(file.getAbsolutePath() + "_tmp");
                                    w.b Vu = this.ewl.Vu();
                                    if (Vu != null) {
                                        oO = Vu.oO(file.getAbsolutePath() + "_tmp");
                                    } else {
                                        oO = y.b.oQ(file.getAbsolutePath() + "_tmp");
                                    }
                                    if (oO != null) {
                                        a2 = this.ewl.a(oO, w.a.evZ, file.getAbsolutePath() + "_tmp");
                                    } else {
                                        this.ewl.a(w.a.evZ, contentType);
                                        a2 = null;
                                    }
                                    if (!(a2 == oO || oO.isRecycled())) {
                                        x.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[]{oO.toString()});
                                        oO.recycle();
                                    }
                                    y.b.a(y.b.ewd, this.ewl, a2);
                                    new File(file.getAbsolutePath() + "_tmp").delete();
                                } catch (Throwable e22222) {
                                    x.w("MicroMsg.MMPictureLogic", "update pic for %s, error", new Object[]{this.ewl.Vw()});
                                    x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e22222)});
                                    a2 = null;
                                }
                                this.dHf = a2;
                            }
                        } catch (Exception e3) {
                            e22222 = e3;
                            try {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e22222)});
                                x.w("MicroMsg.MMPictureLogic", "get url:%s failed.", new Object[]{this.ewl.Vw()});
                                this.ewl.P(contentType, false);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e222222) {
                                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e222222)});
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable e2222222) {
                                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e2222222)});
                                    }
                                }
                                return true;
                            } catch (Throwable th) {
                                e2222222 = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e4) {
                                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e4)});
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable e42) {
                                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e42)});
                                    }
                                }
                                throw e2222222;
                            }
                        }
                    } catch (Exception e5) {
                        e2222222 = e5;
                        contentType = null;
                    }
                } catch (Exception e6) {
                    e2222222 = e6;
                    contentType = null;
                    inputStream = null;
                    x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e2222222)});
                    x.w("MicroMsg.MMPictureLogic", "get url:%s failed.", new Object[]{this.ewl.Vw()});
                    this.ewl.P(contentType, false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e22222222) {
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e22222222)});
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e222222222) {
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e222222222)});
                        }
                    }
                    return true;
                } catch (Throwable th2) {
                    e222222222 = th2;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e422) {
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e422)});
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4222) {
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e4222)});
                        }
                    }
                    throw e222222222;
                }
            } catch (Exception e7) {
                e222222222 = e7;
                contentType = null;
                inputStream = null;
                fileOutputStream = null;
                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e222222222)});
                x.w("MicroMsg.MMPictureLogic", "get url:%s failed.", new Object[]{this.ewl.Vw()});
                this.ewl.P(contentType, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2222222222) {
                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e2222222222)});
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22222222222) {
                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e22222222222)});
                    }
                }
                return true;
            } catch (Throwable th3) {
                e22222222222 = th3;
                inputStream = null;
                fileOutputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e42222) {
                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e42222)});
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e422222) {
                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e422222)});
                    }
                }
                throw e22222222222;
            }
        }
        return true;
    }

    public final boolean Ks() {
        try {
            am.a.dBs.aY(this.ewk, 0);
        } catch (Throwable e) {
            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bi.i(e)});
        }
        y.b.a(y.b.ewd, this.ewl.Vw(), this.ewl.Vx(), this.dHf);
        this.dHf = null;
        return false;
    }
}
