###自动装配
    1. @autowired 
        自动装配类型 支持@primary
    2. @qualified
        可以指定装配名称
    3. @primary 指定主要装配那个bean
    4. @resource 按照名称来装配 不能支持@primary @inject（需要导入依赖）  不能支持 required=false  (java 规范)
    
    后置处理器原理是beanpostProcessir   AutowiredAnnotationBeanPostProcessor
    atuowired: 可以标注在 构造器、方法上(set方法上)、属性上，都是从容器中获取组件的值
      1.标志在属性上
      2.标注在方法上
      3.标注在构造器上  如果只有一个构造器 那么就只会使用这个构造器来初始化方法，并且从容器中拿出相应的组件放在构造参数
  