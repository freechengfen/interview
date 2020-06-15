package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/16-0:24

*/

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImport implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"main.entity.White"};
    }
}
