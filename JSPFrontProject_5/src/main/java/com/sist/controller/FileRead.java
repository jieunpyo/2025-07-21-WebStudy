package com.sist.controller;
import java.util.*;
import java.io.*;
public class FileRead {
  public static void main(String[] args) {
	  packageClassLoader("C:\\webDev\\webStudy\\JSPFrontProject_5\\src\\main\\java", "com.sist.model");
  }
  static public List<String> packageClassLoader(String path,String pack){
       // com.sist.model
	   List<String> list=new ArrayList<String>();
       try
       {
    	   String strPack=pack.replace(".", File.separator);
    	   String strPath=path+File.separator+strPack;
    	   System.out.println(strPath);
    	   File dir=new File(strPath);
    	   File[] files=dir.listFiles();
    	   for(File file:files)
    	   {
    		   //System.out.println(file.getName());
    		   String name=file.getName();
    		   String ext=name.substring(name.lastIndexOf(".")+1);
    		   if(ext.equals("class"))
    		   {
    			   String cls=pack+"."+name;
    			   cls=cls.substring(0,cls.lastIndexOf("."));
    			   System.out.println(cls);
    			   list.add(cls);
    		   }
    	   }
       }catch(Exception ex){}
       return list;
  }
}