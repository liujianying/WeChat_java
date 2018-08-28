package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class af {
    public List<a> jNG = new LinkedList();
    public String mAppId = "";

    public static class a implements Serializable {
        public String bWJ;
        public int jNH;
        public int jNI;
        public boolean jNJ;
        public String jNK;
        public long jsz;
        public String tag;
    }

    public af(String str) {
        if (!bi.oW(str)) {
            this.mAppId = str;
            this.jNG.addAll(aUp());
        }
    }

    public af(String str, List<cu> list) {
        if (!bi.oW(str) && list != null && !list.isEmpty()) {
            this.mAppId = str;
            this.jNG.clear();
            for (cu cuVar : list) {
                a aVar = new a();
                aVar.jNH = cuVar.jTf;
                aVar.bWJ = cuVar.hbL;
                aVar.tag = cuVar.jTh;
                aVar.jsz = cuVar.jTg;
                aVar.jNJ = cuVar.jTi;
                aVar.jNI = cuVar.jTj;
                aVar.jNK = cuVar.jTk;
                this.jNG.add(aVar);
            }
            aUq();
        }
    }

    private List<a> aUp() {
        Throwable e;
        String str = this.mAppId + "_ranks";
        List<a> linkedList = new LinkedList();
        byte[] Dw = ((c) g.l(c.class)).aSk().Dw(str);
        if (Dw == null) {
            return linkedList;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(Dw);
        ObjectInput objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                linkedList.addAll((List) objectInputStream.readObject());
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                }
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return linkedList;
                } catch (Throwable th) {
                    e = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectInputStream = null;
            x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e62) {
                }
            }
            return linkedList;
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e82) {
                }
            }
            throw e;
        }
        return linkedList;
    }

    public final void aUq() {
        Throwable e;
        String str = this.mAppId + "_ranks";
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this.jNG);
                ((c) g.l(c.class)).aSk().p(str, byteArrayOutputStream.toByteArray());
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectOutputStream = null;
            x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e52) {
                }
            }
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e72) {
                }
            }
            byteArrayOutputStream.close();
            throw e;
        }
    }
}
