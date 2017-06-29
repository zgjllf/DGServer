package com.dgserver.server.net.buffer;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.mina.core.buffer.IoBuffer;

public class MyBuffer {
	public static final byte STRING_TYPE_BYTE = 1;
	  public static final byte STRING_TYPE_SHORT = 2;
	  public static MyCharset DEFAULT_CHARSET = MyCharset.UTF_8;

	  public static byte DEFAULT_STRING_TYPE = 1;
	  private IoBuffer buffer;
	  public static final int[] STRING_LEN_MAX = { 0, 255, 65535 };

	  public static MyBuffer allocate(int capacity)
	  {
	    MyBuffer myBuffer = new MyBuffer();

	    myBuffer.buffer = IoBuffer.allocate(capacity);
	    myBuffer.buffer.setAutoExpand(true);

	    return myBuffer;
	  }

	  public static MyBuffer wrap(ByteBuffer buffer)
	  {
	    return wrap(buffer, true);
	  }

	  public static MyBuffer wrapBuffer(IoBuffer buffer, boolean isAutoExpand)
	  {
	    MyBuffer myBuffer = new MyBuffer();

	    myBuffer.buffer = buffer;
	    myBuffer.buffer.setAutoExpand(isAutoExpand);

	    return myBuffer;
	  }

	  public static MyBuffer wrap(ByteBuffer buffer, boolean isAutoExpand)
	  {
	    MyBuffer myBuffer = new MyBuffer();

	    myBuffer.buffer = IoBuffer.wrap(buffer);
	    myBuffer.buffer.setAutoExpand(isAutoExpand);

	    return myBuffer;
	  }

	  public static MyBuffer wrap(byte[] content)
	  {
	    return wrap(content, true);
	  }

	  public static MyBuffer wrap(byte[] content, boolean isAutoExpand)
	  {
	    MyBuffer myBuffer = new MyBuffer();

	    myBuffer.buffer = IoBuffer.wrap(ByteBuffer.wrap(content));

	    myBuffer.buffer.setAutoExpand(isAutoExpand);

	    return myBuffer;
	  }

	  public static MyBuffer wrap(byte[] content, int offset, int length)
	  {
	    return wrap(content, offset, length, true);
	  }

	  public static MyBuffer wrap(byte[] content, int offset, int length, boolean isAutoExpand)
	  {
	    MyBuffer myBuffer = new MyBuffer();
	    myBuffer.buffer = IoBuffer.wrap(ByteBuffer.wrap(content, offset, length));

	    myBuffer.buffer.setAutoExpand(isAutoExpand);
	    return myBuffer;
	  }

	  public IoBuffer buf()
	  {
	    return this.buffer;
	  }

	  public int capacity()
	  {
	    return this.buffer.capacity();
	  }

	  public int position()
	  {
	    return this.buffer.position();
	  }

	  public MyBuffer position(int newPosition)
	  {
	    this.buffer.position(newPosition);

	    return this;
	  }

	  public int limit()
	  {
	    return this.buffer.limit();
	  }

	  public MyBuffer limit(int newLimit)
	  {
	    this.buffer.limit(newLimit);

	    return this;
	  }

	  public MyBuffer mark()
	  {
	    this.buffer.mark();

	    return this;
	  }

	  public int markValue()
	  {
	    return this.buffer.markValue();
	  }

	  public MyBuffer reset()
	  {
	    this.buffer.reset();
	    return this;
	  }

	  public MyBuffer clear()
	  {
	    this.buffer.clear();
	    return this;
	  }

	  public MyBuffer flip()
	  {
	    this.buffer.flip();
	    return this;
	  }

	  public MyBuffer rewind()
	  {
	    this.buffer.rewind();
	    return this;
	  }

	  public int remaining()
	  {
	    return this.buffer.remaining();
	  }

	  public boolean hasRemaining()
	  {
	    return this.buffer.hasRemaining();
	  }

	  public MyBuffer duplicate()
	  {
	    MyBuffer myBuffer = new MyBuffer();

	    myBuffer.buffer = this.buffer.duplicate();

	    return myBuffer;
	  }

