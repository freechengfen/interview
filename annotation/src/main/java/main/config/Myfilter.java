package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/15-22:59

*/

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class Myfilter implements TypeFilter {


    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
//        System.out.println(classMetadata.getClassName());
        if(classMetadata.getClassName().contains("ller")){
            return true;
        }
        return false;
    }
}
