package test;


import java.util.List;

import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.ICodec.ID;

import com.xuggle.xuggler.IContainerFormat;

public class GetSuppportedCodecs 
{ 
  /** 
   * Given the short name of a container, prints out information about 
   * it, including which codecs Xuggler can write (mux) into that container. 
   * @param args One string argument representing the short name of the format 
   */ 
  public static void main(String[] args) 
  { 
    if (args.length != 1) { 
      System.err.println("Usage: program_name container_short_name"); 
      return; 
    } 
    IContainerFormat format = IContainerFormat.make(); 
    format.setOutputFormat(args[0], null, null); 
    List<ID> codecs = format.getOutputCodecsSupported(); 
    System.out.println("Container Format: "+format); 
    System.out.println(); 
    System.out.println("Supported Codecs:"); 
    for(ID id : codecs) { 
      if (id != null) { 
        ICodec codec = ICodec.findEncodingCodec(id); 
        if (codec != null) { 
          System.out.println(codec); 
        } 
      } 
    } 
  } 
}