	  public MyBuffer slice()
	  {
	    MyBuffer myBuffer = new MyBuffer();

	    myBuffer.buffer = this.buffer.slice();

	    return myBuffer;
	  }

	  public MyBuffer slice(int limit)
	  {
	    MyBuffer myBuffer = new MyBuffer();
	    myBuffer.buffer = this.buffer.slice();
	    myBuffer.limit(limit);

	    return myBuffer;
	  }

	  public MyBuffer sliceNew()
	  {
	    return sliceNew(limit() - position());
	  }

	  public MyBuffer sliceNew(int paramInt)
	  {
	    return wrap(array(), position(), paramInt);
	  }

	  public byte[] array()
	  {
	    return this.buffer.array();
	  }

	  public byte[] arrayToPosition()
	  {
	    int i = position();
	    rewind();
	    return getByteArray(i);
	  }

	  public int arrayOffset()
	  {
	    return this.buffer.arrayOffset();
	  }

	  public byte get()
	  {
	    return this.buffer.get();
	  }

	  public short getUnsigned()
	  {
	    return this.buffer.getUnsigned();
	  }

	  public MyBuffer put(byte data)
	  {
	    this.buffer.put(data);

	    return this;
	  }

	  public byte get(int index)
	  {
	    return this.buffer.get(index);
	  }

	  public short getUnsigned(int index)
	  {
	    return this.buffer.getUnsigned(index);
	  }

	  public MyBuffer put(int index, byte data)
	  {
	    this.buffer.put(index, data);
	    return this;
	  }

	  public MyBuffer get(byte[] dst, int offset, int length)
	  {
	    this.buffer.get(dst, offset, length);
	    return this;
	  }

	  public MyBuffer get(byte[] dst)
	  {
	    this.buffer.get(dst);
	    return this;
	  }

	  public byte[] getByteArray(int byteNum)
	  {
	    byte[] dst = new byte[byteNum];
	    get(dst);
	    return dst;
	  }

	  public MyBuffer put(ByteBuffer src)
	  {
	    this.buffer.put(src);

	    return this;
	  }

	  public MyBuffer put(byte[] src, int offset, int length)
	  {
	    this.buffer.put(src, offset, length);

	    return this;
	  }

	  public MyBuffer put(byte[] src)
	  {
	    this.buffer.put(src);

	    return this;
	  }

	  public MyBuffer compact()
	  {
	    this.buffer.compact();

	    return this;
	  }

	  public ByteOrder order()
	  {
	    return this.buffer.order();
	  }

	  public MyBuffer order(ByteOrder bo)
	  {
	    this.buffer.order(bo);
	    return this;
	  }

	  public char getChar()
	  {
	    return this.buffer.getChar();
	  }

	  public MyBuffer putChar(char value)
	  {
	    this.buffer.putChar(value);

	    return this;
	  }

	  public char getChar(int index)
	  {
	    return this.buffer.getChar(index);
	  }

	  public MyBuffer putChar(int index, char value)
	  {
	    this.buffer.putChar(index, value);

	    return this;
	  }

	  public short getShort()
	  {
	    return this.buffer.getShort();
	  }

	  public int getUnsignedShort()
	  {
	    return this.buffer.getUnsignedShort();
	  }

	  public MyBuffer putShort(short value)
	  {
	    this.buffer.putShort(value);

	    return this;
	  }

	  public MyBuffer putUnsigned(short value)
	  {
	    this.buffer.put(_toUnsigned(value));

	    return this;
	  }

	  public short getShort(int index)
	  {
	    return this.buffer.getShort(index);
	  }

	  public int getUnsignedShort(int index)
	  {
	    return this.buffer.getUnsignedShort(index);
	  }

	  public MyBuffer putShort(int index, short value)
	  {
	    this.buffer.putShort(index, value);
	    return this;
	  }

	  public MyBuffer putUnsigned(int index, short value)
	  {
	    this.buffer.put(index, _toUnsigned(value));
	    return this;
	  }

	  public int getInt()
	  {
	    return this.buffer.getInt();
	  }

	  public long getUnsignedInt()
	  {
	    return this.buffer.getUnsignedInt();
	  }

