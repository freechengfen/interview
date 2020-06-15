package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/15-23:31

*/

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxConditionnal  implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        if(osName.contains("linux")){
                return true;
        }
        return false;
    }
}