	  public int getMediumInt()
	  {
	    return this.buffer.getMediumInt();
	  }

	  public int getUnsignedMediumInt()
	  {
	    return this.buffer.getUnsignedMediumInt();
	  }

	  public int getMediumInt(int paramInt)
	  {
	    return this.buffer.getMediumInt(paramInt);
	  }

	  public int getUnsignedMediumInt(int paramInt)
	  {
	    return this.buffer.getUnsignedMediumInt(paramInt);
	  }

	  public MyBuffer putMediumInt(int paramInt)
	  {
	    this.buffer.putMediumInt(paramInt);

	    return this;
	  }

	  public MyBuffer putMediumInt(int paramInt1, int paramInt2)
	  {
	    this.buffer.putMediumInt(paramInt1, paramInt2);

	    return this;
	  }

	  public MyBuffer putInt(int paramInt)
	  {
	    this.buffer.putInt(paramInt);
	    return this;
	  }

	  public MyBuffer putUnsignedShort(int value)
	  {
	    this.buffer.put(_toUnsignedShort(value));
	    return this;
	  }

	  public int getInt(int paramInt)
	  {
	    return this.buffer.getInt(paramInt);
	  }

	  public long getUnsignedInt(int paramInt)
	  {
	    return this.buffer.getUnsignedInt(paramInt);
	  }

	  public MyBuffer putUnsignedShort(int index, int byteNum)
	  {
	    byte[] arrayOfByte = _toUnsignedShort(byteNum);
	    for (int i = 0; i < arrayOfByte.length; i++)
	      this.buffer.put(index + i, arrayOfByte[i]);
	    return this;
	  }

	  public MyBuffer putInt(int index, int value)
	  {
	    this.buffer.putInt(index, value);
	    return this;
	  }

	  public long getLong()
	  {
	    return this.buffer.getLong();
	  }

	  public MyBuffer putLong(long value)
	  {
	    this.buffer.putLong(value);
	    return this;
	  }

	  public MyBuffer putUnsignedInt(long value)
	  {
	    this.buffer.put(_toUnsignedInt(value));
	    return this;
	  }

	  public long getLong(int index)
	  {
	    return this.buffer.getLong(index);
	  }

	  public MyBuffer putLong(int index, long value)
	  {
	    this.buffer.putLong(index, value);
	    return this;
	  }

	  public MyBuffer putUnsignedInt(int index, long value)
	  {
	    byte[] arrayOfByte = _toUnsignedInt(value);
	    for (int i = 0; i < arrayOfByte.length; i++) {
	      this.buffer.put(index + i, arrayOfByte[i]);
	    }
	    return this;
	  }

	  public float getFloat()
	  {
	    return this.buffer.getFloat();
	  }

	  public MyBuffer putFloat(float value)
	  {
	    this.buffer.putFloat(value);
	    return this;
	  }

	  public float getFloat(int index)
	  {
	    return this.buffer.getFloat(index);
	  }

	  public MyBuffer putFloat(int index, float value)
	  {
	    this.buffer.putFloat(index, value);
	    return this;
	  }

	  public double getDouble()
	  {
	    return this.buffer.getDouble();
	  }

	  public MyBuffer putDouble(double value)
	  {
	    this.buffer.putDouble(value);
	    return this;
	  }

	  public double getDouble(int index)
	  {
	    return this.buffer.getDouble(index);
	  }

	  public MyBuffer putDouble(int index, double value)
	  {
	    this.buffer.putDouble(index, value);
	    return this;
	  }

	  public String getPrefixedString(int strLenType, MyCharset charset)
	  {
	    return bufferToPrefixedString(strLenType, charset);
	  }

	  public String getPrefixedString()
	  {
	    return getPrefixedString(1, DEFAULT_CHARSET);
	  }

	  public String getPrefixedString(int strLenType)
	  {
	    return getPrefixedString(strLenType, DEFAULT_CHARSET);
	  }

	  public String getPrefixedString(MyCharset charset)
	  {
	    return getPrefixedString(DEFAULT_STRING_TYPE, charset);
	  }

	  public MyBuffer putPrefixedString(String value, byte strLenType, MyCharset charset)
	  {
	    if ((strLenType != 1) && (strLenType != 2))
	    {
	      throw new IllegalArgumentException("prefixLength must be 1 or 2");
	    }

	    byte[] valueBytes = _stringToByteArray(value, charset);

	    if (valueBytes.length > STRING_LEN_MAX[strLenType])
	    {
	      throw new IllegalArgumentException("The specified string [" + value + "] is too long");
	    }

	    switch (strLenType)
	    {
	    case 1:
	      put((byte)valueBytes.length);

	      break;
	    case 2:
	      putShort((short)valueBytes.length);
	    }

	    return put(valueBytes);
	  }

	  public MyBuffer putPrefixedString(String value)
	  {
	    return putPrefixedString(value, DEFAULT_STRING_TYPE);
	  }

	  public MyBuffer putPrefixedString(String value, byte strLenType)
	  {
	    return putPrefixedString(value, strLenType, DEFAULT_CHARSET);
	  }

	  public MyBuffer putPrefixedString(String value, MyCharset charset)
	  {
	    return putPrefixedString(value, DEFAULT_STRING_TYPE, charset);
	  }

	  public String getHexDump()
	  {
	    return this.buffer.getHexDump();
	  }

	  public String getHexDump(int lengthLimit)
	  {
	    return this.buffer.getHexDump(lengthLimit);
	  }

	  public MyBuffer skip(int num)
	  {
	    this.buffer.skip(num);
	    return this;
	  }

	  private String bufferToPrefixedString(int strLenType, MyCharset charset)
	  {
	    if ((strLenType != 1) && (strLenType != 2)) {
	      throw new IllegalArgumentException("prefixLength must be 1 or 2");
	    }
	    int byteNum = strLenType == 1 ? getUnsigned() : getUnsignedShort();

	    return _byteArrayToString(getByteArray(byteNum), charset);
	  }

	  private String _byteArrayToString(byte[] content, MyCharset charset)
	  {
	    try
	    {
	      return new String(content, charset.charsetName());
	    }
	    catch (UnsupportedEncodingException e)
	    {
	      e.printStackTrace();
	    }

	    return "";
	  }

	  private byte[] _stringToByteArray(String value, MyCharset charset)
	  {
	    try
	    {
	      return value.getBytes(charset.charsetName());
	    }
	    catch (UnsupportedEncodingException e)
	    {
	      e.printStackTrace();
	    }
	    return new byte[0];
	  }

	  private byte _toUnsigned(short value)
	  {
	    return toHH(value, 1)[0];
	  }

	  private byte[] _toUnsignedShort(int value)
	  {
	    return toHH(value, 2);
	  }

	  private byte[] _toUnsignedInt(long value)
	  {
	    return toHH(value, 4);
	  }

	  public byte[] toHH(long value, int byteNum)
	  {
	    byte[] arrayOfByte = new byte[byteNum];
	    for (int i = byteNum - 1; i >= 0; i--) {
	      arrayOfByte[i] = ((byte)(int)(value >> (byteNum - i - 1) * 8 & 0xFF));
	    }
	    return arrayOfByte;
	  }

	  public static void main(String[] args)
	    throws Exception
	  {
	    String x = "测试";

	    byte[] temp = x.getBytes(MyCharset.GBK.charsetName());
	    IoBuffer tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("gbk:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_8.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-8:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_16.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-16:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_16BE.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-16BE:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_16LE.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-16LE:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_32.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-32:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_32BE.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-32BE:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.UTF_32LE.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("utf-32LE:" + temp.length + "  " + tempBuffer.getHexDump());

	    temp = x.getBytes(MyCharset.US_ASCII.charsetName());
	    tempBuffer = IoBuffer.wrap(temp);
	    System.out.println("us-ASCII:" + temp.length + "  " + tempBuffer.getHexDump());

	    MyBuffer buffer = allocate(1024);
	    buffer.putPrefixedString(x, (byte)2);

	    buffer.rewind();
	    String mm = buffer.getPrefixedString(2);

	    System.out.println(mm);
	  }
}
